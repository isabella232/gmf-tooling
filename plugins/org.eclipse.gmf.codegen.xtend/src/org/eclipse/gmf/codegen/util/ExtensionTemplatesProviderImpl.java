package org.eclipse.gmf.codegen.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.FrameworkWiring;

public class ExtensionTemplatesProviderImpl implements IExtensionTemplatesProvider {

	public static String DEFAULT_DYNAMIC_TEMPLATES_FOLDER = "/aspects";

	public static String POINT_SEPARATOR = ".";

	public static String EMPLTY_STRING = "";

	public static String TEMPLATE_FILE_EXTENSIION = "xtend";

	private final String myCustomTemplatePath;

	private final IProject myProject;

	private List<Class<?>> myDinamicClasses;

	private List<Class<?>> myCustomClasses;

	private static final String SLASH = "/";

	private final Bundle myBundle;

	public ExtensionTemplatesProviderImpl(String customPath) {
		if (customPath.startsWith(SLASH)) {
			customPath = customPath.substring(1, customPath.length() - 1);
		}
		String[] parts = customPath.split(SLASH);
		myProject = ResourcesPlugin.getWorkspace().getRoot().getProject(parts[0]);
		myCustomTemplatePath = concatWithoutFirst(parts);
		ManifestUtil.createOrFillManifest(myProject);
		try {
			myBundle = loadBundle(myProject);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Cannot create correct URL for Bundle.", e);
		} catch (BundleException e) {
			throw new RuntimeException("Error. Bundle was not load.", e);
		}
	}

	private static Bundle loadBundle(IProject project) throws MalformedURLException, BundleException {
		String url = project.getLocation().toFile().toURI().toURL().toExternalForm();
		return CodegenXtendPlugin.getInstance().getContext().installBundle(url);
	}

	private static String concatWithoutFirst(String[] parts) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < parts.length; i++) {
			builder.append(SLASH).append(parts[i]);
		}
		return builder.toString();
	}

	@Override
	public List<Class<?>> getCustomTemplateClasses() {
		if (myCustomClasses == null) {
			myCustomClasses = new LinkedList<Class<?>>();
			myCustomClasses.addAll(loadCustomClasses(EMPLTY_STRING, false));
		}
		return myCustomClasses;
	}

	@Override
	public List<Class<?>> getDynamicTemplateClasses() {
		if (myDinamicClasses == null) {
			myDinamicClasses = new LinkedList<Class<?>>();
			myDinamicClasses.addAll(loadCustomClasses(DEFAULT_DYNAMIC_TEMPLATES_FOLDER, true));
		}
		return myDinamicClasses;
	}

	@Override
	public Class<?> getSuperClassForDynamic(Class<?> _class) {
		return _class.getSuperclass();
	}

	private List<Class<?>> loadCustomClasses(String pathSuffix, boolean aspectNotCustom) {
		return loadFolder(myProject.getFolder(myCustomTemplatePath + pathSuffix), aspectNotCustom ? "aspects" : "");
	}

	private List<Class<?>> loadFolder(IFolder parentFolder, String relativPath) {
		List<Class<?>> result = new LinkedList<Class<?>>();
		IFile[] files = null;
		IFolder[] folders = null;
		try {
			files = (IFile[]) getSubResources(parentFolder, true);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (files != null && files.length > 0) {
			for (IFile fileToLoad : files) {
				try {
					result.add(loadClass(fileToLoad, relativPath));
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("Error. Did not load " + fileToLoad.getName() + ". Class not found.", e);
				} catch (IOException e) {
					throw new RuntimeException("Error has occurred when try to load " + fileToLoad.getName(), e);
				}
			}
		}
		try {
			folders = (IFolder[]) getSubResources(parentFolder, false);
			if (folders != null && folders.length > 0) {
				for (IFolder folderToLoad : folders) {
					result.addAll(loadFolder(folderToLoad, createRelativPath(relativPath, folderToLoad.getName())));
				}
			}
		} catch (CoreException e) {
			throw new RuntimeException("Error.  Cannot load folder/package " + parentFolder.getName(), e);
		}
		return result;
	}

	private String createRelativPath(String relativePath, String child) {
		return relativePath.length() > 0 ? relativePath + "." + child : child;
	}

	private IResource[] getSubResources(IFolder parentFolder, boolean filesNotFolders) throws CoreException {
		List<IResource> result = new LinkedList<IResource>();
		for (IResource res : parentFolder.members()) {
			if (filesNotFolders) {
				if (res instanceof IFile) {
					IFile xtendFile = (IFile) res;
					if (TEMPLATE_FILE_EXTENSIION.equals(xtendFile.getFileExtension())) {
						result.add(xtendFile);
					}
				}
			} else {
				if (res instanceof IFolder) {
					result.add((IFolder) res);
				}
			}
		}
		if (result.size() > 0) {
			if (filesNotFolders) {
				return result.toArray(new IFile[result.size()]);
			}
			return result.toArray(new IFolder[result.size()]);
		}
		return null;
	}

	private Class<?> loadClass(IFile classFile, String relativePath) throws ClassNotFoundException, IOException {
		String className = createRelativPath(relativePath, classFile.getName().replace(POINT_SEPARATOR + TEMPLATE_FILE_EXTENSIION, EMPLTY_STRING));
		return myBundle.loadClass(className);
	}

	@Override
	public void dispose() {
		try {
			Bundle systemBundle = CodegenXtendPlugin.getInstance().getContext().getBundle(0);
			myBundle.uninstall();
			FrameworkWiring frameworkWiring = systemBundle.adapt(FrameworkWiring.class);
			frameworkWiring.refreshBundles(frameworkWiring.getRemovalPendingBundles());
		} catch (BundleException e) {
			throw new RuntimeException("Error while unloading bundle.", e);
		}
	}
}

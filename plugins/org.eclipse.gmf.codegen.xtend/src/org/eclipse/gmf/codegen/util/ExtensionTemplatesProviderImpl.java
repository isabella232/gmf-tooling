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
	
	private String myCustomTemplatePath;

	private List<Class<?>> myDinamicClasses = null;

	private List<Class<?>> myCustomClasses = null;

	private Bundle myBundle;
	
	public ExtensionTemplatesProviderImpl() {
		this(null);
	}
	
	public ExtensionTemplatesProviderImpl(String customPath) {
		if (customPath != null) {
			if (customPath.indexOf('/') == 0) {
				myCustomTemplatePath = customPath.substring(1, customPath.length() - 1);
			} else {
				myCustomTemplatePath = customPath;
			}
			init();
		}
	}

	private void init() {
		String projectName = getProjectName(myCustomTemplatePath);
		IProject currentProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		ManifestUtil.get().checkManifest(currentProject);
		String url;
		try {
			url = currentProject.getLocation().toFile().toURI().toURL().toExternalForm();
			myBundle = CodegenXtendPlugin.getInstance().getContext().installBundle(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (BundleException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean hasCustomTemplates() {
		return (null != myCustomTemplatePath) && (null != getCustomTemplateClasses());
	}

	@Override
	public boolean hasDynamicTemplates() {
		return  (null != myCustomTemplatePath) && (null != getDynamicTemplateClasses());
	}

	@Override
	public List<Class<?>> getCustomTemplateClasses() {
		if (myCustomClasses == null) {
			myCustomClasses = new LinkedList<Class<?>>();
			String projectName = getProjectName(myCustomTemplatePath);
			String templatesFolderPath = getCustomTemplateFolderPath(myCustomTemplatePath);
			myCustomClasses = loadCustomClasses(projectName, templatesFolderPath, false);
		}
		return myCustomClasses.size() > 0 ? myCustomClasses : null;
	}

	@Override
	public List<Class<?>> getDynamicTemplateClasses() {
		if (myDinamicClasses == null) {
			String projectName = getProjectName(myCustomTemplatePath);
			String aspectFolderPath = getAspectTemplateFolder(myCustomTemplatePath);
			myDinamicClasses = loadCustomClasses(projectName, aspectFolderPath, true);
		}
		return myDinamicClasses.size() > 0 ? myDinamicClasses : null;
	}

	@Override
	public Class<?> getSuperClassForDynamic(Class<?> _class) {
		return _class.getSuperclass();
	}

	private List<Class<?>> loadCustomClasses(String project, String folder, boolean aspectNotCustom) {
		List<Class<?>> result = new LinkedList<Class<?>>();
		IProject currentProject = ResourcesPlugin.getWorkspace().getRoot().getProject(project);
		IFolder rootFolder = currentProject.getFolder(folder);
		result = loadFolder(rootFolder, currentProject, aspectNotCustom ? "aspects" : "");
		return result;
	}

	private List<Class<?>> loadFolder(IFolder parentFolder, IProject currentProject, String relativPath) {
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
					result.add(loadClass(currentProject, fileToLoad, relativPath));
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		try {
			folders = (IFolder[]) getSubResources(parentFolder, false);
			if (folders != null && folders.length > 0) {
				for (IFolder folderToLoad : folders) {
					result.addAll(loadFolder(folderToLoad, currentProject, createRelativPath(relativPath, folderToLoad.getName())));
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
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

	private Class<?> loadClass(IProject proj, IFile classFile, String relativePath) throws ClassNotFoundException, IOException {
		Class<?> result = null;
		try {
			String className = createRelativPath(relativePath, classFile.getName().replace(POINT_SEPARATOR+TEMPLATE_FILE_EXTENSIION, EMPLTY_STRING));
			result = myBundle.loadClass(className);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return result;
	}

	private String getProjectName(String templateFolderPath) {
		String[] pathParts = templateFolderPath.split("/");
		return pathParts.length > 0 ? pathParts[0] : null;
	}

	private String getAspectTemplateFolder(String expression) {
		StringBuilder aspectFolderPath = new StringBuilder(getCustomTemplateFolderPath(expression));
		aspectFolderPath.append(DEFAULT_DYNAMIC_TEMPLATES_FOLDER);
		return aspectFolderPath.toString();
	}

	private String getCustomTemplateFolderPath(String expression) {
		StringBuilder templateFolderPath = new StringBuilder();
		String[] folders = expression.split("/");
		for (int i = 1; i < folders.length; i++) {
			templateFolderPath.append("/");
			templateFolderPath.append(folders[i]);
		}
		return templateFolderPath.toString();
	}

	@Override
	public void dispose() {
		try {
			Bundle systemBundle = CodegenXtendPlugin.getInstance().getContext().getBundle(0);
			myBundle.uninstall();
            FrameworkWiring frameworkWiring = systemBundle.adapt(FrameworkWiring.class);
            frameworkWiring.refreshBundles(frameworkWiring.getRemovalPendingBundles());
		} catch (BundleException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

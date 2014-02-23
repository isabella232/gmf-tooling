package org.eclipse.gmf.codegen.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.wiring.FrameworkWiring;

public class ExtensionTemplatesProviderImpl implements IExtensionTemplatesProvider {

	public static String DEFAULT_DYNAMIC_TEMPLATES_FOLDER = "/aspects";

	public static String POINT_SEPARATOR = ".";

	public static String EMPLTY_STRING = "";

	public static String TEMPLATE_FILE_EXTENSIION = "xtend";

	private final String myCustomTemplatePath;

	private List<Class<?>> myDinamicClasses;

	private List<Class<?>> myCustomClasses;

	private static final String SLASH = "/";

	private final Bundle myBundle;

	private final boolean myAspectsNeed;

	private final boolean myUsePluginNotProject;

	public ExtensionTemplatesProviderImpl(String customPath, boolean aspectsNeed) {
		myUsePluginNotProject = customPath.startsWith("platform:/plugin/");
		if (!myUsePluginNotProject) {
			if (customPath.startsWith(SLASH)) {
				customPath = customPath.substring(1, customPath.length() - 1);
			}
			String[] parts = customPath.split(SLASH);
			IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(parts[0]);
			myCustomTemplatePath = getTemplateEntryFromURL(customPath, 1);
			ManifestUtil.createOrFillManifest(project);
			try {
				myBundle = loadBundle(project);
			} catch (MalformedURLException e) {
				throw new RuntimeException("Cannot create correct URL for Bundle.", e);
			} catch (BundleException e) {
				throw new RuntimeException("Error. Bundle was not load.", e);
			}
		} else {
			myCustomTemplatePath = getTemplateEntryFromURL(customPath, 3);
			myBundle = Platform.getBundle(getBundleNameFromURL(customPath));
		}
		myAspectsNeed = aspectsNeed;
	}

	private static String getBundleNameFromURL(String url) {
		return url.split(SLASH)[2];
	}

	private static String getTemplateEntryFromURL(String url, int part) {
		StringBuilder result = new StringBuilder();
		String[] parts = url.split(SLASH);
		for (int i = part; i < parts.length; i++) {
			result.append(parts[i]).append(SLASH);
		}
		return result.toString();
	}

	private static Bundle loadBundle(IProject project) throws MalformedURLException, BundleException {
		String url = project.getLocation().toFile().toURI().toURL().toExternalForm();
		return CodegenXtendPlugin.getInstance().getContext().installBundle(url);
	}

	@Override
	public List<Class<?>> getCustomTemplateClasses() {
		if (myCustomClasses == null) {
			myCustomClasses = new LinkedList<Class<?>>();
			myCustomClasses.addAll(loadClassesFromBundle(false));
		}
		return myCustomClasses;
	}

	@Override
	public List<Class<?>> getDynamicTemplateClasses() {
		if (myDinamicClasses == null) {
			myDinamicClasses = new LinkedList<Class<?>>();
			if (myAspectsNeed) {
				myDinamicClasses.addAll(loadClassesFromBundle(true));
			}
		}
		return myDinamicClasses;
	}

	@Override
	public Class<?> getSuperClassForDynamic(Class<?> _class) {
		return _class.getSuperclass();
	}

	private Class<?> loadClass(String className) throws ClassNotFoundException, IOException {
		return myBundle.loadClass(className);
	}

	@Override
	public void dispose() {
		if (!myUsePluginNotProject) {
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

	private List<Class<?>> loadClassesFromBundle(boolean aspectNotCustom) {
		List<Class<?>> result = new LinkedList<Class<?>>();
		Enumeration<java.net.URL> classsesURL = myBundle.findEntries(myCustomTemplatePath, "*.xtend", true);
		while (classsesURL.hasMoreElements()) {
			String classPath = classsesURL.nextElement().toString().trim();
			classPath = classPath.substring(classPath.indexOf(myCustomTemplatePath), classPath.length()).replace(myCustomTemplatePath, EMPLTY_STRING).replace(POINT_SEPARATOR + TEMPLATE_FILE_EXTENSIION, EMPLTY_STRING);
			try {
				if (aspectNotCustom && classPath.startsWith("aspects")) {
					result.add(loadClass(getFQCN(classPath)));
				} else if (!aspectNotCustom && !classPath.startsWith("aspects")) {
					result.add(loadClass(getFQCN(classPath)));
				}
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Error. Did not load " + classPath + ". Class not found.", e);
			} catch (IOException e) {
				throw new RuntimeException("Error has occurred when try to load " + classPath, e);
			}
		}
		return result;
	}

	private String getFQCN(String entryPath) {
		return entryPath.replace(SLASH, POINT_SEPARATOR);
	}
}

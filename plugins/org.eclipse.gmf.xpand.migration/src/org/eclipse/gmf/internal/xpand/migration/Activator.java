package org.eclipse.gmf.internal.xpand.migration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.xpand.ResourceManager;
import org.eclipse.gmf.internal.xpand.RootManager;
import org.eclipse.gmf.internal.xpand.build.MetaModelSource;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.gmf.xpand.migration";

	// The shared instance
	private static Activator plugin;

	private final Set<MetaModelSource> modelSources = new LinkedHashSet<MetaModelSource>();

	/**
	 * The constructor
	 */
	public Activator() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ResourcesPlugin.getWorkspace().addResourceChangeListener(myRootsTracker);
	}

	public void stop(BundleContext context) throws Exception {
		ResourcesPlugin.getWorkspace().removeResourceChangeListener(myRootsTracker);
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static void logError(Exception e) {
		if (e instanceof CoreException) {
			log(((CoreException) e).getStatus());
		} else {
			log(new Status(IStatus.ERROR, getId(), 0, e.getMessage(), e));
		}
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void logWarn(String message) {
		log(new Status(IStatus.WARNING, getId(), 0, message, null));
	}

	private static String getId() {
		return getDefault().getBundle().getSymbolicName();
	}

	public static void registerModelSource(MetaModelSource modelSource) {
		assert modelSource != null;
		getDefault().modelSources.add(modelSource);
	}

	public static EPackage findMetaModel(String nsURI) {
		if (getDefault() == null) {
			// this is for tests execution (which doesn't take place in plugin
			// env)
			return null;
		}
		for (MetaModelSource s : getDefault().modelSources) {
			EPackage p = s.find(nsURI);
			if (p != null) {
				return p;
			}
		}
		return EPackage.Registry.INSTANCE.getEPackage(nsURI);

	}

	/* Root managers are necessary for legacy xpand builders only */
	private final Map<IProject, RootManager> rootManagers = new HashMap<IProject, RootManager>();

	public static ResourceManager getResourceManager(final IFile file) {
		// TODO: return a delegating resource manager to XpandEditor, to
		// silently change context when roots change.
		RootManager manager = getRootManager(file.getProject());
		ResourceManager result = manager.getResourceManager(file);
		assert result != null;
		return result;
	}

	public static RootManager getRootManager(IProject project) {
		synchronized (plugin.myRootsTracker) {
			RootManager result = plugin.rootManagers.get(project);
			if (result == null) {
				result = new RootManager(project);
				plugin.rootManagers.put(project, result);
			}
			return result;
		}
	}

	private final IResourceChangeListener myRootsTracker = new IResourceChangeListener() {

		public synchronized void resourceChanged(IResourceChangeEvent event) {
			if (event == null || event.getDelta() == null) {
				return;
			}
			Set<RootManager> affectedRootManagers = new HashSet<RootManager>();
			IResourceDelta rootDelta = event.getDelta();
			for (IResourceDelta projectDelta : rootDelta.getAffectedChildren()) {
				IProject affectedProject = (IProject) projectDelta.getResource();
				if (isRemovedOrClosed(projectDelta)) {
					rootManagers.remove(affectedProject);
				} else {
					IResourceDelta configFileDelta = projectDelta.findMember(RootManager.PROJECT_RELATIVE_PATH_TO_CONFIG_FILE);
					if (configFileDelta != null && rootManagers.containsKey(affectedProject) && affectsConfigFile(configFileDelta)) {
						affectedRootManagers.add(getRootManager(affectedProject));
					}
				}
			}
			// Opening/closing or creating/deleting a project may affect roots
			// with absolute paths.
			for (IResourceDelta projectDelta : rootDelta.getAffectedChildren()) {
				if (mayAffectOtherResourceManagers(projectDelta)) {
					IPath projectPath = projectDelta.getFullPath();
					for (RootManager nextManager : rootManagers.values()) {
						if (nextManager.containsProject(projectPath)) {
							affectedRootManagers.add(nextManager);
						}
					}
				}
			}
			for (RootManager nextManager : affectedRootManagers) {
				nextManager.rootsChanged();
			}
		}

		private boolean affectsConfigFile(IResourceDelta configFileDelta) {
			if ((configFileDelta.getKind() & (IResourceDelta.ADDED | IResourceDelta.REMOVED)) > 0) {
				return true;
			}
			if ((configFileDelta.getFlags() & (IResourceDelta.CONTENT | IResourceDelta.ENCODING | IResourceDelta.SYNC | IResourceDelta.TYPE | IResourceDelta.REPLACED)) > 0) {
				return true;
			}
			return false;
		}

		private boolean isRemovedOrClosed(IResourceDelta projectDelta) {
			if (projectDelta.getKind() == IResourceDelta.REMOVED) {
				return true;
			}
			if ((projectDelta.getFlags() & IResourceDelta.OPEN) > 0) {
				return !projectDelta.getResource().isAccessible();
			}
			return false;
		}

		private boolean mayAffectOtherResourceManagers(IResourceDelta projectDelta) {
			if ((projectDelta.getKind() & (IResourceDelta.REMOVED | IResourceDelta.ADDED)) > 0) {
				return true;
			}
			if ((projectDelta.getFlags() & IResourceDelta.OPEN) > 0) {
				return !projectDelta.getResource().isAccessible();
			}
			return false;
		}
	};

	private LegacyTemplateRootRegistry legacyTemplateRootRegistry;

	public LegacyTemplateRootRegistry getLegacyTemplateRootRegistry() {
		if (legacyTemplateRootRegistry == null) {
			legacyTemplateRootRegistry = new LegacyTemplateRootRegistry();
		}
		return legacyTemplateRootRegistry;
	}

}

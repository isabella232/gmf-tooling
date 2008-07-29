package org.eclipse.gmf.xpand.migration;

import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.internal.xpand.build.MetaModelSource;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.gmf.xtend.migration";

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
	}

	public void stop(BundleContext context) throws Exception {
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

}

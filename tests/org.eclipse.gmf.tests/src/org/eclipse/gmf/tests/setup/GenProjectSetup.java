/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.LinkedList;

import junit.framework.Assert;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.osgi.service.debug.DebugOptions;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Installs generated GMF plugins to allow invocation of generated code
 * @author artem
 */
public class GenProjectSetup extends GenProjectBaseSetup {

	private Bundle myBundle;
	private final boolean myIsFullRuntimeRun;

	public GenProjectSetup(GeneratorConfiguration generatorFactory) {
		super(generatorFactory);
		myIsFullRuntimeRun = generatorFactory instanceof RuntimeBasedGeneratorConfiguration;
	}

	/**
	 * Assertion fails on compilation errors.
	 * @return <code>this</code> for convenience
	 * @throws BundleException only when shouldInstallInRuntime is true and bundle install fails
	 */
	public GenProjectSetup init(DiaGenSource diaGenSource) throws BundleException {
		final boolean[] extensionChangeNotification = new boolean[] {true};
		final IRegistryChangeListener listener = new IRegistryChangeListener() {
			public void registryChanged(IRegistryChangeEvent event) {
				extensionChangeNotification[0] = false;
			}
		};
		try {
			if (myIsFullRuntimeRun) {
				RegistryFactory.getRegistry().addRegistryChangeListener(listener, "org.eclipse.gmf.runtime.emf.type.core");
			}
			myBundle = null;
			super.generateAndCompile(diaGenSource);
			myBundle.start();
			registerExtensions(myBundle);
			if (myIsFullRuntimeRun) {
				// there should be hit, any .diagram plugin is supposed to include element types
				monitorExtensionLoad(extensionChangeNotification, 60);
			}
			
			disabledNoExprImplDebugOption();
		} catch (BundleException ex) {
			throw ex;
		} catch (Exception ex) {
			Assert.fail(ex.getClass().getSimpleName() + ":" + ex.getMessage());
		} finally {
			if (myIsFullRuntimeRun) {
				RegistryFactory.getRegistry().removeRegistryChangeListener(listener);
			}
		}
		return this;
	}

	/**
	 * Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=136446
	 */
	private void monitorExtensionLoad(boolean[] flag, int timeoutSeconds) {
		if (null != Display.getCurrent()) {
			if (!Utils.dispatchDisplayMessages(flag, timeoutSeconds)) {
				// timeout
				Plugin.logError("Timeout while waiting for extension point registry to refresh !!!");
				// left caller on its own... 
			}
		}
	}

	protected void hookProjectBuild(IProject p) throws Exception {
		super.hookProjectBuild(p);
		try {
			String url = p.getLocation().toFile().toURL().toExternalForm();
			myBundle = Plugin.getBundleContext().installBundle(url);
		} catch (MalformedURLException ex) {
			Assert.fail(ex.getMessage());
		}
	}

	/**
	 * Manually registering all extensions from the generated (diagramming) plugin into eclipse registries
	 */ 
	private void registerExtensions(Bundle bundle) {
		IConfigurationElement[] configElements = getConfigurationElements(bundle.getSymbolicName(), "org.eclipse.emf.ecore.extension_parser");
		for (int i = 0; i < configElements.length; i++) {
			try {
				Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(configElements[i].getAttribute("type"), configElements[i].createExecutableExtension("class"));
			} catch (InvalidRegistryObjectException e) {
				Assert.fail(e.getMessage());
			} catch (CoreException e) {
				Assert.fail(e.getMessage());
			}
		}
	}

	private IConfigurationElement[] getConfigurationElements(String bundlID, String extensionPointID) {
		IConfigurationElement[] configs = Platform.getExtensionRegistry().getConfigurationElementsFor(extensionPointID);
		Collection<IConfigurationElement> ownConfigs = new LinkedList<IConfigurationElement>();
		for (int i = 0; i < configs.length; i++) {
			if (bundlID.equals(configs[i].getContributor().getName())) {
				ownConfigs.add(configs[i]);
			}
		}		
		return ownConfigs.toArray(new IConfigurationElement[ownConfigs.size()]);
	}

	public final Bundle getBundle() {
		assert myBundle != null : "GenProjectSetup was not initialized";
		return myBundle;
	}

	public void uninstall() throws Exception {
		// TODO: uninstall not only myBundle, but all the bundles installed in hookProjectBuild() method
		myBundle.uninstall();
	}
	
	private void disabledNoExprImplDebugOption() {
		String disabledNoExprImplDebugOpt = Platform.getDebugOption(Plugin.getInstance().getBundle().getSymbolicName() + "/disableNoExprImplExceptionLog");
		if(disabledNoExprImplDebugOpt != null) {
			ServiceTracker debugTracker = new ServiceTracker(Plugin.getBundleContext(), DebugOptions.class.getName(), null);
			debugTracker.open();
			DebugOptions debugOptions = (DebugOptions)debugTracker.getService();			
			if(debugOptions != null) {
				debugOptions.setOption(getBundle().getSymbolicName() + "/debug/disableNoExprImplExceptionLog", disabledNoExprImplDebugOpt);
			}
			debugTracker.close();				
		}		
	}
}

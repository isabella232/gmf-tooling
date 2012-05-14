/*
 * Copyright (c) 2005, 2010 Borland Software Corporation and others
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.StringTokenizer;

import junit.framework.Assert;

import org.eclipse.core.commands.contexts.Context;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IRegistryChangeEvent;
import org.eclipse.core.runtime.IRegistryChangeListener;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.plugin.RegistryReader.PluginClassDescriptor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.tests.JobTracker;
import org.eclipse.gmf.tests.Plugin;
import org.eclipse.gmf.tests.Utils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.contexts.IContextService;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;

/**
 * Installs generated GMF plugins to allow invocation of generated code
 * @author artem
 */
public class GenProjectSetup extends GenProjectBaseSetup {

	private ArrayList<Bundle> myAllInstalledBundes = new ArrayList<Bundle>();

	private Bundle myBundle;

	private final boolean myIsFullRuntimeRun;

	public GenProjectSetup(GeneratorConfiguration generatorFactory) {
		super(generatorFactory);
		myIsFullRuntimeRun = generatorFactory instanceof RuntimeBasedGeneratorConfiguration;
	}

	public GenProjectSetup init(DiaGenSource diaGenSource) throws BundleException {
		return init(diaGenSource.getGenDiagram().getEditorGen());
	}

	/**
	 * Assertion fails on compilation errors.
	 * @return <code>this</code> for convenience
	 * @throws BundleException only when shouldInstallInRuntime is true and bundle install fails
	 * FIXME introduce DiaGenSourceBase with single getDiagram() accessor
	 */
	public GenProjectSetup init(GenEditorGenerator genEditor) throws BundleException {
		final boolean[] extensionChangeNotification = new boolean[] { true };
		final IRegistryChangeListener listener = new IRegistryChangeListener() {

			public void registryChanged(IRegistryChangeEvent event) {
				extensionChangeNotification[0] = false;
			}
		};
		try {
			if (myIsFullRuntimeRun) {
				RegistryFactory.getRegistry().addRegistryChangeListener(listener, "org.eclipse.gmf.runtime.emf.type.core");
			} else {
				//Wait for org.eclipse.ui.editors extension point to update. Otherwise, AbstractDiagramEditorTest subclasses fail mysteriously.
				RegistryFactory.getRegistry().addRegistryChangeListener(listener, "org.eclipse.ui");
			}
			myBundle = null;
			JobTracker jt = new JobTracker();
			jt.start();
			generateAndCompile(genEditor);
			myBundle.start();
			jt.freeze();
			// System.out.println("Jobs to wait:" + jt.getJobsCount()); 13!
			registerExtensions(myBundle);
			registerEMFEditExtensions();
			registerContexts();
			// there should be hit, any .diagram plugin is supposed to register extensions we monitor with the listener above.
			monitorExtensionLoad(extensionChangeNotification, 60);
			monitorExtensionLoad(jt.getNonEmptyCondition(), 10);
			jt.stop();
		} catch (BundleException ex) {
			throw ex;
		} catch (Exception ex) {
			Assert.fail(ex.getClass().getSimpleName() + ":" + ex.getMessage());
		} finally {
			RegistryFactory.getRegistry().removeRegistryChangeListener(listener);
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
			myAllInstalledBundes.add(myBundle);
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

	private void registerContexts() {
		IContextService contextService = (IContextService) PlatformUI.getWorkbench().getService(IContextService.class);
		if (contextService == null) {
			return;
		}

		for (Bundle next : myAllInstalledBundes) {
			IConfigurationElement[] configElements = getConfigurationElements(next.getSymbolicName(), "org.eclipse.ui.contexts");
			for (int i = 0; i < configElements.length; i++) {
				IConfigurationElement element = configElements[i];
				if (element.getName().equals("context")) {
					String id = element.getAttribute("id");
					String description = element.getAttribute("description");
					String name = element.getAttribute("name");
					String parentId = element.getAttribute("parentId");
					if (id == null || description == null || name == null || parentId == null) {
						continue;
					}
					Context context = contextService.getContext(id);
					if (!context.isDefined()) {
						context.define(name, description, parentId);
					}
				}
			}
		}

	}

	private void registerEMFEditExtensions() {
		for (Bundle next : myAllInstalledBundes) {
			IConfigurationElement[] configElements = getConfigurationElements(next.getSymbolicName(), "org.eclipse.emf.edit.itemProviderAdapterFactories");
			for (int i = 0; i < configElements.length; i++) {
				IConfigurationElement element = configElements[i];
				if (element.getName().equals("factory")) {
					String packageURI = element.getAttribute("uri");
					String className = element.getAttribute("class");
					String supportedTypes = element.getAttribute("supportedTypes");
					if (packageURI == null) {
						continue;
					} else if (className == null) {
						continue;
					} else if (supportedTypes == null) {
						continue;
					}
					class PluginAdapterFactoryDescriptor extends PluginClassDescriptor implements ComposedAdapterFactory.Descriptor {

						public PluginAdapterFactoryDescriptor(IConfigurationElement element, String attributeName) {
							super(element, attributeName);
						}

						public AdapterFactory createAdapterFactory() {
							return (AdapterFactory) createInstance();
						}
					}

					for (StringTokenizer stringTokenizer = new StringTokenizer(supportedTypes); stringTokenizer.hasMoreTokens();) {
						String supportedType = stringTokenizer.nextToken();
						ArrayList<String> key = new ArrayList<String>(2);
						key.add(packageURI);
						key.add(supportedType);
						((ComposedAdapterFactory.Descriptor.Registry.Impl) ComposedAdapterFactory.Descriptor.Registry.INSTANCE).put(key, new PluginAdapterFactoryDescriptor(element, "class"));
					}

				}
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
		final JobTracker jt = new JobTracker();
		jt.start();
		for (Bundle next : myAllInstalledBundes) {
			next.uninstall();
		}
		jt.freeze();
		// need timeout for ExtensionRegistry to dispatch changes about removed extensions, e.g.
		// EditorManager#removeExtensions removes IEditorParts from EditorHistory, to prevent issues
		// like https://bugs.eclipse.org/bugs/show_bug.cgi?id=154767
		// ExtensionRegistry (namely EqunoxRegistryStrategy) does that either using jobs (ExtensionEventDispatcherJob) or 
		// in RegistryEventThread, hence all we need to do is give it a chance to complete
		Utils.assertDispatchDisplayMessages(jt.getNonEmptyCondition(), 10);
		jt.stop();
		//
		// Then UIExtensionTracker re-dispatches this notification to EditorManager in UI thread, hence need to let them 
		// reach EditorManager#removeExtensions method 
		Utils.assertDispatchDisplayMessages(3);
	}
}

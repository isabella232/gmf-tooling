package org.eclipse.gmf.examples.mindmap.diagram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.amalgam.examples.mindmap.provider.MindmapItemProviderAdapterFactory;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

public class MindmapDiagramEditorPlugin extends AbstractUIPlugin {

	public static final String ID = "org.eclipse.amalgam.examples.mindmap.diagram"; //$NON-NLS-1$

//	 public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new
//	 PreferencesHint(ID);

	private static MindmapDiagramEditorPlugin instance;

	private ComposedAdapterFactory adapterFactory;

	public MindmapDiagramEditorPlugin() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		instance = this;
		// PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT,
		// getPreferenceStore());
		adapterFactory = createAdapterFactory();
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		adapterFactory.dispose();
		adapterFactory = null;
		instance = null;
		super.stop(context);
	}

	public static MindmapDiagramEditorPlugin getInstance() {
		return instance;
	}

	protected ComposedAdapterFactory createAdapterFactory() {
		final List<AdapterFactoryImpl> factories = new ArrayList<AdapterFactoryImpl>();
		factories.add(new MindmapItemProviderAdapterFactory());
		factories.add(new ResourceItemProviderAdapterFactory());
		factories.add(new ReflectiveItemProviderAdapterFactory());
		return new ComposedAdapterFactory(factories);
	}

	public AdapterFactory getItemProvidersAdapterFactory() {
		return adapterFactory;
	}

	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);
	}

}

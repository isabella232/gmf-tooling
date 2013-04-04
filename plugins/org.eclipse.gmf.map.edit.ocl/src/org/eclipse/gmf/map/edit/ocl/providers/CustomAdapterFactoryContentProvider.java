package org.eclipse.gmf.map.edit.ocl.providers;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.ui.views.properties.IPropertySource;

public class CustomAdapterFactoryContentProvider extends AdapterFactoryContentProvider {

	public CustomAdapterFactoryContentProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
		return new CustomPropertySource(object, itemPropertySource);
	}
}

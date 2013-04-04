package org.eclipse.gmf.map.edit.ocl.providers;

import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.ui.provider.PropertySource;
import org.eclipse.ui.views.properties.IPropertyDescriptor;

public class CustomPropertySource extends PropertySource {

	public CustomPropertySource(Object object, IItemPropertySource itemPropertySource) {
		super(object, itemPropertySource);
	}
	
	@Override
	protected IPropertyDescriptor createPropertyDescriptor(IItemPropertyDescriptor itemPropertyDescriptor) {
		return new ConstraintPropertyDescriptor(object, itemPropertyDescriptor);		
	}

}

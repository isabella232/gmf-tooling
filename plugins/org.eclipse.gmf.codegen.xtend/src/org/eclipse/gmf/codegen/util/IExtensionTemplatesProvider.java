package org.eclipse.gmf.codegen.util;

import java.util.List;


public interface IExtensionTemplatesProvider {
	
	/**
	 * @return true if GenCustomTemplates consist template to invocation.
	 */
	public boolean hasCustomTemplates();
	
	/**
	 * @return true if folder /aspect is exist and not empty.
	 */
	public boolean hasDynamicTemplates();
	
	/**
	 * Get Classes for Custom Templates from Custom Generator Extension.
	 * 
	 */
	public List<Class<?>> getCustomTemplateClasses();
	
	/**
	 * Get Classes for Custom Templates from /aspect folder.
	 * 
	 */
	public List<Class<?>> getDynamicTemplateClasses();
	
	/**
	 * Get Class which _class override.
	 * 
	 * @return List<URL>
	 */
	public Class<?> getSuperClassForDynamic(Class<?> _class);
	
	public void dispose();
}
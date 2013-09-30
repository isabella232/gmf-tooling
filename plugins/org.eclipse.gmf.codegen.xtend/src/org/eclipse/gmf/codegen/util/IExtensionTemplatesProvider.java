package org.eclipse.gmf.codegen.util;

import java.util.List;


public interface IExtensionTemplatesProvider {
	
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
	
	/**
	 * Unload bundle from runtime. Necessarily to call this function
	 * 
	 */
	public void dispose();
}
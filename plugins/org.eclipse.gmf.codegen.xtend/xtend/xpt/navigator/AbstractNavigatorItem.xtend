/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.navigator

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import xpt.Common

class AbstractNavigatorItem {
	@Inject extension Common;

	def AbstractNavigatorItem(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName»;
		
		«generatedClassComment()»
		public abstract class «abstractNavigatorItemClassName» extends org.eclipse.core.runtime.PlatformObject {
			
			«IF null != editorGen.propertySheet»
				«registerAdapterFactory(it)»
			«ENDIF»
			
			«attributes(it)»
			
			«constructor(it)»
			
			«getParent(it)»
			
			«additions(it)»
		}
	'''

	def registerAdapterFactory(GenNavigator it) '''
		«generatedMemberComment()»
		static {
			final Class[] supportedTypes = new Class[] { org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class };
			final org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor propertySheetPageContributor = new org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor() {
				public String getContributorId() {
					return "«editorGen.plugin.ID»";  «nonNLS(1)»
				}
			};
			org.eclipse.core.runtime.Platform.getAdapterManager().registerAdapters(new org.eclipse.core.runtime.IAdapterFactory() {
				
				public Object getAdapter(Object adaptableObject, Class adapterType) {
					if (adaptableObject instanceof «getAbstractNavigatorItemQualifiedClassName()» && adapterType == org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor.class) {
						return propertySheetPageContributor;				
					}
					return null;
				}
		
				public Class[] getAdapterList() {
					return supportedTypes;
				}
			}, «getAbstractNavigatorItemQualifiedClassName()».class);
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private Object myParent;
	'''

	def constructor(GenNavigator it) '''
		«generatedMemberComment()»
		protected «abstractNavigatorItemClassName»(Object parent) {
			myParent = parent;
		}
	'''

	def getParent(GenNavigator it) '''
		«generatedMemberComment()»
		public Object getParent() {
			return myParent;
		}
	'''

	def additions(GenNavigator it) ''''''
}

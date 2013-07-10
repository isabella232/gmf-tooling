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

class DomainNavigatorItem {
	@Inject extension Common;

	@Inject AbstractNavigatorItem xptAbstractNavigatorItem;

	def DomainNavigatorItem(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName»;
		
		«generatedClassComment()»
		public class «domainNavigatorItemClassName» extends org.eclipse.core.runtime.PlatformObject {
		
			«registerAdapterFactory(it)»
			
			«xptAbstractNavigatorItem.attributes(it)»
			
			«attributes(it)»
			
			«constructor(it)»
			
			«xptAbstractNavigatorItem.getParent(it)»
			
			«getEObject(it)»
			
			«getPropertySourceProvider(it)»
			
			«equals(it)»
			
			«hashCode(it)»
		
			«additions(it)»
		}
	'''

	def registerAdapterFactory(GenNavigator it) '''
		«generatedMemberComment()»
		static {
			final Class[] supportedTypes = new Class[] { org.eclipse.emf.ecore.EObject.class, org.eclipse.ui.views.properties.IPropertySource.class };
			org.eclipse.core.runtime.Platform.getAdapterManager().registerAdapters(new org.eclipse.core.runtime.IAdapterFactory() {
				
				public Object getAdapter(Object adaptableObject, Class adapterType) {
					if (adaptableObject instanceof «getDomainNavigatorItemQualifiedClassName()») {
						«getDomainNavigatorItemQualifiedClassName()» domainNavigatorItem = («getDomainNavigatorItemQualifiedClassName()») adaptableObject;
						org.eclipse.emf.ecore.EObject eObject = domainNavigatorItem.getEObject();
						if (adapterType == org.eclipse.emf.ecore.EObject.class) {
							return eObject;
						}
						if (adapterType == org.eclipse.ui.views.properties.IPropertySource.class) {
							return domainNavigatorItem.getPropertySourceProvider().getPropertySource(eObject);
						}
					}
				
					return null;
				}
		
				public Class[] getAdapterList() {
					return supportedTypes;
				}
			}, «getDomainNavigatorItemQualifiedClassName()».class);
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private org.eclipse.emf.ecore.EObject myEObject;
		
		«generatedMemberComment()»
		private org.eclipse.ui.views.properties.IPropertySourceProvider myPropertySourceProvider;
	'''

	def constructor(GenNavigator it) '''
		«generatedMemberComment()»
		public «domainNavigatorItemClassName»(org.eclipse.emf.ecore.EObject eObject, Object parent, org.eclipse.ui.views.properties.IPropertySourceProvider propertySourceProvider) {
			myParent = parent;
			myEObject = eObject;
			myPropertySourceProvider = propertySourceProvider;
		}
	'''

	def getEObject(GenNavigator it) '''
		«generatedMemberComment()»
		public org.eclipse.emf.ecore.EObject getEObject() {
			return myEObject;
		}
	'''

	def getPropertySourceProvider(GenNavigator it) '''
		«generatedMemberComment()»
		public org.eclipse.ui.views.properties.IPropertySourceProvider getPropertySourceProvider() {
			return myPropertySourceProvider;
		}
	'''

	def equals(GenNavigator it) '''
		«generatedMemberComment()»
		public boolean equals(Object obj) {
			if (obj instanceof «getDomainNavigatorItemQualifiedClassName()») {
				return org.eclipse.emf.ecore.util.EcoreUtil.getURI(getEObject()).equals(org.eclipse.emf.ecore.util.EcoreUtil.getURI(((«getDomainNavigatorItemQualifiedClassName()») obj).getEObject()));
			}
			return super.equals(obj);
		}
	'''

	def hashCode(GenNavigator it) '''
		«generatedMemberComment()»
		public int hashCode() {
			return org.eclipse.emf.ecore.util.EcoreUtil.getURI(getEObject()).hashCode();
		}
	'''

	def additions(GenNavigator it) ''''''

}

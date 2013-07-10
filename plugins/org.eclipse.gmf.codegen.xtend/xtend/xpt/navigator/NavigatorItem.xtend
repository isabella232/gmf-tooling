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

class NavigatorItem {
	@Inject extension Common;

	def extendsList(GenNavigator it) '''extends «it.abstractNavigatorItemQualifiedClassName»'''

	def NavigatorItem(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName»;
		
			«generatedClassComment()»
		public class «navigatorItemClassName» «extendsList(it)» {
			
			«registerAdapterFactory(it)»
			
			«attributes(it)»
			
			«constructor(it)»
			
			«getView(it)»
			
			«isLeaf(it)»
			
			«equals(it)»
			
			«hashCode(it)»
			
			«additions(it)»
		}
	'''

	def registerAdapterFactory(GenNavigator it) '''
		«generatedMemberComment()»
		static {
			final Class[] supportedTypes = new Class[] { org.eclipse.gmf.runtime.notation.View.class, org.eclipse.emf.ecore.EObject.class };
			org.eclipse.core.runtime.Platform.getAdapterManager().registerAdapters(new org.eclipse.core.runtime.IAdapterFactory() {
				
				public Object getAdapter(Object adaptableObject, Class adapterType) {
					if (adaptableObject instanceof «getNavigatorItemQualifiedClassName()» && (adapterType == org.eclipse.gmf.runtime.notation.View.class || adapterType == org.eclipse.emf.ecore.EObject.class)) {
						return ((«getNavigatorItemQualifiedClassName()») adaptableObject).getView();
					}
					return null;
				}
		
				public Class[] getAdapterList() {
					return supportedTypes;
				}
			}, «getNavigatorItemQualifiedClassName()».class);
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private org.eclipse.gmf.runtime.notation.View myView;
			
		«generatedMemberComment()»
		private boolean myLeaf = false;	
	'''

	def constructor(GenNavigator it) '''
		«generatedMemberComment()»
		public «navigatorItemClassName»(org.eclipse.gmf.runtime.notation.View view, Object parent, boolean isLeaf) {
			super(parent);
			myView = view;
			myLeaf = isLeaf;
		}
	'''

	def getView(GenNavigator it) '''
		«generatedMemberComment()»
		public org.eclipse.gmf.runtime.notation.View getView() {
			return myView;
		}
	'''

	def isLeaf(GenNavigator it) '''
		«generatedMemberComment()»
		public boolean isLeaf() {
			return myLeaf;
		}
	'''

	def equals(GenNavigator it) '''
		«generatedMemberComment()»
		public boolean equals(Object obj) {
			if (obj instanceof «getNavigatorItemQualifiedClassName()») {
				return org.eclipse.emf.ecore.util.EcoreUtil.getURI(getView()).equals(org.eclipse.emf.ecore.util.EcoreUtil.getURI(((«getNavigatorItemQualifiedClassName()») obj).getView()));
			}
			return super.equals(obj);
		}
	'''

	def hashCode(GenNavigator it) '''
		«generatedMemberComment()»
		public int hashCode() {
			return org.eclipse.emf.ecore.util.EcoreUtil.getURI(getView()).hashCode();
		}
	'''

	def additions(GenNavigator it) ''''''

}

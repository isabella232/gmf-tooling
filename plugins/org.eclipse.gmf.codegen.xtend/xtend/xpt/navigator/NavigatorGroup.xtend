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

class NavigatorGroup {
	@Inject extension Common;

	def className(GenNavigator it) '''«it.navigatorGroupClassName»'''

	def packageName(GenNavigator it) '''«it.packageName»'''

	def qualifiedClassName(GenNavigator it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenNavigator it) '''«qualifiedClassName(it)»'''

	def extendsList(GenNavigator it) '''extends «getAbstractNavigatorItemQualifiedClassName()»'''

	def NavigatorGroup(GenNavigator it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment()»
		public class «className(it)» «extendsList(it)» {
		
			«attributes(it)»
		
			«constructor(it)»
			
			«getGroupName(it)»
			
			«getIcon(it)»
			
			«getChildren(it)»
			
			«addChildren(it)»
			
			«addChild(it)»
			
			«isEmpty(it)»
			
			«equals(it)»
			
			«hashCode(it)»
		
			«additions(it)»
		}
	'''

	def attributes(GenNavigator it) '''
		«generatedMemberComment()»
		private String myGroupName;
			
		«generatedMemberComment()»
		private String myIcon;
			
		«generatedMemberComment()»
		private java.util.Collection myChildren = new java.util.LinkedList();
	'''

	def constructor(GenNavigator it) '''
		«generatedMemberComment()»
		«className(it)»(String groupName, String icon, Object parent) {
			super(parent);
			myGroupName = groupName;
			myIcon = icon;
		}
	'''

	def getGroupName(GenNavigator it) '''
			«generatedMemberComment()»
		public String getGroupName() {
			return myGroupName;
		}
	'''

	def getIcon(GenNavigator it) '''
		«generatedMemberComment()»
		public String getIcon() {
			return myIcon;
		}
	'''

	def getChildren(GenNavigator it) '''
		«generatedMemberComment()»
		public Object[] getChildren() {
			return myChildren.toArray();
		}
	'''

	def addChildren(GenNavigator it) '''
		«generatedMemberComment()»
		public void addChildren(java.util.Collection children) {
			myChildren.addAll(children);
		}
	'''

	def addChild(GenNavigator it) '''
		«generatedMemberComment()»
		public void addChild(Object child) {
			myChildren.add(child);
		}
	'''

	def isEmpty(GenNavigator it) '''
		«generatedMemberComment()»
		public boolean isEmpty() {
			return myChildren.size() == 0;
		}
	'''

	def equals(GenNavigator it) '''
		«generatedMemberComment()»
		public boolean equals(Object obj) {
			if (obj instanceof «qualifiedClassName(it)») {
				«qualifiedClassName(it)» anotherGroup = («qualifiedClassName(it)») obj;
				if (getGroupName().equals(anotherGroup.getGroupName())) {
					return getParent().equals(anotherGroup.getParent());
				}
			}
			return super.equals(obj);
		}
	'''

	def hashCode(GenNavigator it) '''
		«generatedMemberComment()»
		public int hashCode() {
			return getGroupName().hashCode();
		}
	'''

	def additions(GenNavigator it) ''''''

}

/**
 * Copyright (c) 2007, 2009 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.propsheet

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenPropertySheet
import xpt.Common
import xpt.navigator.NavigatorGroup
import xpt.QualifiedClassNameProvider
import xpt.editor.VisualIDRegistry

class LabelProvider {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;

	@Inject NavigatorGroup group;
	@Inject VisualIDRegistry visualId;

	def className(GenPropertySheet it) '''«it.labelProviderClassName»'''

	def packageName(GenPropertySheet it) '''«it.packageName»'''

	def qualifiedClassName(GenPropertySheet it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenPropertySheet it) '''«qualifiedClassName(it)»'''

	def extendsList(GenPropertySheet it) '''extends org.eclipse.jface.viewers.BaseLabelProvider'''

	def implementsList(GenPropertySheet it) '''implements org.eclipse.jface.viewers.ILabelProvider'''

	def LabelProvider(GenPropertySheet it) '''
		«copyright(editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsList(it)» {
		
			«getTextMethod(it)»
			«getImageMethod(it)»
			«unwrapMethods(it)»
		
			«additions(it)»
		}
	'''

	def getTextMethod(GenPropertySheet it) '''
		«generatedMemberComment»
		public String getText(Object element) {
			element = unwrap(element);
			«IF editorGen.navigator != null»
				if (element instanceof «group.qualifiedClassName(editorGen.navigator)») {
					return ((«group.qualifiedClassName(editorGen.navigator)») element).getGroupName();
				}
			«ENDIF»
			org.eclipse.gmf.runtime.emf.type.core.IElementType etype = getElementType(getView(element));
			return etype == null ? "" : etype.getDisplayName();
		}
	'''

	def getImageMethod(GenPropertySheet it) '''
		«generatedMemberComment»
		public org.eclipse.swt.graphics.Image getImage(Object element) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType etype = getElementType(getView(unwrap(element)));
			return etype == null ? null : «getElementTypesQualifiedClassName(editorGen.diagram)».getImage(etype);
		}
	'''

	def unwrapMethods(GenPropertySheet it) '''
		«generatedMemberComment»
		private Object unwrap(Object element) {
		if (element instanceof org.eclipse.jface.viewers.IStructuredSelection) {
		return ((org.eclipse.jface.viewers.IStructuredSelection) element).getFirstElement();
		}
		return element;
		}
		
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.notation.View getView(Object element) {
			if (element instanceof org.eclipse.gmf.runtime.notation.View) {
				return (org.eclipse.gmf.runtime.notation.View) element;
			}
			if (element instanceof org.eclipse.core.runtime.IAdaptable) {
				return (org.eclipse.gmf.runtime.notation.View)
						((org.eclipse.core.runtime.IAdaptable) element).getAdapter(org.eclipse.gmf.runtime.notation.View.class);
			}
			return null;
		}
		
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.emf.type.core.IElementType getElementType(org.eclipse.gmf.runtime.notation.View view) {
			// For intermediate views climb up the containment hierarchy to find the one associated with an element type.
			while (view != null) {
				int vid = «visualId.qualifiedClassName(editorGen.diagram)».getVisualID(view);
				org.eclipse.gmf.runtime.emf.type.core.IElementType etype =
						«getElementTypesQualifiedClassName(editorGen.diagram)».getElementType(vid);
				if (etype != null) {
					return etype;
				}
				view = view.eContainer() instanceof org.eclipse.gmf.runtime.notation.View ?
						(org.eclipse.gmf.runtime.notation.View) view.eContainer() : null;
			}
			return null;
		}
	'''

	def additions(GenPropertySheet it) ''''''

}

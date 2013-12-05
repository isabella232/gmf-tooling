/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - [407242] - common code extracted to gmft.runtime, 
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.propsheet

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenCustomPropertyTab
import xpt.CodeStyle
import xpt.Common

@com.google.inject.Singleton class PropertySection {
	@Inject extension Common;

	@Inject CodeStyle xptCodeStyle;

	def className(GenCustomPropertyTab it) '''«it.className»'''

	def packageName(GenCustomPropertyTab it) '''«it.sheet.packageName»'''

	def qualifiedClassName(GenCustomPropertyTab it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenCustomPropertyTab it) '''«qualifiedClassName(it)»'''

	def PropertySection(GenCustomPropertyTab it) '''
		«copyright(sheet.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» «extendsList(it)» «implementsClause(it)» {
		
			«IF sheet.readOnly»
				«createReadonlyControlsMethod(it)»
			«ENDIF»
			«transfromSelectionMethod(it)»
		
			«additions(it)»
		}
	'''

	def extendsList(GenCustomPropertyTab it) '''extends org.eclipse.gmf.tooling.runtime.sheet.DefaultPropertySection'''

	def implementsClause(GenCustomPropertyTab it) '''implements org.eclipse.ui.views.properties.IPropertySourceProvider'''

	def createReadonlyControlsMethod(GenCustomPropertyTab it) '''
		«generatedMemberComment»
		public void createControls(org.eclipse.swt.widgets.Composite parent, org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage aTabbedPropertySheetPage) {
			super.createControls(parent, aTabbedPropertySheetPage);
			forcePageReadOnly();
		}
	'''

	def transfromSelectionMethod(GenCustomPropertyTab it) '''
		«IF 'domain' == ID/*perhaps, override setInput should obey same condition?*/»
			«generatedMemberComment('Modify/unwrap selection.')»
			«xptCodeStyle.overrideC(it.sheet.editorGen.diagram)»
			protected Object transformSelection(Object selected) {
				«transfromSelectionMethodBodyDefault(it)»
				return selected;
			}
		«ENDIF»
	'''

	def transfromSelectionMethodBodyDefault(GenCustomPropertyTab it) '''
		selected = /*super.*/transformSelectionToDomain(selected);
	'''

	/**
	 * DEFINE's below are not supported anymore (code moved to superclass in 3.1). 
	 * If your xpt version have them, call it from custom version of additions
	 * <p>
	 * def dispatch getPropertySourceMethod(GenCustomPropertyTab it) '''''' 
	 * def dispatch getPropertySourceProviderMethod(GenCustomPropertyTab it) ''''''
	 * def dispatch setInputMethod(GenCustomPropertyTab it) ''''''
	 * def dispatch getAdapterFactoryMethod(GenCustomPropertyTab it) ''''''
	 */
	def additions(GenCustomPropertyTab it) ''''''
}

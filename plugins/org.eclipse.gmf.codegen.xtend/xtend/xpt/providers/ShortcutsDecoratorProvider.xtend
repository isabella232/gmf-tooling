/**
 * Copyright (c) 2006, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import xpt.Common
import xpt.editor.VisualIDRegistry

class ShortcutsDecoratorProvider {

	@Inject extension Common;

	@Inject VisualIDRegistry xptVisualIDRegistry;

	def extendsList(GenDiagram it) '''extends org.eclipse.gmf.runtime.common.core.service.AbstractProvider'''

	def implementsList(GenDiagram it) '''implements org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorProvider'''

	def ShortcutsDecoratorProvider(GenDiagram it) '''
		«copyright(editorGen)»
		package «providersPackageName»;
		
		«generatedClassComment»
		public class «shortcutsDecoratorProviderClassName» «extendsList(it)» «implementsList(it)» {
			
			«attributes(it)»
			
			«provides(it)»
			
			«createDecorators(it)»
			
			«ShortcutsDecorator(it)»
			
			«additions(it)»
		}
	'''

	def attributes(GenDiagram it) '''
		«generatedMemberComment»
		public static final String SHORTCUTS_DECORATOR_ID = "shortcuts"; «nonNLS(1)»
	'''

	def provides(GenDiagram it) '''
		«generatedMemberComment»
		public boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
			if (!(operation instanceof org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation)) {
				return false;
			}
			org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget decoratorTarget = ((org.eclipse.gmf.runtime.diagram.ui.services.decorator.CreateDecoratorsOperation) operation).getDecoratorTarget();
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) decoratorTarget.getAdapter(org.eclipse.gmf.runtime.notation.View.class);
			return view != null && «VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»(view));
		}
	'''

	def createDecorators(GenDiagram it) '''
		«generatedMemberComment»
		public void createDecorators(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget decoratorTarget) {
			org.eclipse.gmf.runtime.notation.View view = (org.eclipse.gmf.runtime.notation.View) decoratorTarget.getAdapter(org.eclipse.gmf.runtime.notation.View.class);
			if (view != null) {
				org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut"); «nonNLS(1)»
				if (annotation != null) {
					decoratorTarget.installDecorator(SHORTCUTS_DECORATOR_ID, new ShortcutsDecorator(decoratorTarget));
				}
			}
		}
	'''

	def ShortcutsDecorator(GenDiagram it) '''
		«generatedClassComment»
		protected class ShortcutsDecorator «SD_extendsList(it)» {
			«SD_constructor(it)»
			
			«SD_activate(it)»
			
			«SD_refresh(it)»
			
			«SD_additions(it)»
		}
	'''

	def SD_extendsList(GenDiagram it) '''extends org.eclipse.gmf.runtime.diagram.ui.services.decorator.AbstractDecorator'''

	def SD_constructor(GenDiagram it) '''
		«generatedMemberComment»
		public ShortcutsDecorator(org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget decoratorTarget) {
			super(decoratorTarget);
		}
	'''

	def SD_activate(GenDiagram it) '''
		«generatedMemberComment»
		public void activate() {
			refresh();
		}
	'''

	def SD_refresh(GenDiagram it) '''
		«generatedMemberComment»
		public void refresh() {
			removeDecoration();
			org.eclipse.gef.EditPart editPart = (org.eclipse.gef.EditPart) getDecoratorTarget().getAdapter(org.eclipse.gef.EditPart.class);
			org.eclipse.swt.graphics.Image image = «editorGen.plugin.activatorQualifiedClassName».getInstance().getBundledImage("icons/shortcut.gif"); «nonNLS(1)»
			if (editPart instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeEditPart) {
				setDecoration(getDecoratorTarget().addShapeDecoration(image, org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction.SOUTH_WEST, 0, false));
			} else if (editPart instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) {
				setDecoration(getDecoratorTarget().addConnectionDecoration(image, 50, false));
			}
		}
	'''

	def SD_additions(GenDiagram it) ''''''

	def additions(GenDiagram it) ''''''
}

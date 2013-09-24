/**
 * Copyright (c) 2006-2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.diagram.editparts

import com.google.inject.Inject
import impl.diagram.editparts.viewmaps.modeledViewmapProducer
import impl.parsers.expression_qvto
import org.eclipse.gmf.codegen.gmfgen.DesignLabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.Viewmap
import parsers.ParserProvider
import xpt.CodeStyle
import xpt.Common
import xpt.diagram.ViewmapAttributesUtils_qvto
import xpt.QualifiedClassNameProvider

class TextAware {
	@Inject extension Common
	@Inject extension CodeStyle
	@Inject extension ViewmapAttributesUtils_qvto
	@Inject extension ChoiceUtils_qvto
	@Inject extension RuntimeLabelsSupport_qvto
	@Inject extension expression_qvto
	@Inject extension QualifiedClassNameProvider;

	@Inject modeledViewmapProducer xptModeledViewmapProducer;
	@Inject ParserProvider xptParserProvider;

	def fields(GenCommonBase it) '''
		«generatedMemberComment(it)»
		private org.eclipse.gef.tools.DirectEditManager manager;
		
		«generatedMemberComment(it)»
		private org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser;
		
		«IF isOclChoiceLabel(it) || isViewExpressionDefinedAndOcl(it)»
			«generatedMemberComment(it)»
			private org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker.Registrator myOclRegistrator;
		«ELSE»
			«generatedMemberComment(it)»
			private java.util.List<?> parserElements;
		«ENDIF»
		
		«generatedMemberComment(it)»
		private String defaultText;	
		
		«generatedMemberComment(it)»
		private org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate labelDelegate;
	'''

	def methods(GenCommonBase it, boolean needsRefreshBounds, boolean readOnly, boolean useElementIcon, Viewmap viewmap,
		LabelModelFacet modelFacet, GenCommonBase host, GenDiagram diagram) '''
	«getLabelTextHelper(it)»
	
	«setLabelTextHelper(it)»
	
	«getLabelIconHelper(it)»
	
	«setLabelIconHelper(it)»
	
	«labelSetter(it)»
	
	«getModelChildren(it)»
	
	«getChildBySemanticHint(it)»
	
	«getParserElement(it, modelFacet)»
	
	«getLabelIcon(it, useElementIcon, diagram)»
	
	«getLabelText(it)»
	
	«setLabelText(it, diagram)»
	
	«getEditText(it)»
	
	«isEditable(it, readOnly)»
	
	«getEditTextValidator(it)»
	
	«getCompletionProcessor(it)»
	
	«getParserOptions(it)»
	
	«getParser(it, modelFacet, diagram, host)»
	
	«getManager(it, diagram, modelFacet)»
	
	«setManager(it)»
	
	«performDirectEdit(it)»
	
	«performDirectEditAtPoint(it, modelFacet)»

«IF !(isChoiceLabel(modelFacet))»
	«performDirectEditWithInitialChar(it)»
«ENDIF»	
	
	«performDirectEditRequest(it, modelFacet)»
	
	«refreshVisuals(it, needsRefreshBounds)»
	
	«refreshLabel(it, diagram)»
	
	«refreshUnderline(it)»
	
	«refreshStrikeThrough(it)»
	
	«refreshFont(it)»
	
	«refreshSelectionFeedback(it)»
	
	«setFontColor(it)»
	
	«addSemanticListeners(it)»
	
	«removeSemanticListeners(it)»
	
	«getAccessibleEditPart(it)»
	
	«getFontStyleOwnerView(it, viewmap)»
		
«IF isOclChoiceLabelWithShowExpr(it) || isViewExpressionDefinedAndOcl(it)»
	«getOclTracker(it)»
«ENDIF»
	
«IF isOclChoiceLabel(it) || isViewExpressionDefinedAndOcl(it)»
	«getOclRegistrator(it)»
«ENDIF»

  «getLabelDelegate(it)»
    
  «getAdapter(it)»
'''

	def dispatch labelSetterName(ParentAssignedViewmap it) '''«IF setterName != null»«setterName»«ELSE»setLabel«ENDIF»'''

	def dispatch labelSetterName(Viewmap it) '''setLabel'''

	def dispatch labelSetterName(ModeledViewmap it) '''setLabel'''

	def getLabelTextHelper(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected String getLabelTextHelper(org.eclipse.draw2d.IFigure figure) {
			if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
				return ((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).getText();
			} «IF isVerticalLabel(it)» else if (figure instanceof «getVerticalLabelFQN()») {
					return ((«getVerticalLabelFQN()») figure).getText();
			} «ENDIF» else if (figure instanceof org.eclipse.draw2d.Label) {
				return ((org.eclipse.draw2d.Label) figure).getText();
			} else {
				return getLabelDelegate().getText();
			} 
		}
	'''

	def setLabelTextHelper(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void setLabelTextHelper(org.eclipse.draw2d.IFigure figure, String text) {
			if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
				((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).setText(text);
			} «IF isVerticalLabel(it)» else if (figure instanceof «getVerticalLabelFQN()») {
					((«getVerticalLabelFQN()») figure).setText(text);
			} «ENDIF» else if (figure instanceof org.eclipse.draw2d.Label) {
				((org.eclipse.draw2d.Label) figure).setText(text);
			} else {
				getLabelDelegate().setText(text);
			}
		}
	'''

	def getLabelIconHelper(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected org.eclipse.swt.graphics.Image getLabelIconHelper(org.eclipse.draw2d.IFigure figure) {
			if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
				return ((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).getIcon();
			} «IF isVerticalLabel(it)» else if (figure instanceof «getVerticalLabelFQN()») {
					//icons are not supported for verical labels now
					return null;
			} «ENDIF» else if (figure instanceof org.eclipse.draw2d.Label) {
				return ((org.eclipse.draw2d.Label) figure).getIcon();
			} else {
				return getLabelDelegate().getIcon(0);
			}
		}
	'''

	def setLabelIconHelper(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void setLabelIconHelper(org.eclipse.draw2d.IFigure figure, org.eclipse.swt.graphics.Image icon) {
			if (figure instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
				((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) figure).setIcon(icon);
				return;
			} «IF isVerticalLabel(it)» else if (figure instanceof «getVerticalLabelFQN()») {
					//icons are not supported for verical labels now, nothing to do
					return;
			} «ENDIF» else if (figure instanceof org.eclipse.draw2d.Label) {
				((org.eclipse.draw2d.Label) figure).setIcon(icon);
				return;
			} else {
				getLabelDelegate().setIcon(icon, 0);
			}
		}
	'''

	def getLabelDelegate(GenCommonBase it) '''
		«generatedMemberComment(it)»
		private org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate getLabelDelegate(){
			if (labelDelegate == null){
				org.eclipse.draw2d.IFigure label = getFigure();
				if (label instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel){
					labelDelegate = new org.eclipse.gmf.runtime.diagram.ui.label.WrappingLabelDelegate((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel)label);
				} «IF isVerticalLabel(it)» else if (label instanceof «getVerticalLabelFQN()») {
						labelDelegate = new «getVerticalLabelDelegateFQN()»((«getVerticalLabelFQN()»)label); 
				} «ENDIF» else {
					labelDelegate = new «getSimpleLabelDelegateFQN()»((org.eclipse.draw2d.Label)label);
				}
			}
			return labelDelegate;
		}
	'''

	def getAdapter(GenCommonBase it) '''
		«generatedMemberComment(it)»
		«overrideC(it)»
		public Object getAdapter(Class key) {
			if (org.eclipse.gmf.runtime.diagram.ui.label.ILabelDelegate.class.equals(key)){
				return getLabelDelegate();
			}
			return super.getAdapter(key);
		}
	'''

	def labelSetter(GenCommonBase it) '''
		«generatedMemberComment(it)»
		public void «labelSetterName(viewmap)»(«labelSetterFigureClassName(viewmap)» figure) {
			unregisterVisuals();
			setFigure(figure);
			defaultText = getLabelTextHelper(figure);
			registerVisuals();
			refreshVisuals();
		}
	'''

	def dispatch labelSetterFigureClassName(ParentAssignedViewmap it) //
	'''
		«IF figureQualifiedClassName != null»«figureQualifiedClassName»«ELSE»org.eclipse.draw2d.IFigure«ENDIF»
	'''

	def dispatch labelSetterFigureClassName(ModeledViewmap it) '''
«xptModeledViewmapProducer.viewmapFigureFQN(it)»
'''

	def dispatch labelSetterFigureClassName(Viewmap it) '''
		org.eclipse.draw2d.IFigure
	'''

	def getModelChildren(GenCommonBase it) '''
		«generatedMemberComment(it)»
		«SuppressWarnings('"rawtypes"')»
		protected java.util.List getModelChildren() {
			return java.util.Collections.EMPTY_LIST;
		}
	'''

	def getChildBySemanticHint(GenCommonBase it) '''
		«generatedMemberComment(it)»
		public org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart getChildBySemanticHint(String semanticHint) {
			return null;
		}
	'''

	def getParserElement(GenCommonBase it, LabelModelFacet modelFacet) '''
		«generatedMemberComment(it)»
		protected org.eclipse.emf.ecore.EObject getParserElement() {
			«IF modelFacet == null»
				org.eclipse.emf.ecore.EObject element = resolveSemanticElement();
				return element != null ? element : (org.eclipse.gmf.runtime.notation.View) getModel();
			«ELSE»
				«dispatch_getParserElement(modelFacet)»
			«ENDIF»
		}
	'''

	def dispatch dispatch_getParserElement(LabelModelFacet it) '''
		return resolveSemanticElement();
	'''

	def dispatch dispatch_getParserElement(DesignLabelModelFacet it) '''
		return (org.eclipse.gmf.runtime.notation.View) getModel();
	'''

	def getLabelIcon(GenCommonBase it, boolean useElementIcon, GenDiagram diagram) '''
		«generatedMemberComment(it)»
		protected org.eclipse.swt.graphics.Image getLabelIcon() {
			«IF useElementIcon»
				org.eclipse.emf.ecore.EObject parserElement = getParserElement();
				if (parserElement == null) {
					return null;
				}
				return «getElementTypesQualifiedClassName(diagram)».getImage(parserElement.eClass());
			«ELSE»
				return null;
			«ENDIF»
		}
	'''

	def getLabelText(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected String getLabelText() {
			String text = null;
			org.eclipse.emf.ecore.EObject parserElement = getParserElement();
			if (parserElement != null && getParser() != null) {
				text = getParser().getPrintString(
					new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(parserElement),
					getParserOptions().intValue());
			}
			if (text == null || text.length() == 0) {
				text = defaultText;
			}
			return text;
		}
	'''

	def setLabelText(GenCommonBase it, GenDiagram diagram) '''
		«generatedMemberComment(it)»
		public void setLabelText(String text) {
			setLabelTextHelper(getFigure(), text);
			refreshSelectionFeedback();
		}
	'''

	def getEditText(GenCommonBase it) '''
		«generatedMemberComment(it)»
		public String getEditText() {
			if (getParserElement() == null || getParser() == null) {
				return ""; «nonNLS()»
			}
			return getParser().getEditString(
				new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getParserElement()),
				getParserOptions().intValue());
		}
	'''

	def isEditable(GenCommonBase it, Boolean readOnly) '''
		«generatedMemberComment(it)»
		protected boolean isEditable() {
			«IF readOnly»
				return false;
			«ELSE»
				return getParser() != null;
			«ENDIF»
		}
	'''

	def getEditTextValidator(GenCommonBase it) '''
		«generatedMemberComment(it)»
		public org.eclipse.jface.viewers.ICellEditorValidator getEditTextValidator() {
			return new org.eclipse.jface.viewers.ICellEditorValidator() {
		
			public String isValid(final Object value) {
				if (value instanceof String) {
					final org.eclipse.emf.ecore.EObject element = getParserElement();
					final org.eclipse.gmf.runtime.common.ui.services.parser.IParser parser = getParser();
					try {
						org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus valid =
							(org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus) getEditingDomain().runExclusive(
								new org.eclipse.emf.transaction.RunnableWithResult.Impl<org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus>() {
		
								public void run() {
			setResult(parser.isValidEditString(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(element), (String) value));
								}
							});
							return valid.getCode() == org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus.EDITABLE ? null : valid.getMessage();
						} catch (InterruptedException ie) {
			ie.printStackTrace();
						}
					}
		
					// shouldn't get here
					return null;
				}
			};
		}
	'''

	def getCompletionProcessor(GenCommonBase it) '''
		«generatedMemberComment(it)»
		public org.eclipse.jface.text.contentassist.IContentAssistProcessor getCompletionProcessor() {
			if (getParserElement() == null || getParser() == null) {
				return null;
			}
			return getParser().getCompletionProcessor(new org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter(getParserElement()));
		}
	'''

	def getParserOptions(GenCommonBase it) '''
		«generatedMemberComment(it)»
		public org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions getParserOptions() {
			return org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions.NONE;
		}
	'''

	def getParser(GenCommonBase it, LabelModelFacet modelFacet, GenDiagram diagram, GenCommonBase host) '''
		«generatedMemberComment(it)»
		public org.eclipse.gmf.runtime.common.ui.services.parser.IParser getParser() {
			if (parser == null) {
				parser = «xptParserProvider.accessorCall(it, host, modelFacet, 'getParserElement()')»;
			}
			return parser;
		}
	'''

	def getManager(GenCommonBase it, GenDiagram diagram, LabelModelFacet modelFacet) '''
		«generatedMemberComment(it)»
		protected org.eclipse.gef.tools.DirectEditManager getManager() {
			if (manager == null) {
				setManager(new «getDirectManagerFQN(modelFacet)»(this,
					null,
					«getEditPartFactoryQualifiedClassName(diagram)».getTextCellEditorLocator(this)));
			}
			return manager;
		}
	'''

	def setManager(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void setManager(org.eclipse.gef.tools.DirectEditManager manager) {
			this.manager = manager;
		}
	'''

	def performDirectEdit(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void performDirectEdit() {
			getManager().show();
		}
	'''

	def performDirectEditAtPoint(GenCommonBase it, LabelModelFacet modelFacet) '''
		«generatedMemberComment(it)»
		protected void performDirectEdit(org.eclipse.draw2d.geometry.Point eventLocation) {
			if (getManager().getClass() == «getDirectManagerFQN(modelFacet)».class) {
				((«getDirectManagerFQN(modelFacet)») getManager()).show(eventLocation.getSWTPoint());
			}
		}
	'''

	def performDirectEditWithInitialChar(GenCommonBase it) '''
		«generatedMemberComment(it)»
		private void performDirectEdit(char initialCharacter) {
			if (getManager() instanceof org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) {
				((org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager) getManager()).show(initialCharacter);
			} else // 
			if (getManager() instanceof org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2) {
				((org.eclipse.gmf.tooling.runtime.directedit.TextDirectEditManager2) getManager()).show(initialCharacter);
			} else //
			{
				performDirectEdit();
			}
		}
	'''

	def performDirectEditRequest(GenCommonBase it, LabelModelFacet modelFacet) '''
		«generatedMemberComment(it)»
		protected void performDirectEditRequest(org.eclipse.gef.Request request) {
			final org.eclipse.gef.Request theRequest = request;
			try {
				getEditingDomain().runExclusive(new Runnable() {
		
			public void run() {
				if (isActive() && isEditable()) {
					«IF !isChoiceLabel(modelFacet)»
						if (theRequest.getExtendedData().get(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR) instanceof Character) {
							Character initialChar = (Character) theRequest.getExtendedData().get(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_DIRECTEDIT_EXTENDEDDATA_INITIAL_CHAR);
							performDirectEdit(initialChar.charValue());
					} else «ENDIF» if ((theRequest instanceof org.eclipse.gef.requests.DirectEditRequest) && (getEditText().equals(getLabelText()))) {
						org.eclipse.gef.requests.DirectEditRequest editRequest = (org.eclipse.gef.requests.DirectEditRequest) theRequest;
						performDirectEdit(editRequest.getLocation());
					} else {
						performDirectEdit();
					}
				}
			}
				});
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	'''

	def refreshVisuals(GenCommonBase it, Boolean needsRefreshBounds) '''
		«generatedMemberComment(it)»
		protected void refreshVisuals() {
			super.refreshVisuals();
			refreshLabel();
			refreshFont();
			refreshFontColor();
			refreshUnderline();
			refreshStrikeThrough();
			«IF needsRefreshBounds»
				refreshBounds();
			«ENDIF»
		}
	'''

	def refreshLabel(GenCommonBase it, GenDiagram diagram) '''
		«generatedMemberComment(it)»
		protected void refreshLabel() {
			setLabelTextHelper(getFigure(), getLabelText());
			setLabelIconHelper(getFigure(), getLabelIcon());
			refreshSelectionFeedback();
		}
	'''

	def refreshUnderline(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void refreshUnderline() {
			org.eclipse.gmf.runtime.notation.FontStyle style =
				(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(
					org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
			if (style != null && getFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
				((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getFigure()).setTextUnderline(style.isUnderline());
			}
		}
	'''

	def refreshStrikeThrough(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void refreshStrikeThrough() {
			org.eclipse.gmf.runtime.notation.FontStyle style =
				(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(
					org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
			if (style != null && getFigure() instanceof org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) {
				((org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel) getFigure()).setTextStrikeThrough(style.isStrikeThrough());
			}
		}
	'''

	def refreshFont(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void refreshFont() {
			org.eclipse.gmf.runtime.notation.FontStyle style =
				(org.eclipse.gmf.runtime.notation.FontStyle) getFontStyleOwnerView().getStyle(
					org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
			if (style != null) {
				org.eclipse.swt.graphics.FontData fontData = new org.eclipse.swt.graphics.FontData(
					style.getFontName(), style.getFontHeight(),
					(style.isBold() ? org.eclipse.swt.SWT.BOLD : org.eclipse.swt.SWT.NORMAL) |
					(style.isItalic() ? org.eclipse.swt.SWT.ITALIC : org.eclipse.swt.SWT.NORMAL));
				setFont(fontData);
			}
		}
	'''

	def refreshSelectionFeedback(GenCommonBase it) '''
		«generatedMemberComment(it)»
		private void refreshSelectionFeedback() {
			requestEditPolicyFeedbackRefresh(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
			requestEditPolicyFeedbackRefresh(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE);
		}
		
		«generatedMemberComment(it)»
		private void requestEditPolicyFeedbackRefresh(String editPolicyKey) {
			Object editPolicy = getEditPolicy(editPolicyKey);
			if (editPolicy instanceof org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy) {
				((org.eclipse.gmf.tooling.runtime.edit.policies.labels.IRefreshableFeedbackEditPolicy)editPolicy).refreshFeedback();
			}
		}
	'''

	def setFontColor(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void setFontColor(org.eclipse.swt.graphics.Color color) {
			getFigure().setForegroundColor(color);
		}
	'''

	def addSemanticListeners(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void addSemanticListeners() {
		«IF isOclChoiceLabel(it) || isViewExpressionDefinedAndOcl(it)»
			«IF isOclChoiceLabelWithShowExpr(it) || isViewExpressionDefinedAndOcl(it)»
				org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker tracker = getTracker();
				tracker.initialize(resolveSemanticElement());
				tracker.installListeners(getEditingDomain(), this, getOclRegistrator());
			«ELSE»
				super.addSemanticListeners();
			«ENDIF»
			«IF isOclChoiceLabel(it)»
				((org.eclipse.gmf.tooling.runtime.parsers.OclChoiceParser) getParser()).installListeners(this, getOclRegistrator());
			«ENDIF»		
		«ELSE»
			if (getParser() instanceof org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) {
				org.eclipse.emf.ecore.EObject element = resolveSemanticElement();
				parserElements = ((org.eclipse.gmf.runtime.emf.ui.services.parser.ISemanticParser) getParser()).getSemanticElementsBeingParsed(element);
				for (int i = 0; i < parserElements.size(); i++) {
					addListenerFilter("SemanticModel" + i, this, (org.eclipse.emf.ecore.EObject) parserElements.get(i)); «nonNLS()»
				}
			} else {
				super.addSemanticListeners();
			}
		«ENDIF»	
		}
	'''

	def removeSemanticListeners(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected void removeSemanticListeners() {
		«IF isOclChoiceLabel(it) || isViewExpressionDefinedAndOcl(it)»			
			«IF isOclChoiceLabel(it)»
				((org.eclipse.gmf.tooling.runtime.parsers.OclChoiceParser) getParser()).uninstallListeners();
			«ENDIF»
			«IF isOclChoiceLabelWithShowExpr(it) || isViewExpressionDefinedAndOcl(it)»
				getTracker().uninstallListeners();	
			«ELSE»
				super.removeSemanticListeners();
			«ENDIF»	
		«ELSE»		
			if (parserElements != null) {
				for (int i = 0; i < parserElements.size(); i++) {
					removeListenerFilter("SemanticModel" + i); «nonNLS()»
				}
			} else {
				super.removeSemanticListeners();
			}
		«ENDIF»
		}
	'''

	def getAccessibleEditPart(GenCommonBase it) '''
		«generatedMemberComment(it)»
		protected org.eclipse.gef.AccessibleEditPart getAccessibleEditPart() {
			if (accessibleEP == null) {
				accessibleEP = new AccessibleGraphicalEditPart() {
		
			public void getName(org.eclipse.swt.accessibility.AccessibleEvent e) {
				e.result = getLabelTextHelper(getFigure());
			}
				};
			}
			return accessibleEP;
		}
	'''

	def getFontStyleOwnerView(GenCommonBase it, Viewmap viewmap) '''
		«generatedMemberComment(it)»
		 private org.eclipse.gmf.runtime.notation.View getFontStyleOwnerView() {
		 «IF viewmap.isFixedFont()»
		 	return (org.eclipse.gmf.runtime.notation.View) getModel();
		 «ELSE»
		 	return getPrimaryView();
		 «ENDIF»
		 }
	'''

	def getOclTracker(GenCommonBase it) '''
		«generatedMemberComment(it)»
		private org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker getTracker() {
			return ((org.eclipse.gmf.tooling.runtime.ocl.tracker.HasOclTracker) getParser()).getOclTracker();
		}
	'''

	def getOclRegistrator(GenCommonBase it) '''
		«generatedMemberComment(it)»
		private org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker.Registrator getOclRegistrator() {
			if (myOclRegistrator == null) {
				myOclRegistrator = new org.eclipse.gmf.tooling.runtime.ocl.tracker.OclTracker.Registrator() {
					
					«overrideI(it)»
					public void registerListener(String filterId, org.eclipse.gmf.runtime.diagram.core.listener.NotificationListener listener, org.eclipse.emf.ecore.EObject element) {
						addListenerFilter(filterId, listener, element);
					}
					
					«overrideI(it)»
					public void unregisterListener(String filterId) {
						removeListenerFilter(filterId);
					}
				};
			}
			return myOclRegistrator;
		}
	'''

}

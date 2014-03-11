package diagram.parts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.FeatureLabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.LabelModelFacet
import org.eclipse.gmf.codegen.gmfgen.LabelTextAccessMethod
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.Viewmap
import common.Common
import diagram.MetaModel
import diagram.ViewmapAttributesUtilsHelper

class LabelController {

	extension Common = new Common
	extension MetaModel = new MetaModel
	extension LabelControllerHelper = new LabelControllerHelper
	extension ViewmapAttributesUtilsHelper = new ViewmapAttributesUtilsHelper

	@Inject extension PartCommon
	@Inject extension NodeEditPart

	def directEditManager(GenCommonBase it) '''
		«IF !isReadOnly()»
		«generatedMemberComment»
		private org.eclipse.gef.tools.DirectEditManager manager;

		«generatedMemberComment»
		protected org.eclipse.gef.tools.DirectEditManager getManager() {
			if (manager == null) {
				manager = new org.eclipse.gef.tools.DirectEditManager(this, org.eclipse.jface.viewers.TextCellEditor.class, new org.eclipse.gmf.runtime.gwt.services.LabelCellEditorLocator(getViewer(), getLabel())) {
					protected void initCellEditor() {
						getCellEditor().setValue(getLabelTextDisplayer().getEditText(«getViewCode».getElement()));
					}
				};
			}
			return manager;
		}
		«ENDIF»
	'''

	def performDirectEdit(GenCommonBase it) '''
		«IF !isReadOnly()»
		«generatedMemberComment»
		protected void performDirectEdit() {
«««			if («getDiagram().getDiagramEditorUtilQualifiedClassName()».isReadOnly(«getViewCode».getElement()) || «getDiagram().getDiagramEditorUtilQualifiedClassName()».isReadOnly(«getViewCode»)) {
«««				return;
«««			}
			if (getLabelTextDisplayer() == null) {
				return;
			}
			getManager().show();
		}
		«ENDIF»
	'''

	def labelDisplayer(GenCommonBase it) '''
		«generatedMemberComment»
		public static final org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelTextDisplayer LABEL_DISPLAYER = createLabelTextDisplayer();

		«generatedMemberComment»
		public org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelTextDisplayer getLabelTextDisplayer() {
			return LABEL_DISPLAYER;
		}

		«generatedMemberComment»
		private static org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelTextDisplayer createLabelTextDisplayer() {
			«IF getLabelModelFacet == null»
«««			«ERROR 'Unexpected type'»
			«ELSE»
			«getLabelModelFacet.createLabelTextDisplayer(isReadOnly())»
			«ENDIF»
		}
	'''

	def dispatch createLabelTextDisplayer(LabelModelFacet it, Boolean isReadOnly) '''
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		return null;
	'''

	def dispatch createLabelTextDisplayer(FeatureLabelModelFacet it, Boolean isReadOnly) '''
		«IF viewMethod == editMethod»
		return «instantiateLabelTextDisplayer(isReadOnly)»;
		«ELSE»
		org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelTextDisplayer reader = «instantiateLabelTextReader»;
		org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelTextDisplayer writer = «IF isReadOnly»null;«ELSE»«instantiateLabelTextWriter»;«ENDIF»
		return new org.eclipse.gmf.runtime.gwt.edit.parts.labels.CompositeLabelTextDisplayer(reader, writer);
		«ENDIF»
	'''

	def features(FeatureLabelModelFacet it) '''
		new org.eclipse.emf.ecore.EAttribute[] {«FOR m: metaFeatures SEPARATOR ', '»«m.metaFeature»«ENDFOR»}
	'''

	def instantiateLabelTextDisplayer(FeatureLabelModelFacet it, Boolean isReadOnly) '''
		«IF viewMethod == LabelTextAccessMethod::MESSAGE_FORMAT»
		new org.eclipse.gmf.runtime.gwt.edit.parts.labels.MessageFormatLabelTextDisplayer(«readerPatterns»«IF !isReadOnly», «writerPatterns»«ENDIF», «features»)«»
		«ELSEIF viewMethod == LabelTextAccessMethod::NATIVE»
		«IF metaFeatures.size() != 1»«'Unexpected features size for NATIVE label text access method'»«ENDIF»
		new org.eclipse.gmf.runtime.gwt.edit.parts.labels.NativeLabelTextDisplayer(«features»)«»
		«ELSEIF viewMethod == LabelTextAccessMethod::PRINTF»
		new org.eclipse.gmf.runtime.gwt.edit.parts.labels.PrintfLabelTextDisplayer(«readerPatterns», «features»)«»
		«ELSE»
		«'Unexpected label text access method'»
		«ENDIF»
	'''

	def instantiateLabelTextReader(FeatureLabelModelFacet it) '''«instantiateLabelTextDisplayer(true)»'''

	def instantiateLabelTextWriter(FeatureLabelModelFacet it) '''
		«IF viewMethod == LabelTextAccessMethod::MESSAGE_FORMAT»
		new org.eclipse.gmf.runtime.gwt.edit.parts.labels.MessageFormatLabelTextDisplayer(null, null, «writerPatterns», «features»)«»
		«ELSEIF viewMethod == LabelTextAccessMethod::NATIVE»
		«IF metaFeatures.size() != 1»«'Unexpected features size for NATIVE label text access method'»«ENDIF»
		new org.eclipse.gmf.runtime.gwt.edit.parts.labels.NativeLabelTextDisplayer(«features»)«»
		«ELSEIF editMethod == LabelTextAccessMethod::REGEXP»
		new org.eclipse.gmf.runtime.gwt.edit.parts.labels.RegexpParser(«writerPatterns», «features»)«»
		«ELSE»
		«'Unexpected label text access method'»
		«ENDIF»
	'''

	def readerPatterns(FeatureLabelModelFacet it) '''
		«quote(viewPattern)», «quote(if (isPatternSpecified(editorPattern) ) editorPattern else viewPattern)»
	'''

	def writerPatterns(FeatureLabelModelFacet it) '''
		«quote(if (isPatternSpecified(editPattern)) editPattern else if (isPatternSpecified(editorPattern)) editorPattern else viewPattern)»
	'''

	def quote(FeatureLabelModelFacet it, String text) '''
		«IF text == null»null«ELSE»"«text»«ENDIF»
	'''

	def labelText(GenCommonBase it) '''
		«generatedMemberComment»
		private String defaultText;

		«generatedMemberComment»
		public void setLabelText(String text) {
			if (text == null || text.length() == 0) {
				text = defaultText;
			}
			getLabel().setText(text);
		}

		«generatedMemberComment»
		protected String getLabelText() {
			if (getLabelTextDisplayer() == null) {
				return defaultText;
			}
			org.eclipse.emf.ecore.EObject element = «getViewCode».getElement();
			if (element == null) {
				return defaultText;
			}
			String result = getLabelTextDisplayer().getDisplayText(element);
			if (result == null || result.length() == 0) {
				return defaultText;
			}
			return result;
		}
	'''

	def dispatch labelFigure(ParentAssignedViewmap it, GenCommonBase label) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createFigure() {
			// Parent should assign one using «setter» method
			return null;
		}
		
		«getLabel»

		«generatedMemberComment»
		public void «setter»(«getFigureQualifiedClassName()» label) {
			unregisterVisuals();
			setFigure(label);
			«initDefaultText»
			registerVisuals();
			refreshVisuals();
		}
	'''

	def dispatch labelFigure(Viewmap it, GenCommonBase label) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createFigure() {
			«getFigureQualifiedClassName()» label = createLabel();
			«initDefaultText»
			return label;
		}

		«generatedMemberComment»
		protected «getFigureQualifiedClassName()» createLabel() {
			«createLabel»
		}
		
		«getLabel»
	'''

	def dispatch createLabel(Viewmap it ) '''«'Unexpected viewmap type: ' + it»'''

	def dispatch createLabel(FigureViewmap it) '''
		return new «getFigureQualifiedClassName()»();
	'''

	def dispatch createLabel(SnippetViewmap it) '''
		return «body»;
	'''

	def dispatch createLabel(InnerClassViewmap it) '''
		return new «getFigureQualifiedClassName()»();
	'''

	def dispatch initDefaultText(Viewmap it) '''
		«IF 'org.eclipse.draw2d.Label' == getFigureQualifiedClassName()»
		defaultText = label.getText();
		«ELSE»
		if (label instanceof org.eclipse.draw2d.Label) {
			defaultText = label.getText();
		} else {
			defaultText = "";
		}
		«ENDIF»
	'''

	def dispatch initDefaultText(InnerClassViewmap it) '''
		defaultText = label.getText();
	'''

	def getLabel(Viewmap it) '''
		«getLabelComment»
		public org.eclipse.draw2d.Label getLabel() {
			return (org.eclipse.draw2d.Label) getFigure();
		}
	'''

	def dispatch getLabelComment(Viewmap it) '''
«««		«IF 'org.eclipse.draw2d.Label' == getFigureQualifiedClassName()»
«««		«xpt::Common::generatedMemberComment»
«««		«ELSE»
«««		«xpt::Common::generatedMemberComment('TODO: reimplement, since the figure used by this editpart may not be a Label.')»
«««		«ENDIF»
	'''

	def dispatch getLabelComment(InnerClassViewmap it) '''
«««		«xpt::Common::generatedMemberComment»
	'''

	def labelIcon(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.swt.graphics.Image getLabelIcon() {
		«IF isElementIcon()»
			try {
				return clientFactory.getImageProvider().getImage(«getElement».eClass());
			} catch (Exception e) {
				return null;
			}
		«ELSE»
			return null;
		«ENDIF»
		}
	'''

	def dispatch getElement(GenCommonBase it) '''«getViewCode».getElement()'''

	def dispatch getElement(GenLinkLabel it) '''
		«link.modelFacet.getElement(link)»
	'''

	def dispatch getElement(LinkModelFacet it, GenLink link) '''«'Unexpected model facet: ' + it»'''

	def dispatch getElement(TypeLinkModelFacet it, GenLink link) '''getUpdatableParent().«link.getViewCode».getElement()'''

	def dispatch getElement(FeatureLinkModelFacet it, GenLink link) '''getUpdatableParent().«link.getViewCode».getTarget().getElement()'''

	def getUpdatableParent(GenLabel it) '''
		«generatedMemberComment»
		private «getLabelHostQualifiedClassName()» getUpdatableParent() {
			assert getParent() instanceof «getLabelHostQualifiedClassName()»;
			return («getLabelHostQualifiedClassName()») getParent();
		}
	'''

	//	The activate/deactivate pair for labels with updatable parents more belongs to the LabelController template.
	//	It is thus referenced from the common activate/deactivate mechanism.

	def activateAdditions(GenLabel it) '''
		«getLabelHostQualifiedClassName()» updatableParent = getUpdatableParent();
		if (updatableParent != null) {
		«IF !viewmap.isFixedFont()»
			updatableParent.installRefresher(fontColorRefresher);
			updatableParent.installRefresher(fontRefresher);
		«ENDIF»
			updatableParent.installRefresher(getLabelRefresher());
			updatableParent.addNotifier(getDiagramNode());
			updatableParent.addNotifier(getDiagramNode().getElement());
			«activateMore»
		}
	'''

	def deactivateAdditions(GenLabel it) '''
		«getLabelHostQualifiedClassName()» updatableParent = getUpdatableParent();
		if (updatableParent != null) {
		«IF !viewmap.isFixedFont()»
			updatableParent.uninstallRefresher(fontColorRefresher);
			updatableParent.uninstallRefresher(fontRefresher);
		«ENDIF»
			updatableParent.uninstallRefresher(getLabelRefresher());
			updatableParent.removeNotifier(getDiagramNode());
			updatableParent.removeNotifier(getDiagramNode().getElement());
			«deactivateMore»
		}
	'''

	def dispatch activateMore(GenLabel it) ''''''

	def dispatch deactivateMore(GenLabel it) ''''''

	def dispatch activateMore(GenExternalNodeLabel it) '''
		updatableParent.installRefresher(boundsRefresher);
	'''

	def dispatch deactivateMore(GenExternalNodeLabel it) '''
		updatableParent.uninstallRefresher(boundsRefresher);
	'''

	def dispatch activateMore(GenLinkLabel it) '''
		updatableParent.installRefresher(boundsRefresher);
	'''

	def dispatch deactivateMore(GenLinkLabel it) '''
		updatableParent.uninstallRefresher(boundsRefresher);
	'''
	
	def isPatternSpecified(String pattern) { !pattern.nullOrEmpty }
}

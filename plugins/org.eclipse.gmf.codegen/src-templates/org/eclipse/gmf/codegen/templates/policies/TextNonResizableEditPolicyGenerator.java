package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class TextNonResizableEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized TextNonResizableEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TextNonResizableEditPolicyGenerator result = new TextNonResizableEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "import org.eclipse.draw2d.ColorConstants;" + NL + "import org.eclipse.draw2d.Figure;" + NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.Label;" + NL + "import org.eclipse.draw2d.RectangleFigure;" + NL + "import org.eclipse.draw2d.geometry.Rectangle;" + NL + "import org.eclipse.gef.GraphicalEditPart;" + NL + "import org.eclipse.gef.LayerConstants;" + NL + "import org.eclipse.gef.handles.MoveHandle;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends NonResizableEditPolicyEx {";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure selectionFeedbackFigure;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure focusFeedbackFigure;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showPrimarySelection() {" + NL + "\t\tshowSelection();" + NL + "\t\tshowFocus();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showSelection() {" + NL + "\t\thideSelection();" + NL + "\t\taddFeedback(selectionFeedbackFigure = createSelectionFeedbackFigure());" + NL + "\t\trefreshSelectionFeedback();" + NL + "\t\thideFocus();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void hideSelection() {" + NL + "\t\tif (selectionFeedbackFigure != null) {" + NL + "\t\t\tremoveFeedback(selectionFeedbackFigure);" + NL + "\t\t\tselectionFeedbackFigure = null;" + NL + "\t\t}" + NL + "\t\thideFocus();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showFocus() {" + NL + "\t\thideFocus();" + NL + "\t\taddFeedback(focusFeedbackFigure = createFocusFeedbackFigure());" + NL + "\t\trefreshFocusFeedback();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void hideFocus() {" + NL + "\t\tif (focusFeedbackFigure != null) {" + NL + "\t\t\tremoveFeedback(focusFeedbackFigure);" + NL + "\t\t\tfocusFeedbackFigure = null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure getFeedbackLayer() {" + NL + "\t\treturn getLayer(LayerConstants.SCALED_FEEDBACK_LAYER);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Rectangle getFeedbackBounds() {" + NL + "\t\tRectangle bounds;" + NL + "\t\tif (getHostFigure() instanceof Label) {" + NL + "\t\t\tbounds = ((Label) getHostFigure()).getTextBounds();" + NL + "\t\t\tbounds.intersect(getHostFigure().getBounds());" + NL + "\t\t} else {" + NL + "\t\t\tbounds = getHostFigure().getBounds().getCopy();" + NL + "\t\t}" + NL + "\t\tgetHostFigure().getParent().translateToAbsolute(bounds);" + NL + "\t\tgetFeedbackLayer().translateToRelative(bounds);" + NL + "\t\treturn bounds;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createSelectionFeedbackFigure() {" + NL + "\t\tif (getHostFigure() instanceof Label) {" + NL + "\t\t\tLabel feedbackFigure = new Label();" + NL + "\t\t\tfeedbackFigure.setOpaque(true);" + NL + "\t\t\tfeedbackFigure.setBackgroundColor(ColorConstants.menuBackgroundSelected);" + NL + "\t\t\tfeedbackFigure.setForegroundColor(ColorConstants.menuForegroundSelected);" + NL + "\t\t\treturn feedbackFigure;" + NL + "\t\t} else {" + NL + "\t\t\tRectangleFigure feedbackFigure = new RectangleFigure();" + NL + "\t\t\tfeedbackFigure.setFill(false);" + NL + "\t\t\treturn feedbackFigure;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFocusFeedbackFigure() {" + NL + "\t\treturn new Figure() {" + NL + "" + NL + "\t\t\tprotected void paintFigure(Graphics graphics) {" + NL + "\t\t\t\tgraphics.drawFocus(getBounds().getResized(-1, -1));" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void updateLabel(Label target) {" + NL + "\t\tLabel source = (Label) getHostFigure();" + NL + "\t\ttarget.setText(source.getText());" + NL + "\t\ttarget.setTextAlignment(source.getTextAlignment());" + NL + "\t\ttarget.setFont(source.getFont());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshSelectionFeedback() {" + NL + "\t\tif (selectionFeedbackFigure != null) {" + NL + "\t\t\tif (selectionFeedbackFigure instanceof Label) {" + NL + "\t\t\t\tupdateLabel((Label) selectionFeedbackFigure);" + NL + "\t\t\t\tselectionFeedbackFigure.setBounds(getFeedbackBounds());" + NL + "\t\t\t} else {" + NL + "\t\t\t\tselectionFeedbackFigure.setBounds(getFeedbackBounds().expand(5, 5));" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFocusFeedback() {" + NL + "\t\tif (focusFeedbackFigure != null) {" + NL + "\t\t\tfocusFeedbackFigure.setBounds(getFeedbackBounds());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void refreshFeedback() {" + NL + "\t\trefreshSelectionFeedback();" + NL + "\t\trefreshFocusFeedback();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List createSelectionHandles() {" + NL + "\t\tMoveHandle moveHandle = new MoveHandle((GraphicalEditPart) getHost());" + NL + "\t\tmoveHandle.setBorder(null);" + NL + "\t\tmoveHandle.setDragTracker(new DragEditPartsTrackerEx(getHost()));" + NL + "\t\treturn Collections.singletonList(moveHandle);" + NL + "\t}" + NL + "}";
  protected final String TEXT_11 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getTextNonResizableEditPolicyClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}
package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class TextSelectionEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized TextSelectionEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    TextSelectionEditPolicyGenerator result = new TextSelectionEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.draw2d.Graphics;" + NL + "import org.eclipse.draw2d.IFigure;" + NL + "import org.eclipse.draw2d.Label;" + NL + "import org.eclipse.draw2d.RectangleFigure;" + NL + "import org.eclipse.draw2d.geometry.Rectangle;" + NL + "import org.eclipse.gef.editpolicies.SelectionEditPolicy;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;" + NL + "import org.eclipse.swt.graphics.Color;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends SelectionEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure selectionFeedbackFigure;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure focusFeedbackFigure;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showSelection() {" + NL + "\t\thideSelection();" + NL + "\t\taddFeedback(selectionFeedbackFigure = createSelectionFeedbackFigure());" + NL + "\t\trefreshSelectionFeedbackBounds();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void hideSelection() {" + NL + "\t\tif (selectionFeedbackFigure != null) {" + NL + "\t\t\tremoveFeedback(selectionFeedbackFigure);" + NL + "\t\t\tselectionFeedbackFigure = null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showFocus() {" + NL + "\t\thideFocus();" + NL + "\t\taddFeedback(focusFeedbackFigure = createFocusFeedbackFigure());" + NL + "\t\trefreshFocusFeedbackBounds();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void hideFocus() {" + NL + "\t\tif (focusFeedbackFigure != null) {" + NL + "\t\t\tremoveFeedback(focusFeedbackFigure);" + NL + "\t\t\tfocusFeedbackFigure = null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Rectangle getFeedbackBounds() {" + NL + "\t\tRectangle bounds;" + NL + "\t\tIFigure hostFigure = getHostFigure();" + NL + "\t\tif (hostFigure instanceof Label) {" + NL + "\t\t\tLabel label = (Label) hostFigure;" + NL + "\t\t\tbounds = label.getTextBounds();" + NL + "\t\t\tbounds.union(label.getIconBounds());" + NL + "\t\t\tbounds.intersect(label.getBounds());" + NL + "\t\t} else if (hostFigure instanceof WrapLabel) {" + NL + "\t\t\tWrapLabel label = (WrapLabel) hostFigure;" + NL + "\t\t\tbounds = label.getTextBounds();" + NL + "\t\t\tbounds.union(label.getIconBounds());" + NL + "\t\t\tbounds.intersect(label.getBounds());" + NL + "\t\t} else {" + NL + "\t\t\tbounds = getHostFigure().getBounds().getCopy();" + NL + "\t\t}" + NL + "\t\tgetHostFigure().getParent().translateToAbsolute(bounds);" + NL + "\t\tgetFeedbackLayer().translateToRelative(bounds);" + NL + "\t\treturn bounds;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshSelectionFeedbackBounds() {" + NL + "\t\tif (selectionFeedbackFigure != null) {" + NL + "\t\t\tselectionFeedbackFigure.setBounds(getFeedbackBounds().expand(2, 2));" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshFocusFeedbackBounds() {" + NL + "\t\tif (focusFeedbackFigure != null) {" + NL + "\t\t\tfocusFeedbackFigure.setBounds(getFeedbackBounds().expand(5, 5));" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Color getFeedbackColor() {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createSelectionFeedbackFigure() {" + NL + "\t\tRectangleFigure feedbackFigure = new RectangleFigure();" + NL + "\t\tfeedbackFigure.setFill(false);" + NL + "\t\tColor feedbackColor = getFeedbackColor();" + NL + "\t\tif (feedbackColor != null) {" + NL + "\t\t\tfeedbackFigure.setForegroundColor(feedbackColor);" + NL + "\t\t}" + NL + "\t\treturn feedbackFigure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createFocusFeedbackFigure() {" + NL + "\t\tRectangleFigure feedbackFigure = new RectangleFigure();" + NL + "\t\tfeedbackFigure.setFill(false);" + NL + "\t\tColor feedbackColor = getFeedbackColor();" + NL + "\t\tif (feedbackColor != null) {" + NL + "\t\t\tfeedbackFigure.setForegroundColor(feedbackColor);" + NL + "\t\t}" + NL + "\t\tfeedbackFigure.setLineStyle(Graphics.LINE_DOT);" + NL + "\t\treturn feedbackFigure;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void refreshFeedback() {" + NL + "\t\trefreshSelectionFeedbackBounds();" + NL + "\t\trefreshFocusFeedbackBounds();" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

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
    stringBuffer.append(genDiagram.getTextSelectionEditPolicyClassName());
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}
package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ExternalNodeLabelHostLayoutEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized ExternalNodeLabelHostLayoutEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ExternalNodeLabelHostLayoutEditPolicyGenerator result = new ExternalNodeLabelHostLayoutEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.ArrayList;" + NL + "import java.util.Iterator;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.draw2d.geometry.Rectangle;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.GraphicalEditPart;" + NL + "import org.eclipse.gef.Request;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.editpolicies.LayoutEditPolicy;" + NL + "import org.eclipse.gef.requests.ChangeBoundsRequest;" + NL + "import org.eclipse.gef.requests.GroupRequest;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;" + NL + "import org.eclipse.gmf.runtime.notation.NotationPackage;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends XYLayoutEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate LayoutEditPolicy realLayoutEditPolicy;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic LayoutEditPolicy getRealLayoutEditPolicy() {" + NL + "\t\treturn realLayoutEditPolicy;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setRealLayoutEditPolicy(LayoutEditPolicy realLayoutEditPolicy) {" + NL + "\t\tthis.realLayoutEditPolicy = realLayoutEditPolicy;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(EditPart editPart) {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final List getExternalLabels(GroupRequest request) {" + NL + "\t\tList editParts = new ArrayList();" + NL + "\t\tif (request.getEditParts() != null) {" + NL + "\t\t\tfor (Iterator it = request.getEditParts().iterator(); it.hasNext();) {" + NL + "\t\t\t\tEditPart editPart = (EditPart) it.next();" + NL + "\t\t\t\tif (isExternalLabel(editPart)) {" + NL + "\t\t\t\t\teditParts.add(editPart);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn editParts;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Command getCommand(Request request) {" + NL + "\t\tif (REQ_MOVE_CHILDREN.equals(request.getType())) {" + NL + "\t\t\tChangeBoundsRequest cbRequest = (ChangeBoundsRequest) request;" + NL + "\t\t\tList extLabels = getExternalLabels(cbRequest);" + NL + "\t\t\tif (!extLabels.isEmpty()) {" + NL + "\t\t\t\tList editParts = cbRequest.getEditParts();" + NL + "\t\t\t\tCommand cmd = null;" + NL + "\t\t\t\tif (realLayoutEditPolicy != null && editParts.size() > extLabels.size()) {" + NL + "\t\t\t\t\tList other = new ArrayList(editParts);" + NL + "\t\t\t\t\tother.removeAll(extLabels);" + NL + "\t\t\t\t\tcbRequest.setEditParts(other);" + NL + "\t\t\t\t\tcmd = realLayoutEditPolicy.getCommand(request);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tcbRequest.setEditParts(extLabels);" + NL + "\t\t\t\tCommand extLabelsCmd = getMoveChildrenCommand(request);" + NL + "\t\t\t\tcbRequest.setEditParts(editParts);" + NL + "\t\t\t\treturn cmd == null ? extLabelsCmd : cmd.chain(extLabelsCmd);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (request instanceof GroupRequest) {" + NL + "\t\t\tList extLabels = getExternalLabels((GroupRequest) request);" + NL + "\t\t\tif (!extLabels.isEmpty()) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn realLayoutEditPolicy == null ? null : realLayoutEditPolicy.getCommand(request);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object getConstraintFor(ChangeBoundsRequest request, GraphicalEditPart child) {" + NL + "\t\tint dx = ((Integer) ViewUtil.getStructuralFeatureValue((View) child.getModel(), NotationPackage.eINSTANCE.getLocation_X())).intValue();" + NL + "\t\tint dy = ((Integer) ViewUtil.getStructuralFeatureValue((View) child.getModel(), NotationPackage.eINSTANCE.getLocation_Y())).intValue();" + NL + "\t\tRectangle r = new Rectangle(dx, dy, 0, 0);" + NL + "\t\tchild.getFigure().translateToAbsolute(r);" + NL + "\t\tr.translate(request.getMoveDelta());" + NL + "\t\tchild.getFigure().translateToRelative(r);" + NL + "\t\treturn r;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean understandsRequest(Request req) {" + NL + "\t\tif (realLayoutEditPolicy != null && realLayoutEditPolicy.understandsRequest(req)) {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t\treturn super.understandsRequest(req);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void decorateChild(EditPart child) {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setHost(EditPart host) {" + NL + "\t\tsuper.setHost(host);" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.setHost(host);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void activate() {" + NL + "\t\tsuper.activate();" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.activate();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void deactivate() {" + NL + "\t\tsuper.deactivate();" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.deactivate();" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPart getTargetEditPart(Request request) {" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\treturn realLayoutEditPolicy.getTargetEditPart(request);" + NL + "\t\t} else {" + NL + "\t\t\treturn super.getTargetEditPart(request);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void showSourceFeedback(Request request) {" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.showSourceFeedback(request);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.showSourceFeedback(request);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void eraseSourceFeedback(Request request) {" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.eraseSourceFeedback(request);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.eraseSourceFeedback(request);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void showTargetFeedback(Request request) {" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.showTargetFeedback(request);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.showTargetFeedback(request);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void eraseTargetFeedback(Request request) {" + NL + "\t\tif (realLayoutEditPolicy != null) {" + NL + "\t\t\trealLayoutEditPolicy.eraseTargetFeedback(request);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.eraseTargetFeedback(request);" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

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
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getExternalNodeLabelHostLayoutEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
package org.eclipse.gmf.codegen.templates.parts;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class NodeEditPartGenerator {
 
  protected static String nl;
  public static synchronized NodeEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NodeEditPartGenerator result = new NodeEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " extends ShapeNodeEditPart {";
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String VISUAL_ID = \"";
  protected final String TEXT_10 = "\";";
  protected final String TEXT_11 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure contentPane;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure primaryShape;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_12 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {";
  protected final String TEXT_13 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CREATION_ROLE, new ";
  protected final String TEXT_14 = "()";
  protected final String TEXT_15 = NL + "\t\t{" + NL + "" + NL + "\t\t\tpublic ";
  protected final String TEXT_16 = " getCommand(";
  protected final String TEXT_17 = " request) {" + NL + "\t\t\t\tif (understandsRequest(request)) {" + NL + "\t\t\t\t\tif (request instanceof ";
  protected final String TEXT_18 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_19 = " adapter =" + NL + "\t\t\t\t\t\t\t((";
  protected final String TEXT_20 = ") request).getViewAndElementDescriptor().getCreateElementRequestAdapter();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_21 = " type =" + NL + "\t\t\t\t\t\t\t(";
  protected final String TEXT_22 = ") adapter.getAdapter(";
  protected final String TEXT_23 = ".class);";
  protected final String TEXT_24 = NL + "\t\t\t\t\t\tif (type == ";
  protected final String TEXT_25 = ".";
  protected final String TEXT_26 = ") {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_27 = " compartmentEditPart =" + NL + "\t\t\t\t\t\t\t\tgetChildBySemanticHint(";
  protected final String TEXT_28 = ".VISUAL_ID);" + NL + "\t\t\t\t\t\t\treturn compartmentEditPart == null ? null : compartmentEditPart.getCommand(request);" + NL + "\t\t\t\t\t\t}";
  protected final String TEXT_29 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\treturn super.getCommand(request);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_30 = NL + "\t\t);";
  protected final String TEXT_31 = NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_32 = "());" + NL + "\t\tinstallEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new ";
  protected final String TEXT_33 = "());";
  protected final String TEXT_34 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ";
  protected final String TEXT_35 = "());";
  protected final String TEXT_36 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_37 = "());";
  protected final String TEXT_38 = NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new ";
  protected final String TEXT_39 = "() {" + NL + "" + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_40 = " child) {" + NL + "\t\t\t\tEditPolicy result = super.createChildEditPolicy(child);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_41 = "();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_42 = NL + "\t\tinstallEditPolicy(EditPolicy.LAYOUT_ROLE, new ";
  protected final String TEXT_43 = "() {" + NL + "" + NL + "\t\t\tprotected EditPolicy createChildEditPolicy(";
  protected final String TEXT_44 = " child) {" + NL + "\t\t\t\tif (child.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE) == null) {" + NL + "\t\t\t\t\tif (child instanceof ITextAwareEditPart) {" + NL + "\t\t\t\t\t\treturn new ";
  protected final String TEXT_45 = "();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn super.createChildEditPolicy(child);" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_46 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure createNodeShape() {";
  protected final String TEXT_47 = NL + "\t\treturn primaryShape = new ";
  protected final String TEXT_48 = "()";
  protected final String TEXT_49 = " {" + NL + "\t\t\tprotected boolean useLocalCoordinates() {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_50 = ";";
  protected final String TEXT_51 = NL + "\t\treturn ";
  protected final String TEXT_52 = ";";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = " figure = new ";
  protected final String TEXT_55 = "();" + NL + " \t\tfigure.setUseLocalCoordinates(";
  protected final String TEXT_56 = ");" + NL + " \t\treturn primaryShape = figure;";
  protected final String TEXT_57 = NL + "\t}";
  protected final String TEXT_58 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_59 = " getPrimaryShape() {" + NL + "\t\treturn (";
  protected final String TEXT_60 = ") primaryShape;" + NL + "\t}";
  protected final String TEXT_61 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean addFixedChild(EditPart childEditPart) {";
  protected final String TEXT_62 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_63 = ") {";
  protected final String TEXT_64 = NL + "\t\t\t((";
  protected final String TEXT_65 = ") childEditPart).setLabel(getPrimaryShape().getFigure";
  protected final String TEXT_66 = "());";
  protected final String TEXT_67 = NL + "\t\t\t((";
  protected final String TEXT_68 = ") childEditPart).setLabel(new ";
  protected final String TEXT_69 = "());";
  protected final String TEXT_70 = NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_71 = NL + "\t\treturn false;" + NL + "\t}";
  protected final String TEXT_72 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodePlate() {";
  protected final String TEXT_73 = NL + "\t\treturn new DefaultSizeNodeFigure(getMapMode().DPtoLP(";
  protected final String TEXT_74 = "), getMapMode().DPtoLP(";
  protected final String TEXT_75 = "));" + NL + "\t}";
  protected final String TEXT_76 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic EditPolicy getPrimaryDragEditPolicy() {" + NL + "\t\treturn new ";
  protected final String TEXT_77 = "() {" + NL + "\t\t\tprotected ";
  protected final String TEXT_78 = " createSelectionHandles() {" + NL + "\t\t\t\tfinal ";
  protected final String TEXT_79 = " part = (";
  protected final String TEXT_80 = ") getHost();" + NL + "\t\t\t\tfinal ";
  protected final String TEXT_81 = " list = new ";
  protected final String TEXT_82 = "();" + NL + "\t\t\t\taddMoveHandle(part, list);" + NL + "\t\t\t\t";
  protected final String TEXT_83 = NL + "\t\t\t\t";
  protected final String TEXT_84 = ".addHandle(part, list, ";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t";
  protected final String TEXT_88 = ".addHandle(part, list, ";
  protected final String TEXT_89 = ".";
  protected final String TEXT_90 = ");" + NL + "\t\t\t\t";
  protected final String TEXT_91 = NL + "\t\t\t\treturn list;" + NL + "\t\t\t}" + NL + "\t\t\tprivate void addMoveHandle(final ";
  protected final String TEXT_92 = " part, final ";
  protected final String TEXT_93 = " list) {" + NL + "\t\t\t\t";
  protected final String TEXT_94 = " moveHandle = new ";
  protected final String TEXT_95 = "(part);" + NL + "\t\t\t\t// just make it look nice ";
  protected final String TEXT_96 = NL + "\t\t\t\tmoveHandle.setBorder(null);" + NL + "\t\t\t\tlist.add(moveHandle);" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_97 = NL + "\t/**" + NL + "\t * Creates figure for this edit part." + NL + "\t * " + NL + "\t * Body of this method does not depend on settings in generation model" + NL + "\t * so you may safely remove <i>generated</i> tag and modify it." + NL + "\t * " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected NodeFigure createNodeFigure() {" + NL + "\t\tNodeFigure figure = createNodePlate();" + NL + "\t\tfigure.setLayoutManager(new StackLayout());" + NL + "\t\tIFigure shape = createNodeShape();" + NL + "\t\tfigure.add(shape);" + NL + "\t\tcontentPane = setupContentPane(shape);" + NL + "\t\t" + NL + "\t\tIFigure decorationShape = createDecorationPane();" + NL + "\t\tif (decorationShape != null) {" + NL + "\t\t\tfigure.add(decorationShape);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn figure;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFigure createDecorationPane() {" + NL + "\t\tView view = (View) getModel();" + NL + "\t\tEAnnotation annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tFigure decorationPane = new Figure();" + NL + "\t\tdecorationPane.setLayoutManager(new BorderLayout());" + NL + "" + NL + "\t\tImageFigureEx imageFigure = new ImageFigureEx(";
  protected final String TEXT_98 = ".getInstance().getBundledImage(\"icons/shortcut.gif\"), PositionConstants.EAST);" + NL + "\t\tdecorationPane.add(imageFigure, BorderLayout.BOTTOM);" + NL + "\t\treturn decorationPane;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Default implementation treats passed figure as content pane." + NL + "\t * Respects layout one may have set for generated figure." + NL + "\t * @param nodeShape instance of generated figure class" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure setupContentPane(IFigure nodeShape) {" + NL + "\t\tif (nodeShape.getLayoutManager() == null) {";
  protected final String TEXT_99 = NL + "\t\t\t";
  protected final String TEXT_100 = " layout = new ";
  protected final String TEXT_101 = "();" + NL + "\t\t\tlayout.setSpacing(getMapMode().DPtoLP(5));" + NL + "\t\t\tnodeShape.setLayoutManager(layout);";
  protected final String TEXT_102 = NL + "\t\tnodeShape.setLayoutManager(new ";
  protected final String TEXT_103 = "() {" + NL + "" + NL + "\t\t\tpublic Object getConstraint(IFigure figure) {" + NL + "\t\t\t\tObject result = constraints.get(figure);" + NL + "\t\t\t\tif (result == null) {" + NL + "\t\t\t\t\tresult = new ";
  protected final String TEXT_104 = "(0, 0, -1, -1);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_105 = NL + "\t\t}" + NL + "\t\treturn nodeShape; // use nodeShape itself as contentPane" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IFigure getContentPane() {" + NL + "\t\tif (contentPane != null) {" + NL + "\t\t\treturn contentPane;" + NL + "\t\t}" + NL + "\t\treturn super.getContentPane();" + NL + "\t}";
  protected final String TEXT_106 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_107 = " getPrimaryChildEditPart() {" + NL + "\t\treturn getChildBySemanticHint(";
  protected final String TEXT_108 = ".VISUAL_ID);" + NL + "\t}";
  protected final String TEXT_109 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(";
  protected final String TEXT_110 = " childEditPart, int index) {" + NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_111 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().add(labelFigure);" + NL + "\t\t} else {";
  protected final String TEXT_112 = NL + "\t\t\tif (!addFixedChild(childEditPart)) {" + NL + "\t\t\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t\t\t}";
  protected final String TEXT_113 = NL + "\t\t\tsuper.addChildVisual(childEditPart, -1);";
  protected final String TEXT_114 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void removeChildVisual(";
  protected final String TEXT_115 = " childEditPart) {" + NL + "\t\tif (isExternalLabel(childEditPart)) {" + NL + "\t\t\tIFigure labelFigure = ((";
  protected final String TEXT_116 = ") childEditPart).getFigure();" + NL + "\t\t\tgetExternalLabelsContainer().remove(labelFigure);" + NL + "\t\t} else {" + NL + "\t\t\tsuper.removeChildVisual(childEditPart);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isExternalLabel(";
  protected final String TEXT_117 = " childEditPart) {";
  protected final String TEXT_118 = NL + "\t\tif (childEditPart instanceof ";
  protected final String TEXT_119 = ") {" + NL + "\t\t\treturn true;" + NL + "\t\t}";
  protected final String TEXT_120 = NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IFigure getExternalLabelsContainer() {" + NL + "\t\t";
  protected final String TEXT_121 = " root = (";
  protected final String TEXT_122 = ") getRoot();" + NL + "\t\treturn root.getLayer(";
  protected final String TEXT_123 = ".EXTERNAL_NODE_LABELS_LAYER);" + NL + "\t}" + NL;
  protected final String TEXT_124 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void addChildVisual(EditPart childEditPart, int index) {" + NL + "\t\tif (!addFixedChild(childEditPart)) {" + NL + "\t\t\tsuper.addChildVisual(childEditPart, -1);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_125 = NL;
  protected final String TEXT_126 = NL + "}";
  protected final String TEXT_127 = NL;

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
    
GenNode genNode = (GenNode) ((Object[]) argument)[0];
GenDiagram genDiagram = genNode.getDiagram();
boolean useFlowLayout = !genNode.isListLayout();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_5);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
importManager.addImport("org.eclipse.draw2d.BorderLayout");
importManager.addImport("org.eclipse.draw2d.Figure");
importManager.addImport("org.eclipse.draw2d.IFigure");
importManager.addImport("org.eclipse.draw2d.PositionConstants");
importManager.addImport("org.eclipse.draw2d.StackLayout");
importManager.addImport("org.eclipse.gef.EditPolicy");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart");
importManager.addImport("org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles");
importManager.addImport("org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure");
importManager.addImport("org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.emf.ecore.EAnnotation");
importManager.addImport("org.eclipse.gmf.runtime.draw2d.ui.internal.figures.ImageFigureEx");
if (genNode.getViewmap() instanceof InnerClassViewmap) {
importManager.registerInnerClass(((InnerClassViewmap) genNode.getViewmap()).getClassName());
}
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_7);
    {
GenCommonBase genCommonBase = genNode;
    stringBuffer.append(TEXT_8);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genNode.getEditPartClassName());
    stringBuffer.append(TEXT_12);
    
boolean hasChildrenInListCompartments = false;
for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();) {
	GenCompartment compartment = (GenCompartment) compartments.next();
	hasChildrenInListCompartments |= compartment.isListLayout() && !compartment.getChildNodes().isEmpty();
}
if (!genNode.getChildNodes().isEmpty() || hasChildrenInListCompartments) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy"));
    stringBuffer.append(TEXT_14);
    	if (hasChildrenInListCompartments) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_23);
    
		for (Iterator compartments = genNode.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment compartment = (GenCompartment) compartments.next();
			if (compartment.isListLayout() && !compartment.getChildNodes().isEmpty()) {
				for (Iterator children = compartment.getChildNodes().iterator(); children.hasNext(); ) {
					GenNode child = (GenNode) children.next();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(child.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(compartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    
				}
			}
		}

    stringBuffer.append(TEXT_29);
    	}
    stringBuffer.append(TEXT_30);
    }
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genNode.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genNode.getGraphicalNodeEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    if (!genNode.getChildNodes().isEmpty()) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy"));
    stringBuffer.append(TEXT_35);
    }
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(genNode.getCanonicalEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_37);
    if (useFlowLayout) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy"));
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
boolean hasFixedChildren = false;
String figureQualifiedClassName = null;
Viewmap viewmap = genNode.getViewmap();
if (viewmap instanceof FigureViewmap) {
	figureQualifiedClassName = ((FigureViewmap) viewmap).getFigureQualifiedClassName();
	if (figureQualifiedClassName == null || figureQualifiedClassName.trim().length() == 0) {
		figureQualifiedClassName = "org.eclipse.draw2d.RectangleFigure";
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(figureQualifiedClassName));
    stringBuffer.append(TEXT_48);
    if (useFlowLayout) {
    stringBuffer.append(TEXT_49);
    } // use flow layout
    stringBuffer.append(TEXT_50);
    } // instanceof FigureViewmap
 else if (viewmap instanceof SnippetViewmap) {
    stringBuffer.append(TEXT_51);
    stringBuffer.append(((SnippetViewmap) viewmap).getBody());
    stringBuffer.append(TEXT_52);
    } // instanceof SnippetViewmap; FIXME : obtain figure class name to generate getter
 else if (viewmap instanceof InnerClassViewmap) {
 	figureQualifiedClassName = ((InnerClassViewmap) viewmap).getClassName();

    stringBuffer.append(TEXT_53);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(useFlowLayout ? "true" : "false");
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    if (figureQualifiedClassName != null) {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(figureQualifiedClassName);
    stringBuffer.append(TEXT_60);
    
	List innerLabels = new ArrayList(genNode.getLabels().size());
	for (Iterator it = genNode.getLabels().iterator(); it.hasNext(); ) {
		GenNodeLabel genLabel = (GenNodeLabel) it.next();
		if (!(genLabel instanceof GenExternalNodeLabel)) {
			innerLabels.add(genLabel);
		}
	}
	if (!innerLabels.isEmpty()) {
		hasFixedChildren = true;

    stringBuffer.append(TEXT_61);
    
		for (Iterator it = innerLabels.iterator(); it.hasNext(); ) {
			GenNodeLabel genLabel = (GenNodeLabel) it.next();
			String labelEditPart = importManager.getImportedName(genLabel.getEditPartQualifiedClassName());
			String labelFigureClassName = null;
			boolean isAccessor;
			if (genLabel.getViewmap() instanceof InnerClassViewmap) {
				labelFigureClassName = ((InnerClassViewmap) genLabel.getViewmap()).getClassName();
				isAccessor = true;
			} else if (genLabel.getViewmap() instanceof FigureViewmap) {
				labelFigureClassName = ((FigureViewmap) genLabel.getViewmap()).getFigureQualifiedClassName();
				isAccessor = false;
			} else {
				// temp hack to make tests pass
				labelFigureClassName = "org.eclipse.draw2d.Label";
				isAccessor = false;
			}

    stringBuffer.append(TEXT_62);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_63);
    			if (isAccessor) {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(labelFigureClassName);
    stringBuffer.append(TEXT_66);
    			} else {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(labelEditPart);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(labelFigureClassName);
    stringBuffer.append(TEXT_69);
    			}
    stringBuffer.append(TEXT_70);
    		}
    stringBuffer.append(TEXT_71);
    
	}
}

    stringBuffer.append(TEXT_72);
    
int width = 40;
int height = 40;
DefaultSizeAttributes defSizeAttrs = (DefaultSizeAttributes) genNode.getViewmap().find(DefaultSizeAttributes.class);
if (defSizeAttrs != null) {
	width = defSizeAttrs.getWidth();
	height = defSizeAttrs.getHeight();
}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(width);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(height);
    stringBuffer.append(TEXT_75);
    if (genNode.getViewmap().find(ResizeConstraints.class) != null) {
	final ResizeConstraints rc = (ResizeConstraints) genNode.getViewmap().find(ResizeConstraints.class);
	final String draw2dPositionConstraints = importManager.getImportedName("org.eclipse.draw2d.PositionConstants");
	final String javaUtilList = importManager.getImportedName("java.util.List");
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(javaUtilList);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(javaUtilList);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_82);
    for (Iterator it = rc.getResizeHandleNames().iterator(); it.hasNext();) {
					String next = (String) it.next();
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.handles.ResizableHandleKit"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(draw2dPositionConstraints);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(next);
    stringBuffer.append(TEXT_86);
    } for (Iterator it = rc.getNonResizeHandleNames().iterator(); it.hasNext();) {
					String next = (String) it.next();
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.handles.NonResizableHandleKit"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(draw2dPositionConstraints);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(next);
    stringBuffer.append(TEXT_90);
    }
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(javaUtilList);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.handles.MoveHandle"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.handles.MoveHandle"));
    stringBuffer.append(TEXT_95);
    // FIXME file bug against GEF to provide overridable method in ResizableEditPolicy itself
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_98);
    
if (!useFlowLayout) {
	String layoutClassName = importManager.getImportedName("org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout");

    stringBuffer.append(TEXT_99);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(layoutClassName);
    stringBuffer.append(TEXT_101);
    } else {
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.FreeformLayout"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Rectangle"));
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    
if (!genNode.getLabels().isEmpty()) {
	GenNodeLabel primaryLabel = (GenNodeLabel) genNode.getLabels().get(0);

    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName(primaryLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_108);
    
}
boolean hasExternalLabels = false;
for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
	GenNodeLabel label = (GenNodeLabel) labels.next();
	if (label instanceof GenExternalNodeLabel) {
		hasExternalLabels = true;
		break;
	}
}
if (hasExternalLabels) {

    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_111);
    	if (hasFixedChildren) {
    stringBuffer.append(TEXT_112);
    	} else {
    stringBuffer.append(TEXT_113);
    	}
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.GraphicalEditPart"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_117);
    
	for (Iterator labels = genNode.getLabels().iterator(); labels.hasNext();) {
		GenNodeLabel label = (GenNodeLabel) labels.next();
		if (label instanceof GenExternalNodeLabel) {

    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_119);
    
		}
	}

    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartFactoryQualifiedClassName()));
    stringBuffer.append(TEXT_123);
    
} else {
	if (hasFixedChildren) {
    stringBuffer.append(TEXT_124);
    
	}
}
if (genNode.getViewmap() instanceof InnerClassViewmap) {

    stringBuffer.append(TEXT_125);
    stringBuffer.append(((InnerClassViewmap) genNode.getViewmap()).getClassBody());
    }
    stringBuffer.append(TEXT_126);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_127);
    return stringBuffer.toString();
  }
}
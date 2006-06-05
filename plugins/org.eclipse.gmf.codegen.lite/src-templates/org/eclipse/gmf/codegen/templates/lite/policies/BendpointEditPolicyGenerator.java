package org.eclipse.gmf.codegen.templates.lite.policies;

import org.eclipse.gmf.common.codegen.*;
import org.eclipse.gmf.codegen.gmfgen.*;

public class BendpointEditPolicyGenerator
{
  protected static String nl;
  public static synchronized BendpointEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    BendpointEditPolicyGenerator result = new BendpointEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class BendpointEditPolicy extends ";
  protected final String TEXT_3 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_4 = " getDiagramEdge() {" + NL + "\t\treturn (";
  protected final String TEXT_5 = ")getHost().getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_6 = " getCreateBendpointCommand(";
  protected final String TEXT_7 = " request) {" + NL + "\t\treturn getModifyBendpointCommand(new BendpointCreator(request.getIndex(), request.getLocation()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_8 = " getDeleteBendpointCommand(";
  protected final String TEXT_9 = " request) {" + NL + "\t\treturn getModifyBendpointCommand(new BendpointDeleter(request.getIndex()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_10 = " getMoveBendpointCommand(";
  protected final String TEXT_11 = " request) {" + NL + "\t\treturn getModifyBendpointCommand(new BendpointMover(request.getIndex(), request.getLocation()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_12 = " getModifyBendpointCommand(final BendpointModifier modifier) {" + NL + "\t\t";
  protected final String TEXT_13 = " editingDomain = ";
  protected final String TEXT_14 = ".getEditingDomain(getDiagramEdge().getDiagram().getElement());" + NL + "\t\treturn new ";
  protected final String TEXT_15 = "(editingDomain, new BendpointModificationCommand(modifier));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class BendpointModificationCommand extends ";
  protected final String TEXT_16 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate BendpointModifier bendpointModifier; " + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_17 = " oldPoints;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic BendpointModificationCommand(BendpointModifier bendpointModifier) {" + NL + "\t\t\tthis.bendpointModifier = bendpointModifier;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t";
  protected final String TEXT_18 = " connection = getConnection();" + NL + "\t\t\tfinal ";
  protected final String TEXT_19 = " ptRef1 = connection.getSourceAnchor().getReferencePoint().getCopy();" + NL + "\t\t\tconnection.translateToRelative(ptRef1);" + NL + "\t\t\tfinal ";
  protected final String TEXT_20 = " ptRef2 = connection.getTargetAnchor().getReferencePoint().getCopy();" + NL + "\t\t\tconnection.translateToRelative(ptRef2);" + NL + "\t\t\t";
  protected final String TEXT_21 = " bendpoints = (";
  protected final String TEXT_22 = ") getDiagramEdge().getBendpoints();" + NL + "\t\t\tif (bendpoints == null) {" + NL + "\t\t\t\tbendpoints = ";
  protected final String TEXT_23 = ".eINSTANCE.createRelativeBendpoints();" + NL + "\t\t\t\tgetDiagramEdge().setBendpoints(bendpoints);" + NL + "\t\t\t}" + NL + "\t\t\toldPoints = bendpoints.getPoints();" + NL + "\t\t\t";
  protected final String TEXT_24 = " newPoints = new ";
  protected final String TEXT_25 = "(oldPoints);" + NL + "\t\t\tbendpointModifier.applyModification(newPoints, new BendpointConverter() {" + NL + "\t\t\t\tpublic ";
  protected final String TEXT_26 = " convert(";
  protected final String TEXT_27 = " point) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_28 = " s = point.getDifference(ptRef1);" + NL + "\t\t\t\t\t";
  protected final String TEXT_29 = " t = point.getDifference(ptRef2);" + NL + "\t\t\t\t\treturn new ";
  protected final String TEXT_30 = "(s.width, s.height, t.width, t.height);" + NL + "\t\t\t\t}" + NL + "\t\t\t});" + NL + "\t\t\tbendpoints.setPoints(newPoints);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void undo() {" + NL + "\t\t\t";
  protected final String TEXT_31 = " bendpoints = (";
  protected final String TEXT_32 = ") getDiagramEdge().getBendpoints();" + NL + "\t\t\tbendpoints.setPoints(oldPoints);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canExecute() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static interface BendpointConverter {" + NL + "\t\tpublic ";
  protected final String TEXT_33 = " convert(";
  protected final String TEXT_34 = " point);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static interface BendpointModifier {" + NL + "\t\tpublic void applyModification(";
  protected final String TEXT_35 = "/*<";
  protected final String TEXT_36 = ">*/ originalBendpoints, BendpointConverter converter);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class BendpointDeleter implements BendpointModifier {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate int index;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic BendpointDeleter(int index) {" + NL + "\t\t\tthis.index = index;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void applyModification(";
  protected final String TEXT_37 = " originalBendpoints, BendpointConverter converter) {" + NL + "\t\t\toriginalBendpoints.remove(index);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class BendpointMover implements BendpointModifier {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate int index;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_38 = " point;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic BendpointMover(int index, ";
  protected final String TEXT_39 = " point) {" + NL + "\t\t\tthis.index = index;" + NL + "\t\t\tthis.point = point;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void applyModification(";
  protected final String TEXT_40 = " originalBendpoints, BendpointConverter converter) {" + NL + "\t\t\toriginalBendpoints.set(index, converter.convert(point));" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class BendpointCreator implements BendpointModifier {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate int index;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_41 = " point;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic BendpointCreator(int index, ";
  protected final String TEXT_42 = " point) {" + NL + "\t\t\tthis.index = index;" + NL + "\t\t\tthis.point = point;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void applyModification(";
  protected final String TEXT_43 = " originalBendpoints, BendpointConverter converter) {" + NL + "\t\t\toriginalBendpoints.add(index, converter.convert(point));" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_44 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editpolicies.BendpointEditPolicy"));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.BendpointRequest"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.BendpointRequest"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.BendpointRequest"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartsPackageName() + ".WrappingCommand"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.Connection"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Dimension"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.RelativeBendpoints"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.draw2d.geometry.Point"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_43);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_44);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.lite.commands;

import org.eclipse.gmf.common.codegen.*;

public class ReplaceNotationalElementCommandGenerator
{
  protected static String nl;
  public static synchronized ReplaceNotationalElementCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ReplaceNotationalElementCommandGenerator result = new ReplaceNotationalElementCommandGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ReplaceNotationalElementCommand extends ";
  protected final String TEXT_4 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final CreateNotationalElementCommand createCommand;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final RemoveNotationalElementCommand removeCommand;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ";
  protected final String TEXT_5 = " obsoleteView;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ReplaceNotationalElementCommand(";
  protected final String TEXT_6 = " parentView, CreateNotationalElementCommand createCommand, ";
  protected final String TEXT_7 = " obsoleteView) {" + NL + "\t\tthis.createCommand = createCommand;" + NL + "\t\tthis.obsoleteView = obsoleteView;" + NL + "\t\tthis.removeCommand = obsoleteView instanceof ";
  protected final String TEXT_8 = " ? new RemoveNotationalEdgeCommand(parentView, obsoleteView) : new RemoveNotationalElementCommand(parentView, obsoleteView);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canExecute() {" + NL + "\t\treturn createCommand != null && createCommand.canExecute() && removeCommand != null && removeCommand.canExecute();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canUndo() {" + NL + "\t\treturn createCommand != null && createCommand.canUndo() && removeCommand != null && removeCommand.canUndo();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void execute() {" + NL + "\t\tcreateCommand.execute();" + NL + "\t\tremoveCommand.execute();" + NL + "\t\t";
  protected final String TEXT_9 = " createdView = createCommand.getCreatedView();" + NL + "//\t\tcreatedView.getSourceEdges().addAll(obsoleteView.getSourceEdges());" + NL + "//\t\tcreatedView.getTargetEdges().addAll(obsoleteView.getTargetEdges());" + NL + "\t\tif (createdView != null && obsoleteView != null && createdView.eClass().equals(obsoleteView.eClass())) {" + NL + "\t\t\tif (";
  protected final String TEXT_10 = ".eINSTANCE.getNode().equals(createdView.eClass())) {" + NL + "\t\t\t\tcopy(obsoleteView, createdView, ";
  protected final String TEXT_11 = ".eINSTANCE.getNode_LayoutConstraint());" + NL + "\t\t\t} else if (";
  protected final String TEXT_12 = ".eINSTANCE.getEdge().equals(createdView.eClass())) {" + NL + "\t\t\t\tcopy(obsoleteView, createdView, ";
  protected final String TEXT_13 = ".eINSTANCE.getEdge_Bendpoints());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void copy(";
  protected final String TEXT_14 = " source, ";
  protected final String TEXT_15 = " target, ";
  protected final String TEXT_16 = " feature) {" + NL + "\t\t";
  protected final String TEXT_17 = " oldValue = (";
  protected final String TEXT_18 = ") source.eGet(feature);" + NL + "\t\tif (oldValue == null) {" + NL + "\t\t\treturn;\t//nothing to copy" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_19 = " newValue = (";
  protected final String TEXT_20 = ") target.eGet(feature);" + NL + "\t\tif (newValue != null && !newValue.eClass().equals(oldValue.eClass())) {" + NL + "\t\t\treturn;\t//incompatible instances." + NL + "\t\t}" + NL + "\t\ttarget.eSet(feature, oldValue);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void undo() {" + NL + "\t\t";
  protected final String TEXT_21 = " createdView = createCommand.getCreatedView();" + NL + "\t\tif (createdView != null && obsoleteView != null && createdView.eClass().equals(obsoleteView.eClass())) {" + NL + "\t\t\tif (";
  protected final String TEXT_22 = ".eINSTANCE.getNode().equals(createdView.eClass())) {" + NL + "\t\t\t\tcopy(obsoleteView, createdView, ";
  protected final String TEXT_23 = ".eINSTANCE.getNode_LayoutConstraint());" + NL + "\t\t\t} else if (";
  protected final String TEXT_24 = ".eINSTANCE.getEdge().equals(createdView.eClass())) {" + NL + "\t\t\t\tcopy(obsoleteView, createdView, ";
  protected final String TEXT_25 = ".eINSTANCE.getEdge_Bendpoints());" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "//\t\tobsoleteView.getSourceEdges().addAll(createdView.getSourceEdges());" + NL + "//\t\tobsoleteView.getTargetEdges().addAll(createdView.getTargetEdges());" + NL + "\t\tremoveCommand.undo();" + NL + "\t\tcreateCommand.undo();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void redo() {" + NL + "\t\texecute();" + NL + "\t}" + NL + "}";
  protected final String TEXT_26 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_2);
    
importManager.emitPackageStatement(stringBuffer);
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EStructuralFeature"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_25);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_26);
    return stringBuffer.toString();
  }
}

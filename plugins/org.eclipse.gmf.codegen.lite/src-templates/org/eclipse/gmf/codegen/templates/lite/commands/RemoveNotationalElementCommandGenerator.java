package org.eclipse.gmf.codegen.templates.lite.commands;

import org.eclipse.gmf.common.codegen.*;

public class RemoveNotationalElementCommandGenerator
{
  protected static String nl;
  public static synchronized RemoveNotationalElementCommandGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    RemoveNotationalElementCommandGenerator result = new RemoveNotationalElementCommandGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class RemoveNotationalElementCommand extends ";
  protected final String TEXT_4 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ";
  protected final String TEXT_5 = " childView;" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final ";
  protected final String TEXT_6 = " parentView;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " domainElement;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_8 = " removeEdgeCommands;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic RemoveNotationalElementCommand(";
  protected final String TEXT_9 = " parentView, ";
  protected final String TEXT_10 = " childView) {" + NL + "\t\tthis.parentView = parentView;" + NL + "\t\tthis.childView = childView;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean prepare() {" + NL + "\t\tif (!parentView.getChildren().contains(childView)) {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "\t\tremoveEdgeCommands = new ";
  protected final String TEXT_11 = "();" + NL + "\t\tfor(";
  protected final String TEXT_12 = " it = childView.getSourceEdges().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_13 = " next = (";
  protected final String TEXT_14 = ") it.next();" + NL + "\t\t\tremoveEdgeCommands.append(new RemoveNotationalEdgeCommand(childView.getDiagram(), next));" + NL + "\t\t}" + NL + "\t\tfor(Iterator it = childView.getTargetEdges().iterator(); it.hasNext(); ) {" + NL + "\t\t\t";
  protected final String TEXT_15 = " next = (";
  protected final String TEXT_16 = ") it.next();" + NL + "\t\t\tremoveEdgeCommands.append(new RemoveNotationalEdgeCommand(childView.getDiagram(), next));" + NL + "\t\t}" + NL + "\t\treturn removeEdgeCommands.canExecute();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean canUndo() {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void execute() {" + NL + "\t\tparentView.removeChild(childView);" + NL + "\t\tremoveEdgeCommands.execute();" + NL + "\t\tsweepElement();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void sweepElement() {" + NL + "\t\tif (childView.isSetElement()) {" + NL + "\t\t\tdomainElement = childView.getElement();" + NL + "\t\t\tchildView.setElement(null);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void redo() {" + NL + "\t\texecute();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void undo() {" + NL + "\t\trestoreElement();" + NL + "\t\tremoveEdgeCommands.undo();" + NL + "\t\tparentView.insertChild(childView);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void restoreElement() {" + NL + "\t\tif (childView.isSetElement()) {" + NL + "\t\t\tchildView.setElement(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final ";
  protected final String TEXT_17 = " getChildView() {" + NL + "\t\treturn childView;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final ";
  protected final String TEXT_18 = " getParent() {" + NL + "\t\treturn parentView;" + NL + "\t}" + NL + "}";
  protected final String TEXT_19 = NL;

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
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.CompoundCommand"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_18);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}

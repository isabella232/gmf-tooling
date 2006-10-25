package org.eclipse.gmf.codegen.templates.parts;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramEditPartGenerator
{
  protected static String nl;
  public static synchronized DiagramEditPartGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramEditPartGenerator result = new DiagramEditPartGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic final static String MODEL_ID = \"";
  protected final String TEXT_8 = "\"; //$NON-NLS-1$";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final int VISUAL_ID = ";
  protected final String TEXT_11 = ";";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_13 = "(View view) {" + NL + "\t\tsuper(view);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void createDefaultEditPolicies() {" + NL + "\t\tsuper.createDefaultEditPolicies();" + NL + "\t\tinstallEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ";
  protected final String TEXT_14 = "());";
  protected final String TEXT_15 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new ";
  protected final String TEXT_16 = "());";
  protected final String TEXT_17 = NL + "\t\tinstallEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new ";
  protected final String TEXT_18 = "() {" + NL + "\t\t\tpublic ";
  protected final String TEXT_19 = " getDropObjectsCommand(";
  protected final String TEXT_20 = " dropRequest) {" + NL + "\t\t\t\t";
  protected final String TEXT_21 = " viewDescriptors = new ";
  protected final String TEXT_22 = "();" + NL + "\t\t\t\tfor(";
  protected final String TEXT_23 = " it = dropRequest.getObjects().iterator(); it.hasNext();) {" + NL + "\t\t\t\t\tviewDescriptors.add(new ";
  protected final String TEXT_24 = ".ViewDescriptor(new ";
  protected final String TEXT_25 = "((";
  protected final String TEXT_26 = ") it.next()), ";
  protected final String TEXT_27 = ".class, null, getDiagramPreferencesHint()));" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\treturn createShortcutsCommand(dropRequest, viewDescriptors);" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tprivate ";
  protected final String TEXT_28 = " createShortcutsCommand(";
  protected final String TEXT_29 = " dropRequest, ";
  protected final String TEXT_30 = " viewDescriptors) {" + NL + "\t\t\t\t";
  protected final String TEXT_31 = " command = createViewsAndArrangeCommand(dropRequest, viewDescriptors);" + NL + "\t\t\t\tif (command != null) {" + NL + "\t\t\t\t\treturn command.chain(new ";
  protected final String TEXT_32 = "(new ";
  protected final String TEXT_33 = "(getEditingDomain(), (";
  protected final String TEXT_34 = ") getModel(), viewDescriptors)));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = NL + "\t\tinstallEditPolicy(\"";
  protected final String TEXT_37 = "\", new ";
  protected final String TEXT_38 = "()); //$NON-NLS-1$";
  protected final String TEXT_39 = NL + "\t}" + NL + "}";
  protected final String TEXT_40 = NL;

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
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_8);
    {	GenCommonBase genCommonBase = genDiagram;
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genCommonBase.getVisualID());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getEditPartClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    if (genDiagram.needsCanonicalEditPolicy()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCanonicalEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    }

if (genDiagram.generateCreateShortcutAction() && genDiagram.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editpolicies.DiagramDragDropEditPolicy"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getCreateShortcutDecorationsCommandQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_34);
    }

{	GenCommonBase genCommonBase = genDiagram;
    stringBuffer.append(TEXT_35);
    
for (CustomBehaviour behaviour : genCommonBase.getBehaviour(CustomBehaviour.class)) {

    stringBuffer.append(TEXT_36);
    stringBuffer.append(behaviour.getKey());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(behaviour.getEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    }
    }
    stringBuffer.append(TEXT_39);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_40);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.lite.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class OpenDiagramPolicyGenerator
{
  protected static String nl;
  public static synchronized OpenDiagramPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    OpenDiagramPolicyGenerator result = new OpenDiagramPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_8 = " getOpenCommand(";
  protected final String TEXT_9 = " openRequest) {" + NL + "\t\t";
  protected final String TEXT_10 = " targetEditPart = getTargetEditPart(openRequest);" + NL + "\t\tif (false == targetEditPart.getModel() instanceof ";
  protected final String TEXT_11 = ") {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_12 = " view = (";
  protected final String TEXT_13 = ") targetEditPart.getModel();" + NL + "\t\treturn getOpenCommand(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_14 = " getOpenCommand(";
  protected final String TEXT_15 = " view) {" + NL + "\t\t";
  protected final String TEXT_16 = " annotation = view.getEAnnotation(\"";
  protected final String TEXT_17 = "\");" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_18 = " domain = ";
  protected final String TEXT_19 = ".getEditingDomain(annotation);" + NL + "\t\t";
  protected final String TEXT_20 = " result = new OpenDiagramCommand(annotation);" + NL + "\t\treturn new ";
  protected final String TEXT_21 = "(domain, result);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static class OpenDiagramCommand extends ";
  protected final String TEXT_22 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_23 = " myAnnotation;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected OpenDiagramCommand(";
  protected final String TEXT_24 = " annotation) {" + NL + "\t\t\tmyAnnotation = annotation;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t";
  protected final String TEXT_25 = " diagramToOpen = getDiagramToOpen();" + NL + "\t\t\tif (diagramToOpen == null) {" + NL + "\t\t\t\tdiagramToOpen = createNewDiagram();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_26 = " diagramURI = ";
  protected final String TEXT_27 = ".getURI(diagramToOpen);" + NL + "\t\t\t";
  protected final String TEXT_28 = " page = ";
  protected final String TEXT_29 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage();";
  protected final String TEXT_30 = NL + "\t\t\t";
  protected final String TEXT_31 = " editorInput = new ";
  protected final String TEXT_32 = "(diagramURI);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tpage.openEditor(editorInput, getEditorID());" + NL + "\t\t\t} catch (";
  protected final String TEXT_33 = " e) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Can't open diagram\", e);" + NL + "\t\t\t}";
  protected final String TEXT_34 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_35 = " diagramView = (";
  protected final String TEXT_36 = ")page.showView(getViewID());" + NL + "\t\t\t\tdiagramView.showDiagram(null, diagramURI);" + NL + "\t\t\t} catch (";
  protected final String TEXT_37 = " e) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Can't open diagram\", e);" + NL + "\t\t\t}";
  protected final String TEXT_38 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_39 = " getDiagramToOpen() {" + NL + "\t\t\t// take first that matches the given model ID." + NL + "\t\t\tfor (";
  protected final String TEXT_40 = " it = myAnnotation.getReferences().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\tObject next = it.next();" + NL + "\t\t\t\tif (next instanceof ";
  protected final String TEXT_41 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_42 = " result = (";
  protected final String TEXT_43 = ") next;" + NL + "\t\t\t\t\tif (result.getType().equals(getDiagramKind())) {" + NL + "\t\t\t\t\t\treturn result;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_44 = " createNewDiagram() {" + NL + "\t\t\t";
  protected final String TEXT_45 = " result = ";
  protected final String TEXT_46 = ".eINSTANCE.createDiagram();" + NL + "\t\t\tmyAnnotation.getReferences().add(result);" + NL + "\t\t\tresult.setElement(getDiagramDomainElement());" + NL + "\t\t\taddToResource(result);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tfor (";
  protected final String TEXT_47 = " it = myAnnotation.eResource().getResourceSet().getResources().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = " next = (";
  protected final String TEXT_49 = ") it.next();" + NL + "\t\t\t\t\tif (next.isLoaded() && !";
  protected final String TEXT_50 = ".isReadOnly(next)) {" + NL + "\t\t\t\t\t\tnext.save(";
  protected final String TEXT_51 = ".getSaveOptions());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (";
  protected final String TEXT_52 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_53 = NL + "\t\t\t\tthrow new RuntimeException(\"Can't create diagram of '\" + getDiagramKind() + \"' kind\", e);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns the element that should be the underlying model element for the diagram." + NL + "\t\t * By default, the element associated with the edit part is returned." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_54 = " getDiagramDomainElement() {" + NL + "\t\t\treturn ((";
  protected final String TEXT_55 = ") myAnnotation.getEModelElement()).getElement();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Adds the created diagram to a resource. By default, the diagram is added to the resource which contains the annotation." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void addToResource(";
  protected final String TEXT_56 = " diagram) {" + NL + "\t\t\tassert diagram.eResource() == null;" + NL + "\t\t\tassert myAnnotation.eResource() != null;" + NL + "\t\t\tmyAnnotation.eResource().getContents().add(diagram);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getDiagramKind() {";
  protected final String TEXT_57 = NL + "\t\t\treturn ";
  protected final String TEXT_58 = ".MODEL_ID;";
  protected final String TEXT_59 = NL + "\t\t\treturn \"";
  protected final String TEXT_60 = "\";";
  protected final String TEXT_61 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */";
  protected final String TEXT_62 = NL + "\t\tprotected String getEditorID() {";
  protected final String TEXT_63 = NL + "\t\tprotected String getViewID() {";
  protected final String TEXT_64 = NL + "\t\t\treturn ";
  protected final String TEXT_65 = ".ID;";
  protected final String TEXT_66 = NL + "\t\t\treturn \"";
  protected final String TEXT_67 = "\";";
  protected final String TEXT_68 = NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_69 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final OpenDiagramBehaviour behaviour = (OpenDiagramBehaviour) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = behaviour.getSubject().getDiagram();
final boolean openAsEditor = behaviour.isOpenAsEclipseEditor();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.registerInnerClass("OpenDiagramCommand");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.OpenDiagramEditPolicy"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(org.eclipse.gmf.codegen.gmfgen.impl.OpenDiagramBehaviourImpl.ANNOTATION_SOURCE);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_29);
    
if (openAsEditor) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_33);
    
} else {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_37);
    
}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_52);
    /*XXX: Throwing runtime exceptions is definitely not the most elegant way*/
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_56);
    if (behaviour.getDiagramKind() == null) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_58);
    } else {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(behaviour.getDiagramKind());
    stringBuffer.append(TEXT_60);
    }
    stringBuffer.append(TEXT_61);
    
if (openAsEditor) {

    stringBuffer.append(TEXT_62);
    
} else {

    stringBuffer.append(TEXT_63);
    
}

    if (behaviour.getEditorID() == null) { 
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(behaviour.getEditorID());
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}

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
  protected final String TEXT_1 = "/*" + NL + " * ";
  protected final String TEXT_2 = NL + " */";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_7 = " getOpenCommand(";
  protected final String TEXT_8 = " openRequest) {" + NL + "\t\t";
  protected final String TEXT_9 = " targetEditPart = getTargetEditPart(openRequest);" + NL + "\t\tif (false == targetEditPart.getModel() instanceof ";
  protected final String TEXT_10 = ") {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_11 = " view = (";
  protected final String TEXT_12 = ") targetEditPart.getModel();" + NL + "\t\treturn getOpenCommand(view);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_13 = " getOpenCommand(";
  protected final String TEXT_14 = " view) {" + NL + "\t\t";
  protected final String TEXT_15 = " linkStyle = view.getStyle(";
  protected final String TEXT_16 = ".eINSTANCE.getHintedDiagramLinkStyle());" + NL + "\t\tif (false == linkStyle instanceof ";
  protected final String TEXT_17 = ") {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_18 = " domain = ";
  protected final String TEXT_19 = ".getEditingDomain(linkStyle);" + NL + "\t\t";
  protected final String TEXT_20 = " result = new OpenDiagramCommand((";
  protected final String TEXT_21 = ") linkStyle);" + NL + "\t\treturn new ";
  protected final String TEXT_22 = "(domain, result);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected static class OpenDiagramCommand extends ";
  protected final String TEXT_23 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final ";
  protected final String TEXT_24 = " myDiagramLink;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected OpenDiagramCommand(";
  protected final String TEXT_25 = " linkStyle) {" + NL + "\t\t\tmyDiagramLink = linkStyle;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean prepare() {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void execute() {" + NL + "\t\t\t";
  protected final String TEXT_26 = " diagramToOpen = getDiagramToOpen();" + NL + "\t\t\tif (diagramToOpen == null) {" + NL + "\t\t\t\tdiagramToOpen = createNewDiagram();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_27 = " diagramURI = ";
  protected final String TEXT_28 = ".getURI(diagramToOpen);" + NL + "\t\t\t";
  protected final String TEXT_29 = " page = ";
  protected final String TEXT_30 = ".getWorkbench().getActiveWorkbenchWindow().getActivePage();";
  protected final String TEXT_31 = NL + "\t\t\t";
  protected final String TEXT_32 = " editorInput = new ";
  protected final String TEXT_33 = "(diagramURI);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tpage.openEditor(editorInput, getEditorID());" + NL + "\t\t\t} catch (";
  protected final String TEXT_34 = " e) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Can't open diagram\", e);" + NL + "\t\t\t}";
  protected final String TEXT_35 = NL + "\t\t\ttry {" + NL + "\t\t\t\t";
  protected final String TEXT_36 = " diagramView = (";
  protected final String TEXT_37 = ")page.showView(getViewID());" + NL + "\t\t\t\tdiagramView.showDiagram(null, diagramURI);" + NL + "\t\t\t} catch (";
  protected final String TEXT_38 = " e) {" + NL + "\t\t\t\tthrow new RuntimeException(\"Can't open diagram\", e);" + NL + "\t\t\t}";
  protected final String TEXT_39 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void redo() {" + NL + "\t\t\texecute();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canUndo() {" + NL + "\t\t\treturn false;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_40 = " getDiagramToOpen() {" + NL + "\t\t\t";
  protected final String TEXT_41 = " result = myDiagramLink.getDiagramLink();" + NL + "\t\t\t// take first that matches the given model ID." + NL + "\t\t\tif (result != null && result.getType().equals(getDiagramKind())) {" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_42 = " createNewDiagram() {" + NL + "\t\t\t";
  protected final String TEXT_43 = " result = ";
  protected final String TEXT_44 = ".eINSTANCE.createDiagram();" + NL + "\t\t\tmyDiagramLink.setDiagramLink(result);" + NL + "\t\t\tresult.setElement(getDiagramDomainElement());" + NL + "\t\t\taddToResource(result);" + NL + "\t\t\ttry {" + NL + "\t\t\t\tfor (";
  protected final String TEXT_45 = " it = myDiagramLink.eResource().getResourceSet().getResources().iterator(); it.hasNext(); ) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_46 = " next = (";
  protected final String TEXT_47 = ") it.next();" + NL + "\t\t\t\t\tif (next.isLoaded() && !";
  protected final String TEXT_48 = ".isReadOnly(next)) {" + NL + "\t\t\t\t\t\tnext.save(";
  protected final String TEXT_49 = ".getSaveOptions());" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t} catch (";
  protected final String TEXT_50 = " e) {" + NL + "\t\t\t\t";
  protected final String TEXT_51 = NL + "\t\t\t\tthrow new RuntimeException(\"Can't create diagram of '\" + getDiagramKind() + \"' kind\", e);" + NL + "\t\t\t}" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Returns the element that should be the underlying model element for the diagram." + NL + "\t\t * By default, the element associated with the edit part is returned." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_52 = " getDiagramDomainElement() {" + NL + "\t\t\treturn ((";
  protected final String TEXT_53 = ") myDiagramLink.eContainer()).getElement();" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * Adds the created diagram to a resource. By default, the diagram is added to the resource which contains the initiating diagram." + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected void addToResource(";
  protected final String TEXT_54 = " diagram) {" + NL + "\t\t\tassert diagram.eResource() == null;" + NL + "\t\t\tassert myDiagramLink.eResource() != null;" + NL + "\t\t\tmyDiagramLink.eResource().getContents().add(diagram);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected String getDiagramKind() {";
  protected final String TEXT_55 = NL + "\t\t\treturn ";
  protected final String TEXT_56 = ".MODEL_ID;";
  protected final String TEXT_57 = NL + "\t\t\treturn \"";
  protected final String TEXT_58 = "\";";
  protected final String TEXT_59 = NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */";
  protected final String TEXT_60 = NL + "\t\tprotected String getEditorID() {";
  protected final String TEXT_61 = NL + "\t\tprotected String getViewID() {";
  protected final String TEXT_62 = NL + "\t\t\treturn ";
  protected final String TEXT_63 = ".ID;";
  protected final String TEXT_64 = NL + "\t\t\treturn \"";
  protected final String TEXT_65 = "\";";
  protected final String TEXT_66 = NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_67 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final OpenDiagramBehaviour behaviour = (OpenDiagramBehaviour) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = behaviour.getSubject().getDiagram();
final boolean openAsEditor = behaviour.isOpenAsEclipseEditor();

    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_2);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_3);
    
importManager.registerInnerClass("OpenDiagramCommand");
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.edit.policies.OpenDiagramEditPolicy"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Style"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationPackage"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.TransactionalEditingDomain"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.transaction.util.TransactionUtil"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.Command"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.commands.WrappingCommand"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.command.AbstractCommand"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle"));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle"));
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.util.EcoreUtil"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IWorkbenchPage"));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PlatformUI"));
    stringBuffer.append(TEXT_30);
    
if (openAsEditor) {

    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.IEditorInput"));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.ui.URIEditorInput"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_34);
    
} else {

    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.parts.DiagramViewPart"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.PartInitException"));
    stringBuffer.append(TEXT_38);
    
}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.NotationFactory"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.Resource"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDiagramEditorUtilQualifiedClassName()));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("java.io.IOException"));
    stringBuffer.append(TEXT_50);
    /*XXX: Throwing runtime exceptions is definitely not the most elegant way*/
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_54);
    if (behaviour.getDiagramKind() == null) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_56);
    } else {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(behaviour.getDiagramKind());
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    
if (openAsEditor) {

    stringBuffer.append(TEXT_60);
    
} else {

    stringBuffer.append(TEXT_61);
    
}

    if (behaviour.getEditorID() == null) { 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getEditor().getQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    stringBuffer.append(behaviour.getEditorID());
    stringBuffer.append(TEXT_65);
    }
    stringBuffer.append(TEXT_66);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_67);
    return stringBuffer.toString();
  }
}

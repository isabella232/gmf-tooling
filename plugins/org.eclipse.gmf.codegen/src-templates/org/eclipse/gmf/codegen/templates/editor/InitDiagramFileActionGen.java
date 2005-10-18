package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class InitDiagramFileActionGen
{
  protected static String nl;
  public static synchronized InitDiagramFileActionGen create(String lineSeparator)
  {
    nl = lineSeparator;
    InitDiagramFileActionGen result = new InitDiagramFileActionGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + "import java.io.IOException;" + NL + "import java.util.Collection;" + NL + "import java.util.Collections;" + NL + "import java.util.HashMap;" + NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.Map;" + NL + "" + NL + "import org.eclipse.core.resources.IFile;" + NL + "import org.eclipse.core.resources.IResource;" + NL + "import org.eclipse.core.resources.ResourcesPlugin;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IStatus;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.emf.common.util.URI;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.emf.ecore.resource.Resource;" + NL + "import org.eclipse.emf.ecore.resource.ResourceSet;" + NL + "import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;" + NL + "import org.eclipse.gmf.runtime.diagram.core.internal.services.view.ViewService;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;" + NL + "import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.IElementType;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.Node;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.action.IAction;" + NL + "import org.eclipse.jface.dialogs.IInputValidator;" + NL + "import org.eclipse.jface.dialogs.InputDialog;" + NL + "import org.eclipse.jface.dialogs.MessageDialog;" + NL + "import org.eclipse.jface.viewers.ISelection;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.swt.widgets.Shell;" + NL + "import org.eclipse.ui.IObjectActionDelegate;" + NL + "import org.eclipse.ui.IWorkbenchPart;" + NL + "import org.eclipse.ui.PartInitException;" + NL + "import org.eclipse.ui.ide.IDE;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " implements IObjectActionDelegate, IInputValidator {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "    private static final String FILE_EXT = \"";
  protected final String TEXT_6 = "\";" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IWorkbenchPart myPart;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFile mySelection;" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map myLinkWithClassVID2EObject = new HashMap();" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map myEObject2NodeMap = new HashMap();" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyPart = targetPart;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate Shell getShell() {" + NL + "\t\treturn myPart.getSite().getShell();" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelection = null;" + NL + "\t\taction.setEnabled(false);" + NL + "\t\tif (selection instanceof IStructuredSelection == false || selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tmySelection = (IFile) ((IStructuredSelection) selection).getFirstElement();" + NL + "\t\taction.setEnabled(true);" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */\t" + NL + "\tpublic String isValid(String newText) {" + NL + "\t\tIStatus status = ResourcesPlugin.getWorkspace().validateName(newText, IResource.FILE);" + NL + "\t\tif (!status.isOK()) {" + NL + "\t\t\treturn status.getMessage();" + NL + "\t\t}" + NL + "\t\tif (mySelection.getParent().getFile(new Path(newText).addFileExtension(FILE_EXT)).exists()) {" + NL + "\t\t\treturn \"File already exists, choose another name\";" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tfinal InputDialog outputFileNameDialog = new InputDialog(getShell(), \"Diagram file name\", \"Please provide diagram file name\", mySelection.getProjectRelativePath().removeFileExtension().addFileExtension(FILE_EXT).lastSegment(), this);" + NL + "\t\tif (outputFileNameDialog.open() != InputDialog.OK) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tfinal EObject diagramModelObject = load();" + NL + "\t\tif (diagramModelObject == null) {" + NL + "\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to load user model\");" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tOperationUtil.runAsUnchecked(new MRunnable() {" + NL + "\t\t\tpublic Object run() {" + NL + "\t\t\t\tEObject diagram = create(diagramModelObject);" + NL + "\t\t\t\tif (diagram == null) {" + NL + "\t\t\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to create diagram object\");" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tIFile destFile = mySelection.getParent().getFile(new Path(outputFileNameDialog.getValue()));" + NL + "\t\t\t\tsave(destFile.getLocation().toOSString(), diagram);" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tIDE.openEditor(myPart.getSite().getPage(), destFile);" + NL + "\t\t\t\t} catch (PartInitException ex) {" + NL + "\t\t\t\t\tex.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate EObject load() {" + NL + "\t\tResourceSet resourceSet = new ResourceSetImpl();" + NL + "\t\tResource resource = resourceSet.getResource(URI.createPlatformResourceURI(mySelection.getFullPath().toString()), true);" + NL + "\t\ttry {" + NL + "\t\t\tresource.load(Collections.EMPTY_MAP);" + NL + "\t\t\treturn (EObject) resource.getContents().get(0);" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\tex.printStackTrace();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void save(String filePath, EObject canvas) {" + NL + "\t\tResource resource = ResourceUtil.create(filePath, null);" + NL + "\t\tresource.getContents().add(((Diagram) canvas).getElement());" + NL + "\t\tresource.getContents().add(canvas);" + NL + "\t\ttry {" + NL + "\t\t\tresource.save(Collections.EMPTY_MAP);" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\tex.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate EObject create(EObject diagramModel) {" + NL + "\t\tint diagramVID = ";
  protected final String TEXT_7 = ".INSTANCE.getDiagramVisualID(diagramModel);" + NL + "\t\tif (diagramVID == -1) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tmyLinkWithClassVID2EObject.clear();" + NL + "\t\tmyEObject2NodeMap.clear();";
  protected final String TEXT_8 = NL + "\t\tmyLinkWithClassVID2EObject.put(new Integer(";
  protected final String TEXT_9 = "), new LinkedList());";
  protected final String TEXT_10 = NL + "\t\tDiagram diagram = DiagramUtil.createDiagram(diagramModel, \"";
  protected final String TEXT_11 = "\", ";
  protected final String TEXT_12 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tcreateDiagramChildren(diagram, diagramModel);" + NL + "\t\t" + NL + "\t\tcreateLinks();" + NL + "\t\t" + NL + "\t    return diagram;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void createDiagramChildren(Diagram diagram, EObject diagramObject) {" + NL + "\t\tfor (Iterator it = diagramObject.eContents().iterator(); it.hasNext();) {" + NL + "\t\t\tEObject nextChild = (EObject) it.next();" + NL + "\t\t\tstoreLinkReferenceOnly(nextChild);" + NL + "\t\t\tint nodeVID = ";
  protected final String TEXT_13 = ".INSTANCE.getNodeVisualID(nextChild);" + NL + "\t\t\tif (nodeVID == -1) {" + NL + "\t\t\t\tstoreLinkWithClass(nextChild);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tNode nextNode = DiagramUtil.createNode(diagram, nextChild, null, ";
  protected final String TEXT_14 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tmyEObject2NodeMap.put(nextChild, nextNode);" + NL + "\t\t\tswitch (nodeVID) {";
  protected final String TEXT_15 = "\t\t" + NL + "\t\t\tcase ";
  protected final String TEXT_16 = ":" + NL + "\t\t\t\tcreate";
  protected final String TEXT_17 = "Children(nextNode, nextChild);" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_18 = NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t";
  protected final String TEXT_19 = "\t\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void create";
  protected final String TEXT_20 = "Children(Node node, EObject nodeObject) {" + NL + "\t\tfor (Iterator it = nodeObject.eContents().iterator(); it.hasNext();) {" + NL + "\t\t\tEObject nextChild = (EObject) it.next();" + NL + "\t\t\tstoreLinkReferenceOnly(nextChild);" + NL + "\t\t\tint nodeVID = ";
  protected final String TEXT_21 = ".INSTANCE.getChildNodeVisualID(nextChild);" + NL + "\t\t\tif (nodeVID == -1) {" + NL + "\t\t\t\tstoreLinkWithClass(nextChild);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\t" + NL + "\t\t\tNode container;" + NL + "\t\t\tswitch (nodeVID) {";
  protected final String TEXT_22 = "\t\t" + NL + "\t\t\tcase ";
  protected final String TEXT_23 = ":" + NL + "\t\t\t\tcontainer = getCompartment(node, \"";
  protected final String TEXT_24 = "\");" + NL + "\t\t\t\tbreak;";
  protected final String TEXT_25 = NL + "\t\t\tdefault:" + NL + "\t\t\t\tcontainer = node;" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t\tNode nextNode = DiagramUtil.createNode(container, nextChild, null, ";
  protected final String TEXT_26 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tmyEObject2NodeMap.put(nextChild, nextNode);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_27 = NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate Node getCompartment(Node node, String name) {" + NL + "\t\tfor (Iterator it = node.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\tView nextView = (View) it.next();" + NL + "\t\t\tif (nextView instanceof Node && name.equals(nextView.getType())) {" + NL + "\t\t\t\treturn (Node) nextView;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn node;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void storeLinkWithClass(EObject link) {" + NL + "\t\tint linkVID = ";
  protected final String TEXT_28 = ".INSTANCE.getLinkWithClassVisualID(link);" + NL + "\t\tif (linkVID == -1) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\t((Collection) myLinkWithClassVID2EObject.get(new Integer(linkVID))).add(link);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t *@generated" + NL + "\t */" + NL + "\tprivate void storeLinkReferenceOnly(EObject container) {" + NL + "\t\tEClass containerMetaclass = container.eClass();" + NL + "\t\tfor (Iterator it = containerMetaclass.getEAllStructuralFeatures().iterator(); it.hasNext();) {" + NL + "\t\t\tEStructuralFeature nextFeature = (EStructuralFeature) it.next();";
  protected final String TEXT_29 = NL + "\t\t\tif (";
  protected final String TEXT_30 = ".eINSTANCE.get";
  protected final String TEXT_31 = "().equals(nextFeature)) {" + NL + "\t\t\t\t((Collection) myLinkWithClassVID2EObject.get(new Integer(";
  protected final String TEXT_32 = "))).add(container);" + NL + "\t\t\t}";
  protected final String TEXT_33 = NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void createLinks() {" + NL + "\t\tCollection linkElements;";
  protected final String TEXT_34 = NL + "\t\tlinkElements = (Collection) myLinkWithClassVID2EObject.get(new Integer(";
  protected final String TEXT_35 = "));" + NL + "\t\tfor (Iterator it = linkElements.iterator(); it.hasNext();) {" + NL + "\t\t\tEObject linkElement = (EObject) it.next();";
  protected final String TEXT_36 = NL + "\t\t\tEObject src = linkElement.eContainer();";
  protected final String TEXT_37 = NL + "\t\t\tEObject src = linkElement;";
  protected final String TEXT_38 = NL + "\t\t\tNode srcNode = (Node) myEObject2NodeMap.get(src);" + NL + "\t\t\tif (srcNode == null) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tEStructuralFeature structuralFeature = ";
  protected final String TEXT_39 = ".eINSTANCE.get";
  protected final String TEXT_40 = "();" + NL + "\t\t\tObject structuralFeatureResult = linkElement.eGet(structuralFeature);";
  protected final String TEXT_41 = NL + "\t\t\tif (structuralFeatureResult instanceof EObject == false) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tEObject dst = (EObject) structuralFeatureResult;";
  protected final String TEXT_42 = NL + "\t\t\tif (structuralFeatureResult instanceof Collection == false) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tfor (Iterator destinations = ((Collection) structuralFeatureResult).iterator(); destinations.hasNext();) {" + NL + "\t\t\t\tEObject dst = (EObject) destinations.next();";
  protected final String TEXT_43 = NL + "\t\t\tNode dstNode = (Node) myEObject2NodeMap.get(dst);" + NL + "\t\t\tif (dstNode != null) {";
  protected final String TEXT_44 = NL + "\t\t\t\tDiagramUtil.createEdge(srcNode, dstNode, linkElement, null, ";
  protected final String TEXT_45 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t}";
  protected final String TEXT_46 = NL + "\t\t\t\t\tEdge edge = (Edge) ViewService.getInstance().createConnectorView(new IAdaptable() {" + NL + "\t\t\t\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\t\t\t\tif (IElementType.class.equals(adapter)) {" + NL + "\t\t\t\t\t\t\t\treturn ";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}, srcNode.getDiagram(), \"\", ViewUtil.APPEND, ";
  protected final String TEXT_49 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\t\tif (edge != null) {" + NL + "\t\t\t\t\t\tedge.setSource(srcNode);" + NL + "\t\t\t\t\t\tedge.setTarget(dstNode);" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t}";
  protected final String TEXT_50 = NL + "\t\t}";
  protected final String TEXT_51 = NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
List genNodes = genDiagram.getNodes();
List genLinks = genDiagram.getLinks();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getInitDiagramFileActionClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getDiagramFileExtension());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_7);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_9);
    
}

    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getEMFGenModel().getModelName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    
for (Iterator it = genNodes.iterator(); it.hasNext();) {
	GenNode nextGenNode = (GenNode) it.next();

    stringBuffer.append(TEXT_15);
    stringBuffer.append(nextGenNode.getVisualID());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(nextGenNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_17);
    
}

    stringBuffer.append(TEXT_18);
    
for (Iterator genNodesIt = genNodes.iterator(); genNodesIt.hasNext();) {
	GenNode nextGenNode = (GenNode) genNodesIt.next();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(nextGenNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_21);
    
	for (Iterator childGenNodesIt = nextGenNode.getChildNodes().iterator(); childGenNodesIt.hasNext();) {
		GenChildNode nextChildGenNode = (GenChildNode) childGenNodesIt.next();

    stringBuffer.append(TEXT_22);
    stringBuffer.append(nextChildGenNode.getVisualID());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nextChildGenNode.getGroupID());
    stringBuffer.append(TEXT_24);
    
	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorPackageName() + ".VisualIDRegistry"));
    stringBuffer.append(TEXT_28);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink instanceof GenLinkReferenceOnly) {
		GenFeature genFeature = nextLink.getDomainLinkTargetFeature();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_32);
    
	}
}

    stringBuffer.append(TEXT_33);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	GenFeature domainLinkTargetGenFeature = nextLink.getDomainLinkTargetFeature();

    stringBuffer.append(TEXT_34);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_35);
    	
	if (nextLink instanceof GenLinkWithClass) {

    stringBuffer.append(TEXT_36);
    
	} else {

    stringBuffer.append(TEXT_37);
    	
	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(domainLinkTargetGenFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(domainLinkTargetGenFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_40);
    
	if (nextLink instanceof GenLinkWithClass) {

    stringBuffer.append(TEXT_41);
    
	} else {

    stringBuffer.append(TEXT_42);
    	
	}

    stringBuffer.append(TEXT_43);
    
	if (nextLink instanceof GenLinkWithClass) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    
	} else {

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(genDiagram.getProvidersPackageName() + ".ElementTypes"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPluginQualifiedClassName()));
    stringBuffer.append(TEXT_49);
    	
	}

    stringBuffer.append(TEXT_50);
    
}

    stringBuffer.append(TEXT_51);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}

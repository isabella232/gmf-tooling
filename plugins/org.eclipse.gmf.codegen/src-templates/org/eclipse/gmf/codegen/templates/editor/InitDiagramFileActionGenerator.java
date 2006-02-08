package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.common.codegen.*;

public class InitDiagramFileActionGenerator {
 
  protected static String nl;
  public static synchronized InitDiagramFileActionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitDiagramFileActionGenerator result = new InitDiagramFileActionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " implements IObjectActionDelegate, IInputValidator {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IWorkbenchPart myPart;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IFile mySelection;" + NL + "    " + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map myLinkVID2EObjectMap = new HashMap();" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Map myEObject2NodeMap = new HashMap();" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyPart = targetPart;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate Shell getShell() {" + NL + "\t\treturn myPart.getSite().getShell();" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelection = null;" + NL + "\t\taction.setEnabled(false);" + NL + "\t\tif (selection instanceof IStructuredSelection == false || selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tmySelection = (IFile) ((IStructuredSelection) selection).getFirstElement();" + NL + "\t\taction.setEnabled(true);" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */\t" + NL + "\tpublic String isValid(String newText) {" + NL + "\t\tIStatus status = ResourcesPlugin.getWorkspace().validateName(newText, IResource.FILE);" + NL + "\t\tif (!status.isOK()) {" + NL + "\t\t\treturn status.getMessage();" + NL + "\t\t}" + NL + "\t\tif (mySelection.getParent().getFile(new Path(newText).addFileExtension(\"editorGen.getDiagramFileExtension()\")).exists()) {" + NL + "\t\t\treturn \"File already exists, choose another name\";" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tfinal InputDialog outputFileNameDialog = new InputDialog(getShell(), \"Diagram file name\", \"Please provide diagram file name\", mySelection.getProjectRelativePath().removeFileExtension().addFileExtension(\"editorGen.getDiagramFileExtension()\").lastSegment(), this);" + NL + "\t\tif (outputFileNameDialog.open() != InputDialog.OK) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tfinal EObject diagramModelObject = load();" + NL + "\t\tif (diagramModelObject == null) {" + NL + "\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to load user model\");" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tOperationUtil.runAsUnchecked(new MRunnable() {" + NL + "\t\t\tpublic Object run() {" + NL + "\t\t\t\tEObject diagram = create(diagramModelObject);" + NL + "\t\t\t\tif (diagram == null) {" + NL + "\t\t\t\t\tMessageDialog.openError(getShell(), \"Error\", \"Failed to create diagram object\");" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tIFile destFile = mySelection.getParent().getFile(new Path(outputFileNameDialog.getValue()));" + NL + "\t\t\t\tsave(destFile.getLocation().toOSString(), diagram);" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tIDE.openEditor(myPart.getSite().getPage(), destFile);" + NL + "\t\t\t\t} catch (PartInitException ex) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_5 = ".getInstance().logError(\"Unable to open editor\", ex);" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate EObject load() {";
  protected final String TEXT_6 = NL + "\t\t";
  protected final String TEXT_7 = " resourceSet = new ";
  protected final String TEXT_8 = "();" + NL + "\t\tResource resource = resourceSet.getResource(";
  protected final String TEXT_9 = ".createPlatformResourceURI(mySelection.getFullPath().toString()), true);" + NL + "\t\ttry {" + NL + "\t\t\tresource.load(Collections.EMPTY_MAP);" + NL + "\t\t\treturn (EObject) resource.getContents().get(0);" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\t";
  protected final String TEXT_10 = ".getInstance().logError(\"Unable to load resource: \" + mySelection.getFullPath().toString(), ex);" + NL + "\t\t}" + NL + "\t\treturn null;";
  protected final String TEXT_11 = NL + "\t\tString resourcePath = mySelection.getLocation().toOSString();" + NL + "\t\tResource modelResource = ResourceUtil.findResource(resourcePath);" + NL + "\t\tif (modelResource == null) {" + NL + "\t\t\tmodelResource = ResourceUtil.create(resourcePath);" + NL + "\t\t}" + NL + "\t\tif (!modelResource.isLoaded()) {" + NL + "\t\t\ttry {" + NL + "\t\t\t\tResourceUtil.load(modelResource);" + NL + "\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t";
  protected final String TEXT_12 = ".getInstance().logError(\"Unable to load resource: \" + resourcePath, e);" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn (EObject) modelResource.getContents().get(0);";
  protected final String TEXT_13 = NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void save(String filePath, EObject canvas) {" + NL + "\t\tResource resource = ResourceUtil.create(filePath, null);";
  protected final String TEXT_14 = NL + "\t\tresource.getContents().add(((Diagram) canvas).getElement());";
  protected final String TEXT_15 = NL + "\t\tresource.getContents().add(canvas);" + NL + "\t\ttry {" + NL + "\t\t\tresource.save(Collections.EMPTY_MAP);" + NL + "\t\t} catch (IOException ex) {" + NL + "\t\t\t";
  protected final String TEXT_16 = ".getInstance().logError(\"Save operation failed for: \" + filePath, ex);" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate EObject create(EObject diagramModel) {" + NL + "\t\tint diagramVID = ";
  protected final String TEXT_17 = ".INSTANCE.getDiagramVisualID(diagramModel);" + NL + "\t\tif (diagramVID != ";
  protected final String TEXT_18 = ") {" + NL + "\t\t\treturn null;" + NL + "\t\t}";
  protected final String TEXT_19 = NL + "\t\tmyLinkVID2EObjectMap.put(new Integer(";
  protected final String TEXT_20 = "), new ";
  protected final String TEXT_21 = "());";
  protected final String TEXT_22 = NL + "\t\tDiagram diagram = ViewService.createDiagram(diagramModel, \"";
  protected final String TEXT_23 = "\", ";
  protected final String TEXT_24 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\tcreate";
  protected final String TEXT_25 = "Children(diagram, diagramModel);";
  protected final String TEXT_26 = NL + "\t\tResource resource = diagramModel.eResource();" + NL + "\t\tint nodeVID;" + NL + "\t\tfor (Iterator it = resource.getContents().iterator(); it.hasNext();) {" + NL + "\t\t\tEObject nextResourceObject = (EObject) it.next();" + NL + "\t\t\tif (nextResourceObject == diagramModel) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}";
  protected final String TEXT_27 = NL + "\t\t\tnodeVID = ";
  protected final String TEXT_28 = ".INSTANCE.getNodeVisualID(diagram, nextResourceObject, \"\");" + NL + "\t\t\tif (";
  protected final String TEXT_29 = " == nodeVID) {" + NL + "\t\t\t\t";
  protected final String TEXT_30 = " nextNode = ViewService.createNode(diagram, nextResourceObject, null, ";
  protected final String TEXT_31 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tmyEObject2NodeMap.put(nextResourceObject, nextNode);" + NL + "\t\t\t\tcreate";
  protected final String TEXT_32 = "Children(nextNode, nextResourceObject);" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}";
  protected final String TEXT_33 = NL + "\t\t}";
  protected final String TEXT_34 = "\t\t" + NL + "\t\tcreateLinks();" + NL + "\t\tmyLinkVID2EObjectMap.clear();" + NL + "\t\tmyEObject2NodeMap.clear();\t\t" + NL + "\t    return diagram;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_35 = "\t" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void create";
  protected final String TEXT_36 = "Children(";
  protected final String TEXT_37 = " viewObject, EObject modelObject) {";
  protected final String TEXT_38 = NL + "\t\tEObject nextValue;" + NL + "\t\t";
  protected final String TEXT_39 = " nextNode;" + NL + "\t\tint nodeVID;";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = " nextNode;";
  protected final String TEXT_42 = NL + "\t\tfor (";
  protected final String TEXT_43 = " values = ";
  protected final String TEXT_44 = ".iterator(); values.hasNext();) {" + NL + "\t\t\tnextValue = (EObject) values.next();" + NL;
  protected final String TEXT_45 = NL + "\t\tnextValue = ";
  protected final String TEXT_46 = ";";
  protected final String TEXT_47 = NL + "\t\tnodeVID = ";
  protected final String TEXT_48 = ".INSTANCE.getNodeVisualID(viewObject, nextValue, \"\");" + NL + "\t\tif (";
  protected final String TEXT_49 = " == nodeVID) {" + NL + "\t\t\tnextNode = ViewService.createNode(viewObject, nextValue, null, ";
  protected final String TEXT_50 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\tmyEObject2NodeMap.put(nextValue, nextNode);" + NL + "\t\t\tcreate";
  protected final String TEXT_51 = "Children(nextNode, nextValue);" + NL + "\t\t}";
  protected final String TEXT_52 = NL + "\t\t}";
  protected final String TEXT_53 = NL + "\t\tnextNode = getCompartment(viewObject, \"";
  protected final String TEXT_54 = "\");" + NL + "\t\tif (nextNode != null) {" + NL + "\t\t\tcreate";
  protected final String TEXT_55 = "Children(nextNode, modelObject);" + NL + "\t\t}";
  protected final String TEXT_56 = NL + "\t\tstoreLinks(modelObject, viewObject.getDiagram());" + NL + "\t}";
  protected final String TEXT_57 = NL + "\t" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate ";
  protected final String TEXT_58 = " getCompartment(";
  protected final String TEXT_59 = " node, String name) {" + NL + "\t\tfor (";
  protected final String TEXT_60 = " it = node.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_61 = " nextView = (";
  protected final String TEXT_62 = ") it.next();" + NL + "\t\t\tif (nextView instanceof ";
  protected final String TEXT_63 = " && name.equals(nextView.getType())) {" + NL + "\t\t\t\treturn (";
  protected final String TEXT_64 = ") nextView;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_65 = NL + NL + "\t/**" + NL + "\t *@generated" + NL + "\t */" + NL + "\tprivate void storeLinks(EObject container, Diagram diagram) {" + NL + "\t\tEClass containerMetaclass = container.eClass();" + NL + "\t\tstoreFeatureModelFacetLinks(container, containerMetaclass, diagram);" + NL + "\t\tstoreTypeModelFacetLinks(container, containerMetaclass);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass) {\t";
  protected final String TEXT_66 = "\t\t" + NL + "\t\tif (-1 != containerMetaclass.getFeatureID(";
  protected final String TEXT_67 = ".eINSTANCE.get";
  protected final String TEXT_68 = "())) {" + NL + "\t\t\tObject featureValue = ";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = "\t\t" + NL + "\t\t\tfor (";
  protected final String TEXT_71 = " values = ((";
  protected final String TEXT_72 = ") featureValue).iterator(); values.hasNext();) {" + NL + "\t\t\t\tEObject nextValue = ((EObject) values.next());";
  protected final String TEXT_73 = NL + "\t\t\tEObject nextValue = (EObject) featureValue;";
  protected final String TEXT_74 = NL + "\t\t\tint linkVID = ";
  protected final String TEXT_75 = ".INSTANCE.getLinkWithClassVisualID(nextValue);" + NL + "\t\t\tif (";
  protected final String TEXT_76 = " == linkVID) {" + NL + "\t\t\t\t((";
  protected final String TEXT_77 = ") myLinkVID2EObjectMap.get(new Integer(";
  protected final String TEXT_78 = "))).add(nextValue);" + NL + "\t\t\t}";
  protected final String TEXT_79 = NL + "\t\t\t}";
  protected final String TEXT_80 = NL + "\t\t}";
  protected final String TEXT_81 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t *@generated" + NL + "\t */" + NL + "\tprivate void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {";
  protected final String TEXT_82 = NL + "\t\tif (-1 != containerMetaclass.getFeatureID(";
  protected final String TEXT_83 = ".eINSTANCE.get";
  protected final String TEXT_84 = "())) {" + NL + "\t\t\t((";
  protected final String TEXT_85 = ") myLinkVID2EObjectMap.get(new Integer(";
  protected final String TEXT_86 = "))).add(container);";
  protected final String TEXT_87 = NL + "\t\t\tfor (";
  protected final String TEXT_88 = " values = ";
  protected final String TEXT_89 = ".iterator(); values.hasNext();) {" + NL + "\t\t\t\tEObject nextValue = (EObject) values.next();";
  protected final String TEXT_90 = NL + "\t\t\tEObject nextValue = ";
  protected final String TEXT_91 = ";";
  protected final String TEXT_92 = NL + "\t\t\tint nodeVID = ";
  protected final String TEXT_93 = ".INSTANCE.getNodeVisualID(diagram, nextValue, \"\");" + NL + "\t\t\tif (";
  protected final String TEXT_94 = " == nodeVID) {" + NL + "\t\t\t\t";
  protected final String TEXT_95 = " nextNode = ViewService.createNode(diagram, nextValue, null, ";
  protected final String TEXT_96 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\tmyEObject2NodeMap.put(nextValue, nextNode);" + NL + "\t\t\t\tcreate";
  protected final String TEXT_97 = "Children(nextNode, nextValue);" + NL + "\t\t\t}";
  protected final String TEXT_98 = NL + "\t\t\t}";
  protected final String TEXT_99 = NL + "\t\t}";
  protected final String TEXT_100 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "     * @generated" + NL + "     */" + NL + "\tprivate void createLinks() {";
  protected final String TEXT_101 = NL + "\t\t";
  protected final String TEXT_102 = " linkElements;";
  protected final String TEXT_103 = NL + "\t\tlinkElements = (";
  protected final String TEXT_104 = ") myLinkVID2EObjectMap.get(new Integer(";
  protected final String TEXT_105 = "));" + NL + "\t\tfor (";
  protected final String TEXT_106 = " it = linkElements.iterator(); it.hasNext();) {" + NL + "\t\t\tEObject linkElement = (EObject) it.next();";
  protected final String TEXT_107 = NL + "\t\t\tObject srcResult = ";
  protected final String TEXT_108 = ";" + NL + "\t\t\tif (srcResult instanceof EObject == false) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tEObject src = (EObject) srcResult;";
  protected final String TEXT_109 = NL + "\t\t\tEObject src = linkElement.eContainer();";
  protected final String TEXT_110 = NL + "\t\t\tEObject src = linkElement;";
  protected final String TEXT_111 = NL + "\t\t\t";
  protected final String TEXT_112 = " srcNode = (";
  protected final String TEXT_113 = ") myEObject2NodeMap.get(src);" + NL + "\t\t\tif (srcNode == null) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tObject structuralFeatureResult = ";
  protected final String TEXT_114 = ";";
  protected final String TEXT_115 = NL + "\t\t\tif (structuralFeatureResult instanceof EObject == false) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tEObject dst = (EObject) structuralFeatureResult;";
  protected final String TEXT_116 = NL + "\t\t\tif (structuralFeatureResult instanceof ";
  protected final String TEXT_117 = " == false) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tfor (";
  protected final String TEXT_118 = " destinations = ((";
  protected final String TEXT_119 = ") structuralFeatureResult).iterator(); destinations.hasNext();) {" + NL + "\t\t\t\tEObject dst = (EObject) destinations.next();";
  protected final String TEXT_120 = NL + "\t\t\tif (structuralFeatureResult instanceof EObject == false) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tEObject dst = (EObject) structuralFeatureResult;";
  protected final String TEXT_121 = NL + "\t\t\t";
  protected final String TEXT_122 = " dstNode = (";
  protected final String TEXT_123 = ") myEObject2NodeMap.get(dst);" + NL + "\t\t\tif (dstNode != null) {";
  protected final String TEXT_124 = NL + "\t\t\t\tViewService.createEdge(srcNode, dstNode, linkElement, null, ";
  protected final String TEXT_125 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t}";
  protected final String TEXT_126 = NL + "\t\t\t\t\t";
  protected final String TEXT_127 = " edge = (";
  protected final String TEXT_128 = ") ViewService.getInstance().createEdge(new ";
  protected final String TEXT_129 = "() {" + NL + "\t\t\t\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\t\t\t\tif (";
  protected final String TEXT_130 = ".class.equals(adapter)) {" + NL + "\t\t\t\t\t\t\t\treturn ";
  protected final String TEXT_131 = ".";
  protected final String TEXT_132 = ";" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\treturn null;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}, srcNode.getDiagram(), \"\", ";
  protected final String TEXT_133 = ".APPEND, ";
  protected final String TEXT_134 = ".DIAGRAM_PREFERENCES_HINT);" + NL + "\t\t\t\t\tif (edge != null) {" + NL + "\t\t\t\t\t\tedge.setSource(srcNode);" + NL + "\t\t\t\t\t\tedge.setTarget(dstNode);" + NL + "\t\t\t\t\t}";
  protected final String TEXT_135 = NL + "\t\t\t\t}";
  protected final String TEXT_136 = NL + "\t\t\t}";
  protected final String TEXT_137 = NL + "\t\t}";
  protected final String TEXT_138 = NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_139 = NL;

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
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
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportUtil importManager) {
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
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportUtil importManager) {
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
    
final GenDiagram genDiagram = (GenDiagram) argument;
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final ImportUtil importManager = new ImportUtil(editorGen.getEditor().getPackageName());
final String pluginActivatorClass = importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName());
final String modelID = editorGen.getModelID();
List genLinks = genDiagram.getLinks();

// Collecting all phantom elements
Map genClass2Phantom = new LinkedHashMap();
for (Iterator topLevelNodes = genDiagram.getTopLevelNodes().iterator(); topLevelNodes.hasNext();) {
	GenTopLevelNode nextTopLevelNode = (GenTopLevelNode) topLevelNodes.next();
	TypeModelFacet nextModelFacet = nextTopLevelNode.getModelFacet();
	if (!nextModelFacet.isPhantomElement()) {
		continue;
	}
	genClass2Phantom.put(nextModelFacet.getMetaClass(), nextTopLevelNode);
}

boolean generateGetCompartment = false;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(editorGen.getEditor().getPackageName());
    stringBuffer.append(TEXT_2);
    
importManager.addImport("java.io.IOException");
importManager.addImport("java.util.Collections");
importManager.addImport("java.util.HashMap");
importManager.addImport("java.util.Map");
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.core.resources.IResource");
importManager.addImport("org.eclipse.core.resources.ResourcesPlugin");
importManager.addImport("org.eclipse.core.runtime.IStatus");
importManager.addImport("org.eclipse.core.runtime.Path");
importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.resource.Resource");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.edit.MRunnable");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.util.OperationUtil");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.util.ResourceUtil");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.jface.dialogs.IInputValidator");
importManager.addImport("org.eclipse.jface.dialogs.InputDialog");
importManager.addImport("org.eclipse.jface.dialogs.MessageDialog");
importManager.addImport("org.eclipse.jface.viewers.ISelection");
importManager.addImport("org.eclipse.jface.viewers.IStructuredSelection");
importManager.addImport("org.eclipse.swt.widgets.Shell");
importManager.addImport("org.eclipse.ui.IObjectActionDelegate");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.ui.PartInitException");
importManager.addImport("org.eclipse.ui.ide.IDE");
importManager.addImport("org.eclipse.gmf.runtime.diagram.core.services.ViewService");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getInitDiagramFileActionClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_5);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.ResourceSet"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_18);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_21);
    
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_25);
    
if (!genClass2Phantom.isEmpty()) {

    stringBuffer.append(TEXT_26);
    
	for (Iterator phantoms = genClass2Phantom.values().iterator(); phantoms.hasNext();) {
		GenTopLevelNode phantomNode = (GenTopLevelNode) phantoms.next();

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_32);
    
	}

    stringBuffer.append(TEXT_33);
    
}

    stringBuffer.append(TEXT_34);
    
for (Iterator containers = genDiagram.getAllContainers().iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_35);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_37);
    
	if (nextContainer.getContainedNodes().size() > 0) {

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_39);
    
	} else if (nextContainer instanceof GenNode && ((GenNode) nextContainer).getCompartments().size() > 0) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_41);
    
	}
	
	for (Iterator children = nextContainer.getContainedNodes().iterator(); children.hasNext();) {
		GenNode nextChild = (GenNode) children.next();
		TypeModelFacet typeModelFacet = nextChild.getModelFacet();
		if (typeModelFacet.isPhantomElement()) {
// Skipping top-leve phantoms
			continue;
		}
		GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_44);
    
		} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_46);
    
		}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(nextChild.getVisualID());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(nextChild.getUniqueIdentifier());
    stringBuffer.append(TEXT_51);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_52);
    
		}
	}
	
	if (nextContainer instanceof GenNode) {
		GenNode nextNode = (GenNode) nextContainer;
		for (Iterator compartments = nextNode.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment nextCompartment = (GenCompartment) compartments.next();
			generateGetCompartment = true;

    stringBuffer.append(TEXT_53);
    stringBuffer.append(nextCompartment.getTitle());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(nextCompartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_55);
    
		}
	}

    stringBuffer.append(TEXT_56);
    
}

if (generateGetCompartment) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_64);
    
}

    stringBuffer.append(TEXT_65);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		GenFeature childMetaFeature = typeLinkModelFacet.getChildMetaFeature();

    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName(childMetaFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(childMetaFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_68);
    stringBuffer.append(getFeatureValueGetter("container", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_69);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_72);
    
		} else {

    stringBuffer.append(TEXT_73);
    		
		}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_75);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_78);
    
		if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_79);
    
		}

    stringBuffer.append(TEXT_80);
    
	}
}

    stringBuffer.append(TEXT_81);
    
for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof FeatureModelFacet) {
		FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
		GenFeature genFeature = linkFMF.getMetaFeature();

    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_86);
    
		if (genFeature.isContains()) {
// Processing phantom elements
// TODO: separate this code into incliuded file together with part of create???Children() operation
			GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
			if (phantomNode != null) {
				if (genFeature.isListType()) {

    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_89);
    
				} else {

    stringBuffer.append(TEXT_90);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_91);
    
				}

    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(phantomNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_97);
    
				if (genFeature.isListType()) {

    stringBuffer.append(TEXT_98);
    
				}
			}
		}

    stringBuffer.append(TEXT_99);
    
	}
}

    stringBuffer.append(TEXT_100);
    
if (genLinks.size() > 0) {

    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_102);
    
}

for (Iterator it = genLinks.iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	GenFeature domainLinkTargetGenFeature;

    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(nextLink.getVisualID());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_106);
    	
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) nextLink.getModelFacet();
		domainLinkTargetGenFeature = typeLinkModelFacet.getTargetMetaFeature();
		if (typeLinkModelFacet.getSourceMetaFeature() != null) {

    stringBuffer.append(TEXT_107);
    stringBuffer.append(getFeatureValueGetter("linkElement", typeLinkModelFacet.getSourceMetaFeature(), true, importManager));
    stringBuffer.append(TEXT_108);
    
		} else {

    stringBuffer.append(TEXT_109);
    
		}
	} else {
		domainLinkTargetGenFeature = ((FeatureModelFacet) nextLink.getModelFacet()).getMetaFeature();

    stringBuffer.append(TEXT_110);
    	
	}

    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(getFeatureValueGetter("linkElement", domainLinkTargetGenFeature, true, importManager));
    stringBuffer.append(TEXT_114);
    
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_115);
    
	} else {
		if (domainLinkTargetGenFeature.isListType()) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_119);
    	
		} else {

    stringBuffer.append(TEXT_120);
    
		}
	}

    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_123);
    
	if (nextLink.getModelFacet() instanceof TypeLinkModelFacet) {

    stringBuffer.append(TEXT_124);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_125);
    
	} else {

    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_133);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_134);
    
		if (domainLinkTargetGenFeature.isListType()) {

    stringBuffer.append(TEXT_135);
    
}

    stringBuffer.append(TEXT_136);
    	
	}

    stringBuffer.append(TEXT_137);
    
}

    stringBuffer.append(TEXT_138);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_139);
    return stringBuffer.toString();
  }
}
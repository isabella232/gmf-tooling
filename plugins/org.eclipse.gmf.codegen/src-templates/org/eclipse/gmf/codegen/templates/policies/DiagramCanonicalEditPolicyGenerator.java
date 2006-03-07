package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class DiagramCanonicalEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized DiagramCanonicalEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    DiagramCanonicalEditPolicyGenerator result = new DiagramCanonicalEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import java.util.Iterator;" + NL + "import java.util.LinkedList;" + NL + "import java.util.List;" + NL + "import java.util.Collection;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalConnectionEditPolicy;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.gmf.runtime.notation.Edge;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.emf.ecore.EObject;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends CanonicalConnectionEditPolicy {";
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected ";
  protected final String TEXT_11 = " getSemanticChildrenList() {" + NL + "\t\t\tList result = new ";
  protected final String TEXT_12 = "();";
  protected final String TEXT_13 = NL + "\t\t\t";
  protected final String TEXT_14 = " modelElement = (";
  protected final String TEXT_15 = ") ((View) getHost().getModel()).getElement();" + NL + "\t\t\t";
  protected final String TEXT_16 = " nextValue;" + NL + "\t\t\tint nodeVID;";
  protected final String TEXT_17 = "\t" + NL + "\t\t\tfor (";
  protected final String TEXT_18 = " it = ";
  protected final String TEXT_19 = ".iterator(); it.hasNext();) {" + NL + "\t\t\t\tnextValue = (";
  protected final String TEXT_20 = ") it.next();";
  protected final String TEXT_21 = NL + "\t\t\tnextValue = ";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "\t\t\tnodeVID = ";
  protected final String TEXT_24 = ".INSTANCE.getNodeVisualID((View) getHost().getModel(), nextValue, \"\");" + NL + "\t\t\tif (";
  protected final String TEXT_25 = " == nodeVID) {" + NL + "\t\t\t\tresult.add(nextValue);" + NL + "\t\t\t}";
  protected final String TEXT_26 = NL + "\t\t\t}";
  protected final String TEXT_27 = "\t\t\t" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprotected boolean shouldDeleteView(View view) {" + NL + "\t\t\t";
  protected final String TEXT_28 = " domainModelElement = view.getElement();" + NL + "\t\t\treturn domainModelElement != null && domainModelElement != ((View) getHost().getModel()).getElement() && super.shouldDeleteView(view);" + NL + "\t\t}";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected List getSemanticConnectionsList() {" + NL + "\t\tList result = new LinkedList();";
  protected final String TEXT_30 = NL + "\t\tDiagram diagram = (Diagram) getHost().getModel();" + NL + "\t\t";
  protected final String TEXT_31 = " modelElement = (";
  protected final String TEXT_32 = ") diagram.getElement();" + NL + "\t\tfor (Iterator diagramElements = modelElement.eContents().iterator(); diagramElements.hasNext();) {" + NL + "\t\t\tEObject nextDiagramElement = (EObject) diagramElements.next();" + NL + "\t\t\tfor (Iterator childElements = nextDiagramElement.eContents().iterator(); childElements.hasNext();) {" + NL + "\t\t\t\tEObject nextChild = (EObject) childElements.next();" + NL + "\t\t\t\tif (";
  protected final String TEXT_33 = ".INSTANCE.getLinkWithClassVisualID(nextChild) != -1) {" + NL + "\t\t\t\t\tresult.add(nextChild);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}";
  protected final String TEXT_34 = NL + "\t\treturn result;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSourceElement(EObject relationship) {" + NL + "\t\treturn relationship.eContainer();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getTargetElement(EObject relationship) {" + NL + "\t\tint vID = ";
  protected final String TEXT_35 = ".INSTANCE.getLinkWithClassVisualID(relationship);" + NL + "\t\tswitch (vID) {";
  protected final String TEXT_36 = NL + "\t\tcase ";
  protected final String TEXT_37 = ":" + NL + "\t\t\treturn ";
  protected final String TEXT_38 = ";";
  protected final String TEXT_39 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * For now we are skipping links which was generated based on \"GenLinkReferenceOnly\" classes" + NL + "\t * since they do not handle any domain model objects inside, so we can not process them using" + NL + "\t * CanonicalConnectionEditPolicy class" + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldIncludeConnection(Edge connector, Collection children) {" + NL + "\t\treturn super.shouldIncludeConnection(connector, children) && connector.getElement() != null;" + NL + "\t}";
  protected final String TEXT_40 = NL;
  protected final String TEXT_41 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected void refreshSemantic() {" + NL + "\tsuper.refreshSemantic();";
  protected final String TEXT_42 = NL + "\trefreshReferenceOnlyConnections();";
  protected final String TEXT_43 = NL + "\trefreshPhantoms();";
  protected final String TEXT_44 = NL + "}";
  protected final String TEXT_45 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private class PhantomLinkInfo {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EObject myDst;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int myIndex;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String myType;" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_46 = " myElementType;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PhantomLinkInfo(EObject dst, int index, String linkType, ";
  protected final String TEXT_47 = " elementType) {" + NL + "\t\tmyDst = dst;" + NL + "\t\tmyIndex = index;" + NL + "\t\tmyType = linkType;" + NL + "\t\tmyElementType = elementType;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PhantomLinkInfo(EObject dst, String linkType, ";
  protected final String TEXT_48 = " elementType) {" + NL + "\t\tthis(dst, 0, linkType, elementType);" + NL + "\t}" + NL + "" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void refreshPhantoms() {" + NL + "\t";
  protected final String TEXT_49 = " phantomNodes = new ";
  protected final String TEXT_50 = "();" + NL + "\t";
  protected final String TEXT_51 = " phantomLinks = new ";
  protected final String TEXT_52 = "();" + NL + "\t";
  protected final String TEXT_53 = " modelElement = (";
  protected final String TEXT_54 = ") ((";
  protected final String TEXT_55 = ") getHost().getModel()).getElement();" + NL + "\t";
  protected final String TEXT_56 = " modelElementMetaclass = modelElement.eClass();" + NL + "\t";
  protected final String TEXT_57 = " eObject2ViewMap = new ";
  protected final String TEXT_58 = "();";
  protected final String TEXT_59 = NL + "\tif (-1 != modelElementMetaclass.getFeatureID(";
  protected final String TEXT_60 = ".eINSTANCE.get";
  protected final String TEXT_61 = "())) {";
  protected final String TEXT_62 = NL + "\t\tint linkIndex = 0;" + NL + "\t\tfor (";
  protected final String TEXT_63 = " values = ";
  protected final String TEXT_64 = ".iterator(); values.hasNext(); linkIndex++) {" + NL + "\t\t\tEObject nextValue = (EObject) values.next();";
  protected final String TEXT_65 = NL + "\t\tEObject nextValue = ";
  protected final String TEXT_66 = ";";
  protected final String TEXT_67 = NL + "\t\tint nodeVID = ";
  protected final String TEXT_68 = ".INSTANCE.getNodeVisualID(getDiagram(), nextValue, \"\");" + NL + "\t\tif (";
  protected final String TEXT_69 = " == nodeVID) {" + NL + "\t\t\tphantomNodes.add(nextValue);" + NL + "\t\t\tphantomLinks.add(new PhantomLinkInfo(nextValue";
  protected final String TEXT_70 = ", linkIndex";
  protected final String TEXT_71 = ", ";
  protected final String TEXT_72 = ".";
  protected final String TEXT_73 = ", ";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = "));" + NL + "\t\t}";
  protected final String TEXT_76 = NL + "\t\t}";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL + NL + "\tfor (Iterator resourceObjects = modelElement.eResource().getContents().iterator(); resourceObjects.hasNext();) {" + NL + "\t\tEObject nextResourceEObject = (EObject) resourceObjects.next();" + NL + "\t\tif (nextResourceEObject != modelElement) {" + NL + "\t\t\tphantomNodes.add(nextResourceEObject);" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_79 = NL + NL + "\tfor (Iterator diagramNodes = getDiagram().getChildren().iterator(); diagramNodes.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_80 = " nextView = (";
  protected final String TEXT_81 = ") diagramNodes.next();" + NL + "\t\tEObject nextViewElement = nextView.getElement();" + NL + "\t\tif (phantomNodes.contains(nextViewElement)) {" + NL + "\t\t\tphantomNodes.remove(nextViewElement);" + NL + "\t\t\teObject2ViewMap.put(nextViewElement, nextView);" + NL + "\t\t}\t" + NL + "\t}" + NL + "\t" + NL + "\tfor (Iterator diagramEdges = getDiagram().getEdges().iterator(); diagramEdges.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_82 = " nextEdge = (";
  protected final String TEXT_83 = ") diagramEdges.next();" + NL + "\t\tif (nextEdge.getSource().getElement() != modelElement) {" + NL + "\t\t\tcontinue;" + NL + "\t\t}" + NL + "\t\tEObject target = nextEdge.getTarget().getElement();" + NL + "\t\tString linkType = nextEdge.getType();" + NL + "\t\tfor (Iterator linkInfos = phantomLinks.iterator(); linkInfos.hasNext();) {" + NL + "\t\t\tPhantomLinkInfo nextLinkInfo = (PhantomLinkInfo) linkInfos.next();" + NL + "\t\t\tif (nextLinkInfo.myDst == target && nextLinkInfo.myType.equals(linkType)) {" + NL + "\t\t\t\tlinkInfos.remove();" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\t" + NL + "\tcreatePhantomNodes(phantomNodes, eObject2ViewMap);" + NL + "\tcreatePhantomLinks(phantomLinks, eObject2ViewMap);" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void createPhantomNodes(";
  protected final String TEXT_84 = " nodes, ";
  protected final String TEXT_85 = " eObject2ViewMap) {" + NL + "\tif (nodes.isEmpty()) {" + NL + "\t\treturn;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_86 = " descriptors = new ";
  protected final String TEXT_87 = "();" + NL + "\tfor (Iterator elements = nodes.iterator(); elements.hasNext();) {" + NL + "\t\tEObject element = (EObject)elements.next();" + NL + "\t\tCreateViewRequest.ViewDescriptor descriptor = getViewDescriptor(element);" + NL + "\t\tdescriptors.add(descriptor);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_88 = " request = getCreateViewRequest(descriptors);" + NL + "\t";
  protected final String TEXT_89 = " diagramEditPart = getDiagramEditPart();" + NL + "\t";
  protected final String TEXT_90 = " cmd = diagramEditPart.getCommand(request);" + NL + "\tif (cmd == null) {" + NL + "\t\t";
  protected final String TEXT_91 = " cc = new ";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ".AddCommand_Label);" + NL + "\t\tfor (Iterator descriptorsIterator = descriptors.iterator(); descriptorsIterator.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_94 = ".ViewDescriptor descriptor = (";
  protected final String TEXT_95 = ".ViewDescriptor) descriptorsIterator.next();" + NL + "\t\t\t";
  protected final String TEXT_96 = " createCommand = new ";
  protected final String TEXT_97 = "(((";
  protected final String TEXT_98 = ") getHost()).getEditingDomain(), descriptor, getDiagram());" + NL + "\t\t\tcc.compose(createCommand);" + NL + "\t\t}" + NL + "\t\tcmd = new ";
  protected final String TEXT_99 = "(cc);" + NL + "\t}\t" + NL + "\t" + NL + "\tif ( cmd != null && cmd.canExecute() ) {" + NL + "\t\t";
  protected final String TEXT_100 = ".makeMutable(new ";
  protected final String TEXT_101 = "(((";
  protected final String TEXT_102 = ") diagramEditPart).getNotationView())).execute();" + NL + "\t\texecuteCommand(cmd);" + NL + "\t\t";
  protected final String TEXT_103 = " adapters = (";
  protected final String TEXT_104 = ") request.getNewObject();" + NL + "\t\tmakeViewsImmutable(adapters);" + NL + "\t\tfor (Iterator viewAdapters = adapters.iterator(); viewAdapters.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_105 = " createdView = (";
  protected final String TEXT_106 = ") ((";
  protected final String TEXT_107 = ") viewAdapters.next()).getAdapter(";
  protected final String TEXT_108 = ".class);" + NL + "\t\t\tif (createdView.getElement() != null) {" + NL + "\t\t\t\teObject2ViewMap.put(createdView.getElement(), createdView);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}" + NL + "\tdiagramEditPart.refresh();" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void createPhantomLinks(";
  protected final String TEXT_109 = " linkInfos, ";
  protected final String TEXT_110 = " eObject2ViewMap) {" + NL + "\tif (linkInfos.isEmpty()) {" + NL + "\t\treturn;" + NL + "\t}" + NL + "\tfor (Iterator linkInfoIterator = linkInfos.iterator(); linkInfoIterator.hasNext();) {" + NL + "\t\tfinal PhantomLinkInfo nextLinkInfo = (PhantomLinkInfo) linkInfoIterator.next();" + NL + "\t\t";
  protected final String TEXT_111 = " dstView = (";
  protected final String TEXT_112 = ") eObject2ViewMap.get(nextLinkInfo.myDst);" + NL + "\t\tif (dstView == null) {" + NL + "\t\t\tcontinue;" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_113 = " targetEditPart = (";
  protected final String TEXT_114 = ") getHost().getViewer().getEditPartRegistry().get(dstView);\t\t" + NL + "\t\t";
  protected final String TEXT_115 = " sourceEditPart = getHost();" + NL + "\t\tString factoryHint = \"\";" + NL + "\t\t";
  protected final String TEXT_116 = " adapter = new ";
  protected final String TEXT_117 = "() {" + NL + "\t\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\t\tif (";
  protected final String TEXT_118 = ".class.isAssignableFrom(adapter)) {" + NL + "\t\t\t\t\treturn nextLinkInfo.myElementType;" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t\t" + NL + "\t\t";
  protected final String TEXT_119 = ".ConnectionViewDescriptor descriptor = new ";
  protected final String TEXT_120 = ".ConnectionViewDescriptor(adapter, getFactoryHint(adapter, factoryHint), ";
  protected final String TEXT_121 = ".APPEND, false, ((";
  protected final String TEXT_122 = ") getHost()).getDiagramPreferencesHint());" + NL + "\t\t";
  protected final String TEXT_123 = " ccr = new ";
  protected final String TEXT_124 = "(descriptor);" + NL + "\t\tccr.setType(";
  protected final String TEXT_125 = ".REQ_CONNECTION_START);" + NL + "\t\tccr.setSourceEditPart(sourceEditPart);" + NL + "\t\tsourceEditPart.getCommand(ccr);" + NL + "\t\tccr.setTargetEditPart(targetEditPart);" + NL + "\t\tccr.setType(";
  protected final String TEXT_126 = ".REQ_CONNECTION_END);" + NL + "\t\t";
  protected final String TEXT_127 = " cmd = targetEditPart.getCommand(ccr);" + NL + "\t\tif (cmd != null && cmd.canExecute()) {" + NL + "\t\t\texecuteCommand(cmd);" + NL + "\t\t\t";
  protected final String TEXT_128 = " viewAdapter = (";
  protected final String TEXT_129 = ") ccr.getNewObject();" + NL + "\t\t\t";
  protected final String TEXT_130 = ".makeImmutable(viewAdapter).execute();" + NL + "\t\t}" + NL + "\t}" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_131 = " getDiagram() {" + NL + "\treturn ((View) getHost().getModel()).getDiagram();" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_132 = " getDiagramEditPart() {" + NL + "\treturn (";
  protected final String TEXT_133 = ") getHost().getViewer().getEditPartRegistry().get(getDiagram());" + NL + "}";
  protected final String TEXT_134 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private void refreshReferenceOnlyConnections() {" + NL + "// TODO: implement this method" + NL + "}";
  protected final String TEXT_135 = NL + "}";
  protected final String TEXT_136 = NL;

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
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getCanonicalEditPolicyClassName());
    stringBuffer.append(TEXT_8);
    
GenClass modelElementInterface = genDiagram.getDomainDiagramElement();
if (modelElementInterface != null) {
	Collection genNodes = genDiagram.getTopLevelNodes();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_12);
    
if (genNodes.size() > 0) {
	String modelElementInterfaceName = importManager.getImportedName(modelElementInterface.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_13);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_16);
    
}

    
for (Iterator it = genNodes.iterator(); it.hasNext();) {
	GenNode nextNode = (GenNode) it.next();
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet.isPhantomElement()) {
		continue;
	}
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(getFeatureValueGetter("modelElement", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_20);
    
	} else {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(getFeatureValueGetter("modelElement", childMetaFeature, false, importManager));
    stringBuffer.append(TEXT_22);
    
	}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    stringBuffer.append(nextNode.getVisualID());
    stringBuffer.append(TEXT_25);
    
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_26);
    
	}
}

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    
if (modelElementInterface != null) {
	String modelElementInterfaceName = importManager.getImportedName(modelElementInterface.getQualifiedInterfaceName());

    stringBuffer.append(TEXT_30);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(modelElementInterfaceName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
	GenLink nextGenLink = (GenLink) it.next();
	if (nextGenLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet typeLinkFacet = (TypeLinkModelFacet) nextGenLink.getModelFacet(); 
		GenFeature nextLinkTargetFeature = typeLinkFacet.getTargetMetaFeature();

    stringBuffer.append(TEXT_36);
    stringBuffer.append(nextGenLink.getVisualID());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(nextLinkTargetFeature.isListType() ? "(EObject) " : "");
    stringBuffer.append(getFeatureValueGetter("relationship", nextLinkTargetFeature, true, importManager));
    stringBuffer.append(nextLinkTargetFeature.isListType() ? ".get(0)" : "");
    stringBuffer.append(TEXT_38);
    
	}
}

    stringBuffer.append(TEXT_39);
    
{
	GenClass domainMetaclass = genDiagram.getDomainDiagramElement();
	GenContainerBase genContainerBase = genDiagram;
	if (domainMetaclass != null) {

    stringBuffer.append(TEXT_40);
    
boolean isDiagram = genContainerBase instanceof GenDiagram;

Collection phantomLinks = new ArrayList();
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof FeatureModelFacet) {
		FeatureModelFacet nextModelFacet = (FeatureModelFacet) nextLink.getModelFacet();
		if (nextModelFacet.getMetaFeature().isContains()) {
			phantomLinks.add(nextLink);
		}
	}
}

if (phantomLinks.size() > 0 || isDiagram) {

    stringBuffer.append(TEXT_41);
    
	if (isDiagram) {

    stringBuffer.append(TEXT_42);
    
	}
	
	if (phantomLinks.size() > 0) {

    stringBuffer.append(TEXT_43);
    
	}

    stringBuffer.append(TEXT_44);
    
}

if (phantomLinks.size() > 0) {
	String domainMetaclassInterfaceName = importManager.getImportedName(domainMetaclass.getQualifiedInterfaceName());
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

    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(domainMetaclassInterfaceName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(domainMetaclassInterfaceName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName("java.util.HashMap"));
    stringBuffer.append(TEXT_58);
    
	for (Iterator it = phantomLinks.iterator(); it.hasNext();) {
		GenLink phantomLink = (GenLink) it.next();
		FeatureModelFacet linkFMF = (FeatureModelFacet) phantomLink.getModelFacet();
		GenFeature genFeature = linkFMF.getMetaFeature();

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_61);
    
		GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
		if (phantomNode != null) {
			if (genFeature.isListType()) {

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(getFeatureValueGetter("modelElement", genFeature, true, importManager));
    stringBuffer.append(TEXT_64);
    
			} else {

    stringBuffer.append(TEXT_65);
    stringBuffer.append(getFeatureValueGetter("modelElement", genFeature, true, importManager));
    stringBuffer.append(TEXT_66);
    
			}

    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(phantomNode.getVisualID());
    stringBuffer.append(TEXT_69);
    if (genFeature.isListType()) {
    stringBuffer.append(TEXT_70);
    }
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(phantomLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_74);
    stringBuffer.append(phantomLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_75);
    
			if (genFeature.isListType()) {

    stringBuffer.append(TEXT_76);
    
			}
		}

    stringBuffer.append(TEXT_77);
    
	}
	
	if (isDiagram) {

    stringBuffer.append(TEXT_78);
    
	}

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.ICommand"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.type.core.IElementType"));
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_122);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewRequest"));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_125);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants"));
    stringBuffer.append(TEXT_126);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_127);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_128);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_129);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand"));
    stringBuffer.append(TEXT_130);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_131);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_132);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_133);
    
}


if (isDiagram) {

    stringBuffer.append(TEXT_134);
    
}

    
	}
}

    stringBuffer.append(TEXT_135);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_136);
    return stringBuffer.toString();
  }
}
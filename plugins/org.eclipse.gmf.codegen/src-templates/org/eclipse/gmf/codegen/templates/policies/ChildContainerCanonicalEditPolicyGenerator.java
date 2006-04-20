package org.eclipse.gmf.codegen.templates.policies;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ChildContainerCanonicalEditPolicyGenerator {
 
  protected static String nl;
  public static synchronized ChildContainerCanonicalEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ChildContainerCanonicalEditPolicyGenerator result = new ChildContainerCanonicalEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends CanonicalEditPolicy {" + NL;
  protected final String TEXT_9 = NL;
  protected final String TEXT_10 = "/**" + NL + " * @generated" + NL + " */" + NL + "protected ";
  protected final String TEXT_11 = " getSemanticChildrenList() {" + NL + "\t";
  protected final String TEXT_12 = " result = new ";
  protected final String TEXT_13 = "();";
  protected final String TEXT_14 = NL + "\t";
  protected final String TEXT_15 = " modelObject = ((";
  protected final String TEXT_16 = ") getHost().getModel()).getElement();" + NL + "\t";
  protected final String TEXT_17 = " viewObject = (";
  protected final String TEXT_18 = ") getHost().getModel();";
  protected final String TEXT_19 = "\t";
  protected final String TEXT_20 = " nextValue;" + NL + "\tint nodeVID;";
  protected final String TEXT_21 = "\tfor (";
  protected final String TEXT_22 = " values = ";
  protected final String TEXT_23 = ".iterator(); values.hasNext();) {" + NL + "\t\tnextValue = (";
  protected final String TEXT_24 = ") values.next();";
  protected final String TEXT_25 = NL + "\tnextValue = ";
  protected final String TEXT_26 = ";";
  protected final String TEXT_27 = NL + "\tnodeVID = ";
  protected final String TEXT_28 = ".INSTANCE.getNodeVisualID(viewObject, nextValue);";
  protected final String TEXT_29 = NL + "\tswitch (nodeVID) {";
  protected final String TEXT_30 = NL + "\tcase ";
  protected final String TEXT_31 = ".VISUAL_ID: {";
  protected final String TEXT_32 = NL + "\tif (";
  protected final String TEXT_33 = ".VISUAL_ID == nodeVID) {";
  protected final String TEXT_34 = NL + "\t\tresult.add(nextValue);";
  protected final String TEXT_35 = NL;
  protected final String TEXT_36 = "\t\tbreak;";
  protected final String TEXT_37 = "\t}";
  protected final String TEXT_38 = NL + "\t}";
  protected final String TEXT_39 = NL + "\t}";
  protected final String TEXT_40 = NL + "\treturn result;" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected boolean shouldDeleteView(";
  protected final String TEXT_41 = " view) {" + NL + "\t";
  protected final String TEXT_42 = " domainModelElement = view.getElement();" + NL + "\treturn domainModelElement != null && domainModelElement != ((";
  protected final String TEXT_43 = ") getHost().getModel()).getElement() && super.shouldDeleteView(view);" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "protected String getDefaultFactoryHint() {" + NL + "\treturn null;" + NL + "}";
  protected final String TEXT_44 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_45 = " getSemanticChildrenList() {" + NL + "\t\treturn ";
  protected final String TEXT_46 = ".EMPTY_LIST;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldDeleteView(View view) {" + NL + "\t\treturn ";
  protected final String TEXT_47 = ".resolveSemanticElement(view) == null;" + NL + "\t}";
  protected final String TEXT_48 = NL + "\t";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void refreshSemantic() {" + NL + "\t\tsuper.refreshSemantic();" + NL + "\t\trefreshPhantoms();" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void refreshPhantoms() {" + NL + "\t\t";
  protected final String TEXT_51 = " phantomNodes = new ";
  protected final String TEXT_52 = "();" + NL + "\t\t";
  protected final String TEXT_53 = " container = ((";
  protected final String TEXT_54 = ") getHost().getModel()).getElement();" + NL + "\t\t";
  protected final String TEXT_55 = " containerMetaclass = container.eClass();" + NL + "\t\t";
  protected final String TEXT_56 = " diagram = getDiagram();";
  protected final String TEXT_57 = NL;
  protected final String TEXT_58 = "\tif (";
  protected final String TEXT_59 = ".eINSTANCE.get";
  protected final String TEXT_60 = "().isSuperTypeOf(containerMetaclass)) {";
  protected final String TEXT_61 = NL + "\t\tfor (";
  protected final String TEXT_62 = " destinations = ";
  protected final String TEXT_63 = ".iterator(); destinations.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_64 = " nextDestination = (";
  protected final String TEXT_65 = ") destinations.next();";
  protected final String TEXT_66 = NL + "\t\t";
  protected final String TEXT_67 = " nextDestination = (";
  protected final String TEXT_68 = ") ";
  protected final String TEXT_69 = ";";
  protected final String TEXT_70 = NL + "\t\tif (";
  protected final String TEXT_71 = ".VISUAL_ID == ";
  protected final String TEXT_72 = ".INSTANCE.getNodeVisualID(diagram, nextDestination)) {";
  protected final String TEXT_73 = NL + "\t\t\tphantomNodes.add(nextDestination);";
  protected final String TEXT_74 = NL;
  protected final String TEXT_75 = NL + "\t\t}";
  protected final String TEXT_76 = NL + "\t\t}";
  protected final String TEXT_77 = NL + "\t}";
  protected final String TEXT_78 = NL;
  protected final String TEXT_79 = NL;
  protected final String TEXT_80 = "for (";
  protected final String TEXT_81 = " diagramNodes = getDiagram().getChildren().iterator(); diagramNodes.hasNext();) {" + NL + "\t";
  protected final String TEXT_82 = " nextView = (";
  protected final String TEXT_83 = ") diagramNodes.next();" + NL + "\t";
  protected final String TEXT_84 = " nextViewElement = nextView.getElement();" + NL + "\tif (phantomNodes.contains(nextViewElement)) {" + NL + "\t\tphantomNodes.remove(nextViewElement);" + NL + "\t}\t" + NL + "}" + NL + "\t\tcreatePhantomNodes(phantomNodes);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_85 = NL;
  protected final String TEXT_86 = "/**" + NL + " * @generated" + NL + " */" + NL + "private void createPhantomNodes(";
  protected final String TEXT_87 = " nodes) {" + NL + "\tif (nodes.isEmpty()) {" + NL + "\t\treturn;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_88 = " descriptors = new ";
  protected final String TEXT_89 = "();" + NL + "\tfor (";
  protected final String TEXT_90 = " elements = nodes.iterator(); elements.hasNext();) {" + NL + "\t\t";
  protected final String TEXT_91 = " element = (";
  protected final String TEXT_92 = ")elements.next();" + NL + "\t\t";
  protected final String TEXT_93 = ".ViewDescriptor descriptor = getViewDescriptor(element);" + NL + "\t\tdescriptors.add(descriptor);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_94 = " diagram = getDiagram();" + NL + "\t";
  protected final String TEXT_95 = " diagramEditPart = getDiagramEditPart();" + NL + "\t" + NL + "\t";
  protected final String TEXT_96 = " request = getCreateViewRequest(descriptors);" + NL + "\t";
  protected final String TEXT_97 = " cmd = diagramEditPart.getCommand(request);" + NL + "\tif (cmd == null) {" + NL + "\t\t";
  protected final String TEXT_98 = " cc = new ";
  protected final String TEXT_99 = "(";
  protected final String TEXT_100 = ".AddCommand_Label);" + NL + "\t\tfor (";
  protected final String TEXT_101 = " descriptorsIterator = descriptors.iterator(); descriptorsIterator.hasNext();) {" + NL + "\t\t\t";
  protected final String TEXT_102 = ".ViewDescriptor descriptor = (";
  protected final String TEXT_103 = ".ViewDescriptor) descriptorsIterator.next();" + NL + "\t\t\t";
  protected final String TEXT_104 = " createCommand = new ";
  protected final String TEXT_105 = "(((";
  protected final String TEXT_106 = ") getHost()).getEditingDomain(), descriptor, diagram);" + NL + "\t\t\tcc.compose(createCommand);" + NL + "\t\t}" + NL + "\t\tcmd = new ";
  protected final String TEXT_107 = "(cc);" + NL + "\t}\t" + NL + "\t" + NL + "\tif ( cmd != null && cmd.canExecute() ) {" + NL + "\t\t";
  protected final String TEXT_108 = ".makeMutable(new ";
  protected final String TEXT_109 = "(((";
  protected final String TEXT_110 = ") diagramEditPart).getNotationView())).execute();" + NL + "\t\texecuteCommand(cmd);" + NL + "\t\t";
  protected final String TEXT_111 = " adapters = (";
  protected final String TEXT_112 = ") request.getNewObject();" + NL + "\t\tmakeViewsImmutable(adapters);" + NL + "\t}" + NL + "\tdiagramEditPart.refresh();" + NL + "}" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_113 = " getDiagramEditPart() {" + NL + "\treturn (";
  protected final String TEXT_114 = ") getHost().getViewer().getEditPartRegistry().get(getDiagram());" + NL + "}" + NL;
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = "/**" + NL + " * @generated" + NL + " */" + NL + "private ";
  protected final String TEXT_117 = " getDiagram() {" + NL + "\treturn ((";
  protected final String TEXT_118 = ") getHost().getModel()).getDiagram();" + NL + "}";
  protected final String TEXT_119 = NL + NL + "}";
  protected final String TEXT_120 = NL;

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
    
// TODO: move this attribute to the genmodel
final boolean isSynchronizedDiagram = true;

GenChildContainer genContainer = (GenChildContainer) ((Object[]) argument)[0];
GenDiagram genDiagram = genContainer.getDiagram();

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
    stringBuffer.append(genContainer.getCanonicalEditPolicyClassName());
    stringBuffer.append(TEXT_8);
    
if (isSynchronizedDiagram) {
	List genNodes = genContainer.getChildNodes();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_13);
    if (genNodes.size() > 0) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_18);
    }
    
Map genFeature2genNodeMap = new LinkedHashMap();
for (int nodeIndex = 0; nodeIndex < genNodes.size(); nodeIndex++) {
	GenNode nextNode = (GenNode) genNodes.get(nodeIndex);
	TypeModelFacet typeModelFacet = nextNode.getModelFacet();
	if (typeModelFacet.isPhantomElement()) {
		// Skipping top-level phantoms
		continue;
	}
	GenFeature childMetaFeature = typeModelFacet.getChildMetaFeature();
	if (!genFeature2genNodeMap.containsKey(childMetaFeature)) {
		genFeature2genNodeMap.put(childMetaFeature, new ArrayList());
	}
	((Collection) genFeature2genNodeMap.get(childMetaFeature)).add(nextNode);
}

Set entrySet = genFeature2genNodeMap.entrySet();
if (entrySet.size() > 0) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_20);
    
}

for (Iterator entries = entrySet.iterator(); entries.hasNext();) {
	Map.Entry nextEntry = (Map.Entry) entries.next();
	GenFeature childMetaFeature = (GenFeature) nextEntry.getKey();
	Collection genNodesCollection = (Collection) nextEntry.getValue();
	if (childMetaFeature.isListType()) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_24);
    	} else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(getFeatureValueGetter("modelObject", childMetaFeature, true, importManager));
    stringBuffer.append(TEXT_26);
    	}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    	boolean generateSwitch = genNodesCollection.size() != 1;
	if (generateSwitch) {
    stringBuffer.append(TEXT_29);
    	}
	
	for (Iterator genNodesIterator = genNodesCollection.iterator(); genNodesIterator.hasNext();) {
		GenNode nextNode = (GenNode) genNodesIterator.next();
		if (generateSwitch) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    		} else {
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(nextNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    		}
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    		if (generateSwitch) {
    stringBuffer.append(TEXT_36);
    		}
    stringBuffer.append(TEXT_37);
    	}
	if (generateSwitch) {
    stringBuffer.append(TEXT_38);
    	}
	if (childMetaFeature.isListType()) {
    stringBuffer.append(TEXT_39);
    	}
}
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("java.util.Collections"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.core.util.ViewUtil"));
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    if (genContainer instanceof GenNode && isSynchronizedDiagram) {
    stringBuffer.append(TEXT_49);
    
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

    
List phantomLinks = new LinkedList();
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext();) {
	GenLink nextLink = (GenLink) it.next();
	if (nextLink.getModelFacet() instanceof FeatureModelFacet) {
		FeatureModelFacet nextModelFacet = (FeatureModelFacet) nextLink.getModelFacet();
		if (nextModelFacet.getMetaFeature().isContains()) {
			phantomLinks.add(nextLink);
		}
	}
}
	
if (genClass2Phantom.size() > 0 && phantomLinks.size() > 0) {

    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("java.util.LinkedList"));
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EClass"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_56);
    	
	List genLinks = phantomLinks;
	for (int linkIndex = 0; linkIndex < genLinks.size(); linkIndex++) {
		boolean phantomsOnly = true;

    stringBuffer.append(TEXT_57);
    
GenLink nextLink = (GenLink) genLinks.get(linkIndex);
if (false == nextLink.getModelFacet() instanceof FeatureModelFacet) {
	continue;
}
FeatureModelFacet linkFMF = (FeatureModelFacet) nextLink.getModelFacet();
GenFeature genFeature = linkFMF.getMetaFeature();
GenTopLevelNode phantomNode = (GenTopLevelNode) genClass2Phantom.get(genFeature.getTypeGenClass());
if (phantomsOnly ? (!genFeature.isContains() || phantomNode == null) : (genFeature.isContains())) {
// Processing only features which are isPhantoms == phantomsOnly
	continue;
}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_60);
    	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_65);
    	} else {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(getFeatureValueGetter("container", genFeature, true, importManager));
    stringBuffer.append(TEXT_69);
    	}
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName(phantomNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_72);
    	}
    stringBuffer.append(TEXT_73);
    stringBuffer.append(TEXT_74);
    	if (phantomsOnly) {
    stringBuffer.append(TEXT_75);
    	}
	if (genFeature.isListType()) {
    stringBuffer.append(TEXT_76);
    	}
    stringBuffer.append(TEXT_77);
    	}
    stringBuffer.append(TEXT_78);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("java.util.Collection"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.commands.Command"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.CompositeCommand"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("java.util.Iterator"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.common.core.command.ICommand"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.CreateCommand"));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.commands.SetViewMutabilityCommand"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter"));
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart"));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Diagram"));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_118);
    
}

    }
    stringBuffer.append(TEXT_119);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_120);
    return stringBuffer.toString();
  }
}
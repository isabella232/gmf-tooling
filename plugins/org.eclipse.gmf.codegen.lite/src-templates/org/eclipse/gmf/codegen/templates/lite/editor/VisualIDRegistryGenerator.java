package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import java.util.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class VisualIDRegistryGenerator
{
  protected static String nl;
  public static synchronized VisualIDRegistryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    VisualIDRegistryGenerator result = new VisualIDRegistryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * This registry is used to determine which type of visual object should be" + NL + " * created for the corresponding Diagram, Node, ChildNode or Link represented " + NL + " * by a domain model object. Note that it only returns semantically complete objects (those who must have an element associated with them)." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final ";
  protected final String TEXT_6 = " INSTANCE = new ";
  protected final String TEXT_7 = "();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getVisualID(View view) {" + NL + "\t\tif (view instanceof Diagram) {" + NL + "\t\t\tif (";
  protected final String TEXT_8 = ".MODEL_ID.equals(view.getType())) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_9 = ".VISUAL_ID;" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getVisualID(view.getType());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getModelID(View view) {" + NL + "\t\tView diagram = view.getDiagram();" + NL + "\t\twhile (view != diagram) {" + NL + "\t\t\t";
  protected final String TEXT_10 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tif (annotation != null) {" + NL + "\t\t\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\tview = (View) view.eContainer();" + NL + "\t\t}" + NL + "\t\treturn diagram != null ? diagram.getType() : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getVisualID(String type) {" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(type);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\t";
  protected final String TEXT_11 = ".getInstance().logInfo(\"Unable to parse view type as a visualID number: \" + type);" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getType(int visualID) {" + NL + "\t\treturn String.valueOf(visualID);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_12 = NL + "\t\tif (";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "().equals(domainElementMetaclass) && isDiagram";
  protected final String TEXT_15 = "((";
  protected final String TEXT_16 = ") domainElement)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_17 = ".VISUAL_ID;" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\treturn getUnrecognizedDiagramID(domainElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(containerView, domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass) {" + NL + "\t\tString containerModelID = getModelID(containerView);" + NL + "\t\tif (!";
  protected final String TEXT_19 = ".MODEL_ID.equals(containerModelID)) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tint containerVisualID;" + NL + "\t\tif (";
  protected final String TEXT_20 = ".MODEL_ID.equals(containerModelID)) {" + NL + "\t\t\tcontainerVisualID = getVisualID(containerView);" + NL + "\t\t} else {" + NL + "\t\t\tif (containerView instanceof Diagram) {" + NL + "\t\t\t\tcontainerVisualID = ";
  protected final String TEXT_21 = ".VISUAL_ID;" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tswitch (containerVisualID) {";
  protected final String TEXT_22 = NL + "\t\tcase ";
  protected final String TEXT_23 = ".VISUAL_ID:";
  protected final String TEXT_24 = NL + "\t\t\tif (";
  protected final String TEXT_25 = ".eINSTANCE.get";
  protected final String TEXT_26 = "().isSuperTypeOf(domainElementMetaclass) && isNode";
  protected final String TEXT_27 = "((";
  protected final String TEXT_28 = ") domainElement)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_29 = ".VISUAL_ID;" + NL + "\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_31 = "ChildNodeID(domainElement);";
  protected final String TEXT_32 = NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_33 = NL + "\t\tif (";
  protected final String TEXT_34 = ".eINSTANCE.get";
  protected final String TEXT_35 = "().isSuperTypeOf(domainElementMetaclass) && isLinkWithClass";
  protected final String TEXT_36 = "((";
  protected final String TEXT_37 = ") domainElement)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_38 = ".VISUAL_ID;" + NL + "\t\t}";
  protected final String TEXT_39 = NL + "\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t}" + NL;
  protected final String TEXT_40 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_41 = "(";
  protected final String TEXT_42 = " element) {" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_43 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL;
  protected final String TEXT_44 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_45 = "(";
  protected final String TEXT_46 = " element) {" + NL + "\t\treturn ";
  protected final String TEXT_47 = ".matches(element)";
  protected final String TEXT_48 = "true";
  protected final String TEXT_49 = ";" + NL + "\t}";
  protected final String TEXT_50 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_51 = "ChildNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_52 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL;
  protected final String TEXT_53 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isLinkWithClass";
  protected final String TEXT_54 = "(";
  protected final String TEXT_55 = " element) {" + NL + "\t\treturn ";
  protected final String TEXT_56 = ".matches(element)";
  protected final String TEXT_57 = "true";
  protected final String TEXT_58 = ";" + NL + "\t}";
  protected final String TEXT_59 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final ";
  protected final String TEXT_60 = " ";
  protected final String TEXT_61 = " = new ";
  protected final String TEXT_62 = "(";
  protected final String TEXT_63 = "null";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = "(";
  protected final String TEXT_66 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_67 = ", ";
  protected final String TEXT_68 = ")";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = "(";
  protected final String TEXT_71 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_72 = ")";
  protected final String TEXT_73 = "new ";
  protected final String TEXT_74 = "(";
  protected final String TEXT_75 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_76 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_77 = " self = (";
  protected final String TEXT_78 = ")context;";
  protected final String TEXT_79 = "\t" + NL + "\t\t";
  protected final String TEXT_80 = " ";
  protected final String TEXT_81 = " = (";
  protected final String TEXT_82 = ")env.get(\"";
  protected final String TEXT_83 = "\"); //$NON-NLS-1$";
  protected final String TEXT_84 = NL + "\t\treturn ";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "(self";
  protected final String TEXT_87 = ", ";
  protected final String TEXT_88 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_89 = NL + ");";
  protected final String TEXT_90 = "\t\t\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tstatic class ";
  protected final String TEXT_91 = " {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_92 = " condition;" + NL + "\t\t\t\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_93 = "(";
  protected final String TEXT_94 = " conditionExpression) {\t\t\t" + NL + "\t\t\tthis.condition = conditionExpression;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t\t" + NL + "\t\tboolean matches(EObject object) {" + NL + "\t\t\tObject result = condition.evaluate(object);" + NL + "\t\t\treturn result instanceof Boolean && ((Boolean)result).booleanValue();\t\t\t" + NL + "\t\t}" + NL + "\t}// ";
  protected final String TEXT_95 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private static class ";
  protected final String TEXT_96 = " {";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_99 = " ";
  protected final String TEXT_100 = "(";
  protected final String TEXT_101 = " self";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = " ";
  protected final String TEXT_104 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_105 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_106 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_107 = NL + "\t}// ";
  protected final String TEXT_108 = NL + "}" + NL + "\t";
  protected final String TEXT_109 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);

final String matcherClassName = "Matcher";
final String javaMatcherContainer = "JavaMatchers";
importManager.registerInnerClass(matcherClassName);
importManager.registerInnerClass(javaMatcherContainer);

importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    
if (genDiagram.getDomainDiagramElement() != null) {	/*we do not support diagrams without domain elements in other places, but keep this copy-pasted occurrence*/
	String classifierAccessorName = genDiagram.getDomainDiagramElement().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getMetaPackageName(importManager));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_21);
    
List nodeContainers = genDiagram.getAllContainers();
for(Iterator it = nodeContainers.iterator(); it.hasNext(); ) {
	GenContainerBase nextContainer = (GenContainerBase) it.next();
	if (nextContainer.getContainedNodes().isEmpty()) {
		continue;
	}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(nextContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    
	for (Iterator childNodes = nextContainer.getContainedNodes().iterator(); childNodes.hasNext(); ) {
		GenNode childNode = (GenNode) childNodes.next();
		final String classifierAccessorName = childNode.getDomainMetaClass().getClassifierAccessorName();
		final String interfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getQualifiedInterfaceName());
		final String semanticPackageInterfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()); 

    stringBuffer.append(TEXT_24);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(childNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(childNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_31);
    
}

    stringBuffer.append(TEXT_32);
    
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
	GenLink genLink = (GenLink) it.next();
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		final TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		final String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		final String interfaceName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
		final String semanticPackageInterfaceName = importManager.getImportedName(modelFacet.getMetaClass().getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_33);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    
	}
}

    stringBuffer.append(TEXT_39);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    
for (Iterator nodes = genDiagram.getAllNodes().iterator(); nodes.hasNext();) {
	GenNode nextNode = (GenNode) nodes.next();
	if (nextNode.getModelFacet() == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());
	boolean callMatcher = nextNode.getModelFacet() != null && nextNode.getModelFacet().getModelElementSelector() != null;

    stringBuffer.append(TEXT_44);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_46);
    if (callMatcher) {
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    
}
for (Iterator containers = nodeContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();
	if (nextContainer.getContainedNodes().isEmpty()) {
		continue;
	}

    stringBuffer.append(TEXT_50);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_51);
    
}

    stringBuffer.append(TEXT_52);
    
for (Iterator it = genDiagram.getLinks().iterator(); it.hasNext(); ) {
	GenLink genLink = (GenLink) it.next();
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String interfaceName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
		boolean callMatcher = modelFacet.getModelElementSelector() != null;		

    stringBuffer.append(TEXT_53);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_55);
    if (callMatcher) {
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_56);
    } else {
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    
	}
}


final GenExpressionProviderContainer expressionProviders = genDiagram.getEditorGen().getExpressionProviders();
final List javaSelectorFacets = new ArrayList();
final Map __exprEnvVariables = Collections.EMPTY_MAP;
final String __outEnvVarName = null; // no custom env
final String __javaOperationContainer = javaMatcherContainer; // put method here

int selectorCounter = 0;
for (Iterator it = genDiagram.eAllContents(); it.hasNext() && expressionProviders != null;) {
	Object next = it.next();
	String id = null;
	TypeModelFacet modelFacet = null;
	if (next instanceof GenNode) {
		id = ((GenNode) next).getUniqueIdentifier();
		modelFacet = ((GenNode) next).getModelFacet();
	} else if (next instanceof GenLink && ((GenLink) next).getModelFacet() instanceof TypeLinkModelFacet) {
		id = ((GenLink) next).getUniqueIdentifier();
		modelFacet = (TypeLinkModelFacet) ((GenLink) next).getModelFacet();
	}
	if (modelFacet == null || modelFacet.getModelElementSelector() == null || modelFacet.getMetaClass() == null) {
		continue;
	}
	GenConstraint selector = modelFacet.getModelElementSelector();
	selectorCounter++;
	// setup expression factory
	ValueExpression __genValueExpression = selector;
	GenClassifier __genExprContext = modelFacet.getMetaClass();
	GenExpressionProviderBase expressionProvider = expressionProviders.getProvider(__genValueExpression); 
	if(expressionProvider instanceof GenJavaExpressionProvider && !expressionProviders.isCopy(__genValueExpression)) {
		// skipping duplicates coming from reused node mappings 
		javaSelectorFacets.add(modelFacet);
	}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_62);
    
{ /*begin the scope*/
/*
ValueExpression __genValueExpression;
GenClassifier __genExprContext
java.util.Map __exprEnvVariables
String __outEnvVarName;
String __javaOperationContainer;
*/
	org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
	String __ctxEClassifierAccess = importManager.getImportedName(__genExprContext.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + __genExprContext.getClassifierAccessorName()+"()";
	String __importedAbstractClass = __genExprProvider != null ? importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName()) : null;

	if(__genExprProvider == null || __importedAbstractClass == null) {

    stringBuffer.append(TEXT_63);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		String __bodyLiteral = org.eclipse.gmf.internal.common.codegen.Conversions.toStringLiteral(__genValueExpression.getBody());
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_68);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(__bodyLiteral);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_72);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_73);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_78);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_83);
    		} 
    stringBuffer.append(TEXT_84);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_85);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_86);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_87);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_88);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_89);
    
} /* end of selector interation */

if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_90);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_92);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(matcherClassName);
    
	if(!javaSelectorFacets.isEmpty()) {

    stringBuffer.append(TEXT_95);
    stringBuffer.append(javaMatcherContainer);
    stringBuffer.append(TEXT_96);
    
		for(Iterator it = javaSelectorFacets.iterator(); it.hasNext();) {
			TypeModelFacet modelFacet = (TypeModelFacet) it.next();
			ValueExpression __genValueExpression = modelFacet.getModelElementSelector();
			GenClassifier __genExprContext = modelFacet.getMetaClass();
			String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_97);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String __importedAbstractExpr = importManager.getImportedName(__genExprProvider.getContainer().getAbstractExpressionQualifiedClassName());
	String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = __genExprProvider.getQualifiedInstanceClassName((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj);
	String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);

    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_101);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_104);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_106);
    
} /* end of GenJavaExpressionProvider */

    
		} /* java javaSelectorFacets iteration */

    stringBuffer.append(TEXT_107);
    stringBuffer.append(javaMatcherContainer);
    
	} /* !javaSelectorFacets.isEmpty() */
} /* selectorCounter > 0 */

    stringBuffer.append(TEXT_108);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_4 = NL + "\t" + NL + "/**" + NL + " * This registry is used to determine which type of visual object should be" + NL + " * created for the corresponding Diagram, Node, ChildNode or Link represented " + NL + " * by a domain model object." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class VisualIDRegistry {" + NL + "" + NL + "\tpublic static final VisualIDRegistry INSTANCE = new VisualIDRegistry();" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_5 = NL + "\t\tif (";
  protected final String TEXT_6 = ".eINSTANCE.get";
  protected final String TEXT_7 = "().equals(domainElementMetaclass) && (domainElement != null ? isDiagram";
  protected final String TEXT_8 = "((";
  protected final String TEXT_9 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_10 = ";" + NL + "\t\t}" + NL + "\t\treturn getUnrecognizedDiagramID(domainElement);";
  protected final String TEXT_11 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "//================================================================================================================";
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {" + NL + "\t\tint containerVisualID = getVisualID(containerView);" + NL + "\t\tswitch (containerVisualID) {" + NL + "\t\tcase ";
  protected final String TEXT_13 = ":";
  protected final String TEXT_14 = NL + "\t\t\tif (";
  protected final String TEXT_15 = ".eINSTANCE.get";
  protected final String TEXT_16 = "().equals(domainElementMetaclass) && (domainElement != null ? isNode";
  protected final String TEXT_17 = "((";
  protected final String TEXT_18 = ") domainElement) : true)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_19 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_20 = NL + "\t\t\treturn getUnrecognizedDiagramChildID(domainElement);";
  protected final String TEXT_21 = NL + "\t\tcase ";
  protected final String TEXT_22 = ":";
  protected final String TEXT_23 = NL + "\t\t\tif (";
  protected final String TEXT_24 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_25 = ";" + NL + "\t\t\t}  ";
  protected final String TEXT_26 = NL + "\t\t\tif (";
  protected final String TEXT_27 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_28 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_29 = NL + "\t\t\tif (!\"\".equals(semanticHint)) {" + NL + "\t\t\t\treturn getUnrecognized";
  protected final String TEXT_30 = "ChildNodeID(semanticHint);" + NL + "\t\t\t} ";
  protected final String TEXT_31 = "\t\t" + NL + "\t\t\tif (";
  protected final String TEXT_32 = ".eINSTANCE.get";
  protected final String TEXT_33 = "().equals(domainElementMetaclass) && (domainElement != null ? isChildNode";
  protected final String TEXT_34 = "((";
  protected final String TEXT_35 = ") domainElement) : true)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_36 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_37 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_38 = "ChildNodeID(domainElement);";
  protected final String TEXT_39 = NL + "\t\tcase ";
  protected final String TEXT_40 = ":";
  protected final String TEXT_41 = NL + "\t\t\tif (";
  protected final String TEXT_42 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_43 = ";" + NL + "\t\t\t}";
  protected final String TEXT_44 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_45 = "LinkLabelID(semanticHint);";
  protected final String TEXT_46 = NL + "\t\tcase ";
  protected final String TEXT_47 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_48 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_49 = ";" + NL + "\t\t\t}" + NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_50 = "LinkLabelTextID(semanticHint);";
  protected final String TEXT_51 = NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_52 = NL;
  protected final String TEXT_53 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_54 = " annotation = containerView.getEAnnotation(\"VisualID\");" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"value\");" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\te.printStackTrace();\t\t" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognizedDiagramChildID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_55 = NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_56 = "ChildNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_57 = "ChildNodeID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_58 = NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_59 = "LinkLabelID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_60 = "LinkLabelTextID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_61 = NL + "\t" + NL + "//================================================================================================================" + NL + "" + NL + "\t/**" + NL + "\t * @deprecated" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @deprecated" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_62 = NL + "\t\tif (";
  protected final String TEXT_63 = ".eINSTANCE.get";
  protected final String TEXT_64 = "().equals(domainElementMetaclass) && (domainElement != null ? isNode";
  protected final String TEXT_65 = "((";
  protected final String TEXT_66 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_67 = ";" + NL + "\t\t} else";
  protected final String TEXT_68 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedNodeID(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getChildNodeVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getChildNodeVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getChildNodeVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_69 = NL + "\t\tif (";
  protected final String TEXT_70 = ".eINSTANCE.get";
  protected final String TEXT_71 = "().equals(domainElementMetaclass) && (domainElement != null ? isChildNode";
  protected final String TEXT_72 = "((";
  protected final String TEXT_73 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_74 = ";" + NL + "\t\t} else ";
  protected final String TEXT_75 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedChildNodeID(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedChildNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_76 = NL + "\t\tif (";
  protected final String TEXT_77 = ".eINSTANCE.get";
  protected final String TEXT_78 = "().equals(domainElementMetaclass) && (domainElement != null ? isLinkWithClass";
  protected final String TEXT_79 = "((";
  protected final String TEXT_80 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_81 = ";" + NL + "\t\t} else ";
  protected final String TEXT_82 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t\t";
  protected final String TEXT_85 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_88 = ".matches(element);" + NL + "\t}" + NL;
  protected final String TEXT_89 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isChildNode";
  protected final String TEXT_90 = "(";
  protected final String TEXT_91 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_92 = ".matches(element);" + NL + "\t}" + NL;
  protected final String TEXT_93 = NL + "\t";
  protected final String TEXT_94 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isLinkWithClass";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_97 = ".matches(element);" + NL + "\t}";
  protected final String TEXT_98 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ElementSelectors {\t";
  protected final String TEXT_99 = NL + NL + "\t\t/**" + NL + "\t\t * Element matching condition for ";
  protected final String TEXT_100 = "." + NL + "\t\t * <pre>language: ";
  protected final String TEXT_101 = "</pre>\t" + NL + "\t\t * <pre>body    : ";
  protected final String TEXT_102 = "</pre>" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final Matcher ";
  protected final String TEXT_103 = " = new Matcher(\"";
  protected final String TEXT_104 = "\");";
  protected final String TEXT_105 = NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ElementSelectors() {" + NL + "\t\t}";
  protected final String TEXT_106 = "\t\t\t" + NL + "\t\t/**" + NL + "\t\t* @generated\t" + NL + "\t\t*/" + NL + "\t\tstatic class Matcher {" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate EClass evalContext;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_107 = " condition;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate String body;\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t" + NL + "\t\t\tMatcher(String expressionBody) {\t\t\t" + NL + "\t\t\t\tbody = expressionBody;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tboolean matches(EObject object) {\t\t" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tBoolean result = (object != null) ? evaluate(object) : Boolean.FALSE;" + NL + "\t\t\t\t\treturn result.booleanValue();" + NL + "\t\t\t\t} catch(IllegalArgumentException e) {" + NL + "\t\t\t\t\t// TODO - add log entry" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t" + NL + "\t\t\tprivate Boolean evaluate(EObject context) {" + NL + "\t\t\t\tthis.evalContext = context.eClass();" + NL + "\t\t\t\tif(condition == null) {\t\t\t\t\t" + NL + "\t\t\t\t\tcondition = new OclConstraintCondition(body, evalContext);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(condition != null) {" + NL + "\t\t\t\t\treturn booleanCast(condition.evaluate(context));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate static Boolean booleanCast(Object value) {" + NL + "\t\t\t\tif(value == null) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t} else if(value instanceof Boolean) {" + NL + "\t\t\t\t\t return (Boolean)value;\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t\t} // end of Matcher";
  protected final String TEXT_108 = "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class AcceptAllMatcher {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tstatic final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t\t\t" + NL + "\t\t\tboolean matches(Object element) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tstatic AcceptAllMatcher acceptAllMatcher() {" + NL + "\t\t\treturn AcceptAllMatcher.INSTANCE;" + NL + "\t\t}" + NL + "\t} // end of ElementSelectors" + NL + "}" + NL + "\t";
  protected final String TEXT_109 = NL;

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
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
{
	String classifierAccessorName = genDiagram.getDomainDiagramElement().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_10);
    
}

    stringBuffer.append(TEXT_11);
    
Collection allContainers = AccessUtil.getAllContainers(genDiagram);

    stringBuffer.append(TEXT_12);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_13);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String classifierAccessorName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_14);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_19);
    
}

    stringBuffer.append(TEXT_20);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer nextContainer = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(nextContainer.getVisualID());
    stringBuffer.append(TEXT_22);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(node);
			
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
			GenNodeLabel label = (GenNodeLabel) labels.next();
			String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(label);

    stringBuffer.append(TEXT_23);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_25);
    			
		}
		
		for (Iterator compartments = node.getCompartments().iterator(); compartments.hasNext();) {
			String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
			GenCompartment compartment = (GenCompartment) compartments.next();
			String compartmentId = semanticHintsClassName + ".Compartments." + AccessUtil.getCompartmentId(compartment);

    stringBuffer.append(TEXT_26);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_28);
    
		}
	}

    stringBuffer.append(TEXT_29);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_30);
    	
	for (Iterator childNodes = nextContainer.getChildNodes().iterator(); childNodes.hasNext();) {
		GenNode childNode = (GenNode) childNodes.next();
		String classifierAccessorName = childNode.getDomainMetaClass().getClassifierAccessorName();
		String interfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_31);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(childNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(childNode.getVisualID());
    stringBuffer.append(TEXT_36);
    
	}

    stringBuffer.append(TEXT_37);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_38);
    
}

for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	String semanticHintsQualifiedClassName = genDiagram.getProvidersPackageName() + '.' + AccessUtil.getSemanticHintsClassName(link);

    stringBuffer.append(TEXT_39);
    stringBuffer.append(link.getVisualID());
    stringBuffer.append(TEXT_40);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelId(linkLabel);

    stringBuffer.append(TEXT_41);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_43);
    
	}

    stringBuffer.append(TEXT_44);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_45);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		String semanticHintsClassName = importManager.getImportedName(semanticHintsQualifiedClassName);
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelTextViewId = semanticHintsClassName + ".Labels." + AccessUtil.getLabelTextId(linkLabel);

    stringBuffer.append(TEXT_46);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_50);
    
	}
}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_54);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer nextContainer = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_55);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_57);
    
}

for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_58);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_60);
    
}

    stringBuffer.append(TEXT_61);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_62);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_67);
    
}

    stringBuffer.append(TEXT_68);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = AccessUtil.getAllChildNodes(genNode);
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_69);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_74);
    	}
}

    stringBuffer.append(TEXT_75);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_76);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_81);
    
		}
	}

    stringBuffer.append(TEXT_82);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_84);
    
String acceptAllMatcherAccessor = "acceptAllMatcher()"; //$NON-NLS-1$
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String qualifiedNodeInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();
	String nodeSelector = genNode.getModelFacet() != null && genNode.getModelFacet().getModelElementSelector() != null ? genNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_85);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName(qualifiedNodeInterfaceName));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(nodeSelector);
    stringBuffer.append(TEXT_88);
    
	List genChildNodes = AccessUtil.getAllChildNodes(genNode);
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String qualifiedChildNodeInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();
		String childNodeSelector = genChildNode.getModelFacet() != null && genChildNode.getModelFacet().getModelElementSelector() != null ? genChildNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_89);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(importManager.getImportedName(qualifiedChildNodeInterfaceName));
    stringBuffer.append(TEXT_91);
    stringBuffer.append(childNodeSelector);
    stringBuffer.append(TEXT_92);
    	}
}

    stringBuffer.append(TEXT_93);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		String linkSelector = modelFacet.getModelElementSelector() != null ? genLink.getUniqueIdentifier() : acceptAllMatcherAccessor;		

    stringBuffer.append(TEXT_94);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_96);
    stringBuffer.append(linkSelector);
    stringBuffer.append(TEXT_97);
    
	}
}

    stringBuffer.append(TEXT_98);
    
int selectorCounter = 0;
for (Iterator it = genDiagram.eAllContents(); it.hasNext();) {
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
	if (modelFacet == null || modelFacet.getModelElementSelector() == null) {
		continue;
	}
	ModelElementSelector selector = modelFacet.getModelElementSelector();
	selectorCounter++;

    stringBuffer.append(TEXT_99);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(selector.getLanguage());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_104);
    }
    stringBuffer.append(TEXT_105);
    if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OclConstraintCondition"));
    stringBuffer.append(TEXT_107);
    }
    stringBuffer.append(TEXT_108);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_109);
    return stringBuffer.toString();
  }
}

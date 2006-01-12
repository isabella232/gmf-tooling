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
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "\t" + NL + "/**" + NL + " * This registry is used to determine which type of visual object should be" + NL + " * created for the corresponding Diagram, Node, ChildNode or Link represented " + NL + " * by a domain model object." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\tpublic static final ";
  protected final String TEXT_5 = " INSTANCE = new ";
  protected final String TEXT_6 = "();" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_7 = NL + "\t\tif (";
  protected final String TEXT_8 = ".eINSTANCE.get";
  protected final String TEXT_9 = "().equals(domainElementMetaclass) && (domainElement != null ? isDiagram";
  protected final String TEXT_10 = "((";
  protected final String TEXT_11 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_12 = ";" + NL + "\t\t}" + NL + "\t\treturn getUnrecognizedDiagramID(domainElement);";
  protected final String TEXT_13 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement, String semanticHint) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(containerView, domainElement, domainElementMetaclass, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {" + NL + "\t\tString containerModelID = getModelID(containerView);" + NL + "\t\tif (!\"";
  protected final String TEXT_14 = "\".equals(containerModelID)";
  protected final String TEXT_15 = "\t\t\t" + NL + "\t\t\t&& !\"";
  protected final String TEXT_16 = "\".equals(containerModelID)";
  protected final String TEXT_17 = NL + "\t\t) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tint containerVisualID;" + NL + "\t\tif (\"";
  protected final String TEXT_18 = "\".equals(containerModelID)) {" + NL + "\t\t\tcontainerVisualID = getVisualID(containerView);" + NL + "\t\t} else {" + NL + "\t\t\tif (containerView instanceof Diagram) {" + NL + "\t\t\t\tcontainerVisualID = ";
  protected final String TEXT_19 = ";\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tswitch (containerVisualID) {" + NL + "\t\tcase ";
  protected final String TEXT_20 = ":";
  protected final String TEXT_21 = NL + "\t\t\tif (";
  protected final String TEXT_22 = ".eINSTANCE.get";
  protected final String TEXT_23 = "().equals(domainElementMetaclass) && (domainElement != null ? isNode";
  protected final String TEXT_24 = "((";
  protected final String TEXT_25 = ") domainElement) : true)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_26 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_27 = NL + "\t\t\treturn getUnrecognizedDiagramChildID(domainElement);";
  protected final String TEXT_28 = NL + "\t\tcase ";
  protected final String TEXT_29 = ":";
  protected final String TEXT_30 = NL + "\t\t\tif (";
  protected final String TEXT_31 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_32 = ";" + NL + "\t\t\t}";
  protected final String TEXT_33 = NL + "\t\t\tif (";
  protected final String TEXT_34 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_35 = ";" + NL + "\t\t\t}  ";
  protected final String TEXT_36 = NL + "\t\t\tif (";
  protected final String TEXT_37 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_38 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_39 = NL + "\t\t\tif (!\"\".equals(semanticHint)) {" + NL + "\t\t\t\treturn getUnrecognized";
  protected final String TEXT_40 = "ChildNodeID(semanticHint);" + NL + "\t\t\t} ";
  protected final String TEXT_41 = "\t\t" + NL + "\t\t\tif (";
  protected final String TEXT_42 = ".eINSTANCE.get";
  protected final String TEXT_43 = "().equals(domainElementMetaclass) && (domainElement != null ? isChildNode";
  protected final String TEXT_44 = "((";
  protected final String TEXT_45 = ") domainElement) : true)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_46 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_47 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_48 = "ChildNodeID(domainElement);";
  protected final String TEXT_49 = NL + "\t\tcase ";
  protected final String TEXT_50 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_51 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_52 = ";" + NL + "\t\t\t}" + NL + "\t\t\treturn -1;";
  protected final String TEXT_53 = NL + "\t\tcase ";
  protected final String TEXT_54 = ":";
  protected final String TEXT_55 = NL + "\t\t\tif (";
  protected final String TEXT_56 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_57 = ";" + NL + "\t\t\t}";
  protected final String TEXT_58 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_59 = "LinkLabelID(semanticHint);";
  protected final String TEXT_60 = NL + "\t\tcase ";
  protected final String TEXT_61 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_62 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_63 = ";" + NL + "\t\t\t}" + NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_64 = "LinkLabelTextID(semanticHint);";
  protected final String TEXT_65 = NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_66 = NL + "\t\tif (";
  protected final String TEXT_67 = ".eINSTANCE.get";
  protected final String TEXT_68 = "().equals(domainElementMetaclass) && (domainElement != null ? isLinkWithClass";
  protected final String TEXT_69 = "((";
  protected final String TEXT_70 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_71 = ";" + NL + "\t\t} else ";
  protected final String TEXT_72 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t\t}" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_73 = "(";
  protected final String TEXT_74 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_75 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_76 = "(";
  protected final String TEXT_77 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_78 = ".matches(element);" + NL + "\t}";
  protected final String TEXT_79 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isChildNode";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_82 = ".matches(element);" + NL + "\t}\t";
  protected final String TEXT_83 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognizedDiagramChildID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_84 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_85 = "ChildNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_86 = "ChildNodeID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_87 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_88 = "LinkLabelID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_89 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_90 = "LinkLabelTextID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_91 = NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_92 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isLinkWithClass";
  protected final String TEXT_93 = "(";
  protected final String TEXT_94 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_95 = ".matches(element);" + NL + "\t}";
  protected final String TEXT_96 = NL;
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getModelID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_99 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t}" + NL;
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_102 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"visualID\"); //$NON-NLS-1$" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\te.printStackTrace();\t\t" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ElementSelectors {\t";
  protected final String TEXT_103 = NL + NL + "\t\t/**" + NL + "\t\t * Element matching condition for ";
  protected final String TEXT_104 = "." + NL + "\t\t * <pre>language: ";
  protected final String TEXT_105 = "</pre>\t" + NL + "\t\t * <pre>body    : ";
  protected final String TEXT_106 = "</pre>" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final Matcher ";
  protected final String TEXT_107 = " = new Matcher(\"";
  protected final String TEXT_108 = "\");";
  protected final String TEXT_109 = NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ElementSelectors() {" + NL + "\t\t}";
  protected final String TEXT_110 = "\t\t\t" + NL + "\t\t/**" + NL + "\t\t* @generated\t" + NL + "\t\t*/" + NL + "\t\tstatic class Matcher {" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate EClass evalContext;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_111 = " condition;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate String body;\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t" + NL + "\t\t\tMatcher(String expressionBody) {\t\t\t" + NL + "\t\t\t\tbody = expressionBody;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tboolean matches(EObject object) {\t\t" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tBoolean result = (object != null) ? evaluate(object) : Boolean.FALSE;" + NL + "\t\t\t\t\treturn result.booleanValue();" + NL + "\t\t\t\t} catch(IllegalArgumentException e) {" + NL + "\t\t\t\t\t// TODO - add log entry" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t" + NL + "\t\t\tprivate Boolean evaluate(EObject context) {" + NL + "\t\t\t\tthis.evalContext = context.eClass();" + NL + "\t\t\t\tif(condition == null) {\t\t\t\t\t" + NL + "\t\t\t\t\tcondition = new OclConstraintCondition(body, evalContext);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(condition != null) {" + NL + "\t\t\t\t\treturn booleanCast(condition.evaluate(context));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate static Boolean booleanCast(Object value) {" + NL + "\t\t\t\tif(value == null) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t} else if(value instanceof Boolean) {" + NL + "\t\t\t\t\t return (Boolean)value;\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t\t} // end of Matcher";
  protected final String TEXT_112 = "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class AcceptAllMatcher {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tstatic final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t\t\t" + NL + "\t\t\tboolean matches(Object element) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tstatic AcceptAllMatcher acceptAllMatcher() {" + NL + "\t\t\treturn AcceptAllMatcher.INSTANCE;" + NL + "\t\t}" + NL + "\t} // end of ElementSelectors" + NL + "}" + NL + "\t";
  protected final String TEXT_113 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
List genNodes = genDiagram.getNodes();
List genLinks = genDiagram.getLinks();
Collection allContainers = AccessUtil.getAllContainers(genDiagram);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());

importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_6);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
{
	String classifierAccessorName = genDiagram.getDomainDiagramElement().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_7);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_12);
    
}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getEMFGenModel().getModelName());
    stringBuffer.append(TEXT_14);
    
for (Iterator it = genDiagram.getShortcutsProvidedFor().iterator(); it.hasNext();) { 
	String nextDomainModelName = (String) it.next();
	if (genDiagram.getEMFGenModel().getModelName().equals(nextDomainModelName)) {
		continue;
	}

    stringBuffer.append(TEXT_15);
    stringBuffer.append(nextDomainModelName);
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getEMFGenModel().getModelName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_20);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String classifierAccessorName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_21);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_26);
    
}

    stringBuffer.append(TEXT_27);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer nextContainer = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_28);
    stringBuffer.append(nextContainer.getVisualID());
    stringBuffer.append(TEXT_29);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();
			if (label instanceof ExternalLabel) {
				String labelViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + ((ExternalLabel) label).getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_30);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_32);
    
			} else {
				String labelTextViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + label.getSemanticHintFieldName();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_35);
    
			}
		}
		for (Iterator compartments = node.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment compartment = (GenCompartment) compartments.next();
			String compartmentId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Compartments." + compartment.getSemanticHintFieldName();

    stringBuffer.append(TEXT_36);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_38);
    
		}
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    	
	for (Iterator childNodes = nextContainer.getChildNodes().iterator(); childNodes.hasNext();) {
		GenNode childNode = (GenNode) childNodes.next();
		String classifierAccessorName = childNode.getDomainMetaClass().getClassifierAccessorName();
		String interfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_41);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(childNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(childNode.getVisualID());
    stringBuffer.append(TEXT_46);
    
	}

    stringBuffer.append(TEXT_47);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_48);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();
			if (label instanceof ExternalLabel) {
				String labelTextViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + label.getSemanticHintFieldName();

    stringBuffer.append(TEXT_49);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_52);
    
			}
		}
	}
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());

    stringBuffer.append(TEXT_53);
    stringBuffer.append(link.getVisualID());
    stringBuffer.append(TEXT_54);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelViewId = semanticHintsClassName + '.' + link.getUniqueIdentifier() + "Labels." + linkLabel.getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_55);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_57);
    
	}

    stringBuffer.append(TEXT_58);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_59);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelTextViewId = semanticHintsClassName + '.' + link.getUniqueIdentifier() + "Labels." + linkLabel.getSemanticHintFieldName();

    stringBuffer.append(TEXT_60);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_63);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_64);
    
	}
}

    stringBuffer.append(TEXT_65);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_66);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_71);
    
		}
	}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_74);
    
String acceptAllMatcherAccessor = "acceptAllMatcher()"; //$NON-NLS-1$
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String qualifiedNodeInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();
	String nodeSelector = genNode.getModelFacet() != null && genNode.getModelFacet().getModelElementSelector() != null ? genNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_75);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName(qualifiedNodeInterfaceName));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(nodeSelector);
    stringBuffer.append(TEXT_78);
    
}

for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer nextContainer = (GenChildContainer) containers.next();
	for (Iterator childNodes = nextContainer.getChildNodes().iterator(); childNodes.hasNext();) {
		GenChildNode nextChildNode = (GenChildNode) childNodes.next();
		String qualifiedChildNodeInterfaceName = nextChildNode.getDomainMetaClass().getQualifiedInterfaceName();
		String childNodeSelector = nextChildNode.getModelFacet() != null && nextChildNode.getModelFacet().getModelElementSelector() != null ? nextChildNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_79);
    stringBuffer.append(nextChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(qualifiedChildNodeInterfaceName));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(childNodeSelector);
    stringBuffer.append(TEXT_82);
    
	}
}

    stringBuffer.append(TEXT_83);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenChildContainer nextContainer = (GenChildContainer) containers.next();

    stringBuffer.append(TEXT_84);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_86);
    
}

for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_87);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_88);
    
	if (link.getLabels().size() > 0) {

    stringBuffer.append(TEXT_89);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_90);
    
	}
}

    stringBuffer.append(TEXT_91);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		String linkSelector = modelFacet.getModelElementSelector() != null ? genLink.getUniqueIdentifier() : acceptAllMatcherAccessor;		

    stringBuffer.append(TEXT_92);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(linkSelector);
    stringBuffer.append(TEXT_95);
    
	}
}

    stringBuffer.append(TEXT_96);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_102);
    
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

    stringBuffer.append(TEXT_103);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(selector.getLanguage());
    stringBuffer.append(TEXT_105);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_106);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OclConstraintCondition"));
    stringBuffer.append(TEXT_111);
    }
    stringBuffer.append(TEXT_112);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_113);
    return stringBuffer.toString();
  }
}

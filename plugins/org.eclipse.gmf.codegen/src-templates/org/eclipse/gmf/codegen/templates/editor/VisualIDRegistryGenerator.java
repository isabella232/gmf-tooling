package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import java.util.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_2 = NL + "\t" + NL + "/**" + NL + " * This registry is used to determine which type of visual object should be" + NL + " * created for the corresponding Diagram, Node, ChildNode or Link represented " + NL + " * by a domain model object." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\tpublic static final ";
  protected final String TEXT_4 = " INSTANCE = new ";
  protected final String TEXT_5 = "();" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_6 = NL + "\t\tif (";
  protected final String TEXT_7 = ".eINSTANCE.get";
  protected final String TEXT_8 = "().equals(domainElementMetaclass) && (domainElement != null ? isDiagram";
  protected final String TEXT_9 = "((";
  protected final String TEXT_10 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_11 = ";" + NL + "\t\t}" + NL + "\t\treturn getUnrecognizedDiagramID(domainElement);";
  protected final String TEXT_12 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement, String semanticHint) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(containerView, domainElement, domainElementMetaclass, semanticHint);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {" + NL + "\t\tString containerModelID = getModelID(containerView);" + NL + "\t\tif (!\"";
  protected final String TEXT_13 = "\".equals(containerModelID)";
  protected final String TEXT_14 = "\t\t\t" + NL + "\t\t\t&& !\"";
  protected final String TEXT_15 = "\".equals(containerModelID)";
  protected final String TEXT_16 = NL + "\t\t) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tint containerVisualID;" + NL + "\t\tif (\"";
  protected final String TEXT_17 = "\".equals(containerModelID)) {" + NL + "\t\t\tcontainerVisualID = getVisualID(containerView);" + NL + "\t\t} else {" + NL + "\t\t\tif (containerView instanceof Diagram) {" + NL + "\t\t\t\tcontainerVisualID = ";
  protected final String TEXT_18 = ";\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tswitch (containerVisualID) {";
  protected final String TEXT_19 = NL + "\t\tcase ";
  protected final String TEXT_20 = ":";
  protected final String TEXT_21 = NL + "\t\t\tif (";
  protected final String TEXT_22 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_23 = ";" + NL + "\t\t\t}";
  protected final String TEXT_24 = NL + "\t\t\tif (";
  protected final String TEXT_25 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_26 = ";" + NL + "\t\t\t}  ";
  protected final String TEXT_27 = NL + "\t\t\tif (";
  protected final String TEXT_28 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_29 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_30 = NL + "\t\t\tif (semanticHint != null && !\"\".equals(semanticHint)) {" + NL + "\t\t\t\treturn getUnrecognized";
  protected final String TEXT_31 = "ChildNodeID(semanticHint);" + NL + "\t\t\t} ";
  protected final String TEXT_32 = "\t\t" + NL + "\t\t\tif (";
  protected final String TEXT_33 = ".eINSTANCE.get";
  protected final String TEXT_34 = "().equals(domainElementMetaclass) && (domainElement != null ? isNode";
  protected final String TEXT_35 = "((";
  protected final String TEXT_36 = ") domainElement) : true)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_37 = ";" + NL + "\t\t\t} ";
  protected final String TEXT_38 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_39 = "ChildNodeID(domainElement);";
  protected final String TEXT_40 = NL + "\t\tcase ";
  protected final String TEXT_41 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_42 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_43 = ";" + NL + "\t\t\t}" + NL + "\t\t\treturn -1;";
  protected final String TEXT_44 = NL + "\t\tcase ";
  protected final String TEXT_45 = ":";
  protected final String TEXT_46 = NL + "\t\t\tif (";
  protected final String TEXT_47 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_48 = ";" + NL + "\t\t\t}";
  protected final String TEXT_49 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_50 = "LinkLabelID(semanticHint);";
  protected final String TEXT_51 = NL + "\t\tcase ";
  protected final String TEXT_52 = ":" + NL + "\t\t\tif (";
  protected final String TEXT_53 = ".equals(semanticHint)) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_54 = ";" + NL + "\t\t\t}" + NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_55 = "LinkLabelTextID(semanticHint);";
  protected final String TEXT_56 = NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_57 = NL + "\t\tif (";
  protected final String TEXT_58 = ".eINSTANCE.get";
  protected final String TEXT_59 = "().equals(domainElementMetaclass) && (domainElement != null ? isLinkWithClass";
  protected final String TEXT_60 = "((";
  protected final String TEXT_61 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_62 = ";" + NL + "\t\t} else ";
  protected final String TEXT_63 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t\t}" + NL + "\t}\t" + NL + "\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_66 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_67 = "(";
  protected final String TEXT_68 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_69 = ".matches(element);" + NL + "\t}\t";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_72 = "ChildNodeID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_73 = "ChildNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_74 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_75 = "LinkLabelID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_76 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate int getUnrecognized";
  protected final String TEXT_77 = "LinkLabelTextID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_78 = NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_79 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isLinkWithClass";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_82 = ".matches(element);" + NL + "\t}";
  protected final String TEXT_83 = NL;
  protected final String TEXT_84 = NL;
  protected final String TEXT_85 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getModelID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_86 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t}" + NL;
  protected final String TEXT_87 = NL;
  protected final String TEXT_88 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getVisualID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_89 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tString visualID = (String) annotation.getDetails().get(\"visualID\"); //$NON-NLS-1$" + NL + "\t\tif (visualID == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(visualID);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\t";
  protected final String TEXT_90 = ".getInstance().logError(\"Unable to parse \\\"visualID\\\" annotation: \" + visualID, e);" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ElementSelectors {\t";
  protected final String TEXT_91 = NL + NL + "\t\t/**" + NL + "\t\t * Element matching condition for ";
  protected final String TEXT_92 = "." + NL + "\t\t * <pre>language: ";
  protected final String TEXT_93 = "</pre>\t" + NL + "\t\t * <pre>body    : ";
  protected final String TEXT_94 = "</pre>" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final Matcher ";
  protected final String TEXT_95 = " = new Matcher(\"";
  protected final String TEXT_96 = "\");";
  protected final String TEXT_97 = NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ElementSelectors() {" + NL + "\t\t}";
  protected final String TEXT_98 = "\t\t\t" + NL + "\t\t/**" + NL + "\t\t* @generated\t" + NL + "\t\t*/" + NL + "\t\tstatic class Matcher {" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate EClass evalContext;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_99 = " condition;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate String body;\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t" + NL + "\t\t\tMatcher(String expressionBody) {\t\t\t" + NL + "\t\t\t\tbody = expressionBody;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tboolean matches(EObject object) {\t\t" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tBoolean result = (object != null) ? evaluate(object) : Boolean.FALSE;" + NL + "\t\t\t\t\treturn result.booleanValue();" + NL + "\t\t\t\t} catch(IllegalArgumentException e) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_100 = ".getInstance().logError(null, e);" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t" + NL + "\t\t\tprivate Boolean evaluate(EObject context) {" + NL + "\t\t\t\tthis.evalContext = context.eClass();" + NL + "\t\t\t\tif(condition == null) {\t\t\t\t\t" + NL + "\t\t\t\t\tcondition = new ";
  protected final String TEXT_101 = "(body, evalContext);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(condition != null) {" + NL + "\t\t\t\t\treturn booleanCast(condition.evaluate(context));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate static Boolean booleanCast(Object value) {" + NL + "\t\t\t\tif(value == null) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t} else if(value instanceof Boolean) {" + NL + "\t\t\t\t\t return (Boolean)value;\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t\t} // end of Matcher";
  protected final String TEXT_102 = "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class AcceptAllMatcher {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tstatic final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t\t\t" + NL + "\t\t\tboolean matches(Object element) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tstatic AcceptAllMatcher acceptAllMatcher() {" + NL + "\t\t\treturn AcceptAllMatcher.INSTANCE;" + NL + "\t\t}" + NL + "\t} // end of ElementSelectors" + NL + "}" + NL + "\t";
  protected final String TEXT_103 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final String modelID = genDiagram.getEditorGen().getModelID();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final List genLinks = genDiagram.getLinks();
final Collection allContainers = genDiagram.getAllContainers();

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    
importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_5);
    
{
	String classifierAccessorName = genDiagram.getDomainDiagramElement().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getMetaPackageName(importManager));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_13);
    
for (Iterator it = genDiagram.getShortcutsProvidedFor().iterator(); it.hasNext();) { 
	String nextDomainModelName = (String) it.next();
	if (modelID.equals(nextDomainModelName)) {
		continue;
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(nextDomainModelName);
    stringBuffer.append(TEXT_15);
    
}

    stringBuffer.append(TEXT_16);
    stringBuffer.append(modelID);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_18);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_19);
    stringBuffer.append(nextContainer.getVisualID());
    stringBuffer.append(TEXT_20);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();
			if (label instanceof ExternalLabel) {
				String labelViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + ((ExternalLabel) label).getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_23);
    
			} else {
				String labelTextViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + label.getSemanticHintFieldName();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_26);
    
			}
		}
		for (Iterator compartments = node.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment compartment = (GenCompartment) compartments.next();
			String compartmentId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Compartments." + compartment.getSemanticHintFieldName();

    stringBuffer.append(TEXT_27);
    stringBuffer.append(compartmentId);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(compartment.getVisualID());
    stringBuffer.append(TEXT_29);
    
		}
	}

    stringBuffer.append(TEXT_30);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_31);
    	
	for (Iterator childNodes = nextContainer.getContainedNodes().iterator(); childNodes.hasNext();) {
		GenNode childNode = (GenNode) childNodes.next();
		final String classifierAccessorName = childNode.getDomainMetaClass().getClassifierAccessorName();
		final String interfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getQualifiedInterfaceName());
		final String semanticPackageInterfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()); 

    stringBuffer.append(TEXT_32);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(childNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(childNode.getVisualID());
    stringBuffer.append(TEXT_37);
    
	}

    stringBuffer.append(TEXT_38);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();
			if (label instanceof ExternalLabel) {
				String labelTextViewId = semanticHintsClassName + '.' + node.getUniqueIdentifier() + "Labels." + label.getSemanticHintFieldName();

    stringBuffer.append(TEXT_40);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(label.getVisualID());
    stringBuffer.append(TEXT_43);
    
			}
		}
	}
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	String semanticHintsClassName = importManager.getImportedName(genDiagram.getSemanticHintsQualifiedClassName());

    stringBuffer.append(TEXT_44);
    stringBuffer.append(link.getVisualID());
    stringBuffer.append(TEXT_45);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelViewId = semanticHintsClassName + '.' + link.getUniqueIdentifier() + "Labels." + linkLabel.getSemanticHintLabelFieldName();

    stringBuffer.append(TEXT_46);
    stringBuffer.append(labelViewId);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_48);
    
	}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_50);
    
	for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
		GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();
		String labelTextViewId = semanticHintsClassName + '.' + link.getUniqueIdentifier() + "Labels." + linkLabel.getSemanticHintFieldName();

    stringBuffer.append(TEXT_51);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(labelTextViewId);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(linkLabel.getVisualID());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_55);
    
	}
}

    stringBuffer.append(TEXT_56);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		final TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		final String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		final String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		final String semanticPackageInterfaceName = importManager.getImportedName(modelFacet.getMetaClass().getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_57);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_62);
    
		}
	}

    stringBuffer.append(TEXT_63);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_65);
    
String acceptAllMatcherAccessor = "acceptAllMatcher()"; //$NON-NLS-1$
for (Iterator nodes = genDiagram.getAllNodes().iterator(); nodes.hasNext();) {
	GenNode nextNode = (GenNode) nodes.next();
	String qualifiedChildNodeInterfaceName = nextNode.getDomainMetaClass().getQualifiedInterfaceName();
	String childNodeSelector = nextNode.getModelFacet() != null && nextNode.getModelFacet().getModelElementSelector() != null ? nextNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_66);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName(qualifiedChildNodeInterfaceName));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(childNodeSelector);
    stringBuffer.append(TEXT_69);
    
}

    stringBuffer.append(TEXT_70);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_71);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_73);
    
}

for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();

    stringBuffer.append(TEXT_74);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_75);
    
	if (link.getLabels().size() > 0) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_77);
    
	}
}

    stringBuffer.append(TEXT_78);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		String linkSelector = modelFacet.getModelElementSelector() != null ? genLink.getUniqueIdentifier() : acceptAllMatcherAccessor;		

    stringBuffer.append(TEXT_79);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(linkSelector);
    stringBuffer.append(TEXT_82);
    
	}
}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_90);
    
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
	GenConstraint selector = modelFacet.getModelElementSelector();
	selectorCounter++;

    stringBuffer.append(TEXT_91);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(selector.getLanguage());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_96);
    }
    stringBuffer.append(TEXT_97);
    if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OCLConstraintCondition"));
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OCLConstraintCondition"));
    stringBuffer.append(TEXT_101);
    }
    stringBuffer.append(TEXT_102);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_103);
    return stringBuffer.toString();
  }
}

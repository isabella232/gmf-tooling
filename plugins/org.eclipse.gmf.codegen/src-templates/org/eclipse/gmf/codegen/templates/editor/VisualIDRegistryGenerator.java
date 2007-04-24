package org.eclipse.gmf.codegen.templates.editor;

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
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * This registry is used to determine which type of visual object should be" + NL + " * created for the corresponding Diagram, Node, ChildNode or Link represented " + NL + " * by a domain model object." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String DEBUG_KEY = ";
  protected final String TEXT_7 = ".getInstance().getBundle().getSymbolicName() + \"/debug/visualID\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getVisualID(View view) {" + NL + "\t\tif (view instanceof Diagram) {" + NL + "\t\t\tif (";
  protected final String TEXT_8 = ".MODEL_ID.equals(view.getType())) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_9 = ".VISUAL_ID;" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getVisualID(view.getType());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getModelID(View view) {" + NL + "\t\tView diagram = view.getDiagram();" + NL + "\t\twhile (view != diagram) {" + NL + "\t\t\t";
  protected final String TEXT_10 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tif (annotation != null) {" + NL + "\t\t\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\tview = (View) view.eContainer();" + NL + "\t\t}" + NL + "\t\treturn diagram != null ? diagram.getType() : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getVisualID(String type) {" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(type);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\tif (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {" + NL + "\t\t\t\t";
  protected final String TEXT_11 = ".getInstance().logError(\"Unable to parse view type as a visualID number: \" + type);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getType(int visualID) {" + NL + "\t\treturn String.valueOf(visualID);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_12 = NL + "\t\tif (";
  protected final String TEXT_13 = ".eINSTANCE.get";
  protected final String TEXT_14 = "().isSuperTypeOf(domainElementMetaclass) && isDiagram";
  protected final String TEXT_15 = "((";
  protected final String TEXT_16 = ") domainElement)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_17 = ".VISUAL_ID;" + NL + "\t\t}";
  protected final String TEXT_18 = NL + "\t\treturn getUnrecognizedDiagramID(domainElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getNodeVisualID(View containerView, EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {" + NL + "\t\tString containerModelID = getModelID(containerView);" + NL + "\t\tif (!";
  protected final String TEXT_19 = ".MODEL_ID.equals(containerModelID)";
  protected final String TEXT_20 = "\t\t\t" + NL + "\t\t\t&& !\"";
  protected final String TEXT_21 = "\".equals(containerModelID)";
  protected final String TEXT_22 = NL + "\t\t) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tint containerVisualID;" + NL + "\t\tif (";
  protected final String TEXT_23 = ".MODEL_ID.equals(containerModelID)) {" + NL + "\t\t\tcontainerVisualID = getVisualID(containerView);" + NL + "\t\t} else {" + NL + "\t\t\tif (containerView instanceof Diagram) {" + NL + "\t\t\t\tcontainerVisualID = ";
  protected final String TEXT_24 = ".VISUAL_ID;\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tint nodeVisualID = semanticHint != null ? getVisualID(semanticHint) : -1;" + NL + "\t\tswitch (containerVisualID) {";
  protected final String TEXT_25 = NL + "\t\tcase ";
  protected final String TEXT_26 = ".VISUAL_ID:";
  protected final String TEXT_27 = NL + "\t\t\tif (";
  protected final String TEXT_28 = ".VISUAL_ID == nodeVisualID) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_29 = ".VISUAL_ID;" + NL + "\t\t\t}";
  protected final String TEXT_30 = NL + "\t\t\tif (";
  protected final String TEXT_31 = ".VISUAL_ID == nodeVisualID) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_32 = ".VISUAL_ID;" + NL + "\t\t\t} ";
  protected final String TEXT_33 = NL + "\t\t\tif ((semanticHint == null || ";
  protected final String TEXT_34 = ".VISUAL_ID == nodeVisualID)";
  protected final String TEXT_35 = NL + "\t\t\t\t\t&& ";
  protected final String TEXT_36 = ".eINSTANCE.get";
  protected final String TEXT_37 = "().isSuperTypeOf(domainElementMetaclass)" + NL + "\t\t\t\t\t&& (domainElement == null || isNode";
  protected final String TEXT_38 = "((";
  protected final String TEXT_39 = ") domainElement))";
  protected final String TEXT_40 = NL + "\t\t\t\t) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_41 = ".VISUAL_ID;" + NL + "\t\t\t}";
  protected final String TEXT_42 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_43 = "ChildNodeID(domainElement, semanticHint);";
  protected final String TEXT_44 = NL + "\t\tcase ";
  protected final String TEXT_45 = ".VISUAL_ID:";
  protected final String TEXT_46 = NL + "\t\t\tif (";
  protected final String TEXT_47 = ".VISUAL_ID == nodeVisualID) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_48 = ".VISUAL_ID;" + NL + "\t\t\t}";
  protected final String TEXT_49 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_50 = "LinkLabelID(semanticHint);";
  protected final String TEXT_51 = NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_52 = NL + "\t\tif (";
  protected final String TEXT_53 = ".eINSTANCE.get";
  protected final String TEXT_54 = "().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClass";
  protected final String TEXT_55 = "((";
  protected final String TEXT_56 = ") domainElement))) {" + NL + "\t\t\treturn ";
  protected final String TEXT_57 = ".VISUAL_ID;" + NL + "\t\t} else ";
  protected final String TEXT_58 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t\t}" + NL + "\t}\t" + NL;
  protected final String TEXT_59 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isDiagram";
  protected final String TEXT_60 = "(";
  protected final String TEXT_61 = " element) {" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_62 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_63 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isNode";
  protected final String TEXT_64 = "(";
  protected final String TEXT_65 = " element) {" + NL + "\t\treturn ";
  protected final String TEXT_66 = ".matches(element)";
  protected final String TEXT_67 = "true";
  protected final String TEXT_68 = ";" + NL + "\t}\t";
  protected final String TEXT_69 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static int getUnrecognized";
  protected final String TEXT_70 = "ChildNodeID(EObject domainElement, String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_71 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static int getUnrecognized";
  protected final String TEXT_72 = "LinkLabelID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_73 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_74 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isLinkWithClass";
  protected final String TEXT_75 = "(";
  protected final String TEXT_76 = " element) {" + NL + "\t\treturn ";
  protected final String TEXT_77 = ".matches(element)";
  protected final String TEXT_78 = "true";
  protected final String TEXT_79 = ";" + NL + "\t}";
  protected final String TEXT_80 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final ";
  protected final String TEXT_81 = " ";
  protected final String TEXT_82 = " = new ";
  protected final String TEXT_83 = "(";
  protected final String TEXT_84 = "null";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = "(";
  protected final String TEXT_87 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_88 = ", ";
  protected final String TEXT_89 = ")";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = "(";
  protected final String TEXT_92 = ", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_93 = ")";
  protected final String TEXT_94 = "new ";
  protected final String TEXT_95 = "(";
  protected final String TEXT_96 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_97 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_98 = " self = (";
  protected final String TEXT_99 = ")context;";
  protected final String TEXT_100 = "\t" + NL + "\t\t";
  protected final String TEXT_101 = " ";
  protected final String TEXT_102 = " = (";
  protected final String TEXT_103 = ")env.get(\"";
  protected final String TEXT_104 = "\"); //$NON-NLS-1$";
  protected final String TEXT_105 = NL + "\t\treturn ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = "(self";
  protected final String TEXT_108 = ", ";
  protected final String TEXT_109 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_110 = NL + ");";
  protected final String TEXT_111 = "\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated\t" + NL + "\t */" + NL + "\tstatic class ";
  protected final String TEXT_112 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_113 = " condition;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_114 = "(";
  protected final String TEXT_115 = " conditionExpression) {\t\t\t" + NL + "\t\t\tthis.condition = conditionExpression;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t\t" + NL + "\t\tboolean matches(Object object) {" + NL + "\t\t\tObject result = condition.evaluate(object);" + NL + "\t\t\treturn result instanceof Boolean && ((Boolean)result).booleanValue();\t\t\t" + NL + "\t\t}" + NL + "\t}// ";
  protected final String TEXT_116 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ";
  protected final String TEXT_117 = " {";
  protected final String TEXT_118 = NL;
  protected final String TEXT_119 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_120 = " ";
  protected final String TEXT_121 = "(";
  protected final String TEXT_122 = " self";
  protected final String TEXT_123 = ", ";
  protected final String TEXT_124 = " ";
  protected final String TEXT_125 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new ";
  protected final String TEXT_126 = ".NoImplException(\"No user java implementation provided in '";
  protected final String TEXT_127 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_128 = NL + "\t}// ";
  protected final String TEXT_129 = NL + "}" + NL + "\t";
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final String modelID = genDiagram.getEditorGen().getModelID();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final List genLinks = genDiagram.getLinks();
final Collection allContainers = genDiagram.getAllContainers();

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
final String matcherClassName = "Matcher";
final String javaMatcherContainer = "JavaMatchers";
importManager.registerInnerClass(matcherClassName);
importManager.registerInnerClass(javaMatcherContainer);

importManager.addImport("org.eclipse.emf.ecore.EClass");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.gmf.runtime.notation.View");
importManager.addImport("org.eclipse.gmf.runtime.notation.Diagram");
importManager.addImport("org.eclipse.core.runtime.Platform");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    
if (genDiagram.getDomainDiagramElement() != null) {
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
    
for (Iterator it = genDiagram.getShortcutsProvidedFor().iterator(); it.hasNext();) { 
	String nextDomainModelName = (String) it.next();
	if (modelID.equals(nextDomainModelName)) {
		continue;
	}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(nextDomainModelName);
    stringBuffer.append(TEXT_21);
    
}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(nextContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_29);
    
		}
		for (Iterator compartments = node.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment compartment = (GenCompartment) compartments.next();

    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(compartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(compartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
		}
	}

	for (Iterator childNodes = nextContainer.getContainedNodes().iterator(); childNodes.hasNext();) {
		GenNode childNode = (GenNode) childNodes.next();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(childNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    
		if (childNode.getModelFacet() != null) {
			final String classifierAccessorName = childNode.getDomainMetaClass().getClassifierAccessorName();
			final String interfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getQualifiedInterfaceName());
			final String semanticPackageInterfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()); 

    stringBuffer.append(TEXT_35);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(childNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_39);
    		}
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(childNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    
	}

    stringBuffer.append(TEXT_42);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_43);
    
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	if (link.getLabels().size() > 0) {

    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(link.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    
		for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
			GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_48);
    		}
    stringBuffer.append(TEXT_49);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_50);
    	}
}
    stringBuffer.append(TEXT_51);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		final TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		final String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		final String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		final String semanticPackageInterfaceName = importManager.getImportedName(modelFacet.getMetaClass().getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_52);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    
		}
	}

    stringBuffer.append(TEXT_58);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    
for (Iterator nodes = genDiagram.getAllNodes().iterator(); nodes.hasNext();) {
	GenNode nextNode = (GenNode) nodes.next();
	if (nextNode.getModelFacet() == null) {
		continue;
	}
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());
	boolean callMatcher = nextNode.getModelFacet() != null && nextNode.getModelFacet().getModelElementSelector() != null;

    stringBuffer.append(TEXT_63);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_65);
    if (callMatcher) {
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_66);
    } else {
    stringBuffer.append(TEXT_67);
    }
    stringBuffer.append(TEXT_68);
    
}
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_69);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_70);
    
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	if (link.getLabels().size() == 0) {
		continue;
	}

    stringBuffer.append(TEXT_71);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_72);
    }
    stringBuffer.append(TEXT_73);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String interfaceName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
		boolean callMatcher = modelFacet.getModelElementSelector() != null;		

    stringBuffer.append(TEXT_74);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_76);
    if (callMatcher) {
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_77);
    } else {
    stringBuffer.append(TEXT_78);
    }
    stringBuffer.append(TEXT_79);
    
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

    stringBuffer.append(TEXT_80);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_83);
    
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

    stringBuffer.append(TEXT_84);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_87);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_89);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(__genValueExpression.getBodyString());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_93);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_94);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_99);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_104);
    		} 
    stringBuffer.append(TEXT_105);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_106);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_107);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_108);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_109);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_110);
    
} /* end of selector interation */

if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_111);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_115);
    stringBuffer.append(matcherClassName);
    
	if(!javaSelectorFacets.isEmpty()) {

    stringBuffer.append(TEXT_116);
    stringBuffer.append(javaMatcherContainer);
    stringBuffer.append(TEXT_117);
    
		for(Iterator it = javaSelectorFacets.iterator(); it.hasNext();) {
			TypeModelFacet modelFacet = (TypeModelFacet) it.next();
			ValueExpression __genValueExpression = modelFacet.getModelElementSelector();
			GenClassifier __genExprContext = modelFacet.getMetaClass();
			String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_118);
    
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

    stringBuffer.append(TEXT_119);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_120);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_122);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_123);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_124);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_125);
    stringBuffer.append(__importedAbstractExpr);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_127);
    
} /* end of GenJavaExpressionProvider */

    
		} /* java javaSelectorFacets iteration */

    stringBuffer.append(TEXT_128);
    stringBuffer.append(javaMatcherContainer);
    
	} /* !javaSelectorFacets.isEmpty() */
} /* selectorCounter > 0 */

    stringBuffer.append(TEXT_129);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}

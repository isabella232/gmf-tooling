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
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getVisualID(View view) {" + NL + "\t\tif (view instanceof Diagram) {" + NL + "\t\t\tif (";
  protected final String TEXT_7 = ".MODEL_ID.equals(view.getType())) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_8 = ".VISUAL_ID;" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn getVisualID(view.getType());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getModelID(View view) {" + NL + "\t\tView diagram = view.getDiagram();" + NL + "\t\twhile (view != diagram) {" + NL + "\t\t\t";
  protected final String TEXT_9 = " annotation = view.getEAnnotation(\"Shortcut\"); //$NON-NLS-1$" + NL + "\t\t\tif (annotation != null) {" + NL + "\t\t\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t\t\t}" + NL + "\t\t\tview = (View) view.eContainer();" + NL + "\t\t}" + NL + "\t\treturn diagram != null ? diagram.getType() : null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getVisualID(String type) {" + NL + "\t\ttry {" + NL + "\t\t\treturn Integer.parseInt(type);" + NL + "\t\t} catch (NumberFormatException e) {" + NL + "\t\t\t";
  protected final String TEXT_10 = ".getInstance().logInfo(\"Unable to parse view type as a visualID number: \" + type);" + NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getType(int visualID) {" + NL + "\t\treturn String.valueOf(visualID);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_11 = NL + "\t\tif (";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "().isSuperTypeOf(domainElementMetaclass) && isDiagram";
  protected final String TEXT_14 = "((";
  protected final String TEXT_15 = ") domainElement)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_16 = ".VISUAL_ID;" + NL + "\t\t}";
  protected final String TEXT_17 = NL + "\t\treturn getUnrecognizedDiagramID(domainElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getNodeVisualID(View containerView, EObject domainElement) {" + NL + "\t\tif (domainElement == null) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(containerView, domainElement, domainElementMetaclass, null);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getNodeVisualID(View containerView, EObject domainElement, EClass domainElementMetaclass, String semanticHint) {" + NL + "\t\tString containerModelID = getModelID(containerView);" + NL + "\t\tif (!";
  protected final String TEXT_18 = ".MODEL_ID.equals(containerModelID)";
  protected final String TEXT_19 = "\t\t\t" + NL + "\t\t\t&& !\"";
  protected final String TEXT_20 = "\".equals(containerModelID)";
  protected final String TEXT_21 = NL + "\t\t) {" + NL + "\t\t\treturn -1;" + NL + "\t\t}" + NL + "\t\tint containerVisualID;" + NL + "\t\tif (";
  protected final String TEXT_22 = ".MODEL_ID.equals(containerModelID)) {" + NL + "\t\t\tcontainerVisualID = getVisualID(containerView);" + NL + "\t\t} else {" + NL + "\t\t\tif (containerView instanceof Diagram) {" + NL + "\t\t\t\tcontainerVisualID = ";
  protected final String TEXT_23 = ".VISUAL_ID;\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tint nodeVisualID = semanticHint != null ? getVisualID(semanticHint) : -1;" + NL + "\t\tswitch (containerVisualID) {";
  protected final String TEXT_24 = NL + "\t\tcase ";
  protected final String TEXT_25 = ".VISUAL_ID:";
  protected final String TEXT_26 = NL + "\t\t\tif (";
  protected final String TEXT_27 = ".VISUAL_ID == nodeVisualID) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_28 = ".VISUAL_ID;" + NL + "\t\t\t}";
  protected final String TEXT_29 = NL + "\t\t\tif (";
  protected final String TEXT_30 = ".VISUAL_ID == nodeVisualID) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_31 = ".VISUAL_ID;" + NL + "\t\t\t} ";
  protected final String TEXT_32 = "\t\t" + NL + "\t\t\tif ((semanticHint == null || ";
  protected final String TEXT_33 = ".VISUAL_ID == nodeVisualID) && ";
  protected final String TEXT_34 = ".eINSTANCE.get";
  protected final String TEXT_35 = "().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isNode";
  protected final String TEXT_36 = "((";
  protected final String TEXT_37 = ") domainElement))) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_38 = ".VISUAL_ID;" + NL + "\t\t\t} ";
  protected final String TEXT_39 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_40 = "ChildNodeID(domainElement, semanticHint);";
  protected final String TEXT_41 = NL + "\t\tcase ";
  protected final String TEXT_42 = ".VISUAL_ID:";
  protected final String TEXT_43 = NL + "\t\t\tif (";
  protected final String TEXT_44 = ".VISUAL_ID == nodeVisualID) {" + NL + "\t\t\t\treturn ";
  protected final String TEXT_45 = ".VISUAL_ID;" + NL + "\t\t\t}";
  protected final String TEXT_46 = NL + "\t\t\treturn getUnrecognized";
  protected final String TEXT_47 = "LinkLabelID(semanticHint);";
  protected final String TEXT_48 = NL + "\t\t}" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_49 = NL + "\t\tif (";
  protected final String TEXT_50 = ".eINSTANCE.get";
  protected final String TEXT_51 = "().isSuperTypeOf(domainElementMetaclass) && (domainElement == null || isLinkWithClass";
  protected final String TEXT_52 = "((";
  protected final String TEXT_53 = ") domainElement))) {" + NL + "\t\t\treturn ";
  protected final String TEXT_54 = ".VISUAL_ID;" + NL + "\t\t} else ";
  protected final String TEXT_55 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t\t}" + NL + "\t}\t" + NL;
  protected final String TEXT_56 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isDiagram";
  protected final String TEXT_57 = "(";
  protected final String TEXT_58 = " element) {" + NL + "\t\treturn true;" + NL + "\t}";
  protected final String TEXT_59 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_60 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isNode";
  protected final String TEXT_61 = "(";
  protected final String TEXT_62 = " element) {" + NL + "\t\treturn ";
  protected final String TEXT_63 = ".matches(element)";
  protected final String TEXT_64 = "true";
  protected final String TEXT_65 = ";" + NL + "\t}\t";
  protected final String TEXT_66 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static int getUnrecognized";
  protected final String TEXT_67 = "ChildNodeID(EObject domainElement, String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_68 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static int getUnrecognized";
  protected final String TEXT_69 = "LinkLabelID(String semanticHint) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_70 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}";
  protected final String TEXT_71 = NL + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional " + NL + "\t * conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static boolean isLinkWithClass";
  protected final String TEXT_72 = "(";
  protected final String TEXT_73 = " element) {" + NL + "\t\treturn ";
  protected final String TEXT_74 = ".matches(element)";
  protected final String TEXT_75 = "true";
  protected final String TEXT_76 = ";" + NL + "\t}";
  protected final String TEXT_77 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final ";
  protected final String TEXT_78 = " ";
  protected final String TEXT_79 = " = new ";
  protected final String TEXT_80 = "(";
  protected final String TEXT_81 = "null";
  protected final String TEXT_82 = ".";
  protected final String TEXT_83 = "(\"";
  protected final String TEXT_84 = "\", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_85 = ", ";
  protected final String TEXT_86 = ")";
  protected final String TEXT_87 = ".";
  protected final String TEXT_88 = "(\"";
  protected final String TEXT_89 = "\", //$NON-NLS-1$" + NL + "\t";
  protected final String TEXT_90 = ")";
  protected final String TEXT_91 = "new ";
  protected final String TEXT_92 = "(";
  protected final String TEXT_93 = ") {" + NL + "\tprotected Object doEvaluate(Object context, ";
  protected final String TEXT_94 = " env) {\t" + NL + "\t\t";
  protected final String TEXT_95 = " self = (";
  protected final String TEXT_96 = ")context;";
  protected final String TEXT_97 = "\t" + NL + "\t\t";
  protected final String TEXT_98 = " ";
  protected final String TEXT_99 = " = (";
  protected final String TEXT_100 = ")env.get(\"";
  protected final String TEXT_101 = "\"); //$NON-NLS-1$";
  protected final String TEXT_102 = NL + "\t\treturn ";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = "(self";
  protected final String TEXT_105 = ", ";
  protected final String TEXT_106 = ");" + NL + "\t}" + NL + "}";
  protected final String TEXT_107 = NL + ");";
  protected final String TEXT_108 = "\t" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated\t" + NL + "\t */" + NL + "\tstatic class ";
  protected final String TEXT_109 = " {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_110 = " condition;" + NL + "\t\t\t\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t" + NL + "\t\t";
  protected final String TEXT_111 = "(";
  protected final String TEXT_112 = " conditionExpression) {\t\t\t" + NL + "\t\t\tthis.condition = conditionExpression;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t\t" + NL + "\t\tboolean matches(EObject object) {" + NL + "\t\t\tObject result = condition.evaluate(object);" + NL + "\t\t\treturn result instanceof Boolean && ((Boolean)result).booleanValue();\t\t\t" + NL + "\t\t}" + NL + "\t}// ";
  protected final String TEXT_113 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\t private static class ";
  protected final String TEXT_114 = " {";
  protected final String TEXT_115 = NL;
  protected final String TEXT_116 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "private static ";
  protected final String TEXT_117 = " ";
  protected final String TEXT_118 = "(";
  protected final String TEXT_119 = " self";
  protected final String TEXT_120 = ", ";
  protected final String TEXT_121 = " ";
  protected final String TEXT_122 = ") {" + NL + "\t// TODO: implement this method" + NL + "\t// Ensure that you remove @generated or mark it @generated NOT" + NL + "\t" + NL + "\tthrow new UnsupportedOperationException(\"No user implementation provided in '";
  protected final String TEXT_123 = "' operation\"); //$NON-NLS-1$" + NL + "}";
  protected final String TEXT_124 = NL + "\t}// ";
  protected final String TEXT_125 = NL + "}" + NL + "\t";
  protected final String TEXT_126 = NL;

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

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getVisualIDRegistryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    
if (genDiagram.getDomainDiagramElement() != null) {
	String classifierAccessorName = genDiagram.getDomainDiagramElement().getClassifierAccessorName();
	String interfaceName = importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName());

    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getMetaPackageName(importManager));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    
for (Iterator it = genDiagram.getShortcutsProvidedFor().iterator(); it.hasNext();) { 
	String nextDomainModelName = (String) it.next();
	if (modelID.equals(nextDomainModelName)) {
		continue;
	}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(nextDomainModelName);
    stringBuffer.append(TEXT_20);
    
}

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_23);
    
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName(nextContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_25);
    
	if (nextContainer instanceof GenNode) {
		GenNode node = (GenNode) nextContainer;
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext();) {
			GenNodeLabel label = (GenNodeLabel) labels.next();

    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName(label.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_28);
    
		}
		for (Iterator compartments = node.getCompartments().iterator(); compartments.hasNext();) {
			GenCompartment compartment = (GenCompartment) compartments.next();

    stringBuffer.append(TEXT_29);
    stringBuffer.append(importManager.getImportedName(compartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importManager.getImportedName(compartment.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_31);
    
		}
	}

	for (Iterator childNodes = nextContainer.getContainedNodes().iterator(); childNodes.hasNext();) {
		GenNode childNode = (GenNode) childNodes.next();
		final String classifierAccessorName = childNode.getDomainMetaClass().getClassifierAccessorName();
		final String interfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getQualifiedInterfaceName());
		final String semanticPackageInterfaceName = importManager.getImportedName(childNode.getDomainMetaClass().getGenPackage().getQualifiedPackageInterfaceName()); 

    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(childNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(classifierAccessorName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(childNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(childNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    
	}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_40);
    
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	if (link.getLabels().size() > 0) {

    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(link.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    
		for (Iterator linkLabels = link.getLabels().iterator(); linkLabels.hasNext();) {
			GenLinkLabel linkLabel = (GenLinkLabel) linkLabels.next();

    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(linkLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_45);
    		}
    stringBuffer.append(TEXT_46);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    	}
}
    stringBuffer.append(TEXT_48);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		final TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		final String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		final String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		final String semanticPackageInterfaceName = importManager.getImportedName(modelFacet.getMetaClass().getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_49);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_54);
    
		}
	}

    stringBuffer.append(TEXT_55);
    if (genDiagram.getDomainDiagramElement() != null) {
    stringBuffer.append(TEXT_56);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_58);
    }
    stringBuffer.append(TEXT_59);
    
for (Iterator nodes = genDiagram.getAllNodes().iterator(); nodes.hasNext();) {
	GenNode nextNode = (GenNode) nodes.next();
	String childNodeInterfaceName = importManager.getImportedName(nextNode.getDomainMetaClass().getQualifiedInterfaceName());
	boolean callMatcher = nextNode.getModelFacet() != null && nextNode.getModelFacet().getModelElementSelector() != null;

    stringBuffer.append(TEXT_60);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(childNodeInterfaceName);
    stringBuffer.append(TEXT_62);
    if (callMatcher) {
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    
}
for (Iterator containers = allContainers.iterator(); containers.hasNext();) {
	GenContainerBase nextContainer = (GenContainerBase) containers.next();

    stringBuffer.append(TEXT_66);
    stringBuffer.append(nextContainer.getUniqueIdentifier());
    stringBuffer.append(TEXT_67);
    
}
for (Iterator links = genLinks.iterator(); links.hasNext();) {
	GenLink link = (GenLink) links.next();
	if (link.getLabels().size() == 0) {
		continue;
	}

    stringBuffer.append(TEXT_68);
    stringBuffer.append(link.getUniqueIdentifier());
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String interfaceName = importManager.getImportedName(modelFacet.getMetaClass().getQualifiedInterfaceName());
		boolean callMatcher = modelFacet.getModelElementSelector() != null;		

    stringBuffer.append(TEXT_71);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(interfaceName);
    stringBuffer.append(TEXT_73);
    if (callMatcher) {
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_74);
    } else {
    stringBuffer.append(TEXT_75);
    }
    stringBuffer.append(TEXT_76);
    
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
	if(expressionProviders.getProvider(__genValueExpression) instanceof GenJavaExpressionProvider) {
		javaSelectorFacets.add(modelFacet);
	}

    stringBuffer.append(TEXT_77);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_80);
    
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

    stringBuffer.append(TEXT_81);
    
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter) {
		org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter interpreter = (org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter)__genExprProvider;
		String __expressionAccessor = interpreter.getExpressionAccessor(__genValueExpression);
		String providerImportedClass = importManager.getImportedName(interpreter.getQualifiedClassName());
		if(!__exprEnvVariables.isEmpty()) {			

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(__genValueExpression.getBody());
    stringBuffer.append(TEXT_84);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(__outEnvVarName);
    stringBuffer.append(TEXT_86);
    
		} else { 		

    stringBuffer.append(providerImportedClass);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(__expressionAccessor);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(__genValueExpression.getBody());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_90);
    
		}
	} else if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) { /*inlined java expression adapter*/
		String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
		String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);	


    stringBuffer.append(TEXT_91);
    stringBuffer.append(__importedAbstractClass);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(__ctxEClassifierAccess);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(importManager.getImportedName("java.util.Map"));
    stringBuffer.append(TEXT_94);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_95);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_96);
    	
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
			String nextVariableName = (String)envVarIt.next();
			org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(nextVariableName);
			String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

    stringBuffer.append(TEXT_97);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_98);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(nextVariableName);
    stringBuffer.append(TEXT_101);
    		} 
    stringBuffer.append(TEXT_102);
    
		if(__javaOperationContainer != null && __javaOperationContainer.length() > 0) { 
    stringBuffer.append(__javaOperationContainer);
    stringBuffer.append(TEXT_103);
    
		} 
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_104);
    
		for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();){
    stringBuffer.append(TEXT_105);
    stringBuffer.append((String)envVarIt.next());
    }
    stringBuffer.append(TEXT_106);
    }
    } /*end of scope*/
    stringBuffer.append(TEXT_107);
    
} /* end of selector interation */

if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_108);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_110);
    stringBuffer.append(matcherClassName);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName(expressionProviders.getAbstractExpressionQualifiedClassName()));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(matcherClassName);
    
	if(!javaSelectorFacets.isEmpty()) {

    stringBuffer.append(TEXT_113);
    stringBuffer.append(javaMatcherContainer);
    stringBuffer.append(TEXT_114);
    
		for(Iterator it = javaSelectorFacets.iterator(); it.hasNext();) {
			TypeModelFacet modelFacet = (TypeModelFacet) it.next();
			ValueExpression __genValueExpression = modelFacet.getModelElementSelector();
			GenClassifier __genExprContext = modelFacet.getMetaClass();
			String __genExprResultType = "java.lang.Boolean"; //$NON-NLS-1$

    stringBuffer.append(TEXT_115);
    
/* 
ValueExpression __genValueExpression
java.util.Map __exprEnvVariables
GenClassifier __genExprContext
GenClassifier || String/qualifiedClassName/__genExprResultType
*/
org.eclipse.gmf.codegen.gmfgen.GenExpressionProviderBase __genExprProvider = (genDiagram.getEditorGen().getExpressionProviders() != null) ? genDiagram.getEditorGen().getExpressionProviders().getProvider(__genValueExpression) : null;
if(__genExprProvider instanceof org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider) {
	String evalCtxQualifiedName = __genExprProvider.getQualifiedInstanceClassName(__genExprContext);
	// support GenClassifier and also String based qualified java class name
	Object __genExprResultTypeObj = __genExprResultType;
	String __exprResultTypeQualifiedName = null;
	if(__genExprResultTypeObj instanceof String) 
		__exprResultTypeQualifiedName = (String)__genExprResultTypeObj;
	else if(__genExprResultTypeObj instanceof org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)
		__exprResultTypeQualifiedName = __genExprProvider.getQualifiedInstanceClassName((org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__genExprResultTypeObj);
	String __exprJavaOperName = ((org.eclipse.gmf.codegen.gmfgen.GenJavaExpressionProvider)__genExprProvider).getOperationName(__genValueExpression);

    stringBuffer.append(TEXT_116);
    stringBuffer.append(importManager.getImportedName(__exprResultTypeQualifiedName));
    stringBuffer.append(TEXT_117);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(importManager.getImportedName(evalCtxQualifiedName));
    stringBuffer.append(TEXT_119);
    
	for(java.util.Iterator envVarIt = __exprEnvVariables.keySet().iterator(); envVarIt.hasNext();) {
		String __nextVarName = (String)envVarIt.next();
		org.eclipse.emf.codegen.ecore.genmodel.GenClassifier nextVariableType = (org.eclipse.emf.codegen.ecore.genmodel.GenClassifier)__exprEnvVariables.get(__nextVarName);
		String qualifiedTypeName = __genExprProvider.getQualifiedInstanceClassName(nextVariableType);

	
    stringBuffer.append(TEXT_120);
    stringBuffer.append(importManager.getImportedName(qualifiedTypeName));
    stringBuffer.append(TEXT_121);
    stringBuffer.append(__nextVarName);
    	} 

    stringBuffer.append(TEXT_122);
    stringBuffer.append(__exprJavaOperName);
    stringBuffer.append(TEXT_123);
    
}

    
		} /* java javaSelectorFacets iteration */

    stringBuffer.append(TEXT_124);
    stringBuffer.append(javaMatcherContainer);
    
	} /* !javaSelectorFacets.isEmpty() */
} /* selectorCounter > 0 */

    stringBuffer.append(TEXT_125);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_126);
    return stringBuffer.toString();
  }
}

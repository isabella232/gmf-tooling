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
  protected final String TEXT_23 = ".VISUAL_ID;\t\t" + NL + "\t\t\t} else {" + NL + "\t\t\t\treturn -1;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tint nodeVisualID = getVisualID(semanticHint);" + NL + "\t\tswitch (containerVisualID) {";
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
  protected final String TEXT_77 = NL + NL + "\t/**" + NL + "\t * Element matching condition for ";
  protected final String TEXT_78 = "." + NL + "\t * <pre>language: ";
  protected final String TEXT_79 = "</pre>\t" + NL + "\t * <pre>body    : ";
  protected final String TEXT_80 = "</pre>" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final Matcher ";
  protected final String TEXT_81 = " = new Matcher(\"";
  protected final String TEXT_82 = "\");";
  protected final String TEXT_83 = "\t" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated\t" + NL + "\t */" + NL + "\tstatic class Matcher {" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t" + NL + "\t\tprivate EClass evalContext;" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t\t" + NL + "\t\tprivate ";
  protected final String TEXT_84 = " condition;" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t\t" + NL + "\t\tprivate String body;\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t" + NL + "\t\tMatcher(String expressionBody) {\t\t\t" + NL + "\t\t\tbody = expressionBody;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t\t" + NL + "\t\tboolean matches(EObject object) {\t\t" + NL + "\t\t\ttry {" + NL + "\t\t\t\tBoolean result = (object != null) ? evaluate(object) : Boolean.FALSE;" + NL + "\t\t\t\treturn result.booleanValue();" + NL + "\t\t\t} catch(IllegalArgumentException e) {" + NL + "\t\t\t\t";
  protected final String TEXT_85 = ".getInstance().logError(null, e);" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t" + NL + "\t\tprivate Boolean evaluate(EObject context) {" + NL + "\t\t\tthis.evalContext = context.eClass();" + NL + "\t\t\tif(condition == null) {\t\t\t\t\t" + NL + "\t\t\t\tcondition = new ";
  protected final String TEXT_86 = "(body, evalContext);" + NL + "\t\t\t}" + NL + "\t\t\tif(condition != null) {" + NL + "\t\t\t\treturn booleanCast(condition.evaluate(context));" + NL + "\t\t\t}" + NL + "\t\t\treturn Boolean.FALSE;" + NL + "\t\t}" + NL + "\t" + NL + "\t\t/**" + NL + "\t\t * @generated\t" + NL + "\t\t */\t\t\t\t\t" + NL + "\t\tprivate static Boolean booleanCast(Object value) {" + NL + "\t\t\tif(value == null) {" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t} else if(value instanceof Boolean) {" + NL + "\t\t\t\t return (Boolean)value;\t" + NL + "\t\t\t}" + NL + "\t\t\treturn Boolean.FALSE;" + NL + "\t\t}" + NL + "\t} // end of Matcher";
  protected final String TEXT_87 = "\t\t" + NL + "" + NL + "}" + NL + "\t";
  protected final String TEXT_88 = NL;

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
		for (Iterator labels = node.getLabels().iterator(); labels.hasNext() && !node.isListContainerEntry();) {
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

    stringBuffer.append(TEXT_77);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(selector.getLanguage());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_82);
    
}

if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OCLConstraintCondition"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_85);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OCLConstraintCondition"));
    stringBuffer.append(TEXT_86);
    }
    stringBuffer.append(TEXT_87);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_88);
    return stringBuffer.toString();
  }
}

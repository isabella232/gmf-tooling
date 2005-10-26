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
  protected final String TEXT_3 = NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL;
  protected final String TEXT_4 = NL + "\t" + NL + "/**" + NL + " * This registry is used to determine which type of visual object should be" + NL + " * created for the corresponding Diagram, Node, ChildNode or Link represented " + NL + " * by a domain model object." + NL + " *" + NL + " * @generated" + NL + " */" + NL + "public class VisualIDRegistry {" + NL + "" + NL + "\tpublic static final VisualIDRegistry INSTANCE = new VisualIDRegistry();" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getDiagramVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getDiagramVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_5 = NL + "\t\tif (";
  protected final String TEXT_6 = ".eINSTANCE.get";
  protected final String TEXT_7 = "().equals(domainElementMetaclass) && (domainElement != null ? isDiagram";
  protected final String TEXT_8 = "((";
  protected final String TEXT_9 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_10 = ";" + NL + "\t\t}" + NL + "\t\treturn getUnrecognizedDiagramID(domainElement);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedDiagramID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getNodeVisualID(domainElement, domainElementMetaclass);" + NL + "" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getNodeVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_11 = NL + "\t\tif (";
  protected final String TEXT_12 = ".eINSTANCE.get";
  protected final String TEXT_13 = "().equals(domainElementMetaclass) && (domainElement != null ? isNode";
  protected final String TEXT_14 = "((";
  protected final String TEXT_15 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_16 = ";" + NL + "\t\t} else";
  protected final String TEXT_17 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedNodeID(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getChildNodeVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getChildNodeVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getChildNodeVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_18 = NL + "\t\tif (";
  protected final String TEXT_19 = ".eINSTANCE.get";
  protected final String TEXT_20 = "().equals(domainElementMetaclass) && (domainElement != null ? isChildNode";
  protected final String TEXT_21 = "((";
  protected final String TEXT_22 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_23 = ";" + NL + "\t\t} else ";
  protected final String TEXT_24 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedChildNodeID(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedChildNodeID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement) {" + NL + "\t\tEClass domainElementMetaclass = domainElement.eClass();" + NL + "\t\treturn getLinkWithClassVisualID(domainElement, domainElementMetaclass);" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic int getLinkWithClassVisualID(EObject domainElement, EClass domainElementMetaclass) {";
  protected final String TEXT_25 = NL + "\t\tif (";
  protected final String TEXT_26 = ".eINSTANCE.get";
  protected final String TEXT_27 = "().equals(domainElementMetaclass) && (domainElement != null ? isLinkWithClass";
  protected final String TEXT_28 = "((";
  protected final String TEXT_29 = ") domainElement) : true)) {" + NL + "\t\t\treturn ";
  protected final String TEXT_30 = ";" + NL + "\t\t} else ";
  protected final String TEXT_31 = NL + "\t\t{" + NL + "\t\t\treturn getUnrecognizedLinkWithClassID(domainElement);" + NL + "\t\t}" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to handle some specific" + NL + "\t * situations not covered by default logic." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate int getUnrecognizedLinkWithClassID(EObject domainElement) {" + NL + "\t\treturn -1;" + NL + "\t}" + NL + "\t\t" + NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isDiagram";
  protected final String TEXT_32 = "(";
  protected final String TEXT_33 = " element) {" + NL + "\t\treturn true;" + NL + "\t}" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isNode";
  protected final String TEXT_35 = "(";
  protected final String TEXT_36 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_37 = ".matches(element);" + NL + "\t}" + NL;
  protected final String TEXT_38 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isChildNode";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_41 = ".matches(element);" + NL + "\t}" + NL;
  protected final String TEXT_42 = NL + "\t";
  protected final String TEXT_43 = NL + "\t/**" + NL + "\t * User can change implementation of this method to check some additional conditions here." + NL + "\t *" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean isLinkWithClass";
  protected final String TEXT_44 = "(";
  protected final String TEXT_45 = " element) {" + NL + "\t\treturn ElementSelectors.";
  protected final String TEXT_46 = ".matches(element);" + NL + "\t}";
  protected final String TEXT_47 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ElementSelectors {\t";
  protected final String TEXT_48 = NL + "\t\t/**" + NL + "\t\t * Element matching condition for ";
  protected final String TEXT_49 = "." + NL + "\t\t * <pre>language: ";
  protected final String TEXT_50 = "</pre>\t" + NL + "\t\t * <pre>body    : ";
  protected final String TEXT_51 = "</pre>" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate static final Matcher ";
  protected final String TEXT_52 = " = new Matcher(\"";
  protected final String TEXT_53 = "\");";
  protected final String TEXT_54 = NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ElementSelectors() {" + NL + "\t\t}";
  protected final String TEXT_55 = "\t\t\t" + NL + "\t\t/**" + NL + "\t\t* @generated\t" + NL + "\t\t*/" + NL + "\t\tstatic class Matcher {" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate EClass evalContext;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate ";
  protected final String TEXT_56 = " condition;" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tprivate String body;\t\t" + NL + "\t\t\t\t\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t" + NL + "\t\t\tMatcher(String expressionBody) {\t\t\t" + NL + "\t\t\t\tbody = expressionBody;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t\t" + NL + "\t\t\tboolean matches(EObject object) {\t\t" + NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\tBoolean result = (object != null) ? evaluate(object) : Boolean.FALSE;" + NL + "\t\t\t\t\treturn result.booleanValue();" + NL + "\t\t\t\t} catch(IllegalArgumentException e) {" + NL + "\t\t\t\t\t// TODO - add log entry" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\treturn false;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t" + NL + "\t\t\tprivate Boolean evaluate(EObject context) {" + NL + "\t\t\t\tthis.evalContext = context.eClass();" + NL + "\t\t\t\tif(condition == null) {\t\t\t\t\t" + NL + "\t\t\t\t\tcondition = new OclConstraintCondition(body, evalContext);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif(condition != null) {" + NL + "\t\t\t\t\treturn booleanCast(condition.evaluate(context));" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t" + NL + "\t\t\t/**" + NL + "\t\t\t* @generated\t" + NL + "\t\t\t*/\t\t\t\t\t" + NL + "\t\t\tprivate static Boolean booleanCast(Object value) {" + NL + "\t\t\t\tif(value == null) {" + NL + "\t\t\t\t\treturn null;" + NL + "\t\t\t\t} else if(value instanceof Boolean) {" + NL + "\t\t\t\t\t return (Boolean)value;\t" + NL + "\t\t\t\t}" + NL + "\t\t\t\treturn Boolean.FALSE;" + NL + "\t\t\t}" + NL + "\t\t} // end of Matcher";
  protected final String TEXT_57 = "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tstatic class AcceptAllMatcher {" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t" + NL + "\t\t\tstatic final AcceptAllMatcher INSTANCE = new AcceptAllMatcher();" + NL + "\t\t\t/**" + NL + "\t\t\t * @generated" + NL + "\t\t\t */\t\t\t\t\t" + NL + "\t\t\tboolean matches(Object element) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */\t\t" + NL + "\t\tstatic AcceptAllMatcher acceptAllMatcher() {" + NL + "\t\t\treturn AcceptAllMatcher.INSTANCE;" + NL + "\t\t}" + NL + "\t} // end of ElementSelectors" + NL + "}" + NL + "\t";
  protected final String TEXT_58 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
List genNodes = genDiagram.getNodes();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
String semanticPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_5);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getDomainDiagramElement().getClassifierAccessorName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getVisualID());
    stringBuffer.append(TEXT_10);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String semanticNodeInterfaceName = genNode.getDomainMetaClass().getClassifierAccessorName();
	String qualifiedInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_11);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(semanticNodeInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genNode.getVisualID());
    stringBuffer.append(TEXT_16);
    
}

    stringBuffer.append(TEXT_17);
    
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String semanticChildNodeInterfaceName = genChildNode.getDomainMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_18);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(semanticChildNodeInterfaceName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genChildNode.getVisualID());
    stringBuffer.append(TEXT_23);
    	}
}

    stringBuffer.append(TEXT_24);
    
List genLinks = genDiagram.getLinks();
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String semanticLinkInterfaceName = modelFacet.getMetaClass().getClassifierAccessorName();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(semanticLinkInterfaceName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genLink.getVisualID());
    stringBuffer.append(TEXT_30);
    
		}
	}

    stringBuffer.append(TEXT_31);
    stringBuffer.append(genDiagram.getUniqueIdentifier());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDomainDiagramElement().getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_33);
    
String acceptAllMatcherAccessor = "acceptAllMatcher()"; //$NON-NLS-1$
for (int i = 0; i < genNodes.size(); i++) {
	GenNode genNode = (GenNode) genNodes.get(i);
	String qualifiedNodeInterfaceName = genNode.getDomainMetaClass().getQualifiedInterfaceName();
	String nodeSelector = genNode.getModelFacet() != null && genNode.getModelFacet().getModelElementSelector() != null ? genNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_34);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName(qualifiedNodeInterfaceName));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(nodeSelector);
    stringBuffer.append(TEXT_37);
    
	List genChildNodes = genNode.getChildNodes();
	for (int j = 0; j < genChildNodes.size(); j++) {
		GenChildNode genChildNode = (GenChildNode) genChildNodes.get(j);
		String qualifiedChildNodeInterfaceName = genChildNode.getDomainMetaClass().getQualifiedInterfaceName();
		String childNodeSelector = genChildNode.getModelFacet() != null && genChildNode.getModelFacet().getModelElementSelector() != null ? genChildNode.getUniqueIdentifier() : acceptAllMatcherAccessor;

    stringBuffer.append(TEXT_38);
    stringBuffer.append(genChildNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(qualifiedChildNodeInterfaceName));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(childNodeSelector);
    stringBuffer.append(TEXT_41);
    	}
}

    stringBuffer.append(TEXT_42);
    
for (int i = 0; i < genLinks.size(); i++) {
	GenLink genLink = (GenLink) genLinks.get(i);
	if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
		TypeLinkModelFacet modelFacet = (TypeLinkModelFacet) genLink.getModelFacet();
		String qualifiedInterfaceName = modelFacet.getMetaClass().getQualifiedInterfaceName();
		String linkSelector = modelFacet.getModelElementSelector() != null ? genLink.getUniqueIdentifier() : acceptAllMatcherAccessor;		

    stringBuffer.append(TEXT_43);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName(qualifiedInterfaceName));
    stringBuffer.append(TEXT_45);
    stringBuffer.append(linkSelector);
    stringBuffer.append(TEXT_46);
    
	}
}

    stringBuffer.append(TEXT_47);
    
int selectorCounter = 0;
for(Iterator it = AccessUtil.getGenEntities(genDiagram); it.hasNext();) {
	GenCommonBase nextElement = (GenCommonBase)it.next();
	TypeModelFacet modelFacet = null;
	if(nextElement instanceof GenNode) {
		modelFacet = ((GenNode)nextElement).getModelFacet();
	} else if(nextElement instanceof GenLink && 
		((GenLink)nextElement).getModelFacet() instanceof TypeLinkModelFacet) {
		modelFacet = (TypeLinkModelFacet)((GenLink)nextElement).getModelFacet();
	} 
	
	if(modelFacet == null || modelFacet.getModelElementSelector() == null) continue;
	ModelElementSelector selector = modelFacet.getModelElementSelector();
	selectorCounter++;
	
    stringBuffer.append(TEXT_48);
    stringBuffer.append(nextElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(selector.getLanguage());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(nextElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(selector.getBody());
    stringBuffer.append(TEXT_53);
    }
    stringBuffer.append(TEXT_54);
    if(selectorCounter > 0) { 
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.query.ocl.conditions.OclConstraintCondition"));
    stringBuffer.append(TEXT_56);
    }
    stringBuffer.append(TEXT_57);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_58);
    return stringBuffer.toString();
  }
}

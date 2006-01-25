package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class ModelingAssistantProviderGenerator
{
  protected static String nl;
  public static synchronized ModelingAssistantProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ModelingAssistantProviderGenerator result = new ModelingAssistantProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.util.ArrayList;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ModelingAssistantProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getTypesForPopupBar(IAdaptable host) {" + NL + "\t\tObject editPart = host.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_6 = NL + "\t\tif (editPart instanceof ";
  protected final String TEXT_7 = ") {" + NL + "\t\t\tList children = new ArrayList();";
  protected final String TEXT_8 = NL + "\t\t\tchildren.add(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ");";
  protected final String TEXT_11 = NL + "\t\t\treturn children;" + NL + "\t\t}";
  protected final String TEXT_12 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}";
  protected final String TEXT_13 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getRelTypesOnSource(IAdaptable source) {";
  protected final String TEXT_14 = NL + "\t\tObject sourceEditPart = source.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_15 = NL + "\t\tif (sourceEditPart instanceof ";
  protected final String TEXT_16 = ") {" + NL + "\t\t\tList children = new ArrayList();";
  protected final String TEXT_17 = NL + "\t\t\tchildren.add(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ");";
  protected final String TEXT_20 = NL + "\t\t\treturn children;" + NL + "\t\t}";
  protected final String TEXT_21 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getRelTypesOnTarget(IAdaptable target) {";
  protected final String TEXT_22 = NL + "\t\tObject targetEditPart = target.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_23 = NL + "\t\tif (targetEditPart instanceof ";
  protected final String TEXT_24 = ") {" + NL + "\t\t\tList children = new ArrayList();";
  protected final String TEXT_25 = NL + "\t\t\tchildren.add(";
  protected final String TEXT_26 = ".";
  protected final String TEXT_27 = ");";
  protected final String TEXT_28 = NL + "\t\t\treturn children;" + NL + "\t\t}";
  protected final String TEXT_29 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic List getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {";
  protected final String TEXT_30 = NL + "\t\tObject sourceEditPart = source.getAdapter(IGraphicalEditPart.class);" + NL + "\t\tObject targetEditPart = target.getAdapter(IGraphicalEditPart.class);";
  protected final String TEXT_31 = NL + "\t\tif (sourceEditPart instanceof ";
  protected final String TEXT_32 = ") {" + NL + "\t\t\tList children = new ArrayList();";
  protected final String TEXT_33 = NL + "\t\t\tif (targetEditPart instanceof ";
  protected final String TEXT_34 = ") {" + NL + "\t\t\t\tchildren.add(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");" + NL + "\t\t\t}";
  protected final String TEXT_37 = NL + "\t\t\treturn children;" + NL + "\t\t}";
  protected final String TEXT_38 = NL + "\t\treturn Collections.EMPTY_LIST;" + NL + "\t}" + NL + "}";
  protected final String TEXT_39 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getModelingAssistantProviderClassName());
    stringBuffer.append(TEXT_5);
    
List containers = new ArrayList();
containers.add(genDiagram);
containers.addAll(genDiagram.getAllNodes());
for (Iterator contents = containers.iterator(); contents.hasNext(); ) {
	GenContainerBase genContainer = (GenContainerBase) contents.next();
	List children = new ArrayList(genContainer.getContainedNodes());
	if (genContainer instanceof GenNode && ((GenNode) genContainer).isListLayout()) {
		for (Iterator compartments = ((GenNode) genContainer).getCompartments().iterator(); compartments.hasNext(); ) {
			children.addAll(((GenCompartment) compartments.next()).getContainedNodes());
		}
	}
	if (!children.isEmpty()) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genContainer.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    
			for (int i = 0; i < children.size(); i++) {
				String id = ((GenNode) children.get(i)).getUniqueIdentifier();

    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_10);
    			}
    stringBuffer.append(TEXT_11);
    
	}
}

    stringBuffer.append(TEXT_12);
    
Map linksForSources = new HashMap();
Map linksForTargets = new HashMap();
for (Iterator links = genDiagram.getLinks().iterator(); links.hasNext(); ) {
	GenLink genLink = (GenLink) links.next();
	for (Iterator sources = genLink.getSources().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();
		List value = (List) linksForSources.get(source);
		if (value == null) {
			value = new ArrayList();
			linksForSources.put(source, value);
		}
		value.add(genLink);
	}
	for (Iterator targets = genLink.getTargets().iterator(); targets.hasNext(); ) {
		GenCommonBase target = (GenCommonBase) targets.next();
		List value = (List) linksForTargets.get(target);
		if (value == null) {
			value = new ArrayList();
			linksForTargets.put(target, value);
		}
		value.add(genLink);
	}
}

    stringBuffer.append(TEXT_13);
    if (!linksForSources.isEmpty()) {
    stringBuffer.append(TEXT_14);
    
	for (Iterator sources = linksForSources.keySet().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();
		List sourceLinks = (List) linksForSources.get(source);

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(source.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    
		for (Iterator links = sourceLinks.iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();

    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_19);
    		}
    stringBuffer.append(TEXT_20);
    
	}
}

    stringBuffer.append(TEXT_21);
    if (!linksForTargets.isEmpty()) {
    stringBuffer.append(TEXT_22);
    
	for (Iterator targets = linksForTargets.keySet().iterator(); targets.hasNext(); ) {
		GenCommonBase target = (GenCommonBase) targets.next();
		List targetLinks = (List) linksForTargets.get(target);

    stringBuffer.append(TEXT_23);
    stringBuffer.append(importManager.getImportedName(target.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_24);
    
		for (Iterator links = targetLinks.iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();

    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_27);
    		}
    stringBuffer.append(TEXT_28);
    
	}
}

    stringBuffer.append(TEXT_29);
    if (!linksForSources.isEmpty()) {
    stringBuffer.append(TEXT_30);
    
	for (Iterator sources = linksForSources.keySet().iterator(); sources.hasNext(); ) {
		GenCommonBase source = (GenCommonBase) sources.next();
		List sourceLinks = (List) linksForSources.get(source);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(source.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    
		for (Iterator links = sourceLinks.iterator(); links.hasNext(); ) {
			GenLink genLink = (GenLink) links.next();
			for (Iterator targets = genLink.getTargets().iterator(); targets.hasNext(); ) {
				GenCommonBase target = (GenCommonBase) targets.next();

    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(target.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_36);
    
			}
		}

    stringBuffer.append(TEXT_37);
    
	}
}

    stringBuffer.append(TEXT_38);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_39);
    return stringBuffer.toString();
  }
}

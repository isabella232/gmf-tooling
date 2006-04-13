package org.eclipse.gmf.codegen.templates.lite.editor;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

public class PaletteFactoryGenerator
{
  protected static String nl;
  public static synchronized PaletteFactoryGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PaletteFactoryGenerator result = new PaletteFactoryGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final AdapterFactory domainAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_3 = "(AdapterFactory domainAdapterFactory) {" + NL + "\t\tthis.domainAdapterFactory = domainAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void contributeToPalette(PaletteRoot paletteRoot) {" + NL + "        PaletteGroup controls = new PaletteGroup(\"Controls\");" + NL + "        paletteRoot.add(controls);" + NL + "" + NL + "        ToolEntry tool = new SelectionToolEntry();" + NL + "        controls.add(tool);" + NL + "        paletteRoot.setDefaultEntry(tool);" + NL + "" + NL + "        controls.add(new MarqueeToolEntry());";
  protected final String TEXT_4 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_5 = "());";
  protected final String TEXT_6 = NL + "\t}" + NL;
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_8 = "() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_9 = "\");";
  protected final String TEXT_10 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_11 = "());";
  protected final String TEXT_12 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_13 = "());";
  protected final String TEXT_14 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_15 = "());";
  protected final String TEXT_16 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_18 = "() {" + NL + "\t\t";
  protected final String TEXT_19 = NL + "\t\tImageDescriptor smallImage = ImageDescriptor.createFromFile(";
  protected final String TEXT_20 = ".class, \"";
  protected final String TEXT_21 = "\");" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tImageDescriptor smallImage = getImage(";
  protected final String TEXT_23 = ");" + NL + "\t\t";
  protected final String TEXT_24 = NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\tImageDescriptor largeImage = ImageDescriptor.createFromFile(";
  protected final String TEXT_26 = ".class, \"";
  protected final String TEXT_27 = "\");" + NL + "\t\t";
  protected final String TEXT_28 = NL + "\t\tImageDescriptor largeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\tfinal int[] visualIds = new int[] {";
  protected final String TEXT_30 = NL + "\t\t\t";
  protected final String TEXT_31 = ",";
  protected final String TEXT_32 = "\t\t" + NL + "\t\t};" + NL + "\t\treturn new ";
  protected final String TEXT_33 = "(\"";
  protected final String TEXT_34 = "\", " + NL + "\t\t\t\"";
  protected final String TEXT_35 = "\", new ModelCreationFactory(";
  protected final String TEXT_36 = ".class), smallImage, largeImage) {" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool result = new CreationTool() {" + NL + "\t\t\t\t\tprotected Request createTargetRequest() {" + NL + "\t\t\t\t\t\tCreateRequestEx request = new CreateRequestEx(visualIds);" + NL + "\t\t\t\t\t\trequest.setFactory(getFactory());" + NL + "\t\t\t\t\t\treturn request;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\tprotected void performCreation(int button) {" + NL + "\t\t\t\t\t\tsuper.performCreation(button);" + NL + "\t\t\t\t\t\tfinal ";
  protected final String TEXT_37 = " createdEditPart = (";
  protected final String TEXT_38 = ")getCurrentViewer().getEditPartRegistry().get(getCreateRequest().getNewObject());" + NL + "\t\t\t\t\t\tif (createdEditPart != null) {" + NL + "\t\t\t\t\t\t\tgetCurrentViewer().getControl().getDisplay().asyncExec(new Runnable() {" + NL + "\t\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\t\tif (createdEditPart.isActive()) {" + NL + "\t\t\t\t\t\t\t\t\t\tcreatedEditPart.performRequest(new ";
  protected final String TEXT_39 = "(";
  protected final String TEXT_40 = ".REQ_DIRECT_EDIT));" + NL + "\t\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t});" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tresult.setProperties(getToolProperties());" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_41 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_42 = "() {" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\tImageDescriptor smallImage = ImageDescriptor.createFromFile(";
  protected final String TEXT_44 = ".class, \"";
  protected final String TEXT_45 = "\");" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\tImageDescriptor smallImage = getImage(";
  protected final String TEXT_47 = ");" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\tImageDescriptor largeImage = ImageDescriptor.createFromFile(";
  protected final String TEXT_50 = ".class, \"";
  protected final String TEXT_51 = "\");" + NL + "\t\t";
  protected final String TEXT_52 = NL + "\t\tImageDescriptor largeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\tfinal int[] visualIds = new int[] {";
  protected final String TEXT_54 = NL + "\t\t\t";
  protected final String TEXT_55 = ",";
  protected final String TEXT_56 = "\t\t" + NL + "\t\t};" + NL + "\t\treturn new ConnectionCreationToolEntry(\"";
  protected final String TEXT_57 = "\", \"";
  protected final String TEXT_58 = "\", " + NL + "\t\t\tnew ModelCreationFactory(";
  protected final String TEXT_59 = ".class), smallImage, largeImage) {" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool result = new ConnectionCreationTool() {" + NL + "\t\t\t\t\tprotected Request createTargetRequest() {" + NL + "\t\t\t\t\t\tCreateConnectionRequestEx request = new CreateConnectionRequestEx(visualIds);" + NL + "\t\t\t\t\t\trequest.setFactory(getFactory());" + NL + "\t\t\t\t\t\treturn request;" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t};" + NL + "\t\t\t\tresult.setProperties(getToolProperties());" + NL + "\t\t\t\treturn result;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_60 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getImage(Object o) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) domainAdapterFactory.adapt(o, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {" + NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(o));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class CreateRequestEx extends ";
  protected final String TEXT_61 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final int[] visualIds;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic CreateRequestEx(int[] visualIds) {" + NL + "\t\t\tthis.visualIds = visualIds;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int[] getVisualIds() {" + NL + "\t\t\treturn visualIds;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setCreatedObject(Object createdObject) {" + NL + "\t\t\t((ModelCreationFactory)getFactory()).setCreatedObject(createdObject);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class CreateConnectionRequestEx extends ";
  protected final String TEXT_62 = " {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final int[] visualIds;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic CreateConnectionRequestEx(int[] visualIds) {" + NL + "\t\t\tthis.visualIds = visualIds;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic int[] getVisualIds() {" + NL + "\t\t\treturn visualIds;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setCreatedObject(Object createdObject) {" + NL + "\t\t\t((ModelCreationFactory)getFactory()).setCreatedObject(createdObject);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class ModelCreationFactory implements CreationFactory {" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Object createdObject;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final Class createdObjectType;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic ModelCreationFactory(Class objectType) {" + NL + "\t\t\tcreatedObjectType = objectType;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object getNewObject() {" + NL + "\t\t\treturn createdObject;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Object getObjectType() {" + NL + "\t\t\treturn createdObjectType;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void setCreatedObject(Object createdObject) {" + NL + "\t\t\tthis.createdObject = createdObject;" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_63 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0]; 
final Palette palette = genDiagram.getPalette();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);

importManager.addImport("org.eclipse.gef.Tool");
importManager.addImport("org.eclipse.gef.Request");
importManager.addImport("org.eclipse.gef.requests.CreationFactory");
importManager.addImport("org.eclipse.gef.tools.CreationTool");
importManager.addImport("org.eclipse.gef.tools.ConnectionCreationTool");
importManager.addImport("org.eclipse.gef.palette.PaletteContainer");
importManager.addImport("org.eclipse.gef.palette.PaletteDrawer");
importManager.addImport("org.eclipse.gef.palette.PaletteGroup");
importManager.addImport("org.eclipse.gef.palette.PaletteRoot");
importManager.addImport("org.eclipse.gef.palette.ConnectionCreationToolEntry");
importManager.addImport("org.eclipse.gef.palette.MarqueeToolEntry");
importManager.addImport("org.eclipse.gef.palette.SelectionToolEntry");
importManager.addImport("org.eclipse.gef.palette.ToolEntry");
importManager.addImport("org.eclipse.jface.resource.ImageDescriptor");
importManager.addImport("org.eclipse.emf.edit.provider.IItemLabelProvider");
importManager.addImport("org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry");
importManager.addImport("org.eclipse.emf.common.notify.AdapterFactory");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_3);
    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_9);
    
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_11);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		if (j == 0) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_13);
    		}
    stringBuffer.append(TEXT_14);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_15);
    	}
    stringBuffer.append(TEXT_16);
    
}
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);
		List genNodes = nodeCreationTool.getGenNode();
		GenNode firstGenNode = (GenNode) genNodes.get(0);
		GenClass genClass = firstGenNode.getDomainMetaClass();
		final String domainElementInstanceCreationCode;
		if (!genClass.isMapEntry()) {
			domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";
		} else {
			domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create(" + 
				importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + genClass.getClassifierAccessorName() + "())";
		}

    stringBuffer.append(TEXT_17);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_18);
    if (nodeCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(nodeCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_21);
    } else {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    if (nodeCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(nodeCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_27);
    } else {
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    
		for (Iterator genNodesIterator = genNodes.iterator(); genNodesIterator.hasNext();) {
			GenNode nextNode = (GenNode) genNodesIterator.next();

    stringBuffer.append(TEXT_30);
    stringBuffer.append(nextNode.getVisualID());
    if (genNodesIterator.hasNext()) {
    stringBuffer.append(TEXT_31);
    }
    
		}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.CombinedTemplateCreationEntry"));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(nodeCreationTool.getTitleKey());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nodeCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_40);
    
	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		List genLinks = linkCreationTool.getGenLink();
		GenLink firstGenLink = (GenLink) genLinks.get(0);
		LinkModelFacet linkModelFacet = firstGenLink.getModelFacet();
		final String domainElementInstanceCreationCode;
		if (linkModelFacet instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) linkModelFacet;
			GenClass genClass = typeLinkModelFacet.getMetaClass();
			domainElementInstanceCreationCode = importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";
		} else {
			domainElementInstanceCreationCode = "null";
		}

    stringBuffer.append(TEXT_41);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_42);
    if (linkCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(linkCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_45);
    } else {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    if (linkCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(linkCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_51);
    } else {
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    
		for (Iterator genLinksIterator = genLinks.iterator(); genLinksIterator.hasNext();) {
			GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_54);
    stringBuffer.append(nextLink.getVisualID());
    if (genLinksIterator.hasNext()) {
    stringBuffer.append(TEXT_55);
    }
    
		}

    stringBuffer.append(TEXT_56);
    stringBuffer.append(linkCreationTool.getTitleKey());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(linkCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_59);
    
	}
}

    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateRequest"));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.requests.CreateConnectionRequest"));
    stringBuffer.append(TEXT_62);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_63);
    return stringBuffer.toString();
  }
}

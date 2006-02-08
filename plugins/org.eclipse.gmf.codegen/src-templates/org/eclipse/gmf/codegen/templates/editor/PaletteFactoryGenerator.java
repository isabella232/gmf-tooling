package org.eclipse.gmf.codegen.templates.editor;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.palette.MarqueeToolEntry;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteDrawer;" + NL + "import org.eclipse.gef.palette.PaletteGroup;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.PanningSelectionToolEntry;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;";
  protected final String TEXT_2 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Diagram diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_4 = "(Diagram diagram) {" + NL + "\t\tthis.diagram = diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final Diagram getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static PaletteRoot createPalette(Diagram diagram) {" + NL + "\t\tPaletteRoot paletteRoot = new PaletteRoot();" + NL + "\t\t";
  protected final String TEXT_5 = " factory = new ";
  protected final String TEXT_6 = "(diagram);" + NL + "\t\tPaletteContainer commonTools = factory.createCommonTools();" + NL + "\t\tpaletteRoot.add(commonTools);" + NL + "\t\tpaletteRoot.setDefaultEntry((ToolEntry) commonTools.getChildren().get(0));" + NL + "\t\tfactory.fillPalette(paletteRoot);" + NL + "\t\treturn paletteRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void fillPalette(PaletteRoot paletteRoot, Diagram diagram) {" + NL + "\t\t";
  protected final String TEXT_7 = " factory = new ";
  protected final String TEXT_8 = "(diagram);" + NL + "\t\tfactory.fillPalette(paletteRoot);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void fillPalette(PaletteRoot paletteRoot) {";
  protected final String TEXT_9 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_10 = "());";
  protected final String TEXT_11 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createCommonTools() {" + NL + "\t\tPaletteGroup common = new PaletteGroup(\"Common\");" + NL + "\t\tToolEntry selectionTool = new PanningSelectionToolEntry();" + NL + "\t\tcommon.add(selectionTool);" + NL + "\t\tcommon.add(new MarqueeToolEntry());";
  protected final String TEXT_12 = NL + "\t\tcommon.add(new ToolEntry(\"Zoom\", null, getZoomToolImage(), getZoomToolImage()," + NL + "\t\t\t";
  protected final String TEXT_13 = ".class) {});";
  protected final String TEXT_14 = NL + "\t\treturn common;" + NL + "\t}";
  protected final String TEXT_15 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getZoomToolImage() {" + NL + "\t\t";
  protected final String TEXT_16 = " action = new ";
  protected final String TEXT_17 = "(new ";
  protected final String TEXT_18 = "(null, null));" + NL + "\t\treturn action.getImageDescriptor();" + NL + "\t}";
  protected final String TEXT_19 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_20 = "() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_21 = "\");";
  protected final String TEXT_22 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_23 = "());";
  protected final String TEXT_24 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_25 = "());";
  protected final String TEXT_26 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_27 = "());";
  protected final String TEXT_28 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_30 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_31 = NL + "\t\tsmallImage = ";
  protected final String TEXT_32 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_33 = "\");" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\tsmallImage = ";
  protected final String TEXT_35 = ".getImageDescriptor(";
  protected final String TEXT_36 = ".";
  protected final String TEXT_37 = "); " + NL + "\t\t";
  protected final String TEXT_38 = NL + "\t\t";
  protected final String TEXT_39 = NL + "\t\tlargeImage = ";
  protected final String TEXT_40 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_41 = "\");" + NL + "\t\t";
  protected final String TEXT_42 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\tfinal ";
  protected final String TEXT_44 = " elementTypes = new ";
  protected final String TEXT_45 = "();";
  protected final String TEXT_46 = NL + "\t\telementTypes.add(";
  protected final String TEXT_47 = ".";
  protected final String TEXT_48 = ");";
  protected final String TEXT_49 = "\t\t" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_50 = "\", \"";
  protected final String TEXT_51 = "\", smallImage, largeImage) {" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ";
  protected final String TEXT_52 = "(elementTypes);" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_53 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_54 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\tsmallImage = ";
  protected final String TEXT_56 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_57 = "\");" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\tsmallImage = ";
  protected final String TEXT_59 = ".getImageDescriptor(";
  protected final String TEXT_60 = ".";
  protected final String TEXT_61 = "); " + NL + "\t\t";
  protected final String TEXT_62 = NL + "\t\t";
  protected final String TEXT_63 = NL + "\t\tlargeImage = ";
  protected final String TEXT_64 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_65 = "\");" + NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_67 = NL + "\t\tfinal ";
  protected final String TEXT_68 = " relationshipTypes = new ";
  protected final String TEXT_69 = "();";
  protected final String TEXT_70 = NL + "\t\trelationshipTypes.add(";
  protected final String TEXT_71 = ".";
  protected final String TEXT_72 = ");";
  protected final String TEXT_73 = "\t\t" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_74 = "\", \"";
  protected final String TEXT_75 = "\", smallImage, largeImage) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ";
  protected final String TEXT_76 = "(relationshipTypes);" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_77 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_78 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0]; 
final Palette palette = genDiagram.getPalette();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_8);
    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_9);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    if (palette.isNeedZoomTools()) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.internal.tools.ZoomTool"));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    if (palette.isNeedZoomTools()) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ZoomInAction"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ZoomInAction"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_18);
    
}
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_19);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_21);
    
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_23);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		if (j == 0) {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_25);
    		}
    stringBuffer.append(TEXT_26);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_27);
    	}
    stringBuffer.append(TEXT_28);
    
}
final String importedElementTypesClassName = importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName());
final String importedPluginClassName = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);
		List genNodes = nodeCreationTool.getGenNode();
		GenNode firstGenNode = (GenNode) genNodes.get(0);

    stringBuffer.append(TEXT_29);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_30);
    if (nodeCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nodeCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_33);
    } else {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(firstGenNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    if (nodeCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(nodeCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_41);
    } else {
    stringBuffer.append(TEXT_42);
    }
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_45);
    
		for (Iterator genNodesIterator = genNodes.iterator(); genNodesIterator.hasNext();) {
			GenNode nextNode = (GenNode) genNodesIterator.next();

    stringBuffer.append(TEXT_46);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_48);
    
		}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(nodeCreationTool.getTitleKey());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(nodeCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool"));
    stringBuffer.append(TEXT_52);
    
	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		List genLinks = linkCreationTool.getGenLink();
		GenLink firstGenLink = (GenLink) genLinks.get(0);

    stringBuffer.append(TEXT_53);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_54);
    if (linkCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_55);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(linkCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_57);
    } else {
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(firstGenLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_61);
    }
    stringBuffer.append(TEXT_62);
    if (linkCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(linkCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_65);
    } else {
    stringBuffer.append(TEXT_66);
    }
    stringBuffer.append(TEXT_67);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_69);
    
		for (Iterator genLinksIterator = genLinks.iterator(); genLinksIterator.hasNext();) {
			GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_72);
    
		}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(linkCreationTool.getTitleKey());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(linkCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool"));
    stringBuffer.append(TEXT_76);
    
	}
}

    stringBuffer.append(TEXT_77);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_78);
    return stringBuffer.toString();
  }
}

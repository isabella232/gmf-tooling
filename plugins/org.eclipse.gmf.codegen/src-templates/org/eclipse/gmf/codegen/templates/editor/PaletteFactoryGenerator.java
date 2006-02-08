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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.palette.MarqueeToolEntry;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteDrawer;" + NL + "import org.eclipse.gef.palette.PaletteGroup;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.PanningSelectionToolEntry;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Diagram diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_6 = "(Diagram diagram) {" + NL + "\t\tthis.diagram = diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final Diagram getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static PaletteRoot createPalette(Diagram diagram) {" + NL + "\t\tPaletteRoot paletteRoot = new PaletteRoot();" + NL + "\t\t";
  protected final String TEXT_7 = " factory = new ";
  protected final String TEXT_8 = "(diagram);" + NL + "\t\tPaletteContainer commonTools = factory.createCommonTools();" + NL + "\t\tpaletteRoot.add(commonTools);" + NL + "\t\tpaletteRoot.setDefaultEntry((ToolEntry) commonTools.getChildren().get(0));" + NL + "\t\tfactory.fillPalette(paletteRoot);" + NL + "\t\treturn paletteRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void fillPalette(PaletteRoot paletteRoot, Diagram diagram) {" + NL + "\t\t";
  protected final String TEXT_9 = " factory = new ";
  protected final String TEXT_10 = "(diagram);" + NL + "\t\tfactory.fillPalette(paletteRoot);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void fillPalette(PaletteRoot paletteRoot) {";
  protected final String TEXT_11 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_12 = "());";
  protected final String TEXT_13 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createCommonTools() {" + NL + "\t\tPaletteGroup common = new PaletteGroup(\"Common\");" + NL + "\t\tToolEntry selectionTool = new PanningSelectionToolEntry();" + NL + "\t\tcommon.add(selectionTool);" + NL + "\t\tcommon.add(new MarqueeToolEntry());";
  protected final String TEXT_14 = NL + "\t\tcommon.add(new ToolEntry(\"Zoom\", null, getZoomToolImage(), getZoomToolImage()," + NL + "\t\t\t";
  protected final String TEXT_15 = ".class) {});";
  protected final String TEXT_16 = NL + "\t\treturn common;" + NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getZoomToolImage() {" + NL + "\t\t";
  protected final String TEXT_18 = " action = new ";
  protected final String TEXT_19 = "(new ";
  protected final String TEXT_20 = "(null, null));" + NL + "\t\treturn action.getImageDescriptor();" + NL + "\t}";
  protected final String TEXT_21 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_22 = "() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_23 = "\");";
  protected final String TEXT_24 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_25 = "());";
  protected final String TEXT_26 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_27 = "());";
  protected final String TEXT_28 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_29 = "());";
  protected final String TEXT_30 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_31 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_32 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\tsmallImage = ";
  protected final String TEXT_34 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_35 = "\");" + NL + "\t\t";
  protected final String TEXT_36 = NL + "\t\tsmallImage = ";
  protected final String TEXT_37 = ".getImageDescriptor(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = "); " + NL + "\t\t";
  protected final String TEXT_40 = NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\tlargeImage = ";
  protected final String TEXT_42 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_43 = "\");" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_45 = NL + "\t\tfinal ";
  protected final String TEXT_46 = " elementTypes = new ";
  protected final String TEXT_47 = "();";
  protected final String TEXT_48 = NL + "\t\telementTypes.add(";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = ");";
  protected final String TEXT_51 = "\t\t" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_52 = "\", \"";
  protected final String TEXT_53 = "\", smallImage, largeImage) {" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ";
  protected final String TEXT_54 = "(elementTypes);" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_55 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_56 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\tsmallImage = ";
  protected final String TEXT_58 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_59 = "\");" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\tsmallImage = ";
  protected final String TEXT_61 = ".getImageDescriptor(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = "); " + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\tlargeImage = ";
  protected final String TEXT_66 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_67 = "\");" + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\tfinal ";
  protected final String TEXT_70 = " relationshipTypes = new ";
  protected final String TEXT_71 = "();";
  protected final String TEXT_72 = NL + "\t\trelationshipTypes.add(";
  protected final String TEXT_73 = ".";
  protected final String TEXT_74 = ");";
  protected final String TEXT_75 = "\t\t" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_76 = "\", \"";
  protected final String TEXT_77 = "\", smallImage, largeImage) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ";
  protected final String TEXT_78 = "(relationshipTypes);" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_79 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_80 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument; Palette palette = genDiagram.getPalette();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(palette.getPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(palette.getPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_10);
    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_11);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if (palette.isNeedZoomTools()) {
    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.internal.tools.ZoomTool"));
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if (palette.isNeedZoomTools()) {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ZoomInAction"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.ui.actions.ZoomInAction"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.editparts.ZoomManager"));
    stringBuffer.append(TEXT_20);
    
}
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_21);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_23);
    
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_24);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_25);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		if (j == 0) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_27);
    		}
    stringBuffer.append(TEXT_28);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_29);
    	}
    stringBuffer.append(TEXT_30);
    
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

    stringBuffer.append(TEXT_31);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_32);
    if (nodeCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nodeCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_35);
    } else {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(firstGenNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    if (nodeCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(nodeCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    }
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_47);
    
		for (Iterator genNodesIterator = genNodes.iterator(); genNodesIterator.hasNext();) {
			GenNode nextNode = (GenNode) genNodesIterator.next();

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_50);
    
		}

    stringBuffer.append(TEXT_51);
    stringBuffer.append(nodeCreationTool.getTitleKey());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(nodeCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool"));
    stringBuffer.append(TEXT_54);
    
	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		List genLinks = linkCreationTool.getGenLink();
		GenLink firstGenLink = (GenLink) genLinks.get(0);

    stringBuffer.append(TEXT_55);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_56);
    if (linkCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(linkCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_59);
    } else {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(firstGenLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    if (linkCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(linkCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_67);
    } else {
    stringBuffer.append(TEXT_68);
    }
    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_71);
    
		for (Iterator genLinksIterator = genLinks.iterator(); genLinksIterator.hasNext();) {
			GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_72);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_74);
    
		}

    stringBuffer.append(TEXT_75);
    stringBuffer.append(linkCreationTool.getTitleKey());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(linkCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool"));
    stringBuffer.append(TEXT_78);
    
	}
}

    stringBuffer.append(TEXT_79);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_80);
    return stringBuffer.toString();
  }
}

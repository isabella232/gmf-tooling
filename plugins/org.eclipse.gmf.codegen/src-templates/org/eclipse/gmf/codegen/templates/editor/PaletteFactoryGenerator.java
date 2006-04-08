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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteDrawer;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void fillPalette(PaletteRoot paletteRoot) {";
  protected final String TEXT_7 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_8 = "());";
  protected final String TEXT_9 = NL + "\t}" + NL;
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_11 = "() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_12 = "\");";
  protected final String TEXT_13 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_14 = "());";
  protected final String TEXT_15 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_16 = "());";
  protected final String TEXT_17 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_18 = "());";
  protected final String TEXT_19 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_20 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_21 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_22 = NL + "\t\tsmallImage = ";
  protected final String TEXT_23 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_24 = "\");" + NL + "\t\t";
  protected final String TEXT_25 = NL + "\t\tsmallImage = ";
  protected final String TEXT_26 = ".getImageDescriptor(";
  protected final String TEXT_27 = ".";
  protected final String TEXT_28 = "); " + NL + "\t\t";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = NL + "\t\tlargeImage = ";
  protected final String TEXT_31 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_32 = "\");" + NL + "\t\t";
  protected final String TEXT_33 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_34 = NL + "\t\tfinal ";
  protected final String TEXT_35 = " elementTypes = new ";
  protected final String TEXT_36 = "();";
  protected final String TEXT_37 = NL + "\t\telementTypes.add(";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ");";
  protected final String TEXT_40 = "\t\t" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_41 = "\", \"";
  protected final String TEXT_42 = "\", smallImage, largeImage) {" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ";
  protected final String TEXT_43 = "(elementTypes);" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_44 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_45 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\tsmallImage = ";
  protected final String TEXT_47 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_48 = "\");" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\tsmallImage = ";
  protected final String TEXT_50 = ".getImageDescriptor(";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = "); " + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = NL + "\t\tlargeImage = ";
  protected final String TEXT_55 = ".getBundledImageDescriptor(\"";
  protected final String TEXT_56 = "\");" + NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_58 = NL + "\t\tfinal ";
  protected final String TEXT_59 = " relationshipTypes = new ";
  protected final String TEXT_60 = "();";
  protected final String TEXT_61 = NL + "\t\trelationshipTypes.add(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = "\t\t" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_65 = "\", \"";
  protected final String TEXT_66 = "\", smallImage, largeImage) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ";
  protected final String TEXT_67 = "(relationshipTypes);" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_68 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_69 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0]; 
final Palette palette = genDiagram.getPalette();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_6);
    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_12);
    
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_13);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_14);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		if (j == 0) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_16);
    		}
    stringBuffer.append(TEXT_17);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_18);
    	}
    stringBuffer.append(TEXT_19);
    
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

    stringBuffer.append(TEXT_20);
    stringBuffer.append(nodeCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_21);
    if (nodeCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(nodeCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(firstGenNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    }
    stringBuffer.append(TEXT_29);
    if (nodeCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(nodeCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_32);
    } else {
    stringBuffer.append(TEXT_33);
    }
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_36);
    
		for (Iterator genNodesIterator = genNodes.iterator(); genNodesIterator.hasNext();) {
			GenNode nextNode = (GenNode) genNodesIterator.next();

    stringBuffer.append(TEXT_37);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_39);
    
		}

    stringBuffer.append(TEXT_40);
    stringBuffer.append(nodeCreationTool.getTitleKey());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(nodeCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool"));
    stringBuffer.append(TEXT_43);
    
	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		List genLinks = linkCreationTool.getGenLink();
		GenLink firstGenLink = (GenLink) genLinks.get(0);

    stringBuffer.append(TEXT_44);
    stringBuffer.append(linkCreationTool.getCreateMethodName());
    stringBuffer.append(TEXT_45);
    if (linkCreationTool.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(linkCreationTool.getSmallIconPath());
    stringBuffer.append(TEXT_48);
    } else {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(firstGenLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_52);
    }
    stringBuffer.append(TEXT_53);
    if (linkCreationTool.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(linkCreationTool.getLargeIconPath());
    stringBuffer.append(TEXT_56);
    } else {
    stringBuffer.append(TEXT_57);
    }
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_60);
    
		for (Iterator genLinksIterator = genLinks.iterator(); genLinksIterator.hasNext();) {
			GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_61);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    
		}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(linkCreationTool.getTitleKey());
    stringBuffer.append(TEXT_65);
    stringBuffer.append(linkCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool"));
    stringBuffer.append(TEXT_67);
    
	}
}

    stringBuffer.append(TEXT_68);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_69);
    return stringBuffer.toString();
  }
}

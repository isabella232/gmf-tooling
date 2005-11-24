package org.eclipse.gmf.codegen.templates.editor;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_3 = NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.palette.MarqueeToolEntry;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteDrawer;" + NL + "import org.eclipse.gef.palette.PaletteGroup;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.PaletteSeparator;" + NL + "import org.eclipse.gef.palette.PanningSelectionToolEntry;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Diagram diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_6 = "(Diagram diagram) {" + NL + "\t\tthis.diagram = diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final Diagram getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static PaletteRoot createPalette(Diagram diagram) {" + NL + "\t\tPaletteRoot paletteRoot = new PaletteRoot();" + NL + "\t\t";
  protected final String TEXT_7 = " factory = new ";
  protected final String TEXT_8 = "(diagram);" + NL + "\t\tPaletteContainer commonTools = factory.createCommonTools();" + NL + "\t\tpaletteRoot.add(commonTools);" + NL + "\t\tpaletteRoot.setDefaultEntry((ToolEntry) commonTools.getChildren().get(0));" + NL + "\t\tfactory.fillPalette(paletteRoot);" + NL + "\t\treturn paletteRoot;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static void fillPalette(PaletteRoot paletteRoot, Diagram diagram) {" + NL + "\t\t";
  protected final String TEXT_9 = " factory = new ";
  protected final String TEXT_10 = "(diagram);" + NL + "\t\tfactory.fillPalette(paletteRoot);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void fillPalette(PaletteRoot paletteRoot) {";
  protected final String TEXT_11 = NL + "\t\tpaletteRoot.add(create";
  protected final String TEXT_12 = "Group());";
  protected final String TEXT_13 = NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createCommonTools() {" + NL + "\t\tPaletteGroup common = new PaletteGroup(\"Common\");" + NL + "\t\tToolEntry selectionTool = new PanningSelectionToolEntry();" + NL + "\t\tcommon.add(selectionTool);" + NL + "\t\tcommon.add(new MarqueeToolEntry());";
  protected final String TEXT_14 = NL + "\t\tcommon.add(new ToolEntry(\"Zoom\", null, getZoomToolImage(), getZoomToolImage()," + NL + "\t\t\t";
  protected final String TEXT_15 = ".class) {});";
  protected final String TEXT_16 = NL + "\t\treturn common;" + NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getZoomToolImage() {" + NL + "\t\t";
  protected final String TEXT_18 = " action = new ";
  protected final String TEXT_19 = "(new ";
  protected final String TEXT_20 = "(null, null));" + NL + "\t\treturn action.getImageDescriptor();" + NL + "\t}";
  protected final String TEXT_21 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer create";
  protected final String TEXT_22 = "Group() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_23 = "\");";
  protected final String TEXT_24 = NL + "\t\tpaletteContainer.add(create";
  protected final String TEXT_25 = "CreationTool());";
  protected final String TEXT_26 = NL + "\t\tpaletteContainer.add(new PaletteSeparator());";
  protected final String TEXT_27 = NL + "\t\tpaletteContainer.add(create";
  protected final String TEXT_28 = "CreationTool());";
  protected final String TEXT_29 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_30 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry create";
  protected final String TEXT_31 = "CreationTool() {" + NL + "\t\tImageDescriptor image = ";
  protected final String TEXT_32 = ".getImageDescriptor(" + NL + "\t\t\t";
  protected final String TEXT_33 = ".";
  protected final String TEXT_34 = ");" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_35 = "\", \"";
  protected final String TEXT_36 = "\", image, image) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new CreationTool(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ");" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry create";
  protected final String TEXT_40 = "CreationTool() {" + NL + "\t\tImageDescriptor image = ";
  protected final String TEXT_41 = ".getImageDescriptor(" + NL + "\t\t\t";
  protected final String TEXT_42 = ".";
  protected final String TEXT_43 = ");" + NL + "\t\treturn new ToolEntry(\"";
  protected final String TEXT_44 = "\", \"";
  protected final String TEXT_45 = "\", image, image) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ConnectionCreationTool(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = ");" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}";
  protected final String TEXT_48 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "}";
  protected final String TEXT_49 = NL;

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
    stringBuffer.append(AccessUtil.getPaletteEntryId(toolGroup));
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
    stringBuffer.append(AccessUtil.getPaletteEntryId(toolGroup));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_23);
    
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_24);
    stringBuffer.append(AccessUtil.getPaletteEntryId(nodeCreationTool));
    stringBuffer.append(TEXT_25);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		if (j == 0) {

    stringBuffer.append(TEXT_26);
    		}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(AccessUtil.getPaletteEntryId(linkCreationTool));
    stringBuffer.append(TEXT_28);
    	}
    stringBuffer.append(TEXT_29);
    
}
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);
		GenNode genNode = nodeCreationTool.getGenNode(); 

    stringBuffer.append(TEXT_30);
    stringBuffer.append(AccessUtil.getPaletteEntryId(nodeCreationTool));
    stringBuffer.append(TEXT_31);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_32);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(nodeCreationTool.getTitleKey());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(nodeCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_38);
    
	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		GenLink genLink = linkCreationTool.getGenLink();

    stringBuffer.append(TEXT_39);
    stringBuffer.append(AccessUtil.getPaletteEntryId(linkCreationTool));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(linkCreationTool.getTitleKey());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(linkCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    
	}
}

    stringBuffer.append(TEXT_48);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_49);
    return stringBuffer.toString();
  }
}

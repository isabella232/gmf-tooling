package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
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
  protected final String TEXT_3 = NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.editparts.ZoomManager;" + NL + "import org.eclipse.gef.palette.MarqueeToolEntry;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteDrawer;" + NL + "import org.eclipse.gef.palette.PaletteGroup;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.PaletteSeparator;" + NL + "import org.eclipse.gef.palette.PanningSelectionToolEntry;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.gef.ui.actions.ZoomInAction;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.internal.tools.ZoomTool;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectorCreationTool;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import ";
  protected final String TEXT_4 = ".ElementTypes;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final PaletteRoot root = new PaletteRoot();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final Diagram diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = "(Diagram diagram) {" + NL + "\t\tthis.diagram = diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static PaletteRoot createPalette(Diagram diagram) {" + NL + "\t\t";
  protected final String TEXT_8 = " factory = new ";
  protected final String TEXT_9 = "(diagram);" + NL + "\t\tfactory.createCommonTools();";
  protected final String TEXT_10 = NL + "\t\tfactory.create";
  protected final String TEXT_11 = "Group();";
  protected final String TEXT_12 = NL + "\t\treturn factory.root;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Diagram getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createCommonTools() {" + NL + "\t\tPaletteGroup common = new PaletteGroup(\"Common\");" + NL + "\t\tToolEntry selectionTool = new PanningSelectionToolEntry();" + NL + "\t\tcommon.add(selectionTool);" + NL + "\t\tcommon.add(new MarqueeToolEntry());";
  protected final String TEXT_13 = NL + "\t\tcommon.add(new ToolEntry(\"Zoom\", null, getZoomToolImage(), getZoomToolImage(), ZoomTool.class) {});";
  protected final String TEXT_14 = NL + "\t\troot.add(common);" + NL + "\t\troot.setDefaultEntry(selectionTool);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getZoomToolImage() {" + NL + "\t\tZoomInAction action = new ZoomInAction(new ZoomManager(null, null));" + NL + "\t\treturn action.getImageDescriptor();" + NL + "\t}";
  protected final String TEXT_15 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_16 = "Group() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "\t\tcreate";
  protected final String TEXT_19 = "CreationTool(paletteContainer);";
  protected final String TEXT_20 = NL + "\t\tpaletteContainer.add(new PaletteSeparator());";
  protected final String TEXT_21 = NL + "\t\tcreate";
  protected final String TEXT_22 = "CreationTool(paletteContainer);";
  protected final String TEXT_23 = NL + "\t\troot.add(paletteContainer);" + NL + "\t}";
  protected final String TEXT_24 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_25 = "CreationTool(PaletteContainer paletteContainer) {";
  protected final String TEXT_26 = NL + "\t\tImageDescriptor img = getImage(";
  protected final String TEXT_27 = ");" + NL + "\t\tpaletteContainer.add(new ToolEntry(\"";
  protected final String TEXT_28 = "\"," + NL + "\t\t\t\"";
  protected final String TEXT_29 = "\", img, img) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new CreationTool(ElementTypes.";
  protected final String TEXT_30 = ");" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_31 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void create";
  protected final String TEXT_32 = "CreationTool(PaletteContainer paletteContainer) {";
  protected final String TEXT_33 = NL + "\t\tImageDescriptor img = getImage(";
  protected final String TEXT_34 = ");" + NL + "\t\tpaletteContainer.add(new ToolEntry(\"";
  protected final String TEXT_35 = "\"," + NL + "\t\t\t\"";
  protected final String TEXT_36 = "\", img, img) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ConnectorCreationTool(ElementTypes.";
  protected final String TEXT_37 = ");" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_38 = NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getImage(Object item) {" + NL + "\t\treturn ";
  protected final String TEXT_40 = ".getInstance().getItemImageDescriptor(item);" + NL + "\t}" + NL + "}";
  protected final String TEXT_41 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument; Palette palette = genDiagram.getPalette();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(palette.getPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(palette.getPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_9);
    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_10);
    stringBuffer.append(AccessUtil.getPaletteEntryId(toolGroup));
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    if (palette.isNeedZoomTools()) {
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_15);
    stringBuffer.append(AccessUtil.getPaletteEntryId(toolGroup));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_17);
    
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_18);
    stringBuffer.append(AccessUtil.getPaletteEntryId(nodeCreationTool));
    stringBuffer.append(TEXT_19);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);
		if (j == 0) {

    stringBuffer.append(TEXT_20);
    		}
    stringBuffer.append(TEXT_21);
    stringBuffer.append(AccessUtil.getPaletteEntryId(linkCreationTool));
    stringBuffer.append(TEXT_22);
    	}
    stringBuffer.append(TEXT_23);
    
}
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);
	List nodeCreationTools = toolGroup.getNodeTools();
	for (int j = 0; j < nodeCreationTools.size(); j++) {
		NodeEntry nodeCreationTool = (NodeEntry) nodeCreationTools.get(j);

    stringBuffer.append(TEXT_24);
    stringBuffer.append(AccessUtil.getPaletteEntryId(nodeCreationTool));
    stringBuffer.append(TEXT_25);
    
		GenNode genNode = nodeCreationTool.getGenNode(); 
		GenClass genClass = genNode.getDomainMetaClass();
		String domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";

    stringBuffer.append(TEXT_26);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(nodeCreationTool.getTitleKey());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(nodeCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genNode.getDomainMetaClass().getName());
    stringBuffer.append(TEXT_30);
    	}
	List linkCreationTools = toolGroup.getLinkTools();
	for (int j = 0; j < linkCreationTools.size(); j++) {
		LinkEntry linkCreationTool = (LinkEntry) linkCreationTools.get(j);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(AccessUtil.getPaletteEntryId(linkCreationTool));
    stringBuffer.append(TEXT_32);
    
		GenLink genLink = linkCreationTool.getGenLink();
		if (genLink instanceof GenLinkWithClass) {
			GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
			GenClass genClass = genLinkWithClass.getDomainMetaClass();
			String domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";

    stringBuffer.append(TEXT_33);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(linkCreationTool.getTitleKey());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(linkCreationTool.getDescriptionKey());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genLinkWithClass.getDomainMetaClass().getName());
    stringBuffer.append(TEXT_37);
    		}
    stringBuffer.append(TEXT_38);
    	}
}

    stringBuffer.append(TEXT_39);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_40);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_41);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

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
  protected final String TEXT_3 = NL + "import org.eclipse.emf.common.notify.AdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.IItemLabelProvider;" + NL + "import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;" + NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.palette.MarqueeToolEntry;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteDrawer;" + NL + "import org.eclipse.gef.palette.PaletteGroup;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.PaletteSeparator;" + NL + "import org.eclipse.gef.palette.PanningSelectionToolEntry;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectorCreationTool;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;" + NL + "import org.eclipse.gmf.runtime.notation.Diagram;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import ";
  protected final String TEXT_4 = ".ElementTypes;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final PaletteRoot root = new PaletteRoot();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final AdapterFactory adapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final Diagram diagram;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = "(AdapterFactory adapterFactory, Diagram diagram) {" + NL + "\t\tthis.adapterFactory = adapterFactory;" + NL + "\t\tthis.diagram = diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static PaletteRoot createPalette(AdapterFactory adapterFactory, Diagram diagram) {" + NL + "\t\t";
  protected final String TEXT_8 = " factory = new ";
  protected final String TEXT_9 = "(adapterFactory, diagram);" + NL + "\t\tfactory.setupCommonTools();";
  protected final String TEXT_10 = NL + "\t\tfactory.createToolGroup";
  protected final String TEXT_11 = "();";
  protected final String TEXT_12 = NL + "\t\treturn factory.root;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Diagram getDiagram() {" + NL + "\t\treturn diagram;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setupCommonTools() {" + NL + "\t\tPaletteGroup common = new PaletteGroup(\"Common\");" + NL + "" + NL + "\t\tToolEntry selectionTool = new PanningSelectionToolEntry();" + NL + "\t\tcommon.add(selectionTool);" + NL + "\t\tcommon.add(new MarqueeToolEntry());" + NL + "" + NL + "\t\troot.setDefaultEntry(selectionTool);" + NL + "" + NL + "\t\troot.add(common);" + NL + "\t}";
  protected final String TEXT_13 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createToolGroup";
  protected final String TEXT_14 = "() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_15 = "\");";
  protected final String TEXT_16 = NL + "\t\tcreateNodeTool";
  protected final String TEXT_17 = "(paletteContainer);";
  protected final String TEXT_18 = NL + "\t\tpaletteContainer.add(new PaletteSeparator());";
  protected final String TEXT_19 = NL + "\t\tcreateLinkTool";
  protected final String TEXT_20 = "(paletteContainer);";
  protected final String TEXT_21 = NL + "\t\troot.add(paletteContainer);" + NL + "\t}";
  protected final String TEXT_22 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createNodeTool";
  protected final String TEXT_23 = "(PaletteContainer paletteContainer) {";
  protected final String TEXT_24 = NL + "\t\tImageDescriptor img = getImage(";
  protected final String TEXT_25 = ");" + NL + "\t\tpaletteContainer.add(new ToolEntry(\"";
  protected final String TEXT_26 = "\"," + NL + "\t\t\t\"";
  protected final String TEXT_27 = "\", img, img) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new CreationTool(ElementTypes.";
  protected final String TEXT_28 = ");" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t});" + NL + "\t}";
  protected final String TEXT_29 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createLinkTool";
  protected final String TEXT_30 = "(PaletteContainer paletteContainer) {";
  protected final String TEXT_31 = NL + "\t\tImageDescriptor img = getImage(";
  protected final String TEXT_32 = ");" + NL + "\t\tpaletteContainer.add(new ToolEntry(\"";
  protected final String TEXT_33 = "\"," + NL + "\t\t\t\"";
  protected final String TEXT_34 = "\", img, img) {" + NL + "" + NL + "\t\t\tpublic Tool createTool() {" + NL + "\t\t\t\tTool tool = new ConnectorCreationTool(ElementTypes.";
  protected final String TEXT_35 = ");" + NL + "\t\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\t\treturn tool;" + NL + "\t\t\t}" + NL + "\t\t});";
  protected final String TEXT_36 = NL + "\t}";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getImage(Object obj) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(obj, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {" + NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(obj));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_38 = NL;

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
    for (int toolGroupIndex = 0; toolGroupIndex < palette.getGroups().size(); toolGroupIndex++) {
    stringBuffer.append(TEXT_10);
    stringBuffer.append(toolGroupIndex);
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    
int nodeToolIndex = 0;
int linkToolIndex = 0;
List toolGroups = palette.getGroups();
for (int toolGroupIndex = 0; toolGroupIndex < toolGroups.size(); toolGroupIndex++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(toolGroupIndex);

    stringBuffer.append(TEXT_13);
    stringBuffer.append(toolGroupIndex);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(toolGroup.getTitleKey());
    stringBuffer.append(TEXT_15);
    	for (int i = toolGroup.getNodeTools().size(); i > 0; i--, nodeToolIndex++) {
    stringBuffer.append(TEXT_16);
    stringBuffer.append(nodeToolIndex);
    stringBuffer.append(TEXT_17);
    	}
    stringBuffer.append(TEXT_18);
    	for (int i = toolGroup.getLinkTools().size(); i > 0; i--, linkToolIndex++) {
    stringBuffer.append(TEXT_19);
    stringBuffer.append(linkToolIndex);
    stringBuffer.append(TEXT_20);
    	}
    stringBuffer.append(TEXT_21);
    
}
// Move on and create methods called from createToolGroup 
nodeToolIndex = 0;
linkToolIndex = 0;
for (int toolGroupIndex = 0; toolGroupIndex < toolGroups.size(); toolGroupIndex++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(toolGroupIndex);
	List nodeEntries = toolGroup.getNodeTools();
	for (int i = 0; i < nodeEntries.size(); i++, nodeToolIndex++) {
		NodeEntry nodeEntry = (NodeEntry) nodeEntries.get(i);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(nodeToolIndex);
    stringBuffer.append(TEXT_23);
    
		GenNode genNode = nodeEntry.getGenNode(); 
		GenClass genClass = genDiagram.findGenClass(genNode.getDomainMetaClass());
		String domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";

    stringBuffer.append(TEXT_24);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(nodeEntry.getTitleKey());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(nodeEntry.getDescriptionKey());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genNode.getDomainMetaClass().getName());
    stringBuffer.append(TEXT_28);
    	}
	List linkEntries = toolGroup.getLinkTools();
	for (int i = 0; i < linkEntries.size(); i++, linkToolIndex++) {
		LinkEntry linkEntry = (LinkEntry) linkEntries.get(i);

    stringBuffer.append(TEXT_29);
    stringBuffer.append(linkToolIndex);
    stringBuffer.append(TEXT_30);
    
		GenLink genLink = linkEntry.getGenLink();
		if (genLink instanceof GenLinkWithClass) {
			GenLinkWithClass genLinkWithClass = (GenLinkWithClass) genLink;
			GenClass genClass = genDiagram.findGenClass(genLinkWithClass.getDomainMetaClass());
			String domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";

    stringBuffer.append(TEXT_31);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(linkEntry.getTitleKey());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(linkEntry.getDescriptionKey());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genLinkWithClass.getDomainMetaClass().getName());
    stringBuffer.append(TEXT_35);
    		}
    stringBuffer.append(TEXT_36);
    	}
}

    stringBuffer.append(TEXT_37);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.diacanvas;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class PaletteGen
{
  protected static String nl;
  public static synchronized PaletteGen create(String lineSeparator)
  {
    nl = lineSeparator;
    PaletteGen result = new PaletteGen();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.emf.common.notify.AdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.IItemLabelProvider;" + NL + "import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;" + NL + "import org.eclipse.gef.palette.*;" + NL + "import org.eclipse.gef.requests.CreationFactory;" + NL + "import org.eclipse.jface.resource.*;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final PaletteRoot myRoot = new PaletteRoot();" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final AdapterFactory myAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_6 = "(AdapterFactory adapterFactory) {" + NL + "\t\tmyAdapterFactory = adapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteRoot getRoot() {" + NL + "\t\treturn myRoot;" + NL + "\t} " + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static PaletteRoot createPalette(AdapterFactory adapterFactory) {" + NL + "\t\t";
  protected final String TEXT_7 = " factory = new ";
  protected final String TEXT_8 = "(adapterFactory);" + NL + "\t\tfactory.setupCommonTools();" + NL;
  protected final String TEXT_9 = NL + "\t\tfactory.createToolGroup";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL + "\t\treturn factory.getRoot();" + NL + "\t}" + NL;
  protected final String TEXT_12 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createToolGroup";
  protected final String TEXT_13 = "() {" + NL + "\t\tPaletteContainer paletteContainer = createContainer(\"";
  protected final String TEXT_14 = "\");" + NL + "\t\t// Nodes";
  protected final String TEXT_15 = NL + "\t\tcreateNodeTool";
  protected final String TEXT_16 = "(paletteContainer);";
  protected final String TEXT_17 = NL + "\t\tpaletteContainer.add(new PaletteSeparator());" + NL + "\t\t// Links";
  protected final String TEXT_18 = NL + "\t\tcreateLinkTool";
  protected final String TEXT_19 = "(paletteContainer);";
  protected final String TEXT_20 = NL + "\t\tgetRoot().add(paletteContainer);" + NL + "\t}";
  protected final String TEXT_21 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void setupCommonTools() {";
  protected final String TEXT_22 = NL;
  protected final String TEXT_23 = "\t\tPaletteGroup common = new PaletteGroup(\"Common controls\");" + NL + "" + NL + "\t\tToolEntry selectionTool = new PanningSelectionToolEntry();" + NL + "\t\tcommon.add(selectionTool);" + NL + "\t\tcommon.add(new MarqueeToolEntry());" + NL + "" + NL + "\t\tgetRoot().setDefaultEntry(selectionTool);" + NL + "" + NL + "\t\tgetRoot().add(common);" + NL + "\t}" + NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createNodeTool";
  protected final String TEXT_26 = "(PaletteContainer paletteContainer) {" + NL + "" + NL + "//\t\tImageDescriptor img = ImageDescriptor.createFromFile(";
  protected final String TEXT_27 = ".class, \"";
  protected final String TEXT_28 = "\");" + NL + "\t\tImageDescriptor img = getImage(";
  protected final String TEXT_29 = ");" + NL + "\t\tCreationFactory creationFactory = new CreationNodeFactory";
  protected final String TEXT_30 = "();" + NL + "\t\tpaletteContainer.add(new CreationToolEntry(\"";
  protected final String TEXT_31 = "\", \"";
  protected final String TEXT_32 = "\", creationFactory, img, img));" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class CreationNodeFactory";
  protected final String TEXT_33 = " implements CreationFactory {" + NL + "\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tpublic Object getNewObject() {" + NL + "\t\t\t";
  protected final String TEXT_34 = " diagramNode = ";
  protected final String TEXT_35 = ".eINSTANCE.create";
  protected final String TEXT_36 = "();" + NL + "\t\t\tdiagramNode.setDomainModelElement(";
  protected final String TEXT_37 = ");" + NL + "\t\t\tdiagramNode.setVisualID(";
  protected final String TEXT_38 = ".VISUAL_ID);";
  protected final String TEXT_39 = NL + "\t\t\tdiagramNode.setGroupID(\"";
  protected final String TEXT_40 = "\");";
  protected final String TEXT_41 = NL + "\t\t\tinitialize(diagramNode);" + NL + "\t\t\treturn diagramNode;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tpublic Object getObjectType() {";
  protected final String TEXT_42 = NL + "\t\t\treturn ";
  protected final String TEXT_43 = ".class;";
  protected final String TEXT_44 = NL + "\t\t\treturn ";
  protected final String TEXT_45 = ".class;";
  protected final String TEXT_46 = NL + "\t\t}" + NL + "\t\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tprivate void initialize(";
  protected final String TEXT_47 = " diagramNode) {" + NL + "\t\t// place initialization code for attributes specific to your Diagram RunTime model here" + NL + "\t\t}" + NL + "\t};";
  protected final String TEXT_48 = NL;
  protected final String TEXT_49 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void createLinkTool";
  protected final String TEXT_50 = "(PaletteContainer paletteContainer) {" + NL + "" + NL + "\t\t//ImageDescriptor img = ImageDescriptor.createFromFile(";
  protected final String TEXT_51 = ".class, \"";
  protected final String TEXT_52 = "\");*/";
  protected final String TEXT_53 = NL + "\t\tImageDescriptor img = getImage(";
  protected final String TEXT_54 = ");" + NL + "\t\tCreationFactory creationFactory = new CreationLinkFactory";
  protected final String TEXT_55 = "();" + NL + "\t\tpaletteContainer.add(new ConnectionCreationToolEntry(\"";
  protected final String TEXT_56 = "\", \"";
  protected final String TEXT_57 = "\", creationFactory, img, img));" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate class CreationLinkFactory";
  protected final String TEXT_58 = " implements CreationFactory {" + NL + "\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tpublic Object getNewObject() {" + NL + "\t\t\t";
  protected final String TEXT_59 = " diagramLink = ";
  protected final String TEXT_60 = ".eINSTANCE.create";
  protected final String TEXT_61 = "();" + NL + "\t\t\tdiagramLink.setVisualID(";
  protected final String TEXT_62 = ".VISUAL_ID);" + NL + "\t\t\tdiagramLink.setDomainModelElement(";
  protected final String TEXT_63 = ");" + NL + "\t\t\tinitialize(diagramLink);" + NL + "\t\t\treturn diagramLink;" + NL + "\t\t}" + NL + "" + NL + "\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tpublic Object getObjectType() {" + NL + "\t\t\treturn ";
  protected final String TEXT_64 = ".class;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t" + NL + "\t\t/**" + NL + "\t     * @generated" + NL + "\t     */" + NL + "\t\tprivate void initialize(";
  protected final String TEXT_65 = " diagramLink) {" + NL + "\t\t\t// place initialization code for attributes specific to your Diagram RunTime model here" + NL + "\t\t}" + NL + "\t};";
  protected final String TEXT_66 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer createContainer(String title) {" + NL + "\t\treturn new PaletteDrawer(title);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getImage(Object o) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) myAdapterFactory.adapt(o, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {" + NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(o));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument; Palette palette = genDiagram.getPalette();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(palette.getPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(palette.getPackageName());
    stringBuffer.append(TEXT_3);
    importManager.addImport("org.eclipse.gmf.diagramrt.*");
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
    for(int toolGroupIndex = 0; toolGroupIndex < palette.getGroups().size(); toolGroupIndex++) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(toolGroupIndex);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    
	int toolGroupIndex = 0;
	int nodeToolIndex = 0;
	int linkToolIndex = 0;
	for(Iterator it = palette.getGroups().iterator(); it.hasNext(); toolGroupIndex++) {
		ToolGroup tg = (ToolGroup) it.next();

    stringBuffer.append(TEXT_12);
    stringBuffer.append(toolGroupIndex);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(tg.getTitleKey());
    stringBuffer.append(TEXT_14);
    	for (int i = tg.getNodeTools().size(); i > 0; i--, nodeToolIndex++) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(nodeToolIndex);
    stringBuffer.append(TEXT_16);
    	}
    stringBuffer.append(TEXT_17);
    	for (int i = tg.getLinkTools().size(); i > 0; i--, linkToolIndex++) {
    stringBuffer.append(TEXT_18);
    stringBuffer.append(linkToolIndex);
    stringBuffer.append(TEXT_19);
    	}
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(TEXT_23);
    
	// Move on and create methods called from createToolGroup 
	toolGroupIndex = 0;
	nodeToolIndex = 0;
	linkToolIndex = 0;
for(Iterator it = palette.getGroups().iterator(); it.hasNext(); toolGroupIndex++) {
	ToolGroup tg = (ToolGroup) it.next();
	for (Iterator it2 = tg.getNodeTools().iterator(); it2.hasNext(); nodeToolIndex++) {
		NodeEntry nodeEntry = (NodeEntry) it2.next();

    stringBuffer.append(TEXT_24);
    
GenNode genNode = nodeEntry.getGenNode(); 
GenClass genClass = genDiagram.findGenClass(genNode.getDomainMetaClass());
GenClass drtClass = genNode.getDiagramRunTimeClass();
final String domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create(" + importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + genClass.getName() + "())";

    stringBuffer.append(TEXT_25);
    stringBuffer.append(nodeToolIndex);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(nodeEntry.getSmallIconPath());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(nodeToolIndex);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(nodeEntry.getTitleKey());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(nodeEntry.getDescriptionKey());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(nodeToolIndex);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName(drtClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName(drtClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_35);
    stringBuffer.append(drtClass.getName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(importManager.getImportedName(genNode.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_38);
    if (genNode instanceof GenChildNode) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(((GenChildNode) genNode).getGroupID());
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    if (genNode instanceof GenChildNode) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.diagramrt.ChildNode"));
    stringBuffer.append(TEXT_43);
    } else {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.diagramrt.DiagramNode"));
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName(drtClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_47);
    	}
	for (Iterator it2 = tg.getLinkTools().iterator(); it2.hasNext(); linkToolIndex++) {
		LinkEntry linkEntry = (LinkEntry) it2.next();

    stringBuffer.append(TEXT_48);
    
GenLink genLink = linkEntry.getGenLink();
GenClass drtClass = genLink.getDiagramRunTimeClass();

    stringBuffer.append(TEXT_49);
    stringBuffer.append(linkToolIndex);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(linkEntry.getSmallIconPath());
    stringBuffer.append(TEXT_52);
    
final String domainElementInstanceCreationCode;
if (genLink instanceof GenLinkWithClass) {
	EClass domainMetaClass = ((GenLinkWithClass) genLink).getDomainMetaClass();
	GenClass genClass = genDiagram.findGenClass(domainMetaClass);
	domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create(" + importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + genClass.getName() + "())";
} else {
	// no dedicated metaclass for link, thus no creation code
	domainElementInstanceCreationCode = "null";
}

    stringBuffer.append(TEXT_53);
    stringBuffer.append(domainElementInstanceCreationCode );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(linkToolIndex);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(linkEntry.getTitleKey());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(linkEntry.getDescriptionKey());
    stringBuffer.append(TEXT_57);
    stringBuffer.append(linkToolIndex);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(importManager.getImportedName(drtClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName(drtClass.getGenPackage().getQualifiedFactoryInterfaceName()));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(drtClass.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName(genLink.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.diagramrt.DiagramLink"));
    stringBuffer.append(TEXT_64);
    stringBuffer.append(importManager.getImportedName(drtClass.getQualifiedInterfaceName()));
    stringBuffer.append(TEXT_65);
    	}
}
    stringBuffer.append(TEXT_66);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}

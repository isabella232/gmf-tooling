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

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final AdapterFactory domainAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_3 = "(AdapterFactory domainAdapterFactory) {" + NL + "\t\tthis.domainAdapterFactory = domainAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void contributeToPalette(PaletteRoot paletteRoot) {";
  protected final String TEXT_4 = NL + "        PaletteGroup controls = new PaletteGroup(\"Controls\");" + NL + "        paletteRoot.add(controls);" + NL + "" + NL + "        ToolEntry tool = new ";
  protected final String TEXT_5 = "();" + NL + "        controls.add(tool);" + NL + "        paletteRoot.setDefaultEntry(tool);" + NL + "" + NL + "        controls.add(new MarqueeToolEntry());";
  protected final String TEXT_6 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_7 = "());";
  protected final String TEXT_8 = NL + "\t}" + NL;
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_10 = "() {";
  protected final String TEXT_11 = NL + "\t\tPaletteContainer paletteContainer = new ";
  protected final String TEXT_12 = "(\"";
  protected final String TEXT_13 = "\");";
  protected final String TEXT_14 = NL + "\t\t";
  protected final String TEXT_15 = " smallImage = ";
  protected final String TEXT_16 = ".findImageDescriptor(\"";
  protected final String TEXT_17 = "\");";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = " smallImage = null;";
  protected final String TEXT_20 = NL + "\t\tPaletteContainer paletteContainer = new ";
  protected final String TEXT_21 = "(\"";
  protected final String TEXT_22 = "\", ";
  protected final String TEXT_23 = "\"";
  protected final String TEXT_24 = "\"";
  protected final String TEXT_25 = "null";
  protected final String TEXT_26 = ", smallImage);";
  protected final String TEXT_27 = NL + "\t\tPaletteContainer paletteContainer = new ";
  protected final String TEXT_28 = "(\"";
  protected final String TEXT_29 = "\");";
  protected final String TEXT_30 = NL + "\t\tpaletteContainer.setDescription(\"";
  protected final String TEXT_31 = "\");";
  protected final String TEXT_32 = NL + "\t\t";
  protected final String TEXT_33 = " ";
  protected final String TEXT_34 = " ";
  protected final String TEXT_35 = "paletteEntry = ";
  protected final String TEXT_36 = "();" + NL + "\t\tif (paletteEntry != null) {" + NL + "\t\t\tpaletteContainer.add(paletteEntry);" + NL + "\t\t}";
  protected final String TEXT_37 = NL + "\t\t";
  protected final String TEXT_38 = " ";
  protected final String TEXT_39 = " ";
  protected final String TEXT_40 = "paletteEntry = ";
  protected final String TEXT_41 = "();" + NL + "\t\tif (paletteEntry != null) {" + NL + "\t\t\tpaletteContainer.add(paletteEntry);" + NL + "\t\t}";
  protected final String TEXT_42 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_43 = "());";
  protected final String TEXT_44 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_45 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_46 = "() {";
  protected final String TEXT_47 = NL + "\t\treturn null;";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = " result = new ";
  protected final String TEXT_50 = "();";
  protected final String TEXT_51 = NL + "\t\tresult.setToolClass(";
  protected final String TEXT_52 = ".class);";
  protected final String TEXT_53 = NL;
  protected final String TEXT_54 = NL + "\t\tresult.setToolProperty(";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = ");";
  protected final String TEXT_57 = NL + "\t\treturn result;";
  protected final String TEXT_58 = NL + "\t}" + NL;
  protected final String TEXT_59 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_60 = "() {" + NL + "\t\t";
  protected final String TEXT_61 = NL + "\t\t";
  protected final String TEXT_62 = " smallImage = ";
  protected final String TEXT_63 = ".findImageDescriptor(\"";
  protected final String TEXT_64 = "\");" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\t";
  protected final String TEXT_66 = " smallImage = getImageDescriptor(";
  protected final String TEXT_67 = "); " + NL + "\t\t";
  protected final String TEXT_68 = NL + "\t\t";
  protected final String TEXT_69 = " smallImage = null;" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\t";
  protected final String TEXT_71 = NL + "\t\t";
  protected final String TEXT_72 = " largeImage = ";
  protected final String TEXT_73 = ".findImageDescriptor(\"";
  protected final String TEXT_74 = "\");" + NL + "\t\t";
  protected final String TEXT_75 = NL + "\t\t";
  protected final String TEXT_76 = " largeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t\tfinal int[] visualIds = new int[] {";
  protected final String TEXT_78 = NL + "\t\t\t";
  protected final String TEXT_79 = ".VISUAL_ID";
  protected final String TEXT_80 = ",";
  protected final String TEXT_81 = NL + "\t\t};";
  protected final String TEXT_82 = NL + "\t\tToolEntry result = new NodeToolEntry(\"";
  protected final String TEXT_83 = "\", \"";
  protected final String TEXT_84 = "\", smallImage, largeImage, visualIds);";
  protected final String TEXT_85 = NL + "\t\tToolEntry result = new LinkToolEntry(\"";
  protected final String TEXT_86 = "\", \"";
  protected final String TEXT_87 = "\", smallImage, largeImage, visualIds);";
  protected final String TEXT_88 = NL + "\t\tToolEntry result = new ToolEntry(\"";
  protected final String TEXT_89 = "\", \"";
  protected final String TEXT_90 = "\", smallImage, largeImage) {};";
  protected final String TEXT_91 = NL + "\t\tresult.setToolClass(";
  protected final String TEXT_92 = ".class);";
  protected final String TEXT_93 = NL;
  protected final String TEXT_94 = NL + "\t\tresult.setToolProperty(";
  protected final String TEXT_95 = ", ";
  protected final String TEXT_96 = ");";
  protected final String TEXT_97 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_98 = NL;
  protected final String TEXT_99 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class NodeToolEntry extends ";
  protected final String TEXT_100 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final int[] myVisualIDs;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate NodeToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, int[] visualIDs) {" + NL + "\t\t\tsuper(title, description, new ";
  protected final String TEXT_101 = "(";
  protected final String TEXT_102 = ".class), smallIcon, largeIcon);" + NL + "\t\t\tmyVisualIDs = visualIDs;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool result = new CreationTool() {" + NL + "\t\t\t\tprotected Request createTargetRequest() {" + NL + "\t\t\t\t\t";
  protected final String TEXT_103 = " request = new ";
  protected final String TEXT_104 = "(";
  protected final String TEXT_105 = ".MODEL_ID, myVisualIDs);" + NL + "\t\t\t\t\trequest.setFactory(getFactory());" + NL + "\t\t\t\t\treturn request;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tprotected void performCreation(int button) {" + NL + "\t\t\t\t\tsuper.performCreation(button);" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_106 = " createdEditPart = (";
  protected final String TEXT_107 = ")getCurrentViewer().getEditPartRegistry().get(getCreateRequest().getNewObject());" + NL + "\t\t\t\t\tif (createdEditPart != null) {" + NL + "\t\t\t\t\t\tgetCurrentViewer().getControl().getDisplay().asyncExec(new Runnable() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\tif (createdEditPart.isActive()) {" + NL + "\t\t\t\t\t\t\t\t\tcreatedEditPart.performRequest(new ";
  protected final String TEXT_108 = "(";
  protected final String TEXT_109 = ".REQ_DIRECT_EDIT));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tresult.setProperties(getToolProperties());" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_110 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class LinkToolEntry extends ConnectionCreationToolEntry {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final int[] myVisualIDs;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate LinkToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, int[] visualIDs) {" + NL + "\t\t\tsuper(title, description, new ";
  protected final String TEXT_111 = "(";
  protected final String TEXT_112 = ".class), smallIcon, largeIcon);" + NL + "\t\t\tmyVisualIDs = visualIDs;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool result = new ConnectionCreationTool() {" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tsetUnloadWhenFinished(true);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tprotected Request createTargetRequest() {" + NL + "\t\t\t\t\t";
  protected final String TEXT_113 = " request = new ";
  protected final String TEXT_114 = "(";
  protected final String TEXT_115 = ".MODEL_ID, myVisualIDs);" + NL + "\t\t\t\t\trequest.setFactory(getFactory());" + NL + "\t\t\t\t\treturn request;" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tresult.setProperties(getToolProperties());" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_116 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getImageDescriptor(Object o) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) domainAdapterFactory.adapt(o, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {" + NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(o));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_117 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0]; 
final Palette palette = genDiagram.getPalette();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);

importManager.addImport("org.eclipse.gef.Tool");
importManager.addImport("org.eclipse.gef.Request");
importManager.addImport("org.eclipse.gef.tools.CreationTool");
importManager.addImport("org.eclipse.gef.tools.ConnectionCreationTool");
importManager.addImport("org.eclipse.gef.palette.PaletteContainer");
importManager.addImport("org.eclipse.gef.palette.PaletteDrawer");
importManager.addImport("org.eclipse.gef.palette.PaletteGroup");
importManager.addImport("org.eclipse.gef.palette.PaletteRoot");
importManager.addImport("org.eclipse.gef.palette.ConnectionCreationToolEntry");
importManager.addImport("org.eclipse.gef.palette.MarqueeToolEntry");
importManager.addImport("org.eclipse.gef.palette.ToolEntry");
importManager.addImport("org.eclipse.jface.resource.ImageDescriptor");
importManager.addImport("org.eclipse.emf.edit.provider.IItemLabelProvider");
importManager.addImport("org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry");
importManager.addImport("org.eclipse.emf.common.notify.AdapterFactory");

importManager.registerInnerClass("LinkToolEntry");
importManager.registerInnerClass("NodeToolEntry");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_1);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_3);
    
if (!palette.definesStandardTools()) {

    stringBuffer.append(TEXT_4);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.SelectionToolEntry"));
    stringBuffer.append(TEXT_5);
    
}

    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_6);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_7);
    }
    stringBuffer.append(TEXT_8);
    
final LinkedList<ToolGroup> toolGroupsQueue = new LinkedList<ToolGroup>();
for(Object next : palette.getGroups()) {
	toolGroupsQueue.add((ToolGroup) next);
}
final LinkedList<AbstractToolEntry> toolsQueue = new LinkedList<AbstractToolEntry>();
while (!toolGroupsQueue.isEmpty()) {
	// TODO with additional counter and hashmap here it's easy to add "unique method name" check here
	ToolGroup toolGroup = (ToolGroup) toolGroupsQueue.removeFirst();

    stringBuffer.append(TEXT_9);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_10);
    if (toolGroup.isCollapse() && toolGroup.isToolsOnly()) { 
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteDrawer"));
    stringBuffer.append(TEXT_12);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_13);
    } else if (toolGroup.isStack()) {
    
	if (toolGroup.getSmallIconPath() != null) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(toolGroup.getSmallIconPath());
    stringBuffer.append(TEXT_17);
    
	} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_19);
    
	}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteStack"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_22);
    if (toolGroup.getDescription() != null) {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(toolGroup.getDescription());
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    }
    stringBuffer.append(TEXT_26);
    } else {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteGroup"));
    stringBuffer.append(TEXT_28);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_29);
    }
if (toolGroup.getDescription() != null) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(toolGroup.getDescription());
    stringBuffer.append(TEXT_31);
    }
    
boolean hasDeclaredPaletteEntry = false;
for(Iterator it = toolGroup.getEntries().iterator(); it.hasNext(); ) {
	ToolGroupItem groupItem = (ToolGroupItem) it.next();
	if (groupItem instanceof AbstractToolEntry) {
		toolsQueue.add((AbstractToolEntry) groupItem);

    stringBuffer.append(TEXT_32);
    if (!hasDeclaredPaletteEntry) { hasDeclaredPaletteEntry = true;
    stringBuffer.append(TEXT_33);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteEntry"));
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    stringBuffer.append(((AbstractToolEntry) groupItem).getCreateMethodName());
    stringBuffer.append(TEXT_36);
    	} else if (groupItem instanceof ToolGroup) {
		toolGroupsQueue.addLast((ToolGroup) groupItem);

    stringBuffer.append(TEXT_37);
    if (!hasDeclaredPaletteEntry) { hasDeclaredPaletteEntry = true;
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteEntry"));
    stringBuffer.append(TEXT_39);
    }
    stringBuffer.append(TEXT_40);
    stringBuffer.append(((ToolGroup) groupItem).getCreateMethodName());
    stringBuffer.append(TEXT_41);
    
	} else if (groupItem instanceof Separator) {
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_43);
    	} /*else - no more options possible, log warning? */
    } /*for*/
    stringBuffer.append(TEXT_44);
    
} /*while*/
boolean hasNodeEntries = false;
boolean hasLinkEntries = false;
for(AbstractToolEntry abstractToolEntry : toolsQueue) {
	if (abstractToolEntry instanceof StandardEntry) {
		StandardEntry toolEntry = (StandardEntry) abstractToolEntry;

    stringBuffer.append(TEXT_45);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_46);
    
		String toolEntryQualifiedName;
		if (toolEntry.getKind() == StandardEntryKind.SELECT_LITERAL) {
			toolEntryQualifiedName = "org.eclipse.gef.palette.PanningSelectionToolEntry";
		} else if (toolEntry.getKind() == StandardEntryKind.MARQUEE_LITERAL) {
			toolEntryQualifiedName = "org.eclipse.gef.palette.MarqueeToolEntry";
		} else {
			toolEntryQualifiedName = null;
		}
		if (toolEntryQualifiedName == null) {

    stringBuffer.append(TEXT_47);
    
		} else {

    stringBuffer.append(TEXT_48);
    stringBuffer.append(importManager.getImportedName(toolEntryQualifiedName));
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName(toolEntryQualifiedName));
    stringBuffer.append(TEXT_50);
    
// there's a problem with qualifieToolName - we should also respect different tools 
// in NodeToolEntry and LinkToolEntry (right now there's hardcoded name of the tool) 
if (toolEntry.getQualifiedToolName() != null && toolEntry.getQualifiedToolName().trim().length() > 0 ) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(importManager.getImportedName(toolEntry.getQualifiedToolName()));
    stringBuffer.append(TEXT_52);
    
} /*tool class presence*/
    stringBuffer.append(TEXT_53);
    if (!toolEntry.getProperties().isEmpty()) {
	for (Iterator it = toolEntry.getProperties().entrySet().iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry) it.next();

    stringBuffer.append(TEXT_54);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_56);
    
	} /*properties iterator*/
} /*properties presence check*/

    stringBuffer.append(TEXT_57);
    
		}

    stringBuffer.append(TEXT_58);
    
		continue;
	}
	ToolEntry toolEntry = (ToolEntry) abstractToolEntry;
	GenCommonBase firstGenElement = toolEntry.getElements().isEmpty() ? null : (GenCommonBase) toolEntry.getElements().get(0);
	String domainElementInstanceCreationCode = null;
	if (firstGenElement instanceof GenNode) {
		GenNode firstGenNode = (GenNode) firstGenElement;
		GenClass genClass = firstGenNode.getDomainMetaClass();
		if (!genClass.isMapEntry()) {
			domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";
		} else {
			domainElementInstanceCreationCode = importManager.getImportedName(genClass.getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create(" + 
				importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()) + ".eINSTANCE.get" + genClass.getClassifierAccessorName() + "())";
		}
	} else if (firstGenElement instanceof GenLink) {
		GenLink firstGenLink = (GenLink) firstGenElement;
		LinkModelFacet linkModelFacet = firstGenLink.getModelFacet();
		if (linkModelFacet instanceof TypeLinkModelFacet) {
			TypeLinkModelFacet typeLinkModelFacet = (TypeLinkModelFacet) linkModelFacet;
			GenClass genClass = typeLinkModelFacet.getMetaClass();
			domainElementInstanceCreationCode = importManager.getImportedName(genDiagram.getDomainDiagramElement().getGenPackage().getQualifiedFactoryInterfaceName()) + ".eINSTANCE.create" + genClass.getName() + "()";
		}
	}

    stringBuffer.append(TEXT_59);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_60);
    if (toolEntry.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_63);
    stringBuffer.append(toolEntry.getSmallIconPath());
    stringBuffer.append(TEXT_64);
    } else if (domainElementInstanceCreationCode != null) {
    stringBuffer.append(TEXT_65);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_66);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_67);
    } else {
    stringBuffer.append(TEXT_68);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_69);
    }
    stringBuffer.append(TEXT_70);
    if (toolEntry.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_72);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_73);
    stringBuffer.append(toolEntry.getLargeIconPath());
    stringBuffer.append(TEXT_74);
    } else {
    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_76);
    }
    
	if (!toolEntry.getElements().isEmpty()) {

    stringBuffer.append(TEXT_77);
    
		for (Iterator genElementsIterator = toolEntry.getElements().iterator(); genElementsIterator.hasNext();) {
			GenCommonBase next = (GenCommonBase) genElementsIterator.next();

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_79);
    if (genElementsIterator.hasNext()) {
    stringBuffer.append(TEXT_80);
    }
    
		}

    stringBuffer.append(TEXT_81);
    
	}
	if (firstGenElement instanceof GenNode) {
		hasNodeEntries = true;

    stringBuffer.append(TEXT_82);
    stringBuffer.append(toolEntry.getTitle());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(toolEntry.getDescription());
    stringBuffer.append(TEXT_84);
    
	} else if (firstGenElement instanceof GenLink) {
		hasLinkEntries = true;

    stringBuffer.append(TEXT_85);
    stringBuffer.append(toolEntry.getTitle());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(toolEntry.getDescription());
    stringBuffer.append(TEXT_87);
    
	} else {

    stringBuffer.append(TEXT_88);
    stringBuffer.append(toolEntry.getTitle());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(toolEntry.getDescription());
    stringBuffer.append(TEXT_90);
    
	}

    
// there's a problem with qualifieToolName - we should also respect different tools 
// in NodeToolEntry and LinkToolEntry (right now there's hardcoded name of the tool) 
if (toolEntry.getQualifiedToolName() != null && toolEntry.getQualifiedToolName().trim().length() > 0 ) {

    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName(toolEntry.getQualifiedToolName()));
    stringBuffer.append(TEXT_92);
    
} /*tool class presence*/
    stringBuffer.append(TEXT_93);
    if (!toolEntry.getProperties().isEmpty()) {
	for (Iterator it = toolEntry.getProperties().entrySet().iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry) it.next();

    stringBuffer.append(TEXT_94);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_95);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_96);
    
	} /*properties iterator*/
} /*properties presence check*/

    stringBuffer.append(TEXT_97);
    
}	/*for*/

    stringBuffer.append(TEXT_98);
    
if (hasNodeEntries) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.CombinedTemplateCreationEntry"));
    stringBuffer.append(TEXT_100);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory"));
    stringBuffer.append(TEXT_101);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_102);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_103);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_104);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_106);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_108);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_109);
    
}	/*if (hasNodeEntries)*/
if (hasLinkEntries) {

    stringBuffer.append(TEXT_110);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory"));
    stringBuffer.append(TEXT_111);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_112);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_113);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_114);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_115);
    
}	/*if (hasLinkEntries)*/

    stringBuffer.append(TEXT_116);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_117);
    return stringBuffer.toString();
  }
}

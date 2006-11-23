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
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.List;" + NL + "import org.eclipse.gef.Tool;" + NL + "import org.eclipse.gef.palette.PaletteContainer;" + NL + "import org.eclipse.gef.palette.PaletteRoot;" + NL + "import org.eclipse.gef.palette.ToolEntry;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void fillPalette(PaletteRoot paletteRoot) {";
  protected final String TEXT_7 = NL + "\t\tcleanStandardTools(paletteRoot);";
  protected final String TEXT_8 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_9 = "());";
  protected final String TEXT_10 = NL + "\t}" + NL;
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=159289" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void cleanStandardTools(PaletteRoot paletteRoot) {" + NL + "\t\tfor (java.util.Iterator it = paletteRoot.getChildren().iterator(); it.hasNext();) {" + NL + "\t\t\torg.eclipse.gef.palette.PaletteEntry entry = (org.eclipse.gef.palette.PaletteEntry) it.next();" + NL + "\t\t\tif (!\"standardGroup\".equals(entry.getId())) { //$NON-NLS-1$" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tfor (java.util.Iterator it2 = ((PaletteContainer) entry).getChildren().iterator(); it2.hasNext();) {" + NL + "\t\t\t\torg.eclipse.gef.palette.PaletteEntry entry2 = (org.eclipse.gef.palette.PaletteEntry) it2.next();" + NL + "\t\t\t\tif (\"zoomTool\".equals(entry2.getId())) { //$NON-NLS-1$" + NL + "\t\t\t\t\tit2.remove();" + NL + "\t\t\t\t} else if (\"noteStack\".equals(entry2.getId())) { //$NON-NLS-1$" + NL + "\t\t\t\t\tit2.remove();" + NL + "\t\t\t\t} else if (\"selectionTool\".equals(entry2.getId())) { //$NON-NLS-1$" + NL + "\t\t\t\t\tit2.remove();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tif (paletteRoot.getDefaultEntry() == entry2) {" + NL + "\t\t\t\t\tpaletteRoot.setDefaultEntry(null);" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "     * Creates \"";
  protected final String TEXT_13 = "\" palette tool group" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_14 = "() {";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = " paletteContainer = new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ".getString(\"";
  protected final String TEXT_19 = ".title\")); //$NON-NLS-1$";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = " paletteContainer = new ";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ".getString(\"";
  protected final String TEXT_24 = ".title\"), null, null); //$NON-NLS-1$";
  protected final String TEXT_25 = NL + "\t\t";
  protected final String TEXT_26 = " paletteContainer = new ";
  protected final String TEXT_27 = "(";
  protected final String TEXT_28 = ".getString(\"";
  protected final String TEXT_29 = ".title\")); //$NON-NLS-1$";
  protected final String TEXT_30 = NL + "\t\tpaletteContainer.setDescription(";
  protected final String TEXT_31 = ".getString(\"";
  protected final String TEXT_32 = ".desc\")); //$NON-NLS-1$";
  protected final String TEXT_33 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_34 = "());";
  protected final String TEXT_35 = NL + "\t\tpaletteContainer.setActiveEntry((ToolEntry) paletteContainer.getChildren().get(paletteContainer.getChildren().size() - 1));";
  protected final String TEXT_36 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_37 = "());";
  protected final String TEXT_38 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_39 = "());";
  protected final String TEXT_40 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_41 = NL;
  protected final String TEXT_42 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_43 = "() {";
  protected final String TEXT_44 = NL + "\t\torg.eclipse.gef.palette.PanningSelectionToolEntry result = new org.eclipse.gef.palette.PanningSelectionToolEntry();";
  protected final String TEXT_45 = NL + "\t\torg.eclipse.gef.palette.MarqueeToolEntry result = new org.eclipse.gef.palette.MarqueeToolEntry();";
  protected final String TEXT_46 = NL;
  protected final String TEXT_47 = NL + "\t\tresult.setToolClass(";
  protected final String TEXT_48 = ".class);";
  protected final String TEXT_49 = NL;
  protected final String TEXT_50 = NL + "\t\tresult.setToolProperty(";
  protected final String TEXT_51 = ", ";
  protected final String TEXT_52 = ");";
  protected final String TEXT_53 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_54 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_55 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;";
  protected final String TEXT_56 = NL + "\t\t";
  protected final String TEXT_57 = NL + "\t\tsmallImage = ";
  protected final String TEXT_58 = ".findImageDescriptor(\"";
  protected final String TEXT_59 = "\"); //$NON-NLS-1$" + NL + "\t\t";
  protected final String TEXT_60 = NL + "\t\tsmallImage = ";
  protected final String TEXT_61 = ".getImageDescriptor(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = "); " + NL + "\t\t";
  protected final String TEXT_64 = NL + "\t\tsmallImage = null;" + NL + "\t\t";
  protected final String TEXT_65 = NL + "\t\t";
  protected final String TEXT_66 = NL + "\t\tlargeImage = ";
  protected final String TEXT_67 = ".findImageDescriptor(\"";
  protected final String TEXT_68 = "\"); //$NON-NLS-1$" + NL + "\t\t";
  protected final String TEXT_69 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_70 = NL + "\t\tToolEntry result = new ToolEntry(";
  protected final String TEXT_71 = ".getString(\"";
  protected final String TEXT_72 = ".title\"), ";
  protected final String TEXT_73 = ".getString(\"";
  protected final String TEXT_74 = ".desc\"), smallImage, largeImage) {}; //$NON-NLS-1$ $NON-NLS-2$";
  protected final String TEXT_75 = NL + "\t\tfinal ";
  protected final String TEXT_76 = " elementTypes = new ";
  protected final String TEXT_77 = "();";
  protected final String TEXT_78 = NL + "\t\telementTypes.add(";
  protected final String TEXT_79 = ".";
  protected final String TEXT_80 = ");";
  protected final String TEXT_81 = "\t\t" + NL + "\t\tToolEntry result = new NodeToolEntry(";
  protected final String TEXT_82 = ".getString(\"";
  protected final String TEXT_83 = ".title\"), ";
  protected final String TEXT_84 = ".getString(\"";
  protected final String TEXT_85 = ".desc\"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$";
  protected final String TEXT_86 = NL + "\t\tfinal ";
  protected final String TEXT_87 = " relationshipTypes = new ";
  protected final String TEXT_88 = "();";
  protected final String TEXT_89 = NL + "\t\trelationshipTypes.add(";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = ");";
  protected final String TEXT_92 = "\t\t" + NL + "\t\tToolEntry result = new LinkToolEntry(";
  protected final String TEXT_93 = ".getString(\"";
  protected final String TEXT_94 = ".title\"), ";
  protected final String TEXT_95 = ".getString(\"";
  protected final String TEXT_96 = ".desc\"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$";
  protected final String TEXT_97 = NL;
  protected final String TEXT_98 = NL + "\t\tresult.setToolClass(";
  protected final String TEXT_99 = ".class);";
  protected final String TEXT_100 = NL;
  protected final String TEXT_101 = NL + "\t\tresult.setToolProperty(";
  protected final String TEXT_102 = ", ";
  protected final String TEXT_103 = ");";
  protected final String TEXT_104 = NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_105 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class NodeToolEntry extends ToolEntry {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final List elementTypes;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate NodeToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List elementTypes) {" + NL + "\t\t\tsuper(title, description, smallIcon, largeIcon);" + NL + "\t\t\tthis.elementTypes = elementTypes;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool tool = new ";
  protected final String TEXT_106 = "(elementTypes);" + NL + "\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\treturn tool;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_107 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class LinkToolEntry extends ToolEntry {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final List relationshipTypes;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate LinkToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List relationshipTypes) {" + NL + "\t\t\tsuper(title, description, smallIcon, largeIcon);" + NL + "\t\t\tthis.relationshipTypes = relationshipTypes;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool tool = new ";
  protected final String TEXT_108 = "(relationshipTypes);" + NL + "\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\treturn tool;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_109 = NL + "}";
  protected final String TEXT_110 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0]; 
final Palette palette = genDiagram.getPalette();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.registerInnerClass("LinkToolEntry");
importManager.registerInnerClass("NodeToolEntry");
importManager.markImportLocation(stringBuffer);
boolean needNodeToolEntry = false;
boolean needLinkToolEntry = false;
final String activatorFQN = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(palette.getFactoryClassName());
    stringBuffer.append(TEXT_6);
    if (palette.definesStandardTools()) {
    stringBuffer.append(TEXT_7);
    }
for (int i = 0; i < palette.getGroups().size(); i++) {
	ToolGroup toolGroup = (ToolGroup) palette.getGroups().get(i);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_9);
    }
    stringBuffer.append(TEXT_10);
    if (palette.definesStandardTools()) {
    stringBuffer.append(TEXT_11);
    }
final LinkedList<ToolGroup> toolGroupsQueue = new LinkedList<ToolGroup>();
toolGroupsQueue.addAll((List<ToolGroup>) palette.getGroups());
final LinkedList<AbstractToolEntry> toolsQueue = new LinkedList<AbstractToolEntry>();
while (!toolGroupsQueue.isEmpty()) {
	// TODO with additional counter and hashmap here it's easy to add "unique method name" check here
	ToolGroup toolGroup = toolGroupsQueue.removeFirst();

    stringBuffer.append(TEXT_12);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_14);
    if (toolGroup.isCollapse() && toolGroup.isToolsOnly()) {
		String containerClassName = importManager.getImportedName("org.eclipse.gef.palette.PaletteDrawer");
    stringBuffer.append(TEXT_15);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_19);
    } else if (toolGroup.isStack()) {
		String containerClassName = importManager.getImportedName("org.eclipse.gef.palette.PaletteStack");
    stringBuffer.append(TEXT_20);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_24);
    } else {
		String containerClassName = importManager.getImportedName("org.eclipse.gef.palette.PaletteGroup");
    stringBuffer.append(TEXT_25);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_29);
    }
if (toolGroup.getDescription() != null) {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_32);
    }
    for (Iterator itGroupItems = toolGroup.getEntries().iterator(); itGroupItems.hasNext(); ) {
	ToolGroupItem groupItem = (ToolGroupItem) itGroupItems.next();
	if (groupItem instanceof AbstractToolEntry) {
		AbstractToolEntry toolEntry = (AbstractToolEntry) groupItem;
		toolsQueue.add(toolEntry);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_34);
    	if (toolEntry.isDefault() && toolGroup.isStack()) {
    stringBuffer.append(TEXT_35);
    	}
    	} else if (groupItem instanceof ToolGroup) {
		// though, the only reasonable nested group is group with isStack = false
		toolGroupsQueue.addLast((ToolGroup) groupItem);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(((ToolGroup) groupItem).getCreateMethodName());
    stringBuffer.append(TEXT_37);
    	} else if (groupItem instanceof Separator) {
    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_39);
    	} /*else - no more options possible, log warning? */
    } /*for*/
    stringBuffer.append(TEXT_40);
    
}
final String importedElementTypesClassName = importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName());
final String importedPluginClassName = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
while (!toolsQueue.isEmpty()) {
	if (toolsQueue.element() instanceof StandardEntry) {
		StandardEntry toolEntry = (StandardEntry) toolsQueue.removeFirst();
    stringBuffer.append(TEXT_41);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_43);
    if (toolEntry.getKind() == StandardEntryKind.SELECT_LITERAL) {
    stringBuffer.append(TEXT_44);
    } else if (toolEntry.getKind() == StandardEntryKind.MARQUEE_LITERAL) {
    stringBuffer.append(TEXT_45);
    }
    stringBuffer.append(TEXT_46);
    
// there's a problem with qualifieToolName - we should also respect different tools 
// in NodeToolEntry and LinkToolEntry (right now there's hardcoded name of the tool) 
if (toolEntry.getQualifiedToolName() != null && toolEntry.getQualifiedToolName().trim().length() > 0 ) {
    stringBuffer.append(TEXT_47);
    stringBuffer.append(importManager.getImportedName(toolEntry.getQualifiedToolName()));
    stringBuffer.append(TEXT_48);
    } /*tool class presence*/
    stringBuffer.append(TEXT_49);
    if (!toolEntry.getProperties().isEmpty()) {
	for (Iterator it = toolEntry.getProperties().entrySet().iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry) it.next();
    stringBuffer.append(TEXT_50);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_52);
    	} /*properties iterator*/
} /*properties presence check*/ 
    stringBuffer.append(TEXT_53);
    } else {
	ToolEntry toolEntry = (ToolEntry) toolsQueue.removeFirst();
	GenCommonBase firstGenElement = toolEntry.getElements().isEmpty() ? null : (GenCommonBase) toolEntry.getElements().get(0);

    stringBuffer.append(TEXT_54);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_55);
     /* FIXME do not pass images into cons, use setX instead to reuse same image init code in std-tool*/
    stringBuffer.append(TEXT_56);
    if (toolEntry.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_57);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(toolEntry.getSmallIconPath());
    stringBuffer.append(TEXT_59);
    } else if (firstGenElement != null) {
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(firstGenElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_63);
    } else {
    stringBuffer.append(TEXT_64);
    }
    stringBuffer.append(TEXT_65);
    if (toolEntry.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_66);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(toolEntry.getLargeIconPath());
    stringBuffer.append(TEXT_68);
    } else {
    stringBuffer.append(TEXT_69);
    }
    
if (toolEntry.getElements().isEmpty()) {
    stringBuffer.append(TEXT_70);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_74);
    }
	else if (firstGenElement instanceof GenNode) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_77);
    		for (Iterator genNodesIterator = toolEntry.getGenNodes().iterator(); genNodesIterator.hasNext();) {
			GenNode nextNode = (GenNode) genNodesIterator.next();

    stringBuffer.append(TEXT_78);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_80);
    		}
		needNodeToolEntry = true;
    stringBuffer.append(TEXT_81);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_83);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_85);
    }
	else if (firstGenElement instanceof GenLink) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_88);
    		for (Iterator genLinksIterator = toolEntry.getGenLinks().iterator(); genLinksIterator.hasNext();) {
			GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_89);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_91);
    		}
		needLinkToolEntry = true;
    stringBuffer.append(TEXT_92);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_96);
    } /*else - has no more ideas what's there*/ 
    stringBuffer.append(TEXT_97);
    
// there's a problem with qualifieToolName - we should also respect different tools 
// in NodeToolEntry and LinkToolEntry (right now there's hardcoded name of the tool) 
if (toolEntry.getQualifiedToolName() != null && toolEntry.getQualifiedToolName().trim().length() > 0 ) {
    stringBuffer.append(TEXT_98);
    stringBuffer.append(importManager.getImportedName(toolEntry.getQualifiedToolName()));
    stringBuffer.append(TEXT_99);
    } /*tool class presence*/
    stringBuffer.append(TEXT_100);
    if (!toolEntry.getProperties().isEmpty()) {
	for (Iterator it = toolEntry.getProperties().entrySet().iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry) it.next();
    stringBuffer.append(TEXT_101);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_102);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_103);
    	} /*properties iterator*/
} /*properties presence check*/ 
    stringBuffer.append(TEXT_104);
    } /*else instanceof*/
} /*while toolsQueue*/ 
    if (needNodeToolEntry) {
    stringBuffer.append(TEXT_105);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool"));
    stringBuffer.append(TEXT_106);
    }
if (needLinkToolEntry) {
    stringBuffer.append(TEXT_107);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool"));
    stringBuffer.append(TEXT_108);
    }
    stringBuffer.append(TEXT_109);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_110);
    return stringBuffer.toString();
  }
}

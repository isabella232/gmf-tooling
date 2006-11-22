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
  protected final String TEXT_7 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_8 = "());";
  protected final String TEXT_9 = NL + "\t}" + NL;
  protected final String TEXT_10 = NL + NL + "\t/**" + NL + "     * Creates \"";
  protected final String TEXT_11 = "\" palette tool group" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_12 = "() {";
  protected final String TEXT_13 = NL + "\t\t";
  protected final String TEXT_14 = " paletteContainer = new ";
  protected final String TEXT_15 = "(";
  protected final String TEXT_16 = ".getString(\"";
  protected final String TEXT_17 = ".title\")); //$NON-NLS-1$";
  protected final String TEXT_18 = NL + "\t\t";
  protected final String TEXT_19 = " paletteContainer = new ";
  protected final String TEXT_20 = "(";
  protected final String TEXT_21 = ".getString(\"";
  protected final String TEXT_22 = ".title\"), null, null); //$NON-NLS-1$";
  protected final String TEXT_23 = NL + "\t\t";
  protected final String TEXT_24 = " paletteContainer = new ";
  protected final String TEXT_25 = "(";
  protected final String TEXT_26 = ".getString(\"";
  protected final String TEXT_27 = ".title\")); //$NON-NLS-1$";
  protected final String TEXT_28 = NL + "\t\tpaletteContainer.setDescription(";
  protected final String TEXT_29 = ".getString(\"";
  protected final String TEXT_30 = ".desc\")); //$NON-NLS-1$";
  protected final String TEXT_31 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_32 = "());";
  protected final String TEXT_33 = NL + "\t\tpaletteContainer.setActiveEntry((ToolEntry) paletteContainer.getChildren().get(paletteContainer.getChildren().size() - 1));";
  protected final String TEXT_34 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_35 = "());";
  protected final String TEXT_36 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_37 = "());";
  protected final String TEXT_38 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_39 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_40 = "() {" + NL + "\t\tImageDescriptor smallImage;" + NL + "\t\tImageDescriptor largeImage;" + NL + "\t\t";
  protected final String TEXT_41 = NL + "\t\tsmallImage = ";
  protected final String TEXT_42 = ".findImageDescriptor(\"";
  protected final String TEXT_43 = "\"); //$NON-NLS-1$" + NL + "\t\t";
  protected final String TEXT_44 = NL + "\t\tsmallImage = ";
  protected final String TEXT_45 = ".getImageDescriptor(";
  protected final String TEXT_46 = ".";
  protected final String TEXT_47 = "); " + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\tsmallImage = null;" + NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = NL + "\t\tlargeImage = ";
  protected final String TEXT_51 = ".findImageDescriptor(\"";
  protected final String TEXT_52 = "\"); //$NON-NLS-1$" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\tlargeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_54 = NL + "\t\tToolEntry result = new ToolEntry(";
  protected final String TEXT_55 = ".getString(\"";
  protected final String TEXT_56 = ".title\"), ";
  protected final String TEXT_57 = ".getString(\"";
  protected final String TEXT_58 = ".desc\"), smallImage, largeImage) {}; //$NON-NLS-1$ $NON-NLS-2$";
  protected final String TEXT_59 = NL + "\t\tfinal ";
  protected final String TEXT_60 = " elementTypes = new ";
  protected final String TEXT_61 = "();";
  protected final String TEXT_62 = NL + "\t\telementTypes.add(";
  protected final String TEXT_63 = ".";
  protected final String TEXT_64 = ");";
  protected final String TEXT_65 = "\t\t" + NL + "\t\tToolEntry result = new NodeToolEntry(";
  protected final String TEXT_66 = ".getString(\"";
  protected final String TEXT_67 = ".title\"), ";
  protected final String TEXT_68 = ".getString(\"";
  protected final String TEXT_69 = ".desc\"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$";
  protected final String TEXT_70 = NL + "\t\tfinal ";
  protected final String TEXT_71 = " relationshipTypes = new ";
  protected final String TEXT_72 = "();";
  protected final String TEXT_73 = NL + "\t\trelationshipTypes.add(";
  protected final String TEXT_74 = ".";
  protected final String TEXT_75 = ");";
  protected final String TEXT_76 = "\t\t" + NL + "\t\tToolEntry result = new LinkToolEntry(";
  protected final String TEXT_77 = ".getString(\"";
  protected final String TEXT_78 = ".title\"), ";
  protected final String TEXT_79 = ".getString(\"";
  protected final String TEXT_80 = ".desc\"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$";
  protected final String TEXT_81 = NL;
  protected final String TEXT_82 = NL + "\t\tresult.setToolClass(";
  protected final String TEXT_83 = ".class);";
  protected final String TEXT_84 = NL;
  protected final String TEXT_85 = NL + "\t\tresult.setToolProperty(";
  protected final String TEXT_86 = ", ";
  protected final String TEXT_87 = ");";
  protected final String TEXT_88 = NL + "\t\treturn result;" + NL + "\t}" + NL;
  protected final String TEXT_89 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class NodeToolEntry extends ToolEntry {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final List elementTypes;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate NodeToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List elementTypes) {" + NL + "\t\t\tsuper(title, description, smallIcon, largeIcon);" + NL + "\t\t\tthis.elementTypes = elementTypes;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool tool = new ";
  protected final String TEXT_90 = "(elementTypes);" + NL + "\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\treturn tool;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_91 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class LinkToolEntry extends ToolEntry {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final List relationshipTypes;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate LinkToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List relationshipTypes) {" + NL + "\t\t\tsuper(title, description, smallIcon, largeIcon);" + NL + "\t\t\tthis.relationshipTypes = relationshipTypes;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool tool = new ";
  protected final String TEXT_92 = "(relationshipTypes);" + NL + "\t\t\ttool.setProperties(getToolProperties());" + NL + "\t\t\treturn tool;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_93 = NL + "}";
  protected final String TEXT_94 = NL;

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
    
for (int i = 0; i < palette.getGroups().size(); i++) {
	ToolGroup toolGroup = (ToolGroup) palette.getGroups().get(i);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    
final LinkedList<ToolGroup> toolGroupsQueue = new LinkedList<ToolGroup>();
toolGroupsQueue.addAll((List<ToolGroup>) palette.getGroups());
final LinkedList<ToolEntry> toolsQueue = new LinkedList<ToolEntry>();
while (!toolGroupsQueue.isEmpty()) {
	// TODO with additional counter and hashmap here it's easy to add "unique method name" check here
	ToolGroup toolGroup = toolGroupsQueue.removeFirst();

    stringBuffer.append(TEXT_10);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_12);
    if (toolGroup.isCollapse() && toolGroup.isToolsOnly()) {
		String containerClassName = importManager.getImportedName("org.eclipse.gef.palette.PaletteDrawer");
    stringBuffer.append(TEXT_13);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_17);
    } else if (toolGroup.isStack()) {
		String containerClassName = importManager.getImportedName("org.eclipse.gef.palette.PaletteStack");
    stringBuffer.append(TEXT_18);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_22);
    } else {
		String containerClassName = importManager.getImportedName("org.eclipse.gef.palette.PaletteGroup");
    stringBuffer.append(TEXT_23);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(containerClassName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_27);
    }
if (toolGroup.getDescription() != null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(toolGroup.getIntKey());
    stringBuffer.append(TEXT_30);
    }
    for (Iterator itGroupItems = toolGroup.getEntries().iterator(); itGroupItems.hasNext(); ) {
	ToolGroupItem groupItem = (ToolGroupItem) itGroupItems.next();
	if (groupItem instanceof ToolEntry) {
		ToolEntry toolEntry = (ToolEntry) groupItem;
		toolsQueue.add(toolEntry);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_32);
    	if (toolEntry.isDefault() && toolGroup.isStack()) {
    stringBuffer.append(TEXT_33);
    	}
    	} else if (groupItem instanceof ToolGroup) {
		// though, the only reasonable nested group is group with isStack = false
		toolGroupsQueue.addLast((ToolGroup) groupItem);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(((ToolGroup) groupItem).getCreateMethodName());
    stringBuffer.append(TEXT_35);
    	} else if (groupItem instanceof Separator) {
    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_37);
    	} /*else - no more options possible, log warning? */
    } /*for*/
    stringBuffer.append(TEXT_38);
    
}
final String importedElementTypesClassName = importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName());
final String importedPluginClassName = importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName());
while (!toolsQueue.isEmpty()) {
	ToolEntry toolEntry = toolsQueue.removeFirst();
	GenCommonBase firstGenElement = toolEntry.getElements().isEmpty() ? null : (GenCommonBase) toolEntry.getElements().get(0);

    stringBuffer.append(TEXT_39);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_40);
    if (toolEntry.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(toolEntry.getSmallIconPath());
    stringBuffer.append(TEXT_43);
    } else if (firstGenElement != null) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(firstGenElement.getUniqueIdentifier());
    stringBuffer.append(TEXT_47);
    } else {
    stringBuffer.append(TEXT_48);
    }
    stringBuffer.append(TEXT_49);
    if (toolEntry.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importedPluginClassName);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(toolEntry.getLargeIconPath());
    stringBuffer.append(TEXT_52);
    } else {
    stringBuffer.append(TEXT_53);
    }
    
if (toolEntry.getElements().isEmpty()) {
    stringBuffer.append(TEXT_54);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_58);
    }
	else if (firstGenElement instanceof GenNode) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_60);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_61);
    		for (Iterator genNodesIterator = toolEntry.getGenNodes().iterator(); genNodesIterator.hasNext();) {
			GenNode nextNode = (GenNode) genNodesIterator.next();

    stringBuffer.append(TEXT_62);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(nextNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_64);
    		}
		needNodeToolEntry = true;
    stringBuffer.append(TEXT_65);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_69);
    }
	else if (firstGenElement instanceof GenLink) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_71);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_72);
    		for (Iterator genLinksIterator = toolEntry.getGenLinks().iterator(); genLinksIterator.hasNext();) {
			GenLink nextLink = (GenLink) genLinksIterator.next();

    stringBuffer.append(TEXT_73);
    stringBuffer.append(importedElementTypesClassName);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_75);
    		}
		needLinkToolEntry = true;
    stringBuffer.append(TEXT_76);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(activatorFQN);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(toolEntry.getIntKey());
    stringBuffer.append(TEXT_80);
    } /*else - has no more ideas what's there*/ 
    stringBuffer.append(TEXT_81);
    
// there's a problem with qualifieToolName - we should also respect different tools 
// in NodeToolEntry and LinkToolEntry (right now there's hardcoded name of the tool) 
if (toolEntry.getQualifiedToolName() != null && toolEntry.getQualifiedToolName().trim().length() > 0 ) {
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName(toolEntry.getQualifiedToolName()));
    stringBuffer.append(TEXT_83);
    } /*tool class presence*/
    stringBuffer.append(TEXT_84);
    if (!toolEntry.getProperties().isEmpty()) {
	for (Iterator it = toolEntry.getProperties().entrySet().iterator(); it.hasNext();) {
		Map.Entry entry = (Map.Entry) it.next();
    stringBuffer.append(TEXT_85);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_87);
    	} /*properties iterator*/
} /*properties presence check*/ 
    stringBuffer.append(TEXT_88);
    } /*while toolsQueue*/ 
    if (needNodeToolEntry) {
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool"));
    stringBuffer.append(TEXT_90);
    }
if (needLinkToolEntry) {
    stringBuffer.append(TEXT_91);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool"));
    stringBuffer.append(TEXT_92);
    }
    stringBuffer.append(TEXT_93);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_94);
    return stringBuffer.toString();
  }
}

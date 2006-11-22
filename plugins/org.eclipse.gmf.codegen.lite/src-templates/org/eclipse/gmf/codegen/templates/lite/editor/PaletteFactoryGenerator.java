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

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " {" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate final AdapterFactory domainAdapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_3 = "(AdapterFactory domainAdapterFactory) {" + NL + "\t\tthis.domainAdapterFactory = domainAdapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void contributeToPalette(PaletteRoot paletteRoot) {" + NL + "        PaletteGroup controls = new PaletteGroup(\"Controls\");" + NL + "        paletteRoot.add(controls);" + NL + "" + NL + "        ToolEntry tool = new SelectionToolEntry();" + NL + "        controls.add(tool);" + NL + "        paletteRoot.setDefaultEntry(tool);" + NL + "" + NL + "        controls.add(new MarqueeToolEntry());";
  protected final String TEXT_4 = NL + "\t\tpaletteRoot.add(";
  protected final String TEXT_5 = "());";
  protected final String TEXT_6 = NL + "\t}" + NL;
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate PaletteContainer ";
  protected final String TEXT_8 = "() {";
  protected final String TEXT_9 = NL + "\t\tPaletteContainer paletteContainer = new ";
  protected final String TEXT_10 = "(\"";
  protected final String TEXT_11 = "\");";
  protected final String TEXT_12 = NL + "\t\t";
  protected final String TEXT_13 = " smallImage = ";
  protected final String TEXT_14 = ".findImageDescriptor(\"";
  protected final String TEXT_15 = "\");";
  protected final String TEXT_16 = NL + "\t\t";
  protected final String TEXT_17 = " smallImage = null;";
  protected final String TEXT_18 = NL + "\t\tPaletteContainer paletteContainer = new ";
  protected final String TEXT_19 = "(\"";
  protected final String TEXT_20 = "\", ";
  protected final String TEXT_21 = "\"";
  protected final String TEXT_22 = "\"";
  protected final String TEXT_23 = "null";
  protected final String TEXT_24 = ", smallImage);";
  protected final String TEXT_25 = NL + "\t\tPaletteContainer paletteContainer = new ";
  protected final String TEXT_26 = "(\"";
  protected final String TEXT_27 = "\");";
  protected final String TEXT_28 = NL + "\t\tpaletteContainer.setDescription(\"";
  protected final String TEXT_29 = "\");";
  protected final String TEXT_30 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_31 = "());";
  protected final String TEXT_32 = NL + "\t\tpaletteContainer.add(";
  protected final String TEXT_33 = "());";
  protected final String TEXT_34 = NL + "\t\tpaletteContainer.add(new ";
  protected final String TEXT_35 = "());";
  protected final String TEXT_36 = NL + "\t\treturn paletteContainer;" + NL + "\t}";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ToolEntry ";
  protected final String TEXT_38 = "() {" + NL + "\t\t";
  protected final String TEXT_39 = NL + "\t\t";
  protected final String TEXT_40 = " smallImage = ";
  protected final String TEXT_41 = ".findImageDescriptor(\"";
  protected final String TEXT_42 = "\");" + NL + "\t\t";
  protected final String TEXT_43 = NL + "\t\t";
  protected final String TEXT_44 = " smallImage = getImageDescriptor(";
  protected final String TEXT_45 = "); " + NL + "\t\t";
  protected final String TEXT_46 = NL + "\t\t";
  protected final String TEXT_47 = " smallImage = null;" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t";
  protected final String TEXT_49 = NL + "\t\t";
  protected final String TEXT_50 = " largeImage = ";
  protected final String TEXT_51 = ".findImageDescriptor(\"";
  protected final String TEXT_52 = "\");" + NL + "\t\t";
  protected final String TEXT_53 = NL + "\t\t";
  protected final String TEXT_54 = " largeImage = smallImage;" + NL + "\t\t";
  protected final String TEXT_55 = NL + "\t\tfinal int[] visualIds = new int[] {";
  protected final String TEXT_56 = NL + "\t\t\t";
  protected final String TEXT_57 = ".VISUAL_ID";
  protected final String TEXT_58 = ",";
  protected final String TEXT_59 = NL + "\t\t};";
  protected final String TEXT_60 = NL + "\t\tToolEntry result = new NodeToolEntry(\"";
  protected final String TEXT_61 = "\", \"";
  protected final String TEXT_62 = "\", smallImage, largeImage, visualIds);";
  protected final String TEXT_63 = NL + "\t\tToolEntry result = new LinkToolEntry(\"";
  protected final String TEXT_64 = "\", \"";
  protected final String TEXT_65 = "\", smallImage, largeImage, visualIds);";
  protected final String TEXT_66 = NL + "\t\tToolEntry result = new ToolEntry(\"";
  protected final String TEXT_67 = "\", \"";
  protected final String TEXT_68 = "\", smallImage, largeImage) {};";
  protected final String TEXT_69 = NL + "\t\tresult.setToolClass(";
  protected final String TEXT_70 = ".class);";
  protected final String TEXT_71 = NL + "\t\tresult.setToolProperty(";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ");";
  protected final String TEXT_74 = NL + "\t\treturn result;" + NL + "\t}";
  protected final String TEXT_75 = NL;
  protected final String TEXT_76 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class NodeToolEntry extends ";
  protected final String TEXT_77 = " {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final int[] myVisualIDs;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate NodeToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, int[] visualIDs) {" + NL + "\t\t\tsuper(title, description, new ";
  protected final String TEXT_78 = "(";
  protected final String TEXT_79 = ".class), smallIcon, largeIcon);" + NL + "\t\t\tmyVisualIDs = visualIDs;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool result = new CreationTool() {" + NL + "\t\t\t\tprotected Request createTargetRequest() {" + NL + "\t\t\t\t\t";
  protected final String TEXT_80 = " request = new ";
  protected final String TEXT_81 = "(myVisualIDs);" + NL + "\t\t\t\t\trequest.setFactory(getFactory());" + NL + "\t\t\t\t\treturn request;" + NL + "\t\t\t\t}" + NL + "\t\t\t\tprotected void performCreation(int button) {" + NL + "\t\t\t\t\tsuper.performCreation(button);" + NL + "\t\t\t\t\tfinal ";
  protected final String TEXT_82 = " createdEditPart = (";
  protected final String TEXT_83 = ")getCurrentViewer().getEditPartRegistry().get(getCreateRequest().getNewObject());" + NL + "\t\t\t\t\tif (createdEditPart != null) {" + NL + "\t\t\t\t\t\tgetCurrentViewer().getControl().getDisplay().asyncExec(new Runnable() {" + NL + "\t\t\t\t\t\t\tpublic void run() {" + NL + "\t\t\t\t\t\t\t\tif (createdEditPart.isActive()) {" + NL + "\t\t\t\t\t\t\t\t\tcreatedEditPart.performRequest(new ";
  protected final String TEXT_84 = "(";
  protected final String TEXT_85 = ".REQ_DIRECT_EDIT));" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t});" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tresult.setProperties(getToolProperties());" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_86 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static class LinkToolEntry extends ConnectionCreationToolEntry {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate final int[] myVisualIDs;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate LinkToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, int[] visualIDs) {" + NL + "\t\t\tsuper(title, description, new ";
  protected final String TEXT_87 = "(";
  protected final String TEXT_88 = ".class), smallIcon, largeIcon);" + NL + "\t\t\tmyVisualIDs = visualIDs;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic Tool createTool() {" + NL + "\t\t\tTool result = new ConnectionCreationTool() {" + NL + "\t\t\t\t{" + NL + "\t\t\t\t\tsetUnloadWhenFinished(true);" + NL + "\t\t\t\t}" + NL + "\t\t\t\tprotected Request createTargetRequest() {" + NL + "\t\t\t\t\t";
  protected final String TEXT_89 = " request = new ";
  protected final String TEXT_90 = "(myVisualIDs);" + NL + "\t\t\t\t\trequest.setFactory(getFactory());" + NL + "\t\t\t\t\treturn request;" + NL + "\t\t\t\t}" + NL + "\t\t\t};" + NL + "\t\t\tresult.setProperties(getToolProperties());" + NL + "\t\t\treturn result;" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_91 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ImageDescriptor getImageDescriptor(Object o) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) domainAdapterFactory.adapt(o, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {" + NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(o));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_92 = NL;

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
importManager.addImport("org.eclipse.gef.palette.SelectionToolEntry");
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
    
List toolGroups = palette.getGroups();
for (int i = 0; i < toolGroups.size(); i++) {
	ToolGroup toolGroup = (ToolGroup) toolGroups.get(i);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_5);
    }
    stringBuffer.append(TEXT_6);
    
final LinkedList<ToolGroup> toolGroupsQueue = new LinkedList<ToolGroup>();
for(Object next : palette.getGroups()) {
	toolGroupsQueue.add((ToolGroup) next);
}
final LinkedList<ToolEntry> toolsQueue = new LinkedList<ToolEntry>();
while (!toolGroupsQueue.isEmpty()) {
	// TODO with additional counter and hashmap here it's easy to add "unique method name" check here
	ToolGroup toolGroup = (ToolGroup) toolGroupsQueue.removeFirst();

    stringBuffer.append(TEXT_7);
    stringBuffer.append(toolGroup.getCreateMethodName());
    stringBuffer.append(TEXT_8);
    if (toolGroup.isCollapse() && toolGroup.isToolsOnly()) { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteDrawer"));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_11);
    } else if (toolGroup.isStack()) {
    
	if (toolGroup.getSmallIconPath() != null) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(toolGroup.getSmallIconPath());
    stringBuffer.append(TEXT_15);
    
	} else {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_17);
    
	}

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteStack"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_20);
    if (toolGroup.getDescription() != null) {
    stringBuffer.append(TEXT_21);
    stringBuffer.append(toolGroup.getDescription());
    stringBuffer.append(TEXT_22);
    } else {
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    } else {
    stringBuffer.append(TEXT_25);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteGroup"));
    stringBuffer.append(TEXT_26);
    stringBuffer.append(toolGroup.getTitle());
    stringBuffer.append(TEXT_27);
    }
if (toolGroup.getDescription() != null) {
    stringBuffer.append(TEXT_28);
    stringBuffer.append(toolGroup.getDescription());
    stringBuffer.append(TEXT_29);
    }
    
for(Iterator it = toolGroup.getEntries().iterator(); it.hasNext(); ) {
	ToolGroupItem groupItem = (ToolGroupItem) it.next();
	if (groupItem instanceof ToolEntry) {
		toolsQueue.add((ToolEntry) groupItem);

    stringBuffer.append(TEXT_30);
    stringBuffer.append(((ToolEntry) groupItem).getCreateMethodName());
    stringBuffer.append(TEXT_31);
    	} else if (groupItem instanceof ToolGroup) {
		toolGroupsQueue.addLast((ToolGroup) groupItem);

    stringBuffer.append(TEXT_32);
    stringBuffer.append(((ToolGroup) groupItem).getCreateMethodName());
    stringBuffer.append(TEXT_33);
    
	} else if (groupItem instanceof Separator) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.PaletteSeparator"));
    stringBuffer.append(TEXT_35);
    	} /*else - no more options possible, log warning? */
    } /*for*/
    stringBuffer.append(TEXT_36);
    
} /*while*/
boolean hasNodeEntries = false;
boolean hasLinkEntries = false;
for(ToolEntry toolEntry : toolsQueue) {
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

    stringBuffer.append(TEXT_37);
    stringBuffer.append(toolEntry.getCreateMethodName());
    stringBuffer.append(TEXT_38);
    if (toolEntry.getSmallIconPath() != null) {
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(toolEntry.getSmallIconPath());
    stringBuffer.append(TEXT_42);
    } else if (domainElementInstanceCreationCode != null) {
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_44);
    stringBuffer.append(domainElementInstanceCreationCode);
    stringBuffer.append(TEXT_45);
    } else {
    stringBuffer.append(TEXT_46);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_47);
    }
    stringBuffer.append(TEXT_48);
    if (toolEntry.getLargeIconPath() != null) {
    stringBuffer.append(TEXT_49);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_50);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(toolEntry.getLargeIconPath());
    stringBuffer.append(TEXT_52);
    } else {
    stringBuffer.append(TEXT_53);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.resource.ImageDescriptor"));
    stringBuffer.append(TEXT_54);
    }
    
	if (!toolEntry.getElements().isEmpty()) {

    stringBuffer.append(TEXT_55);
    
		for (Iterator genElementsIterator = toolEntry.getElements().iterator(); genElementsIterator.hasNext();) {
			GenCommonBase next = (GenCommonBase) genElementsIterator.next();

    stringBuffer.append(TEXT_56);
    stringBuffer.append(importManager.getImportedName(next.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_57);
    if (genElementsIterator.hasNext()) {
    stringBuffer.append(TEXT_58);
    }
    
		}
	}

    stringBuffer.append(TEXT_59);
    
	if (firstGenElement instanceof GenNode) {
		hasNodeEntries = true;

    stringBuffer.append(TEXT_60);
    stringBuffer.append(toolEntry.getTitle());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(toolEntry.getDescription());
    stringBuffer.append(TEXT_62);
    
	} else if (firstGenElement instanceof GenLink) {
		hasLinkEntries = true;

    stringBuffer.append(TEXT_63);
    stringBuffer.append(toolEntry.getTitle());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(toolEntry.getDescription());
    stringBuffer.append(TEXT_65);
    
	} else {

    stringBuffer.append(TEXT_66);
    stringBuffer.append(toolEntry.getTitle());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(toolEntry.getDescription());
    stringBuffer.append(TEXT_68);
    
	}
	// there's a problem with qualifiedToolName - we should also respect different tools 
	// in NodeToolEntry and LinkToolEntry (right now there's hardcoded name of the tool) 
	if (toolEntry.getQualifiedToolName() != null && toolEntry.getQualifiedToolName().trim().length() > 0 ) {

    stringBuffer.append(TEXT_69);
    stringBuffer.append(importManager.getImportedName(toolEntry.getQualifiedToolName()));
    stringBuffer.append(TEXT_70);
    
	} /*tool class presence*/
	if (!toolEntry.getProperties().isEmpty()) {
		for (Iterator it = toolEntry.getProperties().entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();

    stringBuffer.append(TEXT_71);
    stringBuffer.append(entry.getKey());
    stringBuffer.append(TEXT_72);
    stringBuffer.append(entry.getValue());
    stringBuffer.append(TEXT_73);
    
		} /*properties iterator*/
	} /*properties presence check*/

    stringBuffer.append(TEXT_74);
    
}	/*for*/

    stringBuffer.append(TEXT_75);
    
if (hasNodeEntries) {

    stringBuffer.append(TEXT_76);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.palette.CombinedTemplateCreationEntry"));
    stringBuffer.append(TEXT_77);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory"));
    stringBuffer.append(TEXT_78);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Node"));
    stringBuffer.append(TEXT_79);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_80);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateRequestEx"));
    stringBuffer.append(TEXT_81);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_82);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPart"));
    stringBuffer.append(TEXT_83);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.Request"));
    stringBuffer.append(TEXT_84);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.RequestConstants"));
    stringBuffer.append(TEXT_85);
    
}	/*if (hasNodeEntries)*/
if (hasLinkEntries) {

    stringBuffer.append(TEXT_86);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.ModelCreationFactory"));
    stringBuffer.append(TEXT_87);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.Edge"));
    stringBuffer.append(TEXT_88);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_89);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.lite.requests.CreateConnectionRequestEx"));
    stringBuffer.append(TEXT_90);
    
}	/*if (hasLinkEntries)*/

    stringBuffer.append(TEXT_91);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_92);
    return stringBuffer.toString();
  }
}

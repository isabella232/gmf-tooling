package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.emf.codegen.util.*;

public class PluginXML
{
  protected static String nl;
  public static synchronized PluginXML create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginXML result = new PluginXML();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin>" + NL + "" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "    <?gmfgen generated=\"true\"?>" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_2 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL;
  protected final String TEXT_3 = NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_4 = "\"" + NL + "        name=\"";
  protected final String TEXT_5 = " Diagram Editor\"" + NL + "        icon=\"";
  protected final String TEXT_6 = "\"" + NL + "        extensions=\"";
  protected final String TEXT_7 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_8 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_9 = "\">" + NL + "     </editor>" + NL + "   </extension>";
  protected final String TEXT_10 = NL + "   <extension point=\"org.eclipse.ui.views\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "      <view" + NL + "            allowMultiple=\"false\"" + NL + "            category=\"";
  protected final String TEXT_11 = "\"";
  protected final String TEXT_12 = NL + "            class=\"";
  protected final String TEXT_13 = "\"" + NL + "            icon=\"";
  protected final String TEXT_14 = "\"" + NL + "            id=\"";
  protected final String TEXT_15 = "\"" + NL + "            name=\"";
  protected final String TEXT_16 = " Diagram View\"/>" + NL + "   </extension>";
  protected final String TEXT_17 = NL + "  <extension" + NL + "    point=\"org.eclipse.core.runtime.applications\"" + NL + "    id=\"";
  protected final String TEXT_18 = "DiagramApplication\">" + NL + "    <?gmfgen generated=\"true\"?>" + NL + "    <application>" + NL + "      <run" + NL + "        class=\"";
  protected final String TEXT_19 = "$Application\">" + NL + "      </run>" + NL + "    </application>" + NL + "  </extension>" + NL + "" + NL + "   <extension" + NL + "    point=\"org.eclipse.ui.perspectives\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "    <perspective" + NL + "      name=\"%_UI_Perspective_label\"" + NL + "      class=\"";
  protected final String TEXT_20 = "$Perspective\"" + NL + "      id=\"";
  protected final String TEXT_21 = ".Perspective\">" + NL + "    </perspective>" + NL + "  </extension>";
  protected final String TEXT_22 = NL + "  <extension" + NL + "    point=\"org.eclipse.ui.commands\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "    <command" + NL + "      name=\"%_UI_Menu_OpenURI_label\"" + NL + "      description=\"%_UI_Menu_OpenURI_description\"" + NL + "      categoryId=\"org.eclipse.ui.category.file\"" + NL + "      id=\"";
  protected final String TEXT_23 = "OpenURICommand\" />  " + NL + "    <command" + NL + "      name=\"%_UI_Menu_Open_label\"" + NL + "      description=\"%_UI_Menu_Open_description\"" + NL + "      categoryId=\"org.eclipse.ui.category.file\"" + NL + "      id=\"";
  protected final String TEXT_24 = "OpenCommand\" />  " + NL + "  </extension> " + NL + "" + NL + "  <extension" + NL + "    point=\"org.eclipse.ui.bindings\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "    <key" + NL + "      commandId=\"";
  protected final String TEXT_25 = "OpenURICommand\"" + NL + "      sequence=\"M1+U\"" + NL + "      schemeId=\"org.eclipse.ui.defaultAcceleratorConfiguration\" />" + NL + "    <key" + NL + "      commandId=\"";
  protected final String TEXT_26 = "OpenCommand\"" + NL + "      sequence=\"M1+O\"" + NL + "      schemeId=\"org.eclipse.ui.defaultAcceleratorConfiguration\" />" + NL + "  </extension>" + NL + "  <extension" + NL + "    point=\"org.eclipse.ui.actionSets\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "    <actionSet" + NL + "      label=\"%_UI_";
  protected final String TEXT_27 = "_ActionSet_label\"" + NL + "      visible=\"true\"" + NL + "      id=\"";
  protected final String TEXT_28 = "ActionSet\">";
  protected final String TEXT_29 = NL + "      <action" + NL + "        label=\"%_UI_Menu_About_label\"" + NL + "        class=\"";
  protected final String TEXT_30 = "$AboutAction\"" + NL + "        menubarPath=\"help/additions\"" + NL + "        id=\"";
  protected final String TEXT_31 = "AboutAction\">" + NL + "      </action>";
  protected final String TEXT_32 = NL + "      <action" + NL + "        label=\"%_UI_Menu_OpenURI_label\"" + NL + "        definitionId=\"";
  protected final String TEXT_33 = "OpenURICommand\"" + NL + "        class=\"";
  protected final String TEXT_34 = "$OpenURIAction\"" + NL + "        menubarPath=\"file/additions\"" + NL + "        id=\"";
  protected final String TEXT_35 = "OpenURIAction\">" + NL + "      </action>" + NL + "      <action" + NL + "        label=\"%_UI_Menu_Open_label\"" + NL + "        definitionId=\"";
  protected final String TEXT_36 = "OpenCommand\"" + NL + "        class=\"";
  protected final String TEXT_37 = "$OpenDiagramAction\"" + NL + "        menubarPath=\"file/additions\"" + NL + "        id=\"";
  protected final String TEXT_38 = "OpenDiagramAction\">" + NL + "      </action>" + NL + "      <action" + NL + "        label=\"%_UI_";
  protected final String TEXT_39 = "NewDiagramCommand\"" + NL + "        class=\"";
  protected final String TEXT_40 = "$NewDiagramAction\"" + NL + "        menubarPath=\"file/new/additions\"" + NL + "        id=\"";
  protected final String TEXT_41 = "NewAction\">" + NL + "      </action>" + NL + "      <action" + NL + "        label=\"Initialize ";
  protected final String TEXT_42 = " diagram file\"" + NL + "        class=\"";
  protected final String TEXT_43 = "\"" + NL + "        menubarPath=\"file/additions\"" + NL + "        id=\"";
  protected final String TEXT_44 = "ID\">" + NL + "      </action>" + NL + "    </actionSet> " + NL + "  </extension>";
  protected final String TEXT_45 = NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "  \t  <wizard" + NL + "  \t     name=\"";
  protected final String TEXT_46 = " Diagram\"" + NL + "  \t     icon=\"";
  protected final String TEXT_47 = "\"" + NL + "  \t     category=\"";
  protected final String TEXT_48 = "\"" + NL + "  \t     class=\"";
  protected final String TEXT_49 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_50 = "ID\">" + NL + "  \t  \t <description>" + NL + "  \t  \t\tCreates ";
  protected final String TEXT_51 = " diagram." + NL + "  \t  \t </description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "     <?gmfgen generated=\"true\"?>" + NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_52 = ".ui.objectContribution.IFile1\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_53 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Initialize ";
  protected final String TEXT_54 = " diagram file\"" + NL + "               class=\"";
  protected final String TEXT_55 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_56 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>  ";
  protected final String TEXT_57 = NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_58 = ".ui.objectContribution.IFile2\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_59 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Open diagram in ";
  protected final String TEXT_60 = " Diagram View\"";
  protected final String TEXT_61 = NL + "               class=\"";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>  ";
  protected final String TEXT_66 = NL + "   </extension>" + NL;
  protected final String TEXT_67 = NL;
  protected final String TEXT_68 = "   <extension point=\"org.eclipse.ui.navigator.viewer\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <viewerContentBinding viewerId=\"org.eclipse.ui.navigator.ProjectExplorer\">" + NL + "         <includes>" + NL + "            <contentExtension pattern=\"";
  protected final String TEXT_69 = "\"/>";
  protected final String TEXT_70 = NL + "            <contentExtension pattern=\"";
  protected final String TEXT_71 = "\"/>";
  protected final String TEXT_72 = NL + "         </includes>" + NL + "      </viewerContentBinding>" + NL + "      <viewerActionBinding viewerId=\"org.eclipse.ui.navigator.ProjectExplorer\">" + NL + "         <includes>" + NL + "            <actionExtension pattern=\"";
  protected final String TEXT_73 = "\"/>" + NL + "         </includes>" + NL + "      </viewerActionBinding>" + NL + "   </extension>" + NL + "   <extension point=\"org.eclipse.ui.navigator.navigatorContent\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <navigatorContent " + NL + "            id=\"";
  protected final String TEXT_74 = "\" " + NL + "            name=\"";
  protected final String TEXT_75 = "\" " + NL + "            priority=\"";
  protected final String TEXT_76 = "\" " + NL + "            contentProvider=\"";
  protected final String TEXT_77 = "\" " + NL + "            labelProvider=\"";
  protected final String TEXT_78 = "\"" + NL + "            icon=\"";
  protected final String TEXT_79 = "\"" + NL + "            activeByDefault=\"true\">" + NL + "         <triggerPoints>" + NL + "            <or>" + NL + "\t           <and>" + NL + "    \t          <instanceof value=\"org.eclipse.core.resources.IFile\"/>" + NL + "        \t      <test property=\"org.eclipse.core.resources.extension\" value=\"";
  protected final String TEXT_80 = "\"/>" + NL + "               </and>" + NL + "               <instanceof value=\"";
  protected final String TEXT_81 = "\"/>";
  protected final String TEXT_82 = NL + "           \t   <adapt type=\"org.eclipse.gmf.runtime.notation.View\">" + NL + "           \t      <test property=\"";
  protected final String TEXT_83 = ".isShortcut\"/>" + NL + "           \t   </adapt>";
  protected final String TEXT_84 = NL + "            </or>" + NL + "         </triggerPoints>" + NL + "         <possibleChildren>" + NL + "            <or>" + NL + "         \t   <instanceof value=\"";
  protected final String TEXT_85 = "\"/>";
  protected final String TEXT_86 = NL + "           \t   <adapt type=\"org.eclipse.gmf.runtime.notation.View\">" + NL + "           \t      <test property=\"";
  protected final String TEXT_87 = ".isShortcut\"/>" + NL + "           \t   </adapt>";
  protected final String TEXT_88 = NL + "            </or>" + NL + "         </possibleChildren>" + NL + "         <commonSorter " + NL + "               id=\"";
  protected final String TEXT_89 = "\" " + NL + "               class=\"";
  protected final String TEXT_90 = "\">" + NL + "            <parentExpression>" + NL + "               <or>" + NL + "\t              <and>" + NL + "    \t             <instanceof value=\"org.eclipse.core.resources.IFile\"/>" + NL + "        \t         <test property=\"org.eclipse.core.resources.extension\" value=\"";
  protected final String TEXT_91 = "\"/>" + NL + "                  </and>" + NL + "                  <instanceof value=\"";
  protected final String TEXT_92 = "\"/>" + NL + "               </or>" + NL + "            </parentExpression>" + NL + "         </commonSorter>" + NL + "      </navigatorContent>" + NL + "      <actionProvider" + NL + "            id=\"";
  protected final String TEXT_93 = "\"" + NL + "            class=\"";
  protected final String TEXT_94 = "\">" + NL + "         <enablement>" + NL + "            <or>" + NL + "               <instanceof value=\"";
  protected final String TEXT_95 = "\"/>";
  protected final String TEXT_96 = NL + "           \t   <adapt type=\"org.eclipse.gmf.runtime.notation.View\">" + NL + "           \t      <test property=\"";
  protected final String TEXT_97 = ".isShortcut\"/>" + NL + "           \t   </adapt>";
  protected final String TEXT_98 = NL + "            </or>" + NL + "         </enablement>" + NL + "      </actionProvider>" + NL + "   </extension>" + NL;
  protected final String TEXT_99 = NL + "   <extension point=\"org.eclipse.ui.navigator.linkHelper\">" + NL + "      <?gmfgen generated=\"true\"?>" + NL + "      <linkHelper" + NL + "            id=\"";
  protected final String TEXT_100 = "\"" + NL + "            class=\"";
  protected final String TEXT_101 = "\">" + NL + "         <editorInputEnablement>" + NL + "         \t<or>" + NL + "\t            <instanceof value=\"org.eclipse.ui.IFileEditorInput\"/>" + NL + "\t            <instanceof value=\"org.eclipse.emf.common.ui.URIEditorInput\"/>" + NL + "\t            <instanceof value=\"org.eclipse.gmf.runtime.lite.parts.DiagramEditorInput\"/>" + NL + "\t        </or>" + NL + "         </editorInputEnablement>" + NL + "         <selectionEnablement>" + NL + "            <instanceof value=\"";
  protected final String TEXT_102 = "\"/>" + NL + "         </selectionEnablement>" + NL + "      </linkHelper>" + NL + "   </extension>";
  protected final String TEXT_103 = NL + "</plugin>";
  protected final String TEXT_104 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenEditorGenerator editorGen = genPlugin.getEditorGen();
final GenDiagram genDiagram = editorGen.getDiagram();
final GenModel genModel = editorGen.getDomainGenModel();
final boolean isRichClientPlatform = genDiagram.getEditorGen().getDomainGenModel().isRichClientPlatform();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_2);
    
if (editorGen.getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(editorGen.getEditor().getIconPathX());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(editorGen.getEditor().getQualifiedClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(editorGen.getEditor().getActionBarContributorQualifiedClassName());
    stringBuffer.append(TEXT_9);
    
} else {

    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getCreationWizardCategoryID());
    stringBuffer.append(TEXT_11);
    /*XXX: replace with gmfgen property*/
    stringBuffer.append(TEXT_12);
    stringBuffer.append(editorGen.getEditor().getQualifiedClassName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(editorGen.getEditor().getIconPathX());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_16);
    
}

    
if (isRichClientPlatform) {
	final boolean shouldGenerateApplication = true;	/*XXX: option in gmfgen*/
	if (shouldGenerateApplication) {

    stringBuffer.append(TEXT_17);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_21);
    
	}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_28);
    
	if (shouldGenerateApplication) {

    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_31);
    
	}

    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_37);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_44);
    
} else {

    stringBuffer.append(TEXT_45);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genDiagram.getCreationWizardIconPathX());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genDiagram.getCreationWizardCategoryID());
    stringBuffer.append(TEXT_48);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_52);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_53);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_54);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_56);
    
	if (!editorGen.getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_57);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_58);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_60);
    
		/*XXX: property in gmfgen?*/
		String className = "OpenDiagramIn" + genModel.getModelName() + "DiagramViewAction";
		className = CodeGenUtil.validJavaIdentifier(className);

    stringBuffer.append(TEXT_61);
    stringBuffer.append(editorGen.getEditor().getPackageName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(editorGen.getEditor().getPackageName());
    stringBuffer.append(TEXT_64);
    stringBuffer.append(className);
    stringBuffer.append(TEXT_65);
    
	}

    stringBuffer.append(TEXT_66);
    
}

    if (editorGen.getNavigator() != null && !isRichClientPlatform) {
    stringBuffer.append(TEXT_67);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionID());
    stringBuffer.append(TEXT_69);
    
if (editorGen.getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_70);
    stringBuffer.append(editorGen.getNavigator().getLinkHelperExtensionID());
    stringBuffer.append(TEXT_71);
    
}

    stringBuffer.append(TEXT_72);
    stringBuffer.append(editorGen.getNavigator().getActionProviderID());
    stringBuffer.append(TEXT_73);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionID());
    stringBuffer.append(TEXT_74);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionName());
    stringBuffer.append(TEXT_75);
    stringBuffer.append(editorGen.getNavigator().getContentExtensionPriority());
    stringBuffer.append(TEXT_76);
    stringBuffer.append(editorGen.getNavigator().getContentProviderQualifiedClassName());
    stringBuffer.append(TEXT_77);
    stringBuffer.append(editorGen.getNavigator().getLabelProviderQualifiedClassName());
    stringBuffer.append(TEXT_78);
    stringBuffer.append(editorGen.getEditor().getIconPathX());
    stringBuffer.append(TEXT_79);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_80);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_81);
    if (false && genDiagram.generateShortcutIcon()) {	//XXX: no shortcuts yet
    stringBuffer.append(TEXT_82);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_85);
    if (false && genDiagram.generateShortcutIcon()) {	//XXX: no shortcuts yet 
    stringBuffer.append(TEXT_86);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_87);
    }
    stringBuffer.append(TEXT_88);
    stringBuffer.append(editorGen.getNavigator().getSorterExtensionID());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(editorGen.getNavigator().getSorterQualifiedClassName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_92);
    stringBuffer.append(editorGen.getNavigator().getActionProviderID());
    stringBuffer.append(TEXT_93);
    stringBuffer.append(editorGen.getNavigator().getActionProviderQualifiedClassName());
    stringBuffer.append(TEXT_94);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_95);
    if (false && genDiagram.generateShortcutIcon()) {	//XXX: no shortcuts yet 
    stringBuffer.append(TEXT_96);
    stringBuffer.append(editorGen.getPlugin().getID());
    stringBuffer.append(TEXT_97);
    }
    stringBuffer.append(TEXT_98);
    
if (editorGen.getEditor().isEclipseEditor()) {

    stringBuffer.append(TEXT_99);
    stringBuffer.append(editorGen.getNavigator().getLinkHelperExtensionID());
    stringBuffer.append(TEXT_100);
    stringBuffer.append(editorGen.getNavigator().getLinkHelperQualifiedClassName());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(editorGen.getNavigator().getAbstractNavigatorItemQualifiedClassName());
    stringBuffer.append(TEXT_102);
    
}

    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(TEXT_104);
    return stringBuffer.toString();
  }
}

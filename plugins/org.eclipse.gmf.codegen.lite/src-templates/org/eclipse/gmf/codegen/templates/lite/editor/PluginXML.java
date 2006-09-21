package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

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
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin>" + NL + "" + NL + "<!-- gmf generator persistent region begin -->" + NL + "<!-- gmf generator persistent region end -->" + NL + "" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_2 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_3 = "\"" + NL + "        name=\"";
  protected final String TEXT_4 = " Diagram Editor\"" + NL + "        icon=\"";
  protected final String TEXT_5 = "\"" + NL + "        extensions=\"";
  protected final String TEXT_6 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_7 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_8 = "\">" + NL + "     </editor>" + NL + "   </extension>" + NL;
  protected final String TEXT_9 = NL + "  <extension" + NL + "    point=\"org.eclipse.core.runtime.applications\"" + NL + "    id=\"";
  protected final String TEXT_10 = "DiagramApplication\">" + NL + "    <application>" + NL + "      <run" + NL + "        class=\"";
  protected final String TEXT_11 = "$Application\">" + NL + "      </run>" + NL + "    </application>" + NL + "  </extension>" + NL + "" + NL + "   <extension" + NL + "    point=\"org.eclipse.ui.perspectives\">" + NL + "    <perspective" + NL + "      name=\"%_UI_Perspective_label\"" + NL + "      class=\"";
  protected final String TEXT_12 = "$Perspective\"" + NL + "      id=\"";
  protected final String TEXT_13 = ".Perspective\">" + NL + "    </perspective>" + NL + "  </extension>";
  protected final String TEXT_14 = NL + "  <extension" + NL + "    point=\"org.eclipse.ui.commands\">" + NL + "    <command" + NL + "      name=\"%_UI_Menu_OpenURI_label\"" + NL + "      description=\"%_UI_Menu_OpenURI_description\"" + NL + "      categoryId=\"org.eclipse.ui.category.file\"" + NL + "      id=\"";
  protected final String TEXT_15 = "OpenURICommand\" />  " + NL + "    <command" + NL + "      name=\"%_UI_Menu_Open_label\"" + NL + "      description=\"%_UI_Menu_Open_description\"" + NL + "      categoryId=\"org.eclipse.ui.category.file\"" + NL + "      id=\"";
  protected final String TEXT_16 = "OpenCommand\" />  " + NL + "  </extension> " + NL + "" + NL + "  <extension" + NL + "    point=\"org.eclipse.ui.bindings\">" + NL + "    <key" + NL + "      commandId=\"";
  protected final String TEXT_17 = "OpenURICommand\"" + NL + "      sequence=\"M1+U\"" + NL + "      schemeId=\"org.eclipse.ui.defaultAcceleratorConfiguration\" />" + NL + "    <key" + NL + "      commandId=\"";
  protected final String TEXT_18 = "OpenCommand\"" + NL + "      sequence=\"M1+O\"" + NL + "      schemeId=\"org.eclipse.ui.defaultAcceleratorConfiguration\" />" + NL + "  </extension>" + NL + "  <extension" + NL + "    point=\"org.eclipse.ui.actionSets\">" + NL + "    <actionSet" + NL + "      label=\"%_UI_";
  protected final String TEXT_19 = "_ActionSet_label\"" + NL + "      visible=\"true\"" + NL + "      id=\"";
  protected final String TEXT_20 = "ActionSet\">";
  protected final String TEXT_21 = NL + "      <action" + NL + "        label=\"%_UI_Menu_About_label\"" + NL + "        class=\"";
  protected final String TEXT_22 = "$AboutAction\"" + NL + "        menubarPath=\"help/additions\"" + NL + "        id=\"";
  protected final String TEXT_23 = "AboutAction\">" + NL + "      </action>";
  protected final String TEXT_24 = NL + "      <action" + NL + "        label=\"%_UI_Menu_OpenURI_label\"" + NL + "        definitionId=\"";
  protected final String TEXT_25 = "OpenURICommand\"" + NL + "        class=\"";
  protected final String TEXT_26 = "$OpenURIAction\"" + NL + "        menubarPath=\"file/additions\"" + NL + "        id=\"";
  protected final String TEXT_27 = "OpenURIAction\">" + NL + "      </action>" + NL + "      <action" + NL + "        label=\"%_UI_Menu_Open_label\"" + NL + "        definitionId=\"";
  protected final String TEXT_28 = "OpenCommand\"" + NL + "        class=\"";
  protected final String TEXT_29 = "$OpenDiagramAction\"" + NL + "        menubarPath=\"file/additions\"" + NL + "        id=\"";
  protected final String TEXT_30 = "OpenDiagramAction\">" + NL + "      </action>" + NL + "      <action" + NL + "        label=\"%_UI_";
  protected final String TEXT_31 = "NewDiagramCommand\"" + NL + "        class=\"";
  protected final String TEXT_32 = "$NewDiagramAction\"" + NL + "        menubarPath=\"file/new/additions\"" + NL + "        id=\"";
  protected final String TEXT_33 = "NewAction\">" + NL + "      </action>" + NL + "      <action" + NL + "        label=\"Initialize ";
  protected final String TEXT_34 = " diagram file\"" + NL + "        class=\"";
  protected final String TEXT_35 = "\"" + NL + "        menubarPath=\"file/additions\"" + NL + "        id=\"";
  protected final String TEXT_36 = "ID\">" + NL + "      </action>" + NL + "    </actionSet> " + NL + "  </extension>";
  protected final String TEXT_37 = NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "  \t  <wizard" + NL + "  \t     name=\"";
  protected final String TEXT_38 = " Diagram\"" + NL + "  \t     icon=\"";
  protected final String TEXT_39 = "\"" + NL + "  \t     category=\"";
  protected final String TEXT_40 = "\"" + NL + "  \t     class=\"";
  protected final String TEXT_41 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_42 = "ID\">" + NL + "  \t  \t <description>" + NL + "  \t  \t\tCreates ";
  protected final String TEXT_43 = " diagram." + NL + "  \t  \t </description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "   <extension point=\"org.eclipse.ui.popupMenus\">" + NL + "      <objectContribution" + NL + "            id=\"";
  protected final String TEXT_44 = ".ui.objectContribution.IFile1\"" + NL + "            nameFilter=\"*.";
  protected final String TEXT_45 = "\"" + NL + "            objectClass=\"org.eclipse.core.resources.IFile\">" + NL + "         <action" + NL + "               label=\"Initialize ";
  protected final String TEXT_46 = " diagram file\"" + NL + "               class=\"";
  protected final String TEXT_47 = "\"" + NL + "               menubarPath=\"additions\"" + NL + "               enablesFor=\"1\"" + NL + "               id=\"";
  protected final String TEXT_48 = "ID\">" + NL + "         </action>" + NL + "      </objectContribution>  " + NL + "   </extension>" + NL;
  protected final String TEXT_49 = NL + "</plugin>";
  protected final String TEXT_50 = NL;

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
    stringBuffer.append(editorGen.getEditor().getID());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(editorGen.getEditor().getIconPath());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(editorGen.getEditor().getQualifiedClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(editorGen.getEditor().getActionBarContributorQualifiedClassName());
    stringBuffer.append(TEXT_8);
    
if (isRichClientPlatform) {
	final boolean shouldGenerateApplication = true;	/*XXX: option in gmfgen*/
	if (shouldGenerateApplication) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_13);
    
	}

    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_20);
    
	if (shouldGenerateApplication) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_31);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_36);
    
} else {

    stringBuffer.append(TEXT_37);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(genDiagram.getCreationWizardIconPath());
    stringBuffer.append(TEXT_39);
    stringBuffer.append(genDiagram.getCreationWizardCategoryID());
    stringBuffer.append(TEXT_40);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_41);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_42);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_43);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_44);
    stringBuffer.append(editorGen.getDomainFileExtension());
    stringBuffer.append(TEXT_45);
    stringBuffer.append(editorGen.getDiagramFileExtension());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_47);
    stringBuffer.append(genDiagram.getInitDiagramFileActionQualifiedClassName());
    stringBuffer.append(TEXT_48);
    
}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}

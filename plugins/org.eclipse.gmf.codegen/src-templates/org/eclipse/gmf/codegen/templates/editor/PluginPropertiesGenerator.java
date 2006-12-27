package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import java.util.*;

public class PluginPropertiesGenerator
{
  protected static String nl;
  public static synchronized PluginPropertiesGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginPropertiesGenerator result = new PluginPropertiesGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "pluginName=";
  protected final String TEXT_2 = NL + "providerName=";
  protected final String TEXT_3 = NL + NL + "preferences.general=";
  protected final String TEXT_4 = " Diagram" + NL + "preferences.appearance=Appearance" + NL + "preferences.connections=Connections" + NL + "preferences.printing=Printing" + NL + "preferences.rulersAndGrid=Rulers & Grid" + NL + "preferences.pathmaps=Path Maps" + NL + "" + NL + "editorName=";
  protected final String TEXT_5 = " Diagram Editor" + NL + "newWizardName=";
  protected final String TEXT_6 = " Diagram" + NL + "newWizardDesc=Creates ";
  protected final String TEXT_7 = " diagram." + NL;
  protected final String TEXT_8 = NL + "initDiagramActionLabel=Initialize ";
  protected final String TEXT_9 = " diagram file";
  protected final String TEXT_10 = NL + "createShortcutActionLabel=Create Shortcut...";
  protected final String TEXT_11 = NL + "loadResourceActionLabel=Load Resource...";
  protected final String TEXT_12 = NL + "applicationActionSetLabel=";
  protected final String TEXT_13 = " Actions" + NL + "newDiagramActionLabel=";
  protected final String TEXT_14 = " Diagram" + NL + "aboutActionLabel=";
  protected final String TEXT_15 = " Diagram About..." + NL + "openURIActionLabel=Open URI..." + NL + "openURIActionDescription=Open file by URI" + NL + "openActionLabel=Open..." + NL + "openActionDescription=Open file";
  protected final String TEXT_16 = NL + "navigatorContentName=*.";
  protected final String TEXT_17 = " diagram contents";
  protected final String TEXT_18 = NL + "###" + NL + "# Property Sheet";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "tab.";
  protected final String TEXT_21 = "=";
  protected final String TEXT_22 = NL + "###";
  protected final String TEXT_23 = NL + "###" + NL + "# Palette Factory";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL;
  protected final String TEXT_26 = ".title=";
  protected final String TEXT_27 = NL;
  protected final String TEXT_28 = ".desc=";
  protected final String TEXT_29 = NL + "###";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenDiagram genDiagram = genPlugin.getEditorGen().getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getProvider());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_7);
    if (genDiagram.generateInitDiagramAction()) {
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genPlugin.getEditorGen().getDiagramFileExtension());
    stringBuffer.append(TEXT_9);
    }
if (genDiagram.generateCreateShortcutAction()) {
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    if (genPlugin.getEditorGen().getApplication() != null) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genPlugin.getEditorGen().getModelID());
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genPlugin.getEditorGen().getDiagramFileExtension());
    stringBuffer.append(TEXT_17);
    if (genPlugin.getEditorGen().getPropertySheet() != null) {
	final GenPropertySheet propertySheet = genPlugin.getEditorGen().getPropertySheet();
    stringBuffer.append(TEXT_18);
    stringBuffer.append(TEXT_19);
    for (Iterator it = propertySheet.getTabs().iterator(); it.hasNext(); ) {
	final GenPropertyTab tab = (GenPropertyTab) it.next();
    stringBuffer.append(TEXT_20);
    stringBuffer.append(tab.getID());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(tab.getLabel());
    }
    stringBuffer.append(TEXT_22);
    }
    if (genDiagram.getPalette() != null) {
	final Palette palette = genDiagram.getPalette();
    stringBuffer.append(TEXT_23);
    stringBuffer.append(TEXT_24);
    for (Iterator it = palette.eAllContents(); it.hasNext();) {
	Object next = it.next();
	if (next instanceof EntryBase) {
		EntryBase b = (EntryBase) next;
    stringBuffer.append(TEXT_25);
    stringBuffer.append(b.getIntKey());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(b.getTitle());
    if (b.getDescription() != null) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(b.getIntKey());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(b.getDescription());
    }
    	} /*EntryBase*/
    }
    stringBuffer.append(TEXT_29);
    }
    return stringBuffer.toString();
  }
}

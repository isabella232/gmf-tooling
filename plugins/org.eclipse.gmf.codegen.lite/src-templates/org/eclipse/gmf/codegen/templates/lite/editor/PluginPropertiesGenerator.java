package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;

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
  protected final String TEXT_3 = NL + NL + "# gmf generator persistent region begin" + NL + "# gmf generator persistent region end" + NL;
  protected final String TEXT_4 = NL + "_UI_Menu_OpenURI_label=Open ";
  protected final String TEXT_5 = " Diagram &URI..." + NL + "_UI_Menu_OpenURI_description=Opens a ";
  protected final String TEXT_6 = " diagram loading it from a URI" + NL + "_UI_Menu_Open_label=&Open ";
  protected final String TEXT_7 = " Diagram..." + NL + "_UI_Menu_Open_description=Opens a ";
  protected final String TEXT_8 = " diagram" + NL + "" + NL + "_UI_";
  protected final String TEXT_9 = "_ActionSet_label=";
  protected final String TEXT_10 = " Diagram Action Set " + NL + "_UI_";
  protected final String TEXT_11 = "NewDiagramCommand=";
  protected final String TEXT_12 = " diagram" + NL;
  protected final String TEXT_13 = NL + "_UI_Perspective_label = ";
  protected final String TEXT_14 = " Diagram" + NL + "_UI_Application_title=";
  protected final String TEXT_15 = " Diagram Application " + NL + "_UI_Menu_File_label=&File" + NL + "_UI_Menu_New_label=&New" + NL + "_UI_Menu_Edit_label=&Edit" + NL + "_UI_Menu_Window_label=&Window" + NL + "_UI_Menu_Help_label=&Help" + NL + "_UI_Menu_About_label=";
  protected final String TEXT_16 = " Diagram &About..." + NL + "_UI_About_title = ";
  protected final String TEXT_17 = " Diagram Application" + NL + "_UI_About_text = ";
  protected final String TEXT_18 = " Diagram Application about box goes here.";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenPlugin genPlugin = (GenPlugin) argument;
final GenDiagram genDiagram = genPlugin.getEditorGen().getDiagram();
final GenModel genModel = genPlugin.getEditorGen().getDomainGenModel();
final boolean isRichClientPlatform = genModel.isRichClientPlatform();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getProvider());
    stringBuffer.append(TEXT_3);
    if (isRichClientPlatform) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getDiagramEditorUtilQualifiedClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_12);
    
	boolean shouldGenerateApplication = true;	/*XXX: option in gmfgen*/
	if (shouldGenerateApplication) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_18);
    
	}
}

    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}

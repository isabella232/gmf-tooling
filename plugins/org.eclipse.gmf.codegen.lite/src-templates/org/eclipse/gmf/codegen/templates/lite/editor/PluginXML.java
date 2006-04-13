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
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + NL + "<?eclipse version=\"3.0\"?>" + NL + "<plugin>" + NL + "  <extension point=\"org.eclipse.team.core.fileTypes\">" + NL + "      <fileTypes" + NL + "         type=\"text\"" + NL + "         extension=\"";
  protected final String TEXT_2 = "\">" + NL + "      </fileTypes>" + NL + "  </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.editors\">" + NL + "     <editor" + NL + "        id=\"";
  protected final String TEXT_3 = "\"" + NL + "        name=\"";
  protected final String TEXT_4 = " Diagram Editor\"" + NL + "        icon=\"";
  protected final String TEXT_5 = "\"" + NL + "        extensions=\"";
  protected final String TEXT_6 = "\"" + NL + "        default=\"true\"" + NL + "        class=\"";
  protected final String TEXT_7 = "\"" + NL + "        contributorClass=\"";
  protected final String TEXT_8 = "\">" + NL + "     </editor>" + NL + "   </extension>" + NL + "" + NL + "   <extension point=\"org.eclipse.ui.newWizards\">" + NL + "  \t  <wizard" + NL + "  \t     name=\"";
  protected final String TEXT_9 = " Diagram\"" + NL + "  \t     icon=\"";
  protected final String TEXT_10 = "\"" + NL + "  \t     category=\"org.eclipse.ui.Examples\"" + NL + "  \t     class=\"";
  protected final String TEXT_11 = "\"" + NL + "  \t     id=\"";
  protected final String TEXT_12 = "ID\">" + NL + "  \t  \t <description>" + NL + "  \t  \t\tCreates ";
  protected final String TEXT_13 = " diagram." + NL + "  \t  \t </description>  " + NL + "      </wizard>" + NL + "   </extension>" + NL + "" + NL + "</plugin>";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenEditorGenerator editorGen = genPlugin.getEditorGen();
final GenDiagram genDiagram = editorGen.getDiagram();
final GenModel genModel = editorGen.getDomainGenModel();

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
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getCreationWizardIconPath());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_11);
    stringBuffer.append(genDiagram.getCreationWizardQualifiedClassName());
    stringBuffer.append(TEXT_12);
    stringBuffer.append(genModel.getModelName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}

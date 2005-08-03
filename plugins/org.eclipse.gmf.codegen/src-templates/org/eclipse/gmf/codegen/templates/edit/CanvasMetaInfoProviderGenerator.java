package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class CanvasMetaInfoProviderGenerator
{
  protected static String nl;
  public static synchronized CanvasMetaInfoProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    CanvasMetaInfoProviderGenerator result = new CanvasMetaInfoProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";";
  protected final String TEXT_3 = NL + NL + "import org.eclipse.gmf.diagramrt.DiagramCanvas;" + NL + "import org.eclipse.gmf.edit.provider.CanvasMetaInfoProvider;" + NL + "import org.eclipse.gmf.edit.provider.MetaInfoProviderAdapter;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends MetaInfoProviderAdapter implements CanvasMetaInfoProvider {" + NL + "}";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getMetaInfoProviderClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}

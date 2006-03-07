package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class IconProviderGenerator
{
  protected static String nl;
  public static synchronized IconProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    IconProviderGenerator result = new IconProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends AbstractProvider implements IIconProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Image getIcon(IAdaptable hint, int flags) {" + NL + "\t\treturn ";
  protected final String TEXT_9 = ".getImage(hint);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetIconOperation) {" + NL + "\t\t\treturn ((GetIconOperation) operation).execute(this) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getIconProviderClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}

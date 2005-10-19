package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.icon.GetIconOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.icon.IIconProvider;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.icon.IconOptions;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends AbstractProvider implements IIconProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Image getIcon(IAdaptable hint, int flags) {" + NL + "\t\treturn ElementTypes.getImage(hint);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetIconOperation) {" + NL + "\t\t\tIAdaptable hint = ((GetIconOperation) operation).getHint();" + NL + "\t\t\treturn getIcon(hint, IconOptions.NONE.intValue()) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(diagram.getIconProviderClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

public class MatchingStrategyGenerator
{
  protected static String nl;
  public static synchronized MatchingStrategyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MatchingStrategyGenerator result = new MatchingStrategyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditorMatchingStrategy;" + NL + "import org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " extends DiagramDocumentEditorMatchingStrategy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic MEditingDomain getDefaultDomain() {" + NL + "\t\treturn MEditingDomain.INSTANCE;" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(diagram.getMatchingStrategyClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}

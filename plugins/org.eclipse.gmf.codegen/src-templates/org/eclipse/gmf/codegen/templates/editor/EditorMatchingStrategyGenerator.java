package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;

public class EditorMatchingStrategyGenerator
{
  protected static String nl;
  public static synchronized EditorMatchingStrategyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    EditorMatchingStrategyGenerator result = new EditorMatchingStrategyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.internal.parts.DiagramDocumentEditorMatchingStrategy;" + NL + "import org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class MDiagramEditorMatchingStrategy extends DiagramDocumentEditorMatchingStrategy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic MEditingDomain getDefaultDomain() {" + NL + "\t\treturn MEditingDomain.INSTANCE;" + NL + "\t}" + NL + "}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}

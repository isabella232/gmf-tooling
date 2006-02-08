package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = NL + "import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditorMatchingStrategy;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_2 = " extends DiagramDocumentEditorMatchingStrategy {}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram diagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getMatchingStrategyClassName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}

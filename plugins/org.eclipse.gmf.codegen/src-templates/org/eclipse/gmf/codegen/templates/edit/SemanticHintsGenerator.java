package org.eclipse.gmf.codegen.templates.edit;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class SemanticHintsGenerator
{
  protected static String nl;
  public static synchronized SemanticHintsGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SemanticHintsGenerator result = new SemanticHintsGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ";
  protected final String TEXT_5 = " = \"";
  protected final String TEXT_6 = "Feature\";";
  protected final String TEXT_7 = NL + "}";
  protected final String TEXT_8 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenBaseElement genElement = (GenBaseElement) argument;
    GenDiagram genDiagram = genElement.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditProvidersPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genElement));
    stringBuffer.append(TEXT_3);
    if (genElement.hasNameToEdit()) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genElement));
    stringBuffer.append(TEXT_5);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genElement));
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}

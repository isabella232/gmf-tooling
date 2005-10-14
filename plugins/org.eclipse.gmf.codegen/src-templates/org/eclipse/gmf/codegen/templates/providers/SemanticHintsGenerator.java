package org.eclipse.gmf.codegen.templates.providers;

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
  protected final String TEXT_4 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String VIEW_TYPE = \"";
  protected final String TEXT_5 = "Link\";";
  protected final String TEXT_6 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ";
  protected final String TEXT_7 = " = \"";
  protected final String TEXT_8 = "Feature\";";
  protected final String TEXT_9 = NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenBaseElement genElement = (GenBaseElement) argument;
    GenDiagram genDiagram = genElement.getDiagram();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genElement));
    stringBuffer.append(TEXT_3);
    if (genElement instanceof GenLinkReferenceOnly) {
    stringBuffer.append(TEXT_4);
    stringBuffer.append(((GenLinkReferenceOnly) genElement).getDomainLinkTargetFeature().getName());
    stringBuffer.append(TEXT_5);
    
}
if (genElement.hasNameToEdit()) {

    stringBuffer.append(TEXT_6);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genElement));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(AccessUtil.getNameSemanticHint(genElement));
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}

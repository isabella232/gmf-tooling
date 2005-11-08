package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class LinkItemSemanticEditPolicyGenerator
{
  protected static String nl;
  public static synchronized LinkItemSemanticEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LinkItemSemanticEditPolicyGenerator result = new LinkItemSemanticEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.commands.MSLDestroyElementCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyReferenceCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyReferenceRequest;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyReferenceCommand(DestroyReferenceRequest req) {" + NL + "\t\treturn getMSLWrapper(new DestroyReferenceCommand(req));" + NL + "\t}";
  protected final String TEXT_8 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDestroyElementCommand(DestroyElementRequest req) {" + NL + "\t\treturn getMSLWrapper(new MSLDestroyElementCommand(req));" + NL + "\t}";
  protected final String TEXT_9 = NL + "}";
  protected final String TEXT_10 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenLink genLink = (GenLink) argument;
GenDiagram genDiagram = genLink.getDiagram();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genLink.getItemSemanticEditPolicyClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getBaseItemSemanticEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    if (genLink.getModelFacet() instanceof FeatureModelFacet) {
    stringBuffer.append(TEXT_7);
    } else if (genLink.getModelFacet() instanceof TypeLinkModelFacet) {
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}

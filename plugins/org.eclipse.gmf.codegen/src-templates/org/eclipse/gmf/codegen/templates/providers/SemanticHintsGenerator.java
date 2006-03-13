package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_8 = "() {}";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ";
  protected final String TEXT_10 = " = \"";
  protected final String TEXT_11 = "SemanticHint\";";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_13 = "Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_14 = "Labels() {}";
  protected final String TEXT_15 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_16 = " = \"";
  protected final String TEXT_17 = "SemanticHint\";";
  protected final String TEXT_18 = NL + "\t}";
  protected final String TEXT_19 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_20 = "Compartments {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_21 = "Compartments() {}";
  protected final String TEXT_22 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_23 = " = \"";
  protected final String TEXT_24 = "SemanticHint\";";
  protected final String TEXT_25 = NL + "\t}";
  protected final String TEXT_26 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_27 = "Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_28 = "Labels() {}";
  protected final String TEXT_29 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_30 = " = \"";
  protected final String TEXT_31 = "SemanticHint\";";
  protected final String TEXT_32 = NL + "\t}";
  protected final String TEXT_33 = NL + "}";
  protected final String TEXT_34 = NL;

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
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getSemanticHintsClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getSemanticHintsClassName());
    stringBuffer.append(TEXT_8);
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenLink) {
		GenLink nextLink = (GenLink) next;
		if (nextLink.getModelFacet() instanceof FeatureModelFacet || nextLink.getModelFacet() == null) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_11);
    
		}
	}
	if (next instanceof GenNode) {
		GenNode genNode = (GenNode) next;
		List labels = genNode.getLabels();
		if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    
			for (int i = 0; i < labels.size(); i++) {
				GenNodeLabel label = (GenNodeLabel) labels.get(i);

    stringBuffer.append(TEXT_15);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_16);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_17);
    			}
    stringBuffer.append(TEXT_18);
    
		}
		List compartments = genNode.getCompartments();
		if (!compartments.isEmpty()) {

    stringBuffer.append(TEXT_19);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_21);
    
			for (int i = 0; i < compartments.size(); i++) {
				GenCompartment compartment = (GenCompartment) compartments.get(i);

    stringBuffer.append(TEXT_22);
    stringBuffer.append(compartment.getSemanticHintFieldName());
    stringBuffer.append(TEXT_23);
    stringBuffer.append(compartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    			}
    stringBuffer.append(TEXT_25);
    
		}
	} else if (next instanceof GenLink) {
		GenLink genLink = (GenLink) next;
		List labels = genLink.getLabels();
		if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_26);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    
			for (int i = 0; i < labels.size(); i++) {
				GenLinkLabel label = (GenLinkLabel) labels.get(i);

    stringBuffer.append(TEXT_29);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_31);
    			}
    stringBuffer.append(TEXT_32);
    
		}
	}
}

    stringBuffer.append(TEXT_33);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_34);
    return stringBuffer.toString();
  }
}

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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_4 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_5 = "() {}";
  protected final String TEXT_6 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ";
  protected final String TEXT_7 = " = \"";
  protected final String TEXT_8 = "Link\";";
  protected final String TEXT_9 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_10 = "Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_11 = "Labels() {}";
  protected final String TEXT_12 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_13 = " = \"";
  protected final String TEXT_14 = "Label\";" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_15 = " = \"";
  protected final String TEXT_16 = "Text\";";
  protected final String TEXT_17 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_18 = " = \"";
  protected final String TEXT_19 = "Text\";";
  protected final String TEXT_20 = NL + "\t}";
  protected final String TEXT_21 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_22 = "Compartments {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_23 = "Compartments() {}";
  protected final String TEXT_24 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_25 = " = \"";
  protected final String TEXT_26 = "\";";
  protected final String TEXT_27 = NL + "\t}";
  protected final String TEXT_28 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_29 = "Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_30 = "Labels() {}";
  protected final String TEXT_31 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_32 = " = \"";
  protected final String TEXT_33 = "Label\";" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_34 = " = \"";
  protected final String TEXT_35 = "Text\";";
  protected final String TEXT_36 = NL + "\t}";
  protected final String TEXT_37 = NL + "}";
  protected final String TEXT_38 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getSemanticHintsClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getSemanticHintsClassName());
    stringBuffer.append(TEXT_5);
    
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	if (next instanceof GenLink && ((GenLink) next).getModelFacet() instanceof FeatureModelFacet) {
		GenLink nextLink = (GenLink) next;

    stringBuffer.append(TEXT_6);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(nextLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_8);
    
	}
	if (next instanceof GenNode) {
		GenNode genNode = (GenNode) next;
		List labels = genNode.getLabels();
		if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_9);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_11);
    
			for (int i = 0; i < labels.size(); i++) {
				GenNodeLabel label = (GenNodeLabel) labels.get(i);
				if (label instanceof GenExternalNodeLabel) {

    stringBuffer.append(TEXT_12);
    stringBuffer.append(((GenExternalNodeLabel) label).getSemanticHintLabelFieldName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_15);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_16);
    				} else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_19);
    
				}
			}

    stringBuffer.append(TEXT_20);
    
		}
		List compartments = genNode.getCompartments();
		if (!compartments.isEmpty()) {

    stringBuffer.append(TEXT_21);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_23);
    
			for (int i = 0; i < compartments.size(); i++) {
				GenCompartment compartment = (GenCompartment) compartments.get(i);

    stringBuffer.append(TEXT_24);
    stringBuffer.append(compartment.getSemanticHintFieldName());
    stringBuffer.append(TEXT_25);
    stringBuffer.append(compartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_26);
    
			}

    stringBuffer.append(TEXT_27);
    
		}
	} else if (next instanceof GenLink) {
		GenLink genLink = (GenLink) next;
		List labels = genLink.getLabels();
		if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_28);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_30);
    
			for (int i = 0; i < labels.size(); i++) {
				GenLinkLabel label = (GenLinkLabel) labels.get(i);

    stringBuffer.append(TEXT_31);
    stringBuffer.append(label.getSemanticHintLabelFieldName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_35);
    			}
    stringBuffer.append(TEXT_36);
    
		}
	}
}

    stringBuffer.append(TEXT_37);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_38);
    return stringBuffer.toString();
  }
}

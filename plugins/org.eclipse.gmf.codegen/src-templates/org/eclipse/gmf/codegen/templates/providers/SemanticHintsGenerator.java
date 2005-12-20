package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
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
  protected final String TEXT_14 = "Text\";";
  protected final String TEXT_15 = NL + "\t}";
  protected final String TEXT_16 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_17 = "Compartments {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_18 = "Compartments() {}";
  protected final String TEXT_19 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_20 = " = \"";
  protected final String TEXT_21 = "\";";
  protected final String TEXT_22 = NL + "\t}";
  protected final String TEXT_23 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class ";
  protected final String TEXT_24 = "Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate ";
  protected final String TEXT_25 = "Labels() {}";
  protected final String TEXT_26 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_27 = " = \"";
  protected final String TEXT_28 = "Label\";" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_29 = " = \"";
  protected final String TEXT_30 = "Text\";";
  protected final String TEXT_31 = NL + "\t}";
  protected final String TEXT_32 = NL + "}";
  protected final String TEXT_33 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
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

    stringBuffer.append(TEXT_12);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_14);
    			}
    stringBuffer.append(TEXT_15);
    
		}
		List compartments = genNode.getCompartments();
		if (!compartments.isEmpty()) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genNode.getUniqueIdentifier());
    stringBuffer.append(TEXT_18);
    
			for (int i = 0; i < compartments.size(); i++) {
				GenCompartment compartment = (GenCompartment) compartments.get(i);

    stringBuffer.append(TEXT_19);
    stringBuffer.append(compartment.getSemanticHintFieldName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(compartment.getUniqueIdentifier());
    stringBuffer.append(TEXT_21);
    
			}

    stringBuffer.append(TEXT_22);
    
		}
	} else if (next instanceof GenLink) {
		GenLink genLink = (GenLink) next;
		List labels = genLink.getLabels();
		if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_23);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(genLink.getUniqueIdentifier());
    stringBuffer.append(TEXT_25);
    
			for (int i = 0; i < labels.size(); i++) {
				GenLinkLabel label = (GenLinkLabel) labels.get(i);

    stringBuffer.append(TEXT_26);
    stringBuffer.append(label.getSemanticHintLabelFieldName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(label.getSemanticHintFieldName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(label.getUniqueIdentifier());
    stringBuffer.append(TEXT_30);
    			}
    stringBuffer.append(TEXT_31);
    
		}
	}
}

    stringBuffer.append(TEXT_32);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_33);
    return stringBuffer.toString();
  }
}

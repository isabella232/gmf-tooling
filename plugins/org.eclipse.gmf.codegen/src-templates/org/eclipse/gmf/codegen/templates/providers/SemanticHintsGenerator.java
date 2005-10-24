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
  protected final String TEXT_2 = ";" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_3 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_4 = "() {}";
  protected final String TEXT_5 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String VIEW_TYPE = \"";
  protected final String TEXT_6 = "Link\";";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Labels() {}";
  protected final String TEXT_8 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_9 = " = \"";
  protected final String TEXT_10 = "Text\";";
  protected final String TEXT_11 = NL + "\t}";
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Compartments {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Compartments() {}";
  protected final String TEXT_13 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_14 = " = \"";
  protected final String TEXT_15 = "\";";
  protected final String TEXT_16 = NL + "\t}";
  protected final String TEXT_17 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static class Labels {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tprivate Labels() {}";
  protected final String TEXT_18 = NL + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_19 = " = \"";
  protected final String TEXT_20 = "Label\";" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic static final String ";
  protected final String TEXT_21 = " = \"";
  protected final String TEXT_22 = "Text\";";
  protected final String TEXT_23 = NL + "\t}";
  protected final String TEXT_24 = NL + "}";
  protected final String TEXT_25 = NL;

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
    stringBuffer.append(AccessUtil.getSemanticHintsClassName(genElement));
    stringBuffer.append(TEXT_4);
    
if (genElement instanceof GenLink && ((GenLink) genElement).getModelFacet() instanceof FeatureModelFacet) {
	FeatureModelFacet modelFacet = (FeatureModelFacet) ((GenLink) genElement).getModelFacet();

    stringBuffer.append(TEXT_5);
    stringBuffer.append(modelFacet.getMetaFeature().getName());
    stringBuffer.append(TEXT_6);
    
}
if (genElement instanceof GenNode) {
	GenNode genNode = (GenNode) genElement;
	List labels = genNode.getLabels();
	if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_7);
    
		for (int i = 0; i < labels.size(); i++) {
			GenNodeLabel label = (GenNodeLabel) labels.get(i);

    stringBuffer.append(TEXT_8);
    stringBuffer.append(AccessUtil.getLabelTextId(label));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(label.getMetaFeature().getName());
    stringBuffer.append(TEXT_10);
    		}
    stringBuffer.append(TEXT_11);
    
	}
	List compartments = genNode.getChildContainers();
	if (!compartments.isEmpty()) {

    stringBuffer.append(TEXT_12);
    
		for (int i = 0; i < compartments.size(); i++) {
			GenChildContainer compartment = (GenChildContainer) compartments.get(i);
			String id = AccessUtil.getCompartmentId(compartment);
			if (id != null && id.length() > 0) {

    stringBuffer.append(TEXT_13);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(compartment.getGroupID());
    stringBuffer.append(TEXT_15);
    
			}
		}

    stringBuffer.append(TEXT_16);
    
	}
} else if (genElement instanceof GenLink) {
	GenLink genLink = (GenLink) genElement;
	List labels = genLink.getLabels();
	if (!labels.isEmpty()) {

    stringBuffer.append(TEXT_17);
    
		for (int i = 0; i < labels.size(); i++) {
			GenLinkLabel label = (GenLinkLabel) labels.get(i);

    stringBuffer.append(TEXT_18);
    stringBuffer.append(AccessUtil.getLabelId(label));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(label.getMetaFeature().getName());
    stringBuffer.append(TEXT_20);
    stringBuffer.append(AccessUtil.getLabelTextId(label));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(label.getMetaFeature().getName());
    stringBuffer.append(TEXT_22);
    		}
    stringBuffer.append(TEXT_23);
    
	}
}

    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.providers;

import java.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ParserProviderGenerator
{
  protected static String nl;
  public static synchronized ParserProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ParserProviderGenerator result = new ParserProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractProvider implements IParserProvider {";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IParser ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IParser get";
  protected final String TEXT_9 = "() {" + NL + "\t\tif (";
  protected final String TEXT_10 = " == null) {" + NL + "\t\t\t";
  protected final String TEXT_11 = " = create";
  protected final String TEXT_12 = "();" + NL + "\t\t}" + NL + "\t\treturn ";
  protected final String TEXT_13 = ";" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParser create";
  protected final String TEXT_14 = "() {";
  protected final String TEXT_15 = NL + "\t\t";
  protected final String TEXT_16 = " parser = new ";
  protected final String TEXT_17 = "(";
  protected final String TEXT_18 = ".eINSTANCE.get";
  protected final String TEXT_19 = "().getEStructuralFeature(\"";
  protected final String TEXT_20 = "\"));";
  protected final String TEXT_21 = NL + "\t\t";
  protected final String TEXT_22 = " features = new ";
  protected final String TEXT_23 = "(";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t\tfeatures.add(";
  protected final String TEXT_26 = ".eINSTANCE.get";
  protected final String TEXT_27 = "().getEStructuralFeature(\"";
  protected final String TEXT_28 = "\"));";
  protected final String TEXT_29 = NL + "\t\t";
  protected final String TEXT_30 = " parser = new ";
  protected final String TEXT_31 = "(features);";
  protected final String TEXT_32 = NL + "\t\tparser.setViewPattern(\"";
  protected final String TEXT_33 = "\");";
  protected final String TEXT_34 = NL + "\t\tparser.setEditPattern(\"";
  protected final String TEXT_35 = "\");";
  protected final String TEXT_36 = NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_37 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParser getParser(int visualID) {" + NL + "\t\tswitch (visualID) {";
  protected final String TEXT_38 = NL + "\t\t\tcase ";
  protected final String TEXT_39 = ".VISUAL_ID:" + NL + "\t\t\t\treturn get";
  protected final String TEXT_40 = "();";
  protected final String TEXT_41 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParser getParser(IAdaptable hint) {" + NL + "\t\tString vid = (String) hint.getAdapter(String.class);" + NL + "\t\tif (vid != null) {" + NL + "\t\t\treturn getParser(";
  protected final String TEXT_42 = ".getVisualID(vid));" + NL + "\t\t}" + NL + "\t\tView view = (View) hint.getAdapter(View.class);" + NL + "\t\tif (view != null) {" + NL + "\t\t\treturn getParser(";
  protected final String TEXT_43 = ".getVisualID(view));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetParserOperation) {" + NL + "\t\t\tIAdaptable hint = ((GetParserOperation) operation).getHint();" + NL + "\t\t\tif (";
  protected final String TEXT_44 = ".getElement(hint) == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\treturn getParser(hint) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_45 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getParserProviderClassName());
    stringBuffer.append(TEXT_6);
    
Map labelMethodNames = new LinkedHashMap(); // GenCommonBase -> String
for (Iterator contents = genDiagram.eAllContents(); contents.hasNext(); ) {
	Object next = contents.next();
	GenCommonBase genHost, genLabel;
	LabelModelFacet modelFacet;
	if (next instanceof GenLabel) {
		genLabel = (GenCommonBase) next;
		if (genLabel instanceof GenNodeLabel) {
			genHost = ((GenNodeLabel) genLabel).getNode();
		} else if (genLabel instanceof GenLinkLabel) {
			genHost = ((GenLinkLabel) genLabel).getLink();
		} else {
			throw new IllegalArgumentException("Unknown label type: " + genLabel);
		}
		modelFacet = ((GenLabel) genLabel).getModelFacet();
	} else if (next instanceof GenChildLabelNode) {
		genLabel = (GenCommonBase) next;
		genHost = genLabel;
		modelFacet = ((GenChildLabelNode) genLabel).getLabelModelFacet();
	} else {
		continue; // not a label
	}
	if (modelFacet == null) {
		continue; // custom parser
	}
	String baseName = genHost.getClassNamePrefix() + genLabel.getUniqueIdentifier();
	char c = baseName.charAt(0);
	baseName = baseName.substring(1) + "Parser";
	String fieldName = Character.toLowerCase(c) + baseName;
	String methodName = Character.toUpperCase(c) + baseName;
	labelMethodNames.put(genLabel, methodName);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(fieldName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(methodName);
    stringBuffer.append(TEXT_14);
    
		String parserClassName;
		String viewPattern;
		String editPattern;
		if (modelFacet instanceof FeatureLabelModelFacet) {
			parserClassName = importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName());
			GenFeature genFeature = ((FeatureLabelModelFacet) modelFacet).getMetaFeature();
			viewPattern = ((FeatureLabelModelFacet) modelFacet).getViewPattern();
			editPattern = ((FeatureLabelModelFacet) modelFacet).getEditPattern();
			String semanticPackageInterfaceName = importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_19);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_20);
    
		} else if (modelFacet instanceof CompositeFeatureLabelModelFacet) {
			parserClassName = importManager.getImportedName(genDiagram.getStructuralFeaturesParserQualifiedClassName());
			List features = ((CompositeFeatureLabelModelFacet) modelFacet).getMetaFeatures();
			viewPattern = ((CompositeFeatureLabelModelFacet) modelFacet).getViewPattern();
			editPattern = ((CompositeFeatureLabelModelFacet) modelFacet).getEditPattern();

    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_23);
    stringBuffer.append(features.size());
    stringBuffer.append(TEXT_24);
    
			for (java.util.Iterator it = features.iterator(); it.hasNext(); ) {
				GenFeature genFeature = (GenFeature) it.next();
				String semanticPackageInterfaceName = importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_25);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(genFeature.getGenClass().getClassifierAccessorName());
    stringBuffer.append(TEXT_27);
    stringBuffer.append(genFeature.getName());
    stringBuffer.append(TEXT_28);
    			}
    stringBuffer.append(TEXT_29);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_31);
    
		} else {
			throw new IllegalArgumentException("Unknown label model facet: " + modelFacet);
		}
		if (viewPattern != null && viewPattern.length() != 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_33);
    
		}
		if (editPattern == null || editPattern.length() == 0) {
			editPattern = viewPattern;
		}
		if (editPattern != null && editPattern.length() != 0) {

    stringBuffer.append(TEXT_34);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_35);
    		}
    stringBuffer.append(TEXT_36);
    }
    stringBuffer.append(TEXT_37);
    
for (Iterator it = labelMethodNames.keySet().iterator(); it.hasNext(); ) {
	GenCommonBase genLabel = (GenCommonBase) it.next();

    stringBuffer.append(TEXT_38);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_39);
    stringBuffer.append(labelMethodNames.get(genLabel));
    stringBuffer.append(TEXT_40);
    }
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_43);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_44);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_45);
    return stringBuffer.toString();
  }
}

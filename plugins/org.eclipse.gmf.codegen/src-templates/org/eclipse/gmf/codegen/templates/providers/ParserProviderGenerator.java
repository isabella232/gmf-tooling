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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
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
  protected final String TEXT_19 = "());";
  protected final String TEXT_20 = NL + "\t\t";
  protected final String TEXT_21 = " features = new ";
  protected final String TEXT_22 = "(";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "\t\tfeatures.add(";
  protected final String TEXT_25 = ".eINSTANCE.get";
  protected final String TEXT_26 = "());";
  protected final String TEXT_27 = NL + "\t\t";
  protected final String TEXT_28 = " parser = new ";
  protected final String TEXT_29 = "(features);";
  protected final String TEXT_30 = NL + "\t\tparser.setViewPattern(\"";
  protected final String TEXT_31 = "\");";
  protected final String TEXT_32 = NL + "\t\tparser.setEditPattern(\"";
  protected final String TEXT_33 = "\");";
  protected final String TEXT_34 = NL + "\t\treturn parser;" + NL + "\t}";
  protected final String TEXT_35 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParser getParser(int visualID) {" + NL + "\t\tswitch (visualID) {";
  protected final String TEXT_36 = NL + "\t\t\tcase ";
  protected final String TEXT_37 = ".VISUAL_ID:" + NL + "\t\t\t\treturn get";
  protected final String TEXT_38 = "();";
  protected final String TEXT_39 = NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParser getParser(IAdaptable hint) {" + NL + "\t\tString vid = (String) hint.getAdapter(String.class);" + NL + "\t\tif (vid != null) {" + NL + "\t\t\treturn getParser(";
  protected final String TEXT_40 = ".getVisualID(vid));" + NL + "\t\t}" + NL + "\t\tView view = (View) hint.getAdapter(View.class);" + NL + "\t\tif (view != null) {" + NL + "\t\t\treturn getParser(";
  protected final String TEXT_41 = ".getVisualID(view));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetParserOperation) {" + NL + "\t\t\tIAdaptable hint = ((GetParserOperation) operation).getHint();" + NL + "\t\t\tif (";
  protected final String TEXT_42 = ".getElement(hint) == null) {" + NL + "\t\t\t\treturn false;" + NL + "\t\t\t}" + NL + "\t\t\treturn getParser(hint) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_43 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
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
	if (!(modelFacet instanceof FeatureLabelModelFacet)) {
		continue; // custom parser
	}
	String baseName = genLabel.getUniqueIdentifier();
	if (genHost.getClassNamePrefix() != null && genHost.getClassNamePrefix().length() > 0) {
		baseName = genHost.getClassNamePrefix() + baseName;
	}
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
		String viewPattern = ((FeatureLabelModelFacet) modelFacet).getViewPattern();
		String editPattern = ((FeatureLabelModelFacet) modelFacet).getEditPattern();
		List<GenFeature> features = ((FeatureLabelModelFacet) modelFacet).getMetaFeatures();
		if (features.size() == 1) {
			parserClassName = importManager.getImportedName(genDiagram.getStructuralFeatureParserQualifiedClassName());
			GenFeature genFeature = features.get(0);
			String semanticPackageInterfaceName = importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_15);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_19);
    
		} else {
			parserClassName = importManager.getImportedName(genDiagram.getStructuralFeaturesParserQualifiedClassName());

    stringBuffer.append(TEXT_20);
    stringBuffer.append(importManager.getImportedName("java.util.List"));
    stringBuffer.append(TEXT_21);
    stringBuffer.append(importManager.getImportedName("java.util.ArrayList"));
    stringBuffer.append(TEXT_22);
    stringBuffer.append(features.size());
    stringBuffer.append(TEXT_23);
    
			for (GenFeature genFeature : features) {
				String semanticPackageInterfaceName = importManager.getImportedName(genFeature.getGenPackage().getQualifiedPackageInterfaceName());

    stringBuffer.append(TEXT_24);
    stringBuffer.append(semanticPackageInterfaceName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(genFeature.getFeatureAccessorName());
    stringBuffer.append(TEXT_26);
    			}
    stringBuffer.append(TEXT_27);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(parserClassName);
    stringBuffer.append(TEXT_29);
    
		}
		if (viewPattern != null && viewPattern.length() != 0) {

    stringBuffer.append(TEXT_30);
    stringBuffer.append(viewPattern);
    stringBuffer.append(TEXT_31);
    
		}
		if (editPattern == null || editPattern.length() == 0) {
			editPattern = viewPattern;
		}
		if (editPattern != null && editPattern.length() != 0) {

    stringBuffer.append(TEXT_32);
    stringBuffer.append(editPattern);
    stringBuffer.append(TEXT_33);
    		}
    stringBuffer.append(TEXT_34);
    }
    stringBuffer.append(TEXT_35);
    
for (Iterator it = labelMethodNames.keySet().iterator(); it.hasNext(); ) {
	GenCommonBase genLabel = (GenCommonBase) it.next();

    stringBuffer.append(TEXT_36);
    stringBuffer.append(importManager.getImportedName(genLabel.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_37);
    stringBuffer.append(labelMethodNames.get(genLabel));
    stringBuffer.append(TEXT_38);
    }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_40);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_41);
    stringBuffer.append(importManager.getImportedName(genDiagram.getElementTypesQualifiedClassName()));
    stringBuffer.append(TEXT_42);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_43);
    return stringBuffer.toString();
  }
}

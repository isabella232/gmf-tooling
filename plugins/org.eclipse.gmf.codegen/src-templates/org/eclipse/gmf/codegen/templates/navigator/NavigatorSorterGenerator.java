package org.eclipse.gmf.codegen.templates.navigator;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;
import java.util.*;

public class NavigatorSorterGenerator
{
  protected static String nl;
  public static synchronized NavigatorSorterGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    NavigatorSorterGenerator result = new NavigatorSorterGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tprivate static final int GROUP_CATEGORY = ";
  protected final String TEXT_8 = ";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */\t" + NL + "\tpublic int category(Object element) {" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_9 = ") {" + NL + "\t\t\t";
  protected final String TEXT_10 = " item = (";
  protected final String TEXT_11 = ") element;" + NL + "\t\t\tif (";
  protected final String TEXT_12 = ".MODEL_ID.equals(item.getModelID())) {" + NL + "\t\t\t\treturn item.getVisualID();" + NL + "\t\t\t}\t" + NL + "\t\t}" + NL + "\t\treturn GROUP_CATEGORY;" + NL + "\t}" + NL + "\t" + NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenNavigator genNavigator = (GenNavigator) ((Object[]) argument)[0];
GenDiagram genDiagram = genNavigator.getEditorGen().getDiagram();
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];

Collection commonBaseElements = new ArrayList(genDiagram.getAllContainers());
commonBaseElements.addAll(genDiagram.getLinks());
int groupVisualID = 0;
for (Iterator it = commonBaseElements.iterator(); it.hasNext();) {
	GenCommonBase nextCommonBase = (GenCommonBase) it.next();
	if (groupVisualID < nextCommonBase.getVisualID()) {
		groupVisualID = nextCommonBase.getVisualID();
	}
}
groupVisualID++;

/*Map visualID2CommonBase = new TreeMap();
for (Iterator it = commonBaseElements.iterator(); it.hasNext();) {
	GenCommonBase nextCommonBase = (GenCommonBase) it.next();
	if (genNavigator.getChildReferencesTo(nextCommonBase).size() > 0) {
		
	}
}*/


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
    stringBuffer.append(genNavigator.getSorterClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.ViewerSorter"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(groupVisualID);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(importManager.getImportedName(genNavigator.getNavigatorItemQualifiedClassName()));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_12);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}

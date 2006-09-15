package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class PropertySectionGenerator
{
  protected static String nl;
  public static synchronized PropertySectionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PropertySectionGenerator result = new PropertySectionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.ArrayList;" + NL + "import java.util.Iterator;" + NL + "" + NL + "import org.eclipse.ui.IWorkbenchPart;" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.common.notify.AdapterFactory;" + NL + "import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;" + NL + "import org.eclipse.emf.edit.provider.IItemPropertySource;" + NL + "import org.eclipse.emf.edit.ui.provider.PropertySource;" + NL + "import org.eclipse.jface.viewers.ISelection;" + NL + "import org.eclipse.jface.viewers.StructuredSelection;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " implements ";
  protected final String TEXT_8 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_9 = " getPropertySource(Object object) {" + NL + "\t\tif (object instanceof IPropertySource) {" + NL + "\t\t\treturn (IPropertySource) object;" + NL + "\t\t}" + NL + "\t\tAdapterFactory af = getAdapterFactory(object);" + NL + "\t\tif (af != null) {" + NL + "\t\t\tIItemPropertySource ips = (IItemPropertySource) af.adapt(object, IItemPropertySource.class);" + NL + "\t\t\tif (ips != null) {" + NL + "\t\t\t\treturn new PropertySource(object, ips);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (object instanceof IAdaptable) {" + NL + "\t\t\treturn (IPropertySource) ((IAdaptable) object).getAdapter(IPropertySource.class);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Modify/unwrap selection.  " + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object transformSelection(Object selected) {";
  protected final String TEXT_10 = NL + "\t\tif (selected instanceof ";
  protected final String TEXT_11 = ") {" + NL + "\t\t\tObject model = ((";
  protected final String TEXT_12 = ") selected).getModel();" + NL + "\t\t\treturn model instanceof ";
  protected final String TEXT_13 = " ? ((";
  protected final String TEXT_14 = ") model).getElement() : null;" + NL + "\t\t}" + NL + "\t\tif (selected instanceof ";
  protected final String TEXT_15 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_16 = ") selected).getElement();" + NL + "\t\t}";
  protected final String TEXT_17 = NL + "\t\treturn selected;" + NL + "\t}" + NL + "" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ";
  protected final String TEXT_18 = " getPropertySourceProvider() {" + NL + "\t\treturn this; " + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setInput(IWorkbenchPart part, ISelection selection) {" + NL + "\t\tif (selection.isEmpty() || false == selection instanceof StructuredSelection) {" + NL + "\t\t\tsuper.setInput(part, selection);" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tfinal StructuredSelection structuredSelection = ((StructuredSelection) selection);" + NL + "\t\tArrayList transformedSelection = new ArrayList(structuredSelection.size());" + NL + "\t\tfor (Iterator it = structuredSelection.iterator();  it.hasNext();) {" + NL + "\t\t\tObject r = transformSelection(it.next());" + NL + "\t\t\tif (r != null) {" + NL + "\t\t\t\ttransformedSelection.add(r);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tsuper.setInput(part, new StructuredSelection(transformedSelection));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected AdapterFactory getAdapterFactory(Object object) {" + NL + "\t\tif (getEditingDomain() instanceof AdapterFactoryEditingDomain) {" + NL + "\t\t\treturn ((AdapterFactoryEditingDomain) getEditingDomain()).getAdapterFactory();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";
  protected final String TEXT_19 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenCustomPropertyTab tab = (GenCustomPropertyTab) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = tab.getSheet().getEditorGen().getDiagram();

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
    stringBuffer.append(tab.getClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.diagram.ui.properties.sections.AdvancedPropertySection"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySourceProvider"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySource"));
    stringBuffer.append(TEXT_9);
    if ("domain".equals(tab.getID())) /*perhaps, override setInput should obey same condition?*/{
	final String epClassName = importManager.getImportedName("org.eclipse.gef.EditPart");
	final String viewClassName = importManager.getImportedName("org.eclipse.gmf.runtime.notation.View");
    stringBuffer.append(TEXT_10);
    stringBuffer.append(epClassName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(epClassName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(viewClassName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(viewClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(viewClassName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(viewClassName);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.ui.views.properties.IPropertySourceProvider"));
    stringBuffer.append(TEXT_18);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}

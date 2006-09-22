package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class SheetLabelProviderGenerator
{
  protected static String nl;
  public static synchronized SheetLabelProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    SheetLabelProviderGenerator result = new SheetLabelProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.viewers.IStructuredSelection;" + NL + "import org.eclipse.swt.graphics.Image;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "() {" + NL + "\t\t";
  protected final String TEXT_9 = "\t\tsuper(new ";
  protected final String TEXT_10 = "(";
  protected final String TEXT_11 = ".getInstance().getItemProvidersAdapterFactory()), null);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getText(Object element) {" + NL + "\t\tObject selected = unwrap(element); ";
  protected final String TEXT_12 = NL + "\t\tif (selected instanceof ";
  protected final String TEXT_13 = ") {" + NL + "\t\t\treturn ((";
  protected final String TEXT_14 = ") selected).getGroupName();" + NL + "\t\t}";
  protected final String TEXT_15 = NL + "\t\treturn super.getText(selected);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Image getImage(Object element) {" + NL + "\t\treturn super.getImage(unwrap(element));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Object unwrap(Object element) {" + NL + "\t\tif (element instanceof IStructuredSelection) {" + NL + "\t\t\treturn unwrap(((IStructuredSelection) element).getFirstElement());" + NL + "\t\t}" + NL + "\t\tif (element instanceof EditPart) {" + NL + "\t\t\treturn unwrapEditPart((EditPart) element);" + NL + "\t\t}" + NL + "\t\tif (element instanceof ";
  protected final String TEXT_16 = ") {" + NL + "\t\t\t";
  protected final String TEXT_17 = " view = (";
  protected final String TEXT_18 = ") ((";
  protected final String TEXT_19 = ") element).getAdapter(";
  protected final String TEXT_20 = ".class);" + NL + "\t\t\tif (view != null) {" + NL + "\t\t\t\treturn unwrapView(view);" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn element;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Object unwrapEditPart(EditPart p) {" + NL + "\t\tif (p.getModel() instanceof View) {" + NL + "\t\t\treturn unwrapView((View) p.getModel());" + NL + "\t\t}" + NL + "\t\treturn p.getModel();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate Object unwrapView(View view) {" + NL + "\t\treturn view.getElement() == null ? view : view.getElement();" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPropertySheet propSheet = (GenPropertySheet) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenDiagram genDiagram = propSheet.getEditorGen().getDiagram(); // FIXME fix copyright inc to use editorGen

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
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.jface.viewers.DecoratingLabelProvider"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getCompilationUnitName());
    stringBuffer.append(TEXT_8);
    
		final String delegate = importManager.getImportedName("org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider");
		final String pluginActivator = importManager.getImportedName(propSheet.getEditorGen().getPlugin().getActivatorQualifiedClassName());

    stringBuffer.append(TEXT_9);
    stringBuffer.append(delegate);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(pluginActivator);
    stringBuffer.append(TEXT_11);
    if (genDiagram.getEditorGen().getNavigator() != null) {
    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getNavigator().getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getNavigator().getNavigatorGroupQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    }
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName("org.eclipse.core.runtime.IAdaptable"));
    stringBuffer.append(TEXT_19);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gmf.runtime.notation.View"));
    stringBuffer.append(TEXT_20);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}

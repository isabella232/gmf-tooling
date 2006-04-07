package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class LabelDirectEditPolicyGenerator
{
  protected static String nl;
  public static synchronized LabelDirectEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    LabelDirectEditPolicyGenerator result = new LabelDirectEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL + "" + NL + "import org.eclipse.draw2d.Label;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.editpolicies.DirectEditPolicy;" + NL + "import org.eclipse.gef.requests.DirectEditRequest;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;" + NL + "import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;" + NL + "import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import ";
  protected final String TEXT_6 = ".ITextAwareEditPart;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class LabelDirectEditPolicy extends DirectEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tclass EObjectAdapterEx" + NL + "\t\textends EObjectAdapter {" + NL + "" + NL + "\t\tprivate View view = null;" + NL + "" + NL + "\t\t/**" + NL + "\t\t * constructor" + NL + "\t\t * @param element\telement to be wrapped" + NL + "\t\t * @param view\tview to be wrapped" + NL + "\t\t */" + NL + "\t\tpublic EObjectAdapterEx(EObject element, View view) {" + NL + "\t\t\tsuper(element);" + NL + "\t\t\tthis.view = view;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic Object getAdapter(Class adapter) {" + NL + "\t\t\tObject o = super.getAdapter(adapter);" + NL + "\t\t\tif (o != null)" + NL + "\t\t\t\treturn o;" + NL + "\t\t\tif (adapter.equals(View.class)) {" + NL + "\t\t\t\treturn view;" + NL + "\t\t\t}" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command getDirectEditCommand(DirectEditRequest edit) {" + NL + "\t\tif (edit.getCellEditor() instanceof TextCellEditorEx)" + NL + "\t\t\tif (!((TextCellEditorEx) edit.getCellEditor()).hasValueChanged())" + NL + "\t\t\t\treturn null;" + NL + "\t\t\t" + NL + "\t\tString labelText = (String) edit.getCellEditor().getValue();" + NL + "\t\t" + NL + "\t\t//for CellEditor, null is always returned for invalid values" + NL + "\t\tif (labelText == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tITextAwareEditPart compartment = (ITextAwareEditPart) getHost();" + NL + "\t\tView view = (View) compartment.getModel();" + NL + "\t\tEObjectAdapter elementAdapter = null ;" + NL + "\t\tif (view !=null)" + NL + "\t\t\telementAdapter = new EObjectAdapterEx(ViewUtil.resolveSemanticElement(view)," + NL + "\t\t\t\tview);" + NL + "\t\telse" + NL + "\t\t\telementAdapter = new EObjectAdapterEx((EObject)compartment.getModel()," + NL + "\t\t\t\tnull);" + NL + "\t\t// check to make sure an edit has occurred before returning a command." + NL + "\t\tString prevText = compartment.getParser().getEditString(elementAdapter," + NL + "\t\t\tcompartment.getParserOptions().intValue());" + NL + "\t\tif (!prevText.equals(labelText)) {" + NL + "\t\t\tICommand iCommand = " + NL + "\t\t\t\tcompartment.getParser().getParseCommand(elementAdapter, labelText, 0);" + NL + "\t\t\treturn new EtoolsProxyCommand(iCommand);" + NL + "\t\t}" + NL + "" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void showCurrentEditValue(DirectEditRequest request) {" + NL + "\t\tString value = (String) request.getCellEditor().getValue();" + NL + "\t\tif (getHostFigure() instanceof Label) {" + NL + "\t\t\t((Label) getHostFigure()).setText(value);" + NL + "\t\t} else {" + NL + "\t\t\t((WrapLabel) getHostFigure()).setText(value);" + NL + "\t\t}" + NL + "\t\tObject pdEditPolicy = getHost().getEditPolicy(";
  protected final String TEXT_8 = ".PRIMARY_DRAG_ROLE);" + NL + "\t\tif (pdEditPolicy instanceof ";
  protected final String TEXT_9 = ") {" + NL + "\t\t\t((";
  protected final String TEXT_10 = ") pdEditPolicy).refreshFeedback();" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_11 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getEditPoliciesPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getEditPartsPackageName());
    stringBuffer.append(TEXT_6);
    
ImportUtil importManager = new ImportUtil(genDiagram.getEditPartsPackageName());
importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.gef.EditPolicy"));
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName(genDiagram.getTextSelectionEditPolicyQualifiedClassName()));
    stringBuffer.append(TEXT_10);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_11);
    return stringBuffer.toString();
  }
}

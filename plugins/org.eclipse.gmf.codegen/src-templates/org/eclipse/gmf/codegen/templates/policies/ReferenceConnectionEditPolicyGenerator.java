package org.eclipse.gmf.codegen.templates.policies;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class ReferenceConnectionEditPolicyGenerator
{
  protected static String nl;
  public static synchronized ReferenceConnectionEditPolicyGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ReferenceConnectionEditPolicyGenerator result = new ReferenceConnectionEditPolicyGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gef.Request;" + NL + "import org.eclipse.gef.commands.Command;" + NL + "import org.eclipse.gef.commands.CompoundCommand;" + NL + "import org.eclipse.gef.commands.UnexecutableCommand;" + NL + "import org.eclipse.gef.editparts.AbstractConnectionEditPart;" + NL + "import org.eclipse.gef.editpolicies.ConnectionEditPolicy;" + NL + "import org.eclipse.gef.requests.GroupRequest;" + NL + "import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;" + NL + "import org.eclipse.gmf.runtime.diagram.ui.requests.GroupRequestViaKeyboard;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;" + NL + "import org.eclipse.gmf.runtime.notation.View;" + NL + "import org.eclipse.jface.dialogs.IDialogConstants;" + NL + "import org.eclipse.jface.dialogs.MessageDialogWithToggle;" + NL + "import org.eclipse.jface.preference.IPreferenceStore;" + NL + "import org.eclipse.jface.util.Assert;" + NL + "import org.eclipse.swt.widgets.Display;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ConnectionEditPolicy {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String DELETE_FROM_DIAGRAM_DLG_TITLE = DiagramUIMessages.PromptingDeleteAction_DeleteFromDiagramDialog_Title;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String DELETE_FROM_DIAGRAM_DLG_MESSAGE = DiagramUIMessages.PromptingDeleteAction_DeleteFromDiagramDialog_Message;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final String DELETE_FROM_MODEL_DLG_TOGGLE_LABEL = DiagramUIMessages.MessageDialogWithToggle_DoNotPromptAgainToggle_label;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected final Command getDeleteCommand(GroupRequest deleteRequest) {" + NL + "\t\tboolean isDeleteFromKeyBoard = deleteRequest instanceof GroupRequestViaKeyboard;" + NL + "\t\tif (shouldDeleteSemantic()) {" + NL + "\t\t\treturn createDeleteSemanticCommand(deleteRequest);" + NL + "\t\t} else {" + NL + "\t\t\tboolean proceedToDeleteView = true;" + NL + "\t\t\tif (isDeleteFromKeyBoard) {" + NL + "\t\t\t\tGroupRequestViaKeyboard groupRequestViaKeyboard = (GroupRequestViaKeyboard) deleteRequest;" + NL + "\t\t\t\tif (groupRequestViaKeyboard.isShowInformationDialog()) {" + NL + "\t\t\t\t\tproceedToDeleteView = showPrompt();" + NL + "\t\t\t\t\tgroupRequestViaKeyboard.setShowInformationDialog(false);" + NL + "\t\t\t\t\tif (!(proceedToDeleteView))" + NL + "\t\t\t\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t\treturn createDeleteViewCommand(deleteRequest);" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean shouldDeleteSemantic() {" + NL + "\t\tAssert.isTrue(getHost() instanceof AbstractConnectionEditPart);" + NL + "\t\tAbstractConnectionEditPart cep = (AbstractConnectionEditPart) getHost();" + NL + "\t\tboolean isCanonical = false;" + NL + "\t\tif (cep.getSource() != null)" + NL + "\t\t\tisCanonical = IsCanonical(cep.getSource());" + NL + "\t\tif (cep.getTarget() != null)" + NL + "\t\t\treturn isCanonical ? isCanonical : IsCanonical(cep.getTarget());" + NL + "\t\treturn isCanonical;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean IsCanonical(EditPart ep) {" + NL + "\t\tEditPart parent = ep.getParent();" + NL + "\t\treturn parent instanceof GraphicalEditPart ? ((GraphicalEditPart) parent).isCanonical() : false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command createDeleteViewCommand(GroupRequest deleteRequest) {" + NL + "\t\tTransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();" + NL + "\t\treturn new EtoolsProxyCommand(new DeleteCommand(editingDomain, (View) getHost().getModel()));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Command createDeleteSemanticCommand(GroupRequest deleteRequest) {" + NL + "\t\tTransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();" + NL + "\t\tEditCommandRequestWrapper semReq = new EditCommandRequestWrapper(new DestroyElementRequest(editingDomain, false), deleteRequest.getExtendedData());" + NL + "\t\tCommand semanticCmd = getHost().getCommand(semReq);" + NL + "\t\tif (semanticCmd != null && semanticCmd.canExecute()) {" + NL + "\t\t\tCompoundCommand cc = new CompoundCommand();" + NL + "\t\t\tcc.add(semanticCmd);" + NL + "\t\t\treturn cc;" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean showPrompt() {" + NL + "\t\tboolean prompt = ((IPreferenceStore) ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint().getPreferenceStore()).getBoolean(IPreferenceConstants.PREF_PROMPT_ON_DEL_FROM_DIAGRAM);" + NL + "\t\tif (prompt)" + NL + "\t\t\tif (showMessageDialog())" + NL + "\t\t\t\treturn true;" + NL + "\t\t\telse" + NL + "\t\t\t\treturn false;" + NL + "\t\treturn true;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate boolean showMessageDialog() {" + NL + "\t\tMessageDialogWithToggle dialog = MessageDialogWithToggle.openYesNoQuestion(Display.getCurrent().getActiveShell(), DELETE_FROM_DIAGRAM_DLG_TITLE, DELETE_FROM_DIAGRAM_DLG_MESSAGE," + NL + "\t\t\t\tDELETE_FROM_MODEL_DLG_TOGGLE_LABEL, false, (IPreferenceStore) ((IGraphicalEditPart) getHost()).getDiagramPreferencesHint().getPreferenceStore()," + NL + "\t\t\t\tIPreferenceConstants.PREF_PROMPT_ON_DEL_FROM_DIAGRAM);" + NL + "\t\tif (dialog.getReturnCode() == IDialogConstants.YES_ID)" + NL + "\t\t\treturn true;" + NL + "\t\telse" + NL + "\t\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic Command getCommand(Request request) {" + NL + "\t\tif (request instanceof GroupRequestViaKeyboard) {" + NL + "\t\t\treturn getDeleteCommand((GroupRequest) request);" + NL + "\t\t}" + NL + "\t\treturn super.getCommand(request);" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
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
    stringBuffer.append(genDiagram.getReferenceConnectionEditPolicyClassName());
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}

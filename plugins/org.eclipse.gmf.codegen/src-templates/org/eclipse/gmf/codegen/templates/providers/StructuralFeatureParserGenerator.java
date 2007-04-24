package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class StructuralFeatureParserGenerator
{
  protected static String nl;
  public static synchronized StructuralFeatureParserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    StructuralFeatureParserGenerator result = new StructuralFeatureParserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.text.FieldPosition;" + NL + "import java.text.MessageFormat;" + NL + "import java.util.Collections;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.emf.transaction.TransactionalEditingDomain;" + NL + "import org.eclipse.emf.transaction.util.TransactionUtil;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends ";
  protected final String TEXT_7 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final MessageFormat DEFAULT_PROCESSOR = new MessageFormat(\"{0}\"); //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EStructuralFeature feature;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_8 = "(EStructuralFeature feature) {" + NL + "\t\tthis.feature = feature;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getViewProcessor() {" + NL + "\t\tMessageFormat processor = super.getViewProcessor();" + NL + "\t\treturn processor == null ? DEFAULT_PROCESSOR : processor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getEditProcessor() {" + NL + "\t\tMessageFormat processor = super.getEditProcessor();" + NL + "\t\treturn processor == null ? DEFAULT_PROCESSOR : processor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getDomainElement(EObject element) {" + NL + "\t\treturn element;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\telement = getDomainElement(element);" + NL + "\t\treturn getStringByPattern(element, feature, processor);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getStringByPattern(EObject element, EStructuralFeature feature, MessageFormat processor) {" + NL + "\t\tObject value = element == null ? null : element.eGet(feature);" + NL + "\t\tvalue = getValidValue(feature, value);" + NL + "\t\treturn processor.format(new Object[] { value }, new StringBuffer(), new FieldPosition(0)).toString();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParserEditStatus validateNewValues(Object[] values) {" + NL + "\t\tif (values.length > 1) {" + NL + "\t\t\treturn ParserEditStatus.UNEDITABLE_STATUS;" + NL + "\t\t}" + NL + "\t\tObject value = values.length == 1 ? values[0] : null;" + NL + "\t\tvalue = getValidNewValue(feature, value);" + NL + "\t\tif (value instanceof InvalidValue) {" + NL + "\t\t\treturn new ParserEditStatus(";
  protected final String TEXT_9 = ".ID," + NL + "\t\t\t\tIParserEditStatus.UNEDITABLE, value.toString());" + NL + "\t\t}" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, Object[] values) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\telement = getDomainElement(element);" + NL + "\t\tif (element == null) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tTransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(element);" + NL + "\t\tif (editingDomain == null) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tObject value = values.length == 1 ? values[0] : null;" + NL + "\t\tICommand command = getModificationCommand(element, feature, value);" + NL + "\t\treturn new CompositeTransactionalCommand(editingDomain, command.getLabel(), Collections.singletonList(command));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isAffectingEvent(Object event, int flags) {" + NL + "\t\tif (event instanceof Notification) {" + NL + "\t\t\treturn isAffectingFeature(((Notification) event).getFeature());" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected boolean isAffectingFeature(Object eventFeature) {" + NL + "\t\treturn feature == eventFeature;" + NL + "\t}" + NL + "}";
  protected final String TEXT_10 = NL;

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
    stringBuffer.append(genDiagram.getStructuralFeatureParserClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getStructuralFeatureParserClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_10);
    return stringBuffer.toString();
  }
}

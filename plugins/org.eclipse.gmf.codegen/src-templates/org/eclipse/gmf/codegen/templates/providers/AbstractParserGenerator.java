package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

public class AbstractParserGenerator
{
  protected static String nl;
  public static synchronized AbstractParserGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    AbstractParserGenerator result = new AbstractParserGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.text.MessageFormat;" + NL + "import java.text.ParsePosition;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;" + NL + "import org.eclipse.jface.text.contentassist.IContentAssistProcessor;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_5 = " implements IParser {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String viewPattern;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MessageFormat viewProcessor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String editPattern;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate MessageFormat editProcessor;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getViewPattern() {" + NL + "\t\treturn viewPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getViewProcessor() {" + NL + "\t\treturn viewProcessor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setViewPattern(String viewPattern) {" + NL + "\t\tthis.viewPattern = viewPattern;" + NL + "\t\tviewProcessor = createViewProcessor(viewPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat createViewProcessor(String viewPattern) {" + NL + "\t\treturn new MessageFormat(viewPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditPattern() {" + NL + "\t\treturn editPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getEditProcessor() {" + NL + "\t\treturn editProcessor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setEditPattern(String editPattern) {" + NL + "\t\tthis.editPattern = editPattern;" + NL + "\t\teditProcessor = createEditProcessor(editPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat createEditProcessor(String editPattern) {" + NL + "\t\treturn new MessageFormat(editPattern);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getPrintString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getStringByPattern(adapter, flags, getViewPattern(), getViewProcessor());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getStringByPattern(adapter, flags, getEditPattern(), getEditProcessor());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected abstract String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParserEditStatus isValidEditString(IAdaptable element, String editString) {" + NL + "\t\tParsePosition pos = new ParsePosition(0);" + NL + "\t\tObject[] values = getEditProcessor().parse(editString, pos);" + NL + "\t\tif (values == null) {" + NL + "\t\t\treturn new ParserEditStatus(";
  protected final String TEXT_6 = ".ID," + NL + "\t\t\t\tIParserEditStatus.UNEDITABLE, \"Invalid input at \" + pos.getErrorIndex());" + NL + "\t\t}" + NL + "\t\treturn validateNewValues(values);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParserEditStatus validateNewValues(Object[] values) {" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {" + NL + "\t\tObject[] newValues = getEditProcessor().parse(newString, new ParsePosition(0));" + NL + "\t\tif (newValues == null || validateNewValues(newValues).getCode() != IParserEditStatus.EDITABLE) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\treturn getParseCommand(adapter, newValues);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected abstract ICommand getParseCommand(IAdaptable adapter, Object[] newValues);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IContentAssistProcessor getCompletionProcessor(IAdaptable element) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getModificationCommand(EObject element, EStructuralFeature feature, Object value) {" + NL + "\t\tSetRequest request = new SetRequest(element, feature, value);" + NL + "\t\treturn new SetValueCommand(request);" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getAbstractParserClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}

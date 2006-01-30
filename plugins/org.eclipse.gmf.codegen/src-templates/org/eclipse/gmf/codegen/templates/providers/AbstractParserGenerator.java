package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;

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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.text.MessageFormat;" + NL + "import java.text.ParseException;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.core.runtime.IProgressMonitor;" + NL + "import org.eclipse.gmf.runtime.common.core.command.CommandResult;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractModelCommand;" + NL + "import org.eclipse.jface.text.contentassist.IContentAssistProcessor;" + NL + "" + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public abstract class ";
  protected final String TEXT_3 = " implements IParser {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final Object[] NO_VALUES = new Object[0];" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String viewPattern;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String editPattern;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getViewPattern() {" + NL + "\t\treturn viewPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setViewPattern(String viewPattern) {" + NL + "\t\tthis.viewPattern = viewPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditPattern() {" + NL + "\t\treturn editPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setEditPattern(String editPattern) {" + NL + "\t\tthis.editPattern = editPattern;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getPrintString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getStringByPattern(adapter, flags, getViewPattern());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic String getEditString(IAdaptable adapter, int flags) {" + NL + "\t\treturn getStringByPattern(adapter, flags, getEditPattern());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected abstract String getStringByPattern(IAdaptable adapter, int flags, String pattern);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected Object[] getValuesFromEditString(String editString, String pattern) {" + NL + "\t\tObject[] values;" + NL + "\t\ttry {" + NL + "\t\t\tvalues = new MessageFormat(pattern).parse(editString);" + NL + "\t\t} catch (ParseException pe) {" + NL + "\t\t\tvalues = NO_VALUES;" + NL + "\t\t}" + NL + "\t\treturn values;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParserEditStatus isValidEditString(IAdaptable element, String editString) {" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IContentAssistProcessor getCompletionProcessor(IAdaptable element) {" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ICommand getModelCommand(ICommand semanticCommand) {" + NL + "\t\tfinal ICommand command = semanticCommand;" + NL + "\t\treturn new AbstractModelCommand(command.getLabel(), command.getAffectedObjects()) {" + NL + "" + NL + "\t\t\tprotected CommandResult doExecute(IProgressMonitor progressMonitor) {" + NL + "\t\t\t\tcommand.execute(progressMonitor);" + NL + "\t\t\t\treturn command.getCommandResult();" + NL + "\t\t\t}" + NL + "\t\t};" + NL + "\t}" + NL + "}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genDiagram.getAbstractParserClassName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}

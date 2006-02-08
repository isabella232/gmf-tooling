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
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import java.text.FieldPosition;" + NL + "import java.text.MessageFormat;" + NL + "import java.util.Collections;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeModelCommand;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static final MessageFormat DEFAULT_PROCESSOR = new MessageFormat(\"{0}\");" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EStructuralFeature feature;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(EStructuralFeature feature) {" + NL + "\t\tthis.feature = feature;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getViewProcessor() {" + NL + "\t\tMessageFormat processor = super.getViewProcessor();" + NL + "\t\treturn processor == null ? DEFAULT_PROCESSOR : processor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected MessageFormat getEditProcessor() {" + NL + "\t\tMessageFormat processor = super.getEditProcessor();" + NL + "\t\treturn processor == null ? DEFAULT_PROCESSOR : processor;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tObject value = element.eGet(feature);" + NL + "\t\tvalue = getValidValue(feature, value);" + NL + "\t\treturn processor.format(new Object[] { value }, new StringBuffer(), new FieldPosition(0)).toString();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected IParserEditStatus validateValues(Object[] values) {" + NL + "\t\tif (values.length > 1) {" + NL + "\t\t\treturn ParserEditStatus.UNEDITABLE_STATUS;" + NL + "\t\t}" + NL + "\t\tObject value = values.length == 1 ? values[0] : null;" + NL + "\t\tvalue = getValidNewValue(feature, value);" + NL + "\t\tif (value instanceof InvalidValue) {" + NL + "\t\t\treturn new ParserEditStatus(";
  protected final String TEXT_8 = ".ID," + NL + "\t\t\t\tIParserEditStatus.UNEDITABLE, value.toString());" + NL + "\t\t}" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, Object[] values) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tObject value = values.length == 1 ? values[0] : null;" + NL + "\t\tICommand command = getModificationCommand(element, feature, value);" + NL + "\t\treturn new CompositeModelCommand(command.getLabel(), Collections.singletonList(command));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isAffectingEvent(Object event, int flags) {" + NL + "\t\tif (event instanceof Notification) {" + NL + "\t\t\tif (feature == ((Notification) event).getFeature()) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_9 = NL;

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
    stringBuffer.append(genDiagram.getStructuralFeatureParserClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(importManager.getImportedName(genDiagram.getAbstractParserQualifiedClassName()));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getStructuralFeatureParserClassName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditorGen().getPlugin().getActivatorQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}

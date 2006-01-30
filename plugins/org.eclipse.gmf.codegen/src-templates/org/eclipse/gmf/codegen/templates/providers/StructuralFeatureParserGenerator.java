package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.*;

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
  protected final String TEXT_3 = NL + "import java.text.MessageFormat;" + NL + "" + NL + "import org.eclipse.core.runtime.IAdaptable;" + NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EStructuralFeature;" + NL + "import org.eclipse.gmf.runtime.common.core.command.ICommand;" + NL + "import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;" + NL + "import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends ";
  protected final String TEXT_6 = " {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate EStructuralFeature feature;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_7 = "(EStructuralFeature feature) {" + NL + "\t\tthis.feature = feature;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected String getStringByPattern(IAdaptable adapter, int flags, String pattern) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tObject value = element.eGet(feature);" + NL + "\t\tif (pattern == null) {" + NL + "\t\t\tpattern = \"{0}\";" + NL + "\t\t}" + NL + "\t\treturn MessageFormat.format(pattern, new Object[] { value });" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IParserEditStatus isValidEditString(IAdaptable element, String editString) {" + NL + "\t\treturn ParserEditStatus.EDITABLE_STATUS;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {" + NL + "\t\tEObject element = (EObject) adapter.getAdapter(EObject.class);" + NL + "\t\tString pattern = getEditPattern();" + NL + "\t\tif (pattern == null) {" + NL + "\t\t\tpattern = \"{0}\";" + NL + "\t\t}" + NL + "\t\tObject[] values = getValuesFromEditString(newString, pattern);" + NL + "\t\tif (values.length != 1) {" + NL + "\t\t\treturn UnexecutableCommand.INSTANCE;" + NL + "\t\t}" + NL + "\t\tSetRequest request = new SetRequest(element, feature, values[0]);" + NL + "\t\treturn getModelCommand(new SetValueCommand(request));" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean isAffectingEvent(Object event, int flags) {" + NL + "\t\tif (event instanceof Notification) {" + NL + "\t\t\tif (feature == ((Notification) event).getFeature()) {" + NL + "\t\t\t\treturn true;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "}";
  protected final String TEXT_8 = NL;

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
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}

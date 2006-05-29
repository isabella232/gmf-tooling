package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class PropertyProviderGenerator
{
  protected static String nl;
  public static synchronized PropertyProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PropertyProviderGenerator result = new PropertyProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/**" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.properties.GetPropertySourceOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.properties.ICompositePropertySource;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.properties.IPropertiesProvider;" + NL + "import org.eclipse.gmf.runtime.emf.ui.properties.providers.GenericEMFPropertiesProvider;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends GenericEMFPropertiesProvider implements IPropertiesProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetPropertySourceOperation) {" + NL + "\t\t\tObject object = ((GetPropertySourceOperation) operation).getObject();" + NL + "\t\t\treturn getSemanticElement(object) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICompositePropertySource getPropertySource(Object object) {" + NL + "\t\tEObject element = getSemanticElement(object);" + NL + "\t\tif (element != null) {" + NL + "\t\t\treturn super.getPropertySource(element);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSemanticElement(Object object) {" + NL + "\t\tView view = null;" + NL + "\t\tif (object instanceof View) {" + NL + "\t\t\tview = (View) object;" + NL + "\t\t} else if (object instanceof EditPart) {" + NL + "\t\t\tEditPart editPart = (EditPart) object;" + NL + "\t\t\tif (editPart.getModel() instanceof View) {" + NL + "\t\t\t\tview = (View) editPart.getModel();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (view != null && ";
  protected final String TEXT_7 = ".MODEL_ID.equals(";
  protected final String TEXT_8 = ".getModelID(view))) {" + NL + "\t\t\treturn view.getElement();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_9 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
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
    stringBuffer.append(genDiagram.getPropertyProviderClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName(genDiagram.getVisualIDRegistryQualifiedClassName()));
    stringBuffer.append(TEXT_8);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_9);
    return stringBuffer.toString();
  }
}

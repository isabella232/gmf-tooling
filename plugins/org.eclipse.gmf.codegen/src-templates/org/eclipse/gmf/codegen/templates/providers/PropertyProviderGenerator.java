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
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + "package ";
  protected final String TEXT_5 = ";" + NL;
  protected final String TEXT_6 = NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.gef.EditPart;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.properties.GetPropertySourceOperation;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.properties.ICompositePropertySource;" + NL + "import org.eclipse.gmf.runtime.common.ui.services.properties.IPropertiesProvider;" + NL + "import org.eclipse.gmf.runtime.emf.ui.properties.providers.GenericEMFPropertiesProvider;" + NL + "import org.eclipse.gmf.runtime.notation.View;";
  protected final String TEXT_7 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_8 = " extends GenericEMFPropertiesProvider implements IPropertiesProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetPropertySourceOperation) {" + NL + "\t\t\tObject object = ((GetPropertySourceOperation) operation).getObject();" + NL + "\t\t\treturn getSemanticElement(object) != null;" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ICompositePropertySource getPropertySource(Object object) {" + NL + "\t\tEObject element = getSemanticElement(object);" + NL + "\t\tif (element != null) {" + NL + "\t\t\treturn super.getPropertySource(element);" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected EObject getSemanticElement(Object object) {" + NL + "\t\tView view = null;" + NL + "\t\tif (object instanceof View) {" + NL + "\t\t\tview = (View) object;" + NL + "\t\t} else if (object instanceof EditPart) {" + NL + "\t\t\tEditPart editPart = (EditPart) object;" + NL + "\t\t\tif (editPart.getModel() instanceof View) {" + NL + "\t\t\t\tview = (View) editPart.getModel();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (view != null && \"";
  protected final String TEXT_9 = "\".equals(getModelID(view))) {" + NL + "\t\t\treturn view.getElement();" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "\t";
  protected final String TEXT_10 = NL;
  protected final String TEXT_11 = "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate String getModelID(View containerView) {" + NL + "\t\t";
  protected final String TEXT_12 = " annotation = containerView.getEAnnotation(\"ViewIdentifier\"); //$NON-NLS-1$" + NL + "\t\tif (annotation == null) {" + NL + "\t\t\treturn null;" + NL + "\t\t}" + NL + "\t\treturn (String) annotation.getDetails().get(\"modelID\"); //$NON-NLS-1$" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n * "));
    stringBuffer.append(TEXT_3);
    }
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_5);
    ImportUtil importManager = new ImportUtil(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_6);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getPropertyProviderClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getEditorGen().getModelID());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.EAnnotation"));
    stringBuffer.append(TEXT_12);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}

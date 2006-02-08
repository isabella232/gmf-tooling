package org.eclipse.gmf.codegen.templates.providers;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

public class MetamodelSupportProviderGenerator
{
  protected static String nl;
  public static synchronized MetamodelSupportProviderGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    MetamodelSupportProviderGenerator result = new MetamodelSupportProviderGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.emf.common.notify.Notification;" + NL + "import org.eclipse.emf.ecore.EClass;" + NL + "import org.eclipse.emf.ecore.EObject;" + NL + "import org.eclipse.emf.ecore.EPackage;" + NL + "import org.eclipse.emf.ecore.EReference;" + NL + "import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;" + NL + "import org.eclipse.gmf.runtime.common.core.service.IOperation;" + NL + "import org.eclipse.gmf.runtime.emf.core.services.metamodel.GetMetamodelSupportOperation;" + NL + "import org.eclipse.gmf.runtime.emf.core.services.metamodel.IMetamodelSupport;" + NL + "import org.eclipse.gmf.runtime.emf.core.services.metamodel.IMetamodelSupportProvider;" + NL + "import org.eclipse.gmf.runtime.notation.providers.internal.semproc.NotationSemProc;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends AbstractProvider implements IMetamodelSupportProvider {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IMetamodelSupport support;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IMetamodelSupport getMetamodelSupport(EPackage ePackage) {" + NL + "\t\tif (support == null) {" + NL + "\t\t\tsupport = new MetamodelSupportImpl();" + NL + "\t\t}" + NL + "\t\treturn support;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic boolean provides(IOperation operation) {" + NL + "\t\tif (operation instanceof GetMetamodelSupportOperation) {" + NL + "\t\t\treturn ";
  protected final String TEXT_6 = ".eINSTANCE == ((GetMetamodelSupportOperation) operation).getEPackage();" + NL + "\t\t}" + NL + "\t\treturn false;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic class MetamodelSupportImpl implements IMetamodelSupport {" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canDestroy(EObject eObject) {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic boolean canContain(EClass eContainer, EReference eReference, EClass eClass) {" + NL + "\t\t\treturn true;" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void handleEvent(Notification event) {" + NL + "\t\t\tNotationSemProc.handleEvent(event);" + NL + "\t\t}" + NL + "" + NL + "\t\t/**" + NL + "\t\t * @generated" + NL + "\t\t */" + NL + "\t\tpublic void postProcess(EObject root) {}" + NL + "\t}" + NL + "}";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram diagram = (GenDiagram) ((Object[]) argument)[0];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(diagram.getProvidersPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(diagram.getProvidersPackageName());
    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(diagram.getMetamodelSupportProviderClassName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(diagram.getMetaPackageName(importManager));
    stringBuffer.append(TEXT_6);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}

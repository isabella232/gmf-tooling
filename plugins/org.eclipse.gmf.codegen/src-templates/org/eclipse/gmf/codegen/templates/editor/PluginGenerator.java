package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.codegen.util.ImportUtil;

public class PluginGenerator
{
  protected static String nl;
  public static synchronized PluginGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginGenerator result = new PluginGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL;
  protected final String TEXT_3 = NL + "import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;" + NL + "import org.eclipse.gmf.runtime.emf.core.internal.util.MSLAdapterFactoryManager;" + NL + "import org.eclipse.gmf.runtime.emf.core.internal.util.MSLMetaModelManager;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.ui.plugin.AbstractUIPlugin;" + NL + "import org.osgi.framework.BundleContext;" + NL + "import ";
  protected final String TEXT_4 = ".ElementTypes;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractUIPlugin {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ID = \"";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EDITOR_ID = \"";
  protected final String TEXT_8 = "ID\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_9 = " ourInstance;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void start(BundleContext context) throws Exception {" + NL + "\t\tsuper.start(context);" + NL + "\t\tourInstance = this;" + NL + "\t\tPreferencesHint.registerPreferenceStore(new PreferencesHint(EDITOR_ID), getPreferenceStore());";
  protected final String TEXT_11 = NL + "\t\tMSLAdapterFactoryManager.register(new ";
  protected final String TEXT_12 = "());" + NL + "\t\tMSLMetaModelManager.register(";
  protected final String TEXT_13 = ".eINSTANCE, ";
  protected final String TEXT_14 = ".INSTANCE);" + NL + "\t\tElementTypes.register();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void stop(BundleContext context) throws Exception {" + NL + "\t\tourInstance = null;" + NL + "\t\tsuper.stop(context);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_15 = " getInstance() {" + NL + "\t\treturn ourInstance;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns an image descriptor for the image file at the given" + NL + "\t * plug-in relative path." + NL + "\t *" + NL + "\t * @generated" + NL + "\t * @param path the path" + NL + "\t * @return the image descriptor" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(String path) {" + NL + "\t\treturn AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);" + NL + "\t}" + NL + "}";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    GenDiagram genDiagram = (GenDiagram) argument;
    GenModel genModel = genDiagram.getEmfGenModel();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_2);
    ImportUtil importManager = new ImportUtil(genDiagram.getEditorPackageName());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genDiagram.getProvidersPackageName());
    stringBuffer.append(TEXT_4);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genDiagram.getPluginID());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genDiagram.getEditorQualifiedClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_10);
    
GenPackage genPackage = genDiagram.getEmfGenModel().findGenPackage(genDiagram.getDomainMetaModel());
String domainPackageIPAFInterfaceName = importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName());
String domainPackageInterfaceName = importManager.getImportedName(genPackage.getQualifiedPackageInterfaceName());
String domainPackageEditPluginClassName = importManager.getImportedName(genPackage.getQualifiedEditPluginClassName());

    stringBuffer.append(TEXT_11);
    stringBuffer.append(domainPackageIPAFInterfaceName);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(domainPackageInterfaceName);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(domainPackageEditPluginClassName);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(genDiagram.getPluginClassName());
    stringBuffer.append(TEXT_15);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.editor;

import java.util.*;
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
  protected final String TEXT_3 = NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "import org.eclipse.emf.edit.provider.ComposedAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.IItemLabelProvider;" + NL + "import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;" + NL + "import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;" + NL + "import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;" + NL + "import org.eclipse.gmf.runtime.emf.core.internal.util.MSLAdapterFactoryManager;" + NL + "import org.eclipse.gmf.runtime.emf.core.internal.util.MSLMetaModelManager;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.ui.plugin.AbstractUIPlugin;" + NL + "import org.osgi.framework.BundleContext;" + NL + "import ";
  protected final String TEXT_4 = ".ElementTypes;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractUIPlugin {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ID = \"";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String EDITOR_ID = \"";
  protected final String TEXT_8 = "ID\";" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_9 = " instance;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ComposedAdapterFactory adapterFactory;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void start(BundleContext context) throws Exception {" + NL + "\t\tsuper.start(context);" + NL + "\t\tinstance = this;" + NL + "\t\tPreferencesHint.registerPreferenceStore(new PreferencesHint(EDITOR_ID), getPreferenceStore());";
  protected final String TEXT_11 = NL + "\t\tMSLAdapterFactoryManager.register(new ";
  protected final String TEXT_12 = "());" + NL + "\t\tMSLMetaModelManager.register(";
  protected final String TEXT_13 = ".eINSTANCE, ";
  protected final String TEXT_14 = ".INSTANCE);" + NL + "\t\tElementTypes.register();" + NL + "\t\tadapterFactory = createAdapterFactory();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void stop(BundleContext context) throws Exception {" + NL + "\t\tadapterFactory.dispose();" + NL + "\t\tadapterFactory = null;" + NL + "\t\tinstance = null;" + NL + "\t\tsuper.stop(context);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_15 = " getInstance() {" + NL + "\t\treturn instance;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ComposedAdapterFactory createAdapterFactory() {" + NL + "\t\tList factories = new ArrayList();" + NL + "\t\tfillItemProviderFactories(factories);" + NL + "\t\treturn new ComposedAdapterFactory(factories);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillItemProviderFactories(List factories) {";
  protected final String TEXT_16 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_17 = "());";
  protected final String TEXT_18 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_19 = "());";
  protected final String TEXT_20 = NL + "\t\tfactories.add(new ResourceItemProviderAdapterFactory());" + NL + "\t\tfactories.add(new ReflectiveItemProviderAdapterFactory());" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ImageDescriptor getItemImageDescriptor(Object item) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {" + NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(item));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns an image descriptor for the image file at the given" + NL + "\t * plug-in relative path." + NL + "\t *" + NL + "\t * @generated" + NL + "\t * @param path the path" + NL + "\t * @return the image descriptor" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getImageDescriptor(String path) {" + NL + "\t\treturn AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);" + NL + "\t}" + NL + "}";
  protected final String TEXT_21 = NL;

  public String generate(Object argument)
  {
    StringBuffer stringBuffer = new StringBuffer();
    
GenDiagram genDiagram = (GenDiagram) argument;
GenModel genModel = genDiagram.getEMFGenModel();

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
    
GenPackage genPackage = genDiagram.getDomainMetaModel();
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
    
List genPackages = genModel.getAllGenPackagesWithClassifiers();
for (int i = 0; i < genPackages.size(); i++) {
	genPackage = (GenPackage) genPackages.get(i);
	if (genPackage.getGenModel().hasEditSupport()) {

    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_17);
    
	}
}
genPackages = genModel.getAllUsedGenPackagesWithClassifiers();
for (int i = 0; i < genPackages.size(); i++) {
	genPackage = (GenPackage) genPackages.get(i);
	if (genPackage.getGenModel().hasEditSupport()) {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_19);
    
	}
}

    stringBuffer.append(TEXT_20);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_21);
    return stringBuffer.toString();
  }
}

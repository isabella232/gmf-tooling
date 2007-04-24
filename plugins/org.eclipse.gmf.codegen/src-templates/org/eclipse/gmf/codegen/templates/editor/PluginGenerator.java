package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.emf.common.util.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.gmf.common.codegen.*;

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
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " * ";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "" + NL + "import org.eclipse.core.runtime.IPath;" + NL + "import org.eclipse.core.runtime.IStatus;" + NL + "import org.eclipse.core.runtime.Path;" + NL + "import org.eclipse.core.runtime.Platform;" + NL + "import org.eclipse.core.runtime.Status;" + NL + "" + NL + "import org.eclipse.emf.common.notify.AdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.ComposedAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.IItemLabelProvider;" + NL + "import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;" + NL + "import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;" + NL + "import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;" + NL + "import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;" + NL + "import org.eclipse.jface.resource.ImageDescriptor;" + NL + "import org.eclipse.swt.graphics.Image;" + NL + "import org.eclipse.ui.plugin.AbstractUIPlugin;" + NL + "import org.osgi.framework.BundleContext;";
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " extends AbstractUIPlugin {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ID = \"";
  protected final String TEXT_7 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(ID);" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_8 = " instance;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ComposedAdapterFactory adapterFactory;\t" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_9 = " myDocumentProvider;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void start(BundleContext context) throws Exception {" + NL + "\t\tsuper.start(context);" + NL + "\t\tinstance = this;" + NL + "\t\tPreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());" + NL + "\t\tadapterFactory = createAdapterFactory();" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void stop(BundleContext context) throws Exception {" + NL + "\t\tadapterFactory.dispose();" + NL + "\t\tadapterFactory = null;" + NL + "\t\tinstance = null;" + NL + "\t\tsuper.stop(context);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_11 = " getInstance() {" + NL + "\t\treturn instance;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected ComposedAdapterFactory createAdapterFactory() {" + NL + "\t\tList factories = new ArrayList();" + NL + "\t\tfillItemProviderFactories(factories);" + NL + "\t\treturn new ComposedAdapterFactory(factories);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprotected void fillItemProviderFactories(List factories) {";
  protected final String TEXT_12 = NL + "\t\tfactories.add(new ";
  protected final String TEXT_13 = "());";
  protected final String TEXT_14 = NL + "\t\tfactories.add(new ResourceItemProviderAdapterFactory());" + NL + "\t\tfactories.add(new ReflectiveItemProviderAdapterFactory());" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic AdapterFactory getItemProvidersAdapterFactory() {" + NL + "\t\treturn adapterFactory;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ImageDescriptor getItemImageDescriptor(Object item) {" + NL + "\t\tIItemLabelProvider labelProvider = (IItemLabelProvider) adapterFactory.adapt(item, IItemLabelProvider.class);" + NL + "\t\tif (labelProvider != null) {";
  protected final String TEXT_15 = NL + "\t\t\treturn ExtendedImageRegistry.getInstance().getImageDescriptor(labelProvider.getImage(item));" + NL + "\t\t}" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns an image descriptor for the image file at the given" + NL + "\t * plug-in relative path." + NL + "\t *" + NL + "\t * @generated" + NL + "\t * @param path the path" + NL + "\t * @return the image descriptor" + NL + "\t */" + NL + "\tpublic static ImageDescriptor getBundledImageDescriptor(String path) {" + NL + "\t\treturn AbstractUIPlugin.imageDescriptorFromPlugin(ID, path);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Respects images residing in any plug-in. If path is relative," + NL + "\t * then this bundle is looked up for the image, otherwise, for absolute " + NL + "\t * path, first segment is taken as id of plug-in with image" + NL + "\t *" + NL + "\t * @generated" + NL + "\t * @param path the path to image, either absolute (with plug-in id as first segment), or relative for bundled images" + NL + "\t * @return the image descriptor" + NL + "\t */" + NL + "\tpublic static ImageDescriptor findImageDescriptor(String path) {" + NL + "\t\tfinal IPath p = new Path(path);" + NL + "\t\tif (p.isAbsolute() && p.segmentCount() > 1) {" + NL + "\t\t\treturn AbstractUIPlugin.imageDescriptorFromPlugin(p.segment(0), p.removeFirstSegments(1).makeAbsolute().toString());" + NL + "\t\t} else {" + NL + "\t\t\treturn getBundledImageDescriptor(p.makeAbsolute().toString());" + NL + "\t\t} " + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * Returns string from plug-in's resource bundle" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static String getString(String key) {" + NL + "\t\treturn Platform.getResourceString(getInstance().getBundle(), \"%\" + key); //$NON-NLS-1$" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Returns an image for the image file at the given plug-in relative path." + NL + "\t * Client do not need to dispose this image. Images will be disposed automatically." + NL + "\t *" + NL + "\t * @generated" + NL + "\t * @param path the path" + NL + "\t * @return image instance" + NL + "\t */" + NL + "\tpublic Image getBundledImage(String path) {" + NL + "\t\tImage image = getImageRegistry().get(path);" + NL + "\t\tif (image == null) {" + NL + "\t\t\tgetImageRegistry().put(path, getBundledImageDescriptor(path));" + NL + "\t\t\timage = getImageRegistry().get(path);" + NL + "\t\t}" + NL + "\t\treturn image;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_16 = " getDocumentProvider() {" + NL + "\t\tif (myDocumentProvider == null) {" + NL + "\t\t\tmyDocumentProvider = new ";
  protected final String TEXT_17 = "();" + NL + "\t\t}" + NL + "\t\treturn myDocumentProvider;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void logError(String error) {" + NL + "\t\tlogError(error, null);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @param throwable actual error or null could be passed" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void logError(String error, Throwable throwable) {" + NL + "\t\tif (error == null && throwable != null) {" + NL + "\t\t\terror = throwable.getMessage();" + NL + "\t\t}" + NL + "\t\tgetLog().log(new Status(IStatus.ERROR, ";
  protected final String TEXT_18 = ".ID, IStatus.OK, error, throwable));" + NL + "\t\tdebug(error, throwable);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void logInfo(String message) {" + NL + "\t\tlogInfo(message, null);" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @param throwable actual error or null could be passed" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void logInfo(String message, Throwable throwable) {" + NL + "\t\tif (message == null && throwable != null) {" + NL + "\t\t\tmessage = throwable.getMessage();" + NL + "\t\t}" + NL + "\t\tgetLog().log(new Status(IStatus.INFO, ";
  protected final String TEXT_19 = ".ID, IStatus.OK, message, throwable));" + NL + "\t\tdebug(message, throwable);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate void debug(String message, Throwable throwable) {" + NL + "\t\tif (!isDebugging()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tif (message != null) {" + NL + "\t\t\tSystem.err.println(message);" + NL + "\t\t}" + NL + "\t\tif (throwable != null) {" + NL + "\t\t\tthrowable.printStackTrace();" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_20 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) ((Object[]) argument)[0];
final GenDiagram genDiagram = genPlugin.getEditorGen().getDiagram();
final EList genPackages = genPlugin.getEditorGen().getAllDomainGenPackages(true);
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
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDocumentProviderQualifiedClassName()));
    stringBuffer.append(TEXT_9);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_11);
    
for (int i = 0; i < genPackages.size(); i++) {
	GenPackage genPackage = (GenPackage) genPackages.get(i);

    stringBuffer.append(TEXT_12);
    stringBuffer.append(importManager.getImportedName(genPackage.getQualifiedItemProviderAdapterFactoryClassName()));
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    
			// XXX dependency org.eclipse.emf.edit.ui is for ExtendedImageRegistry only. 
			// FIXME move image registry to plugin class code

    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDocumentProviderQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    stringBuffer.append(importManager.getImportedName(genDiagram.getDocumentProviderQualifiedClassName()));
    stringBuffer.append(TEXT_17);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_18);
    stringBuffer.append(genPlugin.getActivatorClassName());
    stringBuffer.append(TEXT_19);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}

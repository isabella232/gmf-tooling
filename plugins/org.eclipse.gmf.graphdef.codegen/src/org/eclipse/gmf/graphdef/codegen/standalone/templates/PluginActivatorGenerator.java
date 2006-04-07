package org.eclipse.gmf.graphdef.codegen.standalone.templates;

import org.eclipse.gmf.graphdef.codegen.*;
import org.eclipse.gmf.common.codegen.ImportAssistant;

public class PluginActivatorGenerator
{
  protected static String nl;
  public static synchronized PluginActivatorGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    PluginActivatorGenerator result = new PluginActivatorGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "import org.eclipse.core.runtime.Plugin;" + NL;
  protected final String TEXT_2 = NL + "import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;" + NL + "import org.eclipse.gmf.runtime.draw2d.ui.mapmode.MapModeTypes;";
  protected final String TEXT_3 = NL + NL + "import org.osgi.framework.BundleContext;";
  protected final String TEXT_4 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " extends Plugin {" + NL;
  protected final String TEXT_6 = NL + "\tprivate IMapMode myMapMode = MapModeTypes.IDENTITY_MM;";
  protected final String TEXT_7 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static final String ID = \"";
  protected final String TEXT_8 = "\"; //$NON-NLS-1$" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate static ";
  protected final String TEXT_9 = " ourInstance;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic ";
  protected final String TEXT_10 = "() {" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void start(BundleContext context) throws Exception {" + NL + "\t\tsuper.start(context);" + NL + "\t\tif (ourInstance != null){" + NL + "\t\t\tthrow new IllegalStateException(\"Plugin: \" + ID + \" already started\");" + NL + "\t\t}" + NL + "\t\tourInstance = this;" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void stop(BundleContext context) throws Exception {" + NL + "\t\tif (ourInstance == null){" + NL + "\t\t\tthrow new IllegalStateException(\"Plugin: \" + ID + \" is not started\");" + NL + "\t\t}" + NL + "\t\tourInstance = null;" + NL + "\t\tsuper.stop(context);" + NL + "\t}" + NL + "\t";
  protected final String TEXT_11 = NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic void setMapMode(IMapMode mapMode) {" + NL + "\t\tmyMapMode = mapMode;" + NL + "\t\tif (myMapMode == null){" + NL + "\t\t\tmyMapMode = MapModeTypes.IDENTITY_MM;" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic IMapMode getMapMode() {" + NL + "\t\treturn myMapMode;" + NL + "\t}" + NL;
  protected final String TEXT_12 = NL + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tpublic static ";
  protected final String TEXT_13 = " getDefault() {" + NL + "\t\treturn ourInstance;" + NL + "\t}" + NL + "}";
  protected final String TEXT_14 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final Object[] passedArgs = (Object[]) argument;
final StandaloneGenerator.Config config = (StandaloneGenerator.Config) passedArgs[0];
final ImportAssistant importManager = (ImportAssistant) passedArgs[1];

importManager.emitPackageStatement(stringBuffer);

    stringBuffer.append(TEXT_1);
    
if (config.needsMapMode()){

    stringBuffer.append(TEXT_2);
    
}

    stringBuffer.append(TEXT_3);
    importManager.markImportLocation(stringBuffer);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(config.getPluginActivatorClassName());
    stringBuffer.append(TEXT_5);
    
if (config.needsMapMode()){

    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    stringBuffer.append(config.getPluginID());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(config.getPluginActivatorClassName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(config.getPluginActivatorClassName());
    stringBuffer.append(TEXT_10);
    
if (config.needsMapMode()){

    stringBuffer.append(TEXT_11);
    
}

    stringBuffer.append(TEXT_12);
    stringBuffer.append(config.getPluginActivatorClassName());
    stringBuffer.append(TEXT_13);
    importManager.emitSortedImports();
    stringBuffer.append(TEXT_14);
    return stringBuffer.toString();
  }
}

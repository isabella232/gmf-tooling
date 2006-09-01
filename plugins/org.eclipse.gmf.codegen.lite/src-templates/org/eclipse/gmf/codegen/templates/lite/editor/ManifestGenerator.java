package org.eclipse.gmf.codegen.templates.lite.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import java.util.*;

public class ManifestGenerator
{
  protected static String nl;
  public static synchronized ManifestGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    ManifestGenerator result = new ManifestGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Manifest-Version: 1.0" + NL + "Bundle-ManifestVersion: 2" + NL + "Bundle-Name: %pluginName" + NL + "Bundle-SymbolicName: ";
  protected final String TEXT_2 = "; singleton:=true" + NL + "Bundle-Version: ";
  protected final String TEXT_3 = NL + "Bundle-ClassPath: ." + NL + "Bundle-Activator: ";
  protected final String TEXT_4 = NL + "Bundle-Vendor: %providerName" + NL + "Bundle-Localization: plugin" + NL + "Export-Package: ";
  protected final String TEXT_5 = NL + "Require-Bundle: org.eclipse.core.runtime,";
  protected final String TEXT_6 = "org.eclipse.core.resources," + NL + " org.eclipse.ui.ide,";
  protected final String TEXT_7 = NL + " org.eclipse.jface," + NL + " org.eclipse.ui.views," + NL + " org.eclipse.ui.workbench," + NL + " org.eclipse.emf.ecore," + NL + " org.eclipse.emf.edit.ui," + NL + " org.eclipse.emf.workspace,";
  protected final String TEXT_8 = NL + " org.eclipse.gef;visibility:=reexport," + NL + " org.eclipse.gmf.runtime.lite," + NL + " org.eclipse.gmf.runtime.notation," + NL + " org.eclipse.gmf.runtime.notation.edit";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = NL + " ";
  protected final String TEXT_11 = ";visibility:=reexport";
  protected final String TEXT_12 = NL + "Eclipse-LazyStart: true";
  protected final String TEXT_13 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenModel genModel = genPlugin.getEditorGen().getDomainGenModel();
final Set requiredPluginIDs = new LinkedHashSet();
requiredPluginIDs.add(genModel.getModelPluginID());
requiredPluginIDs.add(genModel.getEditPluginID());

for (Iterator it = genModel.getAllUsedGenPackagesWithClassifiers().iterator(); it.hasNext();) {
	GenModel nextGenModel = ((GenPackage) it.next()).getGenModel();
	if (nextGenModel.hasEditSupport()) {
		requiredPluginIDs.add(nextGenModel.getModelPluginID());
		requiredPluginIDs.add(nextGenModel.getEditPluginID());
	}
}

requiredPluginIDs.addAll(genPlugin.getRequiredPluginIDs());
Iterator requiredBundleIterator = requiredPluginIDs.iterator();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getVersion());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genPlugin.getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPlugin.getEditorGen().getEditor().getPackageName());
    stringBuffer.append(TEXT_5);
    if (!genModel.isRichClientPlatform()) {
    stringBuffer.append(TEXT_6);
    }
    stringBuffer.append(TEXT_7);
    /*XXX: introduces dependency on org.eclipse.core.resources which may be problematic for RCP*/
    stringBuffer.append(TEXT_8);
    while(requiredBundleIterator.hasNext()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(requiredBundleIterator.next());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(TEXT_13);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.editor;

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
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = NL + " ";
  protected final String TEXT_7 = ",";
  protected final String TEXT_8 = NL + " ";
  protected final String TEXT_9 = NL + "Require-Bundle: org.eclipse.core.runtime,";
  protected final String TEXT_10 = NL + " org.eclipse.core.resources,";
  protected final String TEXT_11 = NL + " org.eclipse.core.expressions,";
  protected final String TEXT_12 = NL + " org.eclipse.jface,";
  protected final String TEXT_13 = NL + " org.eclipse.ui.ide,";
  protected final String TEXT_14 = NL + " org.eclipse.ui.views,";
  protected final String TEXT_15 = NL + " org.eclipse.ui.navigator,";
  protected final String TEXT_16 = NL + " org.eclipse.emf.ecore," + NL + " org.eclipse.emf.ecore.xmi," + NL + " org.eclipse.emf.edit.ui," + NL + " org.eclipse.gef;visibility:=reexport," + NL + " org.eclipse.gmf.runtime.emf.core," + NL + " org.eclipse.gmf.runtime.emf.commands.core," + NL + " org.eclipse.gmf.runtime.emf.ui.properties," + NL + " org.eclipse.gmf.runtime.diagram.ui,";
  protected final String TEXT_17 = NL + " org.eclipse.gmf.runtime.diagram.ui.printing.render," + NL + " org.eclipse.gmf.runtime.diagram.ui.printing,";
  protected final String TEXT_18 = NL + " org.eclipse.gmf.runtime.diagram.ui.properties,";
  protected final String TEXT_19 = NL + " org.eclipse.gmf.runtime.diagram.ui.providers,";
  protected final String TEXT_20 = NL + " org.eclipse.gmf.runtime.diagram.ui.providers.ide,";
  protected final String TEXT_21 = NL + " org.eclipse.gmf.runtime.diagram.ui.render," + NL + " org.eclipse.gmf.runtime.diagram.ui.resources.editor,";
  protected final String TEXT_22 = NL + " org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide,";
  protected final String TEXT_23 = NL + " org.eclipse.gmf.runtime.notation.providers";
  protected final String TEXT_24 = ",";
  protected final String TEXT_25 = NL + " ";
  protected final String TEXT_26 = ";visibility:=reexport";
  protected final String TEXT_27 = NL + "Eclipse-LazyStart: true" + NL + "Bundle-RequiredExecutionEnvironment: J2SE-1.4";
  protected final String TEXT_28 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenPlugin genPlugin = (GenPlugin) argument;
final GenModel genModel = genPlugin.getEditorGen().getDomainGenModel();
final Set<String> requiredPluginIDs = new LinkedHashSet<String>();
if (genModel != null) {
	requiredPluginIDs.add(genModel.getModelPluginID());
	requiredPluginIDs.add(genModel.getEditPluginID());

	for (Iterator it = genModel.getAllUsedGenPackagesWithClassifiers().iterator(); it.hasNext();) {
		GenModel nextGenModel = ((GenPackage) it.next()).getGenModel();
		if (nextGenModel.hasEditSupport()) {
			requiredPluginIDs.add(nextGenModel.getModelPluginID());
			requiredPluginIDs.add(nextGenModel.getEditPluginID());
		}
	}
}
	requiredPluginIDs.addAll(genPlugin.getRequiredPluginIDs());
	for (Iterator<String> it = requiredPluginIDs.iterator(); it.hasNext();) {
		String next =  it.next();
		if (next == null || next.trim().length() == 0) {
			it.remove();
		}
	}

Iterator<String> requiredBundleIterator = requiredPluginIDs.iterator();

    stringBuffer.append(TEXT_1);
    stringBuffer.append(genPlugin.getID());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(genPlugin.getVersion());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(genPlugin.getActivatorQualifiedClassName());
    stringBuffer.append(TEXT_4);
    stringBuffer.append(genPlugin.getEditorGen().getDiagram().getEditPartsPackageName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(genPlugin.getEditorGen().getEditor().getPackageName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(genPlugin.getEditorGen().getDiagram().getProvidersPackageName());
    stringBuffer.append(TEXT_9);
    if (genPlugin.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_10);
    }
    if (genPlugin.getEditorGen().getDiagram().generateShortcutIcon() || (genPlugin.getEditorGen().getNavigator() != null && genPlugin.getEditorGen().getNavigator().isGenerateDomainModelNavigator())) {
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    if (genPlugin.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_13);
    }
    stringBuffer.append(TEXT_14);
    if (genPlugin.getEditorGen().getNavigator() != null) {
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    if (genPlugin.isPrintingEnabled()) {
    stringBuffer.append(TEXT_17);
    }
    if (genPlugin.getEditorGen().getPropertySheet() != null) {
    stringBuffer.append(TEXT_18);
    }
    stringBuffer.append(TEXT_19);
    if (genPlugin.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_20);
    }
    stringBuffer.append(TEXT_21);
    if (genPlugin.getEditorGen().getApplication() == null) {
    stringBuffer.append(TEXT_22);
    }
    stringBuffer.append(TEXT_23);
    while(requiredBundleIterator.hasNext()) {
    stringBuffer.append(TEXT_24);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(requiredBundleIterator.next());
    stringBuffer.append(TEXT_26);
    }
    stringBuffer.append(TEXT_27);
    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}

package org.eclipse.gmf.codegen.templates.editor;

import org.eclipse.gmf.codegen.gmfgen.*;
import org.eclipse.emf.codegen.ecore.genmodel.*;
import org.eclipse.gmf.common.codegen.*;

public class InitDiagramFileActionGenerator {
 
  protected static String nl;
  public static synchronized InitDiagramFileActionGenerator create(String lineSeparator)
  {
    nl = lineSeparator;
    InitDiagramFileActionGenerator result = new InitDiagramFileActionGenerator();
    nl = null;
    return result;
  }

  protected final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "/*" + NL + " *";
  protected final String TEXT_3 = NL + " */";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL + NL + "/**" + NL + " * @generated" + NL + " */" + NL + "public class ";
  protected final String TEXT_6 = " implements IObjectActionDelegate {" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate IWorkbenchPart myPart;" + NL + "" + NL + "\t/**" + NL + "\t * @generated" + NL + "\t */" + NL + "\tprivate ";
  protected final String TEXT_7 = " mySelectedModelFile;" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void setActivePart(IAction action, IWorkbenchPart targetPart) {" + NL + "\t\tmyPart = targetPart;" + NL + "\t}" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void selectionChanged(IAction action, ISelection selection) {" + NL + "\t\tmySelectedModelFile = null;" + NL + "\t\taction.setEnabled(false);" + NL + "\t\tif (selection instanceof IStructuredSelection == false || selection.isEmpty()) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tIFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();" + NL + "\t\tmySelectedModelFile = ";
  protected final String TEXT_8 = ".createPlatformResourceURI(file.getFullPath().toString(), true);" + NL + "\t\taction.setEnabled(true);" + NL + "\t}" + NL + "" + NL + "    /**" + NL + "     * @generated" + NL + "     */" + NL + "\tpublic void run(IAction action) {" + NL + "\t\tTransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();";
  protected final String TEXT_9 = NL + "\t\tResourceSet resourceSet = new ";
  protected final String TEXT_10 = "();";
  protected final String TEXT_11 = NL + "\t\tResourceSet resourceSet = editingDomain.getResourceSet();";
  protected final String TEXT_12 = NL + "\t\tEObject diagramRoot = null;" + NL + "\t\ttry {" + NL + "\t\t\tResource resource = resourceSet.getResource(mySelectedModelFile, true);" + NL + "\t\t\tdiagramRoot = (EObject) resource.getContents().get(0);" + NL + "\t\t} catch (WrappedException ex) {" + NL + "\t\t\t";
  protected final String TEXT_13 = ".getInstance().logError(\"Unable to load resource: \" + mySelectedModelFile, ex);" + NL + "\t\t}" + NL + "\t\tif (diagramRoot == null) {" + NL + "\t\t\tMessageDialog.openError(myPart.getSite().getShell(), \"Error\", \"Model file loading failed\");" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tWizard wizard = new ";
  protected final String TEXT_14 = "(mySelectedModelFile, myPart.getSite().getPage(), diagramRoot, editingDomain);" + NL + "        IDialogSettings pluginDialogSettings = ";
  protected final String TEXT_15 = ".getInstance().getDialogSettings();" + NL + "        IDialogSettings initDiagramFileSettings = pluginDialogSettings.getSection(\"InisDiagramFile\"); //$NON-NLS-1$" + NL + "        if (initDiagramFileSettings == null) {" + NL + "        \tinitDiagramFileSettings = pluginDialogSettings.addNewSection(\"InisDiagramFile\"); //$NON-NLS-1$" + NL + "        }" + NL + "        wizard.setDialogSettings(initDiagramFileSettings);" + NL + "\t\twizard.setForcePreviousAndNextButtons(false);" + NL + "\t\twizard.setWindowTitle(\"Initialize new \" + ";
  protected final String TEXT_16 = ".MODEL_ID + \" diagram file\");" + NL + "" + NL + "        WizardDialog dialog = new WizardDialog(myPart.getSite().getShell(), wizard);" + NL + "        dialog.create();" + NL + "        dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);" + NL + "        dialog.open();" + NL + "\t}" + NL + "" + NL + "}";

	protected final String getFeatureValueGetter(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			result.append("((");
			if (feature.isListType()) {
				result.append(importManager.getImportedName("java.util.Collection"));
			} else {
				if (feature.getTypeGenClass() != null) {
					result.append(importManager.getImportedName(feature.getTypeGenClass().getQualifiedInterfaceName()));
				} else {
					// EDataType
					result.append(importManager.getImportedName(feature.getTypeGenClassifier().getEcoreClassifier().getInstanceClassName()));
				}

			}
			result.append(")");
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eGet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("()))");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			result.append(".");
			result.append(feature.getGetAccessor());
			result.append("()");
		}
		return result.toString();
	}
	
	protected final String getFeatureValueSetterPrefix(String containerName, GenFeature feature, boolean isContainerEObject, ImportAssistant importManager) {
		StringBuffer result = new StringBuffer();
		if (feature.getGenClass().isExternalInterface()) {
// Using EMF reflective method to access feature value
			if (!isContainerEObject) {
// Casting container to EObject - ExternalIntarfce could be not an instance of EObject
				result.append("((");
				result.append(importManager.getImportedName("org.eclipse.emf.ecore.EObject"));
				result.append(")");
			}
			result.append(containerName);
			if (!isContainerEObject) {
				result.append(")");
			}
			result.append(".eSet(");
			result.append(importManager.getImportedName(feature.getGenPackage().getQualifiedPackageInterfaceName()));
			result.append(".eINSTANCE.get");
			result.append(feature.getFeatureAccessorName());
			result.append("(), ");
		} else {
			if (isContainerEObject) {
// Casting container to the typed interface
				result.append("((");
				result.append(importManager.getImportedName(feature.getGenClass().getQualifiedInterfaceName()));
				result.append(")");
			}
			result.append(containerName);
			if (isContainerEObject) {
				result.append(")");
			}
			if (feature.isListType()) {
				result.append(".");
				result.append(feature.getGetAccessor());
				result.append("().add(");
			} else {
				result.append(".set");
				result.append(feature.getAccessorName());
				result.append("(");
			}
		}
		return result.toString();
	}
 
	protected final String getMetaClassAccessor(GenClass genClass, ImportAssistant importManager) {
		StringBuffer buf = new StringBuffer();
		buf.append(importManager.getImportedName(genClass.getGenPackage().getQualifiedPackageInterfaceName()))
			.append(".eINSTANCE.get") //$NON-NLS-1$
			.append(genClass.getName())
			.append("()"); //$NON-NLS-1$
		return buf.toString();
	} 
 
	public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
final GenDiagram genDiagram = (GenDiagram) ((Object[]) argument)[0];
final ImportAssistant importManager = (ImportAssistant) ((Object[]) argument)[1];
final GenEditorGenerator editorGen = genDiagram.getEditorGen();
final String pluginActivatorClass = importManager.getImportedName(editorGen.getPlugin().getActivatorQualifiedClassName());

    stringBuffer.append(TEXT_1);
    
String copyrightText = genDiagram.getEditorGen().getCopyrightText();
if (copyrightText != null && copyrightText.trim().length() > 0) {

    stringBuffer.append(TEXT_2);
    stringBuffer.append(copyrightText.replaceAll("\n", "\n *"));
    stringBuffer.append(TEXT_3);
    }
    importManager.emitPackageStatement(stringBuffer);
    stringBuffer.append(TEXT_4);
    
importManager.addImport("org.eclipse.core.resources.IFile");
importManager.addImport("org.eclipse.jface.action.IAction");
importManager.addImport("org.eclipse.jface.dialogs.IDialogSettings");
importManager.addImport("org.eclipse.jface.viewers.ISelection");
importManager.addImport("org.eclipse.jface.viewers.IStructuredSelection");
importManager.addImport("org.eclipse.jface.viewers.StructuredSelection");
importManager.addImport("org.eclipse.jface.wizard.WizardDialog");
importManager.addImport("org.eclipse.jface.wizard.Wizard");
importManager.addImport("org.eclipse.ui.IObjectActionDelegate");
importManager.addImport("org.eclipse.ui.IWorkbenchPart");
importManager.addImport("org.eclipse.emf.transaction.TransactionalEditingDomain");
importManager.addImport("org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory");
importManager.addImport("org.eclipse.emf.ecore.EObject");
importManager.addImport("org.eclipse.emf.ecore.resource.Resource");
importManager.addImport("org.eclipse.emf.ecore.resource.ResourceSet");
importManager.addImport("org.eclipse.emf.common.util.URI");
importManager.addImport("org.eclipse.emf.common.util.WrappedException");
importManager.addImport("org.eclipse.jface.dialogs.MessageDialog");

importManager.markImportLocation(stringBuffer);

    stringBuffer.append(TEXT_5);
    stringBuffer.append(genDiagram.getInitDiagramFileActionClassName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_7);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.common.util.URI"));
    stringBuffer.append(TEXT_8);
    if (editorGen.isSameFileForDiagramAndModel()) {
    stringBuffer.append(TEXT_9);
    stringBuffer.append(importManager.getImportedName("org.eclipse.emf.ecore.resource.impl.ResourceSetImpl"));
    stringBuffer.append(TEXT_10);
    } else {
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(importManager.getImportedName(genDiagram.getNewDiagramFileWizardQualifiedClassName()));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(pluginActivatorClass);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(importManager.getImportedName(genDiagram.getEditPartQualifiedClassName()));
    stringBuffer.append(TEXT_16);
    importManager.emitSortedImports();
    return stringBuffer.toString();
  }
}
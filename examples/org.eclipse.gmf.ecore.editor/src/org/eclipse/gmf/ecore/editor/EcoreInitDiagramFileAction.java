package org.eclipse.gmf.ecore.editor;

import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;

import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.action.IAction;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;

import org.eclipse.jface.wizard.Wizard;
import org.eclipse.jface.wizard.WizardDialog;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

import org.eclipse.ui.ide.IDE;

/**
 * @generated
 */
public class EcoreInitDiagramFileAction implements IObjectActionDelegate, IInputValidator {

	/**
	 * @generated
	 */
	private IWorkbenchPart myPart;

	/**
	 * @generated
	 */
	private IFile mySelectedModelFile;

	/**
	 * @generated
	 */
	private IStructuredSelection mySelection;

	/**
	 * @generated
	 */
	private Map myLinkVID2EObjectMap = new HashMap();

	/**
	 * @generated
	 */
	private Map myEObject2NodeMap = new HashMap();

	/**
	 * @generated
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	/**
	 * @generated
	 */
	private Shell getShell() {
		return myPart.getSite().getShell();
	}

	/**
	 * @generated
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		mySelectedModelFile = null;
		mySelection = StructuredSelection.EMPTY;
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false || selection.isEmpty()) {
			return;
		}
		mySelection = (IStructuredSelection) selection;
		mySelectedModelFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
		action.setEnabled(true);
	}

	/**
	 * @generated
	 */
	public String isValid(String newText) {
		IStatus status = ResourcesPlugin.getWorkspace().validateName(newText, IResource.FILE);
		if (!status.isOK()) {
			return status.getMessage();
		}
		if (mySelectedModelFile.getParent().getFile(new Path(newText).addFileExtension("editorGen.getDiagramFileExtension()")).exists()) {
			return "File already exists, choose another name";
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		NewDiagramFileWizard wizard = new NewDiagramFileWizard();
		IDialogSettings pluginDialogSettings = EcoreDiagramEditorPlugin.getInstance().getDialogSettings();
		IDialogSettings initDiagramFileSettings = pluginDialogSettings.getSection("InisDiagramFile"); //$NON-NLS-1$
		if (initDiagramFileSettings == null) {
			initDiagramFileSettings = pluginDialogSettings.addNewSection("InisDiagramFile"); //$NON-NLS-1$
		}
		wizard.setDialogSettings(initDiagramFileSettings);
		wizard.setForcePreviousAndNextButtons(false);
		wizard.setWindowTitle("Initialize new Ecore diagram file");

		WizardDialog dialog = new WizardDialog(myPart.getSite().getShell(), wizard);
		dialog.create();
		dialog.getShell().setSize(Math.max(500, dialog.getShell().getSize().x), 500);
		dialog.open();
	}

	/**
	 * @generated
	 */
	private class NewDiagramFileWizard extends Wizard {

		/**
		 * @generated
		 */
		private WizardNewFileCreationPage myFileCreationPage;

		/**
		 * @generated
		 */
		public void addPages() {
			myFileCreationPage = new WizardNewFileCreationPage("Initialize new Ecore diagram file", mySelection);
			myFileCreationPage.setFileName(mySelectedModelFile.getProjectRelativePath().removeFileExtension().addFileExtension("ecore_diagram").lastSegment());
			myFileCreationPage.setTitle("Diagram file");
			myFileCreationPage.setDescription("Create new diagram and initialize it using specified Ecore model content");
			addPage(myFileCreationPage);
		}

		/**
		 * @generated
		 */
		public boolean performFinish() {
			final EObject diagramModelObject = load();
			if (diagramModelObject == null) {
				MessageDialog.openError(getShell(), "Error", "Failed to load user model");
				return false;
			}

			myFileCreationPage.getFileName();

			OperationUtil.runAsUnchecked(new MRunnable() {

				public Object run() {
					EObject diagram = create(diagramModelObject);
					if (diagram == null) {
						MessageDialog.openError(getShell(), "Error", "Failed to create diagram object");
						return null;
					}
					IFile destFile = myFileCreationPage.createNewFile();
					save(destFile.getLocation().toOSString(), diagram);
					try {
						IDE.openEditor(myPart.getSite().getPage(), destFile);
					} catch (PartInitException ex) {
						EcoreDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex);
					}
					return null;
				}
			});
			return true;
		}

	}

	/**
	 * @generated
	 */
	private EObject load() {
		String resourcePath = mySelectedModelFile.getLocation().toOSString();
		Resource modelResource = ResourceUtil.findResource(resourcePath);
		if (modelResource == null) {
			modelResource = ResourceUtil.create(resourcePath);
		}
		if (!modelResource.isLoaded()) {
			try {
				ResourceUtil.load(modelResource);
			} catch (Exception e) {
				EcoreDiagramEditorPlugin.getInstance().logError("Unable to load resource: " + resourcePath, e);
				return null;
			}
		}
		return (EObject) modelResource.getContents().get(0);
	}

	/**
	 * @generated
	 */
	private void save(String filePath, EObject canvas) {
		Resource resource = ResourceUtil.create(filePath, null);
		resource.getContents().add(canvas);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException ex) {
			EcoreDiagramEditorPlugin.getInstance().logError("Save operation failed for: " + filePath, ex);
		}
	}

	/**
	 * @generated
	 */
	private EObject create(EObject diagramModel) {
		int diagramVID = EcoreVisualIDRegistry.INSTANCE.getDiagramVisualID(diagramModel);
		if (diagramVID != 79) {
			return null;
		}
		myLinkVID2EObjectMap.put(new Integer(3001), new LinkedList());
		myLinkVID2EObjectMap.put(new Integer(3002), new LinkedList());
		myLinkVID2EObjectMap.put(new Integer(3003), new LinkedList());
		myLinkVID2EObjectMap.put(new Integer(3004), new LinkedList());
		Diagram diagram = ViewService.createDiagram(diagramModel, "Ecore", EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		createEPackage_79Children(diagram, diagramModel);
		createLinks();
		myLinkVID2EObjectMap.clear();
		myEObject2NodeMap.clear();
		return diagram;
	}

	/**
	 * @generated
	 */
	private void createEClass_1001Children(View viewObject, EObject modelObject) {
		Node nextNode;
		nextNode = getCompartment(viewObject, "attributes");
		if (nextNode != null) {
			createAttributes_5001Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "operations");
		if (nextNode != null) {
			createOperations_5002Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "class annotations");
		if (nextNode != null) {
			createClass_annotations_5003Children(nextNode, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEPackage_1002Children(View viewObject, EObject modelObject) {
		Node nextNode;
		nextNode = getCompartment(viewObject, "classes");
		if (nextNode != null) {
			createClasses_5004Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "packages");
		if (nextNode != null) {
			createPackages_5005Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "data types");
		if (nextNode != null) {
			createData_types_5006Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "enums");
		if (nextNode != null) {
			createEnums_5007Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "package annotations");
		if (nextNode != null) {
			createPackage_annotations_5008Children(nextNode, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEAnnotation_1003Children(View viewObject, EObject modelObject) {
		Node nextNode;
		nextNode = getCompartment(viewObject, "details");
		if (nextNode != null) {
			createDetails_5009Children(nextNode, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEDataType_1004Children(View viewObject, EObject modelObject) {
		Node nextNode;
		nextNode = getCompartment(viewObject, "data type annotations");
		if (nextNode != null) {
			createData_type_annotations_5010Children(nextNode, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEEnum_1005Children(View viewObject, EObject modelObject) {
		Node nextNode;
		nextNode = getCompartment(viewObject, "literals");
		if (nextNode != null) {
			createLiterals_5011Children(nextNode, modelObject);
		}
		nextNode = getCompartment(viewObject, "enum annotations");
		if (nextNode != null) {
			createEnum_annotations_5012Children(nextNode, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEAttribute_2001Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEOperation_2002Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEAnnotation_2003Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEClass_2004Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEPackage_2005Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEDataType_2006Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEEnum_2007Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEStringToStringMapEntry_2008Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEEnumLiteral_2009Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createAttributes_5001Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EClass) modelObject).getEAttributes().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEAttribute_2001Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createOperations_5002Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EClass) modelObject).getEOperations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2002 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEOperation_2002Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createClass_annotations_5003Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EModelElement) modelObject).getEAnnotations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2003 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEAnnotation_2003Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createClasses_5004Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EPackage) modelObject).getEClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2004 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEClass_2004Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPackages_5005Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EPackage) modelObject).getESubpackages().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2005 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEPackage_2005Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createData_types_5006Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EPackage) modelObject).getEClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2006 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEDataType_2006Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEnums_5007Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EPackage) modelObject).getEClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2007 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEEnum_2007Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createPackage_annotations_5008Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EModelElement) modelObject).getEAnnotations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2003 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEAnnotation_2003Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createDetails_5009Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EAnnotation) modelObject).getDetails().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2008 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEStringToStringMapEntry_2008Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createData_type_annotations_5010Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EModelElement) modelObject).getEAnnotations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2003 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEAnnotation_2003Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createLiterals_5011Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EEnum) modelObject).getELiterals().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2009 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEEnumLiteral_2009Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEnum_annotations_5012Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EModelElement) modelObject).getEAnnotations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2003 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEAnnotation_2003Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createEPackage_79Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((EPackage) modelObject).getEClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEClass_1001Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((EPackage) modelObject).getESubpackages().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1002 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEPackage_1002Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((EModelElement) modelObject).getEAnnotations().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1003 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEAnnotation_1003Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((EPackage) modelObject).getEClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1004 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEDataType_1004Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((EPackage) modelObject).getEClassifiers().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = EcoreVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1005 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createEEnum_1005Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private Node getCompartment(View node, String name) {
		for (Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView instanceof Node && name.equals(nextView.getType())) {
				return (Node) nextView;
			}
		}
		return null;
	}

	/**
	 *@generated
	 */
	private void storeLinks(EObject container, Diagram diagram) {
		EClass containerMetaclass = container.eClass();
		storeFeatureModelFacetLinks(container, containerMetaclass, diagram);
		storeTypeModelFacetLinks(container, containerMetaclass);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass) {
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures())) {
			Object featureValue = ((EClass) container).getEStructuralFeatures();
			for (Iterator values = ((Collection) featureValue).iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextValue);
				if (3002 == linkVID) {
					((Collection) myLinkVID2EObjectMap.get(new Integer(3002))).add(nextValue);
				}
			}
		}
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures())) {
			Object featureValue = ((EClass) container).getEStructuralFeatures();
			for (Iterator values = ((Collection) featureValue).iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextValue);
				if (3003 == linkVID) {
					((Collection) myLinkVID2EObjectMap.get(new Integer(3003))).add(nextValue);
				}
			}
		}
	}

	/**
	 *@generated
	 */
	private void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEAnnotation_References())) {
			((Collection) myLinkVID2EObjectMap.get(new Integer(3001))).add(container);
		}
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEClass_ESuperTypes())) {
			((Collection) myLinkVID2EObjectMap.get(new Integer(3004))).add(container);
		}
	}

	/**
	 * @generated
	 */
	private void createLinks() {
		Collection linkElements;
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3001));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement;
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((EAnnotation) linkElement).getReferences();
			if (structuralFeatureResult instanceof Collection == false) {
				continue;
			}
			for (Iterator destinations = ((Collection) structuralFeatureResult).iterator(); destinations.hasNext();) {
				EObject dst = (EObject) destinations.next();
				Node dstNode = (Node) myEObject2NodeMap.get(dst);
				if (dstNode != null) {
					Edge edge = (Edge) ViewService.getInstance().createEdge(new IAdaptable() {

						public Object getAdapter(Class adapter) {
							if (IElementType.class.equals(adapter)) {
								return EcoreElementTypes.EAnnotationReferences_3001;
							}
							return null;
						}
					}, srcNode.getDiagram(), "", ViewUtil.APPEND, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					if (edge != null) {
						edge.setSource(srcNode);
						edge.setTarget(dstNode);
					}
				}
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3002));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement.eContainer();
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((ETypedElement) linkElement).getEType();
			if (structuralFeatureResult instanceof EObject == false) {
				continue;
			}
			EObject dst = (EObject) structuralFeatureResult;
			Node dstNode = (Node) myEObject2NodeMap.get(dst);
			if (dstNode != null) {
				ViewService.createEdge(srcNode, dstNode, linkElement, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3003));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement.eContainer();
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((ETypedElement) linkElement).getEType();
			if (structuralFeatureResult instanceof EObject == false) {
				continue;
			}
			EObject dst = (EObject) structuralFeatureResult;
			Node dstNode = (Node) myEObject2NodeMap.get(dst);
			if (dstNode != null) {
				ViewService.createEdge(srcNode, dstNode, linkElement, null, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(new Integer(3004));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement;
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			Object structuralFeatureResult = ((EClass) linkElement).getESuperTypes();
			if (structuralFeatureResult instanceof Collection == false) {
				continue;
			}
			for (Iterator destinations = ((Collection) structuralFeatureResult).iterator(); destinations.hasNext();) {
				EObject dst = (EObject) destinations.next();
				Node dstNode = (Node) myEObject2NodeMap.get(dst);
				if (dstNode != null) {
					Edge edge = (Edge) ViewService.getInstance().createEdge(new IAdaptable() {

						public Object getAdapter(Class adapter) {
							if (IElementType.class.equals(adapter)) {
								return EcoreElementTypes.EClassESuperTypes_3004;
							}
							return null;
						}
					}, srcNode.getDiagram(), "", ViewUtil.APPEND, EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					if (edge != null) {
						edge.setSource(srcNode);
						edge.setTarget(dstNode);
					}
				}
			}
		}
	}

}

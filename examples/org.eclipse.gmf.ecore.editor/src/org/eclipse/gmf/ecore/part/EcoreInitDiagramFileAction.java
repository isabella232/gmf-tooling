package org.eclipse.gmf.ecore.part;

import java.io.IOException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;

import org.eclipse.core.commands.operations.OperationHistoryFactory;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.common.core.command.CommandResult;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;

import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;

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
	private static final Integer LINK_KEY_3001 = new Integer(3001);

	/**
	 * @generated
	 */
	private static final Integer LINK_KEY_3002 = new Integer(3002);

	/**
	 * @generated
	 */
	private static final Integer LINK_KEY_3003 = new Integer(3003);

	/**
	 * @generated
	 */
	private static final Integer LINK_KEY_3004 = new Integer(3004);

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
		private TransactionalEditingDomain myEditingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();

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

			IFile diagramFile = myFileCreationPage.createNewFile();
			ResourceSet resourceSet = myEditingDomain.getResourceSet();
			final Resource diagramResource = resourceSet.createResource(URI.createPlatformResourceURI(diagramFile.getFullPath().toString()));

			List affectedFiles = new LinkedList();
			affectedFiles.add(mySelectedModelFile);
			affectedFiles.add(diagramFile);

			AbstractTransactionalCommand command = new AbstractTransactionalCommand(myEditingDomain, "Initializing diagram contents", affectedFiles) { //$NON-NLS-1$

				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					int diagramVID = EcoreVisualIDRegistry.INSTANCE.getDiagramVisualID(diagramModelObject);
					if (diagramVID != 79) {
						return CommandResult.newErrorCommandResult("Incorrect model object stored as a root resource object"); //$NON-NLS-1$
					}
					myLinkVID2EObjectMap.put(LINK_KEY_3001, new LinkedList());
					myLinkVID2EObjectMap.put(LINK_KEY_3002, new LinkedList());
					myLinkVID2EObjectMap.put(LINK_KEY_3003, new LinkedList());
					myLinkVID2EObjectMap.put(LINK_KEY_3004, new LinkedList());
					Diagram diagram = ViewService.createDiagram(diagramModelObject, "Ecore", EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					diagramResource.getContents().add(diagram);
					createEPackage_79Children(diagram, diagramModelObject);
					createLinks();
					myLinkVID2EObjectMap.clear();
					myEObject2NodeMap.clear();
					return CommandResult.newOKCommandResult();
				}
			};

			try {
				OperationHistoryFactory.getOperationHistory().execute(command, new NullProgressMonitor(), null);
				diagramResource.save(Collections.EMPTY_MAP);
				IDE.openEditor(myPart.getSite().getPage(), diagramFile);
			} catch (ExecutionException e) {
				EcoreDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
			} catch (IOException ex) {
				EcoreDiagramEditorPlugin.getInstance().logError("Save operation failed for: " + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$
			} catch (PartInitException ex) {
				EcoreDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
			}
			return true;
		}

		/**
		 * @generated
		 */
		private EObject load() {
			ResourceSet resourceSet = myEditingDomain.getResourceSet();
			try {
				Resource resource = resourceSet.getResource(URI.createPlatformResourceURI(mySelectedModelFile.getFullPath().toString()), true);
				return (EObject) resource.getContents().get(0);
			} catch (WrappedException ex) {
				EcoreDiagramEditorPlugin.getInstance().logError("Unable to load resource: " + mySelectedModelFile.getFullPath().toString(), ex); //$NON-NLS-1$
			}
			return null;
		}

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
		storeTypeModelFacetLinks(container, containerMetaclass, diagram);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures())) {
			Object featureValue = ((EClass) container).getEStructuralFeatures();
			for (Iterator values = ((Collection) featureValue).iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextValue);
				if (3002 == linkVID) {
					Object structuralFeatureResult = ((ETypedElement) nextValue).getEType();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						((Collection) myLinkVID2EObjectMap.get(LINK_KEY_3002)).add(new LinkDescriptor(container, dst, nextValue, diagram));
					}
				}
			}
		}
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEClass_EStructuralFeatures())) {
			Object featureValue = ((EClass) container).getEStructuralFeatures();
			for (Iterator values = ((Collection) featureValue).iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = EcoreVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextValue);
				if (3003 == linkVID) {
					Object structuralFeatureResult = ((ETypedElement) nextValue).getEType();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						((Collection) myLinkVID2EObjectMap.get(LINK_KEY_3003)).add(new LinkDescriptor(container, dst, nextValue, diagram));
					}
				}
			}
		}
	}

	/**
	 *@generated
	 */
	private void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEAnnotation_References())) {
			Object structuralFeatureResult = ((EAnnotation) container).getReferences();
			for (Iterator destinations = ((Collection) structuralFeatureResult).iterator(); destinations.hasNext();) {
				EObject nextDestination = (EObject) destinations.next();
				((Collection) myLinkVID2EObjectMap.get(LINK_KEY_3001)).add(new LinkDescriptor(container, nextDestination, EcoreElementTypes.EAnnotationReferences_3001, diagram));
			}
		}
		if (-1 != containerMetaclass.getFeatureID(EcorePackage.eINSTANCE.getEClass_ESuperTypes())) {
			Object structuralFeatureResult = ((EClass) container).getESuperTypes();
			for (Iterator destinations = ((Collection) structuralFeatureResult).iterator(); destinations.hasNext();) {
				EObject nextDestination = (EObject) destinations.next();
				((Collection) myLinkVID2EObjectMap.get(LINK_KEY_3004)).add(new LinkDescriptor(container, nextDestination, EcoreElementTypes.EClassESuperTypes_3004, diagram));
			}
		}
	}

	/**
	 * @generated
	 */
	private void createLinks() {
		Collection linkElements;
		linkElements = (Collection) myLinkVID2EObjectMap.get(LINK_KEY_3001);
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), "", ViewUtil.APPEND,
					EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(LINK_KEY_3002);
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), "", ViewUtil.APPEND,
					EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(LINK_KEY_3003);
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), "", ViewUtil.APPEND,
					EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(LINK_KEY_3004);
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), "", ViewUtil.APPEND,
					EcoreDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));
			}
		}
	}

	/**
	 * @generated
	 */
	private class LinkDescriptor {

		/**
		 * @generated
		 */
		private EObject mySource;

		/**
		 * @generated
		 */
		private EObject myDestination;

		/**
		 * @generated
		 */
		private IAdaptable mySemanticAdapter;

		/**
		 * @generated
		 */
		private Diagram myDiagram;

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, EObject linkElement, Diagram diagram) {
			this(source, destination, diagram);
			mySemanticAdapter = new EObjectAdapter(linkElement);
		}

		/**
		 * @generated
		 */
		protected LinkDescriptor(EObject source, EObject destination, IElementType elementType, Diagram diagram) {
			this(source, destination, diagram);
			final IElementType elementTypeCopy = elementType;
			mySemanticAdapter = new IAdaptable() {

				public Object getAdapter(Class adapter) {
					if (IElementType.class.equals(adapter)) {
						return elementTypeCopy;
					}
					return null;
				}
			};
		}

		/**
		 * @generated
		 */
		private LinkDescriptor(EObject source, EObject destination, Diagram diagram) {
			mySource = source;
			myDestination = destination;
			myDiagram = diagram;
		}

		/**
		 * @generated
		 */
		protected EObject getSource() {
			return mySource;
		}

		/**
		 * @generated
		 */
		protected EObject getDestination() {
			return myDestination;
		}

		/**
		 * @generated
		 */
		protected Diagram getDiagram() {
			return myDiagram;
		}

		/**
		 * @generated
		 */
		protected IAdaptable getSemanticAdapter() {
			return mySemanticAdapter;
		}
	}
}

/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

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
public class TaiPanInitDiagramFileAction implements IObjectActionDelegate, IInputValidator {

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
		IDialogSettings pluginDialogSettings = TaiPanDiagramEditorPlugin.getInstance().getDialogSettings();
		IDialogSettings initDiagramFileSettings = pluginDialogSettings.getSection("InisDiagramFile"); //$NON-NLS-1$
		if (initDiagramFileSettings == null) {
			initDiagramFileSettings = pluginDialogSettings.addNewSection("InisDiagramFile"); //$NON-NLS-1$
		}
		wizard.setDialogSettings(initDiagramFileSettings);
		wizard.setForcePreviousAndNextButtons(false);
		wizard.setWindowTitle("Initialize new TaiPan diagram file");

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
			myFileCreationPage.setFileName(mySelectedModelFile.getProjectRelativePath().removeFileExtension().addFileExtension("taipan_diagram").lastSegment());
			myFileCreationPage.setTitle("Diagram file");
			myFileCreationPage.setDescription("Create new diagram and initialize it using specified TaiPan model content");
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
					int diagramVID = TaiPanVisualIDRegistry.INSTANCE.getDiagramVisualID(diagramModelObject);
					if (diagramVID != 79) {
						return CommandResult.newErrorCommandResult("Incorrect model object stored as a root resource object"); //$NON-NLS-1$
					}
					myLinkVID2EObjectMap.put(LINK_KEY_3001, new LinkedList());
					myLinkVID2EObjectMap.put(LINK_KEY_3002, new LinkedList());
					Diagram diagram = ViewService.createDiagram(diagramModelObject, "TaiPan", TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
					diagramResource.getContents().add(diagram);
					createAquatory_79Children(diagram, diagramModelObject);
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
				TaiPanDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
			} catch (IOException ex) {
				TaiPanDiagramEditorPlugin.getInstance().logError("Save operation failed for: " + diagramFile.getFullPath().toString(), ex); //$NON-NLS-1$
			} catch (PartInitException ex) {
				TaiPanDiagramEditorPlugin.getInstance().logError("Unable to open editor", ex); //$NON-NLS-1$
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
				TaiPanDiagramEditorPlugin.getInstance().logError("Unable to load resource: " + mySelectedModelFile.getFullPath().toString(), ex); //$NON-NLS-1$
			}
			return null;
		}

	}

	/**
	 * @generated
	 */
	private void createPort_1001Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createShip_1002Children(View viewObject, EObject modelObject) {
		Node nextNode;
		nextNode = getCompartment(viewObject, "CargoCompartment");
		if (nextNode != null) {
			createCargoCompartment_5001Children(nextNode, modelObject);
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createItem_2001Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createCargoCompartment_5001Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((Ship) modelObject).getCargo().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createItem_2001Children(nextNode, nextValue);
			}
		}
		storeLinks(modelObject, viewObject.getDiagram());
	}

	/**
	 * @generated
	 */
	private void createAquatory_79Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		int nodeVID;
		for (Iterator values = ((Aquatory) modelObject).getPorts().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPort_1001Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Aquatory) modelObject).getShips().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1002 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createShip_1002Children(nextNode, nextValue);
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
		if (-1 != containerMetaclass.getFeatureID(TaiPanPackage.eINSTANCE.getAquatory_Routes())) {
			Object featureValue = ((Aquatory) container).getRoutes();
			for (Iterator values = ((Collection) featureValue).iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = TaiPanVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextValue);
				if (3002 == linkVID) {
					Object structuralFeatureResult = ((Route) nextValue).getDestination();
					if (structuralFeatureResult instanceof EObject) {
						EObject dst = (EObject) structuralFeatureResult;
						((Collection) myLinkVID2EObjectMap.get(LINK_KEY_3002)).add(new LinkDescriptor(container, dst, nextValue, diagram));
					}
				}
			}
		}
	}

	/**
	 *@generated
	 */
	private void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass, Diagram diagram) {
		if (-1 != containerMetaclass.getFeatureID(TaiPanPackage.eINSTANCE.getShip_Destination())) {
			Object structuralFeatureResult = ((Ship) container).getDestination();
			if (structuralFeatureResult instanceof EObject) {
				EObject nextDestination = (EObject) structuralFeatureResult;
				((Collection) myLinkVID2EObjectMap.get(LINK_KEY_3001)).add(new LinkDescriptor(container, nextDestination, TaiPanElementTypes.ShipDestination_3001, diagram));
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
					TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			if (edge != null) {
				edge.setSource((Node) myEObject2NodeMap.get(nextLinkDescriptor.getSource()));
				edge.setTarget((Node) myEObject2NodeMap.get(nextLinkDescriptor.getDestination()));
			}
		}
		linkElements = (Collection) myLinkVID2EObjectMap.get(LINK_KEY_3002);
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			LinkDescriptor nextLinkDescriptor = (LinkDescriptor) it.next();
			Edge edge = (Edge) ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), nextLinkDescriptor.getDiagram(), "", ViewUtil.APPEND,
					TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
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

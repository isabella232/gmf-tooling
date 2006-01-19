/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.taipan.gmf.editor.part;

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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.gmf.examples.taipan.Aquatory;
import org.eclipse.gmf.examples.taipan.Route;
import org.eclipse.gmf.examples.taipan.Ship;
import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanElementTypes;

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

import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;

import org.eclipse.swt.widgets.Shell;

import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;

import org.eclipse.ui.ide.IDE;

/**
 * @generated
 */
public class TaiPanInitDiagramFileAction implements IObjectActionDelegate, IInputValidator {

	/**
	 * @generated
	 */
	private static final String FILE_EXT = "taipan_diagram";

	/**
	 * @generated
	 */
	private IWorkbenchPart myPart;

	/**
	 * @generated
	 */
	private IFile mySelection;

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
		mySelection = null;
		action.setEnabled(false);
		if (selection instanceof IStructuredSelection == false || selection.isEmpty()) {
			return;
		}
		mySelection = (IFile) ((IStructuredSelection) selection).getFirstElement();
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
		if (mySelection.getParent().getFile(new Path(newText).addFileExtension(FILE_EXT)).exists()) {
			return "File already exists, choose another name";
		}
		return null;
	}

	/**
	 * @generated
	 */
	public void run(IAction action) {
		final InputDialog outputFileNameDialog = new InputDialog(getShell(), "Diagram file name", "Please provide diagram file name", mySelection.getProjectRelativePath().removeFileExtension()
				.addFileExtension(FILE_EXT).lastSegment(), this);
		if (outputFileNameDialog.open() != InputDialog.OK) {
			return;
		}
		final EObject diagramModelObject = load();
		if (diagramModelObject == null) {
			MessageDialog.openError(getShell(), "Error", "Failed to load user model");
			return;
		}
		OperationUtil.runAsUnchecked(new MRunnable() {

			public Object run() {
				EObject diagram = create(diagramModelObject);
				if (diagram == null) {
					MessageDialog.openError(getShell(), "Error", "Failed to create diagram object");
					return null;
				}
				IFile destFile = mySelection.getParent().getFile(new Path(outputFileNameDialog.getValue()));
				save(destFile.getLocation().toOSString(), diagram);
				try {
					IDE.openEditor(myPart.getSite().getPage(), destFile);
				} catch (PartInitException ex) {
					ex.printStackTrace();
				}
				return null;
			}
		});
	}

	/**
	 * @generated
	 */
	private EObject load() {
		String resourcePath = mySelection.getLocation().toOSString();
		Resource modelResource = ResourceUtil.findResource(resourcePath);
		if (modelResource == null) {
			modelResource = ResourceUtil.create(resourcePath);
		}
		if (!modelResource.isLoaded()) {
			try {
				ResourceUtil.load(modelResource);
			} catch (Exception e) {
				e.printStackTrace();
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
			ex.printStackTrace();
		}
	}

	/**
	 * @generated
	 */
	private EObject create(EObject diagramModel) {
		int diagramVID = TaiPanVisualIDRegistry.INSTANCE.getDiagramVisualID(diagramModel);
		if (diagramVID != 79) {
			return null;
		}
		myLinkVID2EObjectMap.put(new Integer(3001), new LinkedList());
		myLinkVID2EObjectMap.put(new Integer(3002), new LinkedList());
		Diagram diagram = ViewService.createDiagram(diagramModel, "TaiPan", TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		createAquatory_79Children(diagram, diagramModel);
		createLinks();
		myLinkVID2EObjectMap.clear();
		myEObject2NodeMap.clear();
		return diagram;
	}

	/**
	 * @generated
	 */
	private void createPort_1001Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject);
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
		storeLinks(modelObject);
	}

	/**
	 * @generated
	 */
	private void createItem_2001Children(View viewObject, EObject modelObject) {
		storeLinks(modelObject);
	}

	/**
	 * @generated
	 */
	private void createCargoCompartment_5001Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		for (Iterator values = ((Ship) modelObject).getCargo().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			int nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (2001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createItem_2001Children(nextNode, nextValue);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createAquatory_79Children(View viewObject, EObject modelObject) {
		EObject nextValue;
		Node nextNode;
		for (Iterator values = ((Aquatory) modelObject).getPorts().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			int nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1001 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createPort_1001Children(nextNode, nextValue);
			}
		}
		for (Iterator values = ((Aquatory) modelObject).getShips().iterator(); values.hasNext();) {
			nextValue = (EObject) values.next();

			int nodeVID = TaiPanVisualIDRegistry.INSTANCE.getNodeVisualID(viewObject, nextValue, "");
			if (1002 == nodeVID) {
				nextNode = ViewService.createNode(viewObject, nextValue, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				myEObject2NodeMap.put(nextValue, nextNode);
				createShip_1002Children(nextNode, nextValue);
			}
		}
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
	 * @generated
	 */
	private void storeLinks(EObject container) {
		EClass containerMetaclass = container.eClass();
		storeFeatureModelFacetLinks(container, containerMetaclass);
		storeTypeModelFacetLinks(container, containerMetaclass);
	}

	/**
	 * @generated
	 */
	private void storeTypeModelFacetLinks(EObject container, EClass containerMetaclass) {
		if (-1 != containerMetaclass.getFeatureID(TaiPanPackage.eINSTANCE.getAquatory_Routes())) {
			Object featureValue = ((Aquatory) container).getRoutes();
			for (Iterator values = ((Collection) featureValue).iterator(); values.hasNext();) {
				EObject nextValue = ((EObject) values.next());
				int linkVID = TaiPanVisualIDRegistry.INSTANCE.getLinkWithClassVisualID(nextValue);
				if (3002 == linkVID) {
					((Collection) myLinkVID2EObjectMap.get(new Integer(3002))).add(nextValue);
				}
			}
		}
	}

	/**
	 * @generated
	 */
	private void storeFeatureModelFacetLinks(EObject container, EClass containerMetaclass) {
		if (-1 != containerMetaclass.getFeatureID(TaiPanPackage.eINSTANCE.getShip_Destination())) {
			((Collection) myLinkVID2EObjectMap.get(new Integer(3001))).add(container);
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
			Object structuralFeatureResult = ((Ship) linkElement).getDestination();
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
								return TaiPanElementTypes.ShipDestination_3001;
							}
							return null;
						}
					}, srcNode.getDiagram(), "", ViewUtil.APPEND, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
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
			Object structuralFeatureResult = ((Route) linkElement).getDestination();
			if (structuralFeatureResult instanceof EObject == false) {
				continue;
			}
			EObject dst = (EObject) structuralFeatureResult;
			Node dstNode = (Node) myEObject2NodeMap.get(dst);
			if (dstNode != null) {
				ViewService.createEdge(srcNode, dstNode, linkElement, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			}
		}
	}

}

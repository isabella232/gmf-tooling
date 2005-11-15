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
package org.eclipse.gmf.examples.taipan.editor;

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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.DiagramUtil;
import org.eclipse.gmf.runtime.emf.core.edit.MRunnable;
import org.eclipse.gmf.runtime.emf.core.util.OperationUtil;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
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
import org.eclipse.core.runtime.IAdaptable;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.providers.ElementTypes;

import org.eclipse.gmf.runtime.diagram.core.internal.services.view.ViewService;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.runtime.notation.Edge;

/**
 * @generated
 */
public class InitDiagramFileAction implements IObjectActionDelegate, IInputValidator {

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
	private Map myLinkWithClassVID2EObject = new HashMap();

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
		final InputDialog outputFileNameDialog = new InputDialog(getShell(), "Diagram file name",
				"Please provide diagram file name", mySelection.getProjectRelativePath().removeFileExtension()
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
		Resource modelResource = ResourceUtil.load(mySelection.getLocation().toOSString());
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
		int diagramVID = VisualIDRegistry.INSTANCE.getDiagramVisualID(diagramModel);
		if (diagramVID == -1) {
			return null;
		}

		myLinkWithClassVID2EObject.clear();
		myEObject2NodeMap.clear();
		myLinkWithClassVID2EObject.put(new Integer(3001), new LinkedList());
		Diagram diagram = DiagramUtil.createDiagram(diagramModel, "TaiPan", TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		createDiagramChildren(diagram, diagramModel);

		createLinks();

		return diagram;
	}

	/**
	 * @generated
	 */
	private void createDiagramChildren(Diagram diagram, EObject diagramObject) {
		for (Iterator it = diagramObject.eContents().iterator(); it.hasNext();) {
			EObject nextChild = (EObject) it.next();
			storeLinkReferenceOnly(nextChild);
			int nodeVID = VisualIDRegistry.INSTANCE.getNodeVisualID(nextChild);
			if (nodeVID == -1) {
				storeLinkWithClass(nextChild);
				continue;
			}
			Node nextNode = DiagramUtil
					.createNode(diagram, nextChild, null, TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextChild, nextNode);
			switch (nodeVID) {
			case 1001:
				createPort_1001Children(nextNode, nextChild);
				break;
			case 1002:
				createShip_1002Children(nextNode, nextChild);
				break;
			}
		}
	}

	/**
	 * @generated
	 */
	private void createPort_1001Children(Node node, EObject nodeObject) {
		for (Iterator it = nodeObject.eContents().iterator(); it.hasNext();) {
			EObject nextChild = (EObject) it.next();
			storeLinkReferenceOnly(nextChild);
			int nodeVID = VisualIDRegistry.INSTANCE.getChildNodeVisualID(nextChild);
			if (nodeVID == -1) {
				storeLinkWithClass(nextChild);
				continue;
			}

			Node container;
			switch (nodeVID) {
			default:
				container = node;
				break;
			}
			Node nextNode = DiagramUtil.createNode(container, nextChild, null,
					TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextChild, nextNode);
		}
	}

	/**
	 * @generated
	 */
	private void createShip_1002Children(Node node, EObject nodeObject) {
		for (Iterator it = nodeObject.eContents().iterator(); it.hasNext();) {
			EObject nextChild = (EObject) it.next();
			storeLinkReferenceOnly(nextChild);
			int nodeVID = VisualIDRegistry.INSTANCE.getChildNodeVisualID(nextChild);
			if (nodeVID == -1) {
				storeLinkWithClass(nextChild);
				continue;
			}

			Node container;
			switch (nodeVID) {
			case 2001:
				container = getCompartment(node, "cargo");
				break;
			default:
				container = node;
				break;
			}
			Node nextNode = DiagramUtil.createNode(container, nextChild, null,
					TaiPanDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
			myEObject2NodeMap.put(nextChild, nextNode);
		}
	}

	/**
	 * @generated
	 */
	private Node getCompartment(Node node, String name) {
		for (Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View) it.next();
			if (nextView instanceof Node && name.equals(nextView.getType())) {
				return (Node) nextView;
			}
		}
		return node;
	}

	/**
	 * @generated
	 */
	private void storeLinkWithClass(EObject link) {
		int linkVID = VisualIDRegistry.INSTANCE.getLinkWithClassVisualID(link);
		if (linkVID == -1) {
			return;
		}
		((Collection) myLinkWithClassVID2EObject.get(new Integer(linkVID))).add(link);
	}

	/**
	 *@generated
	 */
	private void storeLinkReferenceOnly(EObject container) {
		EClass containerMetaclass = container.eClass();
		for (Iterator it = containerMetaclass.getEAllStructuralFeatures().iterator(); it.hasNext();) {
			EStructuralFeature nextFeature = (EStructuralFeature) it.next();
			if (TaiPanPackage.eINSTANCE.getShip_Destination().equals(nextFeature)) {
				((Collection) myLinkWithClassVID2EObject.get(new Integer(3001))).add(container);
			}
		}
	}

	/**
	 * @generated
	 */
	private void createLinks() {
		Collection linkElements;
		linkElements = (Collection) myLinkWithClassVID2EObject.get(new Integer(3001));
		for (Iterator it = linkElements.iterator(); it.hasNext();) {
			EObject linkElement = (EObject) it.next();
			EObject src = linkElement;
			Node srcNode = (Node) myEObject2NodeMap.get(src);
			if (srcNode == null) {
				continue;
			}
			EStructuralFeature structuralFeature = TaiPanPackage.eINSTANCE.getShip_Destination();
			Object structuralFeatureResult = linkElement.eGet(structuralFeature);
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
								return ElementTypes.ShipDestination_3001;
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
	}

}

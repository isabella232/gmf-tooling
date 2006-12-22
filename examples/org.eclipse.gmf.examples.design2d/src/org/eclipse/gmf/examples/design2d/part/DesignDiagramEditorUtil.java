/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.part;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.emf.core.GMFEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.PartInitException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;

import org.eclipse.emf.edit.ui.util.EditUIUtil;

import org.eclipse.gef.EditPart;

import org.eclipse.gmf.examples.design2d.edit.parts.Design2DEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;

import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;

import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class DesignDiagramEditorUtil {

	/**
	 * @generated
	 */
	public static boolean openDiagram(Resource diagram) throws PartInitException {
		return EditUIUtil.openEditor((EObject) diagram.getContents().get(0));
	}

	/**
	 * @generated
	 */
	private static void setCharset(URI uri) {
		IFile file = getFile(uri);
		if (file == null) {
			return;
		}
		try {
			file.setCharset("UTF-8", new NullProgressMonitor()); //$NON-NLS-1$
		} catch (CoreException e) {
			DesignDiagramEditorPlugin.getInstance().logError("Unable to set charset for file " + file.getFullPath(), e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public static IFile getFile(URI uri) {
		if (uri.toString().startsWith("platform:/resource")) { //$NON-NLS-1$
			String path = uri.toString().substring("platform:/resource".length()); //$NON-NLS-1$
			IResource workspaceResource = ResourcesPlugin.getWorkspace().getRoot().findMember(new Path(path));
			if (workspaceResource instanceof IFile) {
				return (IFile) workspaceResource;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public static boolean exists(IPath path) {
		return ResourcesPlugin.getWorkspace().getRoot().exists(path);
	}

	/**
	 * <p>
	 * This method should be called within a workspace modify operation since it creates resources.
	 * </p>
	 * @generated
	 * @return the created resource, or <code>null</code> if the resource was not created
	 */
	public static final Resource createDiagram(URI diagramURI, IProgressMonitor progressMonitor) {
		TransactionalEditingDomain editingDomain = GMFEditingDomainFactory.INSTANCE.createEditingDomain();
		progressMonitor.beginTask("Creating diagram and model files", 3);
		final Resource diagramResource = editingDomain.getResourceSet().createResource(diagramURI);
		final String diagramName = diagramURI.lastSegment();
		AbstractTransactionalCommand command = new AbstractTransactionalCommand(editingDomain, "Creating diagram and model", Collections.EMPTY_LIST) { //$NON-NLS-1$

			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				Diagram diagram = ViewService.createDiagram(Design2DEditPart.MODEL_ID, DesignDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if (diagram != null) {
					diagramResource.getContents().add(diagram);
					diagram.setName(diagramName);
				}
				try {
					Map options = new HashMap();
					options.put(XMIResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
					diagramResource.save(options);
				} catch (IOException e) {

					DesignDiagramEditorPlugin.getInstance().logError("Unable to store model and diagram resources", e); //$NON-NLS-1$
				}
				return CommandResult.newOKCommandResult();
			}
		};
		try {
			OperationHistoryFactory.getOperationHistory().execute(command, new SubProgressMonitor(progressMonitor, 1), null);
		} catch (ExecutionException e) {
			DesignDiagramEditorPlugin.getInstance().logError("Unable to create model and diagram", e); //$NON-NLS-1$
		}
		setCharset(diagramURI);
		return diagramResource;
	}

	/**
	 * @generated
	 */
	public static int findElementsInDiagram(IDiagramWorkbenchPart diagramPart, URI elementURI, List/*EditPart*/editPartCollector) {
		final int originalNumOfEditParts = editPartCollector.size();
		EObject element = null;
		try {
			element = diagramPart.getDiagram().eResource().getResourceSet().getEObject(elementURI, false);
		} catch (RuntimeException e) {
			DesignDiagramEditorPlugin.getInstance().logError("Failed to get EObject by uri: " + elementURI, e); //$NON-NLS-1$
			return 0;
		}
		if (element == null) {
			return 0;
		} else if (element instanceof View) {
			EditPart editPart = (EditPart) diagramPart.getDiagramGraphicalViewer().getEditPartRegistry().get(element);
			if (editPart != null) {
				editPartCollector.add(editPart);
				return 1;
			}
		}

		String elementID = EMFCoreUtil.getProxyID(element);
		List associatedParts = diagramPart.getDiagramGraphicalViewer().findEditPartsForElement(elementID, IGraphicalEditPart.class);
		// peform the possible hierarchy disjoint -> take the top-most parts
		for (Iterator editPartIt = associatedParts.iterator(); editPartIt.hasNext();) {
			EditPart nextPart = (EditPart) editPartIt.next();
			EditPart parentPart = nextPart.getParent();
			while (parentPart != null && !associatedParts.contains(parentPart)) {
				parentPart = parentPart.getParent();
			}
			if (parentPart == null) {
				editPartCollector.add(nextPart);
			}
		}

		if (originalNumOfEditParts == editPartCollector.size()) {
			if (!associatedParts.isEmpty()) {
				editPartCollector.add(associatedParts.iterator().next());
			} else {
				element = element.eContainer();
				if (element != null) {
					return findElementsInDiagram(diagramPart, EcoreUtil.getURI(element), editPartCollector);
				}
			}
		}
		return editPartCollector.size() - originalNumOfEditParts;
	}

	/**
	 * @generated
	 */
	public static void selectElementsInDiagram(IDiagramWorkbenchPart diagramPart, List/*EditPart*/editParts) {
		diagramPart.getDiagramGraphicalViewer().deselectAll();

		EditPart firstPrimary = null;
		for (Iterator it = editParts.iterator(); it.hasNext();) {
			EditPart nextPart = (EditPart) it.next();
			diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
			if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
				firstPrimary = nextPart;
			}
		}

		if (!editParts.isEmpty()) {
			diagramPart.getDiagramGraphicalViewer().reveal(firstPrimary != null ? firstPrimary : (EditPart) editParts.get(0));
		}
	}

	/**
	 * @generated
	 */
	public static View findView(DiagramEditPart diagramEditPart, EObject targetElement, LazyElement2ViewMap lazyElement2ViewMap) {
		boolean hasStructuralURI = false;
		if (targetElement.eResource() instanceof XMLResource) {
			hasStructuralURI = ((XMLResource) targetElement.eResource()).getID(targetElement) == null;
		}

		View view = null;
		if (hasStructuralURI && !lazyElement2ViewMap.getElement2ViewMap().isEmpty()) {
			view = (View) lazyElement2ViewMap.getElement2ViewMap().get(targetElement);
		} else if (findElementsInDiagramByID(diagramEditPart, targetElement, lazyElement2ViewMap.editPartTmpHolder) > 0) {
			EditPart editPart = (EditPart) lazyElement2ViewMap.editPartTmpHolder.get(0);
			lazyElement2ViewMap.editPartTmpHolder.clear();
			view = editPart.getModel() instanceof View ? (View) editPart.getModel() : null;
		}

		return (view == null) ? diagramEditPart.getDiagramView() : view;
	}

	/**
	 * @generated
	 */
	private static int findElementsInDiagramByID(DiagramEditPart diagramPart, EObject element, List editPartCollector) {
		IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer) diagramPart.getViewer();
		final int intialNumOfEditParts = editPartCollector.size();

		if (element instanceof View) { // support notation element lookup
			EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(element);
			if (editPart != null) {
				editPartCollector.add(editPart);
				return 1;
			}
		}

		String elementID = EMFCoreUtil.getProxyID(element);
		List associatedParts = viewer.findEditPartsForElement(elementID, IGraphicalEditPart.class);
		// perform the possible hierarchy disjoint -> take the top-most parts only
		for (Iterator editPartIt = associatedParts.iterator(); editPartIt.hasNext();) {
			EditPart nextPart = (EditPart) editPartIt.next();
			EditPart parentPart = nextPart.getParent();
			while (parentPart != null && !associatedParts.contains(parentPart)) {
				parentPart = parentPart.getParent();
			}
			if (parentPart == null) {
				editPartCollector.add(nextPart);
			}
		}

		if (intialNumOfEditParts == editPartCollector.size()) {
			if (!associatedParts.isEmpty()) {
				editPartCollector.add(associatedParts.iterator().next());
			} else {
				if (element.eContainer() != null) {
					return findElementsInDiagramByID(diagramPart, element.eContainer(), editPartCollector);
				}
			}
		}
		return editPartCollector.size() - intialNumOfEditParts;
	}

	/**
	 * @generated
	 */
	public static class LazyElement2ViewMap {

		/**
		 * @generated
		 */
		private Map element2ViewMap;

		/**
		 * @generated
		 */
		private View scope;

		/**
		 * @generated
		 */
		private Set elementSet;

		/**
		 * @generated
		 */
		public final List editPartTmpHolder = new ArrayList();

		/**
		 * @generated
		 */
		public LazyElement2ViewMap(View scope, Set elements) {
			this.scope = scope;
			this.elementSet = elements;
		}

		/**
		 * @generated
		 */
		public final Map getElement2ViewMap() {
			if (element2ViewMap == null) {
				element2ViewMap = new HashMap();
				// map possible notation elements to itself as these can't be found by view.getElement()
				for (Iterator it = elementSet.iterator(); it.hasNext();) {
					EObject element = (EObject) it.next();
					if (element instanceof View) {
						View view = (View) element;
						if (view.getDiagram() == scope.getDiagram()) {
							element2ViewMap.put(element, element); // take only those that part of our diagram
						}
					}
				}

				buildElement2ViewMap(scope, element2ViewMap, elementSet);
			}
			return element2ViewMap;
		}

		/**
		 * @generated
		 */
		static Map buildElement2ViewMap(View parentView, Map element2ViewMap, Set elements) {
			if (elements.size() == element2ViewMap.size())
				return element2ViewMap;

			if (parentView.isSetElement() && !element2ViewMap.containsKey(parentView.getElement()) && elements.contains(parentView.getElement())) {
				element2ViewMap.put(parentView.getElement(), parentView);
				if (elements.size() == element2ViewMap.size())
					return element2ViewMap;
			}

			for (Iterator it = parentView.getChildren().iterator(); it.hasNext();) {
				buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
				if (elements.size() == element2ViewMap.size())
					return element2ViewMap;
			}
			for (Iterator it = parentView.getSourceEdges().iterator(); it.hasNext();) {
				buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
				if (elements.size() == element2ViewMap.size())
					return element2ViewMap;
			}
			for (Iterator it = parentView.getSourceEdges().iterator(); it.hasNext();) {
				buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
				if (elements.size() == element2ViewMap.size())
					return element2ViewMap;
			}
			return element2ViewMap;
		}
	} //LazyElement2ViewMap	
}

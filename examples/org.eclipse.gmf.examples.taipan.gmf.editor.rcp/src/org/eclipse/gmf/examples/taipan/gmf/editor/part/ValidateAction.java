/*
 * Copyright (c) 2006, 2007 Borland Software Corporation
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

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.examples.taipan.gmf.editor.providers.TaiPanValidationProvider;
import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

/**
 * @generated
 */
public class ValidateAction extends Action {

	/**
	 * @generated
	 */
	public static final String VALIDATE_ACTION_KEY = "validateAction"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	private IWorkbenchPartDescriptor workbenchPartDescriptor;

	/**
	 * @generated
	 */
	public ValidateAction(IWorkbenchPartDescriptor workbenchPartDescriptor) {
		setId(VALIDATE_ACTION_KEY);
		setText("Validate");
		this.workbenchPartDescriptor = workbenchPartDescriptor;
	}

	/**
	 * @generated
	 */
	public void run() {
		IWorkbenchPart workbenchPart = workbenchPartDescriptor.getPartPage().getActivePart();
		if (workbenchPart instanceof IDiagramWorkbenchPart) {
			final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;
			try {
				new IRunnableWithProgress() {

					public void run(IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
						runValidation(part.getDiagramEditPart(), part.getDiagram());
					}
				}.run(new NullProgressMonitor());
			} catch (Exception e) {
				TaiPanDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
			}
		}
	}

	/**
	 * @generated
	 */
	public static void runValidation(View view) {
		try {
			if (TaiPanDiagramEditorUtil.openDiagram(view.eResource())) {
				IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (editorPart instanceof IDiagramWorkbenchPart) {
					runValidation(((IDiagramWorkbenchPart) editorPart).getDiagramEditPart(), view);
				} else {
					runNonUIValidation(view);
				}
			}
		} catch (Exception e) {
			TaiPanDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
		}
	}

	/**
	 * @generated
	 */
	public static void runNonUIValidation(View view) {
		DiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance().createDiagramEditPart(view.getDiagram());
		runValidation(diagramEditPart, view);
	}

	/**
	 * @generated
	 */
	public static void runValidation(DiagramEditPart diagramEditPart, View view) {
		final DiagramEditPart fpart = diagramEditPart;
		final View fview = view;
		TaiPanValidationProvider.runWithConstraints(view, new Runnable() {

			public void run() {
				validate(fpart, fview);
			}
		});
	}

	/**
	 * @generated
	 */
	private static Diagnostic runEMFValidator(View target) {
		if (target.isSetElement() && target.getElement() != null) {
			return new Diagnostician() {

				public String getObjectLabel(EObject eObject) {
					return EMFCoreUtil.getQualifiedName(eObject, true);
				}
			}.validate(target.getElement());
		}
		return Diagnostic.OK_INSTANCE;
	}

	/**
	 * @generated
	 */
	private static void validate(DiagramEditPart diagramEditPart, View view) {
		View target = view;
		getMarkers(diagramEditPart.getViewer()).clear();
		Diagnostic diagnostic = runEMFValidator(view);
		createMarkers(target, diagnostic, diagramEditPart);
		IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		if (view.isSetElement() && view.getElement() != null) {
			IStatus status = validator.validate(view.getElement());
			createMarkers(target, status, diagramEditPart);
		}
	}

	/**
	 * @generated
	 */
	private static void createMarkers(View target, IStatus validationStatus, DiagramEditPart diagramEditPart) {
		if (validationStatus.isOK()) {
			return;
		}
		final IStatus rootStatus = validationStatus;
		List allStatuses = new ArrayList();
		TaiPanDiagramEditorUtil.LazyElement2ViewMap element2ViewMap = new TaiPanDiagramEditorUtil.LazyElement2ViewMap(diagramEditPart.getDiagramView(), collectTargetElements(rootStatus,
				new HashSet(), allStatuses));
		for (Iterator it = allStatuses.iterator(); it.hasNext();) {
			IConstraintStatus nextStatus = (IConstraintStatus) it.next();
			View view = TaiPanDiagramEditorUtil.findView(diagramEditPart, nextStatus.getTarget(), element2ViewMap);
			addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view), EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), nextStatus.getMessage(), nextStatus
					.getSeverity());
		}
	}

	/**
	 * @generated
	 */
	private static void createMarkers(View target, Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {
		if (emfValidationStatus.getSeverity() == Diagnostic.OK) {
			return;
		}
		final Diagnostic rootStatus = emfValidationStatus;
		List allDiagnostics = new ArrayList();
		TaiPanDiagramEditorUtil.LazyElement2ViewMap element2ViewMap = new TaiPanDiagramEditorUtil.LazyElement2ViewMap(diagramEditPart.getDiagramView(), collectTargetElements(rootStatus,
				new HashSet(), allDiagnostics));
		for (Iterator it = emfValidationStatus.getChildren().iterator(); it.hasNext();) {
			Diagnostic nextDiagnostic = (Diagnostic) it.next();
			List data = nextDiagnostic.getData();
			if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
				EObject element = (EObject) data.get(0);
				View view = TaiPanDiagramEditorUtil.findView(diagramEditPart, element, element2ViewMap);
				addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view), EMFCoreUtil.getQualifiedName(element, true), nextDiagnostic.getMessage(),
						diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
			}
		}
	}

	/**
	 * @generated
	 */
	private static void addMarker(EditPartViewer viewer, View target, String elementId, String location, String message, int statusSeverity) {
		if (target == null) {
			return;
		}
		getMarkers(viewer, target, true).add(new Marker(elementId, location, message, statusSeverity));
	}

	/**
	 * @generated
	 */
	private static int diagnosticToStatusSeverity(int diagnosticSeverity) {
		if (diagnosticSeverity == Diagnostic.OK) {
			return IStatus.OK;
		} else if (diagnosticSeverity == Diagnostic.INFO) {
			return IStatus.INFO;
		} else if (diagnosticSeverity == Diagnostic.WARNING) {
			return IStatus.WARNING;
		} else if (diagnosticSeverity == Diagnostic.ERROR || diagnosticSeverity == Diagnostic.CANCEL) {
			return IStatus.ERROR;
		}
		return IStatus.INFO;
	}

	/**
	 * @generated
	 */
	private static Set collectTargetElements(IStatus status, Set targetElementCollector, List allConstraintStatuses) {
		if (status instanceof IConstraintStatus) {
			targetElementCollector.add(((IConstraintStatus) status).getTarget());
			allConstraintStatuses.add(status);
		}
		if (status.isMultiStatus()) {
			IStatus[] children = status.getChildren();
			for (int i = 0; i < children.length; i++) {
				collectTargetElements(children[i], targetElementCollector, allConstraintStatuses);
			}
		}
		return targetElementCollector;
	}

	/**
	 * @generated
	 */
	private static Set collectTargetElements(Diagnostic diagnostic, Set targetElementCollector, List allDiagnostics) {
		List data = diagnostic.getData();
		EObject target = null;
		if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
			target = (EObject) data.get(0);
			targetElementCollector.add(target);
			allDiagnostics.add(diagnostic);
		}
		if (diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {
			for (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {
				collectTargetElements((Diagnostic) it.next(), targetElementCollector, allDiagnostics);
			}
		}
		return targetElementCollector;
	}

	/**
	 * @generated
	 */
	private static Map getMarkers(EditPartViewer viewer) {
		Map markers = (Map) viewer.getProperty(VALIDATE_ACTION_KEY);
		if (markers == null) {
			markers = new HashMap();
			viewer.setProperty(VALIDATE_ACTION_KEY, markers);
		}
		return markers;
	}

	/**
	 * @generated
	 */
	private static Set getMarkers(EditPartViewer viewer, View view, boolean create) {
		Set markers = (Set) getMarkers(viewer).get(view);
		if (markers == null) {
			if (!create) {
				return Collections.EMPTY_SET;
			}
			markers = new HashSet();
			getMarkers(viewer).put(view, markers);
		}
		return markers;
	}

	/**
	 * @generated
	 */
	private static Marker[] getMarkers(EditPartViewer viewer, View view) {
		Set markers = getMarkers(viewer, view, false);
		if (markers.isEmpty()) {
			return Marker.EMPTY_ARRAY;
		}
		return (Marker[]) markers.toArray(new Marker[markers.size()]);
	}

	/**
	 * @generated
	 */
	public static class Marker {

		/**
		 * @generated
		 */
		public static final Marker[] EMPTY_ARRAY = new Marker[0];

		/**
		 * @generated
		 */
		private final String elementId;

		/**
		 * @generated
		 */
		private final String location;

		/**
		 * @generated
		 */
		private final String message;

		/**
		 * @generated
		 */
		private final int statusSeverity;

		/**
		 * @generated
		 */
		public Marker(String elementId, String location, String message, int statusSeverity) {
			this.elementId = elementId;
			this.location = location;
			this.message = message;
			this.statusSeverity = statusSeverity;
		}

		/**
		 * @generated
		 */
		public String getElementId() {
			return elementId;
		}

		/**
		 * @generated
		 */
		public String getLocation() {
			return location;
		}

		/**
		 * @generated
		 */
		public String getMessage() {
			return message;
		}

		/**
		 * @generated
		 */
		public int getStatusSeverity() {
			return statusSeverity;
		}
	}
}

/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.diagram.providers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;

import org.eclipse.emf.common.util.Diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Diagnostician;

import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IConstraintStatus;

import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;

import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;

import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;

import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import org.eclipse.ui.IWorkbenchPart;

/**
 * @generated
 */
public class MindmapValidationProvider extends AbstractContributionItemProvider {

	/**
	 * @generated
	 */
	protected IAction createAction(String actionId, IWorkbenchPartDescriptor partDescriptor) {
		if (ValidateAction.VALIDATE_ACTION_KEY.equals(actionId)) {
			return new ValidateAction(partDescriptor);
		}
		return super.createAction(actionId, partDescriptor);
	}

	/**
	 * @generated
	 */
	public static class ValidateAction extends Action {

		/**
		 * @generated
		 */
		public static final String MARKER_TYPE = MindmapDiagramEditorPlugin.ID + ".diagnostic"; //$NON-NLS-1$

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
					part.getDiagramEditPart().getEditingDomain().runExclusive(new Runnable() {

						public void run() {
							validate(part.getDiagram());
						}
					});
				} catch (Exception e) {
					MindmapDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
				}
			}
		}

		/**
		 * @generated
		 */
		private void validate(Diagram diagram) {
			IFile diagramFile = WorkspaceSynchronizer.getFile(diagram.eResource());
			try {
				diagramFile.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				MindmapDiagramEditorPlugin.getInstance().logError(null, e);
			}
			Diagnostic diagnostic = new Diagnostician() {

				public String getObjectLabel(EObject eObject) {
					return EMFCoreUtil.getQualifiedName(eObject, true);
				}
			}.validate(diagram.getElement());

			IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
			IStatus status = validator.validate(diagram.getElement());
			List allStatuses = new ArrayList();
			allStatuses.addAll(Arrays.asList(status.isMultiStatus() ? status.getChildren() : new IStatus[] { status }));

			HashSet targets = new HashSet();
			for (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {
				targets.add(getDiagnosticTarget((Diagnostic) it.next()));
			}

			for (Iterator it = allStatuses.iterator(); it.hasNext();) {
				Object nextStatus = it.next();
				if (nextStatus instanceof IConstraintStatus) {
					targets.add(((IConstraintStatus) nextStatus).getTarget());
				}
			}

			Map viewMap = buildElement2ViewMap(diagram, targets);
			for (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {
				Diagnostic nextDiagnostic = (Diagnostic) it.next();
				List data = nextDiagnostic.getData();
				if (!data.isEmpty() && data.get(0) instanceof EObject) {
					EObject element = (EObject) data.get(0);
					View view = findTargetView(element, viewMap);
					addMarker(diagramFile, view != null ? view : diagram, element, nextDiagnostic.getMessage(), diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
				}
			}

			for (Iterator it = allStatuses.iterator(); it.hasNext();) {
				Object nextStatusObj = it.next();
				if (nextStatusObj instanceof IConstraintStatus) {
					IConstraintStatus nextStatus = (IConstraintStatus) nextStatusObj;
					View view = findTargetView(nextStatus.getTarget(), viewMap);
					addMarker(diagramFile, view != null ? view : diagram, nextStatus.getTarget(), nextStatus.getMessage(), nextStatus.getSeverity());
				}
			}
		}

		/**
		 * @generated
		 */
		private View findTargetView(EObject targetElement, Map viewMap) {
			if (targetElement instanceof View) {
				return (View) targetElement;
			}
			for (EObject container = targetElement; container != null; container = container.eContainer()) {
				if (viewMap.containsKey(container))
					return (View) viewMap.get(container);
			}
			return null;
		}

		/**
		 * @generated
		 */
		private Map buildElement2ViewMap(Diagram diagram, Set targets) {
			HashMap map = new HashMap();
			getElement2ViewMap(diagram, map, targets);
			if (!targets.isEmpty()) {
				Set path = new HashSet();
				for (Iterator it = targets.iterator(); it.hasNext();) {
					EObject nextNotMapped = (EObject) it.next();
					for (EObject container = nextNotMapped.eContainer(); container != null; container = container.eContainer()) {
						if (!map.containsKey(container)) {
							path.add(container);
						} else
							break;
					}
				}
				getElement2ViewMap(diagram, map, path);
			}
			return map;
		}

		/**
		 * @generated
		 */
		private void getElement2ViewMap(View view, Map map, Set targets) {
			if (!map.containsKey(view.getElement()) && targets.remove(view.getElement())) {
				map.put(view.getElement(), view);
			}
			for (Iterator it = view.getChildren().iterator(); it.hasNext();) {
				getElement2ViewMap((View) it.next(), map, targets);
			}
			if (view instanceof Diagram) {
				for (Iterator it = ((Diagram) view).getEdges().iterator(); it.hasNext();) {
					getElement2ViewMap((View) it.next(), map, targets);
				}
			}
		}

		/**
		 * @generated
		 */
		private void addMarker(IFile file, View view, EObject element, String message, int statusSeverity) {
			try {
				IMarker marker = file.createMarker(MARKER_TYPE);
				marker.setAttribute(IMarker.MESSAGE, message);
				marker.setAttribute(IMarker.LOCATION, EMFCoreUtil.getQualifiedName(element, true));
				marker.setAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, ViewUtil.getIdStr(view));
				int markerSeverity = IMarker.SEVERITY_INFO;
				if (statusSeverity == IStatus.WARNING) {
					markerSeverity = IMarker.SEVERITY_WARNING;
				} else if (statusSeverity == IStatus.ERROR || statusSeverity == IStatus.CANCEL) {
					markerSeverity = IMarker.SEVERITY_ERROR;
				}
				marker.setAttribute(IMarker.SEVERITY, markerSeverity);
			} catch (CoreException e) {
				MindmapDiagramEditorPlugin.getInstance().logError(null, e);
			}
		}

		/**
		 * @generated
		 */
		private EObject getDiagnosticTarget(Diagnostic diagnostic) {
			if (!diagnostic.getData().isEmpty()) {
				Object target = diagnostic.getData().get(0);
				return target instanceof EObject ? (EObject) target : null;
			}
			return null;
		}

		/**
		 * @generated
		 */
		private int diagnosticToStatusSeverity(int diagnosticSeverity) {
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
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		EObject domainElement = null;
		if (object instanceof View) {
			View view = (View) object;
			domainElement = view.getElement() != null ? view.getElement() : view.getDiagram().getElement();
		} else if (object instanceof EObject) {
			domainElement = (EObject) object;
		} else {
			return false;
		}
		EPackage domainPackage = domainElement.eClass().getEPackage();
		return domainPackage == org.eclipse.gmf.examples.mindmap.MindmapPackage.eINSTANCE;
	}

	/**
	 * @generated
	 */
	public static class DefaultCtx implements IClientSelector {

		/**
		 * @generated
		 */
		public boolean selects(Object object) {
			return isInDefaultEditorContext(object);
		}
	}

} //MindmapValidationProvider

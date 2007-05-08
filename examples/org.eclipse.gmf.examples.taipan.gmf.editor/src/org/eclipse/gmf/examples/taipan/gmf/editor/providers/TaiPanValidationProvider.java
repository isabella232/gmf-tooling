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
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.common.util.Diagnostic;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.util.Diagnostician;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;

import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.emf.validation.model.IConstraintStatus;

import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;

import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;

import org.eclipse.gmf.examples.taipan.TaiPanPackage;

import org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts.AquatoryEditPart;

import org.eclipse.gmf.examples.taipan.gmf.editor.expressions.TaiPanAbstractExpression;

import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorUtil;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanVisualIDRegistry;

import org.eclipse.gmf.runtime.common.ui.services.action.contributionitem.AbstractContributionItemProvider;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;

import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;

import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;

import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import org.eclipse.jface.operation.IRunnableWithProgress;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;

import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;

/**
 * @generated
 */
public class TaiPanValidationProvider extends AbstractContributionItemProvider {

	/**
	 * @generated
	 */
	private static boolean constraintsActive = false;

	/**
	 * @generated
	 */
	public static boolean shouldConstraintsBePrivate() {
		return false;
	}

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
					new WorkspaceModifyDelegatingOperation(new IRunnableWithProgress() {

						public void run(IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
							runValidation(part.getDiagramEditPart(), part.getDiagram());
						}
					}).run(new NullProgressMonitor());
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
			final View target = view;
			final DiagramEditPart diagramPart = diagramEditPart;
			Runnable task = new Runnable() {

				public void run() {
					try {
						constraintsActive = true;
						validate(diagramPart, target);
					} finally {
						constraintsActive = false;
					}
				}
			};
			TransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(target);
			if (txDomain != null) {
				try {
					txDomain.runExclusive(task);
				} catch (Exception e) {
					TaiPanDiagramEditorPlugin.getInstance().logError("Validation action failed", e); //$NON-NLS-1$
				}
			} else {
				task.run();
			}
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
		private static void validate(DiagramEditPart diagramEditPart, View target) {
			IFile diagramFile = (target.eResource() != null) ? WorkspaceSynchronizer.getFile(target.eResource()) : null;
			if (diagramFile != null) {
				TaiPanMarkerNavigationProvider.deleteMarkers(diagramFile);
			}
			Diagnostic diagnostic = runEMFValidator(target);
			createMarkers(diagramFile, diagnostic, diagramEditPart);
			IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(EvaluationMode.BATCH);
			validator.setIncludeLiveConstraints(true);
			if (target.isSetElement() && target.getElement() != null) {
				IStatus status = validator.validate(target.getElement());
				createMarkers(diagramFile, status, diagramEditPart);
			}
		}

		/**
		 * @generated
		 */
		private static void createMarkers(IFile diagramFile, IStatus validationStatus, DiagramEditPart diagramEditPart) {
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
				addMarker(diagramFile, view.eResource().getURIFragment(view), EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), nextStatus.getMessage(), nextStatus.getSeverity());
			}
		}

		/**
		 * @generated
		 */
		private static void createMarkers(IFile diagramFile, Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {
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
					addMarker(diagramFile, view.eResource().getURIFragment(view), EMFCoreUtil.getQualifiedName(element, true), nextDiagnostic.getMessage(), diagnosticToStatusSeverity(nextDiagnostic
							.getSeverity()));
				}
			}
		}

		/**
		 * @generated
		 */
		private static void addMarker(IFile file, String elementId, String location, String message, int statusSeverity) {
			if (file == null) {
				return;
			}
			TaiPanMarkerNavigationProvider.addMarker(file, elementId, location, message, statusSeverity);
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
	}

	/**
	 * @generated
	 */
	static boolean isInDefaultEditorContext(Object object) {
		if (shouldConstraintsBePrivate() && !constraintsActive) {
			return false;
		}
		if (object instanceof View) {
			return constraintsActive && AquatoryEditPart.MODEL_ID.equals(TaiPanVisualIDRegistry.getModelID((View) object));
		}
		return true;
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

	/**
	 * @generated
	 */
	public static class Adapter2 extends AbstractModelConstraint {

		/**
		 * @generated
		 */
		private TaiPanAbstractExpression expression;

		/**
		 * @generated
		 */
		public Adapter2() {
			expression = new TaiPanAbstractExpression(EcorePackage.eINSTANCE.getEString()) {

				protected Object doEvaluate(Object context, Map env) {
					String self = (String) context;
					return JavaAudits.selflength0(self);
				}
			};
		}

		/**
		 * @generated
		 */
		public IStatus validate(IValidationContext ctx) {
			Object evalCtx = ctx.getTarget();
			if (evalCtx instanceof EObject)
				evalCtx = ((EObject) evalCtx).eGet(TaiPanPackage.eINSTANCE.getShip_Name());
			if (evalCtx == null) {
				return ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) });
			}
			Object result = expression.evaluate(evalCtx);
			if (result instanceof Boolean && ((Boolean) result).booleanValue()) {
				return Status.OK_STATUS;
			}
			return ctx.createFailureStatus(new Object[] { EMFCoreUtil.getQualifiedName(ctx.getTarget(), true) });
		}
	}

	/**
	 * @generated
	 */
	static class JavaAudits {

		/**
		 * @generated NOT
		 */
		private static Boolean selflength0(String self) {
			return Boolean.valueOf(self.length() > 0);
		}
	} //JavaAudits
} //TaiPanValidationProvider

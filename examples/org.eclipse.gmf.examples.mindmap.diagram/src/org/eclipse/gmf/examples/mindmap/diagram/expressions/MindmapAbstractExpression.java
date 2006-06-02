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
package org.eclipse.gmf.examples.mindmap.diagram.expressions;

import java.util.Collections;
import java.util.Map;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import org.eclipse.emf.ecore.EClassifier;

import org.eclipse.gmf.examples.mindmap.diagram.part.MindmapDiagramEditorPlugin;

/**
 * @generated
 */
public abstract class MindmapAbstractExpression {

	/**
	 * @generated
	 */
	private String body;

	/**
	 * @generated
	 */
	private EClassifier context;

	/**
	 * @generated
	 */
	private IStatus status = Status.OK_STATUS;

	/**
	 * @generated
	 */
	protected MindmapAbstractExpression(EClassifier context) {
		this.context = context;
	}

	/**
	 * @generated
	 */
	protected MindmapAbstractExpression(String body, EClassifier context, Map env) {
		this.body = body;
		this.context = context;
	}

	/**
	 * @generated
	 */
	protected void setStatus(int severity, String message, Throwable throwable) {
		String pluginID = MindmapDiagramEditorPlugin.ID;
		this.status = new Status(severity, pluginID, -1, (message != null) ? message : "", throwable); //$NON-NLS-1$
		if (!this.status.isOK()) {
			MindmapDiagramEditorPlugin.getInstance().logError("Expression problem:" + message + "body:" + body, throwable); //$NON-NLS-1$ //$NON-NLS-2$

		}
	}

	/**
	 * @generated
	 */
	protected abstract Object doEvaluate(Object context, Map env);

	/**
	 * @generated
	 */
	public Object evaluate(Object context) {
		return evaluate(context, Collections.EMPTY_MAP);
	}

	/**
	 * @generated
	 */
	public Object evaluate(Object context, Map env) {
		if (context().isInstance(context)) {
			try {
				return doEvaluate(context, env);
			} catch (Exception e) {
				MindmapDiagramEditorPlugin.getInstance().logError("Expression evaluation failure: " + body, e);
				return null;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	public IStatus getStatus() {
		return status;
	}

	/**
	 * @generated
	 */
	public String body() {
		return body;
	}

	/**
	 * @generated
	 */
	public EClassifier context() {
		return context;
	}

	/**
	 * @generated
	 */
	public static final MindmapAbstractExpression createNullExpression(EClassifier context) {
		return new MindmapAbstractExpression(context) {

			protected Object doEvaluate(Object context, Map env) {
				// TODO - log entry about not provider available for this expression
				return null;
			}
		};
	}
}

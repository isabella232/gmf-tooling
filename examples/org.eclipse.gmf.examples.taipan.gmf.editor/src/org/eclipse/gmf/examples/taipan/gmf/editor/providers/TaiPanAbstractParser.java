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
package org.eclipse.gmf.examples.taipan.gmf.editor.providers;

import java.text.MessageFormat;
import java.text.ParsePosition;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorPlugin;

/**
 * @generated
 */
public abstract class TaiPanAbstractParser implements IParser {

	/**
	 * @generated
	 */
	private String viewPattern;

	/**
	 * @generated
	 */
	private MessageFormat viewProcessor;

	/**
	 * @generated
	 */
	private String editPattern;

	/**
	 * @generated
	 */
	private MessageFormat editProcessor;

	/**
	 * @generated
	 */
	public String getViewPattern() {
		return viewPattern;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getViewProcessor() {
		return viewProcessor;
	}

	/**
	 * @generated
	 */
	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
		viewProcessor = createViewProcessor(viewPattern);
	}

	/**
	 * @generated
	 */
	protected MessageFormat createViewProcessor(String viewPattern) {
		return new MessageFormat(viewPattern);
	}

	/**
	 * @generated
	 */
	public String getEditPattern() {
		return editPattern;
	}

	/**
	 * @generated
	 */
	protected MessageFormat getEditProcessor() {
		return editProcessor;
	}

	/**
	 * @generated
	 */
	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
		editProcessor = createEditProcessor(editPattern);
	}

	/**
	 * @generated
	 */
	protected MessageFormat createEditProcessor(String editPattern) {
		return new MessageFormat(editPattern);
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		return getStringByPattern(adapter, flags, getViewPattern(), getViewProcessor());
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		return getStringByPattern(adapter, flags, getEditPattern(), getEditProcessor());
	}

	/**
	 * @generated
	 */
	protected abstract String getStringByPattern(IAdaptable adapter, int flags, String pattern, MessageFormat processor);

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		ParsePosition pos = new ParsePosition(0);
		Object[] values = getEditProcessor().parse(editString, pos);
		if (values == null) {
			return new ParserEditStatus(TaiPanDiagramEditorPlugin.ID, IParserEditStatus.UNEDITABLE, "Invalid input at " + pos.getErrorIndex());
		}
		return validateNewValues(values);
	}

	/**
	 * @generated
	 */
	protected IParserEditStatus validateNewValues(Object[] values) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public ICommand getParseCommand(IAdaptable adapter, String newString, int flags) {
		Object[] newValues = getEditProcessor().parse(newString, new ParsePosition(0));
		if (newValues == null || validateNewValues(newValues).getCode() != IParserEditStatus.EDITABLE) {
			return UnexecutableCommand.INSTANCE;
		}
		return getParseCommand(adapter, newValues);
	}

	/**
	 * @generated
	 */
	protected abstract ICommand getParseCommand(IAdaptable adapter, Object[] newValues);

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * @generated
	 */
	protected ICommand getModificationCommand(EObject element, EStructuralFeature feature, Object value) {
		SetRequest request = new SetRequest(element, feature, value);
		return new SetValueCommand(request);
	}
}

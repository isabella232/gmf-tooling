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
import java.text.ParseException;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserEditStatus;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserEditStatus;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractModelCommand;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;

/**
 * @generated
 */
public abstract class TaiPanAbstractParser implements IParser {

	/**
	 * @generated
	 */
	private static final Object[] NO_VALUES = new Object[0];

	/**
	 * @generated
	 */
	private String viewPattern;

	/**
	 * @generated
	 */
	private String editPattern;

	/**
	 * @generated
	 */
	public String getViewPattern() {
		return viewPattern;
	}

	/**
	 * @generated
	 */
	public void setViewPattern(String viewPattern) {
		this.viewPattern = viewPattern;
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
	public void setEditPattern(String editPattern) {
		this.editPattern = editPattern;
	}

	/**
	 * @generated
	 */
	public String getPrintString(IAdaptable adapter, int flags) {
		return getStringByPattern(adapter, flags, getViewPattern());
	}

	/**
	 * @generated
	 */
	public String getEditString(IAdaptable adapter, int flags) {
		return getStringByPattern(adapter, flags, getEditPattern());
	}

	/**
	 * @generated
	 */
	protected abstract String getStringByPattern(IAdaptable adapter, int flags, String pattern);

	/**
	 * @generated
	 */
	protected Object[] getValuesFromEditString(String editString, String pattern) {
		Object[] values;
		try {
			values = new MessageFormat(pattern).parse(editString);
		} catch (ParseException pe) {
			values = NO_VALUES;
		}
		return values;
	}

	/**
	 * @generated
	 */
	public IParserEditStatus isValidEditString(IAdaptable element, String editString) {
		return ParserEditStatus.EDITABLE_STATUS;
	}

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor(IAdaptable element) {
		return null;
	}

	/**
	 * @generated
	 */
	protected ICommand getModelCommand(ICommand semanticCommand) {
		final ICommand command = semanticCommand;
		return new AbstractModelCommand(command.getLabel(), command.getAffectedObjects()) {

			protected CommandResult doExecute(IProgressMonitor progressMonitor) {
				command.execute(progressMonitor);
				return command.getCommandResult();
			}
		};
	}
}

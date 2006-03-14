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
package org.eclipse.gmf.examples.taipan.gmf.editor.edit.parts;

import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserOptions;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.viewers.ICellEditorValidator;

/**
 * @generated
 */
public interface ITextAwareEditPart extends org.eclipse.gef.GraphicalEditPart {

	/**
	 * @generated
	 */
	public String getEditText();

	/**
	 * @generated
	 */
	public ICellEditorValidator getEditTextValidator();

	/**
	 * @generated
	 */
	public ParserOptions getParserOptions();

	/**
	 * @generated
	 */
	public IParser getParser();

	/**
	 * @generated
	 */
	public IContentAssistProcessor getCompletionProcessor();
}

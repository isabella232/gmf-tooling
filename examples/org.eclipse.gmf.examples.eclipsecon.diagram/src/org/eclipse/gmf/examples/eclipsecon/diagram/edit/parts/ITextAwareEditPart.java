package org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts;

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

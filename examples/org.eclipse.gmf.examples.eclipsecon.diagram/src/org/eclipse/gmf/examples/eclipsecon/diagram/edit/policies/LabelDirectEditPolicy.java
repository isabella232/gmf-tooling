package org.eclipse.gmf.examples.eclipsecon.diagram.edit.policies;

import org.eclipse.draw2d.Label;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.parts.TextCellEditorEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.ITextAwareEditPart;

/**
 * @generated
 */
public class LabelDirectEditPolicy extends DirectEditPolicy {

	/**
	 * @generated
	 */
	class EObjectAdapterEx extends EObjectAdapter {

		private View view = null;

		/**
		 * constructor
		 * @param element	element to be wrapped
		 * @param view	view to be wrapped
		 */
		public EObjectAdapterEx(EObject element, View view) {
			super(element);
			this.view = view;
		}

		public Object getAdapter(Class adapter) {
			Object o = super.getAdapter(adapter);
			if (o != null)
				return o;
			if (adapter.equals(View.class)) {
				return view;
			}
			return null;
		}
	}

	/**
	 * @generated
	 */
	protected Command getDirectEditCommand(DirectEditRequest edit) {
		if (edit.getCellEditor() instanceof TextCellEditorEx)
			if (!((TextCellEditorEx) edit.getCellEditor()).hasValueChanged())
				return null;

		String labelText = (String) edit.getCellEditor().getValue();

		//for CellEditor, null is always returned for invalid values
		if (labelText == null) {
			return null;
		}

		ITextAwareEditPart compartment = (ITextAwareEditPart) getHost();
		View view = (View) compartment.getModel();
		EObjectAdapter elementAdapter = null;
		if (view != null)
			elementAdapter = new EObjectAdapterEx(ViewUtil
					.resolveSemanticElement(view), view);
		else
			elementAdapter = new EObjectAdapterEx((EObject) compartment
					.getModel(), null);
		// check to make sure an edit has occurred before returning a command.
		String prevText = compartment.getParser().getEditString(elementAdapter,
				compartment.getParserOptions().intValue());
		if (!prevText.equals(labelText)) {
			ICommand iCommand = compartment.getParser().getParseCommand(
					elementAdapter, labelText, 0);
			return new EtoolsProxyCommand(iCommand);
		}

		return null;
	}

	/**
	 * @generated
	 */
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		if (getHostFigure() instanceof Label) {
			((Label) getHostFigure()).setText(value);
		} else {
			((WrapLabel) getHostFigure()).setText(value);
		}
	}
}

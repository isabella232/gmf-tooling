package pins.diagram.edit.policies;

import org.eclipse.gmf.tooling.runtime.edit.policies.effect.AbstractOclVisualEffectEditPolicy;

import pins.diagram.edit.parts.VisiblePinEditPart;

/**
 * @generated
 */
public class VisiblePinPin2002Policy extends AbstractOclVisualEffectEditPolicy {

	/**
	 * @generated
	 */
	public static final String KEY = "pins.diagram.edit.policies.VisiblePinPin2002Policy:KEY";

	/**
	 * @generated
	 */
	public VisiblePinPin2002Policy() {
		super();
	}

	/**
	 * @generated
	 */
	@Override
	protected void setVisualEffectValue(Object value) {
		getHostImpl().getPrimaryShape().getFigureVisiblePinWarningLabelFigure().setVisible((Boolean) value);

	}

	/**
	 * @generated
	 */
	@Override
	protected VisiblePinEditPart getHostImpl() {
		return (VisiblePinEditPart) super.getHostImpl();
	}

	/**
	 * @generated
	 */
	@Override
	protected String getExpressionBody() {
		return "self.getChildren->size()<3"; //$NON-NLS-1$
	}

}

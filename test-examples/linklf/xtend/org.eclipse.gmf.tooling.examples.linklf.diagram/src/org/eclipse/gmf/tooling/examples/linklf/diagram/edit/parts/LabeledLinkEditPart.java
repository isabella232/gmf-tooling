package org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.policies.LabeledLinkItemSemanticEditPolicy;

/**
 * @generated
 */
public class LabeledLinkEditPart extends ConnectionNodeEditPart implements ITreeBranchEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4002;

	/**
	 * @generated
	 */
	public LabeledLinkEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new LabeledLinkItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	/**
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new LabeledLinkFigure();
	}

	/**
	 * @generated
	 */
	public LabeledLinkFigure getPrimaryShape() {
		return (LabeledLinkFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class LabeledLinkFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureSourceNameFIgure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureTargetNameFigure;

		/**
		 * @generated
		 */
		private WrappingLabel fFigureLinkName;

		/**
		 * @generated
		 */
		public LabeledLinkFigure() {

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureLinkName = new WrappingLabel();

			fFigureLinkName.setText("LabeldLink");

			this.add(fFigureLinkName);

			fFigureSourceNameFIgure = new WrappingLabel();

			fFigureSourceNameFIgure.setText("Source");

			this.add(fFigureSourceNameFIgure);

			fFigureTargetNameFigure = new WrappingLabel();

			fFigureTargetNameFigure.setText("Target");

			this.add(fFigureTargetNameFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSourceNameFIgure() {
			return fFigureSourceNameFIgure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureTargetNameFigure() {
			return fFigureTargetNameFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureLinkName() {
			return fFigureLinkName;
		}

	}

}

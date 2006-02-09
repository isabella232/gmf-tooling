package org.eclipse.gmf.ecore.edit.commands;

import java.util.Collection;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractModelCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class EcoreReorientConnectionViewCommand extends AbstractModelCommand {

	/**
	 * @generated
	 */
	private IAdaptable edgeAdaptor;

	/**
	 * @generated
	 */
	public EcoreReorientConnectionViewCommand(String label) {
		super(label, null);
	}

	/**
	 * @generated
	 */
	public Collection getAffectedObjects() {
		View view = (View) edgeAdaptor.getAdapter(View.class);
		if (view != null) {
			return getWorkspaceFilesFor(view);
		}
		return super.getAffectedObjects();
	}

	/**
	 * @generated
	 */
	public IAdaptable getEdgeAdaptor() {
		return edgeAdaptor;
	}

	/**
	 * @generated
	 */
	public void setEdgeAdaptor(IAdaptable edgeAdaptor) {
		this.edgeAdaptor = edgeAdaptor;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecute(IProgressMonitor progressMonitor) {
		assert null != edgeAdaptor : "Null child in EcoreReorientConnectionViewCommand"; //$NON-NLS-1$
		Edge edge = (Edge) getEdgeAdaptor().getAdapter(Edge.class);
		assert null != edge : "Null edge in EcoreReorientConnectionViewCommand"; //$NON-NLS-1$

		View tempView = edge.getSource();
		edge.setSource(edge.getTarget());
		edge.setTarget(tempView);

		return newOKCommandResult();
	}
}

package org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.policies;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.edit.parts.ThreadEditPart;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapDiagramUpdater;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapNodeDescriptor;
import org.eclipse.gmf.examples.mindmap.rcp.diagram.part.MindmapVisualIDRegistry;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class TopicThreadCompartmentCanonicalEditPolicy extends
		CanonicalEditPolicy {

	/**
	 * @generated
	 */
	Set myFeaturesToSynchronize;

	/**
	 * @generated
	 */
	protected List getSemanticChildrenList() {
		View viewObject = (View) getHost().getModel();
		List result = new LinkedList();
		for (Iterator it = MindmapDiagramUpdater
				.getTopicThreadCompartment_7001SemanticChildren(viewObject)
				.iterator(); it.hasNext();) {
			result.add(((MindmapNodeDescriptor) it.next()).getModelElement());
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected boolean isOrphaned(Collection semanticChildren, final View view) {
		int visualID = MindmapVisualIDRegistry.getVisualID(view);
		switch (visualID) {
		case ThreadEditPart.VISUAL_ID:
			return !semanticChildren.contains(view.getElement())
					|| visualID != MindmapVisualIDRegistry.getNodeVisualID(
							(View) getHost().getModel(), view.getElement());
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected String getDefaultFactoryHint() {
		return null;
	}

	/**
	 * @generated
	 */
	protected Set getFeaturesToSynchronize() {
		if (myFeaturesToSynchronize == null) {
			myFeaturesToSynchronize = new HashSet();
			myFeaturesToSynchronize.add(MindmapPackage.eINSTANCE
					.getTopic_Comments());
		}
		return myFeaturesToSynchronize;
	}

}

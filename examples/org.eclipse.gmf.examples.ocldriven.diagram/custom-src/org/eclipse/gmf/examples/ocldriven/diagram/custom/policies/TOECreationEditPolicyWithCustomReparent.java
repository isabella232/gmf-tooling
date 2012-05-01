package org.eclipse.gmf.examples.ocldriven.diagram.custom.policies;

import org.eclipse.gmf.examples.ocldriven.toe.diagram.part.TOEVisualIDRegistry;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

public class TOECreationEditPolicyWithCustomReparent extends CreationEditPolicyWithCustomReparent {

	public TOECreationEditPolicyWithCustomReparent() {
		super(TOEVisualIDRegistry.TYPED_INSTANCE);
	}

}

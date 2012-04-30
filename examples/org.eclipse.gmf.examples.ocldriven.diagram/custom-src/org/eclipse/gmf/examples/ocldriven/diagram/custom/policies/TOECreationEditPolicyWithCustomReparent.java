package org.eclipse.gmf.examples.ocldriven.diagram.custom.policies;

public class TOECreationEditPolicyWithCustomReparent extends CreationEditPolicyWithCustomReparent {

	public TOECreationEditPolicyWithCustomReparent() {
		super(new TOEVisualIDRegistryImpl());
	}

}

package org.eclipse.gmf.bridge.genmodel;

public class NotationViewFactoryNamingStrategy extends DefaultNamingStrategy {
	
	protected String getLinkSuffix() {
		return getNodeSuffix();
	}

	protected String getNodeSuffix() {
		return "NotationViewFactory";
	}

	protected String getCanvasSuffix() {
		return getNodeSuffix();
	}

	protected String getChildNodeSuffix() {
		return getNodeSuffix();
	}
	
	protected String getChildNodeLabelSuffix() {
		return getNodeSuffix();
	}

	protected String getCompartmentSuffix() {
		return getNodeSuffix();
	}

	protected String getLinkLabelSuffix() {
		return getNodeSuffix();
	}

	protected String getNodeLabelSuffix() {
		return getNodeSuffix();
	}
	
}

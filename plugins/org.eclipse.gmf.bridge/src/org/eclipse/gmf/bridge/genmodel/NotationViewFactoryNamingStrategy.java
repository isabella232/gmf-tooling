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

}

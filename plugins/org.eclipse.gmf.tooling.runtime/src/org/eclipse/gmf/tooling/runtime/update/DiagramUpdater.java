package org.eclipse.gmf.tooling.runtime.update;

import java.util.List;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @since 3.0
 */
public interface DiagramUpdater {

	public List<? extends UpdaterNodeDescriptor> getSemanticChildren(View view);

	public List<? extends UpdaterLinkDescriptor> getContainedLinks(View view);

	public List<? extends UpdaterLinkDescriptor> getIncomingLinks(View view);

	public List<? extends UpdaterLinkDescriptor> getOutgoingLinks(View view);
}

/*
/*
 * Copyright (c) 2006 Borland Software Corporation, 2013 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #403577, [optionally] avoid GenTopLevelNode / GenChildNode separation
 */
package org.eclipse.gmf.internal.bridge;

import org.eclipse.gmf.codegen.gmfgen.GenChildNodeBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;

/**
 * Doesn't expect <code>get(whatever)</code> to be invoked more then once for the same argument instance.
 * @author artem
 */
public class NaiveIdentifierDispenser implements VisualIdentifierDispenser {

	protected static final int CANVAS_COUNT_BASE = 79;

	protected static final int NODE_COUNT_BASE = 1000;

	protected static final int CHILD_COUNT_BASE = 2000;

	protected static final int LINK_COUNT_BASE = 3000;

	protected static final int LABEL_COUNT_BASE = 4000;

	protected static final int COMPARTMENT_COUNT_BASE = 5000;

	protected static final int TOOL_GROUP_COUNT_BASE = 0;

	private int myNodeCount = 0;

	private int myLinkCount = 0;

	private int myChildCount = 0;

	private int myLabelCount = 0;

	private int myCompartmentCount = 0;

	private int myToolGroupCount = 0;

	public NaiveIdentifierDispenser() {
	}

	@Override
	public int getForDiagram(GenDiagram diagram) {
		return CANVAS_COUNT_BASE;
	}

	@Override
	public int getForTopNode(GenNode node) {
		return NODE_COUNT_BASE + (++myNodeCount);
	}

	@Override
	public int getForNodeLabel(GenNodeLabel nodeLabel) {
		return LABEL_COUNT_BASE + (++myLabelCount);
	}

	@Override
	public int getForLink(GenLink link) {
		return LINK_COUNT_BASE + (++myLinkCount);
	}

	@Override
	public int getForChildNode(GenChildNodeBase childNode) {
		return CHILD_COUNT_BASE + (++myChildCount);
	}

	@Override
	public int getForCompartment(GenCompartment compartment) {
		return COMPARTMENT_COUNT_BASE + (++myCompartmentCount);
	}

	@Override
	public int getForLinkLabel(GenLinkLabel label) {
		return getForNodeLabel(null);
	}

	@Override
	public int getForToolGroup(ToolGroup toolGroup) {
		return TOOL_GROUP_COUNT_BASE + (++myToolGroupCount);
	}
}

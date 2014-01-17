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
 * @author artem
 */
public interface VisualIdentifierDispenser {

	int getForDiagram(GenDiagram diagram);

	int getForTopNode(GenNode node);

	int getForNodeLabel(GenNodeLabel nodeLabel);

	int getForLink(GenLink link);

	int getForChildNode(GenChildNodeBase childNode);

	int getForCompartment(GenCompartment compartment);

	int getForLinkLabel(GenLinkLabel label);

	int getForToolGroup(ToolGroup toolGroup);
}

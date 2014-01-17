/*******************************************************************************
* Copyright (c) 2011, 2012 Montages A.G.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* 	Guillaume Hillairet (Montages A.G.) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.internal.bridge.genmodel;

import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.ToolGroup;
import org.eclipse.gmf.internal.bridge.NaiveIdentifierDispenser;
import org.eclipse.gmf.internal.bridge.VisualIdentifierDispenser;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;

/**
 * {@link VisualIdentifierDispenserFacade} is a QVTO black box providing access to 
 * a {@link VisualIdentifierDispenser}. 
 *
 */
public class VisualIdentifierDispenserFacade {

	public VisualIdentifierDispenserFacade() {
	}

	@Operation(contextual = true, kind = Kind.QUERY)
	public int getVisualID(Object self) {
		VisualIdentifierDispenser dispenser = Provider.getDisenser();
		assert dispenser != null;

		if (self instanceof GenDiagram) {
			return dispenser.getForDiagram((GenDiagram) self);
		}

		if (self instanceof GenTopLevelNode) {
			return dispenser.getForTopNode((GenTopLevelNode) self);
		}

		if (self instanceof GenChildNode) {
			return dispenser.getForChildNode((GenChildNode) self);
		}

		if (self instanceof GenCompartment) {
			return dispenser.getForCompartment((GenCompartment) self);
		}

		if (self instanceof GenNodeLabel) {
			return dispenser.getForNodeLabel((GenNodeLabel) self);
		}

		if (self instanceof GenLink) {
			return dispenser.getForLink((GenLink) self);
		}

		if (self instanceof GenLinkLabel) {
			return dispenser.getForLinkLabel((GenLinkLabel) self);
		}

		if (self instanceof ToolGroup) {
			return dispenser.getForToolGroup((ToolGroup) self);
		}

		int visualID = -1;

		return visualID;
	}

	/**
	 * {@link Provider} is a singleton holding the current visual identifier dispenser. 
	 */
	public static final class Provider {

		private static VisualIdentifierDispenser dispenser;

		public static VisualIdentifierDispenser getDisenser() {
			if (dispenser == null) {
				dispenser = new NaiveIdentifierDispenser();
			}
			return dispenser;
		}

		public static void setDispenser(VisualIdentifierDispenser dispenser) {
			Provider.dispenser = dispenser;
		}

	}
}

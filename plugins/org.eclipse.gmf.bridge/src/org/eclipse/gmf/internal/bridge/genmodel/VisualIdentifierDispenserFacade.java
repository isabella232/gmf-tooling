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
		
	public VisualIdentifierDispenserFacade() {}
	
	@Operation(contextual = true, kind = Kind.QUERY)
	public int getVisualID(Object self) {
		VisualIdentifierDispenser dispenser = Provider.getDisenser();
		assert dispenser != null;
		
		int visualID = -1;
		
		if (self instanceof GenDiagram)
			visualID = dispenser.get((GenDiagram) self);
		
		else if (self instanceof GenTopLevelNode)
			visualID = dispenser.get((GenTopLevelNode) self);
		
		else if (self instanceof GenChildNode)
			visualID = dispenser.get((GenChildNode) self);
		
		else if (self instanceof GenCompartment)
			visualID = dispenser.get((GenCompartment) self);
		
		else if (self instanceof GenNodeLabel)
			visualID = dispenser.get((GenNodeLabel) self);
		
		else if (self instanceof GenLink)
			visualID = dispenser.get((GenLink) self);
		
		else if (self instanceof GenLinkLabel)
			visualID = dispenser.get((GenLinkLabel) self);
		
		else if (self instanceof ToolGroup)
			visualID = dispenser.get((ToolGroup) self);
		
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

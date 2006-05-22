/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.setup;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.internal.common.codegen.GeneratorBase;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Composite;

public interface GeneratorConfiguration {
	public GeneratorBase createGenerator(GenDiagram diagram);

	/**
	 * Encapsulates differences in the way viewer is created and operated in different configurations.
	 */
	public static interface ViewerConfiguration {
		// XXX is it really different? 
		public EditPart findEditPart(View notationElement);
		public EditPartViewer getViewer();
		public Command getCreateNodeCommand(View parentView, GenCommonBase nodeType);
		public Command getStartLinkCommand(View source, GenCommonBase linkType);
		public Command getCreateLinkCommand(View source, View target, GenCommonBase linkType);
		public Command getSetBusinessElementStructuralFeatureCommand(View view, String featureName, Object value);
		public Command getSetNotationalElementStructuralFeature(View view, EStructuralFeature feature, Object value);
		public void dispose();
	}

	public ViewerConfiguration createViewerConfiguration(Composite parent, SessionSetup setup, Diagram canvas) throws Exception;
}

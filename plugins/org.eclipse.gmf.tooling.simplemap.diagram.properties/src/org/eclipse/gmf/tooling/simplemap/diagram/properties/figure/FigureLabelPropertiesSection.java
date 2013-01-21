/**
 * Copyright (c) 2010-2012 ISBAN S.L
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *  
 * Contributors:
 * 		Ruben De Dios (ISBAN S.L)
 * 		Andrez Alvarez Mattos (ISBAN S.L)
 */
package org.eclipse.gmf.tooling.simplemap.diagram.properties.figure;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.gmfgraph.Figure;

public class FigureLabelPropertiesSection extends ElementWithLabelPropertySection {

	@Override
	protected EObject adapt(Object selected) {

		EObject adapted = super.adapt(selected);

		Figure figure = getLabelFigure(adapted);

		return figure != null ? figure.getFont() : null;
	}

}

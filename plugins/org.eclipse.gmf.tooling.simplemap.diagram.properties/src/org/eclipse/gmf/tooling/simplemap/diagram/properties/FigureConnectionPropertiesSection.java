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
package org.eclipse.gmf.tooling.simplemap.diagram.properties;

import org.eclipse.gmf.mappings.LinkMapping;
import org.eclipse.gmf.tooling.simplemap.simplemappings.SimpleLinkMapping;

public class FigureConnectionPropertiesSection extends AbstractSimplemapPropertySection {

	@Override
	protected Object transformSelection(Object selected) {
		Object transformSelection = super.transformSelection(selected);

		LinkMapping linkMapping = null;

		if (transformSelection instanceof SimpleLinkMapping) {
			linkMapping = ((SimpleLinkMapping) transformSelection).getLinkMapping();
		}

		return linkMapping;
	}

}

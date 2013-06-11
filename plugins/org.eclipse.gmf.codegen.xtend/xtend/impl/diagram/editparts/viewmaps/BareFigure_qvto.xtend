/**
﻿ * Copyright (c) 2011 Montages AG
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.diagram.editparts.viewmaps

import com.google.inject.Inject
import org.eclipse.emf.ecore.EStructuralFeature
import org.eclipse.gmf.gmfgraph.FigureDescriptor
import org.eclipse.gmf.gmfgraph.RealFigure
import xpt.Common_qvto

class BareFigure_qvto {
	@Inject extension Common_qvto

	def boolean isBareFigureDescriptor(FigureDescriptor descriptor) {
		return descriptor.actualFigure.oclIsKindOf(typeof(RealFigure)) &&
			isBareFigure(descriptor.actualFigure as RealFigure)
	}

	private def isDerivedOrAlwaysSet(EStructuralFeature f) {
		f.derived || (f.EContainingClass.name == 'RealFigure' && f.name == 'name') ||
			(f.EContainingClass.name == 'RealFigure' && f.name == 'children') ||
			(f.EContainingClass.name == 'CustomClass' && f.name == 'qualifiedClassName') ||
			(f.EContainingClass.name == 'CustomFigure' && f.name == 'customChildren')
	}

	def boolean isBareFigure(RealFigure figure) {
		var featuresToCheck = figure.eClass.EAllStructuralFeatures.filter[f|!isDerivedOrAlwaysSet(f)];
		figure.children.empty && featuresToCheck.forall[f|!figure.eIsSet(f)];
	}

}

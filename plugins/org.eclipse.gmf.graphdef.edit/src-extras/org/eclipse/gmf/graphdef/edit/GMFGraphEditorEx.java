/*******************************************************************************
* Copyright (c) 2011 EBM Websourcing (PetalsLink)
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Mickael Istria (EBM - PetalsLink) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.graphdef.edit;

import org.eclipse.gmf.gmfgraph.presentation.GMFGraphEditor;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;

public class GMFGraphEditorEx extends GMFGraphEditor {
	
	@Override
	public IContentOutlinePage getContentOutlinePage() {
		if (contentOutlinePage == null) {
			PreviewRenderedFigureOutlinePage res = new PreviewRenderedFigureOutlinePage(); 
			contentOutlinePage = res;
			this.addSelectionChangedListener(res);
		}

		return contentOutlinePage;
	}

}

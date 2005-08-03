/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.edit.provider.metainfo;

import org.eclipse.gmf.diagramrt.DiagramCanvas;
import org.eclipse.gmf.diagramrt.DiagramLink;
import org.eclipse.gmf.diagramrt.DiagramNode;

/**
 * Access to domain metainfo from diagram elements
 * @author artem
 */
public interface MetaInfoSource {

	NodeMetaInfoProvider getNodeInfo(DiagramNode diagramNode);
	LinkMetaInfoProvider getLinkInfo(DiagramLink diagramLink);
	CanvasMetaInfoProvider getCanvasInfo(DiagramCanvas diagramCanvas);
}

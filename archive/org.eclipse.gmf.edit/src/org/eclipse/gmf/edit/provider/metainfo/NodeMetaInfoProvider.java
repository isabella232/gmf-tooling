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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.diagramrt.ChildNode;
import org.eclipse.gmf.diagramrt.DiagramNode;

/**
 * Domain meta data for diagram nodes
 * @author artem
 */
public interface NodeMetaInfoProvider {

	//EObject getContainer(DiagramNode node);
	EStructuralFeature getContainmentFeature(DiagramNode node);
	EStructuralFeature getContainmentFeature(DiagramNode node, ChildNode childNode);
}

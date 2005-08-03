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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.diagramrt.DiagramCanvas;
import org.eclipse.gmf.diagramrt.DiagramLink;
import org.eclipse.gmf.diagramrt.DiagramNode;

/**
 * Implementation of {@link org.eclipse.gmf.edit.provider.metainfo.MetaInfoSource} 
 * that uses EMF Adapters mechanism.
 * @author artem
 */
public class AdapterFactoryMetaInfoSource extends AdapterImpl implements MetaInfoSource {
	private final AdapterFactory myMetaInfoFactory;

	public AdapterFactoryMetaInfoSource(AdapterFactory metaInfoFactory) {
		assert metaInfoFactory != null;
		assert metaInfoFactory.isFactoryForType(NodeMetaInfoProvider.class) && metaInfoFactory.isFactoryForType(LinkMetaInfoProvider.class);
		myMetaInfoFactory = metaInfoFactory;
	}

	public boolean isAdapterForType(Object type) {
		return MetaInfoSource.class == type;
	}

	public NodeMetaInfoProvider getNodeInfo(DiagramNode diagramNode) {
		return (NodeMetaInfoProvider) myMetaInfoFactory.adapt(diagramNode, NodeMetaInfoProvider.class);
	}

	public LinkMetaInfoProvider getLinkInfo(DiagramLink diagramLink) {
		return (LinkMetaInfoProvider) myMetaInfoFactory.adapt(diagramLink, LinkMetaInfoProvider.class);
	}

	public CanvasMetaInfoProvider getCanvasInfo(DiagramCanvas diagramCanvas) {
		return (CanvasMetaInfoProvider) myMetaInfoFactory.adapt(diagramCanvas, CanvasMetaInfoProvider.class);
	}
	
	/**
	 * inspired by {@link org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain#getEditingDomainFor(org.eclipse.emf.ecore.EObject)}
	 */
	public static MetaInfoSource getMetaInfoSource(DiagramCanvas canvas) {
		return (MetaInfoSource) EcoreUtil.getExistingAdapter(canvas, MetaInfoSource.class);
	}
}

/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev.insider.internal.ui;

import org.eclipse.gmf.dev.insider.ReferenceUtil;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.OpenEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class ReferenceOpener implements IOpenListener {

	public void open(OpenEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		if (selection.size() != 1) {
			return;
		}
		Object selected = selection.getFirstElement();
		if (!(selected instanceof Element)) {
			return;
		}
		Element element = (Element) selected;
		String targetId = ReferenceUtil.getReferencedId(element);
		if (targetId == null) {
			return;
		}
		Element root = element.getOwnerDocument().getDocumentElement();
		Element target = ReferenceUtil.getReferencedElement(root, targetId);
		if (target == null) {
			return;
		}
		TreeViewer viewer = (TreeViewer) event.getViewer();
		viewer.setSelection(new StructuredSelection(target), true);
	}
}

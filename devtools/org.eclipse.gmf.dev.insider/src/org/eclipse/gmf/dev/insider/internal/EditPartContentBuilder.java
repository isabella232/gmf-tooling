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
package org.eclipse.gmf.dev.insider.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.editparts.AbstractEditPart;
import org.eclipse.gmf.dev.insider.AbstractContentBuilder;
import org.eclipse.gmf.dev.insider.ElementMetaInfo;
import org.eclipse.gmf.dev.insider.ReferenceUtil;
import org.eclipse.gmf.dev.insider.ReflectionUtil;
import org.w3c.dom.Element;

/**
 * @author dstadnik
 */
public class EditPartContentBuilder extends AbstractContentBuilder {

	public Element contribute(Element element, Object object) {
		if (object instanceof EditPart) {
			EditPart editPart = (EditPart) object;
			Element editPartElement = createObject(element, editPart, ElementMetaInfo.EDIT_PART_ELEMENT);
			if (editPart instanceof GraphicalEditPart) {
				IFigure figure = ((GraphicalEditPart) editPart).getFigure();
				if (figure != null) {
					ReferenceUtil.createReference(editPartElement, figure);
				}
			}
			return editPartElement;
		} else if (object instanceof EditPolicy) {
			EditPolicy editPolicy = (EditPolicy) object;
			return createObject(element, editPolicy, ElementMetaInfo.EDIT_POLICY_ELEMENT);
		}
		return null;
	}

	public List getChildren(Object object) {
		if (object instanceof EditPart) {
			EditPart editPart = (EditPart) object;
			List allChildren = new ArrayList();
			Object model = editPart.getModel();
			if (model != null) {
				allChildren.add(model);
			}
			allChildren.addAll(editPart.getChildren());
			if (editPart instanceof GraphicalEditPart) {
				GraphicalEditPart gEditPart = (GraphicalEditPart) editPart;
				allChildren.addAll(gEditPart.getSourceConnections());
				allChildren.addAll(gEditPart.getTargetConnections());
			}
			if (editPart instanceof AbstractEditPart) {
				Object editPolicyKeysObject = ReflectionUtil.getFieldValue(editPart, "editPolicyKeys", AbstractEditPart.class);
				if (editPolicyKeysObject instanceof List) {
					List editPolicyKeys = (List) editPolicyKeysObject;
					for (int i = 0; i < editPolicyKeys.size(); i++) {
						EditPolicy editPolicy = editPart.getEditPolicy(editPolicyKeys.get(i));
						if (editPolicy != null) {
							allChildren.add(editPolicy);
						}
					}
				}
			}
			return allChildren;
		}
		return null;
	}
}

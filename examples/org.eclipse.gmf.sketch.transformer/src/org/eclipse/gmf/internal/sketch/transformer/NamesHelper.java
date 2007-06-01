/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLabel;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;

/**
 * @author dstadnik
 */
public class NamesHelper {

	public void fix(GenDiagram diagram, String name) {
		String prefix = toPrefix(name);
		fix(diagram.getElementType(), name, prefix);
		if (prefix == null) {
			return;
		}
		fixContainerBase(diagram, prefix);
	}

	public void fix(GenNode node, String name) {
		String prefix = toPrefix(name);
		fix(node.getElementType(), name, prefix);
		if (prefix == null) {
			return;
		}
		fixContainerBase(node, prefix);
		node.setGraphicalNodeEditPolicyClassName(prefix + GenNode.GRAPHICAL_NODE_EDIT_POLICY_SUFFIX);
		node.setCreateCommandClassName(prefix + GenNode.CREATE_COMMAND_SUFFIX);
	}

	public void fix(GenCompartment compartment, String name) {
		String prefix = toPrefix(name);
		if (prefix == null) {
			return;
		}
		fixContainerBase(compartment, prefix);
	}

	public void fix(GenLink link, String name) {
		String prefix = toPrefix(name);
		fix(link.getElementType(), name, prefix);
		if (prefix == null) {
			return;
		}
		fixBase(link, prefix);
		link.setCreateCommandClassName(prefix + GenLink.CREATE_COMMAND_SUFFIX);
		link.setReorientCommandClassName(prefix + GenLink.REORIENT_COMMAND_SUFFIX);
	}

	public void fix(GenLabel label, String name) {
		String prefix = toPrefix(name);
		if (prefix == null) {
			return;
		}
		fixBase(label, prefix);
	}

	protected void fixContainerBase(GenContainerBase element, String prefix) {
		fixBase(element, prefix);
		element.setCanonicalEditPolicyClassName(prefix + GenContainerBase.CANONICAL_EDIT_POLICY_SUFFIX);
	}

	protected void fixBase(GenCommonBase element, String prefix) {
		element.setEditPartClassName(prefix + GenCommonBase.EDIT_PART_SUFFIX);
		element.setItemSemanticEditPolicyClassName(prefix + GenCommonBase.ITEM_SEMANTIC_EDIT_POLICY_SUFFIX);
		element.setNotationViewFactoryClassName(prefix + GenCommonBase.NOTATION_VIEW_FACTORY_SUFFIX);
	}

	protected void fix(ElementType type, String name, String prefix) {
		if (type != null && name != null) {
			type.setDisplayName(name);
		}
		if (prefix == null) {
			return;
		}
		if (type instanceof MetamodelType) {
			MetamodelType mtype = (MetamodelType) type;
			mtype.setEditHelperClassName(prefix + MetamodelType.EDIT_HELPER_SUFFIX);
		} else if (type instanceof SpecializationType) {
			SpecializationType stype = (SpecializationType) type;
			stype.setEditHelperAdviceClassName(prefix + SpecializationType.EDIT_HELPER_ADVICE_SUFFIX);
		}
	}

	protected String toPrefix(String name) {
		if (name == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder(name.length());
		boolean firstChar = true;
		for (char c : name.toCharArray()) {
			if (firstChar) {
				if (Character.isJavaIdentifierStart(c)) {
					sb.append(c);
					firstChar = false;
				}
			} else {
				if (Character.isJavaIdentifierPart(c)) {
					sb.append(c);
				}
			}
		}
		return sb.length() == 0 ? null : sb.toString();
	}
}

/*
 * Copyright (c) 2006, 2008 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.ecore.part;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.ecore.providers.EcoreElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

/**
 * @generated
 */
public class EcorePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createChildNodes2Group());
		paletteRoot.add(createLinks3Group());
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Nodes1Group_title);
		paletteContainer.setId("createNodes1Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Nodes1Group_desc);
		paletteContainer.add(createEClass1CreationTool());
		paletteContainer.add(createEPackage2CreationTool());
		paletteContainer.add(createEAnnotation3CreationTool());
		paletteContainer.add(createEDataType4CreationTool());
		paletteContainer.add(createEEnum5CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Child Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createChildNodes2Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.ChildNodes2Group_title);
		paletteContainer.setId("createChildNodes2Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.ChildNodes2Group_desc);
		paletteContainer.add(createEAttribute1CreationTool());
		paletteContainer.add(createEOperation2CreationTool());
		paletteContainer.add(createAnnotationdetails3CreationTool());
		paletteContainer.add(createEEnumLiteral4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteGroup paletteContainer = new PaletteGroup(Messages.Links3Group_title);
		paletteContainer.setId("createLinks3Group"); //$NON-NLS-1$
		paletteContainer.setDescription(Messages.Links3Group_desc);
		paletteContainer.add(createEAnnotationreference1CreationTool());
		paletteContainer.add(createAssociation2CreationTool());
		paletteContainer.add(createAggregation3CreationTool());
		paletteContainer.add(createGeneralization4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEClass1CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EcoreElementTypes.EClass_2001);
		types.add(EcoreElementTypes.EClass_3004);
		NodeToolEntry entry = new NodeToolEntry(Messages.EClass1CreationTool_title, Messages.EClass1CreationTool_desc, types);
		entry.setId("createEClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClass_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPackage2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EcoreElementTypes.EPackage_2002);
		types.add(EcoreElementTypes.EPackage_3005);
		NodeToolEntry entry = new NodeToolEntry(Messages.EPackage2CreationTool_title, Messages.EPackage2CreationTool_desc, types);
		entry.setId("createEPackage2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EPackage_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotation3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EcoreElementTypes.EAnnotation_3003);
		types.add(EcoreElementTypes.EAnnotation_2003);
		NodeToolEntry entry = new NodeToolEntry(Messages.EAnnotation3CreationTool_title, Messages.EAnnotation3CreationTool_desc, types);
		entry.setId("createEAnnotation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotation_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEDataType4CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EcoreElementTypes.EDataType_3006);
		types.add(EcoreElementTypes.EDataType_2004);
		NodeToolEntry entry = new NodeToolEntry(Messages.EDataType4CreationTool_title, Messages.EDataType4CreationTool_desc, types);
		entry.setId("createEDataType4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EDataType_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnum5CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(EcoreElementTypes.EEnum_3007);
		types.add(EcoreElementTypes.EEnum_2005);
		NodeToolEntry entry = new NodeToolEntry(Messages.EEnum5CreationTool_title, Messages.EEnum5CreationTool_desc, types);
		entry.setId("createEEnum5CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnum_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAttribute1CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.EAttribute1CreationTool_title, Messages.EAttribute1CreationTool_desc, Collections.singletonList(EcoreElementTypes.EAttribute_3001));
		entry.setId("createEAttribute1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAttribute_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOperation2CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.EOperation2CreationTool_title, Messages.EOperation2CreationTool_desc, Collections.singletonList(EcoreElementTypes.EOperation_3002));
		entry.setId("createEOperation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EOperation_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotationdetails3CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.Annotationdetails3CreationTool_title, Messages.Annotationdetails3CreationTool_desc,
				Collections.singletonList(EcoreElementTypes.EStringToStringMapEntry_3008));
		entry.setId("createAnnotationdetails3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EStringToStringMapEntry_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumLiteral4CreationTool() {
		NodeToolEntry entry = new NodeToolEntry(Messages.EEnumLiteral4CreationTool_title, Messages.EEnumLiteral4CreationTool_desc, Collections.singletonList(EcoreElementTypes.EEnumLiteral_3009));
		entry.setId("createEEnumLiteral4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnumLiteral_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotationreference1CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.EAnnotationreference1CreationTool_title, Messages.EAnnotationreference1CreationTool_desc,
				Collections.singletonList(EcoreElementTypes.EAnnotationReferences_4001));
		entry.setId("createEAnnotationreference1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotationReferences_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Association2CreationTool_title, Messages.Association2CreationTool_desc, Collections.singletonList(EcoreElementTypes.EReference_4002));
		entry.setId("createAssociation2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregation3CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Aggregation3CreationTool_title, Messages.Aggregation3CreationTool_desc, Collections.singletonList(EcoreElementTypes.EReference_4003));
		entry.setId("createAggregation3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		LinkToolEntry entry = new LinkToolEntry(Messages.Generalization4CreationTool_title, Messages.Generalization4CreationTool_desc,
				Collections.singletonList(EcoreElementTypes.EClassESuperTypes_4004));
		entry.setId("createGeneralization4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClassESuperTypes_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List<IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List<IElementType> relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List<IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public Tool createTool() {
			Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}

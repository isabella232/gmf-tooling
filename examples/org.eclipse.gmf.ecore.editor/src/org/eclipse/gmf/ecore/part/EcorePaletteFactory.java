/*
 * Copyright (c) 2006 Borland Software Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Borland Software Corporation - initial API and implementation
 */
package org.eclipse.gmf.ecore.part;

import java.util.List;
import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;

import org.eclipse.gef.palette.PaletteGroup;

import org.eclipse.gmf.ecore.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

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
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteContainer paletteContainer = new PaletteGroup("Nodes");
		paletteContainer.setDescription("Diagram Nodes");
		paletteContainer.add(createEClass1CreationTool());
		paletteContainer.add(createEPackage2CreationTool());
		paletteContainer.add(createEAnnotation3CreationTool());
		paletteContainer.add(createEDataType4CreationTool());
		paletteContainer.add(createEEnum5CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createChildNodes2Group() {
		PaletteContainer paletteContainer = new PaletteGroup("Child Nodes");
		paletteContainer.setDescription("Child Nodes");
		paletteContainer.add(createEAttribute1CreationTool());
		paletteContainer.add(createEOperation2CreationTool());
		paletteContainer.add(createAnnotationdetails3CreationTool());
		paletteContainer.add(createEEnumLiteral4CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteContainer paletteContainer = new PaletteGroup("Links");
		paletteContainer.setDescription("Links");
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
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClass_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EClass_2001);
		elementTypes.add(EcoreElementTypes.EClass_3004);
		ToolEntry result = new NodeToolEntry("EClass", "Create Class", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPackage2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EPackage_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EPackage_2002);
		elementTypes.add(EcoreElementTypes.EPackage_3005);
		ToolEntry result = new NodeToolEntry("EPackage", "Create Package", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotation3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotation_3003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAnnotation_3003);
		elementTypes.add(EcoreElementTypes.EAnnotation_2003);
		ToolEntry result = new NodeToolEntry("EAnnotation", "Create Annotation", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEDataType4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EDataType_3006);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EDataType_3006);
		elementTypes.add(EcoreElementTypes.EDataType_2004);
		ToolEntry result = new NodeToolEntry("EDataType", "Create DataType", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnum5CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnum_3007);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnum_3007);
		elementTypes.add(EcoreElementTypes.EEnum_2005);
		ToolEntry result = new NodeToolEntry("EEnum", "Create Enumeration", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAttribute1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAttribute_3001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAttribute_3001);
		ToolEntry result = new NodeToolEntry("EAttribute", "Create Attribute", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOperation2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EOperation_3002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EOperation_3002);
		ToolEntry result = new NodeToolEntry("EOperation", "Create Operation", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotationdetails3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EStringToStringMapEntry_3008);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EStringToStringMapEntry_3008);
		ToolEntry result = new NodeToolEntry("Annotation details", "Create Annotation details", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumLiteral4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnumLiteral_3009);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnumLiteral_3009);
		ToolEntry result = new NodeToolEntry("EEnumLiteral", "Create Enumeration literal", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotationreference1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotationReferences_4001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EAnnotationReferences_4001);
		ToolEntry result = new LinkToolEntry("EAnnotation reference", "Create Annotation reference link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_4002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_4002);
		ToolEntry result = new LinkToolEntry("Association", "Create Association link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregation3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_4003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_4003);
		ToolEntry result = new LinkToolEntry("Aggregation", "Create Aggregation link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClassESuperTypes_4004);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EClassESuperTypes_4004);
		ToolEntry result = new LinkToolEntry("Generalization", "Create Generalization link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

		/**
		 * @generated
		 */
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List elementTypes) {
			super(title, description, smallIcon, largeIcon);
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
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, ImageDescriptor smallIcon, ImageDescriptor largeIcon, List relationshipTypes) {
			super(title, description, smallIcon, largeIcon);
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

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
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private PaletteContainer createNodes1Group() {
		PaletteGroup paletteContainer = new PaletteGroup(EcoreDiagramEditorPlugin.getString("Nodes1Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(EcoreDiagramEditorPlugin.getString("Nodes1Group.desc")); //$NON-NLS-1$
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
		PaletteGroup paletteContainer = new PaletteGroup(EcoreDiagramEditorPlugin.getString("ChildNodes2Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(EcoreDiagramEditorPlugin.getString("ChildNodes2Group.desc")); //$NON-NLS-1$
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
		PaletteGroup paletteContainer = new PaletteGroup(EcoreDiagramEditorPlugin.getString("Links3Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(EcoreDiagramEditorPlugin.getString("Links3Group.desc")); //$NON-NLS-1$
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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EClass1CreationTool.title"), EcoreDiagramEditorPlugin.getString("EClass1CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EPackage2CreationTool.title"), EcoreDiagramEditorPlugin.getString("EPackage2CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EAnnotation3CreationTool.title"), EcoreDiagramEditorPlugin.getString("EAnnotation3CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EDataType4CreationTool.title"), EcoreDiagramEditorPlugin.getString("EDataType4CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EEnum5CreationTool.title"), EcoreDiagramEditorPlugin.getString("EEnum5CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EAttribute1CreationTool.title"), EcoreDiagramEditorPlugin.getString("EAttribute1CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EOperation2CreationTool.title"), EcoreDiagramEditorPlugin.getString("EOperation2CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("Annotationdetails3CreationTool.title"), EcoreDiagramEditorPlugin.getString("Annotationdetails3CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("EEnumLiteral4CreationTool.title"), EcoreDiagramEditorPlugin.getString("EEnumLiteral4CreationTool.desc"), smallImage, largeImage, elementTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new LinkToolEntry(
				EcoreDiagramEditorPlugin.getString("EAnnotationreference1CreationTool.title"), EcoreDiagramEditorPlugin.getString("EAnnotationreference1CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new LinkToolEntry(
				EcoreDiagramEditorPlugin.getString("Association2CreationTool.title"), EcoreDiagramEditorPlugin.getString("Association2CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new LinkToolEntry(
				EcoreDiagramEditorPlugin.getString("Aggregation3CreationTool.title"), EcoreDiagramEditorPlugin.getString("Aggregation3CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

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
		ToolEntry result = new LinkToolEntry(
				EcoreDiagramEditorPlugin.getString("Generalization4CreationTool.title"), EcoreDiagramEditorPlugin.getString("Generalization4CreationTool.desc"), smallImage, largeImage, relationshipTypes); //$NON-NLS-1$ $NON-NLS-2$

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

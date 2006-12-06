package org.eclipse.gmf.ecore.part;

/*
 *  Copyright (c) 2006 Borland Software Corp.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */

/**
 * @generated
 */
public class EcorePaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createChildNodes2Group());
		paletteRoot.add(createLinks3Group());
	}

	/**
	 * Creates "Links" palette tool group
	 * @generated
	 */
	private org.eclipse.gef.palette.PaletteContainer createLinks3Group() {
		org.eclipse.gef.palette.PaletteGroup paletteContainer = new org.eclipse.gef.palette.PaletteGroup(org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Links3Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Links3Group.desc")); //$NON-NLS-1$
		paletteContainer.add(createEAnnotationreference1CreationTool());
		paletteContainer.add(createAssociation2CreationTool());
		paletteContainer.add(createAggregation3CreationTool());
		paletteContainer.add(createGeneralization4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Child Nodes" palette tool group
	 * @generated
	 */
	private org.eclipse.gef.palette.PaletteContainer createChildNodes2Group() {
		org.eclipse.gef.palette.PaletteGroup paletteContainer = new org.eclipse.gef.palette.PaletteGroup(org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("ChildNodes2Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("ChildNodes2Group.desc")); //$NON-NLS-1$
		paletteContainer.add(createEAttribute1CreationTool());
		paletteContainer.add(createEOperation2CreationTool());
		paletteContainer.add(createAnnotationdetails3CreationTool());
		paletteContainer.add(createEEnumLiteral4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Nodes" palette tool group
	 * @generated
	 */
	private org.eclipse.gef.palette.PaletteContainer createNodes1Group() {
		org.eclipse.gef.palette.PaletteGroup paletteContainer = new org.eclipse.gef.palette.PaletteGroup(org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Nodes1Group.title")); //$NON-NLS-1$
		paletteContainer.setDescription(org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Nodes1Group.desc")); //$NON-NLS-1$
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
	private org.eclipse.gef.palette.ToolEntry createEAnnotationreference1CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAnnotationReferences_4001);
		LinkToolEntry entry = new LinkToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EAnnotationreference1CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EAnnotationreference1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAnnotationReferences_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createAssociation2CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EReference_4002);
		LinkToolEntry entry = new LinkToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Association2CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Association2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EReference_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createAggregation3CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EReference_4003);
		LinkToolEntry entry = new LinkToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Aggregation3CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Aggregation3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EReference_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createGeneralization4CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EClassESuperTypes_4004);
		LinkToolEntry entry = new LinkToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Generalization4CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Generalization4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EClassESuperTypes_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEAttribute1CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAttribute_3001);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EAttribute1CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EAttribute1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAttribute_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEOperation2CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EOperation_3002);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EOperation2CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EOperation2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EOperation_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createAnnotationdetails3CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EStringToStringMapEntry_3008);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Annotationdetails3CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("Annotationdetails3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EStringToStringMapEntry_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEEnumLiteral4CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(1);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EEnumLiteral_3009);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EEnumLiteral4CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EEnumLiteral4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EEnumLiteral_3009));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEClass1CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EClass_2001);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EClass_3004);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EClass1CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EClass1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EClass_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEPackage2CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EPackage_2002);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EPackage_3005);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EPackage2CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EPackage2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EPackage_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEAnnotation3CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAnnotation_3003);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAnnotation_2003);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EAnnotation3CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EAnnotation3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EAnnotation_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEDataType4CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EDataType_3006);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EDataType_2004);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EDataType4CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EDataType4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EDataType_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private org.eclipse.gef.palette.ToolEntry createEEnum5CreationTool() {
		java.util.List/*<IElementType>*/types = new java.util.ArrayList/*<IElementType>*/(2);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EEnum_3007);
		types.add(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EEnum_2005);
		NodeToolEntry entry = new NodeToolEntry(
				org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EEnum5CreationTool.title"), org.eclipse.gmf.ecore.part.EcoreDiagramEditorPlugin.getString("EEnum5CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(org.eclipse.gmf.ecore.providers.EcoreElementTypes.getImageDescriptor(org.eclipse.gmf.ecore.providers.EcoreElementTypes.EEnum_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends org.eclipse.gef.palette.ToolEntry {

		/**
		 * @generated
		 */
		private final java.util.List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, java.util.List elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
		}

		/**
		 * @generated
		 */
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}

	/**
	 * @generated
	 */
	private static class LinkToolEntry extends org.eclipse.gef.palette.ToolEntry {

		/**
		 * @generated
		 */
		private final java.util.List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, java.util.List relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
		}

		/**
		 * @generated
		 */
		public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
		}
	}
}

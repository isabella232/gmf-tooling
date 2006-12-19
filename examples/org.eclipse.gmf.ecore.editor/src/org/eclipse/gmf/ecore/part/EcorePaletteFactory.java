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
package org.eclipse.gmf.ecore.part;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
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
	 * @generated
	 */
	private ToolEntry createEAnnotationreference1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EAnnotationReferences_4001);
		LinkToolEntry entry = new LinkToolEntry(
				EcoreDiagramEditorPlugin.getString("EAnnotationreference1CreationTool.title"), EcoreDiagramEditorPlugin.getString("EAnnotationreference1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotationReferences_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EReference_4002);
		LinkToolEntry entry = new LinkToolEntry(EcoreDiagramEditorPlugin.getString("Association2CreationTool.title"), EcoreDiagramEditorPlugin.getString("Association2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EReference_4003);
		LinkToolEntry entry = new LinkToolEntry(EcoreDiagramEditorPlugin.getString("Aggregation3CreationTool.title"), EcoreDiagramEditorPlugin.getString("Aggregation3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_4003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EClassESuperTypes_4004);
		LinkToolEntry entry = new LinkToolEntry(EcoreDiagramEditorPlugin.getString("Generalization4CreationTool.title"), EcoreDiagramEditorPlugin.getString("Generalization4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClassESuperTypes_4004));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEClass1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(EcoreElementTypes.EClass_2001);
		types.add(EcoreElementTypes.EClass_3004);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EClass1CreationTool.title"), EcoreDiagramEditorPlugin.getString("EClass1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClass_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPackage2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(EcoreElementTypes.EPackage_2002);
		types.add(EcoreElementTypes.EPackage_3005);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EPackage2CreationTool.title"), EcoreDiagramEditorPlugin.getString("EPackage2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EPackage_2002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotation3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(EcoreElementTypes.EAnnotation_3003);
		types.add(EcoreElementTypes.EAnnotation_2003);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EAnnotation3CreationTool.title"), EcoreDiagramEditorPlugin.getString("EAnnotation3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotation_3003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEDataType4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(EcoreElementTypes.EDataType_3006);
		types.add(EcoreElementTypes.EDataType_2004);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EDataType4CreationTool.title"), EcoreDiagramEditorPlugin.getString("EDataType4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EDataType_3006));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnum5CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(2);
		types.add(EcoreElementTypes.EEnum_3007);
		types.add(EcoreElementTypes.EEnum_2005);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EEnum5CreationTool.title"), EcoreDiagramEditorPlugin.getString("EEnum5CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnum_3007));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAttribute1CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EAttribute_3001);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EAttribute1CreationTool.title"), EcoreDiagramEditorPlugin.getString("EAttribute1CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAttribute_3001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOperation2CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EOperation_3002);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EOperation2CreationTool.title"), EcoreDiagramEditorPlugin.getString("EOperation2CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EOperation_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotationdetails3CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EStringToStringMapEntry_3008);
		NodeToolEntry entry = new NodeToolEntry(
				EcoreDiagramEditorPlugin.getString("Annotationdetails3CreationTool.title"), EcoreDiagramEditorPlugin.getString("Annotationdetails3CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EStringToStringMapEntry_3008));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumLiteral4CreationTool() {
		List/*<IElementType>*/types = new ArrayList/*<IElementType>*/(1);
		types.add(EcoreElementTypes.EEnumLiteral_3009);
		NodeToolEntry entry = new NodeToolEntry(EcoreDiagramEditorPlugin.getString("EEnumLiteral4CreationTool.title"), EcoreDiagramEditorPlugin.getString("EEnumLiteral4CreationTool.desc"), types); //$NON-NLS-1$ $NON-NLS-2$
		entry.setSmallIcon(EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnumLiteral_3009));
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
		private final List elementTypes;

		/**
		 * @generated
		 */
		private NodeToolEntry(String title, String description, List elementTypes) {
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
		private final List relationshipTypes;

		/**
		 * @generated
		 */
		private LinkToolEntry(String title, String description, List relationshipTypes) {
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

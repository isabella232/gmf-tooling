package org.eclipse.gmf.ecore.part;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;
import java.util.List;

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

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClass_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EClass_1001);
		elementTypes.add(EcoreElementTypes.EClass_2004);
		ToolEntry result = new NodeToolEntry("EClass", "Create Class", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPackage2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EPackage_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EPackage_1002);
		elementTypes.add(EcoreElementTypes.EPackage_2005);
		ToolEntry result = new NodeToolEntry("EPackage", "Create Package", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotation3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotation_2003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAnnotation_2003);
		elementTypes.add(EcoreElementTypes.EAnnotation_1003);
		ToolEntry result = new NodeToolEntry("EAnnotation", "Create Annotation", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEDataType4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EDataType_2006);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EDataType_2006);
		elementTypes.add(EcoreElementTypes.EDataType_1004);
		ToolEntry result = new NodeToolEntry("EDataType", "Create DataType", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnum5CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnum_2007);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnum_2007);
		elementTypes.add(EcoreElementTypes.EEnum_1005);
		ToolEntry result = new NodeToolEntry("EEnum", "Create Enumeration", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAttribute1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAttribute_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAttribute_2001);
		ToolEntry result = new NodeToolEntry("EAttribute", "Create Attribute", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOperation2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EOperation_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EOperation_2002);
		ToolEntry result = new NodeToolEntry("EOperation", "Create Operation", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotationdetails3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EStringToStringMapEntry_2008);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EStringToStringMapEntry_2008);
		ToolEntry result = new NodeToolEntry("Annotation details", "Create Annotation details", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumLiteral4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnumLiteral_2009);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnumLiteral_2009);
		ToolEntry result = new NodeToolEntry("EEnumLiteral", "Create Enumeration literal", smallImage, largeImage, elementTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotationreference1CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotationReferences_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EAnnotationReferences_3001);
		ToolEntry result = new LinkToolEntry("EAnnotation reference", "Create Annotation reference link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation2CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_3002);
		ToolEntry result = new LinkToolEntry("Association", "Create Association link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregation3CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_3003);
		ToolEntry result = new LinkToolEntry("Aggregation", "Create Aggregation link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralization4CreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClassESuperTypes_3004);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EClassESuperTypes_3004);
		ToolEntry result = new LinkToolEntry("Generalization", "Create Generalization link", smallImage, largeImage, relationshipTypes);

		return result;
	}

	/**
	 * @generated
	 */
	private static class NodeToolEntry extends ToolEntry {

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

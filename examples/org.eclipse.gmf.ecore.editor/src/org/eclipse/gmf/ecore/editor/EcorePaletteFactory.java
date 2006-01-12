package org.eclipse.gmf.ecore.editor;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.MarqueeToolEntry;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteGroup;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.PanningSelectionToolEntry;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.resource.ImageDescriptor;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.palette.PaletteSeparator;

import org.eclipse.gmf.ecore.edit.providers.EcoreElementTypes;

import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;

/**
 * @generated
 */
public class EcorePaletteFactory {

	/**
	 * @generated
	 */
	private Diagram diagram;

	/**
	 * @generated
	 */
	private EcorePaletteFactory(Diagram diagram) {
		this.diagram = diagram;
	}

	/**
	 * @generated
	 */
	protected final Diagram getDiagram() {
		return diagram;
	}

	/**
	 * @generated
	 */
	public static PaletteRoot createPalette(Diagram diagram) {
		PaletteRoot paletteRoot = new PaletteRoot();
		EcorePaletteFactory factory = new EcorePaletteFactory(diagram);
		PaletteContainer commonTools = factory.createCommonTools();
		paletteRoot.add(commonTools);
		paletteRoot.setDefaultEntry((ToolEntry) commonTools.getChildren().get(0));
		factory.fillPalette(paletteRoot);
		return paletteRoot;
	}

	/**
	 * @generated
	 */
	public static void fillPalette(PaletteRoot paletteRoot, Diagram diagram) {
		EcorePaletteFactory factory = new EcorePaletteFactory(diagram);
		factory.fillPalette(paletteRoot);
	}

	/**
	 * @generated
	 */
	private void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createNodesGroup());
		paletteRoot.add(createChildNodesGroup());
		paletteRoot.add(createLinksGroup());
	}

	/**
	 * @generated
	 */
	private PaletteContainer createCommonTools() {
		PaletteGroup common = new PaletteGroup("Common");
		ToolEntry selectionTool = new PanningSelectionToolEntry();
		common.add(selectionTool);
		common.add(new MarqueeToolEntry());
		return common;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createNodesGroup() {
		PaletteContainer paletteContainer = createContainer("Nodes");
		paletteContainer.add(createEClassCreationTool());
		paletteContainer.add(createEPackageCreationTool());
		paletteContainer.add(createEAnnotationCreationTool());
		paletteContainer.add(createEDataTypeCreationTool());
		paletteContainer.add(createEEnumCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createChildNodesGroup() {
		PaletteContainer paletteContainer = createContainer("Child Nodes");
		paletteContainer.add(createEAttributeCreationTool());
		paletteContainer.add(createEOperationCreationTool());
		paletteContainer.add(createAnnotationdetailsCreationTool());
		paletteContainer.add(createEEnumLiteralCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinksGroup() {
		PaletteContainer paletteContainer = createContainer("Links");
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createEAnnotationreferenceCreationTool());
		paletteContainer.add(createAssociationCreationTool());
		paletteContainer.add(createAggregationCreationTool());
		paletteContainer.add(createGeneralizationCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEClassCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClass_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EClass_1001);
		elementTypes.add(EcoreElementTypes.EClass_2004);
		return new ToolEntry("EClass", "Create Class", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEPackageCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EPackage_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EPackage_1002);
		elementTypes.add(EcoreElementTypes.EPackage_2005);
		return new ToolEntry("EPackage", "Create Package", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotationCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotation_1003);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAnnotation_1003);
		elementTypes.add(EcoreElementTypes.EAnnotation_2003);
		elementTypes.add(EcoreElementTypes.EAnnotation_2008);
		elementTypes.add(EcoreElementTypes.EAnnotation_2010);
		elementTypes.add(EcoreElementTypes.EAnnotation_2012);
		return new ToolEntry("EAnnotation", "Create Annotation", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEDataTypeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EDataType_1004);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EDataType_1004);
		elementTypes.add(EcoreElementTypes.EDataType_2006);
		return new ToolEntry("EDataType", "Create DataType", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnum_1005);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnum_1005);
		elementTypes.add(EcoreElementTypes.EEnum_2007);
		return new ToolEntry("EEnum", "Create Enumeration", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAttributeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAttribute_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAttribute_2001);
		return new ToolEntry("EAttribute", "Create Attribute", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEOperationCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EOperation_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EOperation_2002);
		return new ToolEntry("EOperation", "Create Operation", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createAnnotationdetailsCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EStringToStringMapEntry_2009);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EStringToStringMapEntry_2009);
		return new ToolEntry("Annotation details", "Create Annotation details", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEEnumLiteralCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnumLiteral_2011);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnumLiteral_2011);
		return new ToolEntry("EEnumLiteral", "Create Enumeration literal", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createEAnnotationreferenceCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotationReferences_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EAnnotationReferences_3001);
		return new ToolEntry("EAnnotation reference", "Create Annotation reference link", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociationCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_3002);
		return new ToolEntry("Association", "Create Association link", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createAggregationCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_3003);
		return new ToolEntry("Aggregation", "Create Aggregation link", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private ToolEntry createGeneralizationCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClassESuperTypes_3004);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EClassESuperTypes_3004);
		return new ToolEntry("Generalization", "Create Generalization link", smallImage, largeImage) {

			public Tool createTool() {
				Tool tool = new UnspecifiedTypeConnectionTool(relationshipTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		};
	}

	/**
	 * @generated
	 */
	private PaletteContainer createContainer(String title) {
		return new PaletteDrawer(title);
	}

}

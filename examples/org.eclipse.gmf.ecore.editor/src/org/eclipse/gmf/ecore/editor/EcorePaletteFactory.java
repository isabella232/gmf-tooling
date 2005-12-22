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
		paletteRoot.add(createChlidNodesGroup());
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
		paletteContainer.add(createEClassNodeCreationTool());
		paletteContainer.add(createEPackageNodeCreationTool());
		paletteContainer.add(createEAnnotationNodeCreationTool());
		paletteContainer.add(createEDataTypeNodeCreationTool());
		paletteContainer.add(createEEnumNodeCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createChlidNodesGroup() {
		PaletteContainer paletteContainer = createContainer("Chlid Nodes");
		paletteContainer.add(createEAttributeNodeCreationTool());
		paletteContainer.add(createEOperationNodeCreationTool());
		paletteContainer.add(createEStringToStringMapEntryNodeCreationTool());
		paletteContainer.add(createEEnumLiteralNodeCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinksGroup() {
		PaletteContainer paletteContainer = createContainer("Links");
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createreferencesLinkCreationTool());
		paletteContainer.add(createEReferenceLinkCreationTool());
		paletteContainer.add(createEReferenceLinkCreationTool2());
		paletteContainer.add(createeSuperTypesLinkCreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEClassNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClass_1001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EClass_1001);
		elementTypes.add(EcoreElementTypes.EClass_2004);
		return new ToolEntry("EClass", "EClass", smallImage, largeImage) {
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
	private ToolEntry createEPackageNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EPackage_1002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EPackage_1002);
		elementTypes.add(EcoreElementTypes.EPackage_2005);
		return new ToolEntry("EPackage", "EPackage", smallImage, largeImage) {
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
	private ToolEntry createEAnnotationNodeCreationTool() {
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
		return new ToolEntry("EAnnotation", "EAnnotation", smallImage, largeImage) {
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
	private ToolEntry createEDataTypeNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EDataType_1004);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EDataType_1004);
		elementTypes.add(EcoreElementTypes.EDataType_2006);
		return new ToolEntry("EDataType", "EDataType", smallImage, largeImage) {
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
	private ToolEntry createEEnumNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnum_1005);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnum_1005);
		elementTypes.add(EcoreElementTypes.EEnum_2007);
		return new ToolEntry("EEnum", "EEnum", smallImage, largeImage) {
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
	private ToolEntry createEAttributeNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAttribute_2001);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EAttribute_2001);
		return new ToolEntry("EAttribute", "EAttribute", smallImage, largeImage) {
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
	private ToolEntry createEOperationNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EOperation_2002);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EOperation_2002);
		return new ToolEntry("EOperation", "EOperation", smallImage, largeImage) {
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
	private ToolEntry createEStringToStringMapEntryNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EStringToStringMapEntry_2009);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EStringToStringMapEntry_2009);
		return new ToolEntry("Annotation Details", "EStringToStringMapEntry", smallImage, largeImage) {
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
	private ToolEntry createEEnumLiteralNodeCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EEnumLiteral_2011);

		largeImage = smallImage;

		final List elementTypes = new ArrayList();
		elementTypes.add(EcoreElementTypes.EEnumLiteral_2011);
		return new ToolEntry("EEnumLiteral", "EEnumLiteral", smallImage, largeImage) {
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
	private ToolEntry createreferencesLinkCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EAnnotationReferences_3001);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EAnnotationReferences_3001);
		return new ToolEntry("EAnnotation reference", "references", smallImage, largeImage) {

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
	private ToolEntry createEReferenceLinkCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_3002);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_3002);
		return new ToolEntry("Association", "EReference", smallImage, largeImage) {

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
	private ToolEntry createEReferenceLinkCreationTool2() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EReference_3003);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EReference_3003);
		return new ToolEntry("Aggregation", "EReference", smallImage, largeImage) {

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
	private ToolEntry createeSuperTypesLinkCreationTool() {
		ImageDescriptor smallImage;
		ImageDescriptor largeImage;

		smallImage = EcoreElementTypes.getImageDescriptor(EcoreElementTypes.EClassESuperTypes_3004);

		largeImage = smallImage;

		final List relationshipTypes = new ArrayList();
		relationshipTypes.add(EcoreElementTypes.EClassESuperTypes_3004);
		return new ToolEntry("Generalization", "eSuperTypes", smallImage, largeImage) {

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

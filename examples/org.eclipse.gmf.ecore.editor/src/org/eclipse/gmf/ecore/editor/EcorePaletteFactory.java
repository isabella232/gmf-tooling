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
		paletteRoot.add(createNodes1Group());
		paletteRoot.add(createChildNodes2Group());
		paletteRoot.add(createLinks3Group());
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
	private PaletteContainer createNodes1Group() {
		PaletteContainer paletteContainer = createContainer("Nodes");
		paletteContainer.add(createEClass1001CreationTool());
		paletteContainer.add(createEPackage1004CreationTool());
		paletteContainer.add(createEAnnotation1005CreationTool());
		paletteContainer.add(createEDataType1007CreationTool());
		paletteContainer.add(createEEnum1008CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createChildNodes2Group() {
		PaletteContainer paletteContainer = createContainer("Child Nodes");
		paletteContainer.add(createEAttribute1002CreationTool());
		paletteContainer.add(createEOperation1003CreationTool());
		paletteContainer.add(createAnnotationdetails1006CreationTool());
		paletteContainer.add(createEEnumLiteral1009CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private PaletteContainer createLinks3Group() {
		PaletteContainer paletteContainer = createContainer("Links");
		paletteContainer.add(new PaletteSeparator());
		paletteContainer.add(createEAnnotationreference2001CreationTool());
		paletteContainer.add(createAssociation2002CreationTool());
		paletteContainer.add(createAggregation2003CreationTool());
		paletteContainer.add(createGeneralization2004CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createEClass1001CreationTool() {
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
	private ToolEntry createEPackage1004CreationTool() {
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
	private ToolEntry createEAnnotation1005CreationTool() {
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
	private ToolEntry createEDataType1007CreationTool() {
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
	private ToolEntry createEEnum1008CreationTool() {
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
	private ToolEntry createEAttribute1002CreationTool() {
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
	private ToolEntry createEOperation1003CreationTool() {
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
	private ToolEntry createAnnotationdetails1006CreationTool() {
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
	private ToolEntry createEEnumLiteral1009CreationTool() {
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
	private ToolEntry createEAnnotationreference2001CreationTool() {
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
	private ToolEntry createAssociation2002CreationTool() {
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
	private ToolEntry createAggregation2003CreationTool() {
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
	private ToolEntry createGeneralization2004CreationTool() {
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

package org.eclipse.gmf.tooling.examples.linklf.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.examples.linklf.LinklfPackage;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerName2EditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.ContainerNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkLinkNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkSourceNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.edit.parts.LabeledLinkTargetNameEditPart;
import org.eclipse.gmf.tooling.examples.linklf.diagram.parsers.MessageFormatParser;
import org.eclipse.gmf.tooling.examples.linklf.diagram.part.LinklfVisualIDRegistry;

/**
 * @generated
 */
public class LinklfParserProvider extends AbstractProvider implements IParserProvider {

	/**
	 * @generated
	 */
	private IParser containerName_5002Parser;

	/**
	 * @generated
	 */
	private IParser getContainerName_5002Parser() {
		if (containerName_5002Parser == null) {
			EAttribute[] features = new EAttribute[] { LinklfPackage.eINSTANCE.getContainer_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			containerName_5002Parser = parser;
		}
		return containerName_5002Parser;
	}

	/**
	 * @generated
	 */
	private IParser containerName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getContainerName_5001Parser() {
		if (containerName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { LinklfPackage.eINSTANCE.getContainer_Name() };
			MessageFormatParser parser = new MessageFormatParser(features);
			containerName_5001Parser = parser;
		}
		return containerName_5001Parser;
	}

	/**
	 * @generated
	 */
	private IParser labeledLinkSourceName_6001Parser;

	/**
	 * @generated
	 */
	private IParser getLabeledLinkSourceName_6001Parser() {
		if (labeledLinkSourceName_6001Parser == null) {
			EAttribute[] features = new EAttribute[] { LinklfPackage.eINSTANCE.getLabeledLink_SourceName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			labeledLinkSourceName_6001Parser = parser;
		}
		return labeledLinkSourceName_6001Parser;
	}

	/**
	 * @generated
	 */
	private IParser labeledLinkTargetName_6002Parser;

	/**
	 * @generated
	 */
	private IParser getLabeledLinkTargetName_6002Parser() {
		if (labeledLinkTargetName_6002Parser == null) {
			EAttribute[] features = new EAttribute[] { LinklfPackage.eINSTANCE.getLabeledLink_TargetName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			labeledLinkTargetName_6002Parser = parser;
		}
		return labeledLinkTargetName_6002Parser;
	}

	/**
	 * @generated
	 */
	private IParser labeledLinkLinkName_6003Parser;

	/**
	 * @generated
	 */
	private IParser getLabeledLinkLinkName_6003Parser() {
		if (labeledLinkLinkName_6003Parser == null) {
			EAttribute[] features = new EAttribute[] { LinklfPackage.eINSTANCE.getLabeledLink_LinkName() };
			MessageFormatParser parser = new MessageFormatParser(features);
			labeledLinkLinkName_6003Parser = parser;
		}
		return labeledLinkLinkName_6003Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ContainerNameEditPart.VISUAL_ID:
			return getContainerName_5002Parser();
		case ContainerName2EditPart.VISUAL_ID:
			return getContainerName_5001Parser();
		case LabeledLinkSourceNameEditPart.VISUAL_ID:
			return getLabeledLinkSourceName_6001Parser();
		case LabeledLinkTargetNameEditPart.VISUAL_ID:
			return getLabeledLinkTargetName_6002Parser();
		case LabeledLinkLinkNameEditPart.VISUAL_ID:
			return getLabeledLinkLinkName_6003Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object, String parserHint) {
		return ParserService.getInstance().getParser(new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(LinklfVisualIDRegistry.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(LinklfVisualIDRegistry.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (LinklfElementTypes.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}

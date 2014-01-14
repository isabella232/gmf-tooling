package org.eclipse.gmf.example.lesscode.diagram.part;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupInGroupManyEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.MultiContainmentGroupNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupInGroupOneEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.OneContainmentGroupNameEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.RootContainerEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.Subject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubject5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectInSubjectEditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName2EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName3EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName4EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectName5EditPart;
import org.eclipse.gmf.example.lesscode.diagram.edit.parts.SubjectNameEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.structure.DiagramStructure;

/**
* This registry is used to determine which type of visual object should be
* created for the corresponding Diagram, Node, ChildNode or Link represented
* by a domain model object.
* 
* @generated
*/
public class LesscodeVisualIDRegistry {

	/**
	* @generated
	*/
	private static final String DEBUG_KEY = "org.eclipse.gmf.examples.lesscode.diagram/debug/visualID"; //$NON-NLS-1$

	/**
	* @generated
	*/
	public static int getVisualID(View view) {
		if (view instanceof Diagram) {
			if (RootContainerEditPart.MODEL_ID.equals(view.getType())) {
				return RootContainerEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getVisualID(view.getType());
	}

	/**
	* @generated
	*/
	public static String getModelID(View view) {
		View diagram = view.getDiagram();
		while (view != diagram) {
			EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
			if (annotation != null) {
				return (String) annotation.getDetails().get("modelID"); //$NON-NLS-1$
			}
			view = (View) view.eContainer();
		}
		return diagram != null ? diagram.getType() : null;
	}

	/**
	* @generated
	*/
	public static int getVisualID(String type) {
		try {
			return Integer.parseInt(type);
		} catch (NumberFormatException e) {
			if (Boolean.TRUE.toString().equalsIgnoreCase(Platform.getDebugOption(DEBUG_KEY))) {
				LesscodeDiagramEditorPlugin.getInstance().logError("Unable to parse view type as a visualID number: " + type);
			}
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static String getType(int visualID) {
		return Integer.toString(visualID);
	}

	/**
	* @generated
	*/
	public static int getDiagramVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		if (LesscodePackage.eINSTANCE.getRootContainer().isSuperTypeOf(domainElement.eClass()) && isDiagram((RootContainer) domainElement)) {
			return RootContainerEditPart.VISUAL_ID;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static int getNodeVisualID(View containerView, EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		String containerModelID = org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getModelID(containerView);
		if (!RootContainerEditPart.MODEL_ID.equals(containerModelID)) {
			return -1;
		}
		int containerVisualID;
		if (RootContainerEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RootContainerEditPart.VISUAL_ID;
			} else {
				return -1;
			}
		}
		switch (containerVisualID) {
		case RootContainerEditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return SubjectEditPart.VISUAL_ID;
			}
			if (LesscodePackage.eINSTANCE.getOneContainmentGroup().isSuperTypeOf(domainElement.eClass())) {
				return OneContainmentGroupEditPart.VISUAL_ID;
			}
			if (LesscodePackage.eINSTANCE.getMultiContainmentGroup().isSuperTypeOf(domainElement.eClass())) {
				return MultiContainmentGroupEditPart.VISUAL_ID;
			}
			break;
		case SubjectInSubjectEditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject2EditPart.VISUAL_ID;
			}
			break;
		case SubjectInSubject2EditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject2EditPart.VISUAL_ID;
			}
			break;
		case OneContainmentGroupInGroupOneEditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject3EditPart.VISUAL_ID;
			}
			break;
		case SubjectInSubject3EditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject2EditPart.VISUAL_ID;
			}
			break;
		case MultiContainmentGroupInGroupManyEditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject4EditPart.VISUAL_ID;
			}
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject5EditPart.VISUAL_ID;
			}
			break;
		case SubjectInSubject4EditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject2EditPart.VISUAL_ID;
			}
			break;
		case SubjectInSubject5EditPart.VISUAL_ID:
			if (LesscodePackage.eINSTANCE.getSubject().isSuperTypeOf(domainElement.eClass())) {
				return Subject2EditPart.VISUAL_ID;
			}
			break;
		}
		return -1;
	}

	/**
	* @generated
	*/
	public static boolean canCreateNode(View containerView, int nodeVisualID) {
		String containerModelID = org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getModelID(containerView);
		if (!RootContainerEditPart.MODEL_ID.equals(containerModelID)) {
			return false;
		}
		int containerVisualID;
		if (RootContainerEditPart.MODEL_ID.equals(containerModelID)) {
			containerVisualID = org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getVisualID(containerView);
		} else {
			if (containerView instanceof Diagram) {
				containerVisualID = RootContainerEditPart.VISUAL_ID;
			} else {
				return false;
			}
		}
		switch (containerVisualID) {
		case RootContainerEditPart.VISUAL_ID:
			if (SubjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OneContainmentGroupEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MultiContainmentGroupEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectEditPart.VISUAL_ID:
			if (SubjectNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectInSubjectEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OneContainmentGroupEditPart.VISUAL_ID:
			if (OneContainmentGroupNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (OneContainmentGroupInGroupOneEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiContainmentGroupEditPart.VISUAL_ID:
			if (MultiContainmentGroupNameEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (MultiContainmentGroupInGroupManyEditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Subject2EditPart.VISUAL_ID:
			if (SubjectName2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectInSubject2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Subject3EditPart.VISUAL_ID:
			if (SubjectName3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectInSubject3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Subject4EditPart.VISUAL_ID:
			if (SubjectName4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectInSubject4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case Subject5EditPart.VISUAL_ID:
			if (SubjectName5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (SubjectInSubject5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectInSubjectEditPart.VISUAL_ID:
			if (Subject2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectInSubject2EditPart.VISUAL_ID:
			if (Subject2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case OneContainmentGroupInGroupOneEditPart.VISUAL_ID:
			if (Subject3EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectInSubject3EditPart.VISUAL_ID:
			if (Subject2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case MultiContainmentGroupInGroupManyEditPart.VISUAL_ID:
			if (Subject4EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			if (Subject5EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectInSubject4EditPart.VISUAL_ID:
			if (Subject2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		case SubjectInSubject5EditPart.VISUAL_ID:
			if (Subject2EditPart.VISUAL_ID == nodeVisualID) {
				return true;
			}
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static int getLinkWithClassVisualID(EObject domainElement) {
		if (domainElement == null) {
			return -1;
		}
		return -1;
	}

	/**
	* User can change implementation of this method to handle some specific
	* situations not covered by default logic.
	* 
	* @generated
	*/
	private static boolean isDiagram(RootContainer element) {
		return true;
	}

	/**
	* @generated
	*/
	public static boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
		if (candidate == -1) {
			//unrecognized id is always bad
			return false;
		}
		int basic = getNodeVisualID(containerView, domainElement);
		return basic == candidate;
	}

	/**
	* @generated
	*/
	public static boolean isCompartmentVisualID(int visualID) {
		switch (visualID) {
		case SubjectInSubjectEditPart.VISUAL_ID:
		case SubjectInSubject2EditPart.VISUAL_ID:
		case OneContainmentGroupInGroupOneEditPart.VISUAL_ID:
		case SubjectInSubject3EditPart.VISUAL_ID:
		case MultiContainmentGroupInGroupManyEditPart.VISUAL_ID:
		case SubjectInSubject4EditPart.VISUAL_ID:
		case SubjectInSubject5EditPart.VISUAL_ID:
			return true;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static boolean isSemanticLeafVisualID(int visualID) {
		switch (visualID) {
		case RootContainerEditPart.VISUAL_ID:
			return false;
		default:
			break;
		}
		return false;
	}

	/**
	* @generated
	*/
	public static final DiagramStructure TYPED_INSTANCE = new DiagramStructure() {

		/**
		 * @generated
		 */
		@Override
		public int getVisualID(View view) {
			return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getVisualID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public String getModelID(View view) {
			return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getModelID(view);
		}

		/**
		 * @generated
		 */
		@Override
		public int getNodeVisualID(View containerView, EObject domainElement) {
			return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.getNodeVisualID(containerView, domainElement);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean checkNodeVisualID(View containerView, EObject domainElement, int candidate) {
			return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.checkNodeVisualID(containerView, domainElement, candidate);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isCompartmentVisualID(int visualID) {
			return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.isCompartmentVisualID(visualID);
		}

		/**
		 * @generated
		 */
		@Override
		public boolean isSemanticLeafVisualID(int visualID) {
			return org.eclipse.gmf.example.lesscode.diagram.part.LesscodeVisualIDRegistry.isSemanticLeafVisualID(visualID);
		}
	};

}

//package org.eclipse.gmf.example.lesscode.diagram.edit.policies;
//
//import org.eclipse.gef.commands.Command;
//import org.eclipse.gmf.example.lesscode.diagram.edit.commands.Subject2CreateCommand;
//import org.eclipse.gmf.example.lesscode.diagram.providers.LesscodeElementTypes;
//import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
//
///**
//* @generated
//*/
//public class SubjectInSubject5ItemSemanticEditPolicy extends LesscodeBaseItemSemanticEditPolicy {
//
//	/**
//	* @generated
//	*/
//	public SubjectInSubject5ItemSemanticEditPolicy() {
//		super(LesscodeElementTypes.Subject_3004);
//	}
//
//	/**
//	* @generated
//	*/
//	protected Command getCreateCommand(CreateElementRequest req) {
//		if (LesscodeElementTypes.Subject_3001 == req.getElementType()) {
//			return getGEFWrapper(new Subject2CreateCommand(req));
//		}
//		return super.getCreateCommand(req);
//	}
//
//}

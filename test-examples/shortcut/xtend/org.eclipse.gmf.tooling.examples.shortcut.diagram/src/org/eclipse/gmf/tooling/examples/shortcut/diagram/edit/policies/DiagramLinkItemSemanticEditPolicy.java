package org.eclipse.gmf.tooling.examples.shortcut.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.tooling.examples.shortcut.diagram.providers.ShortcutElementTypes;

/**
 * @generated
 */
public class DiagramLinkItemSemanticEditPolicy extends ShortcutBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public DiagramLinkItemSemanticEditPolicy() {
		super(ShortcutElementTypes.DiagramLink_4001);
	}

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getGEFWrapper(new DestroyElementCommand(req));
	}

}

package org.eclipse.gmf.examples.subdiagrams.popup;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.requests.AbstractEditCommandRequest;

class DomainOnlyEditRequest extends AbstractEditCommandRequest {

	public DomainOnlyEditRequest(TransactionalEditingDomain editingDomain) {
		super(editingDomain);
	}

	public DomainOnlyEditRequest(IGraphicalEditPart editPart) {
		this(editPart.getEditingDomain());
	}

	@Override
	public Object getEditHelperContext() {
		return null;
	}
}
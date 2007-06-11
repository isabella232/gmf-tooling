package org.eclipse.gmf.examples.mindmap.lite.rcp.part;

import java.util.Iterator;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.WorkspaceEditingDomainFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPathEditorInput;
import org.eclipse.ui.PartInitException;

/**
 * @generated
 */
public class MindmapMatchingStrategy implements IEditorMatchingStrategy {
	/**
	 * @generated
	 */
	public boolean matches(IEditorReference editorRef, IEditorInput input) {
		if (editorRef == null
				|| !MindmapDiagramEditor.ID.equals(editorRef.getId())) {
			return false;
		}
		URI inputURI = getURIFromInput(input);
		if (inputURI == null) {
			return false;
		}
		try {
			IEditorInput editorInput = editorRef.getEditorInput();
			URI editorURI = getURIFromInput(editorInput);
			if (editorURI == null) {
				return false;
			}
			if (!editorURI.trimFragment().equals(inputURI.trimFragment())) {
				return false;
			}
			String editorFragment = editorURI.fragment();
			String inputFragment = inputURI.fragment();
			if (editorFragment != null && inputFragment != null) {
				return editorFragment.equals(inputFragment);
			}
			String nonNullFragment;
			if (editorFragment != null) {
				nonNullFragment = editorFragment;
			} else if (inputFragment != null) {
				nonNullFragment = inputFragment;
			} else {
				return true;
			}
			TransactionalEditingDomain domain = WorkspaceEditingDomainFactory.INSTANCE
					.createEditingDomain();
			Resource resource = domain.getResourceSet().getResource(
					editorURI.trimFragment(), true);
			for (Iterator it = resource.getContents().iterator(); it.hasNext();) {
				EObject next = (EObject) it.next();
				if (nonNullFragment.equals(resource.getURIFragment(next))) {
					return true;
				}
				if (next instanceof Diagram) {
					return false;
				}
			}
			return false;
		} catch (PartInitException e) {
			return false;
		}
	}

	/**
	 * @generated
	 */
	private URI getURIFromInput(IEditorInput input) {
		if (input == null) {
			return null;
		}
		if (input instanceof URIEditorInput) {
			return ((URIEditorInput) input).getURI();
		}
		if (input instanceof IPathEditorInput) {
			return URI.createFileURI(((IPathEditorInput) input).getPath()
					.toOSString());
		}
		URI uri = (URI) input.getAdapter(URI.class);
		if (uri != null) {
			return uri;
		}
		return null;
	}
}

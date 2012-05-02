package org.eclipse.gmf.examples.subdiagrams.popup;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.Request;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

public abstract class SubDiagramActionBase extends DiagramAction {

	protected static final String EMPTY_DIAGRAM_NAME = "<empty-name>";

	public SubDiagramActionBase(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	@Override
	protected Request createTargetRequest() {
		return null;
	}

	@Override
	protected boolean isSelectionListener() {
		return true;
	}

	protected String findDiagramEditorId() {
		return getDiagramWorkbenchPart().getSite().getId();
	}

	@Override
	public boolean isEnabled() {
		return getDiagramEditPart() != null;
	}

	protected static String safeGetSubDiagramName(SubDiagramSpec spec) {
		String name = spec.getName();
		return name != null ? name : EMPTY_DIAGRAM_NAME;

	}

	protected OpenSubDiagramCommand createOpenCommand(String label, SubDiagramSpec spec) {
		return createOpenCommand(label, Ref.create(spec));
	}

	protected OpenSubDiagramCommand createOpenCommand(String label, Ref<SubDiagramSpec> spec) {
		IEditCommandRequest request = new DomainOnlyEditRequest(getDiagramEditPart());
		return new OpenSubDiagramCommand(label, spec, findDiagramEditorId(), request);
	}

	protected static class OpenSubDiagramCommand extends EditElementCommand {

		private final Ref<SubDiagramSpec> mySpecRef;

		private final String myEditorId;

		public OpenSubDiagramCommand(String label, Ref<SubDiagramSpec> spec, String editorId, IEditCommandRequest request) {
			super(label, spec.get(), request);
			mySpecRef = spec;
			myEditorId = editorId;
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			SubDiagramSpec spec = mySpecRef.get();
			if (spec == null) {
				throw new ExecutionException("Can't find diagram specification");
			}

			Diagram diagram = spec.getDiagram();

			URI uri = EcoreUtil.getURI(diagram);
			String editorName = uri.lastSegment() + '#' + OpenSubDiagramAction.safeGetSubDiagramName(spec);
			IEditorInput editorInput = new URIEditorInput(uri, editorName);
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				page.openEditor(editorInput, myEditorId);
			} catch (PartInitException e) {
				throw new ExecutionException("Can't Open Sub Diagram", e);
			}

			return CommandResult.newOKCommandResult();
		}
	}

	protected static class Ref<T> {

		private T myValue;

		public Ref() {
		}

		public Ref(T value) {
			myValue = value;
		}

		public boolean isNull() {
			return myValue == null;
		}

		public T get() {
			return myValue;
		}

		public void set(T value) {
			myValue = value;
		}

		public static <T> Ref<T> create(T value) {
			return new Ref<T>(value);
		}

		public String toString() {
			return String.valueOf(myValue);
		}
	}
}

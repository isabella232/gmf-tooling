package org.eclipse.gmf.examples.subdiagrams.popup;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.Request;
import org.eclipse.gmf.examples.layers.SubDiagramSpec;
import org.eclipse.gmf.examples.layers.SubDiagramSupport;
import org.eclipse.gmf.examples.taipan.gmf.editor.part.TaiPanDiagramEditorUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.actions.DiagramAction;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.part.FileEditorInput;

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
			SubDiagramSupport support = (SubDiagramSupport) spec.eContainer();

			saveResourceSet(spec);

			IEditorInput editorInput = null;
			if (spec == support.getMainDiagram()) {
				//to switch to the main diagram if already open
				IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
				if (file != null) {
					editorInput = new FileEditorInput(file);
				}
			}
			if (editorInput == null) {
				URI uri = EcoreUtil.getURI(diagram);
				String editorName = uri.lastSegment() + '#' + OpenSubDiagramAction.safeGetSubDiagramName(spec);
				editorInput = new URIEditorInput(uri, editorName);
			}

			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			try {
				page.openEditor(editorInput, myEditorId);
			} catch (PartInitException e) {
				throw new ExecutionException("Can't Open Sub Diagram", e);
			}

			return CommandResult.newOKCommandResult();
		}

		protected void saveResourceSet(final SubDiagramSpec diagramSpec) throws ExecutionException {
			try {
				new WorkspaceModifyOperation() {

					@Override
					protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException, InterruptedException {
						try {
							for (Resource nextResource : diagramSpec.eResource().getResourceSet().getResources()) {
								if (nextResource.isLoaded() && !getEditingDomain().isReadOnly(nextResource)) {
									nextResource.save(TaiPanDiagramEditorUtil.getSaveOptions());
								}
							}
						} catch (IOException ex) {
							throw new InvocationTargetException(ex, "Save operation failed");
						}
					}
				}.run(null);
			} catch (InvocationTargetException e) {
				throw new ExecutionException("Can't save diagram file", e);
			} catch (InterruptedException e) {
				throw new ExecutionException("Can't save diagram file", e);
			}

		}

		/**
		 * XXX: this is copied from default diagram save options. 
		 * It may be a problem if the particular diagram has a custom changed ones
		 */
		protected static Map<?, ?> getSaveOptions() {

			HashMap<String, Object> saveOptions = new HashMap<String, Object>();
			saveOptions.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			return saveOptions;
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

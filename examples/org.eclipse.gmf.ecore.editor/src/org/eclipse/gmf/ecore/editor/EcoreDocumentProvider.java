package org.eclipse.gmf.ecore.editor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.MultiRule;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramModificationListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.ide.document.FileDiagramModificationListener;
import org.eclipse.gmf.runtime.emf.core.edit.MEditingDomain;
import org.eclipse.gmf.runtime.emf.core.edit.MFilter;
import org.eclipse.gmf.runtime.emf.core.edit.MListener;
import org.eclipse.gmf.runtime.emf.core.util.ResourceUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IFileEditorInput;

/**
 * @generated
 */
public class EcoreDocumentProvider extends FileDiagramDocumentProvider {

	/**
	 * @generated
	 */
	protected void saveDocumentToFile(IDocument document, IFile file, boolean overwrite, IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("", 100); //$NON-NLS-1$
		super.saveDocumentToFile(document, file, overwrite, new SubProgressMonitor(monitor, 20));

		IProgressMonitor subMonitor = new SubProgressMonitor(monitor, 20);
		Diagram diagram = (Diagram) document.getContent();
		Set externalResources = getReferencedResources(diagram);
		subMonitor.done();

		subMonitor = new SubProgressMonitor(monitor, 60);
		subMonitor.beginTask("Saving external resources", externalResources.size());
		for (Iterator it = externalResources.iterator(); it.hasNext();) {
			Resource nextResource = (Resource) it.next();
			subMonitor.setTaskName("Saving " + nextResource.getURI());
			ResourceUtil.save(nextResource);
			subMonitor.worked(1);
		}
		subMonitor.done();
	}

	/**
	 * @generated
	 */
	protected ISchedulingRule getSaveRule(Object element) {
		IDiagramDocument diagramDocument = getDiagramDocument(element);
		if (diagramDocument != null) {
			Diagram diagram = diagramDocument.getDiagram();
			if (diagram != null) {
				Collection rules = new ArrayList();

				Resource resource = ((EObject) diagram).eResource();
				IFile resourceFile = ResourceUtil.getFile(resource);
				rules.add(computeSaveSchedulingRule(resourceFile));

				Set externalResources = getReferencedResources(diagram);
				for (Iterator it = externalResources.iterator(); it.hasNext();) {
					Resource nextResource = (Resource) it.next();
					IFile nextResourceFile = ResourceUtil.getFile(nextResource);
					rules.add(computeSaveSchedulingRule(nextResourceFile));
				}

				return new MultiRule((ISchedulingRule[]) rules.toArray(new ISchedulingRule[rules.size()]));
			}
		}
		return super.getSaveRule(element);
	}

	/**
	 * @generated
	 */
	protected FileInfo createFileInfo(IDocument document, FileSynchronizer synchronizer, IFileEditorInput input) {
		assert document instanceof DiagramDocument;

		DiagramModificationListener diagramListener = new CustomModificationListener(this, (DiagramDocument) document, input);
		DiagramFileInfo info = new DiagramFileInfo(document, synchronizer, diagramListener);

		diagramListener.startListening();
		return info;
	}

	/**
	 * @generated
	 */
	private static Set getReferencedResources(Diagram diagram) {
		Resource diagramResource = ((EObject) diagram).eResource();
		if (diagramResource == null) {
			return Collections.EMPTY_SET;
		}

		return new HashSet(MEditingDomain.INSTANCE.getImports(diagramResource));
	}

	/**
	 * @generated
	 */
	private ISchedulingRule computeSaveSchedulingRule(IResource toCreateOrModify) {
		if (toCreateOrModify.exists() && toCreateOrModify.isSynchronized(IResource.DEPTH_ZERO))
			return fResourceRuleFactory.modifyRule(toCreateOrModify);

		IResource parent = toCreateOrModify;
		do {
			/*
			 * XXX This is a workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=67601
			 * IResourceRuleFactory.createRule should iterate the hierarchy itself.
			 */
			toCreateOrModify = parent;
			parent = toCreateOrModify.getParent();
		} while (parent != null && !parent.exists() && !parent.isSynchronized(IResource.DEPTH_ZERO));

		return fResourceRuleFactory.createRule(toCreateOrModify);
	}

	/**
	 * @generated
	 */
	private class CustomModificationListener extends FileDiagramModificationListener {

		/**
		 * @generated
		 */
		private MListener myListener = null;

		/**
		 * @generated
		 */
		public CustomModificationListener(EcoreDocumentProvider documentProviderParameter, DiagramDocument documentParameter, IFileEditorInput inputParameter) {
			super(documentProviderParameter, documentParameter, inputParameter);
			final DiagramDocument document = documentParameter;
			MFilter diagramResourceSavedFilter = new MFilter() {

				public boolean matches(Notification notification) {
					Diagram diagram = document.getDiagram();
					Object notifier = notification.getNotifier();
					if (diagram != null && notifier instanceof Resource) {
						Resource notifierResource = (Resource) notifier;
						Set externalResources = getReferencedResources(diagram);
						for (Iterator it = externalResources.iterator(); it.hasNext();) {
							Resource nextResource = (Resource) it.next();
							if (notifierResource == nextResource) {
								return notification.getEventType() == Notification.SET && notification.getFeatureID(Resource.class) == Resource.RESOURCE__IS_MODIFIED
										&& notification.getNewBooleanValue() == true;
							}
						}
					}
					return false;
				};
			};
			if (myListener == null) {
				myListener = new MListener(diagramResourceSavedFilter) {

					public void onEvent(List events) {
						document.setContent(document.getContent());
					}
				};
			}
		}

		/**
		 * @generated
		 */
		public void startListening() {
			super.startListening();
			myListener.startListening();
		}

		/**
		 * @generated
		 */
		public void stopListening() {
			myListener.stopListening();
			super.stopListening();
		}

	}

}

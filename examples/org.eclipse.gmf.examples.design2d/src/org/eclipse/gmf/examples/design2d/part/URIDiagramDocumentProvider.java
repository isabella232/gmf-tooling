/*
 *  Copyright (c) 2006, 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.design2d.part;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramModificationListener;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.emf.core.resources.GMFResourceFactory;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.ui.IEditorInput;

/**
 * @generated
 */
public class URIDiagramDocumentProvider extends AbstractDocumentProvider implements IDiagramDocumentProvider {

	/**
	 * @generated
	 */
	protected class URIElementInfo extends ElementInfo {

		/**
		 * @generated
		 */
		public DiagramModificationListener listener;

		/**
		 * @generated
		 */
		public URIElementInfo(IDocument document, DiagramModificationListener listener) {
			super(document);
			this.listener = listener;
		}
	}

	/**
	 * @generated
	 */
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		if (element instanceof URIEditorInput) {
			IDocument document = null;
			IStatus status = null;
			try {
				document = createDocument(element);
			} catch (CoreException x) {
				DesignDiagramEditorPlugin.getInstance().logError("Error creating document from uri", x);
				status = x.getStatus();
				document = createEmptyDocument();
			}
			ElementInfo info = createNewElementInfo(document);
			info.fStatus = status;
			return info;
		}
		return super.createElementInfo(element);
	}

	/**
	 * @generated
	 */
	public ElementInfo createNewElementInfo(IDocument document) {
		DiagramModificationListener listener = new DiagramModificationListener(this, (DiagramDocument) document);
		URIElementInfo info = new URIElementInfo(document, listener);
		listener.startListening();
		return info;
	}

	/**
	 * @generated
	 */
	protected void disposeElementInfo(Object element, ElementInfo info) {
		Object content = info.fDocument.getContent();
		if (content instanceof Diagram) {
			((Diagram) content).eResource().unload();
		}
		((URIElementInfo) info).listener.stopListening();
	}

	/**
	 * @generated
	 */
	public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
		if (editorInput instanceof URIEditorInput) {
			return new URIEditorInputProxy((URIEditorInput) editorInput, domain);
		}
		assert false;
		return null;
	}

	/**
	 * @generated
	 */
	public IDiagramDocument getDiagramDocument(Object element) {
		IDocument doc = getDocument(element);
		if (doc instanceof IDiagramDocument) {
			return (IDiagramDocument) doc;
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IDocument createDocument(Object element) throws CoreException {
		if (element instanceof URIEditorInput) {
			IDocument document = createEmptyDocument();
			if (setDocumentContent(document, (IEditorInput) element)) {
				setupDocument(element, document);
				return document;
			}
		}
		return null;
	}

	/**
	 * Sets up the given document as it would be provided for the given element. The
	 * content of the document is not changed. This default implementation is empty.
	 * Subclasses may reimplement.
	 *
	 * @param element the blue-print element
	 * @param document the document to set up
	 * @generated
	 */
	protected void setupDocument(Object element, IDocument document) {
		// for subclasses
	}

	/**
	 * @generated
	 */
	protected IDocument createEmptyDocument() {
		return new DiagramDocument();
	}

	/**
	 * @generated
	 */
	protected boolean setDocumentContent(IDocument document, IEditorInput editorInput) throws CoreException {
		if (editorInput instanceof org.eclipse.gmf.examples.design2d.part.URIEditorInputProxy) {
			org.eclipse.gmf.examples.design2d.part.URIEditorInputProxy diagramElement = (org.eclipse.gmf.examples.design2d.part.URIEditorInputProxy) editorInput;
			((IDiagramDocument) document).setEditingDomain(diagramElement.getEditingDomain());
		}
		if (editorInput instanceof URIEditorInput) {
			setDocumentContentFromStorage(document, ((URIEditorInput) editorInput).getURI());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void setDocumentContentFromStorage(IDocument document, org.eclipse.emf.common.util.URI uri) throws CoreException {
		IDiagramDocument diagramDocument = (IDiagramDocument) document;
		TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
		Resource resource = null;
		try {
			resource = domain.getResourceSet().getResource(uri.trimFragment(), false);
			if (resource == null) {
				resource = domain.getResourceSet().createResource(uri.trimFragment());
			}
			if (!resource.isLoaded()) {
				try {
					Map options = new HashMap(GMFResourceFactory.getDefaultLoadOptions());
					// @see 171060 
					// options.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
					resource.load(options);
				} catch (IOException e) {
					resource.unload();
					throw e;
				}
			}
			if (resource == null) {
				throw new RuntimeException("Unable to load diagram resource");
			}
			if (uri.fragment() != null) {
				EObject rootElement = resource.getEObject(uri.fragment());
				if (rootElement instanceof Diagram) {
					document.setContent((Diagram) rootElement);
					return;
				}
			} else {
				for (Iterator it = resource.getContents().iterator(); it.hasNext();) {
					Object rootElement = it.next();
					if (rootElement instanceof Diagram) {
						document.setContent((Diagram) rootElement);
						return;
					}
				}
			}
			throw new RuntimeException("Diagram is not present in resource");
		} catch (Exception e) {
			CoreException thrownExcp = null;
			if (e instanceof CoreException) {
				thrownExcp = (CoreException) e;
			} else {
				String msg = e.getLocalizedMessage();
				thrownExcp = new CoreException(new Status(IStatus.ERROR, DesignDiagramEditorPlugin.ID, 0, msg != null ? msg : "Error loading diagram", e)); //$NON-NLS-1$
			}
			throw thrownExcp;
		}
	}

	/**
	 * @generated
	 */
	protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite) throws CoreException {
		if (element instanceof URIEditorInput) {
			IDiagramDocument diagramDocument = (IDiagramDocument) document;
			TransactionalEditingDomain domain = diagramDocument.getEditingDomain();
			List resources = domain.getResourceSet().getResources();
			monitor.beginTask("Saving diagram", resources.size() + 1);
			for (Iterator it = resources.iterator(); it.hasNext();) {
				Resource nextResource = (Resource) it.next();
				monitor.setTaskName("Saving " + nextResource.getURI());
				if (nextResource.isLoaded()) {
					try {
						Map options = new HashMap();
						options.put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);
						nextResource.save(options);
					} catch (IOException e) {
						DesignDiagramEditorPlugin.getInstance().logError("Unable to save resource: " + nextResource.getURI(), e);
					}
				}
				monitor.worked(1);
			}
			monitor.done();
		}
	}

	/**
	 * @generated
	 */
	public boolean isDeleted(Object element) {
		if (element instanceof URIEditorInput) {
			File file = getFile((URIEditorInput) element);
			return file != null && !file.exists();
		}
		return false;
	}

	/**
	 * @generated
	 */
	public boolean isReadOnly(Object element) {
		if (element instanceof URIEditorInput) {
			File file = getFile((URIEditorInput) element);
			if (file != null && file.exists()) {
				return !file.canWrite();
			}
		}
		return false;
	}

	/**
	 * @generated
	 */
	public boolean isModifiable(Object element) {
		if (element instanceof URIEditorInput) {
			File file = getFile((URIEditorInput) element);
			if (file != null && file.exists()) {
				return file.canWrite();
			}
		}
		return true;
	}

	/**
	 * @generated
	 */
	public static File getFile(URIEditorInput input) {
		org.eclipse.emf.common.util.URI uri = input.getURI().trimFragment();
		if (uri != null && uri.isFile()) {
			File file = new File(uri.toFileString());
			if (!file.isDirectory()) {
				return file;
			}
		}
		return null;
	}

	/**
	 * @generated
	 */
	protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
		return null;
	}
}

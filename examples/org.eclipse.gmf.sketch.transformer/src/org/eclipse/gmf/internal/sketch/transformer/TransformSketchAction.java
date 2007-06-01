/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.sketch.transformer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.gmf.sketch.SketchDiagram;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * @author dstadnik
 */
public class TransformSketchAction implements IObjectActionDelegate {

	private IFile sketchFile;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void selectionChanged(IAction action, ISelection selection) {
		sketchFile = null;
		IFile file = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection elements = (IStructuredSelection) selection;
			if (elements.size() == 1) {
				Object element = elements.getFirstElement();
				if (element instanceof IFile) {
					file = (IFile) element;
				} else if (element instanceof IAdaptable) {
					file = (IFile) ((IAdaptable) element).getAdapter(IFile.class);
				}
			}
		}
		if (file != null && file.getName().endsWith("sketch")) { //$NON-NLS-1$
			sketchFile = file;
		}
		action.setEnabled(sketchFile != null);
	}

	public void run(IAction action) {
		if (sketchFile == null) {
			return;
		}
		ResourceSet rs = new ResourceSetImpl();
		SketchDiagram diagram = getDiagram(rs);
		if (diagram == null) {
			return;
		}
		GenModel genModel = getGenModel(rs);
		SketchTransformer transformer = createTransformer(diagram, genModel);
		try {
			transformer.run(new NullProgressMonitor());
		} catch (InvocationTargetException ite) {
			Activator.logError(Messages.TransformSketchAction_ErrorTransforming, ite);
		} catch (InterruptedException ie) {
		}
		if (transformer.getResult() != null) {
			saveResult(transformer.getResult(), rs);
		}
	}

	protected SketchTransformer createTransformer(SketchDiagram diagram, GenModel genModel) {
		return new SketchTransformer(diagram, genModel);
	}

	protected SketchDiagram getDiagram(ResourceSet rs) {
		URI uri = URI.createPlatformResourceURI(sketchFile.getFullPath().toString(), false);
		Resource resource = rs.getResource(uri, true);
		if (resource.getContents().size() == 1) {
			Object contents = resource.getContents().get(0);
			if (contents instanceof SketchDiagram) {
				return (SketchDiagram) contents;
			}
		}
		return null;
	}

	protected GenModel getGenModel(ResourceSet rs) {
		IPath path = sketchFile.getFullPath().removeFileExtension().addFileExtension("genmodel"); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(path.toString(), false);
		Resource resource = rs.getResource(uri, true);
		if (resource.getContents().size() == 1) {
			Object contents = resource.getContents().get(0);
			if (contents instanceof GenModel) {
				return (GenModel) contents;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	protected void saveResult(GenEditorGenerator editorGen, ResourceSet rs) {
		IPath path = sketchFile.getFullPath().removeFileExtension().addFileExtension("gmfgen"); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(path.toString(), false);
		Resource resource = rs.createResource(uri);
		resource.getContents().add(editorGen);
		try {
			Map options = new HashMap();
			options.put(XMLResource.OPTION_ENCODING, "UTF-8"); //$NON-NLS-1$
			resource.save(options);
		} catch (IOException ioe) {
			Activator.logError(Messages.TransformSketchAction_ErrorSavingResult, ioe);
		}
	}
}

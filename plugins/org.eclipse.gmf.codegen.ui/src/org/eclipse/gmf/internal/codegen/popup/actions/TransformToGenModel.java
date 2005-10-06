/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.popup.actions;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.bridge.genmodel.BasicDiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.DiagramGenModelTransformer;
import org.eclipse.gmf.bridge.genmodel.DiagramRunTimeModelHelper;
import org.eclipse.gmf.bridge.genmodel.EditPartNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.MetaInfoProviderNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.NotationViewFactoryNamingStrategy;
import org.eclipse.gmf.bridge.genmodel.SpecificDiagramRunTimeModelHelper;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.mappings.Mapping;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

/**
 * .gmfmap to .gmfgen
 * @author artem
 */
public class TransformToGenModel implements IObjectActionDelegate {
	private IFile myMapFile;
	private IWorkbenchPart myPart;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		myPart = targetPart;
	}

	public void run(IAction action) {
		URI destinationModelURI = getDestPath();
		if (destinationModelURI == null) {
			return;
		}
		final ResourceSet resSet = new ResourceSetImpl();
		Resource mapRes = resSet.getResource(getMapModelURI(), true);
		Mapping m = (Mapping) mapRes.getContents().get(0);

		DiagramRunTimeModelHelper drtModelHelper = null;
		URI specificRTGenModelURI = decideOnRunTimeModel();
		if (specificRTGenModelURI != null) {
			Resource drtGenModelRes = resSet.getResource(specificRTGenModelURI, true);
			if (drtGenModelRes != null) {
				GenModel drtGenModel = (GenModel) drtGenModelRes.getContents().get(0);
				drtModelHelper = new SpecificDiagramRunTimeModelHelper(drtGenModel);
			}
		}
		if (drtModelHelper == null) {
			drtModelHelper = new BasicDiagramRunTimeModelHelper();
		}
		DiagramGenModelTransformer t = new DiagramGenModelTransformer(drtModelHelper, new EditPartNamingStrategy(), new MetaInfoProviderNamingStrategy(), new NotationViewFactoryNamingStrategy());
		t.transform(m);
		GenDiagram genDiagram = t.getResult();

		Resource dgmmRes = resSet.createResource(destinationModelURI);
		dgmmRes.getContents().add(genDiagram);
		try {
			dgmmRes.save(Collections.EMPTY_MAP);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		myMapFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
	}

	private URI getDestPath() {
		IPath destPath = myMapFile.getFullPath().removeFileExtension().addFileExtension("gmfgen");
		final String defFileName = destPath.lastSegment();
		InputDialog dlg = new InputDialog(getShell(), "Target model file", "Please specify name of the file to save diagram genmodel to", defFileName, null);
		if (dlg.open() != InputDialog.OK) {
			return null;
		}
		return URI.createPlatformResourceURI(destPath.removeLastSegments(1).append(dlg.getValue()).toString());
	}

	private URI getMapModelURI() {
		return URI.createPlatformResourceURI(myMapFile.getFullPath().toString());
	}

	private Shell getShell() {
		return myPart.getSite().getShell();
	}

	private URI decideOnRunTimeModel() {
		IPath p = myMapFile.getFullPath();
		String defValue = p.removeLastSegments(1).append(p.removeFileExtension().lastSegment() + "-drt").addFileExtension("genmodel").toString();
		InputDialog dlg = new InputDialog(getShell(), "Diagram RunTime Model", "Please specify path to genmodel file that describes specific diagram runtime model, or press Cancel if you don't need one", defValue, null);
		if (dlg.open() == InputDialog.OK) {
			return URI.createPlatformResourceURI(dlg.getValue());
		}
		return null;
	}
}

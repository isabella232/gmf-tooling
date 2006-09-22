/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.gmf.gmfgraph.Canvas;
import org.eclipse.gmf.internal.bridge.ui.Plugin;
import org.eclipse.gmf.tooldef.GMFToolFactory;
import org.eclipse.gmf.tooldef.ToolRegistry;
import org.eclipse.jface.dialogs.IMessageProvider;

/**
 * @author artem
 */
public class OldWizardInput extends WizardInput {

	private EPackage myDomainModel;
	private Canvas myCanvas;
	private ToolRegistry myRegistry;
	private String initialECoreFile = null;
	private String initialGraphFile = null;
	private String initialToolFile = null;
	private boolean myIsBlankToolDef = false;

	public EPackage getDomainModel() {
		return myDomainModel;
	}

	public void setDomainModel(EPackage aPackage) {
		checkUnload(myDomainModel);
		myDomainModel = aPackage;
	}

	public void setGraphDef(Canvas canvas) {
		checkUnload(myCanvas);
		myCanvas = canvas;
	}

	public Canvas getCanvasDef() {
		return myCanvas;
	}

	public boolean isNewBlankToolDef() {
		return myIsBlankToolDef;
	}

	@SuppressWarnings("unchecked")
	public URI createBlankToolDef() {
		checkUnload(myRegistry);
		myRegistry = null;
		IPath toolDefFile = getMappingFile().getFullPath().removeFileExtension().addFileExtension(TOOLDEF_FILE_EXT);
		String baseName = getMappingFile().getFullPath().removeFileExtension().lastSegment();
		int i = 1;
		final IWorkspace wr = getMappingFile().getProject().getWorkspace(); 
		while (wr.getRoot().findMember(toolDefFile) != null) {
			toolDefFile = toolDefFile.removeLastSegments(1).append(baseName + i).addFileExtension(TOOLDEF_FILE_EXT);
			i++;
		}
		URI toolDefURI = URI.createPlatformResourceURI(toolDefFile.toString());
		myRegistry = GMFToolFactory.eINSTANCE.createToolRegistry();
		myRegistry.setPalette(GMFToolFactory.eINSTANCE.createPalette());
		getResourceSet().createResource(toolDefURI).getContents().add(myRegistry);
		myIsBlankToolDef  = true;
		return toolDefURI;
	}

	public void setToolDef(ToolRegistry registry) {
		checkUnload(myRegistry);
		myRegistry = registry;
		myIsBlankToolDef = false;
	}

	public ToolRegistry getToolDef() {
		return myRegistry;
	}

	/**
	 * @return status with code field set to constant from IMessageProvider
	 */
	public IStatus isReady2Go() {
		if (myDomainModel != null && myCanvas != null && myRegistry != null) {
			return Status.OK_STATUS;
		}
		if (myDomainModel == null) {
			return new Status(Status.WARNING, Plugin.getPluginID(), IMessageProvider.WARNING, Messages.inputNeedDomain, null);
		}
		if (myCanvas == null) {
			return new Status(Status.WARNING, Plugin.getPluginID(), IMessageProvider.WARNING, Messages.inputNeedCanvas, null);
		} else {
			return new Status(Status.WARNING, Plugin.getPluginID(), IMessageProvider.WARNING, Messages.inputNeedToolDef, null);
		}
	}

	private void checkUnload(EObject eobj) {
		if (eobj == null) {
			return;
		}
		if (eobj.eResource().getResourceSet() == getResourceSet() && eobj.eResource().isLoaded()) {
			eobj.eResource().unload();
		}
	}

	public List/*<EClass>*/ getCanvasElementCandidates() {
		UniqueEList rv = new UniqueEList();
		for (Iterator it = myDomainModel.getEClassifiers().iterator(); it.hasNext();) {
			Object next = it.next();
			if (next instanceof EClass) {
				EClass eClass = (EClass) next;
				if (!eClass.isAbstract() && !eClass.isInterface() && !eClass.getEAllContainments().isEmpty()) {
					rv.add(eClass);
				}
			}
		}
		return rv;
	}

	public String getInitialECoreFile() {
		return initialECoreFile;
	}

	public void setInitialECoreFile(String initialECoreFile) {
		this.initialECoreFile = initialECoreFile;
	}

	public String getInitialGraphFile() {
		return initialGraphFile;
	}

	public void setInitialGraphFile(String initialGraphFile) {
		this.initialGraphFile = initialGraphFile;
	}

	public String getInitialToolFile() {
		return initialToolFile;
	}

	public void setInitialToolFile(String initialToolFile) {
		this.initialToolFile = initialToolFile;
	}
}

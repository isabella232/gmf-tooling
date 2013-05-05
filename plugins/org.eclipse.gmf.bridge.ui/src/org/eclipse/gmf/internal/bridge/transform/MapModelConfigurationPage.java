/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Fedorov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.bridge.transform;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.internal.common.ui.ResourceLocationProvider;
import org.eclipse.gmf.mappings.Mapping;


public class MapModelConfigurationPage extends ModelConfigurationPage {
	
	public MapModelConfigurationPage(String pageId, ResourceLocationProvider rlp, ResourceSet resourceSet) {
		super(pageId, rlp, resourceSet);
		setTitle(Messages.TransformToGenModelWizard_title_mapmodel);
		setDescription(Messages.TransformToGenModelWizard_descr_mapmodel);
		setModelFileExtension("gmfmap"); //$NON-NLS-1$
	}

	@Override
	protected Resource doLoadResource(IProgressMonitor monitor) throws CoreException {
		ITransformToGenModelOperation o = getOperation();
		Mapping mapping = o.loadMappingModel(getURI(), monitor);
		return mapping.eResource();
	}

	ITransformToGenModelOperation getOperation() {
		TransformToGenModelWizard wizard = (TransformToGenModelWizard) getWizard();
		return wizard.getTransformOperation();
	}
	
	@Override
	protected void resourceChanged() {
		super.resourceChanged();
		Diagnostic load = getOperation().getMapmodelValidationResult();
		if (load != null) {
			if ((load.getSeverity() == IStatus.WARNING) || (load.getSeverity() == IStatus.INFO) ) {
				setStatusMessage(TransformToGenModelOperation.getFirst(load));
			}
		}
	}
}

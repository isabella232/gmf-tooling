/*
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.wizards;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.codegen.CodeGenUIPlugin;

/**
 * @author dstadnik
 */
public class FileDomainModelSource implements DomainModelSource {

	private IFile file; // file for which domain model is loaded

	private IFile newFile; // new file; source should be updated

	private EPackage contents;

	private IStatus errorStatus;

	public IFile getFile() {
		return newFile;
	}

	public void setFile(IFile file) {
		newFile = file;
	}

	public EPackage getContents() {
		return contents;
	}

	public IStatus getErrorStatus() {
		return errorStatus;
	}

	public boolean update() {
		if (newFile == null || newFile != file) {
			file = newFile;
			reload();
			return true;
		}
		return false;
	}

	protected void reload() {
		if (file == null) {
			contents = null;
			errorStatus = null;
		}
		try {
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString());
			ResourceSet rs = new ResourceSetImpl();
			Resource r = rs.getResource(uri, true);
			contents = (EPackage) r.getContents().get(0);
			errorStatus = null;
		} catch (Exception e) {
			contents = null;
			String namespace = CodeGenUIPlugin.getDefault().getBundle().getSymbolicName();
			errorStatus = new Status(IStatus.ERROR, namespace, 0, e.getMessage(), e);
		}
	}
}

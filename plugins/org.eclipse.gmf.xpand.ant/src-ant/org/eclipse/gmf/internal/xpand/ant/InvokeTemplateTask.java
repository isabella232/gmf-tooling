/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.ant;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tools.ant.BuildException;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * <p>
 * ... xmlns:xpt=<em>&quot;eclipse.org/gmf/2008/xpand&quot;</em>...
 * <p>
 * &lt;xpt:template name=&quot;a::b::Main&quot;/&gt;
 * 
 * @author artem
 */
public class InvokeTemplateTask extends AbstractTemplateTask {

	private String myTemplateName;

	private String myOutFile;

	private XpandFacade myFacade;

	public void setName(String name) {
		myTemplateName = name;
	}

	public void setOutFile(String uri) {
		myOutFile = uri;
	}

	@Override
	public void execute() throws BuildException {
		IProgressMonitor pm = new ProgressSupport(this);
		pm.beginTask(getTaskName(), 3);
		validate();
		pm.worked(1);
		//
		doExecute();
		//
		pm.done();
	}

	protected void doExecute() throws BuildException {
		XpandFacade xf = createFacade();
		String result = xf.xpand(myTemplateName, getInput().getTarget(), getTemplateArguments());
		if (myOutFile == null) {
			System.err.println(result);
		} else {
			try {
				File f = getProject().resolveFile(myOutFile);
				FileOutputStream os = new FileOutputStream(f);
				os.write(result.getBytes());
				os.close();
			} catch (IOException ex) {
				throw new BuildException("Can't write to " + myOutFile, ex, getLocation());
			}
		}
	}

	protected void validate() throws BuildException {
		if (myTemplateName == null) {
			throw new BuildException("Template name is missing", getLocation());
		}
		if (getInput().getTarget() == null) {
			throw new BuildException("Target object is missing", getLocation());
		}
		if (myFacade == null && (getTemplateRoots() == null || getTemplateRoots().length == 0)) {
			throw new BuildException("No template root specified", getLocation());
		}
	}

	protected Object[] getTemplateArguments() {
		return null;
	}

	protected void setTemplateTarget(InputSupport input) {
		getInput().chain(input);
	}

	protected void setFacade(XpandFacade xf) {
		myFacade = xf;
	}

	protected XpandFacade createFacade() throws BuildException {
		if (myFacade != null) {
			return new XpandFacade(myFacade);
		} else {
			return super.createFacade();
		}
	}

}

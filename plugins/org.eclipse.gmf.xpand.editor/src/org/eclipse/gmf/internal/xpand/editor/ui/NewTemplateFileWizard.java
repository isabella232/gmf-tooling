/*
 * Copyright (c) 2005, 2008 committers of openArchitectureWare and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of openArchitectureWare - initial API and implementation
 *     Artem Tikhomirov (Borland) - refactored. Add builder on project with new templates.
 */
package org.eclipse.gmf.internal.xpand.editor.ui;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.internal.xpand.build.XpandBuilder;
import org.eclipse.gmf.internal.xpand.editor.Activator;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewFileResourceWizard;

public class NewTemplateFileWizard extends BasicNewFileResourceWizard {
	
    public NewTemplateFileWizard() {
    }

    @Override
    public void addPages() {
    	super.addPages();
    	WizardNewFileCreationPage page = (WizardNewFileCreationPage) getPage("newFilePage1"); //$NON-NLS-1$
    	page.setTitle(Activator.getResourceString("wizard.page1.title")); //$NON-NLS-1$
    	page.setDescription(Activator.getResourceString("wizard.page1.desc")); //$NON-NLS-1$
    	page.setFileName("NewTemplateFile.xpt");
    }

    @Override
    public boolean performFinish() {
    	if (super.performFinish()) {
    		IFile f = ((WizardNewFileCreationPage) getPage("newFilePage1")).createNewFile(); //$NON-NLS-1$
    		configureBuilder(f.getProject());
    		return true;
    	} else {
    		return false;
    	}
    }

    private void configureBuilder(final IProject project) {
        try {
            final IProjectDescription desc = project.getDescription();
            final ICommand[] commands = desc.getBuildSpec();

            for (ICommand element : commands) {
                if (element.getBuilderName().equals(XpandBuilder.getBUILDER_ID())) {
    				return;
    			}
            }

            project.getWorkspace().run(new IWorkspaceRunnable() {
	
		        public void run(IProgressMonitor monitor) throws CoreException {
			        final ICommand[] newCommands = new ICommand[commands.length + 1];
			        System.arraycopy(commands, 0, newCommands, 0, commands.length);
			        final ICommand command = desc.newCommand();
			        command.setBuilderName(XpandBuilder.getBUILDER_ID());
			        newCommands[commands.length] = command;
			        desc.setBuildSpec(newCommands);
			        project.setDescription(desc, monitor);
				}
	    		
	    	}, project.getWorkspace().getRoot(), 0, null);
        } catch (CoreException ex) {
        	Activator.log(ex.getStatus());
        }
    }
}

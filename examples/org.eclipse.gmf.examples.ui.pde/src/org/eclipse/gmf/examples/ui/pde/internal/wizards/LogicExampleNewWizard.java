/******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/
package org.eclipse.gmf.examples.ui.pde.internal.wizards;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.examples.ui.pde.internal.GmfExamplesPlugin;
import org.eclipse.gmf.examples.ui.pde.internal.l10n.Messages;

public class LogicExampleNewWizard
    extends ProjectUnzipperNewWizard {

    /**
     * Constructor
     */
    public LogicExampleNewWizard() {
        super(
            "LogicExampleNewWizard", //$NON-NLS-1$
            Messages.LogicExample_createProjectPage_title,
            Messages.LogicExample_createProjectPage_desc,
            "org.eclipse.gmf.examples.runtime.diagram.logic", //$NON-NLS-1$  
            new URL[] {
                FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                    new Path("examples/logic.zip"), null), //$NON-NLS-1$
                FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                    new Path("examples/logicSemantic.zip"), null), //$NON-NLS-1$
                FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                    new Path("examples/logicSemanticEdit.zip"), null), //$NON-NLS-1$
                FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                    new Path("examples/logicSemanticEditor.zip"), null) //$NON-NLS-1$
            },
            new String[] {
                "{0}", "{0}.semantic", "{0}.semantic.edit", "{0}.semantic.editor"} //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
        );
    }
}

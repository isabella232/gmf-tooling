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

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.gmf.examples.ui.pde.internal.GmfExamplesPlugin;
import org.eclipse.gmf.examples.ui.pde.internal.l10n.Messages;

public class DecorationServiceExampleNewWizard
    extends ProjectUnzipperNewWizard {

    /**
     * Constructor
     */
    public DecorationServiceExampleNewWizard() {
        super(
            "DecorationServiceExampleNewWizard", //$NON-NLS-1$
            Messages.DecorationServiceExample_createProjectPage_title,
            Messages.DecorationServiceExample_createProjectPage_desc,
            "org.eclipse.gmf.examples.runtime.diagram.decorator", //$NON-NLS-1$  
            FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                new Path("examples/servicesDecorator.zip"), null)); //$NON-NLS-1$
    }
}

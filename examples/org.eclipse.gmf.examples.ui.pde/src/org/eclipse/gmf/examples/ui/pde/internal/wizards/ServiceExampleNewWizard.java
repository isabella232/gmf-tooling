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

public class ServiceExampleNewWizard
    extends ProjectUnzipperNewWizard {

    /**
     * Constructor
     */
    public ServiceExampleNewWizard() {
        super(
            "ServiceExampleNewWizard", //$NON-NLS-1$
            Messages.ServiceExample_createProjectPage_title,
            Messages.ServiceExample_createProjectPage_desc,
            "org.eclipse.gmf.examples.runtime.common.service", //$NON-NLS-1$  
            FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                new Path("examples/serviceExample.zip"), null)); //$NON-NLS-1$
    }
}

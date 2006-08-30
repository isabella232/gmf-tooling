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

public class GeoshapesExampleNewWizard
    extends ProjectUnzipperNewWizard {

    /**
     * Constructor
     */
    public GeoshapesExampleNewWizard() {
        super(
            "GeoshapesExampleNewWizard", //$NON-NLS-1$
            Messages.GeoshapesExample_createProjectPage_title,
            Messages.GeoshapesExample_createProjectPage_desc,
            "org.eclipse.gmf.examples.runtime.diagram.geoshapes", //$NON-NLS-1$  
            FileLocator.find(GmfExamplesPlugin.getDefault().getBundle(),
                new Path("examples/geoshapes.zip"), null)); //$NON-NLS-1$
    }
}

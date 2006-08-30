/******************************************************************************
 * Copyright (c) 2004, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.eclipse.gmf.examples.ui.pde.internal;

import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * The main plugin class to be used in the desktop.
 */
public class GmfExamplesPlugin
    extends AbstractUIPlugin {

    /** The shared instance. */
    private static GmfExamplesPlugin fPlugin;

    /**
     * Constructor.
     */
    public GmfExamplesPlugin() {
        super();
        fPlugin = this;
    }

    /**
     * Returns the shared instance.
     * 
     * @return The plugin instance of <code>GmfExamplesPlugin</code>
     */
    public static GmfExamplesPlugin getDefault() {
        return fPlugin;
    }

}
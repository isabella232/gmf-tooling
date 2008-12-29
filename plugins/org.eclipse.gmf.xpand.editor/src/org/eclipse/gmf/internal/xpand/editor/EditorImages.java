/*
 * Copyright (c) 2008 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.editor;

import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.services.IDisposable;

// would be better to have more generic Disposable interface than one from ui.services.
public class EditorImages implements IDisposable {

	private final ImageRegistry myRegistry;

	private static SoftReference<EditorImages> ourState;
	
	protected EditorImages() {
		myRegistry = new ImageRegistry(Display.getCurrent() == null ? Display.getDefault() : Display.getCurrent());
		// though, since creation happens at the moment someone requested image, getCurrent() shouldn't be null, ever.
	}

	public static EditorImages get() {
		EditorImages inst = ourState == null ? null : ourState.get();
		if (inst == null) {
			ourState = new SoftReference<EditorImages>(inst = new EditorImages());
		}
		return inst;
//		EditorImages inst = Activator.findState(EditorImages.class);
//		if (inst == null) {
//			Activator.putState(EditorImages.class, inst = new EditorImages());
//		}
//		return inst;
	}

	public Image getExtension() {
	    return imageFromPath("extension.gif"); //$NON-NLS-1$
	}
	public Image getOperation() {
	    return imageFromPath("operation.gif"); //$NON-NLS-1$
	}
	public Image getProperty() {
	    return imageFromPath("property.gif"); //$NON-NLS-1$
	}
	public Image getVariable() {
	    return imageFromPath("variable.gif"); //$NON-NLS-1$
	}
	public Image getType() {
	    return imageFromPath("type.gif"); //$NON-NLS-1$
	}
	public Image getStatement() {
	    return imageFromPath("statement.gif"); //$NON-NLS-1$
	}

    protected Image imageFromPath(final String path) {
    	if (myRegistry.getDescriptor(path) == null) {
	        ImageDescriptor desc = ImageDescriptor.getMissingImageDescriptor();
	        try {
	            desc = ImageDescriptor.createFromURL(makeIconFileURL(path));
	        } catch (final MalformedURLException me) {
	            Activator.logError(me);
	        }
	        myRegistry.put(path, desc);
    	}
    	return myRegistry.get(path);
    }

    private static URL makeIconFileURL(final String iconPath) throws MalformedURLException {
        final String pathSuffix = "/icons/"; //$NON-NLS-1$
        return Activator.getDefault().getBundle().getEntry(pathSuffix + iconPath);
    }

	public void dispose() {
		myRegistry.dispose();
	}
}

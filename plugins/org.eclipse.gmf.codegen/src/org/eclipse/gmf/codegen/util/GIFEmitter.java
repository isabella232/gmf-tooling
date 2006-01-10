/**
 * Copyright (c) 2006 Eclipse.org
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    vano - initial API and implementation
 */
package org.eclipse.gmf.codegen.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.osgi.framework.Bundle;


public class GIFEmitter {
	
	private String myInputFile;
	private Bundle myTemplatesBundle;

	public GIFEmitter(String fileName, Bundle templatesBundle) {
		myInputFile = fileName;
		myTemplatesBundle = templatesBundle;
	}
	
	public byte[] generateGif() {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			URL url = myTemplatesBundle.getEntry(myInputFile);
			InputStream is = new BufferedInputStream(url.openStream());
			for (int next = is.read(); next != -1; next = is.read()) {
				outputStream.write(next);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}			
		return outputStream.toByteArray();
	}

}

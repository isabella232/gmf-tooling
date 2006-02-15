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

import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.emf.codegen.jet.JETException;


public class GIFEmitter {
	
	private String myLocation;

	public GIFEmitter(String location) {
		myLocation = location;
	}
	
	public byte[] generateGif() throws JETException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			InputStream is = new BufferedInputStream(JETCompiler.openStream(myLocation));
			for (int next = is.read(); next != -1; next = is.read()) {
				outputStream.write(next);
			}
			is.close();
		} catch (IOException e) {
			throw new JETException(e);
		}
		return outputStream.toByteArray();
	}

}

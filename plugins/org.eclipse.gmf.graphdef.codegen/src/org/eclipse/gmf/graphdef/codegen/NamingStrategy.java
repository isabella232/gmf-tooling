/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.gmf.graphdef.codegen;

import org.eclipse.emf.codegen.util.CodeGenUtil;
import org.eclipse.gmf.gmfgraph.Figure;

/**
 * FIXME [artem] no reason for singleton
 */
public class NamingStrategy {
	public static NamingStrategy INSTANCE = new NamingStrategy();
	
	public String getChildFigureGetterName(Figure childFigure){
		return "getFigure" + CodeGenUtil.capName(CodeGenUtil.validJavaIdentifier(childFigure.getName()));
	}
}

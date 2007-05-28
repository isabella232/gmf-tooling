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
import org.eclipse.gmf.gmfgraph.ChildAccess;

/**
 * XXX [artem] use gmfgraph::Util.ext figureFieldGetter instead or any other *common* way instead.
 */
public class NamingStrategy {

	public static String getChildFigureGetterName(ChildAccess childFigure){
		return "getFigure" + CodeGenUtil.capName(CodeGenUtil.validJavaIdentifier(childFigure.getAccessor()));
	}
}

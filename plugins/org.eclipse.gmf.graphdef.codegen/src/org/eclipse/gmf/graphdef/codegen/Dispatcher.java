/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.codegen;

import org.eclipse.gmf.common.codegen.ImportAssistant;
import org.eclipse.gmf.gmfgraph.Figure;
import org.eclipse.gmf.gmfgraph.util.GMFGraphSwitch;

/**
 * @author artem
 */
public abstract class Dispatcher {

	public abstract String dispatch(Object arg, Object[] orginalArgs);

	public abstract String dispatch(Object key, Args args);

	// TODO just keep importManager+fqnSwitch in the dispatcher (pure interface + subclass?) and shorten the list of args then
	public Args create(Figure figure, String figureVarName, ImportAssistant importManager, GMFGraphSwitch fqnSwitch) {
		return new Args(this, figure, figureVarName, importManager, fqnSwitch);
	}

	public class Args {
		private final String myFigureVarName;
		private final ImportAssistant myImportManager;
		private final GMFGraphSwitch myFqnSwitch;
		private final Dispatcher myOwner;
		private final Figure myFigure;

		public Args(Dispatcher owner, Figure figure, String figureVarName, ImportAssistant importManager, GMFGraphSwitch fqnSwitch) {
			myOwner = owner;
			myFigure = figure;
			myFigureVarName = figureVarName;
			myImportManager = importManager;
			myFqnSwitch = fqnSwitch;
		}

		public Figure getFigure() {
			return myFigure;
		}

		public String getVariableName() {
			return myFigureVarName;
		}

		public ImportAssistant getImportManager() {
			return myImportManager;
		}

		public GMFGraphSwitch getFQNSwitch() {
			return myFqnSwitch;
		}

		public Dispatcher getDispatcher() {
			return myOwner;
		}
	}
}

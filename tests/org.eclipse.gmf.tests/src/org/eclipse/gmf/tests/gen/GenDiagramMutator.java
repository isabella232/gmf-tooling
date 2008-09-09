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
package org.eclipse.gmf.tests.gen;

import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;

/**
 * XXX this approach (mutators) actually hides which particular mutator instance causes problem
 * e.g. unlike with regular junit tests one can't tell the reason of failure just from method/test name 
 */
public abstract class GenDiagramMutator {
	private final String myIdentifyingToken;
	protected String myPluginID;

	public GenDiagramMutator(String identifyingToken) {
		myIdentifyingToken = identifyingToken;
	}

	// enforce generated plugin id change to make sure several mutators do not get into single plugin
	public void doMutate(GenEditorGenerator genEditor) {
		myPluginID = genEditor.getPlugin().getID();
		genEditor.getPlugin().setID(myPluginID + '.' + myIdentifyingToken);
		doMutation(genEditor.getDiagram());
	}

	public void undoMutate(GenEditorGenerator genEditor) {
		genEditor.getPlugin().setID(myPluginID);
		undoMutation(genEditor.getDiagram());
	}

	protected abstract void doMutation(GenDiagram d);
	protected abstract void undoMutation(GenDiagram d);
}

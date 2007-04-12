/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.tests.lite.gef;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.gmf.runtime.lite.parts.DiagramEditor;
import org.eclipse.gmf.tests.gef.AbstractDiagramEditorTest;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;

public class DiagramEditorMatchingStrategyTest extends AbstractDiagramEditorTest {
	public DiagramEditorMatchingStrategyTest(String name) {
		super(name);
	}

	public void testReusingEditor() throws Exception {
		IEditorPart editor = getEditor();
		IEditorInput editorInput = editor.getEditorInput();
		IFile file = (IFile) editorInput.getAdapter(IFile.class);
		assertNotNull("unexpected editor input", file);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		IEditorPart newEditor = editor.getSite().getPage().openEditor(new URIEditorInput(uri), editor.getSite().getId(), true, IWorkbenchPage.MATCH_INPUT);
		assertSame(editor, newEditor);
		newEditor = editor.getSite().getPage().openEditor(new URIEditorInput(uri.appendFragment("/")), editor.getSite().getId(), true, IWorkbenchPage.MATCH_INPUT);
		assertSame(editor, newEditor);
	}

	public void testReusingEditingDomain() throws Exception {
		DiagramEditor editor = (DiagramEditor) getEditor();
		IEditorInput editorInput = editor.getEditorInput();
		IFile file = (IFile) editorInput.getAdapter(IFile.class);
		assertNotNull("unexpected editor input", file);
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		DiagramEditor newEditor = (DiagramEditor) editor.getSite().getPage().openEditor(new URIEditorInput(uri), editor.getSite().getId(), true, IWorkbenchPage.MATCH_NONE);
		assertNotSame(editor, newEditor);
		assertSame(editor.getEditingDomain(), newEditor.getEditingDomain());
	}
}

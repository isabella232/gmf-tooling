/*******************************************************************************
* Copyright (c) 2011 EBM Websourcing (PetalsLink)
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
* Mickael Istria (EBM - PetalsLink) : initial implementation
*******************************************************************************/
package org.eclipse.gmf.tests.gen.swtbot;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swtbot.eclipse.finder.SWTBotEclipseTestCase;
import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.junit.Assert;
import org.junit.Test;

public class FigureGenerationTest extends SWTBotEclipseTestCase {
	
	@Test
	public void testBug267354_FigureRefChildren() throws Exception {
		//[MG] this test blinks at hudson, temporarily disabled
	}

	
	public void _testBug267354_FigureRefChildren() throws Exception {
		// Don't use SWTBot to save time and not related to GMF.
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					IProject proj = ResourcesPlugin.getWorkspace().getRoot().getProject("testProjectBug267354");
					proj.create(new NullProgressMonitor());
					proj.open(new NullProgressMonitor());
					IFile file = proj.getFile("267354-FigureRefChildren.gmfgraph");
					file.create(getClass().getClassLoader().getResourceAsStream("/models/tests/267354-FigureRefChildren.gmfgraph"), false, new NullProgressMonitor());
					IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file, "org.eclipse.gmf.gmfgraph.presentation.GMFGraphEditorID", true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		SWTBotTreeItem figureGalleryNode = bot.editorByTitle("267354-FigureRefChildren.gmfgraph").bot().tree().getAllItems()[0].expand().getNode("Canvas").expand().getNode("Figure Gallery").click();
		figureGalleryNode.contextMenu("Generate Figures Plug-in ...").click();
		bot.shell("Figure Gallery Generator").bot().text().setText("org.eclipse.gmf.testProjectBug267354");
		bot.button("OK").click();
		bot.waitWhile(new ICondition() {
			@Override
			public boolean test() throws Exception {
				return bot.activeShell().getText().equals("Generate Figures Plug-in ...");
			}
			
			@Override
			public void init(SWTBot bot) {
			}
			
			@Override
			public String getFailureMessage() {
				return null;
			}
		}, 40000);
		{
			// Check in ChildFigureRef
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					try {
						IFile file = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.gmf.testProjectBug267354").getFile(new Path("src/org/eclipse/gmf/testProjectBug267354/ChildFigureRef.java"));
						IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			String generatedCode = bot.editorByTitle("ChildFigureRef.java").toTextEditor().getText();
			Assert.assertTrue("No mention of FigureRef details", generatedCode.contains("Process FigureRef details"));
			Assert.assertTrue("Did not find specified background color attribute", generatedCode.contains("ColorConstants.lightGreen"));
		}
		{
			// Check in DirectFigureRef
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					try {
						IFile file = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.gmf.testProjectBug267354").getFile(new Path("src/org/eclipse/gmf/testProjectBug267354/DirectFigureRef.java"));
						IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			String generatedCode = bot.editorByTitle("DirectFigureRef.java").toTextEditor().getText();
			Assert.assertTrue("No mention of FigureRef details", generatedCode.contains("Process FigureRef details"));
			Assert.assertTrue("Did not find specified background color attribute", generatedCode.contains("ColorConstants.lightGreen"));
		}
		{
			// Check in NoRefFigure: no change for figures without Ref
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					try {
						IFile file = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.gmf.testProjectBug267354").getFile(new Path("src/org/eclipse/gmf/testProjectBug267354/NoRefFigure.java"));
						IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(), file);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			String generatedCode = bot.editorByTitle("NoRefFigure.java").toTextEditor().getText();
			Assert.assertFalse("Mention of 'FigureRef details' in figure without Ref!", generatedCode.contains("Process FigureRef details"));
		}
	}
}

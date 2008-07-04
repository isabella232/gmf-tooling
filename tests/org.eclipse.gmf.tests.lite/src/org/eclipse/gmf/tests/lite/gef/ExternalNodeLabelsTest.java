/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
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

import java.util.Iterator;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.ZoomManager;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;
import org.eclipse.gmf.runtime.lite.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tests.gef.AbstractDiagramEditorTest;
import org.eclipse.gmf.tests.lite.setup.LibraryConstrainedSetup;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class ExternalNodeLabelsTest extends AbstractDiagramEditorTest {
	public ExternalNodeLabelsTest(String name) {
		super(name);
		PlatformUI.getWorkbench().getEditorRegistry();
		myDefaultSetup = LibraryConstrainedSetup.getInstance();
	}

	public void testExternalNodeLabelsPosition() throws Exception {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		GenExternalNodeLabel firstExternalNodeLabel = getFirstExternalNodeLabel(nodeB);
		assertNotNull("Incorrect setup: expected ", firstExternalNodeLabel);
		Node nodeBInstance = createNode(nodeB, getDiagram());
		View extLabelInstance = findChildView(nodeBInstance, firstExternalNodeLabel);
		assertTrue("External node label was not created automatically", extLabelInstance instanceof Node);
		GraphicalEditPart nodeBEP = (GraphicalEditPart) findEditPart(nodeBInstance);
		assertNotNull(nodeBEP);
		GraphicalEditPart extLabelEP = (GraphicalEditPart) findEditPart(extLabelInstance);
		assertNotNull(extLabelEP);
		((GraphicalEditPart)getViewerConfiguration().getViewer().getRootEditPart()).getFigure().validate();
		checkExternalNodeLabelBounds(nodeBEP, extLabelEP);

		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_RESIZE);
		req.setMoveDelta(new Point(5, 5));
		req.setSizeDelta(new Dimension(7, 7));
		req.setEditParts(nodeBEP);
		req.setResizeDirection(PositionConstants.NORTH_WEST);
		Command cmd = nodeBEP.getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		((GraphicalEditPart)getViewerConfiguration().getViewer().getRootEditPart()).getFigure().validate();
		checkExternalNodeLabelBounds(nodeBEP, extLabelEP);

		req.setMoveDelta(new Point(0, 0));
		req.setSizeDelta(new Dimension(7, 7));
		req.setEditParts(nodeBEP);
		req.setResizeDirection(PositionConstants.SOUTH_EAST);
		cmd = nodeBEP.getCommand(req);
		assertNotNull("No resize command", cmd);
		assertTrue("Can't execute resize command", cmd.canExecute());
		getCommandStack().execute(cmd);
		checkExternalNodeLabelBounds(nodeBEP, extLabelEP);
	}

	private void checkExternalNodeLabelBounds(GraphicalEditPart nodeEP, GraphicalEditPart extLabelEP) {
		Rectangle nodeBounds = nodeEP.getFigure().getBounds();
		Rectangle labelBounds = extLabelEP.getFigure().getBounds();
		Node extLabelNode = (Node) extLabelEP.getModel();
		Location location = (Location) extLabelNode.getLayoutConstraint();
		assertNotNull("External label does not have layout constraint", location);
		Dimension tolerance = labelBounds.getSize().scale(1.0/3.0);
		Point nodeBottom = nodeBounds.getBottom();
		Point labelTop = labelBounds.getTop();
		assertEquals("Unexpected position of external node label", nodeBottom.x + location.getX(), labelTop.x, tolerance.width);
		assertEquals("Unexpected position of external node label", nodeBottom.y + location.getY(), labelTop.y, tolerance.height);
	}

	@SuppressWarnings("unchecked")
	private GenExternalNodeLabel getFirstExternalNodeLabel(GenNode genNode) {
		for(Iterator it = genNode.getLabels().iterator(); it.hasNext(); ) {
			GenNodeLabel next = (GenNodeLabel) it.next();
			if (next instanceof GenExternalNodeLabel) {
				return (GenExternalNodeLabel) next;
			}
		}
		return null;
	}

	public void testExternalNodeLabelsWithZoom() throws Exception {
		ZoomManager zoomManager = (ZoomManager) getDiagramEditPart().getViewer().getProperty(ZoomManager.class.toString());
		assertNotNull(zoomManager);
		zoomManager.setZoom(4.0);
		testExternalNodeLabelsPosition();
	}

	/**
	 * Makes sure that if font style specifies no font name, the diagram correctly updates when the default font changes.
	 */
	public void testDefaultFont() throws Exception {
		GenNode nodeB = getSetup().getGenModel().getNodeB();
		GenExternalNodeLabel firstExternalNodeLabel = getFirstExternalNodeLabel(nodeB);
		assertNotNull("Incorrect setup: expected ", firstExternalNodeLabel);
		Node nodeBInstance = createNode(nodeB, getDiagram());
		View extLabelInstance = findChildView(nodeBInstance, firstExternalNodeLabel);
		assertTrue("External node label was not created automatically", extLabelInstance instanceof Node);
		GraphicalEditPart nodeBEP = (GraphicalEditPart) findEditPart(nodeBInstance);
		assertNotNull(nodeBEP);
		GraphicalEditPart extLabelEP = (GraphicalEditPart) findEditPart(extLabelInstance);
		assertNotNull(extLabelEP);
		FontStyle style = (FontStyle)nodeBInstance.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		assertNotNull("Font style should not be null here", style);
		TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(style);
		org.eclipse.emf.common.command.Command create = SetCommand.create(domain, style, NotationPackage.eINSTANCE.getFontStyle_FontName(), null);
		execute(new WrappingCommand(domain, create));
		assertNull("Command failed to execute", style.getFontName());
		IPreferenceStore preferenceStore;
		try {
			Class<?> activatorClazz = getSetup().loadGeneratedClass(getSetup().getGenModel().getGenDiagram().getEditorGen().getPlugin().getActivatorQualifiedClassName());
			AbstractUIPlugin pluginInstance = (AbstractUIPlugin) activatorClazz.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
			preferenceStore = pluginInstance.getPreferenceStore();
		} catch (Throwable e) {
			fail("Failed to obtain default preferences");
			return;
		}
		FontData[] defaultFont = PreferenceConverter.getFontDataArray(preferenceStore, IPreferenceConstants.DEFAULT_FONT);
		String defaultName = defaultFont[0].getName();
		assertEquals(defaultName, extLabelEP.getFigure().getFont().getFontData()[0].getName());
		FontData[] fonts = Display.getDefault().getFontList(null, true);
		assertTrue(fonts.length > 1);
		int index = (int) (Math.random() * fonts.length);
		while (fonts[index].getName().equals(defaultName)) {
			index = (int) (Math.random() * fonts.length);
		}
		PreferenceConverter.setValue(preferenceStore, IPreferenceConstants.DEFAULT_FONT, fonts[index]);
		//Check that the font of the label has changed in response.
		assertEquals(fonts[index].getName(), extLabelEP.getFigure().getFont().getFontData()[0].getName());
	}
}

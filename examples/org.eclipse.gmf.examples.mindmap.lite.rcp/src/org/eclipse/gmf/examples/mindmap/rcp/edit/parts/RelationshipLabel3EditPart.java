/*
 * Copyright (c) 2006, 2007 Borland Software Corporation.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *      Richard Gronback (Borland) - initial API and implementation
 */
package org.eclipse.gmf.examples.mindmap.rcp.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionLocator;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ConnectionEndpointEditPolicy;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.rcp.part.MindmapDiagramEditorUtil;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.ILabelController;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.ILabelTextDisplayer;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.MessageFormatLabelTextDisplayer;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.lite.edit.policies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.lite.services.LabelCellEditorLocator;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Location;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

/**
 * @generated
 */
public class RelationshipLabel3EditPart extends AbstractGraphicalEditPart
		implements ILabelController {
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 6003;

	/**
	 * @generated
	 */
	public RelationshipLabel3EditPart(View model) {
		assert model instanceof Node;
		setModel(model);
	}

	/**
	 * @generated
	 */
	public Node getDiagramNode() {
		return (Node) getModel();
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.CONNECTION_ENDPOINTS_ROLE,
				new ConnectionEndpointEditPolicy() {
					public EditPart getHost() {
						return getUpdatableParent();
					}
				});
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void refreshFont() {
		FontStyle style = (FontStyle) getUpdatableParent().getDiagramEdge()
				.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		Font toDispose = createdFont;
		if (style != null) {
			String fontName = style.getFontName();
			int fontHeight = style.getFontHeight();
			int fontStyle = SWT.NORMAL;
			if (style.isBold()) {
				fontStyle |= SWT.BOLD;
			}
			if (style.isItalic()) {
				fontStyle |= SWT.ITALIC;
			}
			Font currentFont = getFigure().getFont();
			if (currentFont != null) {
				FontData currentFontData = currentFont.getFontData()[0];
				if (currentFontData.getName().equals(fontName)
						&& currentFontData.getHeight() == fontHeight
						&& currentFontData.getStyle() == fontStyle) {
					return;
				}
			}
			createdFont = new Font(null, fontName, fontHeight, fontStyle);
			getFigure().setFont(createdFont);
		} else {
			//revert to the default font
			getFigure().setFont(getViewer().getControl().getFont());
			createdFont = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The font (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned).
	 * Whenever another non-default font is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Font createdFont;

	/**
	 * @generated
	 */
	protected void refreshFontColor() {
		FontStyle style = (FontStyle) getUpdatableParent().getDiagramEdge()
				.getStyle(NotationPackage.eINSTANCE.getFontStyle());
		Color toDispose = createdFontColor;
		if (style != null) {
			int fontColor = style.getFontColor();
			int red = fontColor & 0x000000FF;
			int green = (fontColor & 0x0000FF00) >> 8;
			int blue = (fontColor & 0x00FF0000) >> 16;
			Color currentColor = getFigure().getForegroundColor();
			if (currentColor != null && currentColor.getRed() == red
					&& currentColor.getGreen() == green
					&& currentColor.getBlue() == blue) {
				return;
			}
			createdFontColor = new Color(null, red, green, blue);
			getFigure().setForegroundColor(createdFontColor);
		} else {
			getFigure().setForegroundColor(
					getViewer().getControl().getForeground());
			createdFontColor = null;
		}
		if (toDispose != null) {
			toDispose.dispose();
		}
	}

	/**
	 * The color (created by {@link #refreshFontColor()}) currently assigned to the label.
	 * Whenever another color is assigned to it, it is safe to dispose the previous one.
	 * @generated
	 */
	private Color createdFontColor;

	/**
	 * @generated
	 */
	protected void refreshLabel() {
		getLabel().setText(getLabelText());
		getLabel().setIcon(getLabelIcon());
	}

	/**
	 * @generated
	 */
	private IExternallyUpdatableEditPart.ExternalRefresher labelRefresher;

	/**
	 * @generated
	 */
	protected IExternallyUpdatableEditPart.ExternalRefresher getLabelRefresher() {
		if (labelRefresher == null && getDiagramNode() != null) {
			labelRefresher = new ILabelController.ExternalRefresherAdapter(
					this, getDiagramNode().getElement());
		}
		return labelRefresher;
	}

	/**
	 * @generated
	 */
	private IExternallyUpdatableEditPart.ExternalRefresher fontRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
		public void refresh() {
			if (!isActive()) {
				return;
			}
			refreshFont();
		}

		public boolean isAffectingEvent(Notification msg) {
			if (NotationPackage.eINSTANCE.getFontStyle_FontColor() == msg
					.getFeature()) {
				return true;
			}
			if (NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
				return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
						.getFontStyle());
			}
			return false;
		}
	};
	/**
	 * @generated
	 */
	private IExternallyUpdatableEditPart.ExternalRefresher fontColorRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
		public void refresh() {
			if (!isActive()) {
				return;
			}
			refreshFontColor();
		}

		public boolean isAffectingEvent(Notification msg) {
			if (NotationPackage.eINSTANCE.getFontStyle()
					.getEStructuralFeatures().contains(msg.getFeature())) {
				return true;
			}
			if (NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
				return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
						.getFontStyle());
			}
			return false;
		}
	};

	/**
	 * @generated
	 */
	protected void refreshLocation() {
		Node node = getDiagramNode();
		assert node.getLayoutConstraint() instanceof Location;
		final Location location = (Location) node.getLayoutConstraint();
		Relationship3EditPart parent = getUpdatableParent();
		Connection connection = (Connection) parent.getFigure();
		((GraphicalEditPart) getParent()).setLayoutConstraint(this,
				getFigure(), new ConnectionLocator(connection,
						ConnectionLocator.MIDDLE) {
					protected Point getReferencePoint() {
						return super.getReferencePoint().translate(
								location.getX(), location.getY());
					}
				});
	}

	/**
	 * @generated
	 */
	private IExternallyUpdatableEditPart.ExternalRefresher locationRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
		public void refresh() {
			if (!isActive()) {
				return;
			}
			refreshLocation();
		}

		public boolean isAffectingEvent(Notification msg) {
			if (NotationPackage.eINSTANCE.getLocation()
					.getEStructuralFeatures().contains(msg.getFeature())) {
				return true;
			}
			if (NotationPackage.eINSTANCE.getNode_LayoutConstraint() == msg
					.getFeature()) {
				return true;
			}
			return false;
		}
	};

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshLocation();
	}

	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}

		if (RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())
				&& understandsRequest(req)) {
			performDirectEdit();
			return;
		}
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	private DirectEditManager manager;

	/**
	 * @generated
	 */
	protected DirectEditManager getManager() {
		if (manager == null) {
			manager = new DirectEditManager(this, TextCellEditor.class,
					new LabelCellEditorLocator(getViewer(), getLabel())) {
				protected void initCellEditor() {
					getCellEditor().setValue(
							getLabelTextDisplayer().getEditText(
									getDiagramNode().getElement()));
				}
			};
		}
		return manager;
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		if (MindmapDiagramEditorUtil.isReadOnly(getDiagramNode().getElement())
				|| MindmapDiagramEditorUtil.isReadOnly(getDiagramNode())) {
			return;
		}
		if (getLabelTextDisplayer() == null) {
			return;
		}
		getManager().show();
	}

	/**
	 * @generated
	 */
	public static final ILabelTextDisplayer LABEL_DISPLAYER = createLabelTextDisplayer();

	/**
	 * @generated
	 */
	public ILabelTextDisplayer getLabelTextDisplayer() {
		return LABEL_DISPLAYER;
	}

	/**
	 * @generated
	 */
	private static ILabelTextDisplayer createLabelTextDisplayer() {
		return new MessageFormatLabelTextDisplayer(
				"Ç{0}È", "Ç{0}È", "Ç{0}È", new EAttribute[] { MindmapPackage.eINSTANCE.getRelationship_Label() }); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
	}

	/**
	 * @generated
	 */
	private String defaultText;

	/**
	 * @generated
	 */
	public void setLabelText(String text) {
		if (text == null || text.length() == 0) {
			text = defaultText;
		}
		getLabel().setText(text);
	}

	/**
	 * @generated
	 */
	protected String getLabelText() {
		if (getLabelTextDisplayer() == null) {
			return defaultText;
		}
		EObject element = getDiagramNode().getElement();
		if (element == null) {
			return defaultText;
		}
		String result = getLabelTextDisplayer().getDisplayText(element);
		if (result == null || result.length() == 0) {
			return defaultText;
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected Image getLabelIcon() {
		return null;
	}

	/**
	 * @generated
	 */
	protected IFigure createFigure() {
		Label label = createLabel();
		defaultText = label.getText();
		return label;
	}

	/**
	 * @generated
	 */
	protected Label createLabel() {
		return new Label();
	}

	/**
	 * @generated
	 */
	public Label getLabel() {
		return (Label) getFigure();
	}

	/**
	 * @generated
	 */
	private Relationship3EditPart getUpdatableParent() {
		assert getParent() instanceof Relationship3EditPart;
		return (Relationship3EditPart) getParent();
	}

	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		Relationship3EditPart updatableParent = getUpdatableParent();
		if (updatableParent != null) {
			updatableParent.addExternalRefresher(fontColorRefresher);
			updatableParent.addExternalRefresher(fontRefresher);
			updatableParent.addExternalRefresher(getLabelRefresher());
			updatableParent.addExternalRefresher(locationRefresher);
		}
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		Relationship3EditPart updatableParent = getUpdatableParent();
		if (updatableParent != null) {
			updatableParent.removeExternalRefresher(fontColorRefresher);
			updatableParent.removeExternalRefresher(fontRefresher);
			updatableParent.removeExternalRefresher(getLabelRefresher());
			updatableParent.removeExternalRefresher(locationRefresher);
		}
		super.deactivate();
	}

}

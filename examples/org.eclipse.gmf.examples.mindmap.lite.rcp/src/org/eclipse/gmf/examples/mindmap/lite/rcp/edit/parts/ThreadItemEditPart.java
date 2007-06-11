package org.eclipse.gmf.examples.mindmap.lite.rcp.edit.parts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.lite.rcp.edit.policies.ThreadItemComponentEditPolicy;
import org.eclipse.gmf.examples.mindmap.lite.rcp.part.MindmapDiagramEditorPlugin;
import org.eclipse.gmf.examples.mindmap.lite.rcp.part.MindmapDiagramEditorUtil;
import org.eclipse.gmf.examples.mindmap.lite.rcp.providers.MindmapElementTypes;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.ILabelController;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.ILabelTextDisplayer;
import org.eclipse.gmf.runtime.lite.edit.parts.labels.MessageFormatLabelTextDisplayer;
import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IExternallyUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshersRegistry;
import org.eclipse.gmf.runtime.lite.edit.parts.update.TransactionalUpdateManager;
import org.eclipse.gmf.runtime.lite.edit.parts.update.UpdaterUtil;
import org.eclipse.gmf.runtime.lite.edit.policies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.lite.services.LabelCellEditorLocator;
import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Widget;

/**
 * @generated
 */
public class ThreadItemEditPart extends AbstractGraphicalEditPart implements
		IUpdatableEditPart, IExternallyUpdatableEditPart, ILabelController {
	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	public ThreadItemEditPart(View model) {
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
	protected void registerModel() {
		super.registerModel();
		View view = (View) getModel();
		if (view != null && view.isSetElement() && view.getElement() != null) {
			getViewer().getEditPartRegistry().put(view.getElement(), this);
		}
	}

	/**
	 * @generated
	 */
	protected void unregisterModel() {
		super.unregisterModel();
		View view = (View) getModel();
		if (view != null
				&& view.isSetElement()
				&& view.getElement() != null
				&& getViewer().getEditPartRegistry().get(view.getElement()) == this) {
			getViewer().getEditPartRegistry().remove(view.getElement());
		}
	}

	/**
	 * @generated
	 */
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new ThreadItemComponentEditPolicy());
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
	protected List getModelChildren() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected List getModelSourceConnections() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	protected List getModelTargetConnections() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @generated
	 */
	public Object getAdapter(Class key) {
		if (TreeEditPart.class == key) {
			return getTreeEditPartAdapter();
		}
		return super.getAdapter(key);
	}

	/**
	 * @generated
	 */
	private TreeEditPartAdapter myTreeEditPartAdapter;

	/**
	 * @generated
	 */
	private TreeEditPartAdapter getTreeEditPartAdapter() {
		if (myTreeEditPartAdapter == null) {
			myTreeEditPartAdapter = new TreeEditPartAdapter();
		}
		return myTreeEditPartAdapter;
	}

	/**
	 * @generated
	 */
	public void activate() {
		super.activate();
		addExternalRefresher(getLabelRefresher());
		getTransactionalUpdateManager().addUpdatableEditPart(
				getDiagramNode().getElement(), this);
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		getTransactionalUpdateManager().removeUpdatableEditPart(
				getDiagramNode().getElement(), this);
		removeExternalRefresher(getLabelRefresher());
		super.deactivate();
	}

	/**
	 * @generated
	 */
	private TransactionalUpdateManager getTransactionalUpdateManager() {
		return (TransactionalUpdateManager) getViewer().getProperty(
				TransactionalUpdateManager.class.getName());
	}

	/**
	 * @generated
	 */
	private RefreshersRegistry myRefreshersRegistry;

	/**
	 * @generated
	 */
	public Refresher getRefresher(EStructuralFeature feature, Notification msg) {
		if (myRefreshersRegistry == null) {
			createRefreshers();
		}
		return myRefreshersRegistry.getRefresher(feature, msg);
	}

	/**
	 * @generated
	 */
	private void createRefreshers() {
		myRefreshersRegistry = new RefreshersRegistry();
		Refresher visibilityRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshVisibility();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getView_Visible() == msg
						.getFeature()) {
					return msg.getNotifier() == getDiagramNode();
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Visible(),
				visibilityRefresher);
		Refresher fontRefresher = new IExternallyUpdatableEditPart.ExternalRefresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshFont();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getFontStyle()
						.getEStructuralFeatures().contains(msg.getFeature())) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getFontStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_FontHeight(), fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_FontName(), fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getFontStyle_Bold(),
				fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_Italic(), fontRefresher);
		myRefreshersRegistry.add(NotationPackage.eINSTANCE.getView_Styles(),
				fontRefresher);
		Refresher fontColorRefresher = new Refresher() {
			public void refresh() {
				if (!isActive()) {
					return;
				}
				refreshFontColor();
			}

			public boolean isAffectingEvent(Notification msg) {
				if (NotationPackage.eINSTANCE.getFontStyle_FontColor() == msg
						.getFeature()) {
					return true;
				}
				if (NotationPackage.eINSTANCE.getView_Styles() == msg
						.getFeature()) {
					return UpdaterUtil.affects(msg, NotationPackage.eINSTANCE
							.getFontStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(NotationPackage.eINSTANCE
				.getFontStyle_FontColor(), fontColorRefresher);
	}

	/**
	 * @generated
	 */
	protected void refreshVisibility() {
		boolean isVisible = getDiagramNode().isVisible();
		boolean wasVisible = getFigure().isVisible();
		if (isVisible == wasVisible) {
			return;
		}
		if (!isVisible && (getSelected() != SELECTED_NONE)) {
			getViewer().deselect(this);
		}
		getFigure().setVisible(isVisible);
		getFigure().revalidate();
	}

	/**
	 * @generated
	 */
	protected void refreshFont() {
		FontStyle style = (FontStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
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
		FontStyle style = (FontStyle) getDiagramNode().getStyle(
				NotationPackage.eINSTANCE.getFontStyle());
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
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshVisibility();
		refreshLabel();
		refreshFont();
		refreshFontColor();
	}

	/**
	 * @generated
	 */
	private Collection externalRefreshers = new ArrayList();

	/**
	 * @generated
	 */
	public Collection getExternalRefreshers() {
		return externalRefreshers;
	}

	/**
	 * @generated
	 */
	public void addExternalRefresher(
			IExternallyUpdatableEditPart.ExternalRefresher externalRefresher) {
		if (externalRefresher != null
				&& !externalRefreshers.contains(externalRefresher)) {
			externalRefreshers.add(externalRefresher);
		}
	}

	/**
	 * @generated
	 */
	public void removeExternalRefresher(
			IExternallyUpdatableEditPart.ExternalRefresher externalRefresher) {
		externalRefreshers.remove(externalRefresher);
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
		return new MessageFormatLabelTextDisplayer(null, null, null,
				new EAttribute[] { MindmapPackage.eINSTANCE
						.getThreadItem_Body() });
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
		return MindmapElementTypes.getImage(getDiagramNode().getElement()
				.eClass());
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
	private class TreeEditPartAdapter extends BaseTreeEditPart {
		/**
		 * @generated
		 */
		public TreeEditPartAdapter() {
			super(getDiagramNode(), MindmapDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
		}

		/**
		 * @generated
		 */
		protected void createEditPolicies() {
			installEditPolicy(EditPolicy.COMPONENT_ROLE,
					new ThreadItemComponentEditPolicy());
			installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
					new LabelDirectEditPolicy());
		}

		/**
		 * @generated
		 */
		public void setWidget(Widget widget) {
			if (widget == null) {
				myTreeEditPartAdapter = null;
			}
			super.setWidget(widget);
		}

		/**
		 * @generated
		 */
		protected ILabelTextDisplayer createLabelTextDisplayer() {
			return ThreadItemEditPart.this.getLabelTextDisplayer();
		}

		/**
		 * @generated
		 */
		protected Image getImage() {
			return ThreadItemEditPart.this.getLabelIcon();
		}

		/**
		 * @generated
		 */
		protected List getModelChildren() {
			return Collections.EMPTY_LIST;
		}
	}
}

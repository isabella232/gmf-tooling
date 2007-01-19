package org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.edit.parts;

import java.text.MessageFormat;
import java.text.ParseException;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

import org.eclipse.emf.common.command.CompoundCommand;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.command.SetCommand;

import org.eclipse.emf.transaction.TransactionalEditingDomain;

import org.eclipse.emf.transaction.util.TransactionUtil;

import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.TreeEditPart;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editparts.ZoomManager;

import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;

import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;

import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gef.tools.DirectEditManager;

import org.eclipse.gmf.examples.mindmap.MindmapPackage;
import org.eclipse.gmf.examples.mindmap.ThreadItem;

import org.eclipse.gmf.examples.mindmap.lite.rcp.diagram.part.MindmapDiagramEditorPlugin;

import org.eclipse.gmf.runtime.lite.commands.RemoveNotationalElementCommand;
import org.eclipse.gmf.runtime.lite.commands.WrappingCommand;

import org.eclipse.gmf.runtime.lite.edit.parts.tree.BaseTreeEditPart;

import org.eclipse.gmf.runtime.lite.edit.parts.update.IUpdatableEditPart;
import org.eclipse.gmf.runtime.lite.edit.parts.update.RefreshAdapter;

import org.eclipse.gmf.runtime.lite.services.ParserUtil;
import org.eclipse.gmf.runtime.lite.services.TreeDirectEditManager;

import org.eclipse.gmf.runtime.notation.FontStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.jface.resource.ImageDescriptor;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;

import org.eclipse.swt.SWT;

import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;

import org.eclipse.swt.widgets.TreeItem;

/**
 * @generated
 */
public class ThreadItemEditPart extends AbstractGraphicalEditPart implements
		IUpdatableEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3002;

	/**
	 * @generated
	 */
	private DirectEditManager manager;

	/**
	 * @generated
	 */
	private String defaultText;

	/**
	 * @generated
	 */
	public ThreadItemEditPart(View view) {
		setModel(view);
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
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy() {
			protected void showCurrentEditValue(DirectEditRequest request) {
				String value = (String) request.getCellEditor().getValue();
				getLabel().setText(value);
			}

			protected Command getDirectEditCommand(DirectEditRequest request) {
				String value = (String) request.getCellEditor().getValue();
				if (value == null) {
					//Invalid value is transformed into a null by the validator.
					//XXX: implement validator
					return UnexecutableCommand.INSTANCE;
				}
				final Object[] parseResult;
				try {
					parseResult = new MessageFormat(EDIT_PATTERN).parse(value);
				} catch (IllegalArgumentException e) {
					return UnexecutableCommand.INSTANCE;
				} catch (ParseException e) {
					return UnexecutableCommand.INSTANCE;
				}
				TransactionalEditingDomain editingDomain = TransactionUtil
						.getEditingDomain(getDiagramNode().getDiagram()
								.getElement());
				if (parseResult.length != 1) {
					return UnexecutableCommand.INSTANCE;
				}
				org.eclipse.emf.common.command.Command domainModelCommand = createDomainModelCommand(
						editingDomain, parseResult);
				return new WrappingCommand(editingDomain, domainModelCommand);
			}

			org.eclipse.emf.common.command.Command createDomainModelCommand(
					TransactionalEditingDomain editingDomain, Object[] values) {
				ThreadItem element = (ThreadItem) getDiagramNode().getElement();
				CompoundCommand result = new CompoundCommand();
				Object valueToSet;
				EAttribute feature = (EAttribute) MindmapPackage.eINSTANCE
						.getThreadItem_Body();
				try {
					valueToSet = ParserUtil.parseValue(feature, values[0]);
				} catch (IllegalArgumentException e) {
					return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
				}
				result.append(SetCommand.create(editingDomain, element,
						feature, valueToSet));
				return result;
			}
		});
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				TransactionalEditingDomain editingDomain = TransactionUtil
						.getEditingDomain(getDiagramNode().getDiagram()
								.getElement());
				CompoundCommand cc = new CompoundCommand();
				cc.append(getDomainModelRemoveCommand(editingDomain));
				cc
						.append(new RemoveNotationalElementCommand(
								(View) getDiagramNode().eContainer(),
								getDiagramNode()));
				return new WrappingCommand(editingDomain, cc);
			}

			private org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(
					TransactionalEditingDomain editingDomain) {
				return RemoveCommand.create(editingDomain, getDiagramNode()
						.getElement().eContainer(), MindmapPackage.eINSTANCE
						.getThread_Items(), getDiagramNode().getElement());
			}
		});

	}

	/**
	 * @generated
	 */
	public void performRequest(Request req) {
		if (RequestConstants.REQ_DIRECT_EDIT.equals(req.getType())) {
			performDirectEdit();
			return;
		}
		if (RequestConstants.REQ_OPEN.equals(req.getType())) {
			Command command = getCommand(req);
			if (command != null && command.canExecute()) {
				getViewer().getEditDomain().getCommandStack().execute(command);
			}
			return;
		}
		super.performRequest(req);
	}

	/**
	 * @generated
	 */
	protected DirectEditManager getManager() {
		if (manager == null) {
			manager = new DirectEditManager(this, TextCellEditor.class,
					new CellEditorLocator() {
						public void relocate(CellEditor celleditor) {
							Rectangle rect = getLabel().getTextBounds();
							getLabel().translateToAbsolute(rect);
							ZoomManager zoomManager = (ZoomManager) getViewer()
									.getProperty(ZoomManager.class.toString());
							double zoomLevel = zoomManager == null ? 1.0
									: zoomManager.getZoom();
							if (zoomLevel > 1.0 && getLabel().getFont() != null) {
								FontData[] datas = getLabel().getFont()
										.getFontData();
								for (int i = 0; i < datas.length; i++) {
									datas[i].height *= zoomLevel;
								}
								final Font font = new Font(getLabel().getFont()
										.getDevice(), datas);
								celleditor.getControl().setFont(font);
								celleditor.getControl().addDisposeListener(
										new DisposeListener() {
											public void widgetDisposed(
													DisposeEvent e) {
												font.dispose();
											}
										});
							}
							int avr = FigureUtilities.getFontMetrics(
									celleditor.getControl().getFont())
									.getAverageCharWidth();
							rect.setSize(new Dimension(celleditor.getControl()
									.computeSize(SWT.DEFAULT, SWT.DEFAULT))
									.expand(avr * 2, 0));
							celleditor.getControl().setBounds(rect.x, rect.y,
									rect.width, rect.height);
						}
					}) {
				protected void initCellEditor() {
					getCellEditor().setValue(getLabelEditText());
				}
			};
		}
		return manager;
	}

	/**
	 * @generated
	 */
	protected void performDirectEdit() {
		getManager().show();
	}

	/**
	 * @generated
	 */
	protected List getModelChildren() {
		return ((View) getModel()).getVisibleChildren();
	}

	/**
	 * @generated
	 */
	protected List getModelSourceConnections() {
		return ((View) getModel()).getSourceEdges();
	}

	/**
	 * @generated
	 */
	protected List getModelTargetConnections() {
		return ((View) getModel()).getTargetEdges();
	}

	/**
	 * @generated
	 */
	protected void refreshVisuals() {
		super.refreshVisuals();
		refreshLabel();
		refreshFont();
		refreshFontColor();
		refreshVisibility();
	}

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
	public static final String VIEW_PATTERN = "{0}";

	/**
	 * @generated
	 */
	public static final String EDIT_PATTERN = "{0}";

	/**
	 * @generated
	 */
	protected String getLabelText() {
		ThreadItem element = (ThreadItem) getDiagramNode().getElement();
		if (element == null) {
			return defaultText;
		}
		String result = buildTextByPattern(element, VIEW_PATTERN);
		if (result == null) {
			return defaultText;
		}
		return result;
	}

	/**
	 * @generated
	 */
	protected String getLabelEditText() {
		ThreadItem element = (ThreadItem) getDiagramNode().getElement();
		if (element == null) {
			return defaultText;
		}
		String result = buildTextByPattern(element, EDIT_PATTERN);
		if (result == null) {
			return defaultText;
		}
		return result;
	}

	/**
	 * @generated
	 */
	public static String buildTextByPattern(ThreadItem element, String pattern) {
		return MessageFormat
				.format(pattern, new Object[] { element.getBody() });
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
			Color currentColor = getLabel().getForegroundColor();
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
	protected Image getLabelIcon() {
		ImageDescriptor imageDescriptor = MindmapDiagramEditorPlugin
				.getInstance().getItemImageDescriptor(
						getDiagramNode().getElement());
		if (imageDescriptor != null) {
			return imageDescriptor.createImage();
		}
		return null;
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
		getDiagramNode().getElement().eAdapters().add(domainModelRefresher);
	}

	/**
	 * @generated
	 */
	public void deactivate() {
		getDiagramNode().getElement().eAdapters().remove(domainModelRefresher);
		super.deactivate();
	}

	/**
	 * @generated
	 */
	private RefreshAdapter domainModelRefresher = new RefreshAdapter(this);

	/**
	 * @generated
	 */
	private HashMap structuralFeatures2Refresher;

	/**
	 * @generated
	 */
	public Refresher getRefresher(EStructuralFeature feature, Notification msg) {
		if (structuralFeatures2Refresher == null) {
			createRefreshers();
		}
		return (Refresher) structuralFeatures2Refresher.get(feature);
	}

	/**
	 * @generated
	 */
	private void createRefreshers() {
		structuralFeatures2Refresher = new HashMap();
		Refresher childrenRefresher = new Refresher() {
			public void refresh() {
				refreshChildren();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_PersistedChildren(), childrenRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_TransientChildren(), childrenRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_Styles(), childrenRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getDrawerStyle_Collapsed(), childrenRefresher);

		Refresher visibilityRefresher = new Refresher() {
			public void refresh() {
				refreshVisibility();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getView_Visible(), visibilityRefresher);
		Refresher labelRefresher = new Refresher() {
			public void refresh() {
				refreshLabel();
			}
		};
		structuralFeatures2Refresher.put(MindmapPackage.eINSTANCE
				.getThreadItem_Body(), labelRefresher);
		Refresher fontRefresher = new Refresher() {
			public void refresh() {
				refreshFont();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_FontHeight(), fontRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_FontName(), fontRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_Bold(), fontRefresher);
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_Italic(), fontRefresher);

		Refresher fontColorRefresher = new Refresher() {
			public void refresh() {
				refreshFontColor();
			}
		};
		structuralFeatures2Refresher.put(NotationPackage.eINSTANCE
				.getFontStyle_FontColor(), fontColorRefresher);
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
	protected IFigure createFigure() {
		Label label = createLabel();
		defaultText = label.getText();
		return label;
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
	public void setLabel(IFigure figure) {
		unregisterVisuals();
		setFigure(figure);
		defaultText = ""; //$NON-NLS-1$
		registerVisuals();
		refreshVisuals();
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
					new ComponentEditPolicy() {
						protected Command createDeleteCommand(
								GroupRequest deleteRequest) {
							TransactionalEditingDomain editingDomain = TransactionUtil
									.getEditingDomain(getDiagramNode()
											.getDiagram().getElement());
							CompoundCommand cc = new CompoundCommand();
							cc
									.append(getDomainModelRemoveCommand(editingDomain));
							cc.append(new RemoveNotationalElementCommand(
									(View) getDiagramNode().eContainer(),
									getDiagramNode()));
							return new WrappingCommand(editingDomain, cc);
						}

						private org.eclipse.emf.common.command.Command getDomainModelRemoveCommand(
								TransactionalEditingDomain editingDomain) {
							return RemoveCommand.create(editingDomain,
									getDiagramNode().getElement().eContainer(),
									MindmapPackage.eINSTANCE.getThread_Items(),
									getDiagramNode().getElement());
						}
					});
			installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
					new DirectEditPolicy() {
						protected void showCurrentEditValue(
								DirectEditRequest request) {
							String value = (String) request.getCellEditor()
									.getValue();
							setWidgetText(value);
						}

						protected Command getDirectEditCommand(
								DirectEditRequest request) {
							String value = (String) request.getCellEditor()
									.getValue();
							if (value == null) {
								//Invalid value is transformed into a null by the validator.
								//XXX: implement validator
								return UnexecutableCommand.INSTANCE;
							}
							final Object[] parseResult;
							try {
								parseResult = new MessageFormat(EDIT_PATTERN)
										.parse(value);
							} catch (IllegalArgumentException e) {
								return UnexecutableCommand.INSTANCE;
							} catch (ParseException e) {
								return UnexecutableCommand.INSTANCE;
							}
							TransactionalEditingDomain editingDomain = TransactionUtil
									.getEditingDomain(getDiagramNode()
											.getDiagram().getElement());
							if (parseResult.length != 1) {
								return UnexecutableCommand.INSTANCE;
							}
							org.eclipse.emf.common.command.Command domainModelCommand = createDomainModelCommand(
									editingDomain, parseResult);
							return new WrappingCommand(editingDomain,
									domainModelCommand);
						}

						org.eclipse.emf.common.command.Command createDomainModelCommand(
								TransactionalEditingDomain editingDomain,
								Object[] values) {
							ThreadItem element = (ThreadItem) getDiagramNode()
									.getElement();
							CompoundCommand result = new CompoundCommand();
							Object valueToSet;
							EAttribute feature = (EAttribute) MindmapPackage.eINSTANCE
									.getThreadItem_Body();
							try {
								valueToSet = ParserUtil.parseValue(feature,
										values[0]);
							} catch (IllegalArgumentException e) {
								return org.eclipse.emf.common.command.UnexecutableCommand.INSTANCE;
							}
							result.append(SetCommand.create(editingDomain,
									element, feature, valueToSet));
							return result;
						}
					});
		}

		/**
		 * @generated
		 */
		private TreeDirectEditManager manager;

		/**
		 * @generated
		 */
		public void performRequest(Request req) {
			if (RequestConstants.REQ_DIRECT_EDIT == req.getType()) {
				performDirectEdit();
			} else {
				super.performRequest(req);
			}
		}

		/**
		 * @generated
		 */
		protected TreeDirectEditManager getManager() {
			if (manager == null) {
				manager = new TreeDirectEditManager(this, TextCellEditor.class,
						new CellEditorLocator() {
							public void relocate(CellEditor celleditor) {
								if (checkTreeItem()) {
									celleditor.getControl().setFont(
											((TreeItem) getWidget()).getFont());
									celleditor.getControl().setBounds(
											((TreeItem) getWidget())
													.getBounds());
								}
							}
						}) {
					protected void initCellEditor() {
						getCellEditor().setValue(getEditText());
					}
				};
			}
			return manager;
		}

		/**
		 * @generated
		 */
		protected void performDirectEdit() {
			getManager().show();
		}

		/**
		 * @generated
		 */
		protected String getEditText() {
			return getLabelEditText();
		}

		/**
		 * @generated
		 */
		public void activate() {
			super.activate();
			getDiagramNode().getElement().eAdapters().add(domainModelRefresher);
		}

		/**
		 * @generated
		 */
		public void deactivate() {
			getDiagramNode().getElement().eAdapters().remove(
					domainModelRefresher);
			super.deactivate();
		}

		/**
		 * @generated
		 */
		private RefreshAdapter domainModelRefresher = new RefreshAdapter(this);

		/**
		 * @generated
		 */
		protected void createRefreshers() {
			super.createRefreshers();
			Refresher labelRefresher = new Refresher() {
				public void refresh() {
					refreshVisuals();
				}
			};
			registerRefresher(MindmapPackage.eINSTANCE.getThreadItem_Body(),
					labelRefresher);
		}

		/**
		 * @generated
		 */
		protected String getText() {
			return getLabelText();
		}

		/**
		 * Since compartments and labels are not selectable edit parts, they are filtered from the overview as well.
		 * @generated
		 */
		protected List getModelChildren() {
			return Collections.EMPTY_LIST;
		}
	}
}

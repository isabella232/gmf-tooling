package diagram.parts

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import common.Common
import diagram.ViewmapAttributesUtilsHelper

class Refresh {

	extension CommonHelper = new CommonHelper
	extension ViewmapAttributesUtilsHelper = new ViewmapAttributesUtilsHelper
	extension Common = new Common
	
	@Inject extension PartCommon

	def refresher(GenCommonBase it) '''
		«updatableEditPartRefresher»
		«refreshMethods»
		«refreshVisuals»
	'''

	def dispatch updatableEditPartRefresher(GenCommonBase it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.update.RefreshersRegistry myRefreshersRegistry;
		
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.gwt.edit.parts.update.IUpdatableEditPart.Refresher getRefresher(org.eclipse.emf.ecore.EStructuralFeature feature, org.eclipse.emf.common.notify.Notification msg) {
			if (myRefreshersRegistry == null) {
				createRefreshers();
			}
			return myRefreshersRegistry.getRefresher(feature, msg);
		}

		«generatedMemberComment»
		private void createRefreshers() {
			myRefreshersRegistry = new org.eclipse.gmf.runtime.gwt.edit.parts.update.RefreshersRegistry();
			«fillRefreshers»
		}
	'''
	
	def dispatch updatableEditPartRefresher(GenLabel it) ''''''
	
	def dispatch fillRefreshers(GenCommonBase it) ''''''
	
	def dispatch fillRefreshers(GenDiagram it) '''
		«children»
	'''
	
	def dispatch fillRefreshers(GenCompartment it) '''
		«children»
		«visibility»
	'''
	
	/*
	 * By default, nodes have FontStyle installed. However, the color part of this style is only used by its child labels.
	 * Otherwise, there is a conflict between the font color and the foreground color.
	 */
	def dispatch fillRefreshers(GenNode it) '''
		«children»
		«visibility»
		«sourceEdges»
		«targetEdges»
		«bounds»
		«font»
		«fillColor»
		«lineColor»
		«shortcutAnnotation»
	'''

	def dispatch fillRefreshers(GenChildLabelNode it) '''
		«visibility»
		«font»
		«fontColor»
	'''
	
	/*
	 * By default, links have FontStyle installed. However, this style is only used by its child labels.
	 */
	def dispatch fillRefreshers(GenLink it) '''
		«children»
		«visibility»
		«sourceEdges»
		«targetEdges»
		«bendpoints»
		«fillColor»
		«lineColor»
	'''
	
	def children(GenCommonBase it) '''
		Refresher childrenRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshChildren();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_PersistedChildren() == msg.getFeature() || 
						org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_TransientChildren() == msg.getFeature() ||
						org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getDrawerStyle_Collapsed() == msg.getFeature()) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getDrawerStyle());
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Visible() == msg.getFeature()) {
					return msg.getNotifier() != «getViewCode»;
				}
				if (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEModelElement_EAnnotations() == msg.getFeature()) {
					return msg.getNotifier() != «getViewCode»;
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_PersistedChildren(), childrenRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_TransientChildren(), childrenRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles(), childrenRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getDrawerStyle_Collapsed(), childrenRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Visible(), childrenRefresher);
		myRefreshersRegistry.add(org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEModelElement_EAnnotations(), childrenRefresher);
	'''
	
	def visibility(GenCommonBase it) '''
		Refresher visibilityRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				« ignoreIfInactive»
				refreshVisibility();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Visible() == msg.getFeature()) {
					return msg.getNotifier() == « getViewCode»;
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Visible(), visibilityRefresher);
	'''
	
	def bendpoints(GenLink it) '''
		Refresher bendpointsRefresher = new Refresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshBendpoints();
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getEdge_Bendpoints(), bendpointsRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRelativeBendpoints_Points(), bendpointsRefresher);
	'''
	
	def bounds(GenCommonBase it) '''
		Refresher boundsRefresher = new Refresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshBounds();
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getNode_LayoutConstraint(), boundsRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Width(), boundsRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getSize_Height(), boundsRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_X(), boundsRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLocation_Y(), boundsRefresher);
	'''
	
	def sourceEdges(GenCommonBase it) '''
		Refresher sourceEdgesRefresher = new Refresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshSourceConnections();
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_SourceEdges(), sourceEdgesRefresher);
	'''
	
	def targetEdges(GenCommonBase it) '''
		Refresher targetEdgesRefresher = new Refresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshTargetConnections();
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_TargetEdges(), targetEdgesRefresher);
	'''
	
	def fillColor(GenCommonBase it) '''
		«IF !viewmap.isFixedBackground()»
		Refresher backgroundColorRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshBackgroundColor();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor() == msg.getFeature()) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor(), backgroundColorRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles(), backgroundColorRefresher);
		«ENDIF»
	'''
	
	def lineColor(GenCommonBase it) '''
		«IF !viewmap.isFixedForeground()»
		Refresher foregroundColorRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshForegroundColor();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor() == msg.getFeature()) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor(), foregroundColorRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles(), foregroundColorRefresher);
		«ENDIF»
	'''
	
	def font(GenCommonBase it) '''
		«IF !viewmap.isFixedFont()»
		Refresher fontRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshFont();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle().getEStructuralFeatures().contains(msg.getFeature())) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontHeight(), fontRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontName(), fontRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_Bold(), fontRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_Italic(), fontRefresher);
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles(), fontRefresher);
		«ENDIF»
	'''
	
	def fontColor(GenCommonBase it) '''
		«IF !viewmap.isFixedFont»
		Refresher fontColorRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshFontColor();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor() == msg.getFeature()) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor(), fontColorRefresher);
		«ENDIF»
	'''
	
	def shortcutAnnotation(GenNode it) '''
		«IF getDiagram().shortcutsProvidedFor.size() > 0»
		Refresher shortcutPropertyRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshShortcutDecoration();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEModelElement_EAnnotations() == msg.getFeature()) {
					java.util.Collection affectedAnnotations = org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.getAffectedValues(msg, org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEAnnotation());
					for (java.util.Iterator it = affectedAnnotations.iterator(); it.hasNext(); ) {
						org.eclipse.emf.ecore.EAnnotation nextAnnotation = (org.eclipse.emf.ecore.EAnnotation) it.next();
						if ("Shortcut".equals(nextAnnotation.getSource())) {
							return true;
						}
					}
				}
				return false;
			}
		};
		myRefreshersRegistry.add(org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEModelElement_EAnnotations(), shortcutPropertyRefresher);
		«ENDIF»
	'''
	
	def labelRefresher(GenCommonBase it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.EditPartRefresher labelRefresher;
		
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.gwt.edit.parts.EditPartRefresher getLabelRefresher() {
			if (labelRefresher == null && getDiagramNode() != null) {
				labelRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.labels.ILabelController.LabelRefresher(this, «getViewCode».getElement());
			}
			return labelRefresher;
		}
	'''
	
	def dispatch refreshMethods(GenCommonBase it) ''''''
	
	def dispatch refreshMethods(GenCompartment it) '''
		«refreshVisibility»
	'''
	
	def dispatch refreshMethods(GenNode it) '''
		«refreshVisibility»
		«refreshBounds»
		«refreshFont»
		«refreshBackgroundColor»
		«refreshForegroundColor»
		«refreshShortcutDecoration»
	'''

	def dispatch refreshMethods(GenChildLabelNode it) '''
		«refreshVisibility»
		«refreshFont»
		«refreshFontColor»
		«refreshLabel»
		«labelRefresher»
	'''

	def dispatch refreshMethods(GenLabel it) '''
		«refreshFont»
		«refreshFontColor»
		«refreshLabel»
		«labelRefresher»
		«externalFontRefresher»
		«externalFontColorRefresher»
	'''
	
	def dispatch refreshMethods(GenLink it) '''
		«refreshVisibility»
		«refreshBendpoints»
		«refreshBackgroundColor»
		«refreshForegroundColor»
	'''

	def externalFontColorRefresher(GenLabel it) '''
		«IF !viewmap.isFixedFont()»
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher fontColorRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshFontColor();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle_FontColor() == msg.getFeature()) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
				}
				return false;
			}
		};
		«ENDIF»
	'''
	
	def externalFontRefresher(GenLabel it) '''
		«IF !viewmap.isFixedFont()»
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher fontRefresher = new org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher() {
			«generatedMemberComment»
			public void refresh() {
				«ignoreIfInactive»
				refreshFont();
			}
			«generatedMemberComment»
			public boolean isAffectingEvent(org.eclipse.emf.common.notify.Notification msg) {
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle().getEStructuralFeatures().contains(msg.getFeature())) {
					return true;
				}
				if (org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Styles() == msg.getFeature()) {
					return org.eclipse.gmf.runtime.gwt.edit.parts.update.UpdaterUtil.affects(msg, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
				}
				return false;
			}
		};
		«ENDIF»
	'''
	
	def refreshVisibility(GenCommonBase it) '''
		«generatedMemberComment»
		protected void refreshVisibility() {
			boolean isVisible = «getViewCode».isVisible();
			boolean wasVisible = getFigure().isVisible();
			if (isVisible == wasVisible) {
				return;
			}
		«IF isSelectable()»
			if (!isVisible && (getSelected() != SELECTED_NONE)) {
				getViewer().deselect(this);
			}
		«ENDIF»
			getFigure().setVisible(isVisible);
			getFigure().revalidate();
		}
	'''
	
	def refreshBendpoints(GenLink it) '''
		«generatedMemberComment»
		protected void refreshBendpoints() {
			org.eclipse.gmf.runtime.notation.RelativeBendpoints bendpoints = (org.eclipse.gmf.runtime.notation.RelativeBendpoints) getDiagramEdge().getBendpoints();
			if (bendpoints == null) {
				getConnectionFigure().setRoutingConstraint(java.util.Collections.EMPTY_LIST);
				return;
			}
			java.util.List modelConstraint = bendpoints.getPoints();
			java.util.List figureConstraint = new java.util.ArrayList();
			for (int i = 0; i < modelConstraint.size(); i++) {
				org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint wbp = (org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint) modelConstraint.get(i);
				org.eclipse.draw2d.RelativeBendpoint rbp = new org.eclipse.draw2d.RelativeBendpoint(getConnectionFigure());
				rbp.setRelativeDimensions(new org.eclipse.draw2d.geometry.Dimension(wbp.getSourceX(), wbp.getSourceY()), new org.eclipse.draw2d.geometry.Dimension(wbp.getTargetX(), wbp.getTargetY()));
				rbp.setWeight((i + 1) / ((float) modelConstraint.size() + 1));
				figureConstraint.add(rbp);
			}
			getConnectionFigure().setRoutingConstraint(figureConstraint);
		}
	'''
	
	def refreshBounds(GenCommonBase it) '''
		«generatedMemberComment»
		protected void refreshBounds() {
			org.eclipse.gmf.runtime.notation.Node node = «getViewCode»;
			if (node.getLayoutConstraint() == null) {
				return;
			}
			assert node.getLayoutConstraint() instanceof org.eclipse.gmf.runtime.notation.Bounds;
			org.eclipse.gmf.runtime.notation.Bounds bounds = (org.eclipse.gmf.runtime.notation.Bounds) node.getLayoutConstraint();
			int x = bounds.getX();
			int y = bounds.getY();
			int width = bounds.getWidth();
			int height = bounds.getHeight();
			if (width < 0) {
				x -= width;
				width = -width;
			}
			if (height < 0) {
				y -= height;
				height = -height;
			}
			« setLayoutConstraint»
		}
	'''
	
	def dispatch setLayoutConstraint(GenCommonBase it) '''
		((org.eclipse.gef.GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), new org.eclipse.draw2d.geometry.Rectangle(x, y, width, height));
	'''
	
	def dispatch setLayoutConstraint(GenChildSideAffixedNode it) '''
		org.eclipse.draw2d.IFigure parentFigure = getFigure().getParent();
		if (parentFigure != null && parentFigure.getLayoutManager() != null) {
			Object constraint = parentFigure.getLayoutManager().getConstraint(getFigure());
			org.eclipse.gmf.runtime.gwt.figures.BorderItemLocator locator;
			if (constraint instanceof org.eclipse.gmf.runtime.gwt.figures.BorderItemLocator) {
				locator = (org.eclipse.gmf.runtime.gwt.figures.BorderItemLocator) constraint;
			} else {
				locator = new org.eclipse.gmf.runtime.gwt.figures.BorderItemLocator(this);
				parentFigure.getLayoutManager().setConstraint(getFigure(), locator);
			}
			locator.setModelConstraint(new org.eclipse.draw2d.geometry.Rectangle(x, y, width, height));
		}
	'''
	
	def refreshFont(GenCommonBase it) '''
		«IF !viewmap.isFixedFont()»
		«generatedMemberComment»
		protected void refreshFont() {
			org.eclipse.gmf.runtime.notation.FontStyle style = (org.eclipse.gmf.runtime.notation.FontStyle) «getStyleHolderCode».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
			org.eclipse.jface.resource.FontDescriptor toDispose = createdFontDescriptor;
			if (style != null) {
				String fontName = style.getFontName();
				if (fontName != null && «getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().isStrictFont()) {
					org.eclipse.swt.graphics.FontData[] matchingDatas = getViewer().getControl().getDisplay().getFontList(fontName, true);
					if (matchingDatas == null || matchingDatas.length == 0) {
						fontName = null;
					}
				}
				int fontHeight = style.getFontHeight();
				if (fontName == null || fontHeight <= 0) {
					org.eclipse.swt.graphics.FontData defaultFont = org.eclipse.jface.preference.PreferenceConverter.getFontData(«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore(), org.eclipse.gmf.runtime.gwt.preferences.IPreferenceConstants.DEFAULT_FONT);
					if (fontName == null) {
						fontName = defaultFont.getName();
					}
					if (fontHeight <= 0) {
						fontHeight = defaultFont.getHeight();
					}
				}
				int fontStyle = org.eclipse.swt.SWT.NORMAL;
				if (style.isBold()) {
					fontStyle |= org.eclipse.swt.SWT.BOLD;
				}
				if (style.isItalic()) {
					fontStyle |= org.eclipse.swt.SWT.ITALIC;
				}
				org.eclipse.swt.graphics.Font currentFont = getFigure().getFont();
				if (currentFont != null) {
					org.eclipse.swt.graphics.FontData currentFontData = currentFont.getFontData()[0];
					if (currentFontData.getName().equals(fontName) && currentFontData.getHeight() == fontHeight && currentFontData.getStyle() == fontStyle) {
						return;
					}
				}
				createdFontDescriptor = org.eclipse.jface.resource.FontDescriptor.createFrom(fontName, fontHeight, fontStyle);
				getFigure().setFont(getViewer().getResourceManager().createFont(createdFontDescriptor));
			} else {
				//revert to the default font
				getFigure().setFont(getViewer().getControl().getFont());
				createdFontDescriptor = null;
			}
			if (toDispose != null) {
				getViewer().getResourceManager().destroyFont(toDispose);
			}
		}

		«generatedMemberComment('The font descriptor (created by {@link #refreshFont()}) currently assigned to the label (unless the default font is assigned).\n' + 
		'Whenever another non-default font is assigned to it, the previous one should be destroyed through the resource manager.')»
		private org.eclipse.jface.resource.FontDescriptor createdFontDescriptor;
		«ENDIF»
	'''
	
	def refreshFontColor(GenCommonBase it) '''
		«IF !viewmap.isFixedFont()»
		«generatedMemberComment»
		protected void refreshFontColor() {
			org.eclipse.gmf.runtime.notation.FontStyle style = (org.eclipse.gmf.runtime.notation.FontStyle)  «getStyleHolderCode».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFontStyle());
			org.eclipse.jface.resource.ColorDescriptor toDispose = createdFontColorDescriptor;
			if (style != null) {
				int fontColor = style.getFontColor();
				int red = fontColor & 0x000000FF;
				int green = (fontColor & 0x0000FF00) >> 8;
				int blue = (fontColor & 0x00FF0000) >> 16;
				org.eclipse.swt.graphics.Color currentColor = getFigure().getForegroundColor();
				if (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {
					return;
				}
				createdFontColorDescriptor = org.eclipse.jface.resource.ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(red, green, blue));
			} else {
				createdFontColorDescriptor = org.eclipse.jface.resource.ColorDescriptor.createFrom(«defaultColor('FONT_COLOR')»);
			}
			getFigure().setForegroundColor(getViewer().getResourceManager().createColor(createdFontColorDescriptor));
			if (toDispose != null) {
				getViewer().getResourceManager().destroyColor(toDispose);
			}
		}

		«generatedMemberComment('The color descriptor (created by {@link #refreshFontColor()}) currently assigned to the label.\n' + 
		'Whenever another color is assigned to it, the previous one should be destroyed through the resource manager.')»
		private org.eclipse.jface.resource.ColorDescriptor createdFontColorDescriptor;
		«ENDIF»
	'''
	
	def refreshForegroundColor(GenCommonBase it) '''
		«IF !viewmap.isFixedForeground()»
		«generatedMemberComment»
		protected void refreshForegroundColor() {
			org.eclipse.gmf.runtime.notation.LineStyle style = (org.eclipse.gmf.runtime.notation.LineStyle)  «getStyleHolderCode».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle());
			org.eclipse.jface.resource.ColorDescriptor toDispose = createdForegroundColorDescriptor;
			if (style != null) {
				int foregroundColor = style.getLineColor();
				int red = foregroundColor & 0x000000FF;
				int green = (foregroundColor & 0x0000FF00) >> 8;
				int blue = (foregroundColor & 0x00FF0000) >> 16;
				org.eclipse.swt.graphics.Color currentColor = getFigure().getForegroundColor();
				if (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {
					return;
				}
				createdForegroundColorDescriptor = org.eclipse.jface.resource.ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(red, green, blue));
			} else {
				createdForegroundColorDescriptor = org.eclipse.jface.resource.ColorDescriptor.createFrom(«defaultColor('LINE_COLOR')»);
			}
			getFigure().setForegroundColor(getViewer().getResourceManager().createColor(createdForegroundColorDescriptor));
			if (toDispose != null) {
				getViewer().getResourceManager().destroyColor(toDispose);
			}
		}
		
		«generatedMemberComment('The color descriptor (created by {@link #refreshForegroundColor()}) currently assigned to the figure.\n' + 
		'Whenever another color is assigned to it, the previous one should be destroyed through the resource manager.')»
		private org.eclipse.jface.resource.ColorDescriptor createdForegroundColorDescriptor;
	«ENDIF»
	'''
	
	def refreshBackgroundColor(GenCommonBase it) '''
		«IF !viewmap.isFixedBackground()»
		«generatedMemberComment»
		protected void refreshBackgroundColor() {
			org.eclipse.gmf.runtime.notation.FillStyle style = (org.eclipse.gmf.runtime.notation.FillStyle)  «getStyleHolderCode».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle());
			org.eclipse.jface.resource.ColorDescriptor toDispose = createdBackgroundColorDescriptor;
			if (style != null) {
				int backgroundColor = style.getFillColor();
				int red = backgroundColor & 0x000000FF;
				int green = (backgroundColor & 0x0000FF00) >> 8;
				int blue = (backgroundColor & 0x00FF0000) >> 16;
				org.eclipse.swt.graphics.Color currentColor = getFigure().getBackgroundColor();
				if (currentColor != null && currentColor.getRed() == red && currentColor.getGreen() == green && currentColor.getBlue() == blue) {
					return;
				}
				createdBackgroundColorDescriptor = org.eclipse.jface.resource.ColorDescriptor.createFrom(new org.eclipse.swt.graphics.RGB(red, green, blue));
			} else {
				createdBackgroundColorDescriptor = org.eclipse.jface.resource.ColorDescriptor.createFrom(«defaultColor('FILL_COLOR')»);
			}
			getFigure().setBackgroundColor(getViewer().getResourceManager().createColor(createdBackgroundColorDescriptor));
			if (toDispose != null) {
				getViewer().getResourceManager().destroyColor(toDispose);
			}
		}
		
		«generatedMemberComment('The color descriptor (created by {@link #refreshBackgroundColor()}) currently assigned to the figure.\n' + 
		'Whenever another color is assigned to it, the previous one should be destroyed through the resource manager.')»
		private org.eclipse.jface.resource.ColorDescriptor createdBackgroundColorDescriptor;
		«ENDIF»
	'''
	
	def refreshLabel(GenCommonBase it) '''
		«generatedMemberComment»
		protected void refreshLabel() {
			getLabel().setText(getLabelText());
			getLabel().setIcon(getLabelIcon());
		}
	'''
	
	def refreshShortcutDecoration(GenNode it) '''
		«generatedMemberComment»
		protected void refreshShortcutDecoration() {
			org.eclipse.gmf.runtime.gwt.edit.parts.decorations.IDecorationManager decorationManager = getDecorationManager();
			if (decorationManager == null) {
				return;
			}
			org.eclipse.draw2d.Label decorationFigure = null;
			org.eclipse.emf.ecore.EAnnotation annotation = «getViewCode».getEAnnotation("Shortcut");
			if (annotation != null) {
				org.eclipse.swt.graphics.Image image = «getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getBundledImage("icons/shortcut.gif");
				decorationFigure = new org.eclipse.draw2d.Label(image);
			}
			decorationManager.installDecoration("Shortcut", decorationFigure);
		}
	'''
	
	def dispatch refreshVisuals(GenCommonBase it) ''''''
	
	def dispatch refreshVisuals(GenCompartment it) '''
		«generatedMemberComment»
		protected void refreshVisuals() {
			super.refreshVisuals();
			refreshVisibility();
		}
	'''
	
	def dispatch refreshVisuals(GenNode it) '''
		«generatedMemberComment»
		protected void refreshVisuals() {
			super.refreshVisuals();
			refreshVisibility();
			refreshBounds();
		«IF !viewmap.isFixedFont()»
			refreshFont();
		«ENDIF»
		«IF !viewmap.isFixedBackground()»
			refreshBackgroundColor();
		«ENDIF»
		«IF !viewmap.isFixedForeground()»
			refreshForegroundColor();
		«ENDIF»
		«IF getDiagram().shortcutsProvidedFor.size() > 0»
			refreshShortcutDecoration();
		«ENDIF»
		}
	'''
	
	def dispatch refreshVisuals(GenChildLabelNode it) '''
		«generatedMemberComment»
		protected void refreshVisuals() {
			super.refreshVisuals();
			refreshVisibility();
			refreshLabel();
		«IF !viewmap.isFixedFont()»
			refreshFont();
			refreshFontColor();
		«ENDIF»
		}
	'''
	
	def dispatch refreshVisuals(GenLabel it) '''
		«generatedMemberComment»
		protected void refreshVisuals() {
			super.refreshVisuals();
			refreshLabel();
		«IF !viewmap.isFixedFont()»
			refreshFont();
			refreshFontColor();
		«ENDIF»
		}
	'''
	
	def dispatch refreshVisuals(GenLink it) '''
		«generatedMemberComment»
		protected void refreshVisuals() {
			super.refreshVisuals();
			refreshVisibility();
			refreshBendpoints();
		«IF !viewmap.isFixedBackground()»
			refreshBackgroundColor();
		«ENDIF»
		«IF !viewmap.isFixedForeground()»
			refreshForegroundColor();
		«ENDIF»
		}
	'''
	
	def externalRefreshers(GenCommonBase it) '''
		«generatedMemberComment»
		private java.util.Collection externalRefreshers = new java.util.ArrayList();

		«generatedMemberComment»
		public java.util.Collection getExternalRefreshers() {
			return externalRefreshers;
		}

		«generatedMemberComment»
		public void addExternalRefresher(org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher externalRefresher) {
			if (externalRefresher != null && !externalRefreshers.contains(externalRefresher)) {
				externalRefreshers.add(externalRefresher);
			}
		}

		«generatedMemberComment»
		public void removeExternalRefresher(org.eclipse.gmf.runtime.gwt.edit.parts.update.IExternallyUpdatableEditPart.ExternalRefresher externalRefresher) {
			externalRefreshers.remove(externalRefresher);
		}
	'''
	
	def dispatch getStyleHolderCode(GenCommonBase it) '''«getViewCode»'''
	
	def dispatch getStyleHolderCode(GenNodeLabel it) '''getUpdatableParent().«node.getViewCode»'''
	
	def dispatch getStyleHolderCode(GenLinkLabel it) '''getUpdatableParent().« link.getViewCode»'''
	
	def ignoreIfInactive(GenCommonBase it) '''
		if (!isActive()) {
			return;
		}
	'''
	
	def defaultColor(GenCommonBase it, String colorConstant)'''org.eclipse.jface.preference.PreferenceConverter.getColor(«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore(), org.eclipse.gmf.runtime.gwt.preferences.IPreferenceConstants.«colorConstant»)'''

}
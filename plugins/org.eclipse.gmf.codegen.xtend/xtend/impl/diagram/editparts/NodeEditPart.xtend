/**
 * Copyright (c) 2006, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package impl.diagram.editparts

import com.google.inject.Inject
import xpt.Common
import xpt.diagram.ViewmapAttributesUtils_qvto
import xpt.Common_qvto
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.ViewmapLayoutType
import xpt.editor.VisualIDRegistry
import org.eclipse.gmf.codegen.gmfgen.Viewmap
import org.eclipse.gmf.codegen.gmfgen.ModeledViewmap
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.gmfgraph.DiagramLabel
import org.eclipse.gmf.gmfgraph.Compartment
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import xpt.providers.ElementTypes
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import xpt.diagram.editpolicies.GraphicalNodeEditPolicy
import xpt.diagram.editpolicies.TextSelectionEditPolicy
import xpt.diagram.editparts.EditPartFactory

@com.google.inject.Singleton class NodeEditPart {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension ViewmapAttributesUtils_qvto;
	@Inject extension xpt.diagram.editparts.Utils_qvto;
	@Inject extension xpt.diagram.Utils_qvto;
	
	@Inject xpt.diagram.editparts.Common xptEditpartsCommon;
	@Inject impl.diagram.editparts.viewmaps.modeledViewmapProducer xptModeledViewmapProducer;
	@Inject TextAware xptTextAware;
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject ElementTypes xptElementTypes;
	@Inject GraphicalNodeEditPolicy graphicalEditPolicy;
	@Inject TextSelectionEditPolicy textSelection;
	@Inject EditPartFactory xptEditPartFactory;
	
	def className(GenNode it) '''«editPartClassName»'''

	def packageName(GenNode it) '''«getDiagram().editPartsPackageName»'''
	
	def dispatch extendsListContents(GenNode it) '''
	«IF hasBorderItems(it)»org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart«ELSE»org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart«ENDIF»
	'''

	def dispatch extendsListContents(GenChildSideAffixedNode it) '''
	«IF hasBorderItems(it)»org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart«ELSE»org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart«ENDIF»
	'''

	def constructor(GenNode it) '''
		«generatedMemberComment»
		public «className(it)»(org.eclipse.gmf.runtime.notation.View view) {
			super(view);
		}
	'''

	def createDefaultEditPoliciesBody(GenNode it) '''
		«installCreationRolePolicy(it)»
		super.createDefaultEditPolicies();
		«installPrimaryDragEditPolicy(it)»
		«xptEditpartsCommon.installSemanticEditPolicy(it)»
		«installGraphicalNodeEditPolicy(it)»
		«IF !childNodes.empty»
			installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.DRAG_DROP_ROLE, new org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy());
		«ENDIF»
		«xptEditpartsCommon.installCanonicalEditPolicy(it)»
		installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		«xptEditpartsCommon.behaviour(it)»
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	'''
	
	def installGraphicalNodeEditPolicy(GenNode it) '''
		«IF needsGraphicalNodeEditPolicy(it)»
			installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE, new «graphicalEditPolicy.qualifiedClassName(it)»());
		«ENDIF»
	'''

	def installCreationRolePolicy(GenNode it) '''
	«IF !childNodes.empty || hasChildrenInListCompartments(it)»
		«xptEditpartsCommon.installCreationEditPolicy(it)»
	«ENDIF»
	'''

	def dispatch installPrimaryDragEditPolicy(GenNode it) ''''''

	def dispatch installPrimaryDragEditPolicy(GenChildSideAffixedNode it) '''
		installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
	'''

	def createLayoutEditPolicy(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.editpolicies.LayoutEditPolicy createLayoutEditPolicy() {
			«createLayoutEditPolicyBody»
		}
	'''

	def createLayoutEditPolicyBody(GenNode it) '''
		«IF ViewmapLayoutType::XY_LAYOUT_LITERAL == getLayoutType()»
			«createLayoutEditPolicyBody_XY_LAYOUT(it)»
		«ELSEIF ViewmapLayoutType::TOOLBAR_LAYOUT_LITERAL == getLayoutType()»
			«extraLineBreak»
			«createLayoutEditPolicyBody_TOOLBAR_LAYOUT(it)»
		«ELSEIF ViewmapLayoutType::FLOW_LAYOUT_LITERAL == getLayoutType()»
			«extraLineBreak»
			«createLayoutEditPolicyBody_FLOW_LAYOUT(it)»
		«ELSE»
			«createLayoutEditPolicyBody_DEFAULT(it)»
		«ENDIF»
	'''
	
	def createLayoutEditPolicyBody_XY_LAYOUT(GenNode it) '''
			org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				«borderItemSelectionEditPolicy(it)»
				org.eclipse.gef.EditPolicy result = super.createChildEditPolicy(child);
				if (result == null) {
					return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy();
				}
				return result;
			}
		};
		return lep;
	'''	
	
	def createLayoutEditPolicyBody_TOOLBAR_LAYOUT(GenNode it) '''
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				«borderItemSelectionEditPolicy(it)»
				if (child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE) == null) {
					if (child instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart) {
						return new «textSelection.qualifiedClassName(getDiagram())»();
					}
				}
				return super.createChildEditPolicy(child);
			}
		};
		return lep;
	'''
	
	def createLayoutEditPolicyBody_FLOW_LAYOUT(GenNode it) '''
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.FlowLayoutEditPolicy() {
			«IF hasBorderItems(it)»
		«extraLineBreak»
			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				«borderItemSelectionEditPolicy()»
				return super.createChildEditPolicy(child);
			}
			«ENDIF»

			protected org.eclipse.gef.commands.Command createAddCommand(org.eclipse.gef.EditPart child, org.eclipse.gef.EditPart after) {
				return null;
			}

			protected org.eclipse.gef.commands.Command createMoveChildCommand(org.eclipse.gef.EditPart child, org.eclipse.gef.EditPart after) {
				return null;
			}

			protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
				return null;
			}
		};
		return lep;
	'''
	def createLayoutEditPolicyBody_DEFAULT(GenNode it) '''
		org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy lep = new org.eclipse.gmf.runtime.diagram.ui.editpolicies.LayoutEditPolicy() {

			protected org.eclipse.gef.EditPolicy createChildEditPolicy(org.eclipse.gef.EditPart child) {
				«borderItemSelectionEditPolicy(it)»
				org.eclipse.gef.EditPolicy result = child.getEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new org.eclipse.gef.editpolicies.NonResizableEditPolicy();
				}
				return result;
			}

			protected org.eclipse.gef.commands.Command getMoveChildrenCommand(org.eclipse.gef.Request request) {
				return null;
			}

			protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
				return null;
			}
		};
		return lep;
	'''

	def borderItemSelectionEditPolicy(GenNode it) '''
	«IF hasBorderItems(it)»
	org.eclipse.gmf.runtime.notation.View childView = (org.eclipse.gmf.runtime.notation.View) child.getModel();
	switch («xptVisualIDRegistry.getVisualIDMethodCall(it.diagram)»(childView)) {
	«IF !getExternalLabels(it).empty»
	«FOR nextLabel : getExternalLabels(it)»
		«xptVisualIDRegistry.caseVisualID(nextLabel)»
	«ENDFOR»
		return «borderItemSelectionEP(it)»;
	«ENDIF»
	«IF !getSideAffixedChildren(it).empty»
	«FOR nextBorderItem : getSideAffixedChildren(it)»
		«xptVisualIDRegistry.caseVisualID(nextBorderItem)»
	«ENDFOR»
		return new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy();
	«ENDIF»
	}
	«ENDIF»
	'''

	def borderItemSelectionEP(GenNode it) '''
	new org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy() {
	
		protected java.util.List createSelectionHandles() {
			org.eclipse.gef.handles.MoveHandle mh = new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());
			mh.setBorder(null);
			return java.util.Collections.singletonList(mh);
		}
	}
	'''

	/** 
	 * FIXME: 
	 * 1. single generation of createNodeShape(), with inner body filled by polymorphic initPrimaryShape, same as in Lite RT
	 * 2. getPrimaryShape() for SnippetViewmap. Other templates use it regardless of Viewmap kind, perhaps need to add className to SnippetViewmap (with IFigure being default?)
	 * 3. Common (single and shared with Lite RT) condition when to force useLocalConstraints. Lite checks for compartments isEmpty, shouldn't we do the same?
	*/
	def dispatch createNodeShape(Viewmap it, GenNode node) '''
		«ERROR('Unknown viewmap: ' + it + " for node: " + node)»
	'''

	def dispatch createNodeShape(ModeledViewmap it, GenNode node) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createNodeShape() {
			return primaryShape = new «modeledViewmapFigureFQN(it)»()«forceUseLocalCoordinatesAnonymousClassBody(node)»;
		}
		
		«generatedMemberComment»
		public «modeledViewmapFigureFQN(it)» getPrimaryShape() {
			return («modeledViewmapFigureFQN(it)») primaryShape;
		}
'''

	def modeledViewmapFigureFQN(ModeledViewmap it) '''«xptModeledViewmapProducer.viewmapFigureFQN(it)»'''

	def dispatch createNodeShape(FigureViewmap it, GenNode node) {
		var fqn = if (it.figureQualifiedClassName == null) 'org.eclipse.draw2d.RectangleFigure' else figureQualifiedClassName;
		'''
			«generatedMemberComment»
			protected org.eclipse.draw2d.IFigure createNodeShape() {
				return primaryShape = new «fqn»()«forceUseLocalCoordinatesAnonymousClassBody(node)»;
			}
			
			«getPrimaryShapeMethod(fqn)»
		'''
	}

	def dispatch createNodeShape(SnippetViewmap it, GenNode node) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createNodeShape() {
			return «body»;
		}
	'''

	def dispatch createNodeShape(InnerClassViewmap it, GenNode node) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createNodeShape() {
			return primaryShape = new «className»()«forceUseLocalCoordinatesAnonymousClassBody(node)»;
		}
		
		«getPrimaryShapeMethod(className)»
	'''
	
	def forceUseLocalCoordinatesAnonymousClassBody(GenNode node) '''
		«IF !node.childNodes.empty && node.layoutType == ViewmapLayoutType::XY_LAYOUT_LITERAL»
		{
			protected boolean useLocalCoordinates() {
				return true;
			}
		}
		«ENDIF»
	'''

	def getPrimaryShapeMethod(String fqn) '''
		«generatedMemberComment(fqn)»
		public «fqn» getPrimaryShape() {
			return («fqn») primaryShape;
		}
	'''

	def addFixedChild(GenNode it) '''
	«generatedMemberComment»
	protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {
	«FOR label : getInnerFixedLabels(it)»
		«var childViewmap = label.viewmap as ParentAssignedViewmap»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(label)») {
			((«xptEditPartFactory.getEditPartQualifiedClassName(label)») childEditPart).«xptTextAware.labelSetterName(childViewmap)»(getPrimaryShape().«childViewmap.getterName»());
			return true;
		}
	«ENDFOR»
	«FOR label : getInnerFixedLabelsWithModeledViewmaps(it)»
		«var childViewmap = label.viewmap as ModeledViewmap»
		«var getterName = (childViewmap.figureModel as DiagramLabel).accessor.accessor»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(label)») {
			((«xptEditPartFactory.getEditPartQualifiedClassName(label)») childEditPart).«xptTextAware.labelSetterName(childViewmap)»(getPrimaryShape().«getterName»());
			return true;
		}
	«ENDFOR»
	«FOR compartment : getPinnedCompartments(it)»
		«var childViewmap = compartment.viewmap as ParentAssignedViewmap»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(compartment)») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«childViewmap.getterName»();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((«xptEditPartFactory.getEditPartQualifiedClassName(compartment)») childEditPart).getFigure());
			return true;
		}	
	«ENDFOR»
	«FOR compartment : getPinnedCompartmentsWithModeledViewmaps(it)»
		«var childViewmap = compartment.viewmap as ModeledViewmap»
		«var getterName = (childViewmap.figureModel as Compartment).accessor.accessor»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(compartment)») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«getterName»();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((«xptEditPartFactory.getEditPartQualifiedClassName(compartment)») childEditPart).getFigure());
			return true;
		}	
	«ENDFOR»
	«FOR child : getSideAffixedChildren(it)»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(child)») {
			org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator locator = new org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator(getMainFigure(), org.eclipse.draw2d.PositionConstants.«child.preferredSideName»);
			getBorderedFigure().getBorderItemContainer().add(((«xptEditPartFactory.getEditPartQualifiedClassName(child)») childEditPart).getFigure(), locator);
			return true;
		}
	«ENDFOR»
		return false;
	}
'''

	def removeFixedChild(GenNode it) '''
	«generatedMemberComment»
	protected boolean removeFixedChild(org.eclipse.gef.EditPart childEditPart) {
	«FOR label : getInnerFixedLabels(it)»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(label)») {
			return true;
		}
	«ENDFOR»
	«FOR label : getInnerFixedLabelsWithModeledViewmaps(it)»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(label)») {
			return true;
		}
	«ENDFOR»
	«FOR compartment : getPinnedCompartments(it)»
	«var childViewmap = compartment.viewmap as ParentAssignedViewmap»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(compartment)») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«childViewmap.getterName»();
			pane.remove(((«xptEditPartFactory.getEditPartQualifiedClassName(compartment)») childEditPart).getFigure());
			return true;
		}	
	«ENDFOR»
	«FOR compartment : getPinnedCompartmentsWithModeledViewmaps(it)»
	«var childViewmap = compartment.viewmap as ModeledViewmap»
	«var getterName = (childViewmap.figureModel as Compartment).accessor.accessor»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(compartment)») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«getterName»();
			pane.remove(((«xptEditPartFactory.getEditPartQualifiedClassName(compartment)») childEditPart).getFigure());
			return true;
		}	
	«ENDFOR»
	«FOR child : getSideAffixedChildren(it)»
		if (childEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(child)») {
			getBorderedFigure().getBorderItemContainer().remove(((«xptEditPartFactory.getEditPartQualifiedClassName(child)») childEditPart).getFigure());
			return true;
		}
	«ENDFOR»
		return false;
	}
	'''

	def addChildVisual(GenNode it) '''
		«generatedMemberComment»
		protected void addChildVisual(org.eclipse.gef.EditPart childEditPart, int index) {
			if (addFixedChild(childEditPart)) {
				return;
			}
			super.addChildVisual(childEditPart, -1);
		}
	'''

	def removeChildVisual(GenNode it) '''
		«generatedMemberComment»
		protected void removeChildVisual(org.eclipse.gef.EditPart childEditPart) {
			if (removeFixedChild(childEditPart)){
				return;
			}
			super.removeChildVisual(childEditPart);
		}
	'''

	def getContentPaneFor(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure getContentPaneFor(org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart editPart) {
			«/* it is unclear what we should return for labels here */
			FOR compartment : getPinnedCompartments(it)»
			«var childViewmap = compartment.viewmap as ParentAssignedViewmap»
			if (editPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(compartment)») {
				return getPrimaryShape().«childViewmap.getterName»();
			}	
			«ENDFOR»
			«FOR compartment : getPinnedCompartmentsWithModeledViewmaps(it)»
			«var childViewmap = compartment.viewmap as ModeledViewmap»
			«var getterName = (childViewmap.figureModel as Compartment).accessor.accessor»
			if (editPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(compartment)») {
				return getPrimaryShape().«getterName»();
			}	
		«ENDFOR»
		«IF hasBorderItems(it)»
			if (editPart instanceof org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart) {
				return getBorderedFigure().getBorderItemContainer();
			}
		«ENDIF»
			return getContentPane();
		}
	'''

	def addBorderItem(GenNode it) '''
	«IF !getExternalLabels(it).empty»
		«generatedMemberComment»
		protected void addBorderItem(org.eclipse.draw2d.IFigure borderItemContainer, org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart borderItemEditPart) {
			if («FOR label : getExternalLabels(it) SEPARATOR ' || '»borderItemEditPart instanceof «xptEditPartFactory.getEditPartQualifiedClassName(label)»«ENDFOR») {
				org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator locator = new org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator(getMainFigure(), org.eclipse.draw2d.PositionConstants.SOUTH);
				locator.setBorderItemOffset(new org.eclipse.draw2d.geometry.Dimension(-20, -20));
				borderItemContainer.add(borderItemEditPart.getFigure(), locator);
			} else {
				super.addBorderItem(borderItemContainer, borderItemEditPart);
			}
		}
	«ENDIF»
	'''

	def createNodePlate(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure createNodePlate() {
			org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure result = new org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure(«IF getDiagram().isPixelMapMode()»«defaultSizeWidth(viewmap, 40)», «defaultSizeHeight(viewmap, 40)»«ELSE»getMapMode().DPtoLP(«defaultSizeWidth(viewmap, 40)»), getMapMode().DPtoLP(«defaultSizeHeight(viewmap, 40)»)«ENDIF»);
			«setupNodePlate»
			return result;
		}
	'''

	def dispatch setupNodePlate(GenNode it) ''''''

	def dispatch setupNodePlate(GenChildSideAffixedNode it) '''
	«extraLineBreak»
	//FIXME: workaround for #154536
	result.getBounds().setSize(result.getPreferredSize());
	'''

	def getPrimaryDragEditPolicy(GenNode it) '''
		«var rc = getResizeConstraints(it.viewmap)»
		«IF null != primaryDragEditPolicyQualifiedClassName || null != rc»
		«generatedMemberComment»
		public org.eclipse.gef.EditPolicy getPrimaryDragEditPolicy() {
			«IF null != primaryDragEditPolicyQualifiedClassName»
			return new «primaryDragEditPolicyQualifiedClassName»();
			«ELSE /* rc != null */»
			org.eclipse.gef.EditPolicy result = super.getPrimaryDragEditPolicy();
			if (result instanceof org.eclipse.gef.editpolicies.ResizableEditPolicy) {
				org.eclipse.gef.editpolicies.ResizableEditPolicy ep = (org.eclipse.gef.editpolicies.ResizableEditPolicy) result;
				ep.setResizeDirections(
				«IF !rc.resizeHandleNames.empty»
					«FOR name : rc.resizeHandleNames SEPARATOR ' | '»org.eclipse.draw2d.PositionConstants.«name»«ENDFOR»
				«ELSE»
					org.eclipse.draw2d.PositionConstants.NONE
				«ENDIF»);
			}
			return result;
			«ENDIF»
		}
		«ENDIF»
	'''

	def createFigure(GenNode it) '''
		«generatedMemberComment(
			'Creates figure for this edit part.\n' + 
			'\n' + 
			'Body of this method does not depend on settings in generation model\n' + 
			'so you may safely remove <i>generated</i> tag and modify it.\n'
		)»
		protected org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure create«IF hasBorderItems(it)»Main«ELSE»Node«ENDIF»Figure() {
			org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure figure = createNodePlate();
			figure.setLayoutManager(new org.eclipse.draw2d.StackLayout());
			org.eclipse.draw2d.IFigure shape = createNodeShape();
			figure.add(shape);
			contentPane = setupContentPane(shape);
			return figure;
		}
	'''

	def setupContentPane(GenNode it) '''
	«generatedMemberComment(
		'Default implementation treats passed figure as content pane.\n' + 
		'Respects layout one may have set for generated figure.\n' + 
		'@param nodeShape instance of generated figure class'
	)»
	protected org.eclipse.draw2d.IFigure setupContentPane(org.eclipse.draw2d.IFigure nodeShape) {
		«IF !childNodes.empty || !compartments.empty || labels.exists[l|!l.oclIsKindOf(typeof(GenExternalNodeLabel))]»
			if (nodeShape.getLayoutManager() == null) {
			«IF it.layoutType == ViewmapLayoutType::XY_LAYOUT_LITERAL»
				nodeShape.setLayoutManager(new org.eclipse.draw2d.FreeformLayout() {

					public Object getConstraint(org.eclipse.draw2d.IFigure figure) {
						Object result = constraints.get(figure);
						if (result == null) {
							result = new org.eclipse.draw2d.geometry.Rectangle(0, 0, -1, -1);
						}
						return result;
					}
				});
			«ELSE»
				org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout layout =new org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout();
				layout.setSpacing(«IF diagram.isPixelMapMode()»5«ELSE»getMapMode().DPtoLP(5)«ENDIF»);
				nodeShape.setLayoutManager(layout);
			«ENDIF»
			}
		«ENDIF»
		return nodeShape; // use nodeShape itself as contentPane
	}
	'''

	def getContentPane(GenNode it) '''
		«generatedMemberComment»
		public org.eclipse.draw2d.IFigure getContentPane() {
			if (contentPane != null) {
				return contentPane;
			}
			return super.getContentPane();
		}
	'''

	def setForegroundColor(GenNode it) '''
		«generatedMemberComment»
		protected void setForegroundColor(org.eclipse.swt.graphics.Color color) {
			if (primaryShape != null) {
				primaryShape.setForegroundColor(color);
			}
		}
	'''

	def setBackgroundColor(GenNode it) '''
		«generatedMemberComment»
		protected void setBackgroundColor(org.eclipse.swt.graphics.Color color) {
			if (primaryShape != null) {
				primaryShape.setBackgroundColor(color);
			}
		}
	'''
 
	def setLineWidth(GenNode it) '''
		«generatedMemberComment»
		protected void setLineWidth(int width) {
			if (primaryShape instanceof org.eclipse.draw2d.Shape) {
				((org.eclipse.draw2d.Shape) primaryShape).setLineWidth(«IF getDiagram().isPixelMapMode()»width«ELSE»getMapMode().DPtoLP(width)«ENDIF»);
			}
		}
	'''

	def setLineStyle(GenNode it) '''
		«generatedMemberComment»
		protected void setLineType(int style) {
			if (primaryShape instanceof org.eclipse.draw2d.Shape) {
				((org.eclipse.draw2d.Shape) primaryShape).setLineStyle(style);
			}
		}
	'''

	def getPrimaryChildEditPart(GenNode it) '''
		«IF !labels.empty»
			«generatedMemberComment»
			public org.eclipse.gef.EditPart getPrimaryChildEditPart() {
				return getChildBySemanticHint(«xptVisualIDRegistry.typeMethodCall(labels.head)»);
			}
		«ENDIF»
	'''
	
	def handleNotificationEventBody(GenTopLevelNode it) '''
		if (event.getNotifier() == getModel() && org.eclipse.emf.ecore.EcorePackage.eINSTANCE.getEModelElement_EAnnotations().equals(event.getFeature())) {
			handleMajorSemanticChange();
		} else {
			super.handleNotificationEvent(event);
		}
	'''

	def dispatch innerClassDeclaration(Viewmap it) ''''''

	def dispatch innerClassDeclaration(InnerClassViewmap it) '''«classBody»'''

	def dispatch innerClassDeclaration(ModeledViewmap it) '''
		«xptModeledViewmapProducer.viewmapClassBody(it)»
	'''

	def getTargetEditPartMethod(GenNode it) '''
	«generatedMemberComment»
	public org.eclipse.gef.EditPart getTargetEditPart(org.eclipse.gef.Request request) {
		if (request instanceof org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest) {
			org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter adapter = ((org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest) request).getViewAndElementDescriptor().getCreateElementRequestAdapter();
			org.eclipse.gmf.runtime.emf.type.core.IElementType type = (org.eclipse.gmf.runtime.emf.type.core.IElementType) adapter.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
	«FOR compartment : compartments»
	«IF listCompartmentHasChildren(compartment)»
		«FOR childNode : compartment.childNodes»
			if (type == «xptElementTypes.accessElementType(childNode)») {
				return getChildBySemanticHint(«xptVisualIDRegistry.typeMethodCall(compartment)»);
			}
		«ENDFOR»
	«ENDIF»
	«ENDFOR»
		}
		return super.getTargetEditPart(request);
	}
'''
		
}

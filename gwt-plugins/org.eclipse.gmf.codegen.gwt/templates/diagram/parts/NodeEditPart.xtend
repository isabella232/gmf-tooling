package diagram.parts

import com.google.inject.Inject
import common.EditPartTemplate
import diagram.Helper
import diagram.ViewmapAttributesUtilsHelper
import diagram.policies.ComponentEditPolicy
import diagram.policies.LayoutEditPolicy
import diagram.policies.SideAffixedLayoutEditPolicy
import org.eclipse.gmf.codegen.gmfgen.FigureViewmap
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.InnerClassViewmap
import org.eclipse.gmf.codegen.gmfgen.ParentAssignedViewmap
import org.eclipse.gmf.codegen.gmfgen.ResizeConstraints
import org.eclipse.gmf.codegen.gmfgen.SnippetViewmap
import org.eclipse.gmf.codegen.gmfgen.Viewmap

class NodeEditPart extends EditPartTemplate<GenNode> {

	extension Helper = new Helper
	extension CommonHelper = new CommonHelper
	extension NodeEditPartHelper = new NodeEditPartHelper
	extension ViewmapAttributesUtilsHelper = new ViewmapAttributesUtilsHelper

	@Inject extension Requests
	@Inject extension ComponentEditPolicy componentEditPolicy
	@Inject extension LayoutEditPolicy layoutEditPolicy
	@Inject extension SideAffixedLayoutEditPolicy sideAffixedLayoutEditPolicy
	@Inject extension Decorations
	@Inject NotationModelRefresher notationModelRefresher
//	@Inject LinkNotationModelRefresher linkNotationModelRefresher

    override body(GenNode it) '''
		«visualIDConstant»
		«primaryShapeAttribute»
		«clientFactoryAttribute»
		«ctors»
		«createEditPolicies»
		«getPrimaryDragEditPolicy»
		«getDragTracker»
		«createFigure»
		«createDecorationPane»
		«decorationManager»
		«createDecorationManager»
		«IF compartments.size() > 0 && hasDirectChildren»
		«childNodesPane»
		«setupChildNodesPane»
		«ENDIF»
		«createNodeShape»
		«viewmap.primaryShapeQualifiedClassName.getPrimaryShape»
		«setupContentPane»
		«contentPane»
		«declareViewCode»
		«IF getInnerFixedLabels.size() > 0 || (getPinnedCompartments.size() > 0 || getSideAffixedChildren.size() > 0)»
		«addFixedChild»
		«removeFixedChild»
		«ENDIF»
		«getPrimaryLabelEditPart»
		«performRequest»
		«getLabelEditPart»
		«IF getExternalLabels.size() > 0»
		«isExternalLabel»
		«ENDIF»
		«IF getExternalLabels.size() > 0 || getSideAffixedChildren.size() > 0»
		«getExternalLabelsContainer»
		«ENDIF»
		«IF compartments.size() > 0 || getSideAffixedChildren.size() > 0 && hasDirectChildren»
		«isDirectChild»
		«ENDIF»
		«IF getSideAffixedChildren.size() > 0»
		«isSideAffixedChild»
		«ENDIF»
		«IF getExternalLabels.size() > 0 || (compartments.size() > 0 && hasDirectChildren || (getPinnedCompartments.size() > 0 || (getInnerFixedLabels.size() > 0 || getSideAffixedChildren.size() > 0)))»
		«addChildVisual»
		«removeChildVisual»
		«ENDIF»
		«IF getExternalLabels.size() > 0 || getSideAffixedChildren.size() > 0»
		«removeNotify»
		«ENDIF»
		«externalChildPositionTracker»
		«activate»
		«notationModelRefresher.all(it)»
«««		«linkNotationModelRefresher.all(it)»
		«viewmap.viewmap»
		«additions»
    '''

    override supertypes(GenNode it) 
    	'''extends org.eclipse.gmf.runtime.gwt.edit.parts.BaseNodeEditPart'''

	def createEditPolicies(GenNode it) '''
		«generatedMemberComment»
		protected void createEditPolicies() {
			installEditPolicy(org.eclipse.gef.EditPolicy.COMPONENT_ROLE, new «componentEditPolicy.qualifiedClassName(it)»());
			installEditPolicy(org.eclipse.gef.EditPolicy.GRAPHICAL_NODE_ROLE, new «getGraphicalNodeEditPolicyQualifiedClassName()»());
			«IF getPrimaryLabel() != null»
			installEditPolicy(org.eclipse.gef.EditPolicy.DIRECT_EDIT_ROLE, new org.eclipse.gmf.runtime.gwt.edit.policies.DelegatingDirectEditPolicy());
			«ENDIF»
			«IF getDirectChildren().size() > 0»
			installEditPolicy(org.eclipse.gef.EditPolicy.LAYOUT_ROLE, new «layoutEditPolicy.qualifiedClassName(it)»());
			«ENDIF»
			«IF getSideAffixedChildren.size() > 0»
			installEditPolicy(org.eclipse.gmf.runtime.gwt.edit.policies.EditPolicyRoles.SIDE_AFFIXED_LAYOUT_ROLE, new «sideAffixedLayoutEditPolicy.qualifiedClassName(it)»());
			«ENDIF»
			«behaviour(it)»
			installEditPolicy(org.eclipse.gef.EditPolicy.PRIMARY_DRAG_ROLE, getPrimaryDragEditPolicy());
			installEditPolicy(org.eclipse.gef.EditPolicy.SELECTION_FEEDBACK_ROLE, new org.eclipse.gef.editpolicies.SelectionEditPolicy() {
				@Override
				protected void showSelection() {
					clientFactory.getEventBus().fireEvent(new org.eclipse.gmf.runtime.gwt.events.SelectEditPartEvent(«qualifiedClassName».this));
				}
				@Override
				protected void hideSelection() {
					clientFactory.getEventBus().fireEvent(new org.eclipse.gmf.runtime.gwt.events.DeselectEditPartEvent(«qualifiedClassName».this));
				}
			});
		}
	'''
	
	def primaryShapeAttribute(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure primaryShape;
	'''
	
	def installRefreshers(GenNode it) '''
«««		«notationModelRefresher.installClause(it)»
«««		«linkNotationModelRefresher.installClause(it)»
	'''

	def getPrimaryDragEditPolicy(GenNode it) '''

		«generatedMemberComment»
		protected org.eclipse.gef.EditPolicy getPrimaryDragEditPolicy() {
			«IF primaryDragEditPolicyQualifiedClassName != null»
			return new «primaryDragEditPolicyQualifiedClassName»();
			«ELSE»
			«returnPrimaryDragEditPolicy»
			«ENDIF»
		}
	'''
	
	def dispatch returnPrimaryDragEditPolicy(GenNode it) '''
		org.eclipse.gef.editpolicies.ResizableEditPolicy result = new org.eclipse.gef.editpolicies.ResizableEditPolicy() «contributeSelectionHandles»;
		«setResizeConstraints(viewmap.getResizeConstraints())»
		return result;
	'''

	def dispatch returnPrimaryDragEditPolicy(GenChildSideAffixedNode it) '''
		return new org.eclipse.gmf.runtime.gwt.edit.policies.SideAffixedDragEditPolicy()«contributeSelectionHandles»;
	'''
	
	def contributeSelectionHandles(GenNode it) '''
		«IF compartments.size() + getExternalLabels.size() > 0»
		{
			«generatedMemberComment»
			@SuppressWarnings("unchecked")
			protected java.util.List<org.eclipse.gef.handles.AbstractHandle> createSelectionHandles() {
				java.util.List<org.eclipse.gef.handles.AbstractHandle> result = super.createSelectionHandles();
				for(java.util.Iterator<?> it = getChildren().iterator(); it.hasNext(); ) {
					org.eclipse.gef.EditPart next = (org.eclipse.gef.EditPart) it.next();
					org.eclipse.gmf.runtime.notation.View nextView = (org.eclipse.gmf.runtime.notation.View) next.getModel();
					switch («getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(nextView)) {
					«FOR c: compartments»«c.addSelectionHandles»«ENDFOR»
					«FOR l: getExternalLabels»«l.addSelectionHandles»«ENDFOR»
					}
				}
				return result;
			}
		}«ENDIF»'''
	
	def dispatch getDragTracker(GenNode it) ''''''

	def dispatch getDragTracker(GenChildSideAffixedNode it) '''
		«generatedMemberComment»
		public org.eclipse.gef.DragTracker getDragTracker(org.eclipse.gef.Request request) {
			return new org.eclipse.gef.tools.DragEditPartsTracker(this) {
				protected boolean isMove() {
					return true;
				}
			};
		}
	'''

	def createFigure(GenNode it) '''

		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createFigure() {
			org.eclipse.draw2d.IFigure invisibleRectangle = new org.eclipse.draw2d.Figure();
			invisibleRectangle.setLayoutManager(new org.eclipse.draw2d.StackLayout());
			org.eclipse.draw2d.IFigure shape = createNodeShape();
			invisibleRectangle.add(shape);
			contentPane = setupContentPane(shape);
			«IF compartments.size() > 0 && hasDirectChildren»
			childNodesPane = createChildNodesPane();
			shape.add(childNodesPane);
			«ENDIF»
			org.eclipse.draw2d.IFigure decorationShape = createDecorationPane();
			if (decorationShape != null) {
				myDecorationManager = createDecorationManager(decorationShape);
				invisibleRectangle.add(decorationShape);
			}
			return invisibleRectangle;
		}
	'''
	
	def addSelectionHandles(GenCommonBase it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			result.addAll(((«getEditPartQualifiedClassName()») next).createSelectionHandles());
			break;
	'''
	
	def setResizeConstraints(ResizeConstraints it) '''
		«IF it == null»
		«ELSEIF resizeHandles == 0»
			result.setResizeDirections(org.eclipse.draw2d.PositionConstants.NONE);
		«ELSE»
			result.setResizeDirections(«FOR n: resizeHandleNames SEPARATOR ' | '»«n.resizeHandleName»«ENDFOR»);
		«ENDIF»
	'''

	def resizeHandleName(String it) '''org.eclipse.draw2d.PositionConstants.«it»'''
	
	def childNodesPane(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure childNodesPane;
		
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createChildNodesPane() {
			org.eclipse.draw2d.IFigure result = new org.eclipse.draw2d.RectangleFigure()«IF isXYLayout»«forceUseLocalCoordinates»«ENDIF»;
			setupChildNodesPane(result);
			return result;
		}
	'''

	// FIXME @see Full RT impl...NodeEditPart for refactoring suggestions

	def createNodeShape(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure createNodeShape() {
			«viewmap.initPrimaryShape(it)»
			return primaryShape;
		}
	'''

	def dispatch initPrimaryShape(Viewmap it, GenNode node) ''''Unexpected viewmap type ' + «it»'''
	
	def dispatch initPrimaryShape(FigureViewmap it, GenNode node) '''
		primaryShape = new «primaryShapeQualifiedClassName()»()«IF node.compartments.isEmpty() && node.needsXYLayout()»«forceUseLocalCoordinates»«ENDIF»;
	'''
	
	def dispatch initPrimaryShape(SnippetViewmap it, GenNode node) '''
		primaryShape = «body»;
	'''
	
	def dispatch initPrimaryShape(InnerClassViewmap it, GenNode node) '''
		«primaryShapeQualifiedClassName()» figure = new «primaryShapeQualifiedClassName()»()«IF node.compartments.isEmpty() && node.needsXYLayout()»«forceUseLocalCoordinates»«ENDIF»;
		primaryShape = figure;
	'''
	
	def getPrimaryShape(String it) '''
		«generatedMemberComment»
		public «it» getPrimaryShape() {
			return («it») primaryShape;
		}
	'''

	def setupContentPane(GenNode it) '''
		«generatedMemberComment('Default implementation treats passed figure as content pane.\n' + 
		'Respects layout one may have set for generated figure.\n' + 
		'@param nodeShape instance of generated figure class')»
		protected org.eclipse.draw2d.IFigure setupContentPane(org.eclipse.draw2d.IFigure nodeShape) {
			if (nodeShape.getLayoutManager() == null) {
				«setLayoutManager('nodeShape', compartments.size() == 0 && isXYLayout)»
			}
			return nodeShape; // use nodeShape itself as contentPane
		}
	'''

	def setupChildNodesPane(GenNode it) '''
		«generatedMemberComment»
		protected void setupChildNodesPane(org.eclipse.draw2d.IFigure shape) {
			if (shape.getLayoutManager() == null) {
				«setLayoutManager('shape', isXYLayout)»
			}
		}
	'''

	def setLayoutManager(GenNode it, String shapeVar, Boolean xyLayout) '''
		«IF xyLayout»
		«shapeVar».setLayoutManager(new org.eclipse.draw2d.FreeformLayout() {
			public Object getConstraint(org.eclipse.draw2d.IFigure figure) {
				Object result = constraints.get(figure);
				if (result == null) {
					result = new org.eclipse.draw2d.geometry.Rectangle(0, 0, -1, -1);
				}
				return result;
			}
		});
		«ELSE»
		org.eclipse.draw2d.ToolbarLayout layout = new org.eclipse.draw2d.ToolbarLayout();
		layout.setSpacing(5);
		«shapeVar».setLayoutManager(layout);
		«ENDIF»
	'''
	
	def createDecorationPane(GenNode it) '''
		«generatedMemberComment»
		private org.eclipse.draw2d.IFigure createDecorationPane() {
			return new org.eclipse.draw2d.Layer();
		}
	'''

	def addFixedChild(GenNode it) '''
		«generatedMemberComment»
		protected boolean addFixedChild(org.eclipse.gef.EditPart childEditPart) {
			«FOR l: getInnerFixedLabels»«l.addFixedLabel»«ENDFOR»
			«FOR c: getPinnedCompartments»«c.addFixedCompartment»«ENDFOR»
			return false;
		}
	'''
	
	def addFixedLabel(GenLabel it) '''
		if (childEditPart instanceof «getEditPartQualifiedClassName()») {
			((«getEditPartQualifiedClassName()») childEditPart).«viewmap.setter»(getPrimaryShape().«viewmap.getter»());
			return true;
		}
	'''

	def dispatch getter(Viewmap it) '''«'Unexpected type'»'''
	def dispatch getter(ParentAssignedViewmap it) '''«getterName»'''
	
	def dispatch setter(Viewmap it) '''«'Unexpected type'»'''
	def dispatch setter(ParentAssignedViewmap it) '''«IF setterName == null»setLabel«ELSE»«setterName»«ENDIF»'''

	def addFixedCompartment(GenCompartment it) '''
		if (childEditPart instanceof «getEditPartQualifiedClassName()») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«viewmap.getter»();
			((«getEditPartQualifiedClassName()») childEditPart).setupCompartmentHolder(pane);
			pane.add(((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure());
			return true;
		}	
	'''

	def removeFixedChild(GenNode it) '''
		«generatedMemberComment»
		protected boolean removeFixedChild(org.eclipse.gef.EditPart childEditPart) {
«««		«REM»ignore labels assuming that they never may be removed«ENDREM»
			«FOR c: getPinnedCompartments»«c.removeFixedCompartment»«ENDFOR»
			return false;
		}
	'''

	def removeFixedCompartment(GenCompartment it) '''
		if (childEditPart instanceof «getEditPartQualifiedClassName()») {
			org.eclipse.draw2d.IFigure pane = getPrimaryShape().«viewmap.getter»();
			pane.remove(((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure());
			return true;
		}
	'''

	def isExternalLabel(GenNode it) '''
		«generatedMemberComment»
		public boolean isExternalLabel(org.eclipse.gef.EditPart childEditPart) {
		«FOR l:getExternalLabels»«l.returnInstanceof('childEditPart')»«ENDFOR»
			return false;
		}
	'''

	def isDirectChild(GenNode it) '''
		«generatedMemberComment»
		public boolean isDirectChild(org.eclipse.gef.EditPart childEditPart) {
		«FOR c: getDirectChildren»«c.returnInstanceof('childEditPart')»«ENDFOR»
			return false;
		}
	'''

	def isSideAffixedChild(GenNode it) '''
		«generatedMemberComment»
		public boolean isSideAffixedChild(org.eclipse.gef.EditPart childEditPart) {
			«FOR c: getSideAffixedChildren»«c.returnInstanceof('childEditPart')»«ENDFOR»
			return false;
		}
	'''

	def returnInstanceof(GenCommonBase it, String _var) '''
		if («_var» instanceof «getEditPartQualifiedClassName()») {
			return true;
		}
	'''
	
	def addChildVisual(GenNode it) '''
		«generatedMemberComment»
		protected void addChildVisual(org.eclipse.gef.EditPart childEditPart, int index) {
		«IF getExternalLabels.size() > 0»
			if (isExternalLabel(childEditPart)) {
				org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
				getExternalLabelsContainer().add(childFigure);
				«addPositionTracker»
				return;
			}
		«ENDIF»
		«IF getSideAffixedChildren.size() > 0»
			if (isSideAffixedChild(childEditPart)) {
				org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
				getExternalLabelsContainer().add(childFigure);
				«addPositionTracker»
				return;
			}
		«ENDIF»
		«IF getInnerFixedLabels.size() > 0 || getPinnedCompartments.size() > 0»
			if (addFixedChild(childEditPart)) {
				return;
			}
		«ENDIF»
		«IF compartments.size() > 0 && hasDirectChildren»
			if (isDirectChild(childEditPart)) {
				org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
				childNodesPane.add(childFigure);
				return;
			}
		«ENDIF»
			super.addChildVisual(childEditPart, -1);
		}
	'''
	
	def removeChildVisual(GenNode it) '''
		«generatedMemberComment»
		protected void removeChildVisual(org.eclipse.gef.EditPart childEditPart) {
		«IF getExternalLabels.size() > 0»
				if (isExternalLabel(childEditPart)) {
					org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
					«removePositionTracker»
					getExternalLabelsContainer().remove(childFigure);
					return;
				}
		«ENDIF»
		«IF getSideAffixedChildren.size() > 0»
				if (isSideAffixedChild(childEditPart)) {
					org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
					«removePositionTracker»
					getExternalLabelsContainer().remove(childFigure);
					return;
				}
		«ENDIF»
		«IF getInnerFixedLabels.size() > 0 || getPinnedCompartments.size() > 0»
				if (removeFixedChild(childEditPart)) {
					return;
				}
		«ENDIF»
		«IF compartments.size() > 0 && hasDirectChildren»
				if (isDirectChild(childEditPart)) {
					org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
					childNodesPane.remove(childFigure);
					return;
				}
		«ENDIF»
			super.removeChildVisual(childEditPart);
		}
	'''

	def addPositionTracker(GenNode it) '''
		org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker positionTracker = (org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker) childEditPart.getAdapter(org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker.class);
		if (positionTracker != null) {
			getFigure().addAncestorListener(positionTracker);
		}
	'''

	def removePositionTracker(GenNode it) '''
		org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker positionTracker = (org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker) childEditPart.getAdapter(org.eclipse.gmf.runtime.gwt.figures.ExternalChildPositionTracker.class);
		if (positionTracker != null) {
			getFigure().removeAncestorListener(positionTracker);
		}
	'''

	def getExternalLabelsContainer(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure getExternalLabelsContainer() {
			org.eclipse.gef.editparts.LayerManager root = (org.eclipse.gef.editparts.LayerManager) getRoot();
			return root.getLayer(«getDiagram().getEditPartFactoryQualifiedClassName()».EXTERNAL_NODE_LABELS_LAYER);
		}
	'''

	def removeNotify(GenNode it) '''
		«generatedMemberComment»
		public void removeNotify() {
			for (java.util.Iterator it = getChildren().iterator(); it.hasNext(); ) {
				org.eclipse.gef.EditPart childEditPart = (org.eclipse.gef.EditPart) it.next();
		«IF getExternalLabels.size() > 0»
				if (isExternalLabel(childEditPart)) {
					«removePositionTracker»
					org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
					getExternalLabelsContainer().remove(childFigure);
				}
		«ENDIF»
		«IF getSideAffixedChildren.size() > 0»
				if (isSideAffixedChild(childEditPart)) {
					«removePositionTracker»
					org.eclipse.draw2d.IFigure childFigure = ((org.eclipse.gef.GraphicalEditPart) childEditPart).getFigure();
					getExternalLabelsContainer().remove(childFigure);
				}
		«ENDIF»
			}
			super.removeNotify();
		}
	'''
	
	def connectionAnchors(GenNode it) '''
		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor getSourceConnectionAnchor(org.eclipse.gef.ConnectionEditPart connection) {
			return new org.eclipse.draw2d.ChopboxAnchor(getFigure());
		}

		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor getSourceConnectionAnchor(org.eclipse.gef.Request request) {
			return new org.eclipse.draw2d.ChopboxAnchor(getFigure());
		}

		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor  getTargetConnectionAnchor(org.eclipse.gef.ConnectionEditPart connection) {
			return new org.eclipse.draw2d.ChopboxAnchor(getFigure());
		}

		«generatedMemberComment»
		public org.eclipse.draw2d.ConnectionAnchor  getTargetConnectionAnchor(org.eclipse.gef.Request request) {
			return new org.eclipse.draw2d.ChopboxAnchor(getFigure());
		}
	'''

	def forceUseLocalCoordinates() '''
	{
		«generatedMemberComment»
		protected boolean useLocalCoordinates() {
			return true;
		}
	}
	'''

}

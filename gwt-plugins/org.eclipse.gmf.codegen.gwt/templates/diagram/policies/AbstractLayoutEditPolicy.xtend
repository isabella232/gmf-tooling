package diagram.policies

import com.google.inject.Inject
import commands.AddNodeCommand
import commands.CloneNodeCommand
import commands.CommandCommon
import commands.CreateNodeCommand
import common.EditPolicyTemplate
import diagram.Helper
import org.eclipse.gmf.codegen.gmfgen.GenChildSideAffixedNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenNode

abstract class AbstractLayoutEditPolicy<T extends GenCommonBase> extends EditPolicyTemplate<T> {

	protected extension Helper = new Helper
	
	@Inject protected extension PolicyCommon
	@Inject protected AddNodeCommand addCommand
	@Inject protected CloneNodeCommand cloneCommand
	@Inject protected CommandCommon commandCommon
	@Inject protected CreateNodeCommand createNodeCommand

	def getCreateCommand(GenContainerBase it, Iterable<? extends GenNode> childNodes) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getCreateCommand(org.eclipse.gef.requests.CreateRequest request) {
		«IF null != getDiagram().palette && childNodes.size() > 0»
			if (request instanceof org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx) {
				org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx requestEx = (org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx) request;
				if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(requestEx.getModelID())) {
					return null;
				}

				int[] visualIds = requestEx.getVisualIds();
				final org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
				for(int i = 0; i < visualIds.length; i++) {
					int nextVisualId = visualIds[i];
					switch (nextVisualId) {
						«FOR n: childNodes»«n.getCreateCommandContribution(it)»«ENDFOR»
					}
				}

				org.eclipse.emf.ecore.EObject element = «getDiagramElementCode»;
				org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(element);
				return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, result);
			}
		«ENDIF»
			return null;
		}
	'''
	
	def getCreateCommandContribution(GenNode it, GenContainerBase container) '''
		«IF !sansDomain && !modelFacet.metaClass.ecoreClass.abstract»
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			result.append(new «getDiagram().editCommandsPackageName».«createNodeCommand.commandName(it)»(«container.getViewCode», requestEx«IF container.needsXYLayout», (org.eclipse.draw2d.geometry.Rectangle) getConstraintFor(request)«ENDIF»));
			break;
		«ENDIF»
	'''
	
	def createAddCommand(GenContainerBase it, Iterable<? extends GenNode> childNodes) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command createAddCommand(org.eclipse.gef.EditPart child, Object constraint) {
			if (child.getModel() instanceof org.eclipse.gmf.runtime.notation.Node) {
				org.eclipse.gmf.runtime.notation.Node childNode = (org.eclipse.gmf.runtime.notation.Node) child.getModel();
				String modelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(childNode);

				if («getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(modelID)) {
					int newVisualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getNodeVisualID(«getViewCode», childNode.getElement());
					org.eclipse.emf.common.command.Command command = null;
					switch (newVisualID) {
						«FOR n: childNodes»«n.getAddCommandContribution(it)»«ENDFOR»
					}

					if (command != null) {
						org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(childNode.getDiagram().getElement());
						return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, command);
					}
				}
			}
			return null;
		}
	'''
	
	def getAddCommandContribution(GenNode it, GenContainerBase container) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
		command = new «getDiagram().editCommandsPackageName».«addCommand.commandName(it)»(«container.getViewCode», childNode, newVisualID, «IF container.needsXYLayout»(org.eclipse.draw2d.geometry.Rectangle) constraint«ELSE»null«ENDIF»);
		break;
	'''
	
	def createCloneCommand(GenContainerBase it, Iterable<? extends GenNode> childNodes) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command createCloneCommand(org.eclipse.gef.EditPart child, Object constraint) {
			if (child.getModel() instanceof org.eclipse.gmf.runtime.notation.Node) {
				org.eclipse.gmf.runtime.notation.Node childNode = (org.eclipse.gmf.runtime.notation.Node) child.getModel();
				String modelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(childNode);

				if («getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(modelID)) {
					int newVisualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getNodeVisualID(«getViewCode», childNode.getElement());
					org.eclipse.emf.common.command.Command command = null;
					switch (newVisualID) {
						«FOR n: childNodes»«n.getCloneCommandContribution(it)»«ENDFOR»
					}

					if (command != null) {
						org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(childNode.getDiagram().getElement());
						return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, command);
					}
				}
			}
			return null;
		}
	'''
	
	def getCloneCommandContribution(GenNode it, GenContainerBase container) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			command = new «getDiagram().editCommandsPackageName».«cloneCommand.commandName(it)»(«container.getViewCode», childNode, «IF container.needsXYLayout»(org.eclipse.draw2d.geometry.Rectangle) constraint«ELSE»null«ENDIF»);
			break;
	'''
	
	def createChangeConstraintCommand(GenContainerBase it, Iterable<? extends GenNode> childNodes) ''''''
	
	def createChangeConstraintCommand(GenNode it, Iterable<GenNode> childNodes) '''
		«IF needsXYLayout()»
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command createChangeConstraintCommand(org.eclipse.gef.requests.ChangeBoundsRequest request, org.eclipse.gef.EditPart child, Object constraint) {
		«IF hasDirectChildren»
			if ((«getCastToEditPart»).isDirectChild(child)) {
				return super.createChangeConstraintCommand(request, child, constraint);
			}
		«ENDIF»
			return null;
		}
		«ENDIF»
	'''
	
	def showSizeOnDropFeedback(GenContainerBase it) '''
		«generatedMemberComment»
		protected void showSizeOnDropFeedback(org.eclipse.gef.requests.CreateRequest request) {
			org.eclipse.draw2d.IFigure feedback = getSizeOnDropFeedback(request);
			org.eclipse.draw2d.geometry.Rectangle rect = new org.eclipse.draw2d.geometry.Rectangle(request.getLocation(), request.getSize());
			getLayoutContainer().translateToRelative(rect);
			adjustConstraint(request, rect);
			getLayoutContainer().translateToAbsolute(rect);
			feedback.translateToRelative(rect);
			feedback.setBounds(rect.expand(getCreationFeedbackOffset(request)));
		}
	'''
	
	def adjustConstraint(GenContainerBase it, Iterable<? extends GenNode> childNodes) '''
		«generatedMemberComment»
		protected void adjustConstraint(org.eclipse.gef.requests.CreateRequest request, org.eclipse.draw2d.geometry.Rectangle constraint) {
			if (request instanceof org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx) {
				org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx requestEx = (org.eclipse.gmf.runtime.gwt.requests.CreateRequestEx) request;
				if («getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(requestEx.getModelID())) {
					int[] visualIds = requestEx.getVisualIds();
					boolean adjusted = false;
					for(int i = 0; i < visualIds.length && !adjusted; i++) {
						int nextVisualId = visualIds[i];
						switch (nextVisualId) {
							«FOR n: childNodes»«n.adjustConstraint»«ENDFOR»
						}
					}
				}
			}
		}
	'''
	
	def CharSequence adjustConstraint(GenNode it) '''
		«IF !sansDomain && !modelFacet.metaClass.ecoreClass.abstract»
		case «getEditPartQualifiedClassName()».VISUAL_ID: {
			«commandCommon.adjustConstraint(it)»
			«adjustConstraintLocation»
			adjusted = true;
			break;
		}
		«ENDIF»
	'''
	
	def dispatch CharSequence adjustConstraintLocation(GenNode it) '''
	'''
	
	def dispatch CharSequence adjustConstraintLocation(GenChildSideAffixedNode it) '''
		org.eclipse.gmf.runtime.gwt.figures.SideAffixedFeedbackPositioner elementPositioner = getSideAffixedElementPositionerForRequest(request);
		elementPositioner.setSiblingsParent(getExternalLabelsContainer());
		constraint.setBounds(elementPositioner.getValidLocation(constraint));
	'''
	
	def getExternalLabelsContainer(GenNode it) '''
		«generatedMemberComment»
		protected org.eclipse.draw2d.IFigure getExternalLabelsContainer() {
			org.eclipse.gef.editparts.LayerManager root = (org.eclipse.gef.editparts.LayerManager) getHost().getRoot();
			return root.getLayer(«getDiagram().getEditPartFactoryQualifiedClassName()».EXTERNAL_NODE_LABELS_LAYER);
		}
	'''

	def createChangeSideAffixedConstraintCommand(GenNode it, Iterable<? extends GenNode> childNodes) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command createChangeConstraintCommand(org.eclipse.gef.requests.ChangeBoundsRequest request, org.eclipse.gef.EditPart child, Object constraint) {
			return null;
		}
	'''

}
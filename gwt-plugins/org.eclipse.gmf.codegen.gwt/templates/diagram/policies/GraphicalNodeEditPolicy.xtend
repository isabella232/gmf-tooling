package diagram.policies

import com.google.inject.Inject
import commands.CreateLinkCompleteCommand
import commands.CreateLinkStartCommand
import commands.ReconnectLinkSourceCommand
import commands.ReconnectLinkTargetCommand
import common.EditPolicyTemplate
import diagram.LinkFinder
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenLink

class GraphicalNodeEditPolicy extends EditPolicyTemplate<GenCommonBase> {

	extension LinkFinder = new LinkFinder

	@Inject extension PolicyCommon
	@Inject CreateLinkStartCommand linkStartCommand
	@Inject CreateLinkCompleteCommand linkCompleteCommand
	@Inject ReconnectLinkSourceCommand reconnectSourceCommand
	@Inject ReconnectLinkTargetCommand reconnectTargetCommand

	override body(GenCommonBase it) '''
		«getConnectionCreateCommand»
		«getConnectionCompleteCommand»
		«getReconnectSourceCommand»
		«getReconnectTargetCommand»
		«additions»
	'''

	override editPolicyName(GenCommonBase it) 
		'''«getGraphicalNodeEditPolicyClassName()»'''
		
	override supertypes(GenCommonBase it) 
		'''extends org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy'''

	def getConnectionCreateCommand(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest request) {
			«IF getDiagram().palette != null && outgoingLinks.size() > 0»
			if (request instanceof org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx) {
				org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx requestEx = (org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx) request;
				if (!«diagram.getEditPartQualifiedClassName()».MODEL_ID.equals(requestEx.getModelID())) {
					«notApplicable»
				}

				int[] visualIds = requestEx.getVisualIds();
				final org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
				for (int i = 0; i < visualIds.length; i++) {
						int nextVisualId = visualIds[i];
						switch (nextVisualId) {
						«FOR l: outgoingLinks»
						«l.getConnectionCreateCommandContribution»
						«ENDFOR»
					}
				}

				if (!result.canExecute()) {
					«notApplicable»
				}

				org.eclipse.emf.ecore.EObject element = «getDiagramElementCode»;
				org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(element);
				org.eclipse.gef.commands.Command wrappedResult = new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, result);
				request.setStartCommand(wrappedResult);

				return wrappedResult;
			}
			«ENDIF»
			«notApplicable»
		}
	'''	
	
	def getConnectionCreateCommandContribution(GenLink it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			result.appendIfCanExecute(new «getDiagram().editCommandsPackageName».«linkStartCommand.commandName(it)»(requestEx));
			break;
	'''

	def getConnectionCompleteCommand(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest request) {
			«IF getDiagram().palette != null && incomingLinks.size() > 0»
			if (request instanceof org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx) {
				if (request.getStartCommand() == null || !request.getStartCommand().canExecute()) {
					return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
				}

				org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx requestEx = (org.eclipse.gmf.runtime.gwt.requests.CreateConnectionRequestEx) request;
				if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(requestEx.getModelID())) {
					«notApplicable»
				}

				int[] visualIds = requestEx.getVisualIds();
				final org.eclipse.emf.common.command.CompoundCommand result = new org.eclipse.emf.common.command.CompoundCommand();
				for (int i = 0; i < visualIds.length; i++) {
						int nextVisualId = visualIds[i];
						switch (nextVisualId) {
						«FOR l: incomingLinks»
							«l.getConnectionCompleteCommandContribution»
						«ENDFOR»
					}
				}

				if (result.getCommandList().size() != 1 || !result.canExecute()) {
					//Cannot create several connections at once.
					return org.eclipse.gef.commands.UnexecutableCommand.INSTANCE;
				}

				org.eclipse.emf.ecore.EObject element = «getDiagramElementCode»;
				org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(element);
				org.eclipse.gef.commands.Command wrappedResult = new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, result);

				return request.getStartCommand().chain(wrappedResult);
			}
			«ENDIF»
			«notApplicable»
		}
	'''

	def getConnectionCompleteCommandContribution(GenLink it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			result.appendIfCanExecute(new «getDiagram().editCommandsPackageName».«linkCompleteCommand.commandName(it)»(requestEx));
			break;
	'''

	def getReconnectSourceCommand(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest request) {
			«IF outgoingLinks.size() > 0»
			org.eclipse.gef.ConnectionEditPart connection = request.getConnectionEditPart();
			if (connection.getModel() instanceof org.eclipse.gmf.runtime.notation.Edge == false) {
				«notApplicable»
			}

			org.eclipse.gmf.runtime.notation.Edge edge = (org.eclipse.gmf.runtime.notation.Edge)connection.getModel();
			String modelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(edge);
			if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(modelID)) {
				«notApplicable»
			}

			org.eclipse.emf.common.command.Command result = null;
			int visualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(edge);
			switch (visualID) {
				«FOR l: outgoingLinks»
				«l.getReconnectSourceCommandContribution»
				«ENDFOR»
			}

			if (result == null || !result.canExecute()) {
				«notApplicable»
			}

			org.eclipse.emf.ecore.EObject element = «getDiagramElementCode»;
			org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(element);
			return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, result);
			«ELSE»
			«notApplicable»
			«ENDIF»
		}
	'''

	def getReconnectSourceCommandContribution(GenLink it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			result = new «getDiagram().editCommandsPackageName».«reconnectSourceCommand.commandName(it)»(request);
			break;
	'''

	def getReconnectTargetCommand(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gef.commands.Command getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest request) {
		«IF incomingLinks.size() > 0»
			org.eclipse.gef.ConnectionEditPart connection = request.getConnectionEditPart();
			if (connection.getModel() instanceof org.eclipse.gmf.runtime.notation.Edge == false) {
				«notApplicable»
			}

			org.eclipse.gmf.runtime.notation.Edge edge = (org.eclipse.gmf.runtime.notation.Edge)connection.getModel();
			String modelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(edge);
			if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(modelID)) {
				«notApplicable»
			}

			org.eclipse.emf.common.command.Command result = null;
			int visualID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(edge);
			switch (visualID) {
				«FOR l: incomingLinks»
				«l.getReconnectTargetCommandContribution»
				«ENDFOR»
			}

			if (result == null || !result.canExecute()) {
				«notApplicable»
			}

			org.eclipse.emf.ecore.EObject element = «getDiagramElementCode»;
			org.eclipse.emf.edit.domain.EditingDomain domain = org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain.getEditingDomainFor(element);
			return new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domain, result);
		«ELSE»
			«notApplicable»
		«ENDIF»
		}
	'''

	def getReconnectTargetCommandContribution(GenLink it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
			result = new «getDiagram().editCommandsPackageName».«reconnectTargetCommand.commandName(it)»(request);
			break;
	'''

	/**
	 * Command is not applicable for the given request. Should return either null or 
	 * org.eclipse.gef.commands.UnexecutableCommand.INSTANCE, but the same value everywhere.
	 */
	def notApplicable(GenCommonBase it) '''return null;'''

}


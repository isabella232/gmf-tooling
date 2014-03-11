package org.eclipse.gmf.codegen.gwt.module

import com.google.inject.AbstractModule
import gwt.GWTModule
import commands.AddNodeCommand
import commands.CloneNodeCommand
import commands.CommandCommon
import commands.CreateLinkCompleteCommand
import commands.CreateLinkStartCommand
import commands.CreateNodeCommand
import commands.CreateNotationalElementCommand
import commands.DomainModelRemoveCommand
import commands.ReconnectLinkSourceCommand
import commands.ReconnectLinkTargetCommand
import diagram.VisualIDRegistry
import diagram.parts.ChildNodeEditPart
import diagram.parts.CompartmentEditPart
import diagram.parts.Decorations
import diagram.parts.DiagramEditPart
import diagram.parts.EditPartFactory
import diagram.parts.LabelController
import diagram.parts.LinkLabelEditPart
import diagram.parts.LinkNotationModelRefresher
import diagram.parts.NodeEditPart
import diagram.parts.NodeLabelEditPart
import diagram.parts.NotationModelRefresher
import diagram.parts.PartCommon
import diagram.parts.Refresh
import diagram.parts.Requests
import diagram.policies.ComponentEditPolicy
import diagram.policies.ConnectionEndpointEditPolicy
import diagram.policies.GraphicalNodeEditPolicy
import diagram.policies.LayoutEditPolicy
import diagram.policies.PolicyCommon
import palette.LinkToolEntry
import palette.NodeToolEntry
import palette.PaletteFactory
import viewfactories.ViewFactory

class TemplateModule extends AbstractModule {

	override protected configure() {
		bindGWTModule

		// commands
		bindCommandCommon
		bindAddNodeCommand
		bindCloneNodeCommand
		bindCreateLinkCompleteCommand
		bindCreateLinkStartCommand
		bindCreateNodeCommand
		bindCreateNotationalElementCommand
		bindDomainModelRemoveCommand
		bindReconnectLinkSourceCommand
		bindReconnectLinkTargetCommand

		// diagram
		bindVisualIDRegistry

		// diagram.parts
		bindPartCommon
		bindChildNodeEditPart
		bindDecorations
		bindDiagramEditPart
		bindEditPartFactory
		bindLabelController
		bindLinkLabelEditPart
		bindLinkNotationModelRefresher
		bindNodeEditPart
		bindCompartmentEditPart
		bindNodeLabelEditPart
		bindNotationModelRefresher
		bindRefresh
		bindRequests

		// diagram.policies
		bindComponentEditPolicy
		bindConnectionEndpointEditPolicy
		bindGraphicalNodeEditPolicy
		bindLayoutEditPolicy
		bindPolicyCommon

		// palette
		bindLinkToolEntry
		bindNodeToolEntry
		bindPaletteFactory

		// viewfactories
		bindViewFactory
	}

	def void bindGWTModule() { 
		bind(GWTModule)
	}
	
	def void bindCommandCommon() {
		bind(CommandCommon)
	}
	
	def void bindAddNodeCommand() {
		bind(AddNodeCommand)
	}
	
	def void bindCloneNodeCommand() {
		bind(CloneNodeCommand)
	}
	
	def void bindCreateLinkCompleteCommand() {
		bind(CreateLinkCompleteCommand)
	}
	
	def void bindCreateLinkStartCommand() {
		bind(CreateLinkStartCommand)
	}
	
	def void bindCreateNodeCommand() {
		bind(CreateNodeCommand)
	}
	
	def void bindCreateNotationalElementCommand() {
		bind(CreateNotationalElementCommand)
	}

	def void bindDomainModelRemoveCommand() {
		bind(DomainModelRemoveCommand)
	}

	def void bindReconnectLinkSourceCommand() {
		bind(ReconnectLinkSourceCommand)
	}

	def void bindReconnectLinkTargetCommand() {
		bind(ReconnectLinkTargetCommand)
	}

	def void bindVisualIDRegistry() {
		bind(VisualIDRegistry)
	}

	def void bindPartCommon() {
		bind(PartCommon)
	} 

	def void bindChildNodeEditPart() {
		bind(ChildNodeEditPart)
	}
	
	def void bindDecorations() {
		bind(Decorations)
	}

	def void bindDiagramEditPart() {
		bind(DiagramEditPart)
	}
	
	def void bindEditPartFactory() {
		bind(EditPartFactory)
	}
	
	def void bindLabelController() {
		bind(LabelController)
	}
	
	def void bindLinkLabelEditPart() {
		bind(LinkLabelEditPart)
	}

	def void bindLinkNotationModelRefresher() {
		bind(LinkNotationModelRefresher)
	}
	
	def void bindNodeEditPart() {
		bind(NodeEditPart)
	}
	
	def void bindCompartmentEditPart() {
		bind(CompartmentEditPart)
	}

	def void bindNodeLabelEditPart() {
		bind(NodeLabelEditPart)
	}
	
	def void bindNotationModelRefresher() {
		bind(NotationModelRefresher)
	}

	def void bindRefresh() {
		bind(Refresh)
	}
	
	def void bindRequests() {
		bind(Requests)
	}

	def void bindComponentEditPolicy() {
		bind(ComponentEditPolicy)
	}
	
	def void bindConnectionEndpointEditPolicy() {
		bind(ConnectionEndpointEditPolicy)
	}
	
	def void bindGraphicalNodeEditPolicy() {
		bind(GraphicalNodeEditPolicy)
	}
	
	def void bindLayoutEditPolicy() {
		bind(LayoutEditPolicy)
	}
	
	def void bindPolicyCommon() {
		bind(PolicyCommon)
	}
	
	def void bindLinkToolEntry() {
		bind(LinkToolEntry)
	}
	
	def void bindNodeToolEntry() {
		bind(NodeToolEntry)
	}
	
	def void bindPaletteFactory() {
		bind(PaletteFactory)
	}
	
	def void bindViewFactory() {
		bind(ViewFactory)
	}

}
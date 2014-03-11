package org.eclipse.gmf.codegen.gwt.impl

import com.google.inject.Inject
import gwt.GWTModule
import commands.AddNodeCommand
import commands.CloneNodeCommand
import commands.CreateLinkCompleteCommand
import commands.CreateLinkStartCommand
import commands.CreateNodeCommand
import commands.ReconnectLinkSourceCommand
import commands.ReconnectLinkTargetCommand
import diagram.VisualIDRegistry
import diagram.parts.ChildNodeEditPart
import diagram.parts.CompartmentEditPart
import diagram.parts.DiagramEditPart
import diagram.parts.EditPartFactory
import diagram.parts.LinkEditPart
import diagram.parts.LinkLabelEditPart
import diagram.parts.NodeEditPart
import diagram.parts.NodeLabelEditPart
import diagram.policies.ComponentEditPolicy
import diagram.policies.ConnectionEndpointEditPolicy
import diagram.policies.GraphicalNodeEditPolicy
import diagram.policies.LayoutEditPolicy
import palette.PaletteFactory
import viewfactories.ViewFactory

class TemplateProvider {

	@Inject public VisualIDRegistry visualId
	@Inject public PaletteFactory paletteFactory 

	@Inject public GWTModule moduleGenerator

	@Inject public CreateNodeCommand createNodeCommand
	@Inject public AddNodeCommand addNodeCommand
	@Inject public CloneNodeCommand cloneNodeCommand
	@Inject public CreateLinkStartCommand createLinkStartCommand
    @Inject public CreateLinkCompleteCommand createLinkCompleteCommmand
	@Inject public ReconnectLinkSourceCommand reconnectLinkSourceCommand 
	@Inject public ReconnectLinkTargetCommand reconnectLinkTargetCommand

	@Inject public ComponentEditPolicy componentEditPolicy
	@Inject public ConnectionEndpointEditPolicy connectionEndPointPolicy
	@Inject public LayoutEditPolicy layoutEditPolicy

	@Inject public ViewFactory viewFactory

	@Inject public GraphicalNodeEditPolicy graphicalNodeEditPolicy

	@Inject public EditPartFactory editPartFactory
	@Inject public DiagramEditPart diagramEditPart
	@Inject public NodeEditPart nodeEditPart
	@Inject public CompartmentEditPart compartmentEditPart
	@Inject public ChildNodeEditPart childNodeEditPart
	@Inject public NodeLabelEditPart nodeLabelEditPart
	@Inject public LinkEditPart linkEditPart
	@Inject public LinkLabelEditPart linkLabelEditPart

}
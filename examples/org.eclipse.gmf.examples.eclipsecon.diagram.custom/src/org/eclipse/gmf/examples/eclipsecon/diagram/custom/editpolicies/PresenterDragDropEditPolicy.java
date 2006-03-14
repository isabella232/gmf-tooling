package org.eclipse.gmf.examples.eclipsecon.diagram.custom.editpolicies;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.examples.eclipsecon.diagram.edit.parts.PresenterEditPart;
import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconElementTypes;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.EtoolsProxyCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class PresenterDragDropEditPolicy
    extends DragDropEditPolicy {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
     */
    protected Command getDropCommand(ChangeBoundsRequest request) {
        Command cmd = super.getDropCommand(request);

        if (cmd == null) {
            IElementType elementType = EclipseconElementTypes.TutorialPresenters_3003;
            CompoundCommand cm = new CompoundCommand();

            Iterator elements = request.getEditParts().iterator();
            while (elements.hasNext()) {
                Object obj = elements.next();
                if (obj instanceof PresenterEditPart) {
                    cmd = CreateConnectionViewAndElementRequest
                        .getCreateCommand(elementType, getHost(), (PresenterEditPart) obj,
                            ((IGraphicalEditPart) getHost())
                                .getDiagramPreferencesHint());
                    if (cmd != null)
                        cm.add(cmd);
                }
            }

            if (cm.isEmpty())
                return null;

            return new EtoolsProxyCommand(new CommandProxy(cm.unwrap()));
        }

        return cmd;
    }
}

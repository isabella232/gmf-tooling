package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.gef.Tool;
import org.eclipse.gmf.runtime.diagram.ui.services.palette.PaletteFactory;
import org.eclipse.gmf.runtime.diagram.ui.tools.ConnectionCreationTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.CreationTool;

public class MindmapPaletteFactory extends PaletteFactory.Adapter {

	@Override
	public Tool createTool(String toolId) {
		if (toolId.equals("Topic")) { //$NON-NLS-1$
			return new CreationTool(MindmapElementTypes.TOPIC);
		}
		if (toolId.equals("Subtopic")) { //$NON-NLS-1$
			return new ConnectionCreationTool(MindmapElementTypes.SUBTOPIC);
		}
		return null;
	}

}

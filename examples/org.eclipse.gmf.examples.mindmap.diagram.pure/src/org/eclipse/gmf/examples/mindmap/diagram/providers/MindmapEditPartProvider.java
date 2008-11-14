package org.eclipse.gmf.examples.mindmap.diagram.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.SubtopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.edit.parts.TopicEditPart;
import org.eclipse.gmf.examples.mindmap.diagram.editor.MindmapDiagramEditor;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;

public class MindmapEditPartProvider extends AbstractEditPartProvider {

	private final Map<String, Class<?>> diagramMap = new HashMap<String, Class<?>>();
	{
		diagramMap.put(MindmapDiagramEditor.ID, DiagramEditPart.class);
	}

	private final Map<String, Class<?>> shapeMap = new HashMap<String, Class<?>>();
	{
		shapeMap.put("Topic", TopicEditPart.class);
	}

	private final Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();
	{
		edgeMap.put("Subtopic", SubtopicEditPart.class);
	}

	@Override
	protected Class getDiagramEditPartClass(View view) {
		return diagramMap.get(view.getType());
	}

	@Override
	protected Class getNodeEditPartClass(View view) {
		return shapeMap.get(view.getType());
	}

	@Override
	protected Class getEdgeEditPartClass(View view) {
		return edgeMap.get(view.getType());
	}
}

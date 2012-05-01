package org.eclipse.gmf.examples.mindmap.diagram.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.amalgam.examples.mindmap.MindmapPackage;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.examples.mindmap.diagram.editor.MindmapDiagramEditor;
import org.eclipse.gmf.examples.mindmap.diagram.view.factories.TopicViewFactory;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.ConnectionViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.notation.View;

public class MindmapViewProvider extends AbstractViewProvider {

	private final Map<String, Class<?>> diagramMap = new HashMap<String, Class<?>>();
	{
		diagramMap.put(MindmapDiagramEditor.ID, DiagramViewFactory.class);
	}

	private final Map<String, Class<?>> nodeMap = new HashMap<String, Class<?>>();
	{
		nodeMap.put("Topic", TopicViewFactory.class);
	}
	
	private final Map<String, Class<?>> edgeMap = new HashMap<String, Class<?>>();
	{
		edgeMap.put("Subtopic", ConnectionViewFactory.class);
	}
	
	@Override
	protected Class getDiagramViewClass(IAdaptable semanticAdapter,
			String diagramKind) {
		return diagramMap.get(diagramKind);
	}

	@Override
	protected Class getNodeViewClass(IAdaptable semanticAdapter,
			View containerView, String semanticHint) {
		Class clazz = null;
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = nodeMap.get(semanticHint);
		}
		return clazz;
	}

	@Override
	protected Class getEdgeViewClass(IAdaptable semanticAdapter, 
			View containerView, String semanticHint) {
		Class clazz = null;
		if (semanticHint != null && semanticHint.length() > 0) {
			clazz = edgeMap.get(semanticHint);
		}
		return clazz;
	}
}

package org.eclipse.gmf.examples.mindmap.diagram.providers;

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

public class MindmapElementTypes extends AbstractElementTypeEnumerator {

	public static final IElementType MAP = getElementType("org.eclipse.amalgam.examples.mindmap.diagram.Map"); //$NON-NLS-1$
	public static final IElementType TOPIC = getElementType("org.eclipse.amalgam.examples.mindmap.diagram.Topic"); //$NON-NLS-1$
	public static final IElementType SUBTOPIC = getElementType("org.eclipse.amalgam.examples.mindmap.diagram.Subtopic"); //$NON-NLS-1$

}

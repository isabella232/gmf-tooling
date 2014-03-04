package org.eclipse.gmf.codegen.util;

import java.net.URL;

import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.codegen.jet.JETCompiler;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.BinaryEmitter;
import org.eclipse.gmf.internal.common.codegen.GIFEmitter;
import org.eclipse.gmf.internal.common.codegen.JETGIFEmitterAdapter;


/**
 * @since 2.11
 */
public class BinaryEmitters {
	
	private final URL myLocation;
	
	public BinaryEmitters() {
		myLocation = Platform.getBundle("org.eclipse.gmf.codegen").getEntry("/templates/");
	}
	
	public BinaryEmitter getShortcutImageEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitter("/xpt/editor/shortcut.gif"); //$NON-NLS-1$
	}
	
	public BinaryEmitter getGroupIconEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitter("/xpt/navigator/navigatorGroup.gif"); //$NON-NLS-1$
	}
	
	public BinaryEmitter getDiagramIconEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitterAdapter("/xpt/editor/diagram.gif"); //$NON-NLS-1$
	}
	
	public BinaryEmitter getWizardBannerImageEmitter() throws UnexpectedBehaviourException {
		return newGIFEmitterAdapter("/xpt/editor/wizban.gif"); //$NON-NLS-1$
	}
	
	private BinaryEmitter newGIFEmitter(String relativePath) throws UnexpectedBehaviourException {
		return new GIFEmitter(checkTemplateLocation(relativePath));
	}

	private BinaryEmitter newGIFEmitterAdapter(String relativePath) throws UnexpectedBehaviourException {
		return new JETGIFEmitterAdapter(new org.eclipse.emf.codegen.util.GIFEmitter(checkTemplateLocation(relativePath)));
	}

	private String checkTemplateLocation(String relativePath) throws UnexpectedBehaviourException {
		String[] templatesPath = new String[]{myLocation.toString()};
		String templateLocation = JETCompiler.find(templatesPath, relativePath);
		if (templateLocation == null) {
			throw new UnexpectedBehaviourException("Template " + relativePath + " not found");
		}
		return templateLocation;
	}
}

package org.eclipse.gmf.internal.bridge.wizards.pages;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.internal.common.ui.ExtensibleModelSelectionPage;

/**
 * @author dstadnik
 */
public class DomainModelSelectionPage extends ExtensibleModelSelectionPage implements DomainModelSource {

	private static final String DEE = "diagramElement"; //$NON-NLS-1$

	private EPackage contents;

	public DomainModelSelectionPage(String pageId) {
		super(pageId);
	}

	protected void addExtensions() {
		addExtension(DEE, new DiagramElementSelectorExtension());
	}

	protected void setResource(Resource resource) {
		super.setResource(resource);
		contents = null;
		if (resource != null) {
			List rc = resource.getContents();
			if (rc.size() >= 1 && rc.get(0) instanceof EPackage) {
				contents = (EPackage) rc.get(0);
			}
		}
	}

	public EPackage getContents() {
		return contents;
	}

	public EClass getDiagramElement() {
		return (EClass) ((DiagramElementSelectorExtension) getExtension(DEE)).getModelElement();
	}
}

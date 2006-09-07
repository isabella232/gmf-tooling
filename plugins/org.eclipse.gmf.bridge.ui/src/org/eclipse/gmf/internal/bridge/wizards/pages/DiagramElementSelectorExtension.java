package org.eclipse.gmf.internal.bridge.wizards.pages;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.common.ui.ListElementSelectorExtension;

/**
 * @author dstadnik
 */
public class DiagramElementSelectorExtension extends ListElementSelectorExtension {

	protected String getModelElementName() {
		return "Diagram Element:";
	}

	protected String getModelElementLabel(EObject modelElement) {
		String name = ((EClass) modelElement).getName();
		if (name == null || name.trim().length() == 0) {
			name = "<unnamed>";
		}
		return name;
	}

	protected EClass getModelElementClass() {
		return EcorePackage.eINSTANCE.getEClass();
	}
}

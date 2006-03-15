package org.eclipse.gmf.examples.eclipsecon.diagram.custom.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.diagram.custom.parsers.PresenterParser;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.core.service.IProviderChangeListener;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;


public class ParserProvider
	extends AbstractProvider
	implements IParserProvider {

	public IParser getParser(IAdaptable hint) {
		return PresenterParser.getInstance();
	}

	public void addProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();

			EObject semanticEl = (EObject) hint.getAdapter(EObject.class);
			if (semanticEl.eClass() == EclipseconPackage.Literals.PRESENTER)
				return true;
		}
	
		return false;
	}

	public void removeProviderChangeListener(IProviderChangeListener listener) {
		// TODO Auto-generated method stub

	}

}

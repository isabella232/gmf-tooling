package org.eclipse.gmf.examples.eclipsecon.diagram.custom.parsers;

import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.gmf.examples.eclipsecon.EclipseconPackage;
import org.eclipse.gmf.examples.eclipsecon.diagram.providers.EclipseconStructuralFeaturesParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;

public class PresenterParser
	extends EclipseconStructuralFeaturesParser {

	static protected IParser instance = null;
	static EAttribute[] attributes = { EclipseconPackage.eINSTANCE.getParticipant_Name(),
										EclipseconPackage.eINSTANCE.getPresenter_Phone()};

	/**
	 * Constructor for PresenterParser.
	 */
	protected PresenterParser() {
		super(new ArrayList(Arrays.asList(attributes)));
		setViewPattern("Name: {0}, Phone: {1}");	//$NON-NLS-1$
		setEditPattern("{0} {1}");			//$NON-NLS-1$
	}

	/**
	 * Gets the instance of the parser
	 * @return IParser the single instance of the parser
	 */
	static public IParser getInstance() {
		if (instance == null) {
			instance = new PresenterParser();
		}
		return instance;
	}
}

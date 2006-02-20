package org.eclipse.gmf.common.codegen;

import org.eclipse.osgi.util.NLS;

public class GeneratorBaseMessages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.gmf.codegen.util.messages"; //$NON-NLS-1$

	private GeneratorBaseMessages() {
	}

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, GeneratorBaseMessages.class);
	}

//	public static String start;
//
//	public static String initproject;

	public static String merge;

	public static String interrupted;

	public static String unexpected;

	public static String problems; 
}

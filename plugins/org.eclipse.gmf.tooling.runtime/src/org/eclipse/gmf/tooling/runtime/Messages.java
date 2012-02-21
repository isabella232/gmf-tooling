package org.eclipse.gmf.tooling.runtime;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {

	static {
		NLS.initializeMessages("messages", Messages.class); //$NON-NLS-1$
	}

	private Messages() {
	}

	public static String AbstractParser_UnexpectedValueType;

	public static String AbstractParser_WrongStringConversion;

	public static String AbstractParser_UnknownLiteral;
}

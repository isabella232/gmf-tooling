package org.eclipse.gmf.internal.common.codegen;

import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.formatter.CodeFormatter;

public interface CodeFormatterFactory {

	public final CodeFormatterFactory DEFAULT = new NullFormatterFactory();

	public CodeFormatter createCodeFormatter();

	static class NullFormatterFactory implements CodeFormatterFactory {

		public CodeFormatter createCodeFormatter() {
			return ToolFactory.createCodeFormatter(null);
		}
	}

}

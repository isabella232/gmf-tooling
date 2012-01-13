package org.eclipse.gmf.internal.common.codegen;

import org.eclipse.gmf.common.UnexpectedBehaviourException;

public interface ClassEmitter {

	public TextEmitter getTextEmitter();

	public String getPackageName(Object... input) throws UnexpectedBehaviourException;

	public String getClassName(Object... input) throws UnexpectedBehaviourException;
}

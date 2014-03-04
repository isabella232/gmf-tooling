package org.eclipse.gmf.internal.common.codegen;

import org.eclipse.gmf.common.UnexpectedBehaviourException;



public interface JavaClassEmitter extends TextEmitter {
	
	public String getQualifiedClassName(Object... input)  throws UnexpectedBehaviourException;
	
	public String getQualifiedClassName(String fqnMethodName, Object... input)  throws UnexpectedBehaviourException;
}

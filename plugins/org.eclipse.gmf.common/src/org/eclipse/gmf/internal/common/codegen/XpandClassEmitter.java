package org.eclipse.gmf.internal.common.codegen;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.xpand.ResourceManager;


public class XpandClassEmitter extends XpandTextEmitter implements JavaClassEmitter {

	private final Map<String, Object> myGlobals;
	
	private final String templateName;
	
	public XpandClassEmitter(ResourceManager manager, String templateFQN, String methodToInvoke) {
		this(manager, templateFQN, methodToInvoke, null);
	}

	public XpandClassEmitter(ResourceManager manager, String templateFQN, String methodToInvoke, Map<String, Object> globals) {
		super(manager, templateFQN, methodToInvoke, globals);
		myGlobals = globals;
		templateName = templateFQN;
	}

	public String getQualifiedClassName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("qualifiedClassName", input);
	}

	public String getQualifiedClassName(String fqnMethodName, Object... input) throws UnexpectedBehaviourException {
		return getText(fqnMethodName, input);
	}
	
	private String getText(String method,Object... input) throws UnexpectedBehaviourException {
		try {
			return this.generate(new NullProgressMonitor(),method, input).trim();
		} catch (InvocationTargetException e) {
			throw new UnexpectedBehaviourException("Invocation method exception "+ method + " on template " + getTemplateFQN(), e);
		} catch (InterruptedException e) {
			throw new UnexpectedBehaviourException("Execute method exception "+ method + " on template " + getTemplateFQN(), e);
		}
	}

}

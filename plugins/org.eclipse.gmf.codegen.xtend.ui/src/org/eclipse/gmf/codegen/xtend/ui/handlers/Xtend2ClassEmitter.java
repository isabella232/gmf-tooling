package org.eclipse.gmf.codegen.xtend.ui.handlers;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.JavaClassEmitter;

import com.google.inject.Injector;


public class Xtend2ClassEmitter extends Xtend2Emitter implements JavaClassEmitter {

	public Xtend2ClassEmitter(Injector injector, Class<?> clazz, String methodName) {
		super(injector, clazz, methodName);
	}

	@Override
	public String getQualifiedClassName(Object... input) throws UnexpectedBehaviourException {
		return getQualifiedClassName("qualifiedClassName", input);
	}

	@Override
	public String getQualifiedClassName(String FQNMethodName, Object... input) throws UnexpectedBehaviourException {
		return getText(FQNMethodName, input);
	}

	private String getText(String method, Object... input) throws UnexpectedBehaviourException {
		try {
			return this.generate(new NullProgressMonitor(), method, input);
		} catch (InvocationTargetException e) {
			throw new UnexpectedBehaviourException("Invocation method exception "+ method + " on class " + getTemplateClass().getName(), e);
		} catch (InterruptedException e) {
			throw new UnexpectedBehaviourException("Execute method exception "+ method + " on class " + getTemplateClass().getName(), e);
		}
	}
}

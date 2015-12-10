package org.eclipse.gmf.codegen.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.TextEmitter;

import com.google.inject.Injector;

public class Xtend2Emitter implements TextEmitter {

	private final Class<?> myXtendGenerator;

	private final String myMethodName;

	private final Injector myInjector;

	public Xtend2Emitter(Injector injector, Class<?> clazz, String methodName) {
		myInjector = injector;
		myXtendGenerator = clazz;
		myMethodName = methodName;
	}

	@Override
	public String generate(IProgressMonitor monitor, Object[] arguments) throws InterruptedException, InvocationTargetException, UnexpectedBehaviourException {
		return generate(monitor, myMethodName, arguments);
	}
	
	protected String generate(IProgressMonitor monitor, String methodName, Object[] arguments) throws InterruptedException, InvocationTargetException, UnexpectedBehaviourException {
		if (monitor != null && monitor.isCanceled()) {
			throw new InterruptedException();
		}
		if (arguments.length > 1) {
			List<Object> fixedArgs = new LinkedList<Object>();
			fixedArgs.add(arguments[0]);
			for (int i = 1; i < arguments.length; i++) {
				fixedArgs.add(arguments[i]);
			}
			arguments = fixedArgs.toArray();
		}
		Object generator = instantiateGenerator();
		Method method = getGeneratorMethod(arguments.length, methodName);
		Object result;
		try {
			result = method.invoke(generator, arguments);
		} catch (IllegalArgumentException e) {
			throw new UnexpectedBehaviourException("Invocation failed for: " + this, e);
		} catch (IllegalAccessException e) {
			throw new UnexpectedBehaviourException("Invocation failed for: " + this, e);
		}

		if (result == null) {
			throw new UnexpectedBehaviourException("Xtend generator returned null for " + this);
		}
		return String.valueOf(result);
	}

	private Object instantiateGenerator() throws UnexpectedBehaviourException {
		Object instance = myInjector.getInstance(myXtendGenerator);
		if (instance == null) {
			throw new UnexpectedBehaviourException("Can't instantiate Xtend generator object " + this);
		}
		return instance;
	}

	private Method getGeneratorMethod(int paramsCount, String methodName) throws UnexpectedBehaviourException {
		Method[] allMethods;
		try {
			allMethods = myXtendGenerator.getDeclaredMethods();
		} catch (SecurityException e) {
			throw new UnexpectedBehaviourException("For : " + this, e);
		}
		Method candidate = null;
		for (Method next : allMethods) {
			if (methodName.equals(next.getName()) && next.getParameterTypes().length == paramsCount) {
				if (candidate != null) {
					throw new UnexpectedBehaviourException("More than 1 method found for " + this + ", " + candidate + " vs " + next);
				}
				candidate = next;
			}
		}
		if (candidate == null) {
			throw new UnexpectedBehaviourException("No such method (with params count = " + paramsCount + ") for : " + this);
		}
		return candidate;
	}

	@Override
	public String toString() {
		return "xtend2:[" + myXtendGenerator.getSimpleName() + "#" + myMethodName + "]";
	}

	protected Object extractTarget(Object[] arguments) {
		assert arguments != null && arguments.length > 0;
		return arguments[0];
	}
	
	protected Injector getInjector() {
		return myInjector;
	}
	
	protected Class<?> getTemplateClass() {
		return myXtendGenerator;
	}

}
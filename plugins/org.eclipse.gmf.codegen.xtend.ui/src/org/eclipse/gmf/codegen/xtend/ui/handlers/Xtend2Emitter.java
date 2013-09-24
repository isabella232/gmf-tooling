package org.eclipse.gmf.codegen.xtend.ui.handlers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.common.UnexpectedBehaviourException;
import org.eclipse.gmf.internal.common.codegen.ImportUtil;

import com.google.inject.Injector;

public class Xtend2Emitter implements GeneratorTextEmitter {

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
		if (monitor != null && monitor.isCanceled()) {
			throw new InterruptedException();
		}
		if (arguments.length > 1) {
			List<Object> fixedArgs = new LinkedList<Object>();
			fixedArgs.add(arguments[0]);
			for (int i = 1; i < arguments.length; i++) {
				/**
				 * FIXME: [MG] HACK: the XPT templates just ignores the additional argument, 
				 * so the fact that 5 invocations are still sending ImportUtil had been missed.
				 * However, there are also some more legitimate cases of parameters, e.g for 
				 * PredefinedAction.xtend: def Main(InitDiagramAction it, GenEditorGenerator editorGen)    
				 */
				if (arguments[i] instanceof ImportUtil) {
					System.err.println("Template: " + this + " received additional argument: " + arguments[i] + ", which had been rejected: ");
					continue;
				}
				fixedArgs.add(arguments[i]);
			}
			arguments = fixedArgs.toArray();
		}
		Object generator = instantiateGenerator();
		Method method = getGeneratorMethod(arguments.length);
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

	private Method getGeneratorMethod(int paramsCount) throws UnexpectedBehaviourException {
		Method[] allMethods;
		try {
			allMethods = myXtendGenerator.getDeclaredMethods();
		} catch (SecurityException e) {
			throw new UnexpectedBehaviourException("For : " + this, e);
		}
		Method candidate = null;
		for (Method next : allMethods) {
			if (myMethodName.equals(next.getName()) && next.getParameterTypes().length == paramsCount) {
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

}
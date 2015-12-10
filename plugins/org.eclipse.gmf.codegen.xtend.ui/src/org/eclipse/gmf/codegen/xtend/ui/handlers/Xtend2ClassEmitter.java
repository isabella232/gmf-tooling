package org.eclipse.gmf.codegen.xtend.ui.handlers;

import com.google.inject.Injector;

/**
 * Use {@link org.eclipse.gmf.codegen.util.Xtend2ClassEmitter}
 */
public class Xtend2ClassEmitter extends org.eclipse.gmf.codegen.util.Xtend2ClassEmitter {

	public Xtend2ClassEmitter(Injector injector, Class<?> clazz, String methodName) {
		super(injector, clazz, methodName);
	}
}

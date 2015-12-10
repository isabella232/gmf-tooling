package org.eclipse.gmf.codegen.xtend.ui.handlers;

import com.google.inject.Injector;

public class Xtend2Emitter extends org.eclipse.gmf.codegen.util.Xtend2Emitter {

	public Xtend2Emitter(Injector injector, Class<?> clazz, String methodName) {
		super(injector, clazz, methodName);
	}
}
/*
 * Copyright (c) 2010 Artem Tikhomirov and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (independent) - initial API and implementation
 */
package org.eclipse.gmf.tests;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * The idea is to minimize number of static fields throughout tests; 
 * to keep tests configuration externally to tests themselves;
 * to allow reuse of single setup instance in partial rerun of few tests
 * @author artem
 */
public class Configurator {
	
	private final Map<Class<? extends TestCase>, Class<? extends TestConfiguration>> config;
	private final Map<Class<? extends TestConfiguration>, TestConfiguration> state;
	// tests from single TestCase usually run sequentially, and never mix with other 
	// TestCases, hence enough to cache only one class/set of methods  
	private Class<?> lastSetupLookupTarget;
	private Method[] lastSetupLookupResult;
	
	
	public Configurator() {
		config = new HashMap<Class<? extends TestCase>, Class<? extends TestConfiguration>>();
		state = new HashMap<Class<? extends TestConfiguration>, TestConfiguration>();
	}
	
	public void dispose() {
		config.clear();
		state.clear();
	}

	// configuration instance would get created on demand
	public void register(Class<? extends TestCase> target, Class<? extends TestConfiguration> configClass) {
		config.put(target, configClass);
	}

	// supplied configuration instance would be used. useful when instance initialization takes extra steps
	// and/or should be done in advance (i.e. before running any test)
	public void register(Class<? extends TestCase> target, TestConfiguration configInstance) {
		Class<? extends TestConfiguration> configClass = configInstance.getClass();
		register(target, configClass);
		registerInstance(configClass, configInstance);
	}

	// 
	public void registerInstance(Class<? extends TestConfiguration> configClass, TestConfiguration configInstance) {
		state.put(configClass, configInstance);
	}

	// potentially may provide different configuration per separate test, although we don't use this now
	private TestConfiguration getConfig(Class<? extends TestCase> target, String testName, boolean instantiate) {
		Class<? extends TestConfiguration> configClass = config.get(target);
		if (configClass == null) {
			return null;
		}
		TestConfiguration configInstance = state.get(configClass);
		if (configInstance == null && instantiate) {
			configInstance = newInstance(configClass);
			state.put(configClass, configInstance); // may be null
		}
		return configInstance;
	}
	
	private TestConfiguration newInstance(Class<? extends TestConfiguration> configClass) {
		// in fact, getMethods may lead to troubles if we have subclasses of TestConfiguration with
		// few newInstance methods, and we pick the one from superclass first. To fix, need to iterate over
		// subclasses manually, but too lazy now.
		for (Method m : configClass.getMethods()) {
			if (Modifier.isStatic(m.getModifiers()) && m.getAnnotation(TestConfiguration.FactoryMethod.class) != null) {
				if (configClass.isAssignableFrom(m.getReturnType())) {
					try {
						// null is ok, client's troubles then
						return (TestConfiguration) m.invoke(null);
					} catch (Exception ex) {
						ex.printStackTrace();
						// FALL-THROUGH - fail
					}
				}
				Assert.fail("Bad factory method: " + m);
				assert false; // should not ever get here
			}
		}
		Assert.fail("Can't find factory method in " + configClass);
		return null;
	}

	// instance method just to allow caching
	private Method[] getSetupMethods(Class<?> target) {
		if (lastSetupLookupTarget == target) {
			return lastSetupLookupResult;
		}
		
		lastSetupLookupTarget = target;
		lastSetupLookupResult = findSetupMethods(target);
		return lastSetupLookupResult;
	}

	private static Method[] findSetupMethods(Class<?> target) {
		ArrayList<Method> setupMethods = new ArrayList<Method>(3);
		for (Method m : target.getMethods()) {
			// may use annotation arguments to denote different configure methods (e.g. taking more than one argument)
			if (m.getAnnotation(NeedsSetup.class) != null) {
				Class<?>[] parameterTypes = m.getParameterTypes();
				if (parameterTypes.length == 1 && TestConfiguration.class.isAssignableFrom(parameterTypes[0])) {
					setupMethods.add(m);
				} else {
					Assert.fail("Invalid test configuration method:" + m);
				}
			}
		}
		return setupMethods.toArray(new Method[setupMethods.size()]);
	}

	// calls back to initialize test with appropriate configuration object
	public void prepare(TestCase test) {
		Class<? extends TestCase> testClass = test.getClass();
		Method[] setupMethods = getSetupMethods(testClass);
		if (setupMethods.length == 0) {
			// fail? OTOH, test would fail itself if no expected setup would be supplied.
			// XXX seems reasonable to fail only in case of programming errors (e.g. incorrectly marked method)
			// and do not fail if none matching setups/methods found.
			return;
		}
		TestConfiguration config = getConfig(testClass, test.getName(), true);
		if (config == null) {
			return;
		}
		for (Method m : setupMethods) {
			// invoke all compatible setup methods, ignore those that not good.
			if (m.getParameterTypes()[0].isInstance(config)) {
				try {
					m.invoke(test, config);
				} catch (Exception ex) {
					// wrong configuration method IS programming error
					Assert.fail(ex.toString());
				}
			}
		}
	}

	public static TestSuite feed(Class<? extends TestCase> theClass, TestConfiguration config, String suiteName) {
		TestSuite suite = new TestSuite(theClass, suiteName);
		try {
			for (Method m : findSetupMethods(theClass)) {
				if (m.getParameterTypes()[0].isInstance(config)) {
					for (Enumeration<?> en = suite.tests(); en.hasMoreElements(); ) {
						Object nextTest = en.nextElement();
						m.invoke(nextTest, config);
					}
				}
			}
		} catch (Exception ex) {
			suite.addTest(new ConfigurationFailedCase(theClass.getName() + ": " + ex.getMessage(), ex));
		}
		return suite;
	}
}

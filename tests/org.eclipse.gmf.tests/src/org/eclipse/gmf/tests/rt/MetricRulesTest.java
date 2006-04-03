/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Radek Dvorak (Borland) - initial API and implementation
 */
package org.eclipse.gmf.tests.rt;

import java.lang.reflect.Method;
import java.util.List;

import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer;
import org.eclipse.gmf.mappings.MetricContainer;


public class MetricRulesTest extends RuntimeDiagramTestBase {
	private MetricContainer metricContainer;
	private GenMetricContainer genMetricContainer;
	
	public MetricRulesTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();		
		this.metricContainer = getSetup().getMapModel().getMapping().getMetrics();
		this.genMetricContainer = getGenModel().getGenDiagram().getEditorGen().getMetrics();		
		assertTrue(
			"Setup with at least one metric definition required", //$NON-NLS-1$
			metricContainer != null && !metricContainer.getMetrics().isEmpty());
	}

	public void testMetrics() throws Exception {
		assertTrue(
				"Problem in gen-model transformation detected", //$NON-NLS-1$
				genMetricContainer != null && genMetricContainer.getMetrics().size() == metricContainer.getMetrics().size());
		Class providerClass = null;
		Class viewClass = null;		
		try {
			providerClass = loadGeneratedClass(getGenModel().getGenDiagram().getMetricProviderQualifiedClassName());		
			viewClass = loadGeneratedClass(getGenModel().getGenDiagram().getMetricProviderQualifiedClassName() + "$ResultView"); //$NON-NLS-1$
		} catch (ClassNotFoundException e) {
			fail("Could not find generated metric provider or view"); //$NON-NLS-1$
		}
			
		Method metricAccessor = null;
		try {
			metricAccessor = providerClass.getMethod("getMetrics", null); //$NON-NLS-1$
		} catch (Exception e) {			
			fail("Could not find generated metric definitions accessor"); //$NON-NLS-1$			
		}
		
		List metrics = (List)metricAccessor.invoke(viewClass, null); 
		assertEquals(
			"All metrics from gmfmap must be registered", //$NON-NLS-1$
			metrics.size(), metricContainer.getMetrics().size());	
	}
}

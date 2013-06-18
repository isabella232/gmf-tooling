/**
 * Copyright (c) 2008, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import org.eclipse.emf.codegen.util.CodeGenUtil
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget
import org.eclipse.gmf.codegen.gmfgen.GenDomainElementTarget
import org.eclipse.gmf.codegen.gmfgen.GenMetricContainer
import org.eclipse.gmf.codegen.gmfgen.GenMetricRule
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget
import org.eclipse.gmf.codegen.xtend.annotations.MetaDef
import xpt.Common_qvto

class Metrics_qvto {
	@Inject extension Common_qvto;

	def Iterable<GenMetricRule> getNotationMetrics(GenMetricContainer c) {
		return filterNotationMetricsByTargetType(c, typeof(GenNotationElementTarget));
	}

	def Iterable<GenMetricRule> getDiagramMetrics(GenMetricContainer c) {
		return filterNotationMetricsByTargetType(c, typeof(GenDiagramElementTarget));
	}

	def Iterable<GenMetricRule> getDomainMetrics(GenMetricContainer c) {
		return filterNotationMetricsByTargetType(c, typeof(GenDomainElementTarget))
	}

	protected def Iterable<GenMetricRule> filterNotationMetricsByTargetType(GenMetricContainer c, Class<?> targetType) {
		return c.metrics.filter[m|m.target.oclIsKindOf(targetType)]
	}

	@MetaDef def String calcMethodName(GenMetricRule m) {
		return 'calc' + CodeGenUtil::validJavaIdentifier(m.key).toFirstUpper
	}

}

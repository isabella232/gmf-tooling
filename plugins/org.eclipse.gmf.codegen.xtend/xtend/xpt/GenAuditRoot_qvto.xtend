/**
 * Copyright (c) 2007, 2009, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt

import com.google.inject.Inject
import org.eclipse.emf.codegen.ecore.genmodel.GenPackage
import org.eclipse.gmf.codegen.gmfgen.GenAuditContext
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagramElementTarget
import org.eclipse.gmf.codegen.gmfgen.GenNotationElementTarget

/**
 * FIXME: [MG] Why it is here, in xpt?  
 */
@com.google.inject.Singleton class GenAuditRoot_qvto {
	@Inject extension Common_qvto;

	def Iterable<GenPackage> getAllTargetedModelPackages(GenAuditRoot root) {
		return root.rules.filter[r|r.target != null && r.target.getTargetClass() != null].map[r|
			r.target.targetClass.genPackage].toSet
	}

	def String getQualifiedIdentity(GenAuditContext ctx) {
		return ctx.root.editorGen.plugin.ID + ctx.id
	}

	def boolean hasDiagramElementTargetRule(GenAuditRoot audits) {
		return audits != null && audits.rules.exists[r|r.target.oclIsKindOf(typeof(GenDiagramElementTarget))]
	}

	def boolean hasAnyNotationElementTargetRule(GenAuditRoot audits) {
		return audits != null && audits.rules.exists[r|r.target.oclIsKindOf(typeof(GenNotationElementTarget))]
	}

	def boolean shouldRunValidateOnDiagram(GenAuditRoot audits) {
		return hasDiagramElementTargetRule(audits) || hasAnyNotationElementTargetRule(audits)
	}

	def Iterable<GenCommonBase> getTargetDiagramElements(GenAuditContext ctx) {
		return ctx.ruleTargets.filter(typeof(GenDiagramElementTarget)).map[t|t.element].flatten.toSet
	}

	def Iterable<GenCommonBase> getAllTargetDiagramElements(GenAuditRoot root) {
		return root.clientContexts.map[c|getTargetDiagramElements(c)].flatten.toSet
	}

}

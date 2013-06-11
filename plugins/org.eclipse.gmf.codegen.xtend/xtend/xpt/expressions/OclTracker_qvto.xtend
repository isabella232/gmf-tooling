package xpt.expressions

/**
 * XXX: [MG] move it somewhere? or rename to ImpactAnalyzerSomething (?)
 */ 
class OclTracker_qvto {
	def boolean isForcedImpactAnalyzerKind(String oclExpression) {
		return null != oclExpression && oclExpression.startsWith('--IA');
	}

}

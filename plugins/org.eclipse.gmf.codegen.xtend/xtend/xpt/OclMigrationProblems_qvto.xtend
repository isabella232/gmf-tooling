package xpt

import org.eclipse.emf.ecore.ETypedElement

/**
 * XXX: [MG] not needed anymore, all ocl-related problems are gone with xtend, merge it with GenModelUtils_qvto
 */
@com.google.inject.Singleton class OclMigrationProblems_qvto {
	def boolean isUnbounded(ETypedElement typedElement) {
		return typedElement.upperBound == ETypedElement::UNBOUNDED_MULTIPLICITY
	}

	def isSingleValued(ETypedElement typedElement) {
		return typedElement.upperBound == 1 || typedElement.upperBound == ETypedElement::UNSPECIFIED_MULTIPLICITY
	}

}

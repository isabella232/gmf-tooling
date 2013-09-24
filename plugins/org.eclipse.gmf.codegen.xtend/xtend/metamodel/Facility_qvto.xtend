package metamodel;

import org.eclipse.emf.codegen.ecore.genmodel.GenPackage

class Facility_qvto {
	def getNameToken(GenPackage gp) {
		return gp.prefix
	}

	def fieldName(GenPackage gp) {
		return 'instance' + getNameToken(gp)
	}

}
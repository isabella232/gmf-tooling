package common

class Common {

	def newLine()
	'''
	'''

	def generatedClassComment() {
		generatedClassComment('')
	}

	def generatedClassComment(String comment) {
		doGeneratedComment(comment, '')
	}

	def generatedMemberComment() {
		doGeneratedComment('', '')	
	}

	def generatedMemberComment(String comment) {
		doGeneratedComment(comment, '')
	} 

	def generatedMemberComment(String comment, String comment2) {
		doGeneratedComment(comment, comment2)
	}

	def doGeneratedComment(String comment, String comment2)
	'''

	/**
	«IF comment.length > 0» * «comment.replaceAll('\n', '\n * ')»«ENDIF»
	 * @generated
	«IF comment2.length > 0» * «comment2.replaceAll('\n', '\n * ')»«ENDIF»
	 */
	'''

}
package common

import org.eclipse.emf.ecore.EObject

abstract class BaseClassTemplate<T extends EObject> extends BaseTemplate<T> {

	protected extension Common = new Common

	def abstract String qualifiedClassName(T it)

	override abstract CharSequence generate(T it) 

	def supertypes(T it) ''''''

	def additions(T it) ''''''

	protected abstract def CharSequence body(T it)

}
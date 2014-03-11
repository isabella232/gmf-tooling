package common

import org.eclipse.emf.ecore.EObject

abstract class BaseTemplate<T extends EObject> {

	abstract def CharSequence generate(T it)

}
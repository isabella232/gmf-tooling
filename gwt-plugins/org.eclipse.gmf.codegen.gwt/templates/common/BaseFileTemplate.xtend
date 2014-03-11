package common

import org.eclipse.emf.ecore.EObject

abstract class BaseFileTemplate<T extends EObject> extends BaseTemplate<T> {

	abstract def String filePath(T it)

}
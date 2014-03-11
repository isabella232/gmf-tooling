package common

import com.google.inject.Inject
import diagram.parts.PartCommon
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram

abstract class EditPartTemplate<T extends GenCommonBase> extends BaseClassTemplate<T> {

	@Inject protected extension PartCommon

	override generate(T it) '''
		package «packageName»;
		
		«generatedClassComment»
		public class «editPartName» «supertypes» {

			«body»

		}
	'''

	override qualifiedClassName(T it) { editPartQualifiedClassName }
	
	dispatch def packageName(GenCommonBase it) { diagram.editPartsPackageName }

	dispatch def packageName(GenDiagram it) { editPartsPackageName }

	def editPartName(GenCommonBase it) { editPartClassName }

}

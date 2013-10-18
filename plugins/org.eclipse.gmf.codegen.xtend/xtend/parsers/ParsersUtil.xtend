package parsers

import com.google.inject.Inject
import xpt.Common_qvto
import org.eclipse.gmf.codegen.gmfgen.GenParsers

/**
 * [MG] FIXME: revisit, he same problem as with the QualifiedClassNameProvider
*/ 	
@com.google.inject.Singleton class ParsersUtil {
	
	@Inject extension Common_qvto;
	
	def classNameCustomParser(org.eclipse.gmf.codegen.gmfgen.CustomParser it) '''«lastSegment(it.qualifiedName)»'''

	def packageNameCustomParser(org.eclipse.gmf.codegen.gmfgen.CustomParser it) '''«withoutLastSegment(it.qualifiedName)»'''

	def classNameExpressionLabelParser(org.eclipse.gmf.codegen.gmfgen.ExpressionLabelParser it) '''«lastSegment(it.qualifiedClassName)»'''

	def packageNameExpressionLabelParser(org.eclipse.gmf.codegen.gmfgen.ExpressionLabelParser it) '''«withoutLastSegment(it.qualifiedClassName)»'''

	def classNameGenParsers(GenParsers it) '''«className»'''

	def packageNameGenParsers(GenParsers it) '''«packageName»'''
	
}
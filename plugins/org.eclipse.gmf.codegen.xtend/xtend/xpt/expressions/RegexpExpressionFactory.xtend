/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitry Stadnik (Borland) - initial API and implementation
 * 	  Michael Golubev (Montages) - API extracted to GMF-T runtime, migrated to Xtend2 
 */
package xpt.expressions

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenExpressionInterpreter
import org.eclipse.gmf.codegen.gmfgen.GenLanguage
import xpt.Common
import xpt.QualifiedClassNameProvider

class RegexpExpressionFactory {
	@Inject extension Common;
	@Inject extension QualifiedClassNameProvider;

	@Inject OCLExpressionFactory xptOCLExpressionFactory;

	def className(GenExpressionInterpreter it) '''«it.className»'''

	def packageName(GenExpressionInterpreter it) '''«it.container.expressionsPackageName»'''

	def qualifiedClassName(GenExpressionInterpreter it) '''«packageName(it)».«className(it)»'''

	def fullPath(GenExpressionInterpreter it) '''«qualifiedClassName(it)»'''

	def RegexpExpressionFactory(GenExpressionInterpreter it) '''
		«copyright(it.container.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» {
		
			«xptOCLExpressionFactory.initInterpreterFactory(it)»
		
			«generatedMemberComment»
			public static «getAbstractExpressionQualifiedClassName(it.container.editorGen.diagram)» getExpression(String body, org.eclipse.emf.ecore.EClassifier context, java.util.Map<String, org.eclipse.emf.ecore.EClassifier> environment) {
				return new Expression(body, context, environment);
			}
		
			«generatedMemberComment(it, 'This method will become private in the next release')»/* FIXME [MG] private or completely remove in the next release  */
			public static «getAbstractExpressionQualifiedClassName(it.container.editorGen.diagram)» getExpression(String body, org.eclipse.emf.ecore.EClassifier context) {
				return getExpression(body, context, java.util.Collections.<String, org.eclipse.emf.ecore.EClassifier>emptyMap());
			}
		
			«generatedMemberComment»
			private static class Expression extends «getAbstractExpressionQualifiedClassName(it.container.editorGen.diagram)» {
		
				«generatedMemberComment»
				private final java.util.regex.Pattern pattern;
		
				«generatedMemberComment»
				@SuppressWarnings("rawtypes")
				public Expression(String body, org.eclipse.emf.ecore.EClassifier context, java.util.Map environment) {
					super(body, context);
					java.util.regex.Pattern p;
					try {
						p = java.util.regex.Pattern.compile(body);
					} catch (java.util.regex.PatternSyntaxException e) {
						setStatus(org.eclipse.core.runtime.IStatus.ERROR, e.getMessage(), e);
						p = null;
					}
					this.pattern = p;
				}
		
				«generatedMemberComment»
				@SuppressWarnings("rawtypes")
				protected Object doEvaluate(Object contextInstance, java.util.Map env) {
					if (pattern == null) {
						return null;
					}
					if (context() instanceof org.eclipse.emf.ecore.EDataType) {
						contextInstance = org.eclipse.emf.ecore.util.EcoreUtil.convertToString(
								(org.eclipse.emf.ecore.EDataType) context(), contextInstance);
					}
					java.util.regex.Matcher matcher = this.pattern.matcher(String.valueOf(contextInstance));
					return Boolean.valueOf(«IF language == GenLanguage::NREGEXP_LITERAL»!«ENDIF»matcher.matches());
				}
			}
			«additions(it)»
		}
	'''

	def additions(GenExpressionInterpreter it) ''''''

}

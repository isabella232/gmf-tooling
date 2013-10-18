package xpt

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenAuditRoot
import org.eclipse.gmf.codegen.gmfgen.GenAuditContainer

@com.google.inject.Singleton class ConstraintProviders {

	@Inject extension Common
	@Inject extension GenAuditRoot_qvto
	@Inject extension GenEditorGenerator_qvto

def extensions(GenEditorGenerator it)'''
«IF hasAudits(it)»«extensions(audits)»«ENDIF»
'''

def extensions(GenAuditRoot it)'''
«extensions_emfv_constraintProviders»
«extensions_emfv_constraintBindings»
«extensions_emfv_uiContexts»
'''

//
// Extension point: org.eclipse.emf.validation.constraintProviders
//
def extensions_emfv_constraintProviders(GenAuditRoot it)'''
   <extension point="org.eclipse.emf.validation.constraintProviders">
      «xmlGeneratedTag»
      «FOR c : categories»«declareCategory(c)»«ENDFOR»
      <constraintProvider cache="true">
	  «FOR p : getAllTargetedModelPackages(it)»
         <package namespaceUri="«p.ecorePackage.nsURI»"/>
	  «ENDFOR»
	  «FOR c : categories»«defineCategory(c)»«ENDFOR»
      </constraintProvider>
   </extension>
'''

//
// Extension point: org.eclipse.emf.validation.constraintBindings
//
def extensions_emfv_constraintBindings(GenAuditRoot it)'''
   <extension point="org.eclipse.emf.validation.constraintBindings">
      «xmlGeneratedTag»
	«FOR ctx : clientContexts»
      <clientContext default="false" id="«getQualifiedIdentity(ctx)»">
         <selector class="«ctx.getQualifiedClassName()»"/>
      </clientContext>
      <binding context="«getQualifiedIdentity(ctx)»">
         «FOR rule : rules.filter(r | r.target != null && r.target.contextSelector == ctx)»
         <constraint ref="«editorGen.plugin.ID».«escapeXML(rule.id)»"/>
         «ENDFOR»
      </binding>

	«ENDFOR»
   </extension>
'''

//
// Extension point: org.eclipse.emf.validation.ui.UIRegisteredClientContext
//
def extensions_emfv_uiContexts(GenAuditRoot it)'''
«IF editorGen.diagram.liveValidationUIFeedback»
   <extension point="org.eclipse.emf.validation.ui.UIRegisteredClientContext">
      «xmlGeneratedTag»
	«FOR ctx : clientContexts»
      <clientContext id="«getQualifiedIdentity(ctx)»"/>
	«ENDFOR»
   </extension>
«ENDIF»
'''

def declareCategory(GenAuditContainer it)'''
      <category id="«pathMap»" mandatory="false" name="«IF name != null»«escapeXML(name)»«ELSE»«pathMap»«ENDIF»">
         <![CDATA[«IF description != null»«description»«ELSE»«''»«ENDIF»]]>
      </category>
'''

	def defineCategory(GenAuditContainer it)'''
         <constraints categories="«pathMap»">
         «FOR audit : audits.filter(a | a.target != null && a.target.getTargetClass() != null)»
         <constraint id="«escapeXML(audit.id)»"
            «IF audit.requiresConstraintAdapter»lang="Java" class="«audit.getConstraintAdapterQualifiedClassName()»"«ELSE»lang="OCL"«ENDIF»
            «IF audit.name != null »
            name="«escapeXML(audit.name)»"
            «ELSE»
            name="«escapeXML(audit.id)»"
            «ENDIF»
            mode="«IF audit.useInLiveMode»Live«ELSE»Batch«ENDIF»"
            severity="«audit.severity»" statusCode="200">
            «IF audit.description != null»
            «IF !audit.requiresConstraintAdapter»<![CDATA[«IF audit.rule != null»«audit.rule.body»«ELSE»«''»«ENDIF»]]>«ENDIF»
            <description><![CDATA[«(audit.description)»]]></description>
            «ELSE»
            <description><![CDATA[«('')»]]></description>
            «ENDIF»
            «IF audit.message != null»
            	<message><![CDATA[«audit.message»]]></message>
            	«ELSE»
            	«IF audit.name != null»
            	<message><![CDATA[«audit.name» audit violated]]></message>
            	«ELSE»
            	<message><![CDATA[«audit.id» audit violated]]></message>
            	«ENDIF»
            «ENDIF»
            <target class="«audit.target.getTargetClassModelQualifiedName()»"/>
         </constraint>
         «ENDFOR»
         </constraints>
	'''
	
	protected def pathMap(GenAuditContainer it) 
		'''«FOR p : path SEPARATOR '/' »«escapeXML(p.id)»«ENDFOR»'''
}
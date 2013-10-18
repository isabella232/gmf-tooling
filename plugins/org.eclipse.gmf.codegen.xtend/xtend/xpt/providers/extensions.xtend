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
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.Utils_qvto
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.ElementType
import org.eclipse.gmf.codegen.gmfgen.MetamodelType
import org.eclipse.gmf.codegen.gmfgen.SpecializationType
import org.eclipse.gmf.codegen.gmfgen.NotationType
import xpt.QualifiedClassNameProvider
import parsers.ParserProvider
import xpt.diagram.edithelpers.EditHelper
import xpt.diagram.edithelpers.EditHelperAdvice
import xpt.diagram.editparts.EditPartFactory

class extensions {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;

	@Inject ViewProvider viewProvider;
	@Inject IconProvider iconProvider;
	@Inject EditPartProvider editPartProvider;
	@Inject ModelingAssistantProvider modelAssistant;
	@Inject ParserProvider labelParsers;
	@Inject ShortcutsDecoratorProvider shorcutProvider;
	@Inject EditHelper editHelper;
	@Inject EditHelperAdvice editHelperAdvice;
	@Inject EditPartFactory xptEditPartFactory;
	
	def extensions(GenDiagram it) '''
		<extension point="org.eclipse.gmf.runtime.diagram.core.viewProviders" id="view-provider">
			«xmlGeneratedTag»
			<viewProvider class="«viewProvider.qualifiedClassName(it)»">
				<Priority name="«notationViewProviderPriority»"/>
				«IF shortcutsProvidedFor.notEmpty/*allow provider activation when another diagram tries to create a node, perhaps ours*/»
				<object id="referencing-diagrams" class="org.eclipse.gmf.runtime.notation.Diagram">
					<method name="getType()" value="«FOR s : shortcutsProvidedFor SEPARATOR ','»«s»«ENDFOR»"/>
				</object>
				<context viewClass="org.eclipse.gmf.runtime.notation.Node" containerViews="referencing-diagrams"/>
				«ENDIF»
				<context viewClass="org.eclipse.gmf.runtime.notation.Diagram" semanticHints="«editorGen.modelID»"/>
				<context viewClass="org.eclipse.gmf.runtime.notation.Node" semanticHints="«commaSeparatedVisualIDs(allNodes)»"/>
				«IF links.notEmpty/*it is unlikely there would be a diagram without a node, but a diagram without links deemed possible */»
				<context viewClass="org.eclipse.gmf.runtime.notation.Edge" semanticHints="«commaSeparatedVisualIDs(links)»"/>
				«ENDIF»
			</viewProvider>
		</extension>
		
		<extension point="org.eclipse.gmf.runtime.diagram.ui.editpartProviders" id="ep-provider">
			«xmlGeneratedTag»
			<editpartProvider class="«editPartProvider.qualifiedClassName(it)»">
				<Priority name="«editPartProviderPriority»"/>
				<object class="org.eclipse.gmf.runtime.notation.Diagram" id="generated-diagram">
				         	<method name="getType()" value="«editorGen.modelID»"/>
				</object>
				<object class="org.eclipse.gmf.runtime.notation.Node" id="generated-nodes">
				         	<method name="getType()" value="«commaSeparatedVisualIDs(allNodes)»"/>
				</object>
				<object class="org.eclipse.gmf.runtime.notation.Edge" id="generated-links">
				         	<method name="getType()" value="«commaSeparatedVisualIDs(links)»"/>
				</object>
				<object class="org.eclipse.gmf.runtime.notation.Node" id="generated-labels">
				         	<method name="getType()" value="«commaSeparatedVisualIDs(allNodes.map[n|n.labels].flatten)»"/>
				</object>
				<object class="org.eclipse.gmf.runtime.notation.Node" id="generated-compartments">
				         	<method name="getType()" value="«commaSeparatedVisualIDs(compartments)»"/>
				</object>
				<context views="generated-diagram,generated-nodes,generated-links,generated-labels,generated-compartments"/>
				   	</editpartProvider>
		</extension>
		
		<extension point="org.eclipse.gmf.runtime.emf.ui.modelingAssistantProviders" id="modelassist-provider">
			«xmlGeneratedTag»
			<modelingAssistantProvider class="«modelAssistant.qualifiedClassName(it)»">
				<Priority name="«modelingAssistantProviderPriority»"/>
				<object class="«xptEditPartFactory.getEditPartQualifiedClassName(it)»" id="«uniqueIdentifier»"/>
				«FOR n : topLevelNodes»
				<object class="«xptEditPartFactory.getEditPartQualifiedClassName(n)»" id="«n.uniqueIdentifier»"/>
				«ENDFOR»
				«FOR n : childNodes»
				<object class="«xptEditPartFactory.getEditPartQualifiedClassName(n)»" id="«n.uniqueIdentifier»"/>
				«ENDFOR»
				<context elements="«uniqueIdentifier»,«FOR tn: topLevelNodes SEPARATOR ','»«tn.uniqueIdentifier»«ENDFOR»,«FOR cn: childNodes SEPARATOR ','»«cn.uniqueIdentifier»«ENDFOR»"/>
			</modelingAssistantProvider>
		</extension>
		
		<extension point="org.eclipse.gmf.runtime.common.ui.services.iconProviders" id="icon-provider">
			«xmlGeneratedTag»
			<IconProvider class="«iconProvider.qualifiedClassName(it)»">
				<Priority name="«iconProviderPriority»"/>
			</IconProvider>
		</extension>
		«IF editorGen.labelParsers != null && editorGen.labelParsers.extensibleViaService»
			<extension point="org.eclipse.gmf.runtime.common.ui.services.parserProviders" id="parser-provider">
				«xmlGeneratedTag»
				<ParserProvider class="«labelParsers.qualifiedClassName(editorGen.labelParsers)»">
					<Priority name="«editorGen.labelParsers.providerPriority»"/>
				</ParserProvider>
			</extension>
		«ENDIF»
		«IF generateShortcutIcon()»
			<extension point="org.eclipse.gmf.runtime.diagram.ui.decoratorProviders" id="decorator-provider">
				«xmlGeneratedTag»
				<decoratorProvider class="«shorcutProvider.qualifiedClassName(it)»">
					<Priority name="«shortcutsDecoratorProviderPriority»"/>
					<object class="org.eclipse.gmf.runtime.notation.Node(org.eclipse.gmf.runtime.notation)" id="generated-top-nodes">
					         	<method name="getType()" value="«commaSeparatedVisualIDs(topLevelNodes)/*generated code supports shortcuts only to top-level nodes*/»"/>
					</object>
					      <context decoratorTargets="generated-top-nodes"/>
				</decoratorProvider>
			</extension>
		«ENDIF»
		
		<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypes" id="element-types">
			«xmlGeneratedTag»
			«FOR e : getAllTypedElements()»
				«elementTypeSafe(e.elementType)»
			«ENDFOR»
		</extension>
		
		<extension point="org.eclipse.gmf.runtime.emf.type.core.elementTypeBindings" id="element-types-bindings">
			«xmlGeneratedTag»
			<clientContext id="«editorGen.plugin.ID».TypeContext">
				<enablement>
					<test
						property="org.eclipse.gmf.runtime.emf.core.editingDomain"
						value="«editingDomainID»"/>
				</enablement>
			</clientContext> 
			<binding context="«editorGen.plugin.ID».TypeContext">
				«FOR e : getAllTypedElements()»
				<elementType ref="«e.elementType.uniqueIdentifier»"/>
				«ENDFOR»
				<advice ref="org.eclipse.gmf.runtime.diagram.core.advice.notationDepdendents"/>
			</binding>
		</extension>
	'''

	def elementTypeSafe(ElementType it) '''
		«IF !it.definedExternally»
			«elementType(it)»
		«ENDIF»
	'''

	def dispatch elementType(ElementType it) '''«ERROR('Unknown element type: ' + it)»'''

	def dispatch elementType(MetamodelType it) '''
		<metamodel nsURI="«getMetaClass().genPackage.ecorePackage.nsURI»">
			<metamodelType
				id="«uniqueIdentifier»"
				«IF null != displayName»
					name="%metatype.name.«diagramElement.uniqueIdentifier»"
				«ENDIF»
				kind="org.eclipse.gmf.runtime.emf.type.core.IHintedType"
				eclass="«getMetaClass().ecoreClass.name»"
				edithelper="«editHelper.qualifiedClassName(it)»">
				          	<param name="semanticHint" value="«diagramElement.visualID»"/>
			</metamodelType>
		</metamodel>
	'''

	def dispatch elementType(SpecializationType it) '''
		«IF null == getMetamodelClass()»
			«specializationType(it)»
		«ELSE»
			<metamodel nsURI="«getMetamodelClass().genPackage.ecorePackage.nsURI»">
			«specializationType(it)»
			</metamodel>
		«ENDIF»
	'''

	def specializationType(SpecializationType it) '''
		<specializationType
			id="«uniqueIdentifier»"
			«IF null != displayName»
				name="%metatype.name.«diagramElement.uniqueIdentifier»"
			«ENDIF»
			kind="org.eclipse.gmf.runtime.emf.type.core.IHintedType"«IF editHelperAdviceClassName != null»
			edithelperadvice="«editHelperAdvice.qualifiedClassName(it)»"«ENDIF»>
			<specializes id="«IF (null == metamodelType)»org.eclipse.gmf.runtime.emf.type.core.null«ELSE»«metamodelType.
				uniqueIdentifier»«ENDIF»"/>
				<param name="semanticHint" value="«diagramElement.visualID»"/>
			</specializationType>
	'''

	def dispatch elementType(NotationType it) '''
		<specializationType
			id="«uniqueIdentifier»"
			«IF null != displayName»
				name="%metatype.name.«diagramElement.uniqueIdentifier»"
			«ENDIF»
			kind="org.eclipse.gmf.runtime.diagram.ui.util.INotationType">
			<specializes id="org.eclipse.gmf.runtime.emf.type.core.null"/>
				<param name="semanticHint" value="«diagramElement.visualID»"/>
			</specializationType>
	'''

	def commaSeparatedVisualIDs(Iterable<? extends GenCommonBase> list) '''«FOR gcb : list SEPARATOR ','»«gcb.visualID»«ENDFOR»'''

	@Localization def i18n(GenDiagram it) '''
		
		# Providers
		«FOR next : getAllTypedElements().map[t|t.elementType]»
			«internal_i18n(next)»
		«ENDFOR»
	'''

	@Localization def internal_i18n(ElementType it) '''
		«IF null != displayName && !definedExternally»metatype.name.«diagramElement.uniqueIdentifier»=«displayName»«ENDIF»
	'''

}

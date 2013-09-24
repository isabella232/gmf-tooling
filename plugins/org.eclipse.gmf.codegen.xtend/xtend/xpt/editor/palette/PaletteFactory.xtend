/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.editor.palette

import com.google.inject.Inject
import java.util.Map
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.EntryBase
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.gmfgen.Separator
import org.eclipse.gmf.codegen.gmfgen.StandardEntry
import org.eclipse.gmf.codegen.gmfgen.StandardEntryKind
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.gmf.codegen.gmfgen.ToolGroup
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import xpt.Common
import xpt.Common_qvto
import xpt.Externalizer
import xpt.providers.ElementTypes
import xpt.QualifiedClassNameProvider

class PaletteFactory {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension Utils_qvto;
	@Inject extension QualifiedClassNameProvider;

	@Inject ElementTypes xptElementTypes;
	@Inject Externalizer xptExternalizer;

	def className(Palette it) '''«it.factoryClassName»'''

	def packageName(Palette it) '''«it.packageName»'''

	def qualifiedClassName(Palette it) '''«packageName(it)».«className(it)»'''

	def fullPath(Palette it) '''«qualifiedClassName(it)»'''

	@Deprecated
	def Factory(Palette it) '''«PaletteFactory(it)»'''
	
	def PaletteFactory(Palette it) '''
		«copyright(diagram.editorGen)»
		package «packageName(it)»;
		
		«generatedClassComment»
		public class «className(it)» {
		
			«generatedMemberComment»
			public void fillPalette(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
		«IF definesStandardTools()»
			cleanStandardTools(paletteRoot);
		«ENDIF»
				«FOR group : it.groups»
			«addEntry(group, 'paletteRoot')»
				«ENDFOR»
			}
		
		«IF it.definesStandardTools»
			«cleanStandardToolsHack(it)»
		«ENDIF»
		
		«FOR group : collectGroups(it)»
			«createGroup(group)»
		«ENDFOR»
		«FOR tool : collectTools(it)»
			«createEntry(tool)»
		«ENDFOR»
		
		«IF needsNodeToolEntryClass(it)»«nodeToolEntry(it)»«ENDIF»
		«IF needsLinkToolEntryClass(it)»«linkToolEntry(it)»«ENDIF»
		
		«additions(it)»
		}
	'''

	def createGroup(ToolGroup it) '''
		«generatedMemberComment('Creates \"' + title + '\" palette tool group')»
		private org.eclipse.gef.palette.PaletteContainer «createMethodName»() {
			«newContainer(it, 'paletteContainer')»
			«setIdentity(it, 'paletteContainer')»
			«setDescription(it, 'paletteContainer')»
			«setSmallImage(it, 'paletteContainer', palette)»
			«setLargeImage(it, 'paletteContainer', palette)»
			«FOR entry : it.entries»
				«addEntry(entry, 'paletteContainer')»
			«ENDFOR»
			return paletteContainer;
		}
	'''

	def newContainer(ToolGroup it, String varName) '''
	«IF collapse && toolsOnly»
		org.eclipse.gef.palette.PaletteDrawer «varName» = new org.eclipse.gef.palette.PaletteDrawer(«i18nTitle(it)»);
	«ELSEIF stack»
		org.eclipse.gef.palette.PaletteStack «varName» = new org.eclipse.gef.palette.PaletteStack(«i18nTitle(it)», null, null);
	«ELSE»
		org.eclipse.gef.palette.PaletteGroup «varName» = new org.eclipse.gef.palette.PaletteGroup(«i18nTitle(it)»);
	«ENDIF»
	'''

	def setDescription(ToolGroup gr, String varName) '''
		«IF gr.description != null»
		«varName».setDescription(«i18nDesc(gr)»);
		«ENDIF»
	'''

	def dispatch addEntry(ToolGroupItem it, String varName) '''
		«ERROR('abstract addEntry(ToolGroupItem,String) template for' + it)»
	'''

	def dispatch addEntry(AbstractToolEntry it, String varName) '''
		«varName».add(«createMethodName»());
		«IF it.isDefault && it.group.stack»
			«varName».setActiveEntry((org.eclipse.gef.palette.ToolEntry) paletteContainer.getChildren().get(paletteContainer.getChildren().size() - 1));
		«ENDIF»
	'''

	def dispatch addEntry(Separator it, String varName) '''
		«varName».add(new org.eclipse.gef.palette.PaletteSeparator());
	'''

	def dispatch addEntry(ToolGroup it, String varName) '''
		«varName».add(«createMethodName»());
	'''

	def createEntry(AbstractToolEntry it) '''
		«generatedMemberComment»
		private org.eclipse.gef.palette.ToolEntry «createMethodName»() {
			«newEntry(it, 'entry')»
			«setIdentity(it, 'entry')»
			«setSmallImage(it, 'entry', group.palette)»
			«setLargeImage(it, 'entry', group.palette)»
			«setToolClass(it, 'entry')»
			«FOR prop : it.properties»
				«setToolProperty(prop, 'entry')»
			«ENDFOR»
			return entry;
		}
	'''

	protected def String toolEntryClass(ToolEntry entry) {
		return if(entry.genNodes.empty) 'LinkToolEntry' else 'NodeToolEntry'
	}

	def dispatch newEntry(AbstractToolEntry it, String toolVarName) '''
		«ERROR('abstract newEntry(AbstractToolEntry,String) template for: ' + it)»
	'''

	def dispatch newEntry(ToolEntry it, String toolVarName) '''
		«IF it.elements.empty»
			org.eclipse.gef.palette.ToolEntry «toolVarName» = new org.eclipse.gef.palette.ToolEntry(«i18nTitle(it)», «i18nDesc(it)», null, null) {};
		«ELSEIF it.elements.size() > 1»
			java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType> types = new java.util.ArrayList<org.eclipse.gmf.runtime.emf.type.core.IElementType>(«elements.
			size»);
			«FOR e : elements»
				types.add(«xptElementTypes.accessElementType(e)»);
			«ENDFOR»
			«toolEntryClass(it)» «toolVarName» = new «toolEntryClass(it)»(«i18nTitle(it)», «i18nDesc(it)», types);
		«ELSE»
			«toolEntryClass(it)» «toolVarName» = new «toolEntryClass(it)»(«i18nTitle(it)», «i18nDesc(it)», java.util.Collections.singletonList(«xptElementTypes.
				accessElementType(elements.head)»));
		«ENDIF»
	'''

	def dispatch newEntry(StandardEntry it, String toolVarName) '''
	«IF kind == StandardEntryKind::SELECT_LITERAL»
		«newStdSelectEntry(it, toolVarName)»
	«ELSEIF kind == StandardEntryKind::MARQUEE_LITERAL»
		«newStdMarqueeEntry(it, toolVarName)»
	«ELSEIF kind == StandardEntryKind::ZOOM_LITERAL»
		«newStdZoomEntry(it, toolVarName)»
	«ELSE»
		«newStdOtherEntry(it, toolVarName)»
	«ENDIF»
	'''

	def newStdSelectEntry(StandardEntry it, String toolVarName) '''
		org.eclipse.gef.palette.PanningSelectionToolEntry «toolVarName» = new org.eclipse.gef.palette.PanningSelectionToolEntry();
	'''

	def newStdMarqueeEntry(StandardEntry it, String toolVarName) '''
		org.eclipse.gef.palette.MarqueeToolEntry «toolVarName» = new org.eclipse.gef.palette.MarqueeToolEntry();
	'''

	def newStdZoomEntry(StandardEntry it, String toolVarName) '''
		FIXME
	'''

	def newStdOtherEntry(StandardEntry it, String toolVarName) '''
		«ERROR('override newStdOtherEntry(StandardEntry, String) for kind ' + it.kind)»
	'''

	def setSmallImage(EntryBase it, String toolVarName, Palette palette) '''
	«IF null != smallIconPath»
		«toolVarName».setSmallIcon(«palette.activatorFQN».findImageDescriptor("«smallIconPath»")); «nonNLS(1)»
	«ELSEIF it.oclIsKindOf(typeof(ToolEntry))»
		«IF (it as ToolEntry).elements.head != null»
			«toolVarName».setSmallIcon(«getElementTypesQualifiedClassName(palette.diagram)».getImageDescriptor(«xptElementTypes.accessElementType((it as ToolEntry).elements.head)»));
		«ENDIF»
	«ENDIF»
	'''

	def setLargeImage(EntryBase it, String toolVarName, Palette palette) '''
	«IF null != largeIconPath»
		«toolVarName».setLargeIcon(«palette.activatorFQN».findImageDescriptor("«largeIconPath»")); «nonNLS(1)»
	«ELSEIF it.oclIsKindOf(typeof(ToolEntry))»
		«IF (it as ToolEntry).elements.head != null»
			«toolVarName».setLargeIcon(«toolVarName».getSmallIcon());
		«ENDIF»
	«ENDIF»
	'''

	def setToolClass(AbstractToolEntry it, String toolVarName) '''
	«IF null != qualifiedToolName»
		«toolVarName».setToolClass(«qualifiedToolName».class);
	«ENDIF»
	'''

	def setToolProperty(Map.Entry<String, String> it, String toolVarName) '''
		«toolVarName».setToolProperty(«key», «value»);
	'''

	@Localization def dispatch i18nTitle(ToolEntry it) // 
	'''«IF title == null»null«ELSE»«xptExternalizer.accessorCall(group.palette.diagram.editorGen, i18nTitleKey(it))»«ENDIF»'''

	@Localization def dispatch i18nTitle(ToolGroup it) //
	'''«IF title == null»null«ELSE»«xptExternalizer.accessorCall(palette.diagram.editorGen, i18nTitleKey(it))»«ENDIF»'''

	@Localization def dispatch i18nDesc(ToolEntry it) //
	'''«IF description == null»null«ELSE»«xptExternalizer.accessorCall(group.palette.diagram.editorGen, i18nDescKey(it))»«ENDIF»'''

	@Localization def dispatch i18nDesc(ToolGroup it) //
	'''«IF description == null»null«ELSE»«xptExternalizer.accessorCall(palette.diagram.editorGen, i18nDescKey(it))»«ENDIF»'''

	@Localization def i18nAccessors(Palette it) '''
	«FOR group : collectGroups(it)»
		«internal_i18n_accessors(group)»
	«ENDFOR»
	«FOR tool : collectTools(it)»
		«internal_i18n_accessors(tool)»
	«ENDFOR»
	'''

	@Localization def i18nValues(Palette it) '''
	«FOR group : collectGroups(it)»
		«internal_i18n_values(group)»
	«ENDFOR»
	«FOR tool : collectTools(it)»
		«internal_i18n_values(tool)»
	«ENDFOR»
	'''

	@Localization protected def internal_i18n_accessors(EntryBase it) '''
	«IF null != title»«xptExternalizer.accessorField(i18nTitleKey(it))»«ENDIF»
	«IF null != description»«xptExternalizer.accessorField(i18nDescKey(it))»«ENDIF»
	'''

	@Localization protected def internal_i18n_values(EntryBase it) '''
	«IF null != title»«xptExternalizer.messageEntry(i18nTitleKey(it), title)»«ENDIF»
	«IF null != description»«xptExternalizer.messageEntry(i18nDescKey(it), description)»«ENDIF»
	'''

	def cleanStandardToolsHack(Palette it) '''
		«generatedMemberComment(it, 'Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=159289')»
		private void cleanStandardTools(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
			for (java.util.Iterator it = paletteRoot.getChildren().iterator(); it.hasNext();) {
				org.eclipse.gef.palette.PaletteEntry entry = (org.eclipse.gef.palette.PaletteEntry) it.next();
				if (!"standardGroup".equals(entry.getId())) { «nonNLS(1)»
					continue;
				}
				for (java.util.Iterator it2 = ((org.eclipse.gef.palette.PaletteContainer) entry).getChildren().iterator(); it2.hasNext();) {
					org.eclipse.gef.palette.PaletteEntry entry2 = (org.eclipse.gef.palette.PaletteEntry) it2.next();
					if ("zoomTool".equals(entry2.getId())) { «nonNLS(1)»
						it2.remove();
					} else if ("noteStack".equals(entry2.getId())) { «nonNLS(1)»
						it2.remove();
					} else if ("selectionTool".equals(entry2.getId())) { «nonNLS(1)»
						it2.remove();
					}
					if (paletteRoot.getDefaultEntry() == entry2) {
						paletteRoot.setDefaultEntry(null);
					}
				}
			}
		}
	'''

	def nodeToolEntry(Palette it) '''
		«generatedClassComment»
		private static class NodeToolEntry extends org.eclipse.gef.palette.ToolEntry {
		
			«generatedMemberComment»
			private final java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> elementTypes;
		
			«generatedMemberComment»
			private NodeToolEntry(String title, String description, java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> elementTypes) {
			super(title, description, null, null);
			this.elementTypes = elementTypes;
			}
		
			«generatedMemberComment»
			public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool(elementTypes);
			tool.setProperties(getToolProperties());
			return tool;
			}
		}
	'''

	def linkToolEntry(Palette it) '''
		«generatedClassComment»
		private static class LinkToolEntry extends org.eclipse.gef.palette.ToolEntry {
		
			«generatedMemberComment»
			private final java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> relationshipTypes;
		
			«generatedMemberComment»
			private LinkToolEntry(String title, String description, java.util.List<org.eclipse.gmf.runtime.emf.type.core.IElementType> relationshipTypes) {
			super(title, description, null, null);
			this.relationshipTypes = relationshipTypes;
			}
		
			«generatedMemberComment»
			public org.eclipse.gef.Tool createTool() {
			org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool(relationshipTypes);
			tool.setProperties(getToolProperties());
			return tool;
			}
		}
	'''

	def setIdentity(EntryBase it, String toolVarName) '''
	«IF !it.id.nullOrEmpty»
		 «toolVarName».setId(«id»);«IF id.startsWith('\"') && id.endsWith('\"')» «nonNLS(1)»«ENDIF»
	«ENDIF»
	'''

	def additions(Palette it) ''''''

}

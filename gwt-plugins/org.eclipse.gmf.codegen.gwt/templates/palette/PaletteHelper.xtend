package palette

import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.EntryBase
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.gmf.codegen.gmfgen.ToolGroup

class PaletteHelper {

	def activatorFQN(Palette it) {
		diagram.editorGen.plugin.getActivatorQualifiedClassName
	}
	
	def activatorFQN(AbstractToolEntry it) { group.palette.activatorFQN }
	
	def activatorFQN(ToolGroup it) { palette.activatorFQN }
	
	def i18nKey(EntryBase group) {
		val rv = group.createMethodName 
		if (rv.startsWith('get'))
			rv.substring('get'.length) 
		else 
			if (rv.startsWith('create')) 
				rv.substring('create'.length) 
			else rv
	}
	
	def i18nTitleKey(EntryBase group) { i18nKey(group) + '_title' }
	
	def i18nDescKey(EntryBase group) { i18nKey(group) + '_desc' }
	
	def collectGroups(Palette palette) {
		palette.groups + palette.groups.map(it | collectSubGroups(it)).flatten
	}
	
	def Iterable<ToolGroup> collectSubGroups(ToolGroup group) {
		val rv = group.entries.filter(ToolGroup) 
		val rest = rv.map(g | collectSubGroups(g)).flatten
		rv + rest
	}
	
	def collectTools(Palette palette) {
		collectGroups(palette).map[it | entries].flatten.filter(AbstractToolEntry)
	}

	def needsNodeToolEntryClass(Palette palette) {
		collectTools(palette).filter(ToolEntry).exists[it | !genNodes.nullOrEmpty]
	}
	
	def needsLinkToolEntryClass(Palette palette) {
		collectTools(palette).filter(ToolEntry).exists[it | !genLinks.nullOrEmpty]
	}

}
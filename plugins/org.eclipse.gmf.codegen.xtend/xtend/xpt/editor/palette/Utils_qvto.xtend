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
import java.util.Collection
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.gmf.codegen.gmfgen.ToolGroup
import xpt.Common_qvto
import org.eclipse.gmf.codegen.xtend.annotations.Localization
import org.eclipse.gmf.codegen.gmfgen.EntryBase

class Utils_qvto {
	@Inject extension Common_qvto;

	def dispatch String activatorFQN(Palette palette) {
		return palette.diagram.editorGen.plugin.getActivatorQualifiedClassName()
	}

	def dispatch String activatorFQN(AbstractToolEntry entry) {
		return entry.group.palette.activatorFQN()
	}

	def dispatch String activatorFQN(ToolGroup group) {
		return group.palette.activatorFQN()
	}

	@Localization def String i18nKey(EntryBase group) {
		var rv = group.createMethodName;
		return switch(rv){
			case rv.startsWith("get") : rv.substringAfter("get")
			case rv.startsWith("create") : rv.substringAfter("create")
			default : rv
		}
	}
	
	@Localization def String i18nTitleKey(EntryBase group) {
		return i18nKey(group) + '_title'
	}
	
	@Localization def String i18nDescKey(EntryBase group) {
		return i18nKey(group) + '_desc'
	}

	def Iterable<ToolGroup> collectGroups(Palette palette) {
		var result = <ToolGroup>newLinkedHashSet()
		if (palette != null) {
			result.addAll(palette.groups)
			for (group : palette.groups) {
				result.addAll(collectSubGroups(group))
			}
		}
		return result
	}

	def Iterable<ToolGroup> collectSubGroups(ToolGroup group) {
		return collectSubGroups(group, <ToolGroup>newLinkedList())
	}

	def Iterable<ToolGroup> collectSubGroups(ToolGroup group, Collection<ToolGroup> acc) {
		var directSubGroups = group.entries.filter(typeof(ToolGroup))
		if (!directSubGroups.empty) {
			acc.addAll(directSubGroups);
			for (next : directSubGroups) {
				collectSubGroups(next, acc)
			}
		}
		return acc;
	}

	def Iterable<AbstractToolEntry> collectTools(Palette palette) {
		return collectGroups(palette).map[g|g.entries.filter(typeof(AbstractToolEntry))].flatten
	}

	def boolean needsNodeToolEntryClass(Palette palette) {
		return collectTools(palette).filter(typeof(ToolEntry)).exists[e|e.genNodes.notEmpty]
	}

	def boolean needsLinkToolEntryClass(Palette palette) {
		return collectTools(palette).filter(typeof(ToolEntry)).exists[e|e.genLinks.notEmpty]
	}

}

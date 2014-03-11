package palette

import com.google.inject.Inject
import common.BaseClassTemplate
import diagram.MetaModel
import java.util.Map
import org.eclipse.gmf.codegen.gmfgen.AbstractToolEntry
import org.eclipse.gmf.codegen.gmfgen.EntryBase
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.Palette
import org.eclipse.gmf.codegen.gmfgen.Separator
import org.eclipse.gmf.codegen.gmfgen.StandardEntry
import org.eclipse.gmf.codegen.gmfgen.StandardEntryKind
import org.eclipse.gmf.codegen.gmfgen.ToolEntry
import org.eclipse.gmf.codegen.gmfgen.ToolGroup
import org.eclipse.gmf.codegen.gmfgen.ToolGroupItem
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeModelFacet

class PaletteFactory extends BaseClassTemplate<Palette> {

	extension PaletteHelper = new PaletteHelper
	extension MetaModel = new MetaModel

	@Inject NodeToolEntry nodeToolEntry
	@Inject LinkToolEntry linkToolEntry

	override generate(Palette it) '''
«««		«xpt::Common::copyright FOR diagram.editorGen»
		package «packageName»;

		«generatedClassComment»
		public class «factoryClassName» {
			«body»
		}
	'''

	protected def getEditPluginImagesQCN(GenEditorGenerator it) {
		domainGenModel.genPackages.head.qualifiedEditPluginClassName + 'Images'
	}

	def attrs(Palette it) '''
		private final org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory;
	'''

	override protected body(Palette it) '''

		«attrs»

		public «factoryClassName»(org.eclipse.gmf.runtime.gwt.client.ClientFactory clientFactory) {
			assert clientFactory != null;
			this.clientFactory = clientFactory;
		}

		«contribute»

		«FOR g: collectGroups(it)»«createGroup(g)»«ENDFOR»

		«FOR t: collectTools(it)»«createEntry(t)»«ENDFOR»

		«IF needsNodeToolEntryClass»«nodeToolEntry.nodeToolEntry(it)»«ENDIF»

		«IF needsLinkToolEntryClass»«linkToolEntry.linkToolEntry(it)»«ENDIF»

		«additions»

	'''

	override qualifiedClassName(Palette it) { factoryQualifiedClassName }

	def contribute(Palette it) '''
		«generatedMemberComment»
		public void contributeToPalette(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
			«IF !definesStandardTools()»
			«addStandardTools»
			«ENDIF»
			«FOR g: groups»«addEntry(g, 'paletteRoot')»«ENDFOR»
		}
	'''
	
	def addStandardTools(Palette it) '''
		org.eclipse.gef.palette.PaletteGroup controls = new org.eclipse.gef.palette.PaletteGroup("Controls");
		paletteRoot.add(controls);

		org.eclipse.gef.palette.ToolEntry tool = new org.eclipse.gef.palette.SelectionToolEntry();
		controls.add(tool);
		paletteRoot.setDefaultEntry(tool);

		controls.add(new org.eclipse.gef.palette.MarqueeToolEntry());
	'''
	
	def createGroup(ToolGroup it) '''
		«generatedMemberComment('Creates \"' + title + '\" palette tool group')»
		private org.eclipse.gef.palette.PaletteContainer «createMethodName»() {
			«newContainer('paletteContainer')»
			«setIdentity('paletteContainer')»
			«description.setDescription('paletteContainer', it)»
			«setSmallImage('paletteContainer', palette)»
			«setLargeImage('paletteContainer', palette)»
			«FOR e: entries»«e.addEntry('paletteContainer')»«ENDFOR»
			return paletteContainer;
		}
	'''
	
	def newContainer(ToolGroup it, String varName) '''
		«IF collapse && toolsOnly»
			org.eclipse.gef.palette.PaletteDrawer «varName» = new org.eclipse.gef.palette.PaletteDrawer(«i18nTitle»);
		«ELSEIF stack»
			org.eclipse.gef.palette.PaletteStack «varName» = new org.eclipse.gef.palette.PaletteStack(«i18nTitle», null, null);
		«ELSE»
			org.eclipse.gef.palette.PaletteGroup «varName» = new org.eclipse.gef.palette.PaletteGroup(«i18nTitle»);
		«ENDIF»
	'''

	def setDescription(String it, String varName, ToolGroup gr) '''
		«varName».setDescription(«gr.i18nDesc»);
	'''

	def dispatch addEntry(ToolGroupItem it, String varName) '''
		«'abstract addEntry(ToolGroupItem,String) template'»
	'''

	def dispatch addEntry(AbstractToolEntry it, String varName) '''
		{
			org.eclipse.gef.palette.PaletteEntry paletteEntry = «createMethodName»();
			if (paletteEntry != null) {
				«varName».add(paletteEntry);
				«IF ^default && group.stack»
				«varName».setActiveEntry(paletteEntry);
				«ENDIF»
			}
		}
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
			«newEntry('entry')»
			«setIdentity('entry')»
			«setSmallImage('entry', group.palette)»
			«setLargeImage('entry', group.palette)»
			«setToolClass('entry')»
			«FOR p: properties»«p.setToolProperty('entry')»«ENDFOR»
			return entry;
		}
	'''
	
	def dispatch newEntry(AbstractToolEntry it, String toolVarName) '''
«««		«'abstract newEntry(AbstractToolEntry,String) template'»
	'''
	
	def dispatch newEntry(ToolEntry it, String toolVarName) {
		val toolEntryClass = if (genNodes.isEmpty()) 'LinkToolEntry' else 'NodeToolEntry'
		'''
			«IF elements.isEmpty()»
			org.eclipse.gef.palette.ToolEntry «toolVarName» = new org.eclipse.gef.palette.ToolEntry("«title»", "«description»", null, null) {};
			«ELSE»
			final int[] visualIds = new int[] {
				«FOR e: elements SEPARATOR ','»«e.visualID»«ENDFOR»
			};
			«toolEntryClass» «toolVarName» = new «toolEntryClass»("«title»", "«description»", visualIds);
			«ENDIF»
		'''
	} 
	
	def dispatch newEntry(StandardEntry it, String toolVarName) '''
		«IF StandardEntryKind::SELECT == kind »
		«newStdSelectEntry(toolVarName)»
		«ELSEIF kind == StandardEntryKind::MARQUEE»
		«newStdMarqueeEntry(toolVarName)»
		«ELSEIF kind == StandardEntryKind::ZOOM»
		«newStdZoomEntry(toolVarName)»
		«ELSE»
		«newStdOtherEntry(toolVarName)»
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
		«'override newStdOtherEntry(StandardEntry, String) for kind ' + kind»
	'''

	// FIXME: odd code - FOR EntryBase, while most of the template is valid for ToolEntry only!!!
	dispatch def setSmallImage(EntryBase it, String toolVarName, Palette palette) '''
«««		// «toolVarName».setSmallIcon(org.eclipse.jface.resource.ImageDescriptor.createFromImage(new org.eclipse.swt.graphics.Image(null, IMAGES.«it.eClass.name.toFirstLower»())));
«««		«IF null != smallIconPath»
«««		«toolVarName».setSmallIcon(«palette.activatorFQN()».findImageDescriptor("«smallIconPath»"));
«««		«ELSEIF it instanceof ToolEntry && !(it as ToolEntry).elements.isEmpty()»
«««		«LET self.oclAsType(gmfgen::ToolEntry) AS toolEntry»
«««		«toolVarName».setSmallIcon(«palette.diagram.getElementTypesQualifiedClassName()».getImageDescriptor(«xpt::providers::ElementTypes::accessElementType FOR toolEntry.elements.first()»));
«««		«ENDLET»
«««		«ENDIF»
	'''

	dispatch def setSmallImage(ToolEntry it, String toolVarName, Palette palette) '''
		«toolVarName».setSmallIcon(«smallImage(toolVarName)»);
	'''

	def smallImage(ToolEntry it, String toolVarName) '''
		«IF elements.isEmpty()»
		null
		«ELSE»
		clientFactory.getImageProvider().getImageDescriptor(«getElement(elements.head)»)«ENDIF»
	'''

	def dispatch CharSequence getElement(GenNode it) '''«modelFacet.getElement()»'''
	def dispatch CharSequence getElement(GenLink it) '''«modelFacet.getElement()»'''
	def dispatch CharSequence getElement(LinkModelFacet it) ''''Unexpected model facet: ' + self.repr()'''
	def dispatch CharSequence getElement(TypeModelFacet it) '''«metaClass.getMetaClass»'''
	def dispatch CharSequence getElement(TypeLinkModelFacet it) '''«metaClass.getMetaClass»'''
	def dispatch CharSequence getElement(FeatureLinkModelFacet it) '''«metaFeature.getMetaFeature»'''

	def setLargeImage(EntryBase it, String toolVarName, Palette palette) '''
«««		«IF null != largeIconPath»
«««		«toolVarName».setLargeIcon(«palette.activatorFQN()».findImageDescriptor("«largeIconPath»"));
«««		«ELSEIF it instanceof ToolEntry && !(it as ToolEntry).elements.isEmpty()»
		«toolVarName».setLargeIcon(«toolVarName».getSmallIcon());
«««		«ENDIF»
	'''
	
	def setToolClass(AbstractToolEntry it, String toolVarName) '''
		«IF null != qualifiedToolName»
		«toolVarName».setToolClass(«qualifiedToolName».class);
		«ENDIF»
	'''

	def setToolProperty(Map.Entry<?,?> it, String toolVarName) 
		'''«toolVarName».setToolProperty(«key», «value»);'''
	
	def dispatch i18nTitle(ToolEntry it) 
		'''«IF title == null»null«ELSE»"«title»"«ENDIF»'''
	
	def dispatch i18nTitle(ToolGroup it) 
		'''«IF title == null»null«ELSE»"«title»"«ENDIF»'''
	
	def dispatch i18nDesc(ToolEntry it) 
		'''«IF null == description»null«ELSE»"«description»"«ENDIF»'''
	
	def dispatch i18nDesc(ToolGroup it) 
		'''«IF null == description»null«ELSE»"«description»"«ENDIF»'''
	
	def i18nAccessors(Palette it) '''
«««		«internal_i18n_accessors FOREACH collectGroups»
«««		«internal_i18n_accessors FOREACH collectTools»
	'''
	
	def i18nValues(Palette it) '''
«««		«internal_i18n_values FOREACH collectGroups»
«««		«internal_i18n_values FOREACH collectTools»
	'''
	
	def internal_i18n_accessors(EntryBase it) '''
«««		«IF null != title»«xpt::Externalizer::accessorField(i18nTitleKey)»«ENDIF»
«««		«IF null != description»«xpt::Externalizer::accessorField(i18nDescKey)»«ENDIF»
	'''
	
	def internal_i18n_values(EntryBase it) '''
«««		«IF null != title»«xpt::Externalizer::messageEntry(i18nTitleKey, title)»«ENDIF»
«««		«IF null != description»«xpt::Externalizer::messageEntry(i18nDescKey, description)»«ENDIF»
	'''
	
	def cleanStandardToolsHack(Palette it) '''
		«generatedMemberComment('Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=159289')»
		private void cleanStandardTools(org.eclipse.gef.palette.PaletteRoot paletteRoot) {
			for (java.util.Iterator it = paletteRoot.getChildren().iterator(); it.hasNext();) {
				org.eclipse.gef.palette.PaletteEntry entry = (org.eclipse.gef.palette.PaletteEntry) it.next();
				if (!"standardGroup".equals(entry.getId())) {
					continue;
				}
				for (java.util.Iterator it2 = ((org.eclipse.gef.palette.PaletteContainer) entry).getChildren().iterator(); it2.hasNext();) {
					org.eclipse.gef.palette.PaletteEntry entry2 = (org.eclipse.gef.palette.PaletteEntry) it2.next();
					if ("zoomTool".equals(entry2.getId())) {
						it2.remove();
					} else if ("noteStack".equals(entry2.getId())) {
						it2.remove();
					} else if ("selectionTool".equals(entry2.getId())) {
						it2.remove();
					}
					if (paletteRoot.getDefaultEntry() == entry2) {
						paletteRoot.setDefaultEntry(null);
					}
				}
			}
		}
	'''
	
	/*
	def nodeToolEntry(Palette it) '''
«««		«xpt::Common::generatedClassComment»
		private static class NodeToolEntry extends org.eclipse.gef.palette.ToolEntry {
	
«««			«xpt::Common::generatedMemberComment»
«««			private final «CodeStyle::G('java.util.List', 'org.eclipse.gmf.runtime.emf.type.core.IElementType') FOR diagram» elementTypes;
	
«««			«xpt::Common::generatedMemberComment»
«««			private NodeToolEntry(String title, String description, «CodeStyle::G('java.util.List', 'org.eclipse.gmf.runtime.emf.type.core.IElementType') FOR diagram» elementTypes) {
«««				super(title, description, null, null);
«««				this.elementTypes = elementTypes;
«««			}
	
«««			«xpt::Common::generatedMemberComment»
			public org.eclipse.gef.Tool createTool() {
				org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool(elementTypes);
				tool.setProperties(getToolProperties());
				return tool;
			}
		}
	'''
	*  
	*/
/*	
//	def linkToolEntry(Palette it) '''
«««		«xpt::Common::generatedClassComment»
«««		private static class LinkToolEntry extends org.eclipse.gef.palette.ToolEntry {
	
«««			«xpt::Common::generatedMemberComment»
«««			private final «CodeStyle::G('java.util.List', 'org.eclipse.gmf.runtime.emf.type.core.IElementType') FOR diagram» relationshipTypes;
	
«««			«xpt::Common::generatedMemberComment»
«««			private LinkToolEntry(String title, String description, «CodeStyle::G('java.util.List', 'org.eclipse.gmf.runtime.emf.type.core.IElementType') FOR diagram» relationshipTypes) {
«««				super(title, description, null, null);
«««				this.relationshipTypes = relationshipTypes;
«««			}
	
«««			«xpt::Common::generatedMemberComment»
«««			public org.eclipse.gef.Tool createTool() {
«««				org.eclipse.gef.Tool tool = new org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool(relationshipTypes);
«««				tool.setProperties(getToolProperties());
«««				return tool;
«««			}
«««		}
«««	'''
*/
	def setIdentity(EntryBase it, String toolVarName) '''
		«IF id != null && id.length != 0»
«««		«toolVarName».setId(«id»);«IF id.isQuoted('\"')»«xpt::Common::nonNLS»«ENDIF»
		«ENDIF»
	'''

}
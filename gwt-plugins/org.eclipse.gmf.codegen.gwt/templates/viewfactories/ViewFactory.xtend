package viewfactories

import common.BaseClassTemplate
import diagram.MetaModel
import diagram.ViewmapAttributesUtilsHelper
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.OpenDiagramBehaviour
import org.eclipse.gmf.codegen.gmfgen.SharedBehaviour

class ViewFactory extends BaseClassTemplate<GenCommonBase> {
	
	extension MetaModel = new MetaModel
	extension ViewmapAttributesUtilsHelper = new ViewmapAttributesUtilsHelper 

	override generate(GenCommonBase it) '''
«««		«xpt::Common::copyright FOR getDiagram().editorGen»
		package «getDiagram().notationViewFactoriesPackageName»;

		«generatedClassComment»
		public class «notationViewFactoryClassName» «supertypes» {
			«body»
		}
	'''
	
	override protected body(GenCommonBase it) '''
		«instanceDeclaration»
		«decorateView»
		«predefinedChildren»
		«additions»
	'''

	override qualifiedClassName(GenCommonBase it) { notationViewFactoryQualifiedClassName }
	
	override supertypes(GenCommonBase it) 
		'''implements org.eclipse.gmf.runtime.gwt.services.IViewDecorator'''
	
	def instanceDeclaration(GenCommonBase it) '''
		«generatedMemberComment»
		public static «notationViewFactoryClassName» INSTANCE = new «notationViewFactoryClassName»();
	'''
	
	def decorateView(GenCommonBase it) '''
		«generatedMemberComment»
		public void decorateView(org.eclipse.gmf.runtime.notation.View view) {
			if (view.eIsSet(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getView_Type())) {
				return;
			}
			«setViewType»
			«initStyles»
			«FOR s: styles»«s.addCustomStyle»«ENDFOR»
			«instantiatePredefinedChildren»
			«createOpenDiagramAnnotation»
		}
	'''
	
	def addCustomStyle(GenClass it) '''
		view.getStyles().add(«newInstance»);
	'''

	def dispatch setViewType(GenCommonBase it) '''
		view.setType(«getDiagram().getVisualIDRegistryQualifiedClassName()».getType(«getEditPartQualifiedClassName()».VISUAL_ID));
	'''
	
	def dispatch setViewType(GenDiagram it) '''
		view.setType(«getDiagram().getEditPartQualifiedClassName()».MODEL_ID);
	'''
	
	def dispatch initStyles(GenCommonBase it) ''''''

	def dispatch initStyles(GenDiagram it) '''
		org.eclipse.gmf.runtime.notation.DiagramStyle style = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagramStyle();
		view.getStyles().add(style);
	'''

	def dispatch initStyles(GenNode it) '''
		«IF viewmap.isFixedFont() || (viewmap.isFixedForeground() || viewmap.isFixedBackground())»
			«IF !viewmap.isFixedFont()»
			org.eclipse.gmf.runtime.notation.FontStyle fontStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFontStyle();
			«initFontStyle('fontStyle')»
			view.getStyles().add(fontStyle);
			«ENDIF»
			«IF !viewmap.isFixedForeground()»
			org.eclipse.gmf.runtime.notation.LineStyle lineStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLineStyle();
			«initLineStyle('lineStyle')»
			view.getStyles().add(lineStyle);
			«ENDIF»
			«IF !viewmap.isFixedBackground()»
			org.eclipse.gmf.runtime.notation.FillStyle fillStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFillStyle();
			«initFillStyle('fillStyle')»
			view.getStyles().add(fillStyle);
			«ENDIF»
		«ELSE»
			org.eclipse.gmf.runtime.notation.ShapeStyle style = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShapeStyle();
			«initFontStyle('style')»
			«initLineStyle('style')»
			«initFillStyle('style')»
			view.getStyles().add(style);
		«ENDIF»
	'''
	
	def dispatch initStyles(GenChildLabelNode it) '''
		«IF !viewmap.isFixedFont()»
			org.eclipse.gmf.runtime.notation.FontStyle style = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFontStyle();
			«initFontStyle('style')»
			view.getStyles().add(style);
		«ENDIF»
	'''
	
	def dispatch initStyles(GenCompartment it) '''
		org.eclipse.gmf.runtime.notation.DrawerStyle drawerStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDrawerStyle();
		view.getStyles().add(drawerStyle);
		org.eclipse.gmf.runtime.notation.TitleStyle titleStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createTitleStyle();
		view.getStyles().add(titleStyle);
	'''
	
	def dispatch initStyles(GenLink it) '''
		«IF !viewmap.isFixedFont()»
			org.eclipse.gmf.runtime.notation.FontStyle fontStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFontStyle();
			«initFontStyle('fontStyle')»
			view.getStyles().add(fontStyle);
		«ENDIF»
		«IF !viewmap.isFixedForeground()»
			org.eclipse.gmf.runtime.notation.LineStyle lineStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLineStyle();
			«initLineStyle('lineStyle')»
			view.getStyles().add(lineStyle);
		«ENDIF»
		«IF !viewmap.isFixedBackground()»
			org.eclipse.gmf.runtime.notation.FillStyle fillStyle = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFillStyle();
			«initFillStyle('fillStyle')»
			view.getStyles().add(fillStyle);
		«ENDIF»
	'''
	
	def dispatch initStyles(GenLinkLabel it) '''
		«initLocation»
	'''

	def dispatch initStyles(GenExternalNodeLabel it) '''
		«initLocation»
	'''
	
	def initLocation(GenLabel it) {
		val x = labelOffsetX(viewmap, 0)
		val y = labelOffsetY(viewmap, 0)
		
		'''
		org.eclipse.gmf.runtime.notation.Location location = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLocation();
		«IF x != 0»
		location.setX(«x»);
		«ENDIF»
	
		«IF y != 0»
		location.setY(«y»);
		«ENDIF»
		((org.eclipse.gmf.runtime.notation.Node)view).setLayoutConstraint(location);
		'''
	}
	
	def dispatch instantiatePredefinedChildren(GenCommonBase it) ''''''
	
	def dispatch instantiatePredefinedChildren(GenNode it) '''
		«FOR l: labels»«l.instantiatePredefinedChildLabel»«ENDFOR»
		«FOR c: compartments»«c.instantiatePredefinedChildCompartment»«ENDFOR»
	'''
	
	def instantiatePredefinedChildCompartment(GenCompartment it) '''
		create«visualID»Compartment(view);
	'''
	
	def instantiatePredefinedChildLabel(GenLabel it) '''
		create«visualID»Label(view);
	'''

	def dispatch instantiatePredefinedChildren(GenChildLabelNode it) '''
	'''
	
	def dispatch instantiatePredefinedChildren(GenLink it) '''
		«FOR l: labels»«l.instantiatePredefinedChildLabel»«ENDFOR»
	'''
	
	def dispatch predefinedChildren(GenCommonBase it) '''
	'''
	
	def dispatch predefinedChildren(GenNode it) '''
		«FOR l: labels»«l.predefinedChildLabel»«ENDFOR»
		«FOR c: compartments»«c.predefinedChildCompartment»«ENDFOR»
	'''
	
	def dispatch predefinedChildren(GenChildLabelNode it) '''
	'''
	
	def predefinedChildCompartment(GenCompartment it) '''
		«generatedMemberComment»
		private void create«visualID»Compartment(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.gmf.runtime.notation.Node compartment = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();
			view.getPersistedChildren().add(compartment);
			«getNotationViewFactoryQualifiedClassName()».INSTANCE.decorateView(compartment);
		}
	'''
	
	def predefinedChildLabel(GenLabel it) '''
		«generatedMemberComment»
		private void create«visualID»Label(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.gmf.runtime.notation.Node label = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();
			view.getPersistedChildren().add(label);
			«getNotationViewFactoryQualifiedClassName()».INSTANCE.decorateView(label);
		}
	'''
	
	def dispatch predefinedChildren(GenLink it) '''
		«FOR l: labels»«l.predefinedChildLabel»«ENDFOR»
	'''
	
	def dispatch createOpenDiagramAnnotation(GenCommonBase it) {
		val openDiagramBehaviours = openDiagramBehaviours
		val kinds = openDiagramBehaviours.map[it | diagramKind]
		'''
			«IF openDiagramBehaviours.size() == 1»
			org.eclipse.gmf.runtime.notation.HintedDiagramLinkStyle diagramFacet = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createHintedDiagramLinkStyle();
			«IF !kinds.nullOrEmpty»
			diagramFacet.setHint("«kinds.head»");
			«ENDIF»
			view.getStyles().add(diagramFacet);
			«ENDIF»
		'''
	}
	
	def dispatch createOpenDiagramAnnotation(GenDiagram it) '''
	'''
	
	def initFontStyle(GenCommonBase it, String styleVar) '''
«««		org.eclipse.swt.graphics.FontData defaultFontData = org.eclipse.jface.preference.PreferenceConverter.getFontData(«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore(), org.eclipse.gmf.runtime.gwt.preferences.IPreferenceConstants.DEFAULT_FONT);
		org.eclipse.swt.graphics.FontData defaultFontData = new org.eclipse.swt.graphics.FontData();
		«styleVar».setFontName(defaultFontData.getName());
		«styleVar».setFontHeight(defaultFontData.getHeight());
		«styleVar».setBold((defaultFontData.getStyle() & org.eclipse.swt.SWT.BOLD) != 0);
		«styleVar».setItalic((defaultFontData.getStyle() & org.eclipse.swt.SWT.ITALIC) != 0);

«««		org.eclipse.swt.graphics.RGB defaultFontColor = org.eclipse.jface.preference.PreferenceConverter.getColor(«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore(), org.eclipse.gmf.runtime.gwt.preferences.IPreferenceConstants.FONT_COLOR);
		org.eclipse.swt.graphics.RGB defaultFontColor = new org.eclipse.swt.graphics.RGB(100, 100, 100);
		«styleVar».setFontColor((defaultFontColor.blue << 16) | (defaultFontColor.green << 8) | defaultFontColor.red);
	'''

	def initLineStyle(GenCommonBase it, String styleVar) '''
«««		org.eclipse.swt.graphics.RGB defaultLineColor = org.eclipse.jface.preference.PreferenceConverter.getColor(«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore(), org.eclipse.gmf.runtime.gwt.preferences.IPreferenceConstants.LINE_COLOR);
		org.eclipse.swt.graphics.RGB defaultLineColor = new org.eclipse.swt.graphics.RGB(100, 100, 100);
		«styleVar».setLineColor((defaultLineColor.blue << 16) | (defaultLineColor.green << 8) | defaultLineColor.red);
	'''

	def initFillStyle(GenCommonBase it, String styleVar) '''
«««		org.eclipse.swt.graphics.RGB defaultFillColor = org.eclipse.jface.preference.PreferenceConverter.getColor(«getDiagram().editorGen.plugin.getActivatorQualifiedClassName()».getInstance().getPreferenceStore(), org.eclipse.gmf.runtime.gwt.preferences.IPreferenceConstants.FILL_COLOR);
		org.eclipse.swt.graphics.RGB defaultFillColor = new org.eclipse.swt.graphics.RGB(100, 100, 100);
		«styleVar».setFillColor((defaultFillColor.blue << 16) | (defaultFillColor.green << 8) | defaultFillColor.red);
	'''

	private def openDiagramBehaviours(GenCommonBase it) {
		behaviour.filter(OpenDiagramBehaviour) +
		behaviour.filter(SharedBehaviour).map[it | delegate].filter(OpenDiagramBehaviour)
	}

}
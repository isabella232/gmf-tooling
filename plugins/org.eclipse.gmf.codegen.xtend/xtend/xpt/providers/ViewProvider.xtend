/**
 * Copyright (c) 2007, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Artem Tikhomirov (Borland) - [257119] Create views directly, not through ViewFactories
 * 	  Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.providers

import com.google.inject.Inject
import org.eclipse.gmf.codegen.gmfgen.ColorAttributes
import org.eclipse.gmf.codegen.gmfgen.ElementType
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkLabel
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode
import org.eclipse.gmf.codegen.gmfgen.MetamodelType
import org.eclipse.gmf.codegen.gmfgen.NotationType
import org.eclipse.gmf.codegen.gmfgen.SpecializationType
import xpt.Common
import xpt.Common_qvto
import xpt.diagram.Utils_qvto
import xpt.diagram.ViewmapAttributesUtils_qvto
import xpt.diagram.editpolicies.LinkUtils_qvto
import xpt.diagram.views.ViewStyles
import xpt.editor.VisualIDRegistry
import xpt.QualifiedClassNameProvider
import org.eclipse.gmf.runtime.notation.FontStyle
import org.eclipse.gmf.runtime.notation.LineStyle
import org.eclipse.gmf.runtime.notation.FillStyle
import org.eclipse.gmf.runtime.notation.Style

class ViewProvider {
	@Inject extension Common;
	@Inject extension Common_qvto;
	@Inject extension QualifiedClassNameProvider;
	
	@Inject extension Utils_qvto;
	@Inject extension LinkUtils_qvto;
	@Inject extension ViewmapAttributesUtils_qvto;
	
	@Inject VisualIDRegistry xptVisualIDRegistry;
	@Inject ViewStyles xptViewStyles;
	
	def className(GenDiagram it) '''«it.notationViewProviderClassName»'''

	def packageName(GenDiagram it) '''«it.providersPackageName»'''

	def qualifiedClassName(GenDiagram it) '''«packageName(it)».«className(it)»'''
	
	def fullPath(GenDiagram it) '''«qualifiedClassName(it)»'''
	
	def extendsList(GenDiagram it) ''' extends org.eclipse.gmf.runtime.common.core.service.AbstractProvider'''
	def implementsList(GenDiagram it) ''' implements org.eclipse.gmf.runtime.diagram.core.providers.IViewProvider'''

	
	def ViewProvider(GenDiagram it) '''
	«copyright(editorGen)»
	package «packageName(it)»;
	
	«generatedClassComment»
	public class «className(it)» «extendsList(it)»«implementsList(it)» {
	
		«generatedMemberComment»
		public final boolean provides(org.eclipse.gmf.runtime.common.core.service.IOperation operation) {
			if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) {
				return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation) operation);
			}
			«_assert('operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewOperation')»
			if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) {
				return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation) operation);
			} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) {
				return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation) operation);
			} else if (operation instanceof org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) {
				return provides((org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation) operation);
			}
			return false;
		}
	
		«generatedMemberComment»
		protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateViewForKindOperation op) {
	/*
			if (op.getViewKind() == Node.class)
				return getNodeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
			if (op.getViewKind() == Edge.class)
				return getEdgeViewClass(op.getSemanticAdapter(), op.getContainerView(), op.getSemanticHint()) != null;
	*/
			return true;
		}
	
		«generatedMemberComment»«/* When diagram domain element is null only diagram kind is checked */»
		protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateDiagramViewOperation op) {
			return «VisualIDRegistry::modelID(it)».equals(op.getSemanticHint())«IF domainDiagramElement != null» && «xptVisualIDRegistry.getDiagramVisualIDMethodCall(it)»(getSemanticElement(op.getSemanticAdapter())) != -1«ENDIF»;
		}
	
		«generatedMemberComment»
		protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateNodeViewOperation op) {
			if (op.getContainerView() == null) {
				return false;
			}
			org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
			org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
			int visualID;
			if (op.getSemanticHint() == null) {
				// Semantic hint is not specified. Can be a result of call from CanonicalEditPolicy.
				// In this situation there should be NO elementType, visualID will be determined
				// by VisualIDRegistry.getNodeVisualID() for domainElement.
				if (elementType != null || domainElement == null) {«/* XXX Perhaps, better to fix CanonicalEP instead of this hack? */»
					return false;
				}
				visualID = «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(op.getContainerView(), domainElement);
			} else {
				visualID = «xptVisualIDRegistry.getVisualIDMethodCall(it)»(op.getSemanticHint());
				if (elementType != null) {«/*
					Semantic hint is specified together with element type.
					Both parameters should describe exactly the same diagram element.
					In addition we check that visualID returned by VisualIDRegistry.getNodeVisualID() for
					domainElement (if specified) is the same as in element type. */»
					if (!«getElementTypesQualifiedClassName(it)».isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
						return false; // foreign element type
					}
					String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
					if (!op.getSemanticHint().equals(elementTypeHint)) {
						return false; // if semantic hint is specified it should be the same as in element type
					}
					if (domainElement != null && visualID != «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(op.getContainerView(), domainElement)) {
						return false; // visual id for node EClass should match visual id from element type
					}
				} else {«/*
					Element type is not specified. Domain element should be present (except pure design elements).
					 This method is called with EObjectAdapter as parameter from:
					   - ViewService.createNode(View container, EObject eObject, String type, PreferencesHint preferencesHint) 
					   - generated ViewFactory.decorateView() for parent element */»
			«IF getAllTypedElements().filter[e | e.elementType != null].notEmpty»
					if (!«VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»(op.getContainerView()))) {
						return false; // foreign diagram
					}
					switch (visualID) {
				«IF getAllNodes().exists[e|e.elementType.oclIsKindOf(typeof(NotationType))]»
					«FOR e : getAllNodes().map[e|e.elementType].filter(typeof(NotationType))»
					«localCaseVisualID(e)»
					«ENDFOR»
						break; // pure design element
				«ENDIF»
				«IF getAllNodes().exists[e|e.elementType.oclIsKindOf(typeof(MetamodelType)) || e.elementType.oclIsKindOf(typeof(SpecializationType))]»
					«FOR e : getAllNodes().map[e|e.elementType].filter(typeof(MetamodelType))»
					«localCaseVisualID(e)»
					«ENDFOR»
					«FOR e : getAllNodes().map[e|e.elementType].filter(typeof(SpecializationType))»
					«localCaseVisualID(e)»
					«ENDFOR»
						if (domainElement == null || visualID != «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(op.getContainerView(), domainElement)) {
							return false; // visual id in semantic hint should match visual id for domain element
						}
						break;«/*FIXME: Perhaps, can return true or false right away, without any further check?*/»
				«ENDIF»
					default:
						return false;
					}
			«ELSE»
					return false;
			«ENDIF»
				}
			}
			return «FOR n : getAllNodes() SEPARATOR '||'»«VisualIDRegistry::visualID(n)» == visualID«ENDFOR»;
		}
	
		«generatedMemberComment»«/* XXX: unlike createNode, we don't check op.containerView() for null here. On purpose? */»
		protected boolean provides(org.eclipse.gmf.runtime.diagram.core.services.view.CreateEdgeViewOperation op) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(op.getSemanticAdapter());
			if (!«getElementTypesQualifiedClassName(it)».isKnownElementType(elementType) || (!(elementType instanceof org.eclipse.gmf.runtime.emf.type.core.IHintedType))) {
				return false; // foreign element type
			}
			String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
			if (elementTypeHint == null || (op.getSemanticHint() != null && !elementTypeHint.equals(op.getSemanticHint()))) {
				return false; // our hint is visual id and must be specified, and it should be the same as in element type
			}
			int visualID = «xptVisualIDRegistry.getVisualIDMethodCall(it)»(elementTypeHint);
			org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(op.getSemanticAdapter());
			if (domainElement != null && visualID != «xptVisualIDRegistry.getLinkWithClassVisualIDMethodCall(it)»(domainElement)) {
				return false; // visual id for link EClass should match visual id from element type
			}
			return true; «/* Does it make sense to check visualID here, like we did for nodes? */»
		}
	
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.notation.Diagram createDiagram(org.eclipse.core.runtime.IAdaptable semanticAdapter, String diagramKind, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
			org.eclipse.gmf.runtime.notation.Diagram diagram = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagram();«/* FIXME instantiate diagramRunTimeClass instead */»
			diagram.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDiagramStyle());
			«xptViewStyles.addCustomStyles(it, 'diagram.getStyles()')»
			diagram.setType(«VisualIDRegistry::modelID(it)»);
			diagram.setElement(«IF domainDiagramElement != null»getSemanticElement(semanticAdapter)«ELSE»null«ENDIF»);
		«IF units != null»
			diagram.setMeasurementUnit(org.eclipse.gmf.runtime.notation.MeasurementUnit.«units.toUpperCase»_LITERAL);
		«ENDIF»
		«IF styles.notEmpty»
			// initializeFromPreferences
			org.eclipse.jface.preferences.IPreferenceStore store = (org.eclipse.jface.preferences.IPreferenceStore) preferencesHint.getPreferenceStore();
			«initializeStyles(it, 'diagram', 'store', false, false, false)»
		«ENDIF»
			return diagram;
		}
	
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.notation.Node createNode(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
			final org.eclipse.emf.ecore.EObject domainElement = getSemanticElement(semanticAdapter);
			final int visualID;
			if (semanticHint == null) {
				visualID = «xptVisualIDRegistry.getNodeVisualIDMethodCall(it)»(containerView, domainElement);
			} else {
				visualID = «xptVisualIDRegistry.getVisualIDMethodCall(it)»(semanticHint);
			}
			switch(visualID) {
			«FOR n : getAllNodes()»
			«caseVisualID(n)»
				return create«n.uniqueIdentifier»(domainElement, containerView, index, persisted, preferencesHint);
			«ENDFOR»
			}
			// can't happen, provided #provides(CreateNodeViewOperation) is correct
			return null;
		}
	
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.notation.Edge createEdge(org.eclipse.core.runtime.IAdaptable semanticAdapter, org.eclipse.gmf.runtime.notation.View containerView, String semanticHint, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
			org.eclipse.gmf.runtime.emf.type.core.IElementType elementType = getSemanticElementType(semanticAdapter);
			String elementTypeHint = ((org.eclipse.gmf.runtime.emf.type.core.IHintedType) elementType).getSemanticHint();
			switch («xptVisualIDRegistry.getVisualIDMethodCall(it)»(elementTypeHint)) {
			«FOR link : links»
			«caseVisualID(link)»
				return create«link.uniqueIdentifier»(«IF link.isTypeLink()» getSemanticElement(semanticAdapter), «ENDIF»containerView, index, persisted, preferencesHint);
			«ENDFOR»
			}
			// can never happen, provided #provides(CreateEdgeViewOperation) is correct
			return null;
		}
	
		«FOR next : getAllNodes()»
			«createNodeMethod(next)»
		«ENDFOR»
		«FOR next : links»
			«createEdgeMethod(next)»
		«ENDFOR»
	
		«IF topLevelNodes.notEmpty»
			«generatedMemberComment»
			private void stampShortcut(org.eclipse.gmf.runtime.notation.View containerView, org.eclipse.gmf.runtime.notation.Node target) {
				if (!«VisualIDRegistry::modelID(it)».equals(«xptVisualIDRegistry.getModelIDMethodCall(it)»(containerView))) {
					«addShortcutAnnotation(it, 'target')»
				}
			}
		«ENDIF»
	
		«IF links.map[l|l.labels].flatten.notEmpty || topLevelNodes.map[n|n.labels].flatten.notEmpty || childNodes.map[n|n.labels].flatten.notEmpty»
			«generatedMemberComment»
			private org.eclipse.gmf.runtime.notation.Node createLabel(org.eclipse.gmf.runtime.notation.View owner, String hint) {
				org.eclipse.gmf.runtime.notation.DecorationNode rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();
				rv.setType(hint);
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);
				return rv;
			}
		«ENDIF»
	
		«IF getAllNodes().map[n|n.compartments].flatten.notEmpty»
			«generatedMemberComment»
			private org.eclipse.gmf.runtime.notation.Node createCompartment(org.eclipse.gmf.runtime.notation.View owner, String hint, boolean canCollapse, boolean hasTitle, boolean canSort, boolean canFilter) {
				//SemanticListCompartment rv = NotationFactory.eINSTANCE.createSemanticListCompartment();
				//rv.setShowTitle(showTitle);
				//rv.setCollapsed(isCollapsed);
				org.eclipse.gmf.runtime.notation.Node rv;
				if (canCollapse) {
					rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBasicCompartment();
				} else {
					rv = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDecorationNode();
				}
				if (hasTitle) {
					org.eclipse.gmf.runtime.notation.TitleStyle ts = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createTitleStyle();
					ts.setShowTitle(true);
					rv.getStyles().add(ts);
				}
				if (canSort) {
					rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createSortingStyle());
				}
				if (canFilter) {
					rv.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFilteringStyle());
				}
				rv.setType(hint);
				org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(owner, rv, org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.APPEND, true);
				return rv;
			}
		«ENDIF»

		«getSemanticElementMethod(it)»
		«getSemanticElementTypeMethod(it)»
		«additions(it)»
	}
	'''

	def dispatch createNodeMethod(GenNode it) '''
	«generatedMemberComment»
	public org.eclipse.gmf.runtime.notation.Node create«uniqueIdentifier»(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
		«IF viewmap.canUseShapeStyle()»
		org.eclipse.gmf.runtime.notation.Shape node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShape();
		«ELSE»
		org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();
		node.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createDescriptionStyle());«/* FIXME Contionally add this style, whether toolsmith needs Notes or not */»
		«xptViewStyles.addFontLineFillStylesConditionally(it.viewmap, 'node.getStyles()')»
		«ENDIF»
		«xptViewStyles.addLinkedDiagramStyle(it, 'node.getStyles()')»
		«xptViewStyles.addCustomStyles(it, 'node.getStyles()')»
		node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());
		node.setType(«xptVisualIDRegistry.typeMethodCall(it)»);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);
		node.setElement(domainElement);
		«IF it.oclIsKindOf(typeof(GenTopLevelNode))»
		stampShortcut(containerView, node);
		«ENDIF»
		// initializeFromPreferences «/* XXX Perhaps, do init only once, for complete figure? */»
		final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
		«initializeStyles(it, 'node', 'prefStore', !viewmap.isFixedForeground(), !viewmap.isFixedBackground(), !viewmap.isFixedFont())»
		«FOR label : it.labels»
		«initLabel(label, 'node', 'prefStore')»
		«ENDFOR»
		«FOR comp : it.compartments»
		«initCompartment(comp, 'node', 'prefStore')»
		«ENDFOR»
		return node;
	}
	'''

	// Location as layoutConstraint, no children
	def dispatch createNodeMethod(GenChildLabelNode it) '''
		«generatedMemberComment»
		public org.eclipse.gmf.runtime.notation.Node create«uniqueIdentifier»(org.eclipse.emf.ecore.EObject domainElement, org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
			org.eclipse.gmf.runtime.notation.Node node = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createNode();
			node.setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLocation());«/* [artem] XXX not sure, why LabelNode needs location */»
			«xptViewStyles.addLinkedDiagramStyle(it, 'node.getStyles()')»
			«xptViewStyles.addCustomStyles(it, 'node.getStyles()')»
			node.setType(«xptVisualIDRegistry.typeMethodCall(it)»);
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, node, index, persisted);
			node.setElement(domainElement);
			«IF styles.notEmpty»
				final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
				«initializeStyles(it, 'node', 'prefStore', false, false, false)»
			«ENDIF»
			return node;
		}
	'''

	// looks for Font/Line/Fill styles in customStyles and initializes, if any (may be forced with boolean params)
	// params has*Style are to force respective style initialization (when callee knows certain style was added)  
	def initializeStyles(GenCommonBase it, String viewVar, String prefStoreVar, boolean hasLineStyle, boolean hasFillStyle, boolean hasFontStyle) '''
		«IF hasLineStyle || it.hasLineStyleInCustom()»
			«/* FIXME ColorAttributes is deprecated, should remove and clean the second branch of the disjunction */»
			«IF it.viewmap.isFixedForeground || it.viewmap.attributes.filter(typeof(ColorAttributes)).notEmpty»
				«xptViewStyles.foregroundColour(it.viewmap, viewVar)»
			«ELSE»
				«initForegroundFromPrefs(it, viewVar, prefStoreVar)»
			«ENDIF»
		«ENDIF»
		«IF (hasFontStyle || it.hasFontStyleInCustom()) && !viewmap.isFixedFont()»
				«initFontFromPrefs(it, viewVar, prefStoreVar)»
		«ENDIF»
		«IF hasFillStyle || it.hasFillStyleInCustom()»
			«IF viewmap.isFixedBackground() || viewmap.attributes.filter(typeof(ColorAttributes)).notEmpty»
				«xptViewStyles.backgroundColour(it.viewmap, viewVar)»
			«ELSE»
				«initBackgroundFromPrefs(it, viewVar, prefStoreVar)»
			«ENDIF»
		«ENDIF»
	'''

	/**
	 * FIXME check if there's need for a variable name, see initCompartment for a hint
	 */
	def initLabel(GenLabel it, String nodeVar, String prefStoreVar) '''
		«var String labelVar = 'label' + it.visualID»
		org.eclipse.gmf.runtime.notation.Node «labelVar» = createLabel(«nodeVar», «xptVisualIDRegistry.typeMethodCall(it)»);
		«xptViewStyles.addTextStyle(it.modelFacet, labelVar + '.getStyles()')»
		«xptViewStyles.addCustomStyles(it, labelVar + '.getStyles()')»
		«IF it.oclIsKindOf(typeof(GenExternalNodeLabel)) || it.oclIsKindOf(typeof(GenLinkLabel))»
			«labelVar».setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createLocation());
			«xptViewStyles.offset(it, labelVar)»
		«ENDIF»
		«initializeStyles(it, labelVar, prefStoreVar, false, false, false)»
	'''

	def initCompartment(GenCompartment it, String nodeVar, String prefStoreVar) '''
		«var String compartmentVar= 'compartment' + it.visualID»
		«IF it.styles.notEmpty || isStoringChildPositions(it.layoutType)»org.eclipse.gmf.runtime.notation.Node «compartmentVar» = «ENDIF»createCompartment(«nodeVar», «xptVisualIDRegistry.typeMethodCall(it)», «canCollapse», «needsTitle», «listLayout», «listLayout»);
		«xptViewStyles.addCustomStyles(it, compartmentVar + '.getStyles()')»
		«IF isStoringChildPositions(it.layoutType)»
			«IF viewmap.canUseShapeStyle()»
				«compartmentVar».add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createShapeStyle());
			«ELSE /* Intentionally not adding Description style, as it deemed to be useless for compartments (can't avoid for ShapeStyle - benefits of a single style overwheight drawbacks of Description presence) */»
				«xptViewStyles.addFontLineFillStylesConditionally(it.viewmap, compartmentVar + '.getStyles()')»
			«ENDIF»
			«compartmentVar».setLayoutConstraint(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createBounds());
			«initializeStyles(it, compartmentVar, prefStoreVar, !viewmap.isFixedForeground(), !viewmap.isFixedBackground(), !viewmap.isFixedFont())»
		«ELSE»
			«initializeStyles(it, compartmentVar, prefStoreVar, false, false, false)»
		«ENDIF»
	'''

	def initForegroundFromPrefs(GenCommonBase it, String viewVar, String prefStoreVar) '''
		org.eclipse.swt.graphics.RGB lineRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(«prefStoreVar», org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_COLOR);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(«viewVar», org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getLineStyle_LineColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(lineRGB));
	'''
	
	def initBackgroundFromPrefs(GenCommonBase it, String viewVar, String prefStoreVar) '''
		org.eclipse.swt.graphics.RGB fillRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(«prefStoreVar», org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_FILL_COLOR);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(«viewVar», org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getFillStyle_FillColor(), org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fillRGB));
	'''

	def initFontFromPrefs(GenCommonBase it, String viewVar, String prefStoreVar) '''
		org.eclipse.gmf.runtime.notation.FontStyle «viewVar»FontStyle = (org.eclipse.gmf.runtime.notation.FontStyle) «viewVar».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.Literals.FONT_STYLE);
		if («viewVar»FontStyle != null) {«/* Given this template is invoked only when FontStyle is present, no need to check fontStyle for null, but at least this gives a scope for fontData var */»
			org.eclipse.swt.graphics.FontData fontData = org.eclipse.jface.preference.PreferenceConverter.getFontData(«prefStoreVar», org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_DEFAULT_FONT);
			«viewVar»FontStyle.setFontName(fontData.getName());
			«viewVar»FontStyle.setFontHeight(fontData.getHeight());
			«viewVar»FontStyle.setBold((fontData.getStyle() & org.eclipse.swt.SWT.BOLD) != 0);
			«viewVar»FontStyle.setItalic((fontData.getStyle() & org.eclipse.swt.SWT.ITALIC) != 0);
			org.eclipse.swt.graphics.RGB fontRGB = org.eclipse.jface.preference.PreferenceConverter.getColor(«prefStoreVar», org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_FONT_COLOR);
			«viewVar»FontStyle.setFontColor(org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities.RGBToInteger(fontRGB).intValue());
		}
	'''


	def createEdgeMethod(GenLink it) '''
	«generatedMemberComment»
	public org.eclipse.gmf.runtime.notation.Edge create«uniqueIdentifier»(«IF it.isTypeLink()»org.eclipse.emf.ecore.EObject domainElement, «ENDIF»org.eclipse.gmf.runtime.notation.View containerView, int index, boolean persisted, org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint preferencesHint) {
	«IF viewmap.isFixedForeground()»
		org.eclipse.gmf.runtime.notation.Edge edge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createEdge();
		edge.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createRoutingStyle());
	«ELSE»
		org.eclipse.gmf.runtime.notation.Connector edge = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createConnector();
	«ENDIF»
	«IF !viewmap.isFixedFont()»
		edge.getStyles().add(org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createFontStyle());
	«ENDIF»
		«xptViewStyles.addCustomStyles(it, 'edge.getStyles()')»
		org.eclipse.gmf.runtime.notation.RelativeBendpoints bendpoints = org.eclipse.gmf.runtime.notation.NotationFactory.eINSTANCE.createRelativeBendpoints();
		java.util.ArrayList<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint> points = new java.util.ArrayList<org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint>(2); 
		points.add(new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint());
		points.add(new org.eclipse.gmf.runtime.notation.datatype.RelativeBendpoint());
		bendpoints.setPoints(points);
		edge.setBendpoints(bendpoints);
		org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.insertChildView(containerView, edge, index, persisted);
		edge.setType(«xptVisualIDRegistry.typeMethodCall(it)»);
		edge.setElement(«IF it.isTypeLink()»domainElement«ELSE»null«ENDIF»);
		// initializePreferences
		final org.eclipse.jface.preference.IPreferenceStore prefStore = (org.eclipse.jface.preference.IPreferenceStore) preferencesHint.getPreferenceStore();
		«initializeStyles(it, 'edge', 'prefStore', !viewmap.isFixedForeground(), false, !viewmap.isFixedFont())»
		org.eclipse.gmf.runtime.notation.Routing routing = org.eclipse.gmf.runtime.notation.Routing.get(prefStore.getInt(org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants.PREF_LINE_STYLE));
		if (routing != null) {
			org.eclipse.gmf.runtime.diagram.core.util.ViewUtil.setStructuralFeatureValue(edge, org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getRoutingStyle_Routing(), routing);
		}
		«FOR label : it.labels»
			«initLabel(label, 'edge', 'prefStore')»
		«ENDFOR»
		return edge;
	}
	'''

	def getSemanticElementMethod(GenDiagram it) '''
		«generatedMemberComment»
		private org.eclipse.emf.ecore.EObject getSemanticElement(org.eclipse.core.runtime.IAdaptable semanticAdapter) {
			if (semanticAdapter == null) {
				return null;
			}
			org.eclipse.emf.ecore.EObject eObject = (org.eclipse.emf.ecore.EObject) semanticAdapter.getAdapter(org.eclipse.emf.ecore.EObject.class);
			if (eObject != null) {
				return org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil.resolve(org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(eObject), eObject);
			}
			return null;
		}
	'''

	def getSemanticElementTypeMethod(GenDiagram it) '''
	«generatedMemberComment»
	private org.eclipse.gmf.runtime.emf.type.core.IElementType getSemanticElementType(org.eclipse.core.runtime.IAdaptable semanticAdapter) {
		if (semanticAdapter == null) {
			return null;
		}
		return (org.eclipse.gmf.runtime.emf.type.core.IElementType) semanticAdapter.getAdapter(org.eclipse.gmf.runtime.emf.type.core.IElementType.class);
	}
	'''

	def localCaseVisualID(ElementType elementType) '''
		«IF elementType.diagramElement != null»
		case «VisualIDRegistry::visualID(elementType.diagramElement)»:
		«ENDIF»
	'''

	def additions(GenDiagram it) ''''''
	
	def boolean hasFontStyleInCustom(GenCommonBase it) {
		return hasNotationStyleInCustomStyles(it, typeof(FontStyle));
	}

	def boolean hasLineStyleInCustom(GenCommonBase it) {
		return hasNotationStyleInCustomStyles(it, typeof(LineStyle));
	}

	def boolean hasFillStyleInCustom(GenCommonBase it) {
		return hasNotationStyleInCustomStyles(it, typeof(FillStyle));
	}

	/**
	 * check if there's notation::[styleType] among diagram element's custom styles
	 */
	def boolean hasNotationStyleInCustomStyles(GenCommonBase it, Class<? extends Style> styleType) {
		return it.styles.exists[s|s.ecoreClass.oclIsKindOf(styleType)];
	}
	

}

package diagram.parts

import com.google.inject.Inject
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenLink
import common.Common
import commands.CreateNotationalElementCommand
import diagram.LinkFinder
import diagram.MetaModel

class LinkNotationModelRefresher {

	extension Common = new Common
	extension MetaModel = new MetaModel
	extension LinkFinder = new LinkFinder 
	extension LinkNotationModelRefresherHelper = new LinkNotationModelRefresherHelper
	extension SemanticChildLinks = new SemanticChildLinks
	extension CreateNotationalElementCommand = new CreateNotationalElementCommand

	@Inject extension PartCommon

//	def installClause(GenCommonBase it) '''
//		«IF needsLinkNotationModelRefresher()»
//		installLinkNotationModelRefresher();
//		«ENDIF»
//	'''
	
//	def uninstallClause(GenCommonBase it) '''
//		«IF needsLinkNotationModelRefresher()»
//		uninstallLinkNotationModelRefresher();
//		«ENDIF»
//	'''
	
	def all(GenCommonBase it) '''
		«IF needsLinkNotationModelRefresher()»
«««		«install»
«««		«uninstall»
		«getLinkNotationModelRefresher»
		«viewService»
«««		«refresh»
		«generate»
		«ENDIF»
	'''
	
	def className(GenCommonBase it) '''LinkNotationModelRefresher'''
	
	def install(GenCommonBase it) '''
«««		«xpt::Common::generatedMemberComment»
		installRefresher(getLinkNotationModelRefresher());
«««		private void installLinkNotationModelRefresher() {
«««			«className» refresher = getLinkNotationModelRefresher();
«««			if (!getTransactionalUpdateManager().isNotationModelRefresherInstalled(refresher)) {
«««				getTransactionalUpdateManager().addNotationModelRefresher(refresher);
«««				try {
«««					refreshLinkNotationModel();
«««				} catch (java.lang.IllegalStateException readOnlyContext) {
«««					//Most likely, this means that the host element was created in a precommit notification of a transaction.
«««					//While it is impossible to execute this command here, it will be executed as a trigger command.
«««					//See org.eclipse.gmf.runtime.gwt.edit.parts.update.TransactionalUpdateManager for details.
«««				}
«««			}
«««		}
	'''
	
	def uninstall(GenCommonBase it) '''
«««		«xpt::Common::generatedMemberComment»
«««		private void uninstallLinkNotationModelRefresher() {
«««			«className» refresher = getLinkNotationModelRefresher();
«««			getTransactionalUpdateManager().removeNotationModelRefresher(refresher);
«««		}
	'''
	
	def getLinkNotationModelRefresher(GenCommonBase it) '''
		«generatedMemberComment»
		private «className» linkNotationModelRefresher = null;

		«generatedMemberComment»
		private «className» getLinkNotationModelRefresher() {
			if (linkNotationModelRefresher == null) {
				linkNotationModelRefresher = new «className»(this, getViewService());
			}
			return linkNotationModelRefresher;
		}
	'''
	
	def viewService(GenCommonBase it) '''
		«generatedMemberComment('Service to find a notational element that corresponds to the given underlying domain element.')»
		private org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.IViewService viewService;

		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.IViewService getViewService() {
			if (viewService == null) {
				viewService = new org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.EditPartRegistryBasedViewService(getViewer());
			}
			return viewService;
		}
	'''
	
	protected def refresh(GenCommonBase it) '''
		«generatedMemberComment»
		protected void refreshLinkNotationModel() {
			«className» linkRefresher = getLinkNotationModelRefresher();
			org.eclipse.emf.common.command.Command command = linkRefresher.buildRefreshNotationModelCommand();
			if (command == null) {
				return;
			}
			org.eclipse.emf.transaction.TransactionalEditingDomain domainModelEditDomain = org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(«getDiagramElementCode»);
			getViewer().getEditDomain().getCommandStack().execute(new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domainModelEditDomain, command));
		}
	'''

	def generate(GenCommonBase it) '''
		«generatedClassComment»
		private class «className» «supertypes» {

			«ctors»
			«getConstrainedChildrenFilter»
			«createUncontainedLinksFilter»
«««			«createFilter»
			«shouldRefresh»
			«getSemanticLinks»
			«getNotationalLinks»
			«getCreateNotationalElementCommand»
			«shouldCreateView»
«««			«getHost»
			«additions»

		}
	'''

	def supertypes(GenCommonBase it) '''extends org.eclipse.gmf.runtime.gwt.edit.parts.OwnedLinksNotationModelRefresher'''

	def ctors(GenCommonBase it) '''
		«generatedMemberComment»
		public «className»(org.eclipse.gef.editparts.AbstractGraphicalEditPart part, org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.IViewService viewService) {
			super(part, viewService);
		}
	'''
	
	def getConstrainedChildrenFilter(GenCommonBase it) '''
		«IF containedLinksWithSelector.size() > 0»
«««		«xpt::Common::generatedMemberComment('TODO: Child links of this element are selected based on constraint declared in ' + getDiagram().getVisualIDRegistryQualifiedClassName() + '. \n' + 
«««		'Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in \n' + 
«««		'notational model having to be updated.\n' + 
«««		'<p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications\n' + 
«««		'result in such an update.')»
		private org.eclipse.emf.transaction.NotificationFilter getConstrainedChildLinksFilter() {
			return org.eclipse.emf.transaction.NotificationFilter.NOT_TOUCH;
		}
		«ENDIF»
	'''
	
	def dispatch createUncontainedLinksFilter(GenCommonBase it) '''
	'''
	
	def dispatch createUncontainedLinksFilter(GenDiagram it) '''
		«generatedMemberComment('Creates a notification filter which filters notifications that may possibly result in uncontained links. ')»
		private org.eclipse.emf.transaction.NotificationFilter createUncontainedLinksFilter() {
			return org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.SET).or(
				org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.UNSET).or(
				org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.REMOVE).or(
				org.eclipse.emf.transaction.NotificationFilter.createEventTypeFilter(org.eclipse.emf.common.notify.Notification.REMOVE_MANY)
			)));
		}
	'''
	
	def shouldRefresh(GenCommonBase it) '''
		«generatedMemberComment»
		@Override
		public boolean shouldRefresh(org.eclipse.emf.common.notify.Notification notification) {
			«val affectingFeatures = affectingFeatures»
			«FOR feature: affectingFeatures»
			if («createFeatureFilter(feature)») {
				return true;
			}
			«ENDFOR»
«««			«IF containedLinksWithSelector.size() > 0»
«««			TODO
«««			«ENDIF»
			return false;
		}
	'''
	
	def createFilter(GenCommonBase it) '''
«««		«xpt::Common::generatedMemberComment('Creates a notification filter which filters notifications that may possibly affect the notational model')»
«««		protected org.eclipse.emf.transaction.NotificationFilter createFilter() {
«««		«LET getAffectingFeatures AS affectingFeatures»
«««		«FOREACH affectingFeatures AS nextFeature ITERATOR it»
«««			«IF it.isFirstIteration()»org.eclipse.emf.transaction.NotificationFilter filter = «createFeatureFilter FOR nextFeature»;«ELSE»
«««			filter = filter.or(«createFeatureFilter FOR nextFeature»);«ENDIF»
«««		«ENDFOREACH»
«««		«IF containedLinksWithSelector.size() > 0»
«««			«IF affectingFeatures.size() > 0»
«««			filter = getConstrainedChildLinksFilter().or(filter);
«««			«ELSE»
«««			org.eclipse.emf.transaction.NotificationFilter filter = getConstrainedChildLinksFilter();
«««			«ENDIF»
«««		«ENDIF»
«««		«IF (Sequence { self })[gmfgen::GenDiagram].size() > 0»
«««			«IF affectingFeatures.size() + containedLinksWithSelector.size() > 0»
«««			filter = filter.or(createUncontainedLinksFilter());
«««			«ELSE»
«««			org.eclipse.emf.transaction.NotificationFilter filter = createUncontainedLinksFilter();
«««			«ENDIF»
«««		«ELSE»
«««			«REM»Make sure filter var is declared«ENDREM»
«««			«IF affectingFeatures.size() + containedLinksWithSelector.size() = 0»
«««			org.eclipse.emf.transaction.NotificationFilter filter = org.eclipse.emf.transaction.NotificationFilter.NOT_TOUCH;
«««			«ENDIF»
«««		«ENDIF»
«««		«ENDLET»
«««			return filter;
«««		}
	'''
	
	def createFeatureFilter(GenFeature it) 
//		'''org.eclipse.emf.transaction.NotificationFilter.createFeatureFilter(«metaFeature»)'''
		'''«metaFeature».equals(notification.getFeature())'''
	
	def getSemanticLinks(GenCommonBase it) '''
		«generatedMemberComment»
		protected java.util.List<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor> getSemanticChildLinks() {
			«semanticChildLinks('getHost()')»
		}
	'''
	
	def getNotationalLinks(GenCommonBase it) '''
		«generatedMemberComment»
		protected java.util.List getNotationalChildLinks() {
			java.util.List result = new java.util.LinkedList();
			java.util.List allLinks = «getDiagramCode».getEdges();
			for(java.util.Iterator it = allLinks.iterator(); it.hasNext(); ) {
				org.eclipse.gmf.runtime.notation.Edge next = (org.eclipse.gmf.runtime.notation.Edge) it.next();
				«uncontainedLinks»
				«containedFeatureModelLinks»
				«containedTypeModelLinks»
			}
			return result;
		}
	'''
	
	def uncontainedLinks(GenCommonBase it) ''''''
	
	def uncontainedLinks(GenDiagram it) '''
		if (next.isSetElement() && next.getElement() != null && next.getElement().eResource() == null) {
			result.add(next);
			continue;
		}
		org.eclipse.gmf.runtime.notation.View source = next.getSource();
		if (source == null || (source.isSetElement() && source.getElement() != null && source.getElement().eResource() == null)) {
			result.add(next);
			continue;
		}
		org.eclipse.gmf.runtime.notation.View target = next.getTarget();
		if (target == null || (target.isSetElement() && target.getElement() != null && target.getElement().eResource() == null)) {
			result.add(next);
			continue;
		}
	'''
	
	def containedFeatureModelLinks(GenCommonBase it) '''
		«IF containedFeatureModelFacetLinks.size() > 0»
		if (next.isSetElement() && next.getElement() == null) {
			if (next.getSource() == getHost()) {
				int linkVID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(next);
				switch (linkVID) {
				«FOR v: containedFeatureModelFacetLinks»«caseVisualId(v)»«ENDFOR»
					result.add(next);
					break;
				}
			}
		}
		«ENDIF»
	'''
	
	def containedTypeModelLinks(GenCommonBase it) '''
		«IF containedTypeModelFacetLinks.size() > 0»
		if (next.isSetElement() && next.getElement() != null) {
			if (next.getElement().eContainer() == «getViewCode».getElement()) {
				int linkVID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getVisualID(next);
				switch (linkVID) {
				«FOR v: containedTypeModelFacetLinks»«caseVisualId(v)»«ENDFOR»
					result.add(next);
					break;
				}
			}
		}
		«ENDIF»
	'''
	
	def caseVisualId(GenLink it) '''
		case «getEditPartQualifiedClassName()».VISUAL_ID:
	'''
	
	def getCreateNotationalElementCommand(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.gwt.commands.CreateNotationalElementCommand getCreateNotationalElementCommand(org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor descriptor) {
		«IF primNeedsLinkNotationModelRefresher»
			org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor linkDescriptor = (org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.LinkDescriptor) descriptor;
			«defineDecorator»
			«IF getDiagram().shortcutsProvidedFor.size() > 0»
			String diagramModelID = «getDiagram().getVisualIDRegistryQualifiedClassName()».getModelID(getHost().getDiagram());
«««			if (!«getDiagram().getEditPartQualifiedClassName()».MODEL_ID.equals(diagramModelID)) {
«««				return new «xpt::commands::CreateShortcutEdgeCommand::qualifiedClassName FOR getDiagram()»(getHost().getDiagram(), linkDescriptor.getElement(), sourceView, targetView, decorator);
«««			}
			«ENDIF»
			«instantiateNotationalEdgeCommand('getHost().getDiagram()')»
		«ELSE»
			return null;
		«ENDIF»
		}
	'''
	
	def shouldCreateView(GenCommonBase it) '''
		«generatedMemberComment('Returns whether a notational edge should be created for the given domain element. \n' + 
		'The generated code respects canonical style. If the canonycal style is not present, ' + 
		(if (getDiagram().synchronized) 'true' else 'false') + 
		' is always returned. \n' + 
		'User can change implementation of this method to handle a more sophisticated logic.')»
		protected boolean shouldCreateView(org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor descriptor) {
			org.eclipse.gmf.runtime.notation.CanonicalStyle style = (org.eclipse.gmf.runtime.notation.CanonicalStyle) «getViewCode».getStyle(org.eclipse.gmf.runtime.notation.NotationPackage.eINSTANCE.getCanonicalStyle());
			if (style == null) {
				return «getDiagram().synchronized»;
			}
			return style.isCanonical();
		}
	'''
	
	def getHost(GenCommonBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.notation.View getHost() {
			return «getViewCode»;
		}
	'''
	
	def additions(GenCommonBase it) ''''''

}
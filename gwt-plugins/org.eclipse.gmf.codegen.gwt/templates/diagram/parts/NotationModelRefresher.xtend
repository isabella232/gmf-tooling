package diagram.parts

import com.google.inject.Inject
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import common.Common
import commands.CreateNotationalElementCommand
import diagram.MetaModel
import diagram.PhantomUtils
import diagram.VisualIDRegistry

class NotationModelRefresher {
	
	extension NotationModelRefresherHelper = new NotationModelRefresherHelper
	extension PhantomUtils = new PhantomUtils
	extension MetaModel = new MetaModel
	extension Common = new Common

	@Inject extension CreateNotationalElementCommand
	@Inject extension SemanticChildren
	@Inject extension PartCommon
	@Inject extension VisualIDRegistry

	def installClause(GenContainerBase it) '''
«««		«IF needsNotationModelRefresher()»
«««		installNotationModelRefresher();
«««		«ENDIF»
	'''

	def uninstallClause(GenContainerBase it) '''
«««		«IF needsNotationModelRefresher()»
«««		uninstallNotationModelRefresher();
«««		«ENDIF»
	'''

	def all(GenContainerBase it) '''
		«IF needsNotationModelRefresher()»
«««		«install»
«««		«uninstall»
		«getNotationModelRefresher»
«««		«refresh»
		«generate»
		«ENDIF»
	'''

	def install(GenContainerBase it) '''
		installRefresher(getNotationModelRefresher());
«««		«xpt::Common::generatedMemberComment»
«««		private void installNotationModelRefresher() {
«««			org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ChildNotationModelRefresher refresher = getNotationModelRefresher();
«««			if (!getTransactionalUpdateManager().isNotationModelRefresherInstalled(refresher)) {
«««				getTransactionalUpdateManager().addNotationModelRefresher(refresher);
«««				try {
«««					refreshNotationModel();
«««				} catch (java.lang.IllegalStateException readOnlyContext) {
«««					//Most likely, this means that the host element was created in a precommit notification of a transaction.
«««					//While it is impossible to execute this command here, it will be executed as a trigger command.
«««					//See org.eclipse.gmf.runtime.gwt.edit.parts.update.TransactionalUpdateManager for details.
«««				}
«««			}
«««		}
	'''
	
	def uninstall(GenContainerBase it) '''
«««		«xpt::Common::generatedMemberComment»
«««		private void uninstallNotationModelRefresher() {
«««			org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ChildNotationModelRefresher refresher = getNotationModelRefresher();
«««			getTransactionalUpdateManager().removeNotationModelRefresher(refresher);
«««		}
	'''
	
	def getNotationModelRefresher(GenContainerBase it) '''
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.ChildNotationModelRefresher notationModelRefresher;
		
		«generatedMemberComment»
		private org.eclipse.gmf.runtime.gwt.edit.parts.ChildNotationModelRefresher getNotationModelRefresher() {
			if (notationModelRefresher == null) {
				notationModelRefresher = new «className»(this);
			}
			return notationModelRefresher;
		}
	'''
	
	def className(GenContainerBase it) '''NotationModelRefresher'''
	
	def refresh(GenContainerBase it) '''
«««		«xpt::Common::generatedMemberComment»
«««		protected void refreshNotationModel() {
«««			org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ChildNotationModelRefresher childRefresher = getNotationModelRefresher();
«««			org.eclipse.emf.common.command.Command command = childRefresher.buildRefreshNotationModelCommand();
«««			if (command == null) {
«««				return;
«««			}
«««			org.eclipse.emf.transaction.TransactionalEditingDomain domainModelEditDomain = org.eclipse.emf.transaction.util.TransactionUtil.getEditingDomain(«getDiagramElementCode»);
«««			getViewer().getEditDomain().getCommandStack().execute(new org.eclipse.gmf.runtime.gwt.commands.WrappingCommand(domainModelEditDomain, command));
«««		}
	'''
	
	def generate(GenContainerBase it) '''
		«generatedClassComment»
		private class «className» «supertypes» {

			«ctor»
			«getConstrainedChildrenFilter»
			«getPhantomsFilter»
«««			«createFilter»
			«shouldRefresh»
			«getCreateNotationalElementCommand»
			«getSemanticChildNodes»
«««			«xpt::diagram::parts::semanticChildren::getPhantomNodesIterator»
			«shouldCreateView»
			«externalViews»
«««			«getHost»
			«additions»

		}
	'''
	
	protected def ctor() '''
		public NotationModelRefresher(org.eclipse.gef.editparts.AbstractGraphicalEditPart part) {
			super(part);
		}
	'''
	
	def supertypes(GenContainerBase it) 
		'''extends org.eclipse.gmf.runtime.gwt.edit.parts.ChildNotationModelRefresher'''
	
	def getConstrainedChildrenFilter(GenContainerBase it) '''
		«IF getConstraintsInChildren.size() > 0»
		«generatedMemberComment('TODO: Children of this element are selected based on constraint declared in ' + getDiagram().getVisualIDRegistryQualifiedClassName() + '. \n' + 
		'Since no assumptions may be made concerning the runtime behavior of the constraint, <b>any</b> non-touch notification may result in \n' + 
		'notational model having to be updated.\n' + 
		'<p/>User is encouraged to change implementation of this method to provide an optimization if it is safe to assume that not all notifications\n' + 
		'result in such an update.')»
		private boolean getConstrainedChildrenFilter(org.eclipse.emf.common.notify.Notification notification) {
			return !notification.isTouch();
		}
		«ENDIF»
	'''
	
	def dispatch getPhantomsFilter(GenContainerBase it) ''''''
	
	def dispatch getPhantomsFilter(GenDiagram it) '''
		«IF getPhantomNodes.size() > 0»
		«generatedMemberComment»
		private boolean getPhantomsFilter(org.eclipse.emf.common.notify.Notification notification) {
			boolean result = true;
			«val phantomFeatures = it.phantomFeatures»
			«FOR feature: phantomFeatures»
			result = result || «createFeatureFilter(feature)»
			«ENDFOR»
			«IF phantomFeatures.size() > 0»
			return result || org.eclipse.emf.ecore.resource.Resource.RESOURCE__CONTENTS.equals(notification.getFeature());
			«ELSE»
			return result;
			«ENDIF»
«««		«LET getPhantomFeatures() AS phantomFeatures»
«««		«FOREACH phantomFeatures AS nextFeature ITERATOR it»
«««		«IF it.isFirstIteration()»org.eclipse.emf.transaction.NotificationFilter phantomFeaturesFilter = «createFeatureFilter FOR nextFeature»;«ELSE»
«««		phantomFeaturesFilter = phantomFeaturesFilter.or(«createFeatureFilter FOR nextFeature»);«ENDIF»
«««		«ENDFOREACH»
«««			return «IF phantomFeatures.size() > 0»phantomFeaturesFilter.or(«ENDIF»org.eclipse.emf.transaction.NotificationFilter.createFeatureFilter(org.eclipse.emf.ecore.resource.Resource.class, org.eclipse.emf.ecore.resource.Resource.RESOURCE__CONTENTS)«IF phantomFeatures.size() > 0»)«ENDIF»;
«««		«ENDLET»
		}
		«ENDIF»
	'''
	
	def shouldRefresh(GenContainerBase it) '''
		«generatedMemberComment»
		@Override
		public boolean shouldRefresh(org.eclipse.emf.common.notify.Notification notification) {
			«val features = getChildFeaturesForFilter»
			boolean result = true;
			«FOR feature: features»
			if («createFeatureFilter(feature)») {
				result = result || true;
			}
			«ENDFOR»
			«IF features.size() > 0»
			result = result && «createNotifierFilter»;
			«ELSE»
			result = «createNotifierFilter»
			«ENDIF»
			«plugPhantomNotifier»
			«IF constraintsInChildren.size > 0»
			result = getConstrainedChildrenFilter() || result;
			«ENDIF»
			return result;
		}
	'''

	def createFilter(GenContainerBase it) {
//		val first = features.head
//		val rest = features.tail
		'''
	«««		«xpt::Common::generatedMemberComment('Creates a notification filter which filters notifications that may possibly affect the notational model')»
«««			protected org.eclipse.emf.transaction.NotificationFilter createFilter() {
«««				org.eclipse.emf.transaction.NotificationFilter filter = «first.createFeatureFilter»;
«««				«FOR nextFeature: rest»
«««				filter = filter.or(«nextFeature.createFeatureFilter»);
«««				«ENDFOR»
«««				«IF features.size() > 0»filter = filter.and(«createNotifierFilter»);«ELSE»
«««				org.eclipse.emf.transaction.NotificationFilter filter = «createNotifierFilter»;«ENDIF»
«««				«plugPhantomNotifier»
«««				«IF getConstraintsInChildren.size() > 0»
«««				filter = getConstrainedChildrenFilter().or(filter);
«««				«ENDIF»
«««				return filter;
«««			}
		'''
	}
	
	def dispatch plugPhantomNotifier(GenContainerBase it) ''''''
	
	def dispatch plugPhantomNotifier(GenDiagram it) '''
		«IF getPhantomFeatures().size() > 0»
		result = result || getPhantomsFilter();
		«ENDIF»
	'''

	def createFeatureFilter(GenFeature it) 
//		'''org.eclipse.emf.transaction.NotificationFilter.createFeatureFilter(«metaFeature»)'''
		'''«metaFeature».equals(notification.getFeature())'''
	
	def createNotifierFilter(GenContainerBase it) 
//		'''org.eclipse.emf.transaction.NotificationFilter.createNotifierFilter(«getViewCode».getElement())'''
		'''notification.getNotifier().equals(«getViewCode».getElement())'''

	def getCreateNotationalElementCommand(GenContainerBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.gwt.commands.CreateNotationalElementCommand getCreateNotationalElementCommand(org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor descriptor) {
			«createNotationalNodeCommand('getHost()')»
		}
	'''

	def getSemanticChildNodes(GenContainerBase it) '''
		«generatedMemberComment»
		protected java.util.List<org.eclipse.gmf.runtime.gwt.edit.parts.update.canonical.ElementDescriptor> getSemanticChildNodes() {
			«semanticChildren('getHost()')»
		}
	'''
	
	def shouldCreateView(GenContainerBase it) '''
		«generatedMemberComment('Returns whether a notational element should be created for the given domain element. \n' + 
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
	
	def externalViews(GenContainerBase it) ''''''
	
	def externalViews(GenDiagram it) '''
		«IF containsShortcutsTo.size() > 0»
		«generatedMemberComment»
		protected boolean shouldRemoveView(org.eclipse.gmf.runtime.notation.View view) {
			org.eclipse.emf.ecore.EAnnotation annotation = view.getEAnnotation("Shortcut");
			if (annotation == null) {
				return super.shouldRemoveView(view);
			}
			String modelID = «getModelIDMethodCall»(view);
			if («getDiagramEditorUtilQualifiedClassName()».isKnownShortcutModelID(modelID)) {
				return !view.isSetElement() || view.getElement() == null || view.getElement().eIsProxy();
			}
			return true;
		}

		«generatedMemberComment»
		protected org.eclipse.emf.common.command.Command getRefreshExternalElementCommand(org.eclipse.gmf.runtime.notation.View view) {
			// The element is a shortcut that exists, but may have changed:
			// see #shouldRemoveView(org.eclipse.gmf.runtime.notation.View)
			String modelID = «getModelIDMethodCall»(view);
			org.eclipse.gmf.runtime.gwt.shortcuts.IShortcutProvider shortcutProvider = org.eclipse.gmf.runtime.gwt.shortcuts.ShortcutProvidersRegistry.INSTANCE.getShortcutProvider(modelID);
			if (shortcutProvider == null) {
				return null;
			}
			return shortcutProvider.getRefreshShortcutCommand(view);
		}
		«ENDIF»
	'''
	
	def getHost(GenContainerBase it) '''
		«generatedMemberComment»
		protected org.eclipse.gmf.runtime.notation.View getHost() {
			return «getViewCode»;
		}
	'''

	def additions(GenContainerBase it) ''''''

}
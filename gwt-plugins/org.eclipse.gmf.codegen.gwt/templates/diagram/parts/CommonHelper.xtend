package diagram.parts

import java.util.Collection
import org.eclipse.gmf.codegen.gmfgen.GenChildLabelNode
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenCompartment
import org.eclipse.gmf.codegen.gmfgen.GenContainerBase
import org.eclipse.gmf.codegen.gmfgen.GenDiagram
import org.eclipse.gmf.codegen.gmfgen.GenExternalNodeLabel
import org.eclipse.gmf.codegen.gmfgen.GenLabel
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenNode
import org.eclipse.gmf.codegen.gmfgen.GenNodeLabel
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet

class CommonHelper {
	
	extension LinkNotationModelRefresherHelper = new LinkNotationModelRefresherHelper
	extension NotationModelRefresherHelper = new NotationModelRefresherHelper
	
	def dispatch isSelectable(GenCommonBase it) { true }

	def dispatch isSelectable(GenNodeLabel it) { false }
	
	def dispatch isSelectable(GenExternalNodeLabel it) { true }
	
	def dispatch isSelectable(GenCompartment it) { false }
	
	def dispatch needsTransactionalUpdateManager(GenCommonBase it) {
		needsDomainModelRefresher() || needsLinkNotationModelRefresher
	}
	
	def dispatch needsTransactionalUpdateManager(GenDiagram it) { true }
	
	def dispatch needsTransactionalUpdateManager(GenContainerBase it) {
		needsDomainModelRefresher() || (needsNotationModelRefresher || needsLinkNotationModelRefresher)
	}
	
	def dispatch Boolean needsDomainModelRefresher(GenCommonBase it) { false }
	
	def dispatch Boolean needsDomainModelRefresher(GenLink it) { modelFacet.needsDomainModelRefresher() }
	
	def dispatch Boolean needsDomainModelRefresher(LinkModelFacet it) { false }
	
	def dispatch Boolean needsDomainModelRefresher(TypeLinkModelFacet it) { metaClass != null }
	
	def dispatch Boolean needsDomainModelRefresher(GenDiagram it) { !sansDomain }
	
	def dispatch Boolean needsDomainModelRefresher(GenNode it) { !sansDomain }
	
	def dispatch getPrimaryLabel(GenCommonBase it) { null }
	
	def dispatch getPrimaryLabel(GenNode it) { labels.filter[e | !e.readOnly].head }
	
	def dispatch getPrimaryLabel(GenLink it) { labels.filter[e | !e.readOnly].head }
	
	def dispatch getPrimaryLabel(GenChildLabelNode it) { null }
	
	def dispatch Collection<? extends GenLabel> getAllLabels(GenCommonBase it)  { newArrayList() }
	
	def dispatch Collection<? extends GenLabel> getAllLabels(GenNode it) { labels }
	
	def dispatch Collection<? extends GenLabel> getAllLabels(GenLink it) { labels }

}
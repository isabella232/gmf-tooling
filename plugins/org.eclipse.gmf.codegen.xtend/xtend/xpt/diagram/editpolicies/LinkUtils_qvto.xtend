/**
 * Copyright (c) 2007, 2010 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Borland) - [243151] explicit source/target for links
 *  							- #386838 - migrate to Xtend2
 */
package xpt.diagram.editpolicies

import com.google.inject.Inject
import org.eclipse.emf.codegen.ecore.genmodel.GenClass
import org.eclipse.gmf.codegen.gmfgen.FeatureLinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.GenLink
import org.eclipse.gmf.codegen.gmfgen.GenLinkEnd
import org.eclipse.gmf.codegen.gmfgen.LinkModelFacet
import org.eclipse.gmf.codegen.gmfgen.TypeLinkModelFacet
import xpt.Common_qvto
import xpt.GenModelUtils_qvto

@com.google.inject.Singleton class LinkUtils_qvto {
	@Inject extension Common_qvto;
	@Inject extension GenModelUtils_qvto;

	def boolean isTypeLink(GenLink link) {
		link.modelFacet.oclIsKindOf(typeof(TypeLinkModelFacet))
	}

	def boolean isRefLink(GenLink link) {
		link.modelFacet.oclIsKindOf(typeof(FeatureLinkModelFacet))
	}

	def boolean canBeSource(GenLink link, GenLinkEnd linkEnd) {
		link.sources.contains(linkEnd)
	}

	def boolean canBeTarget(GenLink link, GenLinkEnd linkEnd) {
		link.targets.contains(linkEnd)
	}

	def boolean canBeContainer(GenLink link, GenClass metaClass) {
		link.modelFacet != null && isCompatible(link.modelFacet.getContainerClass(), metaClass)
	}

	private def dispatch GenClass getContainerClass(LinkModelFacet facet) {
		return null
	}

	private def dispatch GenClass getContainerClass(TypeLinkModelFacet facet) {
		return facet.childMetaFeature.genClass
	}

	private def dispatch GenClass getContainerClass(FeatureLinkModelFacet facet) {
		return facet.sourceType
	}

	private def boolean isCompatible(GenClass desiredType, GenClass actualClass) {
		return null != desiredType && desiredType.isSuperTypeOf(actualClass)
	}

}

/**
 * Copyright (c) 2006, 2010, 2013 Borland Software Corporation and others
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 *    Michael Golubev (Montages) - #386838 - migrate to Xtend2
 */
package xpt.navigator

import com.google.inject.Inject
import java.util.Set
import org.eclipse.emf.codegen.ecore.genmodel.GenFeature
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase
import org.eclipse.gmf.codegen.gmfgen.GenNavigator
import org.eclipse.gmf.codegen.gmfgen.GenNavigatorChildReference
import xpt.Common_qvto

class Utils_qvto {
	@Inject extension Common_qvto;

	def int getMaxVisualID(GenNavigator navigator) {
		getNavigatorNodes(navigator).sortBy[n|n.visualID].last.visualID
	}

	def Iterable<GenCommonBase> getNavigatorContainerNodes(GenNavigator navigator) {
		return getNavigatorNodes(navigator).filter[n|getChildReferencesFrom(navigator, n).notEmpty]
	}

	def Iterable<GenCommonBase> getNavigatorContainedNodes(GenNavigator navigator) {
		return getNavigatorNodes(navigator).filter[n|getChildReferencesTo(navigator, n).notEmpty]
	}

	def Iterable<GenCommonBase> getNavigatorNodes(GenNavigator navigator) {
		var result = <GenCommonBase>newLinkedList()
		result.addAll(navigator.editorGen.diagram.getAllContainers())
		result.addAll(navigator.editorGen.diagram.links)
		return result.sortBy[n|n.visualID]
	}

	def Set<String> getGroupNames(Iterable<GenNavigatorChildReference> refs) {
		return refs.filter[ref|ref.isInsideGroup()].map[ref|ref.groupName].toSet()
	}

	def GenNavigatorChildReference getNavigatorReference(String groupName,
		Iterable<GenNavigatorChildReference> childReferences) {
		return childReferences.findFirst[r|r.groupName == groupName]
	}

	def Iterable<GenNavigatorChildReference> getChildReferencesFrom(GenNavigator navigator, GenCommonBase parent) {
		return if (parent == null) //
			navigator.childReferences.filter[r|r.parent == null] //
		else
			navigator.childReferences.filter[r|r.parent != null && parent.visualID == r.parent.visualID]
	}

	def Iterable<GenNavigatorChildReference> getChildReferencesTo(GenNavigator navigator, GenCommonBase child) {
		return navigator.childReferences.filter[r|child.visualID == r.child.visualID]
	}

	def GenNavigatorChildReference getDiagramTopReference(GenNavigator navigator) {
		return navigator.childReferences.filter[cr|null == cr.parent].filter[cr|cr.child == navigator.editorGen.diagram].
			head;
	}

	def boolean isStringFeature(GenFeature feature) {
		return feature.ecoreFeature.EType.name == 'EString'
	}

}

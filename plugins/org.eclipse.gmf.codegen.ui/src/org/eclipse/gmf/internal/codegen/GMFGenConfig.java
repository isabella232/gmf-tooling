/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.gmf.codegen.gmfgen.GenChildContainer;
import org.eclipse.gmf.codegen.gmfgen.GenNode;
import org.eclipse.gmf.internal.common.reconcile.DefaultDecisionMaker;
import org.eclipse.gmf.internal.common.reconcile.Matcher;
import org.eclipse.gmf.internal.common.reconcile.ReconcilerConfigBase;
import org.eclipse.gmf.internal.common.reconcile.ReflectiveMatcher;
import org.eclipse.gmf.internal.common.reconcile.StringPatternDecisionMaker;

/**
 * XXX Perhaps, org.eclipse.gmf.codegen/oeg.internal.util would be better place for this class. 
 */
public class GMFGenConfig extends ReconcilerConfigBase {
	private final GMFGenPackage GMFGEN = GMFGenPackage.eINSTANCE;
	
	public GMFGenConfig(){
		setMatcher(GMFGEN.getGenEditorGenerator(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_CopyrightText());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_PackageNamePrefix());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_DiagramFileExtension());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_SameFileForDiagramAndModel());
		
		setMatcher(GMFGEN.getGenPlugin(), ALWAYS_MATCH); //exactly one feature for ALWAYS_MATCH GenEditorGenerator
		preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_Provider());
		preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_Version());
		preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_ActivatorClassName());
		
		setMatcher(GMFGEN.getGenDiagram(), ALWAYS_MATCH);  
		
		setMatcher(GMFGEN.getGenTopLevelNode(), getGenNodeMatcher());
		preserveIfSet(GMFGEN.getGenTopLevelNode(), GMFGEN.getGenChildContainer_ListLayout());
		preserveIfNotByPattern(GMFGEN.getGenTopLevelNode(), GMFGEN.getGenChildContainer_CanonicalEditPolicyClassName(), ".*" + GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX);
		preserveIfNotByPattern(GMFGEN.getGenTopLevelNode(), GMFGEN.getGenNode_GraphicalNodeEditPolicyClassName(), ".*" + GenNode.GRAPHICAL_NODE_EDIT_POLICY_SUFFIX);
		
		setMatcher(GMFGEN.getGenChildNode(), getGenNodeMatcher());
		preserveIfSet(GMFGEN.getGenChildNode(), GMFGEN.getGenChildContainer_ListLayout());
		preserveIfNotByPattern(GMFGEN.getGenChildNode(), GMFGEN.getGenChildContainer_CanonicalEditPolicyClassName(), ".*" + GenChildContainer.CANONICAL_EDIT_POLICY_SUFFIX);
		preserveIfNotByPattern(GMFGEN.getGenChildNode(), GMFGEN.getGenNode_GraphicalNodeEditPolicyClassName(), ".*" + GenNode.GRAPHICAL_NODE_EDIT_POLICY_SUFFIX);
		
		setMatcher(GMFGEN.getGenCompartment(), new ReflectiveMatcher(GMFGEN.getGenCompartment_Title()));
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenChildContainer_ListLayout());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_CanCollapse());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_HideIfEmpty());
		preserveIfSet(GMFGEN.getGenCompartment(), GMFGEN.getGenCompartment_NeedsTitle());
	}
	
	private Matcher getGenNodeMatcher(){
		//FIXME: use new AttributeMatcher("domainMetaClass")
		return new ReflectiveMatcher(GMFGenPackage.eINSTANCE.getGenNode(), new ReflectiveMatcher.Reflector(){
			public Object reflect(EObject target) {
				GenNode genNode = (GenNode)target;
				return genNode.getDomainMetaClass();
			}
		});
	}
	
	private void preserveIfSet(EClass eClass, EAttribute feature){
		//FIXME: only attributes for now, allow references
		addDecisionMaker(eClass, new DefaultDecisionMaker(feature));
	}
	
	private void preserveIfNotByPattern(EClass eClass, EAttribute feature, String pattern){
		addDecisionMaker(eClass, new StringPatternDecisionMaker(pattern, feature));
	}
	
}

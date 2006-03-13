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
import org.eclipse.gmf.internal.common.reconcile.DefaultDecisionMaker;
import org.eclipse.gmf.internal.common.reconcile.Matcher;
import org.eclipse.gmf.internal.common.reconcile.ReconcilerConfigBase;

/**
 * XXX Perhaps, org.eclipse.gmf.codegen/oeg.internal.util would be better place for this class. 
 */
public class GMFGenConfig extends ReconcilerConfigBase {
	
	public GMFGenConfig(){
		final GMFGenPackage GMFGEN = GMFGenPackage.eINSTANCE;

		setMatcher(GMFGEN.getGenEditorGenerator(), ALWAYS_MATCH);
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_CopyrightText());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_PackageNamePrefix());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_DiagramFileExtension());
		preserveIfSet(GMFGEN.getGenEditorGenerator(), GMFGEN.getGenEditorGenerator_SameFileForDiagramAndModel());
		
		setMatcher(GMFGEN.getGenPlugin(), ALWAYS_MATCH); //exactly one feature for ALWAYS_MATCH GenEditorGenerator
		preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_Provider());
		preserveIfSet(GMFGEN.getGenPlugin(), GMFGEN.getGenPlugin_Version());
	}
	
	private void preserveIfSet(EClass eClass, EAttribute feature){
		//FIXME: only attributes for now, allow references
		addDecisionMaker(eClass, new DefaultDecisionMaker(feature));
	}
	
	private static final Matcher ALWAYS_MATCH = new Matcher(){
		public boolean match(EObject current, EObject old) {
			return current.eClass().equals(old.eClass());
		}
	};
	
}

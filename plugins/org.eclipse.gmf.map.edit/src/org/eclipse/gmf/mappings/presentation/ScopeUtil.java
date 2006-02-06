/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.mappings.presentation;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.mappings.MappingEntry;

/**
 * @author artem
 *
 */
public class ScopeUtil {
	private final MappingEntry entry;
	private boolean myCouldBeUnsed;

	public ScopeUtil(MappingEntry anEntry) {
		this(anEntry, false);
	}
	
	public ScopeUtil(MappingEntry anEntry, boolean couldBeUnset) {
		entry = anEntry;
		myCouldBeUnsed = couldBeUnset;
	}

	public boolean isDevisable() {
		return entry.getDomainMetaElement() != null;
	}

	/**
	 * XXX usability: produce ordered set of references, with cont.references from parent mapping's element first 
	 * @return collections of <code>EReference</code>s that are containment for entry's meta type
	 */
	public Collection/*<EReference>*/ getPossibleContainments() {
		if (entry.getDomainMetaElement() != null) {
			Set features = new LinkedHashSet();
			Iterator wholeWorld;
			if (entry.getDomainMetaElement().eResource() == null) {
				wholeWorld = entry.getDomainMetaElement().getEPackage().eAllContents();
			} else {
				wholeWorld = entry.getDomainMetaElement().eResource().getResourceSet().getAllContents();
			}
			while (wholeWorld.hasNext()) {
				Object next = wholeWorld.next();
				if (next instanceof EReference) {
					EReference ref = (EReference) next;
					if (ref.isContainment() && ref.getEReferenceType().isSuperTypeOf(entry.getDomainMetaElement())) {
						features.add(ref);
					}
				}
			}
			if (myCouldBeUnsed) {
				features.add(null);
			}
			return features;
		}
		return Collections.EMPTY_LIST;
	}
}

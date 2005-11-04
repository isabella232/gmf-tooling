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
package org.eclipse.gmf.tests.gen;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import junit.framework.TestCase;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenCommonBase;
import org.eclipse.gmf.codegen.gmfgen.GenCompartment;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.tests.SessionSetup;
import org.eclipse.jdt.core.JavaConventions;

/**
 * Tests for handcoded method implementations in GMFGen model
 * @author artem
 */
public class HandcodedImplTest extends TestCase {
	private GenDiagram myGenModel;

	public HandcodedImplTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		// FIXME need complex genmodel with a lot of nodes and links to make tests effective 
		myGenModel = SessionSetup.getGenModel().getGenDiagram();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testUniqueIdentifier_IsUnique() {
		HashSet allIds = new HashSet(1<<7);
		for (GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel); it.hasNext();) {
			GenCommonBase next = it.nextElement();
			assertFalse("There should be no two same 'unique' identifiers in GMFGen", allIds.contains(next.getUniqueIdentifier()));
			allIds.add(next.getUniqueIdentifier());
		}
		assertTrue("Test is not valid unless few elements were checked", allIds.size() > 1);
		allIds.clear();
	}

	public void testUniqueIdentifier_IsConstant() {
		LinkedList/*<String>*/ allIdsOrdered = new LinkedList/*<String>*/();
		for (GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel); it.hasNext();) {
			GenCommonBase next = it.nextElement();
			allIdsOrdered.add(next.getUniqueIdentifier());
		}
		assertTrue("Test is not valid unless there are few elements to check", allIdsOrdered.size() > 1);
		Iterator itSaved = allIdsOrdered.iterator();
		GenCommonBaseIterator it = new GenCommonBaseIterator(myGenModel);
		for (; it.hasNext() && itSaved.hasNext();) {
			GenCommonBase next = it.nextElement();
			String savedID = itSaved.next().toString();
			assertEquals("Subsequent invocations of getUniqueIdentifier produce different results", savedID, next.getUniqueIdentifier());
		}
		assertEquals("Lists are not equal in size", itSaved.hasNext(), it.hasNext());
		allIdsOrdered.clear();
	}

	public void testCompartmentClassNamePrefix() {
		GenCompartment c = GMFGenFactory.eINSTANCE.createGenCompartment();
		IStatus s = JavaConventions.validateJavaTypeName(c.getClassNamePrefix());
		assertTrue("Default prefix (no title set):" + s.getMessage(), s.getSeverity() != IStatus.ERROR);
		c.setTitle("<>?#!. =\"'\n\t\\");
		s = JavaConventions.validateJavaTypeName(c.getClassNamePrefix());
		assertTrue(s.getMessage(), s.getSeverity() != IStatus.ERROR);
	}

	private static class GenCommonBaseIterator implements Iterator {
		private GenCommonBase nextBase;
		private Iterator wrappedIterator;

		public GenCommonBaseIterator(GenDiagram genDiagram) {
			assert genDiagram != null;
			nextBase = genDiagram;
			wrappedIterator = genDiagram.eAllContents();
		}
		public boolean hasNext() {
			return nextBase != null;
		}
		public GenCommonBase nextElement() {
			if (nextBase == null) {
				throw new NoSuchElementException();
			}
			GenCommonBase rv = nextBase;
			advance();
			return rv;
		}
		public Object next() {
			return nextElement();
		}
		private void advance() {
			nextBase = null;
			while (wrappedIterator.hasNext()) {
				Object next = wrappedIterator.next();
				if (next instanceof GenCommonBase) {
					nextBase = (GenCommonBase) next;
					break;
				}
			}
		}
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}

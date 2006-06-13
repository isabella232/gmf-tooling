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

package org.eclipse.gmf.tests.gen;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.gmf.internal.common.reconcile.AbstractPool;

import junit.framework.TestCase;

public class ReconcilerPoolTest extends TestCase {
	public void testMoreAcquiresThanCapacity(){
		Pool pool = new Pool(2);
		Object a = pool.acquire();
		Object b = pool.acquire();
		Object c = pool.acquire();
		pool.release(a);
		pool.release(b);
		pool.release(c);
		
		assertEquals(0, pool.getNullsCount());
		assertEquals(3, pool.getCreationCount());
	}
	
	public void testMuchMoreAcquiresGoodShaped(){
		Pool pool = new Pool(2);
		Object a = pool.acquire();
		Object b = pool.acquire();

		final int NOT_POOLED_AQUIRES = 50;
		for (int i = 0; i < NOT_POOLED_AQUIRES; i++){
			Object next = pool.acquire();
			pool.release(next);
		}
		
		pool.release(a);
		pool.release(b);
		
		assertEquals("When first NOT_POOLED object is release it should be returned to pool", 1 + 2, pool.getCreationCount());
		assertEquals(0, pool.getNullsCount());
	}

	public void testImmediateRelease(){
		Pool pool = new Pool(2);
		for (int i = 0; i < 50; i++){
			Object next = pool.acquire();
			assertEquals(pool.capacity(), pool.getNullsCount());
			pool.release(next);
		}
		assertEquals(1, pool.getCreationCount());
		assertEquals(pool.capacity() - 1, pool.getNullsCount());
		
		for (int i = 0; i < 50; i++){
			Object nextA = pool.acquire();
			Object nextB = pool.acquire();

			assertEquals(pool.capacity(), pool.getNullsCount());
			
			if (i % 2 == 0){
				pool.release(nextA);
				pool.release(nextB);
			} else {
				pool.release(nextB);
				pool.release(nextA);
			}
		}

		assertEquals(2, pool.getCreationCount());
		assertEquals(pool.capacity() - 2, pool.getNullsCount());
	}
	
	public void testBadCase(){
		Pool pool = new Pool(2);
		final int ACQUIRES = 50;
		
		List allAcquired = new LinkedList(); 
		for (int i = 0; i < ACQUIRES; i++){
			allAcquired.add(pool.acquire());
		}
		for (Iterator it = allAcquired.iterator(); it.hasNext();){
			pool.release(it.next());
			it.remove();
		}
		assertEquals(ACQUIRES, pool.getCreationCount());
		assertEquals(0, pool.getNullsCount());
		
		//once again
		for (int i = 0; i < ACQUIRES; i++){
			allAcquired.add(pool.acquire());
		}
		for (Iterator it = allAcquired.iterator(); it.hasNext();){
			pool.release(it.next());
			it.remove();
		}
		
		assertEquals(ACQUIRES * 2 - pool.capacity(), pool.getCreationCount());
		assertEquals(0, pool.getNullsCount());
	}
	
	public void testBaseInternals(){
		Pool pool = new Pool(2);
		Object a = pool.acquire();
		assertEquals(1, pool.getCreationCount());
		assertEquals(2, pool.getNullsCount());
		
		pool.release(a);
		assertEquals(1, pool.getCreationCount());
		assertEquals(1, pool.getNullsCount());
		
		Object aa = pool.acquire();
		assertEquals(1, pool.getCreationCount());
		assertEquals(2, pool.getNullsCount());
		assertSame(a, aa);
		
		Object b = pool.acquire();
		assertEquals(2, pool.getCreationCount());
		assertEquals(2, pool.getNullsCount());
		assertNotSame(a, b);
		
		pool.release(a);
		assertEquals(2, pool.getCreationCount());
		assertEquals(1, pool.getNullsCount());

		pool.release(b);
		assertEquals(2, pool.getCreationCount());
		assertEquals(0, pool.getNullsCount());
	}
	
	private static class Pool extends AbstractPool {
		private int myCreationCount;
		
		public Pool(int capacity) {
			super(capacity);
		}

		protected Object createNew() {
			myCreationCount++;
			return new Object();
		}
		
		public Object acquire(){
			Object result = internalAcquire();
			assertNotNull(result);
			return result;
		}
		
		public void release(Object object){
			internalRelease(object);
		}
		
		public int getCreationCount() {
			return myCreationCount;
		}
		
		public int getNullsCount() {
			return internalCountNulls();
		}
	}
}

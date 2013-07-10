package org.eclipse.gmf.codegen.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

public class _Counter2 {
	private final HashMap<EClass, Integer> myCounters = new HashMap<EClass, Integer>();
	private final HashMap<EClass, Integer> myCache = new HashMap<EClass, Integer>();
	private final Integer CACHE_MISS = new Integer(0);

	public _Counter2() {
	}

	public void registerFactor(EClass eClass, int count) {
		myCounters.put(eClass, count);
	}

	public int getTotal(EObject from) {
		int total = process(from);
		for (Iterator<EObject> it = from.eAllContents(); it.hasNext();) {
			total += process(it.next());
		}
		return total;
	}

	protected int process(EObject next) {
		final EClass nextKey = next.eClass();
		Integer cachedValue = checkCached(nextKey);
		if (cachedValue != null) {
			return cachedValue;
		}
		LinkedList<EClass> checkQueue = new LinkedList<EClass>();
		checkQueue.add(nextKey);
		do {
			EClass key = checkQueue.removeFirst();
			if (myCounters.containsKey(key)) {
				final Integer value = myCounters.get(key);
				cache(nextKey, value);
				return value;
			} else {
				// add immeditate superclasses to check first
				checkQueue.addAll(key.getESuperTypes());
			}
		} while (!checkQueue.isEmpty());
		cache(nextKey, CACHE_MISS);
		return 0;
	}

	private Integer checkCached(EClass nextKey) {
		return myCache.get(nextKey);
	}

	private void cache(EClass nextKey, Integer value) {
		myCache.put(nextKey, value);
	}

}


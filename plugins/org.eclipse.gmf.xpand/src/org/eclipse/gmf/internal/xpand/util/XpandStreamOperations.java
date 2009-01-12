/*
 * Copyright (c) 2008, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Boris Blajer (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand.util;

import java.util.List;

import org.eclipse.gmf.internal.xpand.StreamsHolder;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation;
import org.eclipse.m2m.qvt.oml.blackbox.java.Operation.Kind;
import org.eclipse.ocl.util.CollectionUtil;

/**
 * Stream-related operations that should be accessible from within QVT environment.
 */
public class XpandStreamOperations {
	public StreamsHolder streamsHolder;

	@Operation(contextual = false, kind = Kind.HELPER)
	public List<String> xpandGetStreamNames() {
		List<String> result = CollectionUtil.<String> createNewSequence();
		if (streamsHolder != null) {
			result.addAll(streamsHolder.getSlotNames());
		}
		return result;
	}

	@Operation(contextual = false, kind = Kind.HELPER)
	public String xpandGetStreamContents(String streamName) {
		if (streamsHolder == null) {
			return null;
		}
		return streamsHolder.getStreamContents(streamName);
	}
}

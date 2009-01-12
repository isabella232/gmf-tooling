/*
 * Copyright (c) 2006, 2009 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.gmf.internal.xpand;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import org.eclipse.gmf.internal.xpand.model.XpandStreamsHolder;

public class BufferOutput extends AbstractOutput {
	/**
	 * INV: size > 0
	 */
	private final Stack<StringBuilder> outletStack;

	/**
	 * INV: size == outletStack.size - 1
	 */
	private final Stack<String> outletNamesStack;

	private final Map<String, StringBuilder> namedSlots;

	private final XpandStreamsHolder streamsHolder;

	private final boolean enforceReadOnlyAfterAccess;

	public BufferOutput(StringBuilder buffer) {
		this(buffer, null);
	}

	// XXX not map but config to show whether to append/overwrite content
	public BufferOutput(StringBuilder buffer, Map<String, StringBuilder> namedSlots) {
		this(buffer, namedSlots, false);
	}

	public BufferOutput(StringBuilder buffer, boolean enforceReadOnlyAfterRead) {
		this(buffer, null, enforceReadOnlyAfterRead);
	}

	public BufferOutput(StringBuilder buffer, Map<String, StringBuilder> namedSlots, boolean enforceReadOnlyAfterRead) {
		assert buffer != null;
		outletStack = new Stack<StringBuilder>();
		outletStack.push(buffer);
		outletNamesStack = new Stack<String>();
		streamsHolder = new XpandStreamsHolder();
		if (namedSlots == null) {
			this.namedSlots = new HashMap<String, StringBuilder>();
		} else {
			this.namedSlots = namedSlots;
			for (Map.Entry<String, StringBuilder> next : namedSlots.entrySet()) {
				streamsHolder.addNamedStream(next.getKey(), next.getValue());
			}
		}
		this.enforceReadOnlyAfterAccess = enforceReadOnlyAfterRead;
	}

	public void closeFile() {
		if (outletStack.size() == 1) {
			String msg = "CLOSE FILE without previous openFile";
			System.err.println("<<<" + msg);
			throw new UnsupportedOperationException(msg);
		}
		checkAccessPermitted();
		outletStack.pop();
		outletNamesStack.pop();
	}

	/**
	 * Throws an exception if the buffer has been configured not to allow write operations after reading and the stream 
	 * has in fact been accessed.
	 */
	private void checkAccessPermitted() {
		if (enforceReadOnlyAfterAccess && streamsHolder.isAccessed(outletNamesStack.peek())) {
			throw new UnsupportedOperationException("Cannot write to a stream after its contents have been accessed");
		}
	}

	public void openFile(String path, String outletName) {
		if (!namedSlots.containsKey(outletName)) {
//			String msg = "OPEN FILE ('" + path + "', " + outletName + ")";
//			System.err.println(">>>" + msg);
//			throw new UnsupportedOperationException(msg);
			StringBuilder newSlot = new StringBuilder();
			namedSlots.put(outletName, newSlot);
			streamsHolder.addNamedStream(outletName, newSlot);
		}
		outletStack.push(namedSlots.get(outletName));
		outletNamesStack.push(outletName);
		checkAccessPermitted();
		assert outletStack.peek() != null;
	}

	@Override
	protected void doAppend(String text) {
		outletStack.peek().append(text);
	}

	public StreamsHolder getNamedStreams() {
		return streamsHolder;
	}
}
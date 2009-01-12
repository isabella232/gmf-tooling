/*******************************************************************************
 * Copyright (c) 2008 Borland Software Corporation
 *******************************************************************************/
package org.eclipse.gmf.internal.xpand;

import java.util.List;

/**
 * @author bblajer
 */
public interface StreamsHolder {
	public String getStreamContents(String slotName);

	public List<String> getSlotNames();
}

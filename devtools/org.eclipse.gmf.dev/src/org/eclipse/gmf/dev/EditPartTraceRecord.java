/*
 * Copyright (c) 2005 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Dmitri Stadnik (Borland) - initial API and implementation
 */
package org.eclipse.gmf.dev;

/**
 * @author dstadnik
 */
public class EditPartTraceRecord {

	public static final EditPartTraceRecord[] NO_KIDS = new EditPartTraceRecord[0];

	private transient EditPartTraceRecord parent;
	private String label;
	private String imageId;
	private EditPartTraceRecord[] kids;

	public EditPartTraceRecord(String label) {
		this(label, null, NO_KIDS);
	}

	public EditPartTraceRecord(String label, String imageId) {
		this(label, imageId, NO_KIDS);
	}

	public EditPartTraceRecord(String label, String imageId, EditPartTraceRecord[] kids) {
		this.label = label;
		this.imageId = imageId;
		this.kids = kids;
		if (this.kids == null) {
			this.kids = NO_KIDS;
		}
		for (EditPartTraceRecord kid : this.kids) {
			kid.parent = this;
		}
	}

	public EditPartTraceRecord getParent() {
		return parent;
	}

	public String getLabel() {
		return label;
	}

	public String getImageId() {
		return imageId;
	}

	public EditPartTraceRecord[] getKids() {
		return kids;
	}

	public boolean equalTree(EditPartTraceRecord another) {
		if (another == null) {
			return false;
		}
		if (another == this) {
			return true;
		}
		if (label == null ? another.label != null : !label.equals(another.label)) {
			return false;
		}
		if (imageId == null ? another.imageId != null : !imageId.equals(another.imageId)) {
			return false;
		}
		if (kids.length != another.kids.length) {
			return false;
		}
		for (int i = 0; i < kids.length; i++) {
			if (kids[i] == null ? another.kids[i] != null : !kids[i].equalTree(another.kids[i])) {
				return false;
			}
		}
		return true;
	}
}

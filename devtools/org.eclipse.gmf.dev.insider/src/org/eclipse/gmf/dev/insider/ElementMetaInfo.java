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
package org.eclipse.gmf.dev.insider;

/**
 * @author dstadnik
 */
public class ElementMetaInfo {

	private ElementMetaInfo() {}

	/**
	 * Model root element.
	 */
	public static final String VIEW_ELEMENT = "view"; //$NON-NLS-1$

	/**
	 * Reference element. Poits to some other element in model.
	 * Id attribute is id of the referenced element.
	 */
	public static final String REFERENCE_ELEMENT = "reference"; //$NON-NLS-1$

	/**
	 * Edit part element. Represents all gef edit parts.
	 */
	public static final String EDIT_PART_ELEMENT = "editPart"; //$NON-NLS-1$

	/**
	 * Edit policy element. Represents all gef edit policies.
	 */
	public static final String EDIT_POLICY_ELEMENT = "editPolicy"; //$NON-NLS-1$

	/**
	 * Figure element. Represents all draw2d figures.
	 */
	public static final String FIGURE_ELEMENT = "figure"; //$NON-NLS-1$

	/**
	 * Specifies ancestor type. Used in figure and editPart.
	 */
	public static final String EXTENDS_ELEMENT = "extends"; //$NON-NLS-1$

	/**
	 * Bounds element. Used in figures that are not connections.
	 */
	public static final String BOUNDS_ELEMENT = "bounds"; //$NON-NLS-1$

	/**
	 * Represents PointList object. Contains a number of child
	 * point elements. Used in connection figures.
	 */
	public static final String POINT_LIST_ELEMENT = "pointList"; //$NON-NLS-1$

	/**
	 * Element that represents point.
	 */
	public static final String POINT_ELEMENT = "point"; //$NON-NLS-1$

	// attributes

	/**
	 * View creation timestamp.
	 */
	public static final String TIMESTAMP_ATTRIBUTE = "timestamp"; //$NON-NLS-1$

	/**
	 * View description attribute.
	 */
	public static final String DESCRIPTION_ATTRIBUTE = "description"; //$NON-NLS-1$

	/**
	 * Unique id attribute. Corresponds to object hash code.
	 * Elements that have this attribute are tree nodes;
	 * other elements are complex node attributes.
	 */
	public static final String ID_ATTRIBUTE = "id"; //$NON-NLS-1$

	/**
	 * Fully qualified class name. Used in figure.
	 */
	public static final String TYPE_ATTRIBUTE = "type"; //$NON-NLS-1$

	/**
	 * X coordinate of bounds or a point.
	 */
	public static final String X_ATTRIBUTE = "x"; //$NON-NLS-1$

	/**
	 * Y coordinate of bounds or a point.
	 */
	public static final String Y_ATTRIBUTE = "y"; //$NON-NLS-1$

	/**
	 * Bounds width.
	 */
	public static final String WIDTH_ATTRIBUTE = "width"; //$NON-NLS-1$

	/**
	 * Bounds height.
	 */
	public static final String HEIGHT_ATTRIBUTE = "height"; //$NON-NLS-1$
}

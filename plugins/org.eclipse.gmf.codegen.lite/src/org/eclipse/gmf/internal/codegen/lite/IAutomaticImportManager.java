/**
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    bblajer - initial API and implementation
 */
package org.eclipse.gmf.internal.codegen.lite;

import org.eclipse.gmf.internal.common.codegen.TextEmitter;

/**
 * Marker interface that specifies that the text emitter manages imports automatically, so no import manager instance should be
 * passed as a parameter.
 */
interface IAutomaticImportManager extends TextEmitter {
}

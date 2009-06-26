/**
 * Copyright (c) 2009 Borland Software Corp.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alexander Shatalin (Borland) - initial API and implementation
 */
package org.eclipse.gmf.graphdef.editor.edit.policies;

import org.eclipse.gef.EditPolicy;

public interface KeyHandlerEditPolicy extends EditPolicy {

	String KEY_HANDLER_ROLE = "KeyHandlerEditPolicy";

	void processRequest(KeyPressedRequest request);

}

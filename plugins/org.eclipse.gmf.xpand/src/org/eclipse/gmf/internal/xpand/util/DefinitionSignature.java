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
package org.eclipse.gmf.internal.xpand.util;

import java.util.Arrays;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.gmf.internal.xpand.expression.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;

final class DefinitionSignature {
	private final String myName;
	private final EClassifier myType;
	private final EClassifier[] myArgs;

	public static DefinitionSignature create(ExecutionContext ctx, XpandDefinition def) {
		if (def == null || ctx == null) {
			return null;
		}
		EClassifier type = ctx.getTypeForName(def.getTargetType());
		if (type == null) {
			return null;
		}
		EClassifier[] args = new EClassifier[def.getParams().length];
		for (int i = 0; i < def.getParams().length; i++) {
			EClassifier nextArg = ctx.getTypeForName(def.getParams()[i].getType().getValue());
			if (nextArg == null) {
				return null;
			}
			args[i] = nextArg;
		}
		return new DefinitionSignature(def.getName(), type, args);
	}

	private DefinitionSignature(String name, EClassifier type, EClassifier[] args) {
		myName = name;
		myType = type;
		myArgs = args;
		assert myName != null;
		assert myArgs != null;
		for (EClassifier nextArg : myArgs) {
			assert nextArg != null;
		}
	}
	public boolean equals(Object o) {
		if (o instanceof DefinitionSignature) {
			DefinitionSignature that = (DefinitionSignature) o;
			return this.myName.equals(that.myName) && ((this.myType == null && that.myType == null) || this.myType.equals(that.myType)) && Arrays.equals(this.myArgs, that.myArgs);
		}
		return false;
	}
	@Override
	public int hashCode() {
		return myName.hashCode() + (myType == null ? 0 : 17*myType.hashCode()) + 31*Arrays.hashCode(myArgs);
	}
}

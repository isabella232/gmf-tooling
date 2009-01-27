/*
 * Copyright (c) 2007, 2009 Borland Software Corporation
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
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandDefinition;
import org.eclipse.ocl.TypeResolver;

final class DefinitionSignature {
	private final String myName;
	private final EClassifier myType;
	private final EClassifier[] myArgs;
	private TypeResolver<EClassifier, EOperation, EStructuralFeature> myTypeResolver;

	public static DefinitionSignature create(ExecutionContext ctx, XpandDefinition def) {
		if (def == null || ctx == null) {
			return null;
		}
		EClassifier type = def.getTargetType().getTypeForName(ctx);
		if (type == null) {
			return null;
		}
		EClassifier[] args = new EClassifier[def.getParams().length];
		for (int i = 0; i < def.getParams().length; i++) {
			EClassifier nextArg = def.getParams()[i].getTypeForName(ctx);
			if (nextArg == null) {
				return null;
			}
			args[i] = nextArg;
		}
		return new DefinitionSignature(def.getName(), type, args, ctx.getOCLEnvironment().getTypeResolver());
	}
	
	private DefinitionSignature(String name, EClassifier type, EClassifier[] args, TypeResolver<EClassifier, EOperation, EStructuralFeature> typeResolver) {
		myName = name;
		myType = type;
		myArgs = args;
		myTypeResolver = typeResolver;
		assert myName != null;
		assert myArgs != null;
		for (EClassifier nextArg : myArgs) {
			assert nextArg != null;
		}
		assert myTypeResolver != null;
	}
	
	public boolean equals(Object o) {
		if (o instanceof DefinitionSignature) {
			DefinitionSignature that = (DefinitionSignature) o;
			return this.myName.equals(that.myName) && ((this.myType == null && that.myType == null) || this.myType.equals(resolve(that.myType))) && Arrays.equals(this.myArgs, resolve(that.myArgs));
		}
		return false;
	}
	
	private EClassifier resolve(EClassifier classifier) {
		return myTypeResolver.resolve(classifier);
	}

	private EClassifier[] resolve(EClassifier[] classifiers) {
		EClassifier[] result = new EClassifier[classifiers.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = resolve(classifiers[i]);
		}
		return result;
	}
	
	@Override
	public int hashCode() {
		return myName.hashCode();
	}
}

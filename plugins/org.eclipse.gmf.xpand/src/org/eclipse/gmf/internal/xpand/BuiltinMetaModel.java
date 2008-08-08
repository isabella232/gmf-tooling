/*
 * Copyright (c) 2006, 2008 Borland Software Corporation
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Artem Tikhomirov (Borland) - initial API and implementation
 */
package org.eclipse.gmf.internal.xpand;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandDefinitionWrap;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.util.TypeUtil;
import org.eclipse.ocl.utilities.UMLReflection;

/**
 * XXX Guess, will need special support to recognize the fact
 * EJavaObject.isSupertypeOf(EObject)
 * 
 * @author artem
 */
public class BuiltinMetaModel {
    public final static String SET = "Set";
    public final static String LIST = "List";

	
	private static EPackage XECORE = EcoreFactory.eINSTANCE.createEPackage();
	
	static {
		XECORE.setName("xecore");
		XECORE.setNsPrefix("xecore");
		XECORE.setNsURI("uri:org.eclipse.modeling/m2t/xpand/xecore/1.0");
	}

	public static final EClass DEFINITION_TYPE = EcoreFactory.eINSTANCE.createEClass();

	static {
		DEFINITION_TYPE.setName("xpand2::Definition");
		DEFINITION_TYPE.getESuperTypes().add(EcorePackage.eINSTANCE.getEClass()); // XXX perhaps, with OCL, some other superclassifier? 
		EOperation proceedOp = EcoreFactory.eINSTANCE.createEOperation();
		proceedOp.setName("proceed");
		proceedOp.setEType(EcorePackage.eINSTANCE.getEObject()); // FIXME not sure what do I need as a type here
		DEFINITION_TYPE.setInstanceClass(XpandDefinitionWrap.class);
		DEFINITION_TYPE.getEOperations().add(proceedOp);
		XECORE.getEClassifiers().add(DEFINITION_TYPE);
	}

	public static final EClass ITERATOR_TYPE = EcoreFactory.eINSTANCE.createEClass();

	static {
		ITERATOR_TYPE.setName("xpand2::Iterator");
		ITERATOR_TYPE.getESuperTypes().add(EcorePackage.eINSTANCE.getEClass());
		XECORE.getEClassifiers().add(ITERATOR_TYPE);
	}

	public static EClassifier getType(Object obj) {
		// XXX (1) not sure how Collections are handled
		// FIXME (2) need to support own types (IteratorType and DefinitionType)
//		if (obj instanceof Collection) {
//		EClassifier type = null;
//		if (!((Collection) obj).isEmpty()) {
//			// FIXME respect all! elements in the collection, not only the first one
//			type = getType(((Collection) obj).iterator().next());
//		}
//		if (obj instanceof Set) {
//			return collectionTypes.getSetType(type);
//		}
//		if (obj instanceof List) {
//			return collectionTypes.getListType(type);
//		}
//		return collectionTypes.getCollectionType(type);
//	}
//	if (obj instanceof XpandDefinitionWrap) {
//		return DEFINITION_TYPE;
//	}
//	if (obj instanceof XpandIterator) {
//		return ITERATOR_TYPE;
//	}
		return EcoreEnvironmentFactory.INSTANCE.createEvaluationEnvironment().getType(obj);
//		return TypeUtil.resolveType(ctx.getOCLEnvironment(), ee.getType(obj));
	}
	
	/**
	 * @param ctx 
	 * @return true if first argument is more general and second is more
	 *         specific, think Object and String
	 * @see AbstractTypeImpl.isAssignableFrom(this, t)
	 */
	public static boolean isAssignableFrom(ExecutionContext ctx, EClassifier t1, EClassifier t2) {
		return 0 != (UMLReflection.SUBTYPE & TypeUtil.getRelationship(ctx.getOCLEnvironment(), t2, t1));
	}
}

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

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.internal.xpand.model.ExecutionContext;
import org.eclipse.gmf.internal.xpand.model.XpandDefinitionWrap;
import org.eclipse.gmf.internal.xpand.model.XpandIterator;
import org.eclipse.ocl.TypeResolver;
import org.eclipse.ocl.ecore.EcoreEnvironment;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.expressions.CollectionKind;
import org.eclipse.ocl.types.OCLStandardLibrary;
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
		EOperation isFirstIteration = EcoreFactory.eINSTANCE.createEOperation();
		isFirstIteration.setName("isFirstIteration");
		isFirstIteration.setEType(EcorePackage.eINSTANCE.getEBoolean());
		EOperation isLastIteration = EcoreFactory.eINSTANCE.createEOperation();
		isLastIteration.setName("isLastIteration");
		isLastIteration.setEType(EcorePackage.eINSTANCE.getEBoolean());
		EOperation counter = EcoreFactory.eINSTANCE.createEOperation();
		counter.setName("counter");
		counter.setEType(EcorePackage.eINSTANCE.getELong());
		EOperation elements = EcoreFactory.eINSTANCE.createEOperation();
		elements.setName("elements");
		elements.setEType(EcorePackage.eINSTANCE.getELong());
		EOperation counter1 = EcoreFactory.eINSTANCE.createEOperation();
		counter1.setName("counter1");
		counter1.setEType(EcorePackage.eINSTANCE.getELong());
		ITERATOR_TYPE.getEOperations().add(isFirstIteration);
		ITERATOR_TYPE.getEOperations().add(isLastIteration);
		ITERATOR_TYPE.getEOperations().add(counter);
		ITERATOR_TYPE.getEOperations().add(counter1);
		ITERATOR_TYPE.getEOperations().add(elements);
		ITERATOR_TYPE.setInstanceClass(XpandIterator.class);
		XECORE.getEClassifiers().add(ITERATOR_TYPE);
	}

	public static EClassifier getType(ExecutionContext ctx, Object obj) {
		return getType(ctx.getOCLEnvironment(), obj);
	}

	public static EClassifier getType(EcoreEnvironment env, Object obj) {
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
		if (obj instanceof Collection<?>) {
			EClassifier firstElementType = ((Collection<?>) obj).isEmpty() ? null : getType(env, ((Collection<?>) obj).iterator().next());
			TypeResolver<EClassifier, EOperation, EStructuralFeature> tr = env.getTypeResolver();
			OCLStandardLibrary<EClassifier> stdLib = env.getOCLStandardLibrary();
			if (obj instanceof Set<?>) {
				// XXX odd TypeResolver - CollectionType returned is EDataType for Ecore, need to cast nevertheless
				return (EClassifier) tr.resolveCollectionType(CollectionKind.SET_LITERAL, firstElementType == null ? stdLib.getOclVoid() : firstElementType);
			}
			if (obj instanceof List<?>) {
				return (EClassifier) tr.resolveCollectionType(CollectionKind.SEQUENCE_LITERAL, firstElementType == null ? stdLib.getOclVoid() : firstElementType);
			}
			return (EClassifier) tr.resolveCollectionType(CollectionKind.COLLECTION_LITERAL, firstElementType == null ? stdLib.getOclVoid() : firstElementType);
		}
		/**
		 * It's not possible to determine a type (meta-object) of Enumeration
		 * instance, so returning EEnumerator from here wich will be specially
		 * processed in getRelationship()  method
		 */
		if (obj instanceof Enumerator) {
			return EcorePackage.eINSTANCE.getEEnumerator();
		}
		/**
		 * Workaround for current implementation of
		 * EcoreEnvironmentFactory.oclType(obj) - for now it returns OclAny
		 * instead of OclVoid if null was passed as a parameter
		 */
		if (obj == null) {
			return env.getOCLStandardLibrary().getOclVoid();
		}
		if (obj == env.getOCLStandardLibrary().getInvalid()) {
			return env.getOCLStandardLibrary().getOclInvalid();
		}
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
		return 0 != (UMLReflection.SUBTYPE & getRelationship(ctx.getOCLEnvironment(), t1, t2));
	}

	public static int getRelationship(EcoreEnvironment env, EClassifier t1, EClassifier t2) {
		/**
		 * Special processing for EEnumerator returned as a type for any
		 * enumeration instances - see above
		 */
		if (t1 instanceof EEnum && t2 == EcorePackage.eINSTANCE.getEEnumerator()) {
			return UMLReflection.SUBTYPE; // HACK - any enumerator instance can be assigned to any enum attribute. 
		}
		return TypeUtil.getRelationship(env, t2, t1);
	}
}

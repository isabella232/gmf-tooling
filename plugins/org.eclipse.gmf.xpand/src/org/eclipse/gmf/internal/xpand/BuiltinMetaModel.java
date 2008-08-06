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

import java.lang.reflect.Field;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;

/**
 * XXX Guess, will need special support to recognize the fact
 * EJavaObject.isSupertypeOf(EObject)
 * 
 * @author artem
 */
@SuppressWarnings("unchecked")
public class BuiltinMetaModel {
    public final static String SET = "Set";
    public final static String LIST = "List";

	
	private static EPackage XECORE = EcoreFactory.eINSTANCE.createEPackage();
	
	static {
		XECORE.setName("xecore");
		XECORE.setNsPrefix("xecore");
		XECORE.setNsURI("uri:org.eclipse.modeling/m2t/xpand/xecore/1.0");
	}

	private static EClass PARAMETERIZED_TYPE = EcoreFactory.eINSTANCE.createEClass();
	private static EReference PT_INNER_TYPE_REF = EcoreFactory.eINSTANCE.createEReference();
	private static EAttribute PT_INNER_TYPE_ATTR = EcoreFactory.eINSTANCE.createEAttribute();

	static {
		PARAMETERIZED_TYPE.setName("ParameterizedType");
		PARAMETERIZED_TYPE.getESuperTypes().add(EcorePackage.eINSTANCE.getEClass());
		PARAMETERIZED_TYPE.setAbstract(true);
		PT_INNER_TYPE_REF.setName("innerType");
		PT_INNER_TYPE_REF.setContainment(false);
		PT_INNER_TYPE_REF.setEType(EcorePackage.eINSTANCE.getEClass());

		PARAMETERIZED_TYPE.getEStructuralFeatures().add(PT_INNER_TYPE_REF);

		PT_INNER_TYPE_ATTR.setName("innerDataType");
		PT_INNER_TYPE_ATTR.setEType(EcorePackage.eINSTANCE.getEDataType());
		PARAMETERIZED_TYPE.getEStructuralFeatures().add(PT_INNER_TYPE_ATTR);
		XECORE.getEClassifiers().add(PARAMETERIZED_TYPE);
	}

	/**
	 * Checks whether classifier is one of user's model extension classes
	 * (conforming to ParameterizedType from our extended ECore meta-model).
	 * EClassifier instances available in analyze() methods are param
	 * candidates.
	 * 
	 * @param parameterizedTypeM1 -
	 *            e.g. EClass "Order", or XEClass "OrderList"
	 */
	public static boolean isParameterizedType(EClassifier parameterizedTypeM1) {
		return PARAMETERIZED_TYPE.isSuperTypeOf(parameterizedTypeM1.eClass());
	}

	// XXX revisit invocations, this check is doubled with isParameterizedType, perhaps, can refactor it 
	public static boolean isCollectionType(EClassifier parameterizedTypeM1) {
		// XXX this implementation is not really 'isCollectionType', it's just a copy of what was in the original code
		return isAssignableFrom(CollectionTypesSupport.COLLECTION_OF_OBJECT, parameterizedTypeM1);
	}

	public static EClassifier getInnerType(EClassifier parameterizedTypeM1) {
		assert isParameterizedType(parameterizedTypeM1);
		if (parameterizedTypeM1.eIsSet(PT_INNER_TYPE_REF)) {
			return (EClass) parameterizedTypeM1.eGet(PT_INNER_TYPE_REF);
		} else {
			return (EDataType) parameterizedTypeM1.eGet(PT_INNER_TYPE_ATTR);
		}
	}

	/**
	 * NOTE, parameterizedTypeM1 is M1 instance, you can't pass {@link BuiltinMetaModel#COLLECTION_TYPE} (or {@link BuiltinMetaModel#LIST_TYPE}) here,
	 * because COLLECTION_TYPE just extends PARAMETERIZED_TYPE, but still instance of EClass. We could, however, have COLLECTION_TYPE to be an
	 * instance of PARAMETERIZED_TYPE, and then we could use this method. The reasons not to do so (at least, now) are
	 * (a) didn't think it over yet (b) looks like extending M2 (sic!) dynamically, though I don't like even M1 polluting with type
	 * that happens.
	 * @param parameterizedTypeM1
	 * @param innerTypeM1
	 * @return
	 */
	public static EClass cloneParametrizedType(EClassifier parameterizedTypeM1, EClassifier innerTypeM1) {
		assert isParameterizedType(parameterizedTypeM1);
		return collectionTypes.getCollectionType(parameterizedTypeM1.eClass(), innerTypeM1);
	}

	/*package*/ static EClass internalNewParameterizedType(EClass parameterizedTypeM2, EClassifier inner) {
		assert PARAMETERIZED_TYPE.isSuperTypeOf(parameterizedTypeM2);
		EObject anInstance = XECORE.getEFactoryInstance().create(parameterizedTypeM2);
		assert anInstance instanceof EClass : "EClass is first supertype with instanceClass set";
		// e.g. "OrderCollection" or "IntegerList"
		((EClass) anInstance).setName(inner.getName() + parameterizedTypeM2.getName());
		anInstance.eSet(inner instanceof EClass ? PT_INNER_TYPE_REF : PT_INNER_TYPE_ATTR, inner);
		return (EClass) anInstance;
	}

	public static final EClass VOID = EcoreFactory.eINSTANCE.createEClass();

	static {
		VOID.setName("void");
		XECORE.getEClassifiers().add(VOID);
	}

	private static CollectionTypesSupport collectionTypes = new CollectionTypesSupport();

	static {
		collectionTypes.init(XECORE, PARAMETERIZED_TYPE);
	}
	/**
	 * @param name
	 * @return true if name is one of M2 collection meta-types (either Collection, List, Set)
	 */
	public static boolean isCollectionMetaType(String name) {
		return collectionTypes.isCollectionMetaType(name);
	}

	public static EClass getCollectionType(String metaTypeName, EClassifier innerType) {
		return collectionTypes.getCollectionType(metaTypeName, innerType);
	}

	// XXX actually, it's odd to use abstract and vague 'collection' 
	public static EClass getCollectionType(EClassifier innerType) {
		return collectionTypes.getCollectionType(innerType);
	}
	public static EClass getListType(EClassifier innerType) {
		return collectionTypes.getListType(innerType);
	}
	public static EClass getSetType(EClassifier innerType) {
		return collectionTypes.getSetType(innerType);
	}

	public static final EClass DEFINITION_TYPE = EcoreFactory.eINSTANCE.createEClass();

	static {
		DEFINITION_TYPE.setName("xpand2::Definition");
		DEFINITION_TYPE.getESuperTypes().add(EcorePackage.eINSTANCE.getEClass());
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
	 * @return true if first argument is more general and second is more
	 *         specific, think Object and String
	 * @see AbstractTypeImpl.isAssignableFrom(this, t)
	 */
	public static boolean isAssignableFrom(EClassifier c1, EClassifier t) {
		if ((t == null) || (c1 == null)) {
			return false;
		}
		if (BuiltinMetaModel.primEquals(c1, t)) {
			return true;
		}
		if (t.equals(VOID)) {
			return true;
		}
		if (false == (t instanceof EClass)) {
			if (c1 instanceof EEnum && t == EcorePackage.eINSTANCE.getEEnumerator()) {
				return true; // HACK - any enumerator instance can be assigned to any enum attribute. 
			}
			if (c1 instanceof EDataType && t instanceof EDataType) {
				return isCompatibleDataTypes((EDataType) c1, (EDataType) t);
			}
			return false;
		}
		if (c1 instanceof EDataType) {
			Class c1Class = ((EDataType) c1).getInstanceClass();
			return c1Class.isAssignableFrom(t.getInstanceClass() == null ? Object.class : t.getInstanceClass()); 
		}
		if (isParameterizedType(c1) && isParameterizedType(t)) {
			return c1.eClass().isSuperTypeOf(t.eClass()) && isAssignableFrom(getInnerType(c1), getInnerType(t));
		}
		// == c1.isSuperTypeOf(t);
		for (EClass superType : ((EClass) t).getEAllSuperTypes()) {
			if (BuiltinMetaModel.primEquals(superType, c1)) {
				return true;
			}
		}
		return false;
	}

	private static boolean primEquals(EClassifier c1, EClassifier obj) {
	    if (obj == null) {
			return false;
		}
	    if (c1 == obj) {
	        return true;
	    }
	    final boolean namesEqual = c1.getName().equals(obj.getName());
	    if (!namesEqual) {
	    	return false;
	    }
	    if (c1.getEPackage() == null) {
	    	return obj.getEPackage() == null;
	    }
    	if (obj.getEPackage() == null) {
    		return false;
    	}
    	if (c1.getEPackage().getNsURI() == null) {
    		return obj.getEPackage().getNsURI() == null;
    	}
   		return c1.getEPackage().getNsURI().equals(obj.getEPackage().getNsURI());  
	}

	private static boolean isCompatibleDataTypes(EDataType dt1, EDataType dt2) {
		try {
			final Class dt1Class = dt1.getInstanceClass();
			final Class dt2Class = dt2.getInstanceClass();
			if (dt1Class != null && dt2Class != null) {
				if (dt1Class == Object.class) {
					// anything (with or without wrapping) can be assigned to object
					return true;
				}
				if (dt1Class.isPrimitive() && !dt2Class.isPrimitive()) {
					Field f = dt2Class.getField("TYPE");
					return dt1Class.equals(f.get(null));
				} else if (!dt1Class.isPrimitive() && dt2Class.isPrimitive()) {
					Field f = dt1Class.getField("TYPE");
					return dt2Class.equals(f.get(null));
				}
				return dt1Class.isAssignableFrom(dt2Class);
			}
			if (dt1Class != null && dt2Class == null) {
				// special case for dt2 datatype from dynamic model instance
				// (e.g. model file in same workspace as template)
				// hence no instance classes yet, but anything is assignable to Object
				// Fixed while resolving #analyze of enum literals compare (==)
				return dt1Class == Object.class;
			}
		} catch (NoSuchFieldException ex) {
			// IGNORE
		} catch (IllegalAccessException ex) {
			// IGNORE
		}
		return false;
	}
}

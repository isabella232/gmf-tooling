/**
 */
package org.eclipse.gmf.example.lesscode.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.example.lesscode.LesscodePackage;
import org.eclipse.gmf.example.lesscode.MultiContainmentGroup;
import org.eclipse.gmf.example.lesscode.OneContainmentGroup;
import org.eclipse.gmf.example.lesscode.RootContainer;
import org.eclipse.gmf.example.lesscode.Subject;
import org.eclipse.gmf.example.lesscode.WithSomeAttributes;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.example.lesscode.LesscodePackage
 * @generated
 */
public class LesscodeAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LesscodePackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LesscodeAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = LesscodePackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LesscodeSwitch<Adapter> modelSwitch =
		new LesscodeSwitch<Adapter>() {
			@Override
			public Adapter caseRootContainer(RootContainer object) {
				return createRootContainerAdapter();
			}
			@Override
			public Adapter caseWithSomeAttributes(WithSomeAttributes object) {
				return createWithSomeAttributesAdapter();
			}
			@Override
			public Adapter caseSubject(Subject object) {
				return createSubjectAdapter();
			}
			@Override
			public Adapter caseOneContainmentGroup(OneContainmentGroup object) {
				return createOneContainmentGroupAdapter();
			}
			@Override
			public Adapter caseMultiContainmentGroup(MultiContainmentGroup object) {
				return createMultiContainmentGroupAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.example.lesscode.RootContainer <em>Root Container</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.example.lesscode.RootContainer
	 * @generated
	 */
	public Adapter createRootContainerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.example.lesscode.WithSomeAttributes <em>With Some Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.example.lesscode.WithSomeAttributes
	 * @generated
	 */
	public Adapter createWithSomeAttributesAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.example.lesscode.Subject <em>Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.example.lesscode.Subject
	 * @generated
	 */
	public Adapter createSubjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.example.lesscode.OneContainmentGroup <em>One Containment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.example.lesscode.OneContainmentGroup
	 * @generated
	 */
	public Adapter createOneContainmentGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.eclipse.gmf.example.lesscode.MultiContainmentGroup <em>Multi Containment Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.eclipse.gmf.example.lesscode.MultiContainmentGroup
	 * @generated
	 */
	public Adapter createMultiContainmentGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //LesscodeAdapterFactory

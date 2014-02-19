/**
 */
package org.eclipse.gmf.tooling.examples.svg;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.gmf.tooling.examples.svg.SvgFactory
 * @model kind="package"
 * @generated
 */
public interface SvgPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "svg";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://org.eclipse.gmf.tooling.examples.svg";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.eclipse.gmf.tooling.examples.svg";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SvgPackage eINSTANCE = org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.svg.impl.PlaygroundImpl <em>Playground</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.svg.impl.PlaygroundImpl
	 * @see org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl#getPlayground()
	 * @generated
	 */
	int PLAYGROUND = 0;

	/**
	 * The feature id for the '<em><b>Players</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYGROUND__PLAYERS = 0;

	/**
	 * The feature id for the '<em><b>Goals</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYGROUND__GOALS = 1;

	/**
	 * The number of structural features of the '<em>Playground</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYGROUND_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Playground</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYGROUND_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.svg.impl.PlayerImpl <em>Player</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.svg.impl.PlayerImpl
	 * @see org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl#getPlayer()
	 * @generated
	 */
	int PLAYER = 1;

	/**
	 * The number of structural features of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Player</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLAYER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.gmf.tooling.examples.svg.impl.GoalImpl <em>Goal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.gmf.tooling.examples.svg.impl.GoalImpl
	 * @see org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl#getGoal()
	 * @generated
	 */
	int GOAL = 2;

	/**
	 * The number of structural features of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Goal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GOAL_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.svg.Playground <em>Playground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Playground</em>'.
	 * @see org.eclipse.gmf.tooling.examples.svg.Playground
	 * @generated
	 */
	EClass getPlayground();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.svg.Playground#getPlayers <em>Players</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Players</em>'.
	 * @see org.eclipse.gmf.tooling.examples.svg.Playground#getPlayers()
	 * @see #getPlayground()
	 * @generated
	 */
	EReference getPlayground_Players();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.gmf.tooling.examples.svg.Playground#getGoals <em>Goals</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Goals</em>'.
	 * @see org.eclipse.gmf.tooling.examples.svg.Playground#getGoals()
	 * @see #getPlayground()
	 * @generated
	 */
	EReference getPlayground_Goals();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.svg.Player <em>Player</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Player</em>'.
	 * @see org.eclipse.gmf.tooling.examples.svg.Player
	 * @generated
	 */
	EClass getPlayer();

	/**
	 * Returns the meta object for class '{@link org.eclipse.gmf.tooling.examples.svg.Goal <em>Goal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Goal</em>'.
	 * @see org.eclipse.gmf.tooling.examples.svg.Goal
	 * @generated
	 */
	EClass getGoal();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SvgFactory getSvgFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.svg.impl.PlaygroundImpl <em>Playground</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.svg.impl.PlaygroundImpl
		 * @see org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl#getPlayground()
		 * @generated
		 */
		EClass PLAYGROUND = eINSTANCE.getPlayground();

		/**
		 * The meta object literal for the '<em><b>Players</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYGROUND__PLAYERS = eINSTANCE.getPlayground_Players();

		/**
		 * The meta object literal for the '<em><b>Goals</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLAYGROUND__GOALS = eINSTANCE.getPlayground_Goals();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.svg.impl.PlayerImpl <em>Player</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.svg.impl.PlayerImpl
		 * @see org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl#getPlayer()
		 * @generated
		 */
		EClass PLAYER = eINSTANCE.getPlayer();

		/**
		 * The meta object literal for the '{@link org.eclipse.gmf.tooling.examples.svg.impl.GoalImpl <em>Goal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.gmf.tooling.examples.svg.impl.GoalImpl
		 * @see org.eclipse.gmf.tooling.examples.svg.impl.SvgPackageImpl#getGoal()
		 * @generated
		 */
		EClass GOAL = eINSTANCE.getGoal();

	}

} //SvgPackage

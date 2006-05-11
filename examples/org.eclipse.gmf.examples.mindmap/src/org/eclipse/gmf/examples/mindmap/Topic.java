/**
 * <copyright>
 * </copyright>
 *
 * $Id: Topic.java,v 1.1 2006/05/11 01:47:59 rgronback Exp $
 */
package org.eclipse.gmf.examples.mindmap;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Topic</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getSubtopics <em>Subtopics</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getResources <em>Resources</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getPercentComplete <em>Percent Complete</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getPriority <em>Priority</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getStartDate <em>Start Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getEndDate <em>End Date</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getDuration <em>Duration</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Topic#getComments <em>Comments</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic()
 * @model
 * @generated
 */
public interface Topic extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Topic#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Subtopics</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Topic}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtopics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtopics</em>' reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_Subtopics()
	 * @model type="org.eclipse.gmf.examples.mindmap.Topic"
	 * @generated
	 */
	EList getSubtopics();

	/**
	 * Returns the value of the '<em><b>Resources</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Resource}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.mindmap.Resource#getTopics <em>Topics</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resources</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resources</em>' reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_Resources()
	 * @see org.eclipse.gmf.examples.mindmap.Resource#getTopics
	 * @model type="org.eclipse.gmf.examples.mindmap.Resource" opposite="topics"
	 * @generated
	 */
	EList getResources();

	/**
	 * Returns the value of the '<em><b>Percent Complete</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Percent Complete</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Percent Complete</em>' attribute.
	 * @see #setPercentComplete(Float)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_PercentComplete()
	 * @model default="0"
	 * @generated
	 */
	Float getPercentComplete();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Topic#getPercentComplete <em>Percent Complete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Percent Complete</em>' attribute.
	 * @see #getPercentComplete()
	 * @generated
	 */
	void setPercentComplete(Float value);

	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.gmf.examples.mindmap.Priority}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see org.eclipse.gmf.examples.mindmap.Priority
	 * @see #setPriority(Priority)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_Priority()
	 * @model
	 * @generated
	 */
	Priority getPriority();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Topic#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see org.eclipse.gmf.examples.mindmap.Priority
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(Priority value);

	/**
	 * Returns the value of the '<em><b>Start Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Date</em>' attribute.
	 * @see #setStartDate(Date)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_StartDate()
	 * @model
	 * @generated
	 */
	Date getStartDate();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Topic#getStartDate <em>Start Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Date</em>' attribute.
	 * @see #getStartDate()
	 * @generated
	 */
	void setStartDate(Date value);

	/**
	 * Returns the value of the '<em><b>End Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Date</em>' attribute.
	 * @see #setEndDate(Date)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_EndDate()
	 * @model
	 * @generated
	 */
	Date getEndDate();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Topic#getEndDate <em>End Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Date</em>' attribute.
	 * @see #getEndDate()
	 * @generated
	 */
	void setEndDate(Date value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' attribute.
	 * @see #setDuration(Float)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_Duration()
	 * @model default="0"
	 * @generated
	 */
	Float getDuration();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Topic#getDuration <em>Duration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' attribute.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Float value);

	/**
	 * Returns the value of the '<em><b>Comments</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.Thread}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comments</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comments</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getTopic_Comments()
	 * @model type="org.eclipse.gmf.examples.mindmap.Thread" containment="true"
	 * @generated
	 */
	EList getComments();

} // Topic
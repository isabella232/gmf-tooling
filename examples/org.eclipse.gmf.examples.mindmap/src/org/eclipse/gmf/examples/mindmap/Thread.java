/**
 * <copyright>
 * </copyright>
 *
 * $Id: Thread.java,v 1.1 2006/05/11 01:47:59 rgronback Exp $
 */
package org.eclipse.gmf.examples.mindmap;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Thread#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Thread#getSubject <em>Subject</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Thread#getItems <em>Items</em>}</li>
 *   <li>{@link org.eclipse.gmf.examples.mindmap.Thread#getPostDate <em>Post Date</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getThread()
 * @model
 * @generated
 */
public interface Thread extends EObject {
	/**
	 * Returns the value of the '<em><b>Author</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.examples.mindmap.Resource#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' reference.
	 * @see #setAuthor(Resource)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getThread_Author()
	 * @see org.eclipse.gmf.examples.mindmap.Resource#getComments
	 * @model opposite="comments"
	 * @generated
	 */
	Resource getAuthor();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Thread#getAuthor <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(Resource value);

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' attribute.
	 * @see #setSubject(String)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getThread_Subject()
	 * @model
	 * @generated
	 */
	String getSubject();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Thread#getSubject <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' attribute.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(String value);

	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.gmf.examples.mindmap.ThreadItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getThread_Items()
	 * @model type="org.eclipse.gmf.examples.mindmap.ThreadItem" containment="true"
	 * @generated
	 */
	EList getItems();

	/**
	 * Returns the value of the '<em><b>Post Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Date</em>' attribute.
	 * @see #setPostDate(Date)
	 * @see org.eclipse.gmf.examples.mindmap.MindmapPackage#getThread_PostDate()
	 * @model required="true"
	 * @generated
	 */
	Date getPostDate();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.examples.mindmap.Thread#getPostDate <em>Post Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Date</em>' attribute.
	 * @see #getPostDate()
	 * @generated
	 */
	void setPostDate(Date value);

} // Thread
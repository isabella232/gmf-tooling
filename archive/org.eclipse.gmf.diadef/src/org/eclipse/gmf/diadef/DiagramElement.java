/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.gmf.diadef;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagram Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.diadef.DiagramElement#isNeedsTool <em>Needs Tool</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.DiagramElement#getToolGroupID <em>Tool Group ID</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.DiagramElement#getSmallIconPath <em>Small Icon Path</em>}</li>
 *   <li>{@link org.eclipse.gmf.diadef.DiagramElement#getLargeIconPath <em>Large Icon Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getDiagramElement()
 * @model abstract="true"
 * @generated
 */
public interface DiagramElement extends CommonBase{
	/**
	 * Returns the value of the '<em><b>Needs Tool</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Needs Tool</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Needs Tool</em>' attribute.
	 * @see #setNeedsTool(boolean)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getDiagramElement_NeedsTool()
	 * @model default="true"
	 * @generated
	 */
	boolean isNeedsTool();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.DiagramElement#isNeedsTool <em>Needs Tool</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Needs Tool</em>' attribute.
	 * @see #isNeedsTool()
	 * @generated
	 */
	void setNeedsTool(boolean value);

	/**
	 * Returns the value of the '<em><b>Tool Group ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Tool Group ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tool Group ID</em>' attribute.
	 * @see #setToolGroupID(String)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getDiagramElement_ToolGroupID()
	 * @model
	 * @generated
	 */
	String getToolGroupID();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.DiagramElement#getToolGroupID <em>Tool Group ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tool Group ID</em>' attribute.
	 * @see #getToolGroupID()
	 * @generated
	 */
	void setToolGroupID(String value);

	/**
	 * Returns the value of the '<em><b>Small Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Small Icon Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Small Icon Path</em>' attribute.
	 * @see #setSmallIconPath(String)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getDiagramElement_SmallIconPath()
	 * @model
	 * @generated
	 */
	String getSmallIconPath();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.DiagramElement#getSmallIconPath <em>Small Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Small Icon Path</em>' attribute.
	 * @see #getSmallIconPath()
	 * @generated
	 */
	void setSmallIconPath(String value);

	/**
	 * Returns the value of the '<em><b>Large Icon Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Large Icon Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Large Icon Path</em>' attribute.
	 * @see #setLargeIconPath(String)
	 * @see org.eclipse.gmf.diadef.DiagramDefinitionPackage#getDiagramElement_LargeIconPath()
	 * @model
	 * @generated
	 */
	String getLargeIconPath();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.diadef.DiagramElement#getLargeIconPath <em>Large Icon Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Large Icon Path</em>' attribute.
	 * @see #getLargeIconPath()
	 * @generated
	 */
	void setLargeIconPath(String value);

} // DiagramElement

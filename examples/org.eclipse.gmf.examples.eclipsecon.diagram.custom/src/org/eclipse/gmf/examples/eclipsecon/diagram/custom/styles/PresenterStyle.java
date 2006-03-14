package org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles;

import org.eclipse.gmf.runtime.notation.Style;


/**
 * @author sshaw
 * @model 
 */
public interface PresenterStyle
    extends Style{

    /**
     * @model default="new Boolean(true)"
     */
    Boolean getDisplayAsDefault();

    /**
     * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getDisplayAsDefault <em>Display As Default</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Display As Default</em>' attribute.
     * @see #getDisplayAsDefault()
     * @generated
     */
    void setDisplayAsDefault(Boolean value);

    /**
     * Returns the value of the '<em><b>Description</b></em>' attribute.
     * The default value is <code>""</code>.
     * @model default=""
     */
    String getImageURL();
    
    /**
     * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getImageURL <em>Image URL</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Image URL</em>' attribute.
     * @see #getImageURL()
     * @generated
     */
    void setImageURL(String value);

    /**
     * @return
     * @model default=""
     */
    String getReview();

    /**
     * Sets the value of the '{@link org.eclipse.gmf.examples.eclipsecon.diagram.custom.styles.PresenterStyle#getReview <em>Review</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Review</em>' attribute.
     * @see #getReview()
     * @generated
     */
    void setReview(String value);

}

/**
 */
package org.eclipse.gmf.codegen.gmfgen;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Gen Template Invocation Base</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocationBase#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocationBase#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocationBase#getTemplateFqn <em>Template Fqn</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocationBase()
 * @model abstract="true"
 * @generated
 */
public interface GenTemplateInvocationBase extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.gmf.codegen.gmfgen.GenCustomGeneratorExtension#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' container reference.
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocationBase_Extension()
	 * @see org.eclipse.gmf.codegen.gmfgen.GenCustomGeneratorExtension#getInvocations
	 * @model opposite="invocations" resolveProxies="false" required="true" transient="false" changeable="false"
	 * @generated
	 */
	GenCustomGeneratorExtension getExtension();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * User friendly description for this invocation, used only in UI
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocationBase_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocationBase#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Template Fqn</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * FQN of xPand template to invoke in the standard form of abc::def::TemplateName#rootExpand
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Template Fqn</em>' attribute.
	 * @see #setTemplateFqn(String)
	 * @see org.eclipse.gmf.codegen.gmfgen.GMFGenPackage#getGenTemplateInvocationBase_TemplateFqn()
	 * @model
	 * @generated
	 */
	String getTemplateFqn();

	/**
	 * Sets the value of the '{@link org.eclipse.gmf.codegen.gmfgen.GenTemplateInvocationBase#getTemplateFqn <em>Template Fqn</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Template Fqn</em>' attribute.
	 * @see #getTemplateFqn()
	 * @generated
	 */
	void setTemplateFqn(String value);

} // GenTemplateInvocationBase

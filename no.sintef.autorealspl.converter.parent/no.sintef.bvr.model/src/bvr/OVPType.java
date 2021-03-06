/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>OVP Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>OVPType (Opaque Variation Point type) is a model transformation pattern which may be used to define an opaque variation point.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link bvr.OVPType#getSpec <em>Spec</em>}</li>
 * </ul>
 * </p>
 *
 * @see bvr.BvrPackage#getOVPType()
 * @model
 * @generated
 */
public interface OVPType extends VPackageable {
	/**
	 * Returns the value of the '<em><b>Spec</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>Reference to the specification.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Spec</em>' containment reference.
	 * @see #setSpec(OVPSemanticSpec)
	 * @see bvr.BvrPackage#getOVPType_Spec()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	OVPSemanticSpec getSpec();

	/**
	 * Sets the value of the '{@link bvr.OVPType#getSpec <em>Spec</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spec</em>' containment reference.
	 * @see #getSpec()
	 * @generated
	 */
	void setSpec(OVPSemanticSpec value);

} // OVPType

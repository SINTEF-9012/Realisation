/*******************************************************************************
 * Copyright (c)
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 ******************************************************************************/
/**
 */
package bvr.impl;

import bvr.BvrPackage;
import bvr.OVPSemanticSpec;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>OVP Semantic Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link bvr.impl.OVPSemanticSpecImpl#getModelTransformation <em>Model Transformation</em>}</li>
 *   <li>{@link bvr.impl.OVPSemanticSpecImpl#getTransfromationLanguage <em>Transfromation Language</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OVPSemanticSpecImpl extends MinimalEObjectImpl.Container implements OVPSemanticSpec {
	/**
	 * The default value of the '{@link #getModelTransformation() <em>Model Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelTransformation()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_TRANSFORMATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelTransformation() <em>Model Transformation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelTransformation()
	 * @generated
	 * @ordered
	 */
	protected String modelTransformation = MODEL_TRANSFORMATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransfromationLanguage() <em>Transfromation Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfromationLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSFROMATION_LANGUAGE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransfromationLanguage() <em>Transfromation Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransfromationLanguage()
	 * @generated
	 * @ordered
	 */
	protected String transfromationLanguage = TRANSFROMATION_LANGUAGE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OVPSemanticSpecImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return BvrPackage.Literals.OVP_SEMANTIC_SPEC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getModelTransformation() {
		return modelTransformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModelTransformation(String newModelTransformation) {
		String oldModelTransformation = modelTransformation;
		modelTransformation = newModelTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION, oldModelTransformation, modelTransformation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransfromationLanguage() {
		return transfromationLanguage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransfromationLanguage(String newTransfromationLanguage) {
		String oldTransfromationLanguage = transfromationLanguage;
		transfromationLanguage = newTransfromationLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BvrPackage.OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE, oldTransfromationLanguage, transfromationLanguage));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case BvrPackage.OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION:
				return getModelTransformation();
			case BvrPackage.OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE:
				return getTransfromationLanguage();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case BvrPackage.OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION:
				setModelTransformation((String)newValue);
				return;
			case BvrPackage.OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE:
				setTransfromationLanguage((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case BvrPackage.OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION:
				setModelTransformation(MODEL_TRANSFORMATION_EDEFAULT);
				return;
			case BvrPackage.OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE:
				setTransfromationLanguage(TRANSFROMATION_LANGUAGE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case BvrPackage.OVP_SEMANTIC_SPEC__MODEL_TRANSFORMATION:
				return MODEL_TRANSFORMATION_EDEFAULT == null ? modelTransformation != null : !MODEL_TRANSFORMATION_EDEFAULT.equals(modelTransformation);
			case BvrPackage.OVP_SEMANTIC_SPEC__TRANSFROMATION_LANGUAGE:
				return TRANSFROMATION_LANGUAGE_EDEFAULT == null ? transfromationLanguage != null : !TRANSFROMATION_LANGUAGE_EDEFAULT.equals(transfromationLanguage);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (modelTransformation: ");
		result.append(modelTransformation);
		result.append(", transfromationLanguage: ");
		result.append(transfromationLanguage);
		result.append(')');
		return result.toString();
	}

} //OVPSemanticSpecImpl

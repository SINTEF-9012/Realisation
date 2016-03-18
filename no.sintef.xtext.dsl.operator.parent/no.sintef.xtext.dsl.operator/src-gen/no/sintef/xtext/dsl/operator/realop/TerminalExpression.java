/**
 * generated by Xtext 2.9.2
 */
package no.sintef.xtext.dsl.operator.realop;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Terminal Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link no.sintef.xtext.dsl.operator.realop.TerminalExpression#getOp <em>Op</em>}</li>
 *   <li>{@link no.sintef.xtext.dsl.operator.realop.TerminalExpression#getRhs <em>Rhs</em>}</li>
 * </ul>
 *
 * @see no.sintef.xtext.dsl.operator.realop.RealopPackage#getTerminalExpression()
 * @model
 * @generated
 */
public interface TerminalExpression extends EObject
{
  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Op</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see no.sintef.xtext.dsl.operator.realop.RealopPackage#getTerminalExpression_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link no.sintef.xtext.dsl.operator.realop.TerminalExpression#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Rhs</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rhs</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rhs</em>' containment reference.
   * @see #setRhs(Expression)
   * @see no.sintef.xtext.dsl.operator.realop.RealopPackage#getTerminalExpression_Rhs()
   * @model containment="true"
   * @generated
   */
  Expression getRhs();

  /**
   * Sets the value of the '{@link no.sintef.xtext.dsl.operator.realop.TerminalExpression#getRhs <em>Rhs</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Rhs</em>' containment reference.
   * @see #getRhs()
   * @generated
   */
  void setRhs(Expression value);

} // TerminalExpression

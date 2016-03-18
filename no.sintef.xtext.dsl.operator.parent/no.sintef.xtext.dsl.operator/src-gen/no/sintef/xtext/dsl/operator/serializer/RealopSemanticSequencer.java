/*
 * generated by Xtext 2.9.2
 */
package no.sintef.xtext.dsl.operator.serializer;

import com.google.inject.Inject;
import java.util.Set;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.Predicate;
import no.sintef.xtext.dsl.operator.realop.Realop;
import no.sintef.xtext.dsl.operator.realop.RealopPackage;
import no.sintef.xtext.dsl.operator.realop.TerminalExpression;
import no.sintef.xtext.dsl.operator.services.RealopGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class RealopSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private RealopGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == RealopPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case RealopPackage.EXPRESSION:
				sequence_Expression(context, (Expression) semanticObject); 
				return; 
			case RealopPackage.OPERATOR:
				sequence_Operator(context, (Operator) semanticObject); 
				return; 
			case RealopPackage.PREDICATE:
				sequence_Predicate(context, (Predicate) semanticObject); 
				return; 
			case RealopPackage.REALOP:
				sequence_Realop(context, (Realop) semanticObject); 
				return; 
			case RealopPackage.TERMINAL_EXPRESSION:
				sequence_TerminalExpression(context, (TerminalExpression) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     Expression returns Expression
	 *
	 * Constraint:
	 *     (lhs=Predicate rhs=TerminalExpression?)
	 */
	protected void sequence_Expression(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Operator returns Operator
	 *
	 * Constraint:
	 *     (name=ID exp_pre=Expression exp_post=Expression)
	 */
	protected void sequence_Operator(ISerializationContext context, Operator semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RealopPackage.Literals.OPERATOR__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RealopPackage.Literals.OPERATOR__NAME));
			if (transientValues.isValueTransient(semanticObject, RealopPackage.Literals.OPERATOR__EXP_PRE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RealopPackage.Literals.OPERATOR__EXP_PRE));
			if (transientValues.isValueTransient(semanticObject, RealopPackage.Literals.OPERATOR__EXP_POST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RealopPackage.Literals.OPERATOR__EXP_POST));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOperatorAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getOperatorAccess().getExp_preExpressionParserRuleCall_5_0(), semanticObject.getExp_pre());
		feeder.accept(grammarAccess.getOperatorAccess().getExp_postExpressionParserRuleCall_9_0(), semanticObject.getExp_post());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Predicate returns Predicate
	 *
	 * Constraint:
	 *     (negate?=NOT_TOKEN? predicate=Predicates name=ID)
	 */
	protected void sequence_Predicate(ISerializationContext context, Predicate semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Realop returns Realop
	 *
	 * Constraint:
	 *     operator+=Operator+
	 */
	protected void sequence_Realop(ISerializationContext context, Realop semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     TerminalExpression returns TerminalExpression
	 *
	 * Constraint:
	 *     (op=Logic rhs=Expression)
	 */
	protected void sequence_TerminalExpression(ISerializationContext context, TerminalExpression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, RealopPackage.Literals.TERMINAL_EXPRESSION__OP) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RealopPackage.Literals.TERMINAL_EXPRESSION__OP));
			if (transientValues.isValueTransient(semanticObject, RealopPackage.Literals.TERMINAL_EXPRESSION__RHS) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, RealopPackage.Literals.TERMINAL_EXPRESSION__RHS));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getOpLogicParserRuleCall_0_0(), semanticObject.getOp());
		feeder.accept(grammarAccess.getTerminalExpressionAccess().getRhsExpressionParserRuleCall_1_0(), semanticObject.getRhs());
		feeder.finish();
	}
	
	
}

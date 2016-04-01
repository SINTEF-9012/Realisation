package no.sintef.bvr.planner.repository.ecore;

import no.sintef.bvr.planner.operators.And;
import no.sintef.bvr.planner.operators.Not;
import no.sintef.bvr.planner.operators.interfaces.IExpression;
import no.sintef.bvr.planner.operators.interfaces.IOperator;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.xtext.dsl.operator.realop.AndExp;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.IsNegative;
import no.sintef.xtext.dsl.operator.realop.IsPositive;
import no.sintef.xtext.dsl.operator.realop.IsRealised;
import no.sintef.xtext.dsl.operator.realop.NotExp;
import no.sintef.xtext.dsl.operator.realop.Operator;

public class EcoreOperatorConverter {
	
	private IOperator operator;
	private IExpression preExp;
	private IExpression postExp;
		
	public IOperator convert(Operator ecore_operator) throws ReaderException {
		preExp = convertExpression(ecore_operator.getExpPre(), preExp);
		postExp = convertExpression(ecore_operator.getExpPost(), postExp);
		
		operator = new no.sintef.bvr.planner.operators.Operator(ecore_operator.getName(), preExp, postExp);
		
		return operator;
	}
	
	private IExpression convertExpression(Expression ecore_exp, IExpression result) throws ReaderException {
		if(isExpression(ecore_exp))
			return convertIsExpression(ecore_exp, result);
		
		if(ecore_exp instanceof AndExp) {
			AndExp ecore_and = (AndExp) ecore_exp;
			IExpression left = convertExpression(ecore_and.getLeft(), result);
			IExpression right = convertExpression(ecore_and.getRight(), result);
			result = new And(left, right);
		} else if (ecore_exp instanceof NotExp) {
			NotExp ecore_not = (NotExp) ecore_exp;
			IExpression exp = convertExpression(ecore_not.getExp(), result);
			result = new Not(exp);
		} else {
			throw new ReaderException("do not know how to conver " + ecore_exp);
		}
		
		return result;
	}
	
	private IExpression convertIsExpression(Expression ecore_isexp, IExpression result) throws ReaderException {
		
		if(ecore_isexp instanceof IsRealised) {
			result = new no.sintef.bvr.planner.operators.IsRealised(((IsRealised) ecore_isexp).getFeatureName());
		} else if (ecore_isexp instanceof IsPositive) {
			result = new no.sintef.bvr.planner.operators.IsPositive(((IsPositive) ecore_isexp).getFeatureName());
		} else if (ecore_isexp instanceof IsNegative) {
			result = new no.sintef.bvr.planner.operators.IsNegative(((IsNegative) ecore_isexp).getFeatureName());
		} else {
			throw new ReaderException("do not know how to conver " + ecore_isexp);
		}
		return result;
	}
	
	private boolean isExpression(Expression exp) {
		return (exp instanceof IsRealised || exp instanceof IsNegative || exp instanceof IsPositive);
	}
	
	

}

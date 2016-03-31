package no.sintef.autorealspl.converter.operconverter;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.BoolExpression;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.IsExpression;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.RealopFactory;


public class NegativeOperatorConverter implements IFeatureOperatorConverterStrategy {

	public Operator convertIFeatureToOperator(IFeature feature) {
		Operator operator = RealopFactory.eINSTANCE.createOperator();
		operator.setName(feature.getName()+"Neg");
		
		Expression pre_exp = RealopFactory.eINSTANCE.createExpression();
		
		BoolExpression predicate_pre = RealopFactory.eINSTANCE.createBoolExpression();
		predicate_pre.setNegated(true);
		predicate_pre.setName(feature.getName());
		
	
		IsExpression realised = RealopFactory.eINSTANCE.createIsExpression();
		realised.setRealised(true);
		
		predicate_pre.setIsExpression(realised);
		
		pre_exp.setLhs(predicate_pre);
		operator.setExp_pre(pre_exp);
		
		
		Expression post_exp = RealopFactory.eINSTANCE.createExpression();
		
		BoolExpression predicate_post = RealopFactory.eINSTANCE.createBoolExpression();
		predicate_post.setName(feature.getName());
		
		IsExpression positive_post = RealopFactory.eINSTANCE.createIsExpression();
		positive_post.setNegative(true);
		
		predicate_post.setIsExpression(positive_post);
		
		post_exp.setLhs(predicate_post);
		
		operator.setExp_post(post_exp);
		return operator;
	}

}

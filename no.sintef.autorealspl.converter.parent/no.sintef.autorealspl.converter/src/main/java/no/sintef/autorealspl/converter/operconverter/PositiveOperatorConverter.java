package no.sintef.autorealspl.converter.operconverter;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.Predicate;
import no.sintef.xtext.dsl.operator.realop.Predicates;
import no.sintef.xtext.dsl.operator.realop.RealopFactory;


public class PositiveOperatorConverter implements IFeatureOperatorConverterStrategy {

	public Operator convertIFeatureToOperator(IFeature feature) {
		Operator operator = RealopFactory.eINSTANCE.createOperator();
		operator.setName(feature.getName()+"Pos");
		
		Expression pre_exp = RealopFactory.eINSTANCE.createExpression();
		
		Predicate predicate_pre = RealopFactory.eINSTANCE.createPredicate();
		predicate_pre.setNegated(true);
		predicate_pre.setName(feature.getName());
		
		Predicates realised_pre = RealopFactory.eINSTANCE.createPredicates();
		realised_pre.setRealised(true);
		
		predicate_pre.setPredicate(realised_pre);
		
		pre_exp.setLhs(predicate_pre);
		operator.setExp_pre(pre_exp);
		
		
		Expression post_exp = RealopFactory.eINSTANCE.createExpression();
		
		Predicate predicate_post = RealopFactory.eINSTANCE.createPredicate();
		predicate_post.setName(feature.getName());
		
		Predicates positive_post = RealopFactory.eINSTANCE.createPredicates();
		positive_post.setPositive(true);
		
		predicate_post.setPredicate(positive_post);
		
		post_exp.setLhs(predicate_post);
		
		operator.setExp_post(post_exp);
		return operator;
	}

}

package no.sintef.autorealspl.converter.operconverter;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.IsPositive;
import no.sintef.xtext.dsl.operator.realop.IsRealised;
import no.sintef.xtext.dsl.operator.realop.Not;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.RealopFactory;


public class PositiveOperatorConverter implements IFeatureOperatorConverterStrategy {

	public Operator convertIFeatureToOperator(IFeature feature) {
		Operator operator = RealopFactory.eINSTANCE.createOperator();
		operator.setName(feature.getName()+"Pos");
		
		
		Not not_exp = RealopFactory.eINSTANCE.createNot();
		IsRealised predicate_pre = RealopFactory.eINSTANCE.createIsRealised();
		predicate_pre.setFeatureName(feature.getName());
		not_exp.setExp(predicate_pre);
		
		
		
		IsPositive predicate_post = RealopFactory.eINSTANCE.createIsPositive();
		predicate_post.setFeatureName(feature.getName());
		

		operator.setExpPre(not_exp);
		operator.setExpPost(predicate_post);
		
		return operator;
	}

}

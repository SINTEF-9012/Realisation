package no.sintef.autorealspl.converter.operconverter;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.IsNegative;
import no.sintef.xtext.dsl.operator.realop.IsRealised;
import no.sintef.xtext.dsl.operator.realop.Not;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.RealopFactory;


public class NegativeOperatorConverter implements IFeatureOperatorConverterStrategy {

	public Operator convertIFeatureToOperator(IFeature feature) {
		Operator operator = RealopFactory.eINSTANCE.createOperator();
		operator.setName(feature.getName()+"Neg");
		
		Not not_pre = RealopFactory.eINSTANCE.createNot();
		IsRealised realised = RealopFactory.eINSTANCE.createIsRealised();
		realised.setFeatureName(feature.getName());
		not_pre.setExp(realised);
		
		operator.setExpPre(not_pre);
				
		IsNegative positive_post = RealopFactory.eINSTANCE.createIsNegative();
		positive_post.setFeatureName(feature.getName());
		
		operator.setExpPost(positive_post);
		return operator;
	}

}

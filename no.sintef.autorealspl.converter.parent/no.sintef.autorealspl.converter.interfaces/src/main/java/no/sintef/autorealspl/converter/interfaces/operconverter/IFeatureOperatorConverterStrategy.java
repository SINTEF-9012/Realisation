package no.sintef.autorealspl.converter.interfaces.operconverter;

import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.Operator;

public interface IFeatureOperatorConverterStrategy {
	
	public Operator convertIFeatureToOperator(IFeature feature);

}

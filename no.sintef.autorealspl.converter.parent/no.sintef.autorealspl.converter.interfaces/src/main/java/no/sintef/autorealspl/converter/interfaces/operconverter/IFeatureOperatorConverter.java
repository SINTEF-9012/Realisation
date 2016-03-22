package no.sintef.autorealspl.converter.interfaces.operconverter;

import java.util.List;

import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.Operator;

public interface IFeatureOperatorConverter {
	
	public List<Operator> convertToOperators(IFeature feature);
	
	public void addConverterStrategy(IFeatureOperatorConverterStrategy strategy);

}

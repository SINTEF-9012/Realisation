package no.sintef.autorealspl.converter.operconverter;

import java.util.ArrayList;
import java.util.List;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverter;
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.xtext.dsl.operator.realop.Operator;

public class FeatureOperatorConvertor implements IFeatureOperatorConverter {
	
	List<IFeatureOperatorConverterStrategy> strategies;
	
	public FeatureOperatorConvertor() {
		strategies = new ArrayList<IFeatureOperatorConverterStrategy>();
	}

	public List<Operator> convertToOperators(IFeature feature) {
		List<Operator> operators = new ArrayList<Operator>();
		
		for(IFeatureOperatorConverterStrategy strategy : strategies)
			operators.add(strategy.convertIFeatureToOperator(feature));
		
		return operators;
	}

	public void addConverterStrategy(IFeatureOperatorConverterStrategy strategy) {
		strategies.add(strategy);
	}

}

package no.sintef.autorealspl.converter.main;

import java.util.List;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverter;
import no.sintef.autorealspl.converter.interfaces.operconverter.IOperatorSerializer;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;
import no.sintef.xtext.dsl.operator.realop.Operator;

public interface IConverter {

	public void readVariabilityModelFromFile(String str);
	
	public void convertVariabilityModelToOperators();
	
	public void writeOperatorsToFile(String str);
	
	public List<Operator> getGeneratodOperators();
	
	public void setVariabityModelParser(IVariabilityModelParser parser);
	
	public void setFeaturerOperatorConverter(IFeatureOperatorConverter operatorConverter);
	
	public void setOperatorSerializer(IOperatorSerializer serializer);
}

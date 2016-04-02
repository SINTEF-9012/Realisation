package no.sintef.bvr.planner.repository.ecore;

import java.util.List;

import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverter;
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.autorealspl.converter.operconverter.FeatureOperatorConvertor;
import no.sintef.autorealspl.converter.operconverter.NegativeOperatorConverter;
import no.sintef.autorealspl.converter.operconverter.PositiveOperatorConverter;
import no.sintef.autorealspl.converter.operconverter.XtextFileSrcOperatorSerializer;
import no.sintef.autorealspl.converter.parser.BVRModelParserStrategy;
import no.sintef.autorealspl.converter.parser.VariabiltiyModelParser;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.operators.interfaces.IOperator;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;
import no.sintef.bvr.planner.repository.interfaces.IOperatorGenenerator;
import no.sintef.xtext.dsl.operator.realop.Operator;

public class EcoreBVROperatorsGenerator implements IOperatorGenenerator {
	
	private IConverter converter;
	private String bvr_model;
	private String realop_file;
	private EcoreOperatorConverter ecore_op_conv;

	public EcoreBVROperatorsGenerator(IConverter _converter, String _bvr_model, String _realop_file) {
		converter = _converter;
		bvr_model = _bvr_model;
		realop_file = _realop_file;
		
		converter.setVariabityModelParser(new VariabiltiyModelParser(new BVRModelParserStrategy()));
		converter.setOperatorSerializer(new XtextFileSrcOperatorSerializer());
		
		IFeatureOperatorConverter feature_converter = new FeatureOperatorConvertor();
		IFeatureOperatorConverterStrategy positiveConveterStrategy = new PositiveOperatorConverter();
		IFeatureOperatorConverterStrategy negativeConvererStrategy = new NegativeOperatorConverter();
		feature_converter.addConverterStrategy(positiveConveterStrategy);
		feature_converter.addConverterStrategy(negativeConvererStrategy);
		converter.setFeaturerOperatorConverter(feature_converter);
		
		ecore_op_conv = new EcoreOperatorConverter();
	}

	@Override
	public Operators generate() throws ReaderException {
		Operators operators = new Operators();
		try {
			converter.readVariabilityModelFromFile(bvr_model);
			converter.convertVariabilityModelToOperators();
			List<Operator> ecore_operators = converter.getGeneratodOperators();
			
			for(Operator ecore_operator : ecore_operators) {
				IOperator operator = ecore_op_conv.convert(ecore_operator);
				operators.add((no.sintef.bvr.planner.operators.Operator) operator);
			}
		} catch(Exception ex) {
			throw new ReaderException(ex.getMessage(), ex);
		}
		return operators;
	}

	@Override
	public void commit() throws WriterException {
		try {
			converter.writeOperatorsToFile(realop_file);
		} catch(Exception ex) {
			throw new WriterException(ex.getMessage(), ex);
		}
	}

}

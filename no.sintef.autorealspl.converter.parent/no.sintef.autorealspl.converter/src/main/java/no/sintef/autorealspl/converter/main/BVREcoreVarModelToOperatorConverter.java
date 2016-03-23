package no.sintef.autorealspl.converter.main;


import java.util.ArrayList;
import java.util.List;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;


import bvr.BVRModel;
import bvr.BvrPackage;
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverter;
import no.sintef.autorealspl.converter.interfaces.operconverter.IOperatorSerializer;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;
import no.sintef.autorealspl.converter.parser.BVRModelParserStrategy;
import no.sintef.xtext.dsl.operator.realop.Operator;


public class BVREcoreVarModelToOperatorConverter implements IConverter {

	private BVRModel model;
	private IVariabilityModelParser parser;
	private IFeatureOperatorConverter operatorConverter;
	private List<Operator> operators;
	private IOperatorSerializer operatorSerializer;
	
	public BVREcoreVarModelToOperatorConverter() {};

	public void readVariabilityModelFromFile(String str) {
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("bvr", new XMIResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(str), true);
		
		model = (BVRModel) resource.getContents().get(0);
	}

	public void convertVariabilityModelToOperators() {
		BVRModelParserStrategy strategy = (BVRModelParserStrategy) parser.getParserStrategy();
		strategy.setBVRModel(model);
		strategy.setResolution(null);
		
		List<IFeature> features = parser.parse();
		operators = new ArrayList<Operator>();
		
		for(IFeature feature : features) {
			List<Operator> ops = operatorConverter.convertToOperators(feature);
			operators.addAll(ops);
		}

	}

	public void writeOperatorsToFile(String str) {
		operatorSerializer.serialize(operators, str);
	}

	public List<Operator> getGeneratodOperators() {
		return operators;
	}

	public void setVariabityModelParser(IVariabilityModelParser _parser) {
		parser = _parser;

	}

	public void setFeaturerOperatorConverter(IFeatureOperatorConverter _operatorConverter) {
		operatorConverter = _operatorConverter;
	}

	@Override
	public void setOperatorSerializer(IOperatorSerializer serializer) {
		operatorSerializer = serializer;
	}

}

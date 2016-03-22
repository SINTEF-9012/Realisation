package no.sintef.autorealspl.converter.main;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.xtext.resource.XtextResource;

import bvr.BVRModel;
import bvr.BvrPackage;
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverter;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;
import no.sintef.autorealspl.converter.parser.BVRModelParserStrategy;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.RealopPackage;

public class BVREcoreVarModelToOperatorConverter implements IConverter {

	private BVRModel model;
	private IVariabilityModelParser parser;
	private IFeatureOperatorConverter operatorConverter;
	private List<Operator> operators;
	
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
		RealopPackage.eINSTANCE.eClass();
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("realop", new XtextResource());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(URI.createURI(str));
		
		Map<Object, Object> options = new HashMap<Object, Object>();
		options.put(XtextResource.OPTION_ENCODING, "UTF-8");
		
		try {
			resource.save(options);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

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

}

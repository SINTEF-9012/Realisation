package no.sintef.autorealspl.no.sintef.autorealspl.converter.test;

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.junit.Before;
import org.junit.Test;

import bvr.BVRModel;
import bvr.BvrPackage;
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverter;
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureStatus;
import no.sintef.autorealspl.converter.interfaces.parser.IParserStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;
import no.sintef.autorealspl.converter.main.BVREcoreVarModelToOperatorConverter;
import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.autorealspl.converter.operconverter.FeatureOperatorConvertor;
import no.sintef.autorealspl.converter.operconverter.NegativeOperatorConverter;
import no.sintef.autorealspl.converter.operconverter.PositiveOperatorConverter;
import no.sintef.autorealspl.converter.operconverter.XtextFileSrcOperatorSerializer;
import no.sintef.autorealspl.converter.operconverter.XtextFilsSrcOperatorDeserializer;
import no.sintef.autorealspl.converter.parser.BVRModelParserStrategy;
import no.sintef.autorealspl.converter.parser.VariabiltiyModelParser;
import no.sintef.xtext.dsl.operator.realop.BoolExpression;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.Operator;


public class BVROperatorTest {

	IVariabilityModelParser parser;
	String path_to_model = "src/main/resources/testparsing.bvr";
	
	IFeatureOperatorConverterStrategy positiveConveterStrategy;
	IFeatureOperatorConverterStrategy negativeConvererStrategy;
	IFeatureOperatorConverter featureConverter;
	
	@Before
	public void setUp() throws Exception {
		
		BvrPackage.eINSTANCE.eClass();
		Resource.Factory.Registry registry = Resource.Factory.Registry.INSTANCE;
		registry.getExtensionToFactoryMap().put("bvr", new XMIResourceFactoryImpl());
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createURI(path_to_model), true);
		assertNotNull("can not load bvr resource", resource);
		
		BVRModel bvr_model = (BVRModel) resource.getContents().get(0);
		assertNotNull("cannot find bvr model", bvr_model);
		
		IParserStrategy parser_strategy = new BVRModelParserStrategy();
		((BVRModelParserStrategy) parser_strategy).setBVRModel(bvr_model);
		((BVRModelParserStrategy) parser_strategy).setResolution(bvr_model.getResolutionModels().get(0));
		
		parser = new VariabiltiyModelParser(parser_strategy);
		
		positiveConveterStrategy = new PositiveOperatorConverter();
		negativeConvererStrategy = new NegativeOperatorConverter();
		
		featureConverter = new FeatureOperatorConvertor();
	}

	@Test
	public void testParsing() {
		List<IFeature> features = parser.parse();
		
		assertNotNull(features);
		assertEquals(5, features.size());
	}
	
	@Test
	public void testParsedFeaturesPositiveStatus() {
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature positive = getFeatureByName(features, "SPpositive");
		assertNotNull(positive);
		
		assertEquals(IFeatureStatus.TRUE, positive.getStatus().getValue());
		
		assertEquals(true, positive.getStatus().isPosResolved());
		assertEquals(false, positive.getStatus().isNegResolved());
		assertEquals(false, positive.getStatus().isNotResolved());
		
	}
	
	@Test
	public void testParsedFeaturesNegativeStatus() {
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature feauture = getFeatureByName(features, "SPnegative");
		assertNotNull(feauture);
		
		assertEquals(IFeatureStatus.FALSE, feauture.getStatus().getValue());
		
		assertEquals(false, feauture.getStatus().isPosResolved());
		assertEquals(true, feauture.getStatus().isNegResolved());
		assertEquals(false, feauture.getStatus().isNotResolved());
		
	}
	
	@Test
	public void testParsedFeaturesNotStatus() {
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature feauture = getFeatureByName(features, "SPnotresolved");
		assertNotNull(feauture);
		
		assertEquals(IFeatureStatus.NR, feauture.getStatus().getValue());
		
		assertEquals(false, feauture.getStatus().isPosResolved());
		assertEquals(false, feauture.getStatus().isNegResolved());
		assertEquals(true, feauture.getStatus().isNotResolved());
		
		
	}
	
	
	@Test
	public void testPositiveOperatorConverter() {
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature positive = getFeatureByName(features, "SPpositive");
		assertNotNull(positive);
		
		
		Operator operator = positiveConveterStrategy.convertIFeatureToOperator(positive);
		assertNotNull(operator);
		
		Expression pre_exp = operator.getExp_pre();
		BoolExpression lhs = pre_exp.getLhs();
		
		assertTrue("should be negated", lhs.isNegated());
		assertTrue("should be realised predicate", lhs.getIsExpression().isRealised());
		assertEquals("SPpositive", lhs.getName());
		
		Expression post_exp = operator.getExp_post();
		lhs = post_exp.getLhs();
		
		assertFalse("should not be negated", lhs.isNegated());
		assertTrue("should be positive predicate", lhs.getIsExpression().isPositive());
		assertEquals("SPpositive", lhs.getName());
	}
	
	@Test
	public void testNegativeOperatorConverter() {
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature positive = getFeatureByName(features, "SPpositive");
		assertNotNull(positive);
		
		
		Operator operator = negativeConvererStrategy.convertIFeatureToOperator(positive);
		assertNotNull(operator);
		
		Expression pre_exp = operator.getExp_pre();
		BoolExpression lhs = pre_exp.getLhs();
		
		assertTrue("should be negated", lhs.isNegated());
		assertTrue("should be realised predicate", lhs.getIsExpression().isRealised());
		assertEquals("SPpositive", lhs.getName());
		
		Expression post_exp = operator.getExp_post();
		lhs = post_exp.getLhs();
		
		assertFalse("should not be negated", lhs.isNegated());
		assertTrue("should be positive predicate", lhs.getIsExpression().isNegative());
		assertEquals("SPpositive", lhs.getName());
	}
	
	@Test
	public void testOperatorConverter() {
		featureConverter.addConverterStrategy(positiveConveterStrategy);
		featureConverter.addConverterStrategy(negativeConvererStrategy);
		
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature positive = getFeatureByName(features, "SPpositive");
		assertNotNull(positive);
		
		List<Operator> list = featureConverter.convertToOperators(positive);
		
		assertTrue(2 == list.size());
		
	}
	
	@Test
	public void testConverter() {
		
		IConverter converter = new BVREcoreVarModelToOperatorConverter();
		
		converter.readVariabilityModelFromFile("src/main/resources/simple.bvr");
		converter.setVariabityModelParser(new VariabiltiyModelParser(new BVRModelParserStrategy()));
		converter.setOperatorSerializer(new XtextFileSrcOperatorSerializer());
		
		IFeatureOperatorConverter feature_converter = new FeatureOperatorConvertor();
		feature_converter.addConverterStrategy(positiveConveterStrategy);
		feature_converter.addConverterStrategy(negativeConvererStrategy);
		converter.setFeaturerOperatorConverter(feature_converter);
		
		converter.convertVariabilityModelToOperators();
		
		List<Operator> operators = converter.getGeneratodOperators();
		
		assertNotNull(operators);
		assertTrue(2 == operators.size());
		converter.writeOperatorsToFile("src/main/resources/simple.realop");
		
		converter.setOperatorDeserializer(new XtextFilsSrcOperatorDeserializer());
		operators = converter.readOperatorsFromFile("src/main/resources/simple.realop");
		assertNotNull(operators);
		assertTrue(2 == operators.size());
	}
	
	@Test
	public void testOperatorParsing() {
		IConverter converter = new BVREcoreVarModelToOperatorConverter();
		converter.setOperatorDeserializer(new XtextFilsSrcOperatorDeserializer());
		List<Operator> operators = converter.readOperatorsFromFile("src/main/resources/test.realop");
		
		assertNotNull(operators);
		assertTrue(1 == operators.size());
		
		Operator operator = operators.get(0);
		assertEquals("SPpositivePos", operator.getName());
		
		Expression pre_exp = operator.getExp_pre();
		Expression post_exp = operator.getExp_post();
		
		BoolExpression pred_pre = pre_exp.getLhs();
		assertTrue(pred_pre.isNegated());
		
		BoolExpression pred_post = post_exp.getLhs();
		assertFalse(pred_post.isNegated());
		
		assertTrue(pred_pre.getIsExpression().isRealised());
		assertTrue(pred_post.getIsExpression().isPositive());
	}
	
	private IFeature getFeatureByName(List<IFeature> features, String name) {
		
		for(IFeature feature : features) {
			if(feature.getName().equals(name))
				return feature;
		}
		return null;	
	}

}

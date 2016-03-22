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
import no.sintef.autorealspl.converter.interfaces.operconverter.IFeatureOperatorConverterStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureStatus;
import no.sintef.autorealspl.converter.interfaces.parser.IParserStrategy;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;
import no.sintef.autorealspl.converter.parser.BVRModelParserStrategy;
import no.sintef.autorealspl.converter.parser.VariabiltiyModelParser;
import no.sintef.xtext.dsl.operator.realop.Expression;
import no.sintef.xtext.dsl.operator.realop.Operator;
import no.sintef.xtext.dsl.operator.realop.Predicate;

public class BVROperatorTest {

	IVariabilityModelParser parser;
	String path_to_model = "src/main/resources/testparsing.bvr";
	
	IFeatureOperatorConverterStrategy positiveConveter;
	IFeatureOperatorConverterStrategy negativeConverer;
	
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
		
		IParserStrategy parser_strategy = new BVRModelParserStrategy(bvr_model, 0);
		parser = new VariabiltiyModelParser(parser_strategy);
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
		
		
		Operator operator = positiveConveter.convertIFeatureToOperator(positive);
		assertNotNull(operator);
		
		Expression pre_exp = operator.getExp_pre();
		Predicate lhs = pre_exp.getLhs();
		
		assertTrue("should be negated", lhs.isNegated());
		assertTrue("should be realised predicate", lhs.getPredicate().isRealised());
		assertEquals("SPpositive", lhs.getName());
		
		Expression post_exp = operator.getExp_post();
		lhs = post_exp.getLhs();
		
		assertFalse("should not be negated", lhs.isNegated());
		assertTrue("should be positive predicate", lhs.getPredicate().isPositive());
		assertEquals("SPpositive", lhs.getName());
	}
	
	@Test
	public void testNegativeOperatorConverter() {
		List<IFeature> features = parser.parse();
		assertNotNull(features);
		
		IFeature positive = getFeatureByName(features, "SPpositive");
		assertNotNull(positive);
		
		
		Operator operator = negativeConverer.convertIFeatureToOperator(positive);
		assertNotNull(operator);
		
		Expression pre_exp = operator.getExp_pre();
		Predicate lhs = pre_exp.getLhs();
		
		assertTrue("should be negated", lhs.isNegated());
		assertTrue("should be realised predicate", lhs.getPredicate().isRealised());
		assertEquals("SPpositive", lhs.getName());
		
		Expression post_exp = operator.getExp_post();
		lhs = post_exp.getLhs();
		
		assertFalse("should not be negated", lhs.isNegated());
		assertTrue("should be positive predicate", lhs.getPredicate().isNegative());
		assertEquals("SPpositive", lhs.getName());
	}
	
	private IFeature getFeatureByName(List<IFeature> features, String name) {
		
		for(IFeature feature : features) {
			if(feature.getName().equals(name))
				return feature;
		}
		return null;	
	}

}

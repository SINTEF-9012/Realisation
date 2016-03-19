package no.sintef.autorealspl.no.sintef.autorealspl.converter.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import no.sintef.autorealspl.converter.interfaces.parser.IFeature;
import no.sintef.autorealspl.converter.interfaces.parser.IFeatureStatus;
import no.sintef.autorealspl.converter.interfaces.parser.IVariabilityModelParser;

public class BVROperatorTest {

	IVariabilityModelParser parser;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
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
		
		IFeature positive = features.get(0);
		
		assertEquals(IFeatureStatus.TRUE, positive.getStatus().getValue());
		
		assertEquals(true, positive.getStatus().isPosResolved());
		assertEquals(false, positive.getStatus().isNegResolved());
		assertEquals(false, positive.getStatus().isNotResolved());
		
	}
	
	@Test
	public void testParsedFeaturesNegativeStatus() {
		List<IFeature> features = parser.parse();
		
		IFeature positive = features.get(0);
		
		assertEquals(IFeatureStatus.FALSE, positive.getStatus().getValue());
		
		assertEquals(false, positive.getStatus().isPosResolved());
		assertEquals(true, positive.getStatus().isNegResolved());
		assertEquals(false, positive.getStatus().isNotResolved());
		
	}
	
	@Test
	public void testParsedFeaturesNotStatus() {
		List<IFeature> features = parser.parse();
		
		IFeature positive = features.get(0);
		
		assertEquals(IFeatureStatus.NR, positive.getStatus().getValue());
		
		assertEquals(false, positive.getStatus().isPosResolved());
		assertEquals(false, positive.getStatus().isNegResolved());
		assertEquals(true, positive.getStatus().isNotResolved());
	}

}

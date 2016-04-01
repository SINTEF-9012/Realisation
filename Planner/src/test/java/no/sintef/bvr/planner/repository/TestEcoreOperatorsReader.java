package no.sintef.bvr.planner.repository;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import no.sintef.autorealspl.converter.main.BVREcoreVarModelToOperatorConverter;
import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.operators.IsNegative;
import no.sintef.bvr.planner.operators.IsPositive;
import no.sintef.bvr.planner.operators.IsRealised;
import no.sintef.bvr.planner.operators.interfaces.IAndExpression;
import no.sintef.bvr.planner.operators.interfaces.IExpression;
import no.sintef.bvr.planner.operators.interfaces.IIsExpression;
import no.sintef.bvr.planner.operators.interfaces.INotExpression;
import no.sintef.bvr.planner.operators.interfaces.IOperator;
import no.sintef.bvr.planner.operators.interfaces.ITwoSideExpression;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;


public class TestEcoreOperatorsReader {

	private IOperatorsReader operator_reader;

	@Before
	public void setUp() throws Exception {
		String realop_file = "src/test/resources/test.realop";
		IConverter ecore_converter = new BVREcoreVarModelToOperatorConverter();		
		operator_reader = new EcoreOperatorReader(ecore_converter, realop_file); 
		
	}

	@Test
	public void testEcoreOperatorsReader() throws ReaderException {
		Operators operators = operator_reader.read();
		IOperator operator = operators.get("SPpositivePos");
		assertNotNull(operator);
		
		IExpression pre_condition = operator.getPreCondition();
		assertTrue(pre_condition instanceof INotExpression);
		
		IExpression realised = ((INotExpression) pre_condition).getExpression();
		assertTrue(realised instanceof IsRealised);
		assertEquals("SPpositive", ((IIsExpression) realised).getFeatureName());
		
		
		IExpression post_condition = operator.getPostCondition();
		assertTrue(post_condition instanceof IAndExpression);
		
		IExpression left = ((ITwoSideExpression) post_condition).getLeftSide();
		assertTrue(left instanceof IsPositive);
		assertEquals("SPpositive", ((IIsExpression) left).getFeatureName());
		
		IExpression right = ((ITwoSideExpression) post_condition).gerRightSide();
		assertTrue(right instanceof IsNegative);
		assertEquals("SPnegative", ((IIsExpression) right).getFeatureName());
	}

}

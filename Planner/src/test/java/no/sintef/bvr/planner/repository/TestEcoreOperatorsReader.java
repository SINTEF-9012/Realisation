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
import no.sintef.bvr.planner.operators.interfaces.IOrExpression;
import no.sintef.bvr.planner.operators.interfaces.ITwoSideExpression;
import no.sintef.bvr.planner.operators.interfaces.IXorExpression;
import no.sintef.bvr.planner.repository.ecore.EcoreOperatorReader;
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
		assertTrue(pre_condition instanceof IXorExpression);
		
		IXorExpression xor_exp = (IXorExpression) pre_condition;
		
		assertTrue(xor_exp.getLeftSide() instanceof INotExpression);
		assertTrue(xor_exp.getRightSide() instanceof IsRealised);
		
		INotExpression inot_exp = (INotExpression) xor_exp.getLeftSide();
		assertEquals("SPpositive", ((IIsExpression) inot_exp.getExpression()).getFeatureName());
		
		IExpression realised = (IsRealised) xor_exp.getRightSide();
		assertEquals("SPpositive1", ((IIsExpression) realised).getFeatureName());
		
		
		
		IExpression post_condition = operator.getPostCondition();
		assertTrue(post_condition instanceof IAndExpression);
		
		IExpression left = ((ITwoSideExpression) post_condition).getLeftSide();
		assertTrue(left instanceof IsPositive);
		assertEquals("SPpositive", ((IIsExpression) left).getFeatureName());
		
		IExpression right = ((ITwoSideExpression) post_condition).getRightSide();
		assertTrue(right instanceof IOrExpression);
		
		IOrExpression or_exp = (IOrExpression) right;
		left = or_exp.getLeftSide();
		right = or_exp.getRightSide();
		assertTrue(left instanceof IsNegative);
		assertTrue(right instanceof IsPositive);
		
		assertEquals("SPnegative2", ((IIsExpression) left).getFeatureName());
		assertEquals("SPpositive3", ((IIsExpression) right).getFeatureName());
	}

}

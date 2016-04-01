package no.sintef.bvr.planner.repository;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import no.sintef.autorealspl.converter.main.BVREcoreVarModelToOperatorConverter;
import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.operators.Operator;
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
		Operator operator = operators.get("SPpositivePos");
		assertNotNull(operator);
	}

}

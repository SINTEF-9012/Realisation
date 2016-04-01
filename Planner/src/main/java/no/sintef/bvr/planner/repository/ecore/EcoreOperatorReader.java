package no.sintef.bvr.planner.repository.ecore;

import java.util.List;

import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.operators.interfaces.IOperator;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;
import no.sintef.xtext.dsl.operator.realop.Operator;

public class EcoreOperatorReader implements IOperatorsReader {
	
	private IConverter converter;
	private String realop_file;
	private EcoreOperatorConverter operatorConverte;

	public EcoreOperatorReader(IConverter _converter, String _file_path) {
		converter = _converter;
		realop_file = _file_path;
		operatorConverte = new EcoreOperatorConverter();
	}

	@Override
	public Operators read() throws ReaderException {
		Operators operators = new Operators();
		
		List<Operator> ecore_operators = converter.readOperatorsFromFile(realop_file);
		for(Operator ecore_operator : ecore_operators) {
			IOperator operator = operatorConverte.convert(ecore_operator);
			operators.add((no.sintef.bvr.planner.operators.Operator) operator);
		}
		
		return operators;
	}

}

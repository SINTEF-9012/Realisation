package no.sintef.bvr.planner.repository.ecore;

import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;
import no.sintef.bvr.planner.repository.interfaces.IOperatorGenenerator;

public class EcoreBVROperatorsGenerator implements IOperatorGenenerator {
	
	private IConverter converter;
	private String bvr_model;
	private String realop_file;

	public EcoreBVROperatorsGenerator(IConverter _converter, String _bvr_model, String _realop_file) {
		converter = _converter;
		bvr_model = _bvr_model;
		realop_file = _realop_file;
	}

	@Override
	public Operators generate() throws ReaderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commit() throws WriterException {
		// TODO Auto-generated method stub

	}

}

package no.sintef.bvr.planner.repository;

import no.sintef.autorealspl.converter.main.IConverter;
import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.repository.interfaces.IOperatorsReader;

public class EcoreOperatorReader implements IOperatorsReader {
	
	private IConverter converter;
	private String realop_file;

	public EcoreOperatorReader(IConverter _converter, String _file_path) {
		converter = _converter;
		realop_file = _file_path;
	}

	@Override
	public Operators read() throws ReaderException {
		throw new ReaderException("do not know how to read");
	}

}

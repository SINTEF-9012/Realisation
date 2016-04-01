package no.sintef.bvr.planner.repository.interfaces;

import no.sintef.bvr.planner.Operators;
import no.sintef.bvr.planner.repository.ReaderException;
import no.sintef.bvr.planner.repository.WriterException;

public interface IOperatorGenenerator {

	public Operators generate() throws ReaderException;
	
	public void commit() throws WriterException;
}

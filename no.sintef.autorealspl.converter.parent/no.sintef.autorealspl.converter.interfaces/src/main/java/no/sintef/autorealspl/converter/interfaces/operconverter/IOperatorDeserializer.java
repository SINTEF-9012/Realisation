package no.sintef.autorealspl.converter.interfaces.operconverter;

import java.util.List;

import no.sintef.xtext.dsl.operator.realop.Operator;

public interface IOperatorDeserializer {

	public List<Operator> deserialize(String src);
}

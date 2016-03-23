package no.sintef.autorealspl.converter.interfaces.operconverter;

import java.util.List;

import no.sintef.xtext.dsl.operator.realop.Operator;

public interface IOperatorSerializer {
 
	public void serialize(List<Operator> operators, String dest);
}

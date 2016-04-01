package no.sintef.bvr.planner.operators.interfaces;

public interface IOperator {
	
	public IExpression getPreCondition();
	
	public IExpression getPostCondition();

}

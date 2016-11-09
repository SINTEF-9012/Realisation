package no.sintef.bvr.planner.operators.interfaces;

public interface ITwoSideExpression extends IExpression {
	
	public IExpression getLeftSide();
	
	public IExpression getRightSide();

}

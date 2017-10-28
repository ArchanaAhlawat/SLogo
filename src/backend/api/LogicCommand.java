package backend.api;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

public abstract class LogicCommand implements Command {

	protected static final double ZERO = 0.0;
	protected static final double ONE = 1.0;
	
	protected double expr1;
	protected double expr2;
	protected Stacks instructionStacks;
	protected Turtle currentTurtle;
	
	public LogicCommand(Stacks myStack, Turtle myTurtle) {
		instructionStacks = myStack;
		currentTurtle = myTurtle;
	}
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		setParams();
		addReturn(doUpdate());
	}
	
	protected void setParams() {
		expr1 = instructionStacks.popDouble();
		expr2 = instructionStacks.popDouble();
	}

	protected double doUpdate() {
		//do nothing
		return 10.0;
	}
	
	protected void addReturn(double returnVal) {
		instructionStacks.addDouble(returnVal);
	}
}

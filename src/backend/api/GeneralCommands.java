package backend.api;

import backend.Stacks;
import backend.Turtle;

public abstract class GeneralCommands implements Command {
	protected double expr1;
	protected double expr2;
	protected Stacks instructionStacks;
	protected Turtle currentTurtle;
	
	public GeneralCommands(Stacks myStack, Turtle myTurtle) {
		instructionStacks = myStack;
		currentTurtle = myTurtle;
	}
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
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

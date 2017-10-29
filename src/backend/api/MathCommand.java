package backend.api;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

public abstract class MathCommand implements Command {

	protected static final double ZERO = 0.0;
	protected static final double ONE = 1.0;
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		// do nothing
	}
	
	

}

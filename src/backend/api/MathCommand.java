package backend.api;

import backend.Stacks;
import backend.Turtle;

public abstract class MathCommand implements Command {

	protected static final double ZERO = 0.0;
	protected static final double ONE = 1.0;
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		// do nothing
	}
	
	

}

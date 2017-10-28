package backend.commands.booleanOperations;

import backend.Stacks;
import backend.Turtle;
import backend.commands.BooleanOperations;

/**
 * has the execute for when a not command is called
 *     pops a parameters off the stack
 *     pushes if it is zero onto the stack (inverting the value)
 * 
 * @author kelly
 *
 */
public class Not extends BooleanOperations {

	public Not(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr = instructionStacks.popDouble();
		if (expr == ZERO) {
			instructionStacks.addDouble(ONE);
		}
		else {
			instructionStacks.addDouble(ZERO);
		}
	}
}

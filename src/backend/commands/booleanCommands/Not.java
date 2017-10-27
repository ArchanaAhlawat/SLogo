package backend.commands.booleanCommands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a not command is called
 *     pops a parameters off the stack
 *     pushes if it is zero onto the stack (inverting the value)
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Not implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;
	
	
	public Not(Stacks myStack, Turtle myTurtle) {
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

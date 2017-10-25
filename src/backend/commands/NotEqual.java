package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a notequal command is called
 *     pops two parameters off the stack
 *     pushes if the first one is not equal to the second onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class NotEqual implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr1 = instructionStacks.popDouble();
		double expr2 = instructionStacks.popDouble();
		if (expr1 != expr2) {
			instructionStacks.addDouble(ONE);
		}
		else {
			instructionStacks.addDouble(ZERO);
		}
	}
}

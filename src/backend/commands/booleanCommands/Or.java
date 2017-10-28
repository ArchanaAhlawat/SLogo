package backend.commands.booleanCommands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a or command is called
 *     pops two parameters off the stack
 *     pushes if either the first or second are nonzero onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Or implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr1 = instructionStacks.popDouble();
		double expr2 = instructionStacks.popDouble();
		if (expr1 != ZERO || expr2 != ZERO) {
			instructionStacks.addDouble(ONE);
		}
		else {
			instructionStacks.addDouble(ZERO);
		}
	}
}

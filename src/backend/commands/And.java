package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a and command is called
 *     pops two parameters off the stack
 *     pushes if both are nonzero onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class And implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;

	@Override
	public void execute(Stacks instructionStack, Turtle currentTurtle) {
		double expr1 = instructionStack.popDouble();
		double expr2 = instructionStack.popDouble();
		if (expr1 != ZERO && expr2 != ZERO) {
			instructionStack.addDouble(ONE);
		}
		else {
			instructionStack.addDouble(ZERO);
		}
	}
}

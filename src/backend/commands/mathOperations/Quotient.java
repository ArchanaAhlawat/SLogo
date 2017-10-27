package backend.commands.mathOperations;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a quotient command is called
 *     pops the two parameter in the stack
 *     pushes their quotient onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Quotient implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr1 = instructionStacks.popDouble();
		//TODO: throw error if expr2 is 0.0
		double expr2 = instructionStacks.popDouble();
		instructionStacks.addDouble(expr1/expr2);
	}

}

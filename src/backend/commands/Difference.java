package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a difference command is called
 *     pops the two parameter from the stack
 *     pushes their sum onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 * 
 */
public class Difference implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr1 = instructionStacks.popDouble();
		double expr2 = instructionStacks.popDouble();
		instructionStacks.addDouble(expr1-expr2);
	}

}

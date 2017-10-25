package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a remainder command is called
 *     pops the two parameter in the stack
 *     pushes the remainder of their division onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Remainder implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr1 = instructionStacks.popDouble();
		double expr2 = instructionStacks.popDouble();
		//TODO: throw error if expr2 is 0.0
		//negative modulus is defined
		instructionStacks.addDouble(expr1 % expr2);
	}

}

package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a power command is called
 *     pops two parameters off the stack, the base and the exponent
 *     pushes the value of the base to the exponent onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Power implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(Math.pow(instructionStacks.popDouble(),instructionStacks.popDouble()));
	}
}

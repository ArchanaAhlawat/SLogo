package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a sine command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the sine of this onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Sine implements Command {
	private static final double RADTODEG = 180.0/Math.PI;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double sine = Math.sin(instructionStacks.popDouble()*RADTODEG);
		instructionStacks.addDouble(sine);
	}
}

package backend.commands.mathOperations;

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
public class Cosine implements Command {
	private static final double RADTODEG = 180.0/Math.PI;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double cosine = Math.cos(instructionStacks.popDouble()*RADTODEG);
		instructionStacks.addDouble(cosine); //Math.random() is 0.0 (inclusive) to 1.0 (exclusive)
	}
}

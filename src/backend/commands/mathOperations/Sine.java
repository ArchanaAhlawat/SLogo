package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.api.MathOperations;

/**
 * has the execute for when a sine command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the sine of this onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Sine extends MathOperations {

	public Sine(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double sine = Math.sin(instructionStacks.popDouble()*RADTODEG);
		instructionStacks.addDouble(sine);
	}
}

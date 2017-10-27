package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.commands.MathOperations;

/**
 * has the execute for when a sine command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the sine of this onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Cosine extends MathOperations {

	public Cosine(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double cosine = Math.cos(instructionStacks.popDouble()*RADTODEG);
		instructionStacks.addDouble(cosine); 
	}
}

package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a sine command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the sine of this onto the stack
 * 
 * @author kelly
 *
 */
public class Sine extends MathOperations {

	public Sine(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double sine = Math.sin(instructionStacks.popDouble()*DEGTORAD);
		instructionStacks.addDouble(sine);
	}
}

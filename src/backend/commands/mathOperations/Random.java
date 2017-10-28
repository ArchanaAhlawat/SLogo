package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a random command is called
 *     pops a parameter off the stack, the max
 *     pushes a random non-negative number less than max onto the stack
 * 
 * @author kelly
 *
 */
public class Random extends MathOperations {

	public Random(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double max = instructionStacks.popDouble();
		//TODO: throw exception if max is negative/zero
		instructionStacks.addDouble(Math.random()*max); //Math.random() is 0.0 (inclusive) to 1.0 (exclusive)
	}
}

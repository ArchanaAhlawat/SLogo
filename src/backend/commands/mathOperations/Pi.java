package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a pi command is called
 *     doesn't take any parameters
 *     pushes the value of pi onto the stack
 * 
 * @author kelly
 *
 */
public class Pi extends MathOperations {

	public Pi(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(Math.PI);
	}
}

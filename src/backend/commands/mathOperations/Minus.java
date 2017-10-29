package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a minus command is called
 *     pops a parameter off the stack
 *     pushes the negative value of it onto the stack
 *
 * @author kelly
 * 
 */
public class Minus extends MathOperations {

	public Minus(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double expr = instructionStacks.popDouble();
		instructionStacks.addDouble(-1*expr);
	}
}

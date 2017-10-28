package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a naturallog command is called
 *     pops a parameter off the stack, the max
 *     pushes the natural log of the number onto the stack
 * 
 * @author kelly
 *
 */
public class NaturalLog extends MathOperations {

	public NaturalLog(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double expr = instructionStacks.popDouble();
		instructionStacks.addDouble(Math.log(expr));
		//TODO: throw errors if expr is invalid input for ln
	}
}

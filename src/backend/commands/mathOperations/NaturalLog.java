package backend.commands.mathOperations;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a naturallog command is called
 *     pops a parameter off the stack, the max
 *     pushes the natural log of the number onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class NaturalLog implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr = instructionStacks.popDouble();
		instructionStacks.addDouble(Math.log(expr));
		//TODO: throw errors if expr is invalid input for ln
	}
}

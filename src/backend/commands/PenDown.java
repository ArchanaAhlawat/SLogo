package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a pendown command is called
 *     doesn't need any input parameters from the stack
 *     sets the pen to down and tracks the trails drawn by the turtle in the next commands
 *     pushes the return value from the pendown command (1) to the stack
 * 	   returns the stack of parameters
 * 
 * @author kelly
 * 
 */
public class PenDown implements Command {
	
	private static final double ONE = 1.0;

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble((double) currentTurtle.penChange(ONE));
	}
}
package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a penup command is called
 *     doesn't need any input parameters from the stack
 *     sets the pen to up and doesn't track any trails for the pen
 *     pushes the return value from the penup command (0) to the stack
 * 	   returns the stack of parameters
 * 
 *  @author kelly
 * 
 */
public class PenUp implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(currentTurtle.penChange(ZERO));
	}
}
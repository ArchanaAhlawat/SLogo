package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a heading command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the heading value
 *     pushes if the angle (heading) of the turtle facing to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Heading implements Command {
	
	private static final String HEADING = "theta";
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getAbsoluteOrientation(HEADING));
	}
}
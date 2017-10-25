package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a ispendown command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the pendown value
 *     pushes if the pen is up or down to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class IsPenDown implements Command {
	
	private static final String ISPENDOWN = "penDown";
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getAbsoluteOrientation(ISPENDOWN));
	}
}
package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a xcor command is called
 *     doesn't need any parameter from the stack
 *     asks the turtle for its xcor value
 *     pushes if the turtle's xcor to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class XCoordinate implements Command {
	
	private static final String XCOR = "xcor";
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getAbsoluteOrientation(XCOR));
	}
}
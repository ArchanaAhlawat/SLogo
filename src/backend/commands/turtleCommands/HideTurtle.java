package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a hideturtle command is called
 *     does not need any parameters from the stack
 *     makes the turtle invisible (hidden)
 *     pushes the command return value (0) to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class HideTurtle implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(currentTurtle.visChange(ZERO));
	}
}
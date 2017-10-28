package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a showturtle command is called
 *     does not need any parameters from the stack
 *     makes the turtle visible (shown)
 *     pushes the command return value (1) to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class ShowTurtle implements Command {
	
	private static final double ONE = 1.0;

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.visChange(ONE));
	}
}
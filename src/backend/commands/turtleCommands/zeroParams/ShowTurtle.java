package backend.commands.turtleCommands.zeroParams;

import backend.Stacks;
import backend.Turtle;
import backend.commands.turtleCommands.TurtleCommands;

/**
 * has the execute for when a showturtle command is called
 *     does not need any parameters from the stack
 *     makes the turtle visible (shown)
 *     pushes the command return value (1) to the stack
 *
 * @author kelly
 *
 */
public class ShowTurtle extends TurtleCommands {

	public ShowTurtle(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.visChange(ONE);
	}
}
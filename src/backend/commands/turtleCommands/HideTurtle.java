package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a hideturtle command is called
 *     does not need any parameters from the stack
 *     makes the turtle invisible (hidden)
 *     pushes the command return value (0) to the stack
 *
 * @author kelly
 *
 */
public class HideTurtle extends TurtleCommands {

	public HideTurtle(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.visChange(ZERO);
	}
}
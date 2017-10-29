package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a heading command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the heading value
 *     pushes if the angle (heading) of the turtle facing to the stack
 *
 * @author kelly
 *
 */
public class Heading extends TurtleQueries {
	
	private static final String HEADING = "theta";
	
	public Heading(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		int length = currentTurtle.getAbsoluteOrientation(HEADING).length;
		return currentTurtle.getAbsoluteOrientation(HEADING)[length - 1];
	}
}

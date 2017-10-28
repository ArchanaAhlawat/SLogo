package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a isshowing command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the turtlevis value
 *     pushes if the turtle is visible or not to the stack
 *
 * @author kelly
 *
 */
public class IsShowing extends TurtleQueries {
	
	private static final String ISSHOWING = "turtleVis";
	
	public IsShowing(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.getAbsoluteOrientation(ISSHOWING);
	}
}

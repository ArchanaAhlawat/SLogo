package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a ispendown command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for the pendown value
 *     pushes if the pen is up or down to the stack
 *
 * @author kelly
 *
 */
public class IsPenDown extends TurtleQueries {
	
	private static final String ISPENDOWN = "penDown";
	
	public IsPenDown(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		return currentTurtle.getAbsoluteOrientation(ISPENDOWN);
	}
}
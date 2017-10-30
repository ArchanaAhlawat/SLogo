package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a xcor command is called
 *     doesn't need any parameter from the stack
 *     asks the turtle for its xcor value
 *     pushes if the turtle's xcor to the stack
 *
 * @author kelly
 *
 */
public class XCoordinate extends TurtleQueries {
	
	private static final String XCOR = "xcor";
	
	public XCoordinate(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		int length = currentTurtle.getAbsoluteOrientation(XCOR).length;
		return currentTurtle.getAbsoluteOrientation(XCOR)[length - 1];
	}
}

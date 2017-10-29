package backend.commands.turtleQueries;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a ycor command is called
 *     doesn't need any parameters from the stack
 *     asks the turtle for its ycor value
 *     pushes if the turtle's ycor to the stack
 *
 * @author kelly
 *
 */
public class YCoordinate extends TurtleQueries {

	private static final String YCOR = "ycor";
	
	public YCoordinate(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected double doUpdate() {
		int length = currentTurtle.getAbsoluteOrientation(YCOR).length;
		return currentTurtle.getAbsoluteOrientation(YCOR)[length - 1];
	}
}

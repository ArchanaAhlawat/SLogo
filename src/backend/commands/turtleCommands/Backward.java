package backend.commands.turtleCommands;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;

/**
 * has the execute for when a back command is called
 *     peeks the first parameter in the stack
 *     moves the turtle that distance back
 *
 * @author kelly
 *
 */
public class Backward extends TurtleCommandsOneParam {
	
	public Backward(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		currentTurtle.move(expr1);
		return expr1;
	}
}
package backend.commands.turtleCommands.twoParams;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;
import backend.commands.turtleCommands.TurtleCommands;

/**
 * has the execute for when a setposition command is called
 *     pops two parameters needed off the stack to be used to set the position
 *     makes the turtle move to that absolute location
 *     pushes the distance moved to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class SetPosition extends TurtleCommands {
	
	public SetPosition(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	protected double doUpdate() {
		return currentTurtle.setXY(expr1, expr2);
	}
}
package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a back command is called
 *     peeks at the first parameter in the stack
 *     moves the turtle that distance back
 *     does not need to add the distance moved back to the stack because it was not popped (only peeked!)
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Back implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.move(-1*vars.peek());
		return vars;
	}
}
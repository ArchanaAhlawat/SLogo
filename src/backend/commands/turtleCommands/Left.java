package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Turtle;
import backend.commands.Command;

/**
 * @author kelly
 *
 */
public class Left implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.rotate(-1*vars.peek());
		return vars; // new Stack
	}
}
package backend.commands;

import java.util.Stack;

import backend.Turtle;

/**
 * @author kelly
 *
 */
public class Right implements Command {
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.rotate(vars.peek());
		return vars;
	}
}
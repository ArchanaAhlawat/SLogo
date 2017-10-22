package backend.commands;

import java.util.Stack;

import backend.Turtle;

/**
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
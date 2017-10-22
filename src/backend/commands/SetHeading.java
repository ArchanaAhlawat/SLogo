package backend.commands;

import java.util.Stack;

import backend.Turtle;

/**
 * @author kelly
 *
 */
public class SetHeading implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		currentTurtle.setHeading(vars.peek());
		return vars;
	}
}

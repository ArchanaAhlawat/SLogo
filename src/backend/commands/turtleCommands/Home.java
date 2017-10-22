package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Turtle;
import backend.commands.Command;

/**
 * @author kelly
 *
 */
public class Home implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.home());
		return vars;
	}
}
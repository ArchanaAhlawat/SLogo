package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Turtle;
import backend.commands.Command;

/**
 * @author kelly
 *
 */
public class ShowTurtle implements Command {
	
	private static final double ONE = 1.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		vars.push(currentTurtle.visChange(ONE));
		return vars;
	}
}
package backend.commands.mathOperations;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a minus command is called
 *     pops a parameter off the stack
 *     pushes the negative value of it onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 * 
 */
public class Minus implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double expr = vars.pop();
		vars.push(-1*expr);
		return vars;
	}

}

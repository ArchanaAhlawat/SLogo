package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a or command is called
 *     pops two parameters off the stack
 *     pushes if either the first or second are nonzero onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Or implements Command {

	private static final double ZERO = 0.0;
	private static final double ONE = 1.0;

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double expr1 = vars.pop();
		double expr2 = vars.pop();
		if (expr1 != ZERO || expr2 != ZERO) {
			vars.push(ONE);
		}
		else {
			vars.push(ZERO);
		}
		return vars;
	}
}

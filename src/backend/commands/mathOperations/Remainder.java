package backend.commands.mathOperations;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a remainder command is called
 *     pops the two parameter in the stack
 *     pushes the remainder of their division onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Remainder implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double expr1 = vars.pop();
		double expr2 = vars.pop();
		vars.push(expr1 % expr2);
		return vars;
	}

}

package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a quotient command is called
 *     pops the two parameter in the stack
 *     pushes their quotient onto the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class Quotient implements Command {

	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double expr1 = vars.pop();
		//TODO: throw error if expr2 is 0.0
		double expr2 = vars.pop();
		vars.push(expr1/expr2);
		return vars;
	}

}

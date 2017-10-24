package backend.commands;

import java.util.Stack;

import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a tangent command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the tangent of this onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Tangent implements Command {
	private static final double RADTODEG = 180.0/Math.PI;
	
	@Override
	public Stack<Double> execute(Stack<Double> vars, Turtle currentTurtle) {
		double tan = Math.tan(vars.pop()*RADTODEG);
		vars.push(tan);
		//TODO: throw error if input is pi/2 + pi*i
		return vars;
	}
}

package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a arctan command is called
 *     pops a parameter off the stack, the tangent of some angle
 *     pushes the angle in degrees onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class ArcTangent implements Command {
	private static final double RADTODEG = 180/Math.PI;

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double atan = instructionStacks.popDouble();
		instructionStacks.addDouble(Math.atan(atan)*RADTODEG);
	}
	
//	public static void main (String[] args[]) {
//		ArcTangent at = new ArcTangent();
//		Stack<Double> vars = new Stack<>();
//		vars.push(1.0);
//		Turtle currentTurtle = new Turtle();
//		at.execute(vars, currentTurtle);
//		System.out.println(vars.peek());
//	}
}

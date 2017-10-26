package backend.commands;

import java.util.Stack;

import backend.Stacks;
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
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double tan = Math.tan(instructionStacks.popDouble()*RADTODEG);
		instructionStacks.addDouble(tan);
		//TODO: throw error if input is pi/2 + pi*i
	}
}

package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;

/**
 * has the execute for when a tangent command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the tangent of this onto the stack
 * 
 * @author kelly
 *
 */
public class Tangent extends MathOperations {
	
	public Tangent(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double tan = Math.tan(instructionStacks.popDouble()*DEGTORAD);
		instructionStacks.addDouble(tan);
		//TODO: throw error if input is pi/2 + pi*i
	}
}

package backend.commands.mathOperations;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a tangent command is called
 *     pops a parameter off the stack, the number of degrees
 *     pushes the tangent of this onto the stack
 * 
 * @author kelly
 *
 */
public class Tangent extends MathOperations {
	
	public Tangent(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double tan = Math.tan(instructionStacks.popDouble()*DEGTORAD);
		instructionStacks.addDouble(tan);
		//TODO: throw error if input is pi/2 + pi*i
	}
}

package backend.commands.mathOperations;

import java.util.Stack;

import backend.Stacks;
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
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double expr = instructionStacks.popDouble();
		instructionStacks.addDouble(-1*expr);
	}

}

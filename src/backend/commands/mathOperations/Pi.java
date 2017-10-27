package backend.commands.mathOperations;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a pi command is called
 *     doesn't take any parameters
 *     pushes the value of pi onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Pi implements Command {

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(Math.PI);
	}
}

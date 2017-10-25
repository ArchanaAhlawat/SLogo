package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a left command is called
 *     peeks at the first value in the stack (parameter of degrees to turn left)
 *     rotates the turtle left by that number of degrees
 *     doesn't need to push anything to the stack bc the parameter returned is what was peeked (not popped!)
 * 	   returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class Left implements Command {
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		currentTurtle.rotate(-1*instructionStacks.peekDouble());
	}
}
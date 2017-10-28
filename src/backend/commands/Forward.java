package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a forward command is called
 *     peeks at the first parameter in the stack
 *     moves the turtle that distance forward
 *     does not need to add the distance moved forward to the stack because it was not popped (only peeked!)
 *     returns the stack of parameters
 *
 * @author kelly
 * @author archana
 * 
 */
public class Forward implements Command {
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		currentTurtle.move(instructionStacks.peekDouble());
	}
}
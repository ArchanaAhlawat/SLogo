package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a home command is called
 *     does not need any parameters from the stack
 *     moves the turtle to home (0,0)
 *     pushes the distance moved by the turtle to the stack
 * 	   returns the stack of parameters
 * 
 * @author kelly
 * 
 */
public class Home implements Command {
	
	private static final double ZERO = 0.0;

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.home());
	}
}
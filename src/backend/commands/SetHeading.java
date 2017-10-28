package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;

/**
 * has the execute for when a setheading command is called
 *     pops the parameter needed off the stack to be used to set the angle
 *     makes the turtle rotate to that absolute location
 *     pushes the number of degrees rotated to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class SetHeading implements Command {

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.setHeading(instructionStacks.popDouble()));
	}
}

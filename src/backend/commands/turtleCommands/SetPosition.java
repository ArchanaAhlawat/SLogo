package backend.commands.turtleCommands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;

/**
 * has the execute for when a setposition command is called
 *     pops two parameters needed off the stack to be used to set the position
 *     makes the turtle move to that absolute location
 *     pushes the distance moved to the stack
 *     returns the stack of parameters
 *
 * @author kelly
 *
 */
public class SetPosition implements Command {
	
	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double distance = currentTurtle.setXY(instructionStacks.popDouble(), instructionStacks.popDouble());
		instructionStacks.addDouble(distance);
		//TODO: would you get concurrent modification exception if you popped inside of your push?
		//made it two lines to just be safe..
	}
}
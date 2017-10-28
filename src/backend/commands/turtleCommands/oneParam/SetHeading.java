package backend.commands.turtleCommands.oneParam;

import backend.Stacks;
import backend.Turtle;
import backend.commands.turtleCommands.TurtleCommandsOneParam;

/**
 * has the execute for when a setheading command is called
 *     pops the parameter needed off the stack to be used to set the angle
 *     makes the turtle rotate to that absolute location
 *     pushes the number of degrees rotated to the stack
 *
 * @author kelly
 *
 */
public class SetHeading extends TurtleCommandsOneParam {

	public SetHeading(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	protected void setParams() {
		expr1 = instructionStacks.popDouble();
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		instructionStacks.addDouble(currentTurtle.setHeading(expr1));
	}
}

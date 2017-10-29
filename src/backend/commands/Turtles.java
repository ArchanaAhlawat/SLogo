package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Stacks;
import backend.TurtleTree;
import backend.api.Command;

public class Turtles implements Command {

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getSize());
	}

}

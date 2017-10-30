package backend.commands.multipleTurtleCommands;

import java.lang.reflect.InvocationTargetException;

import backend.Stacks;
import backend.TurtleTree;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class ID extends GeneralCommands {

	public ID(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		instructionStacks.addDouble(currentTurtle.getActiveTurtleID());
	}

}

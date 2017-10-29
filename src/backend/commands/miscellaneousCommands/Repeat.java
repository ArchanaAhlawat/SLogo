package backend.commands.miscellaneousCommands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class Repeat extends GeneralCommands {

	public Repeat(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double repeatNum = instructionStacks.peekDouble();
		Parser tempParser;
		try {
			tempParser = new Parser(instructionStacks.getLanguage());
			for (int i = 0; i < repeatNum; i++) {
				for (String instruction : instructionStacks.getCommandsList()) {
					tempParser.parseInstruction(currentTurtle, instruction);
				}
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException | ClassNotFoundException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


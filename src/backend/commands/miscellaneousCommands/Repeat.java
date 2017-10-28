package backend.commands.miscellaneousCommands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class Repeat extends GeneralCommands {

	public Repeat(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double repeatNum = instructionStacks.peekDouble();
		Parser tempParser;
		try {
			tempParser = new Parser(currentTurtle, "ENGLISH");
			for (int i = 0; i < repeatNum; i++) {
				for (String instruction : instructionStacks.getCommandsList()) {
					tempParser.parseInstruction(instruction);
				}
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);

		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}

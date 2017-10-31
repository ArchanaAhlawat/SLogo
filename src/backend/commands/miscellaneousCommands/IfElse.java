package backend.commands.miscellaneousCommands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class IfElse extends GeneralCommands {

	public IfElse(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
		Parser tempParser;
		tempParser = new Parser(instructionStacks.getLanguage());
		if (instructionStacks.popDouble() != 0) {
			for (String instruction : instructionStacks.getSecondCommandsList()) {
					tempParser.parseInstruction(currentTurtle, instruction);
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);
		}
		else {
			for (String instruction : instructionStacks.getCommandsList()) {
					tempParser.parseInstruction(currentTurtle, instruction);
			}
			double toReturn = tempParser.getReturnVal();
			instructionStacks.addDouble(toReturn);
		}
	}
}

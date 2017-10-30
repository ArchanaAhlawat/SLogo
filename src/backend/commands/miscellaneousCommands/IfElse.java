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
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		Parser tempParser;
		try {
			tempParser = new Parser(instructionStacks.getLanguage());
			if (instructionStacks.popDouble() != 0) {
				for (String instruction : instructionStacks.getSecondCommandsList()) {
					try {
						tempParser.parseInstruction(currentTurtle, instruction);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException | InstantiationException
							| ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				double toReturn = tempParser.getReturnVal();
				instructionStacks.addDouble(toReturn);
			}
			else {
				for (String instruction : instructionStacks.getCommandsList()) {
					try {
						tempParser.parseInstruction(currentTurtle, instruction);
					} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
							| NoSuchMethodException | SecurityException | InstantiationException
							| ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				double toReturn = tempParser.getReturnVal();
				instructionStacks.addDouble(toReturn);
			}
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

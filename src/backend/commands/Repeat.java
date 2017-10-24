package backend.commands;

import java.lang.reflect.InvocationTargetException;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;

public class Repeat implements Command{

	@Override
	public void execute(Stacks instructionStacks, Turtle currentTurtle) {
		double repeatNum = instructionStacks.peekDouble();
		System.out.println("repeatNum: " + repeatNum);
		Parser tempParser = new Parser(currentTurtle);
		
		try {
		for (int i = 0; i < repeatNum; i++) {
			for (String instruction : instructionStacks.getCommandsList()) {
				tempParser.parseInstruction(instruction);
			}
		}
		double toReturn = tempParser.getReturnVal();
		instructionStacks.addDouble(toReturn);
		
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException | InstantiationException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

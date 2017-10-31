package backend.commands.multipleTurtleCommands;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.Parser;
import backend.Stacks;
import backend.Turtle;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class AskWith extends GeneralCommands {

	public AskWith(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
		List<String> commands = instructionStacks.getCommandsList(); // commands
		String condition = instructionStacks.getSecondCommandsList().get(0); // turtle IDs
		Parser tempParser = new Parser(instructionStacks.getLanguage());
		StringBuilder sbTell = new StringBuilder();
		for (Turtle t : currentTurtle.allTurtles) {
			tempParser.parseInstruction(t, condition);
			if (tempParser.getReturnVal() == 1.0) {
				sbTell.append(t.getActiveTurtleID() + " ");
			}
		}
		String setTell = sbTell.toString();
		Set<String> idSet = new HashSet<String>();
		for (String id : setTell.split(" ")) {
			idSet.add(id);
		}
		System.out.println("omg " + Arrays.toString(idSet.toArray()).replaceAll(",", "").replaceAll("\\]", "").replaceAll("\\[", ""));
		String ids = "Tell [ " + Arrays.toString(idSet.toArray()).replaceAll(",", "").replaceAll("\\]", "").replaceAll("\\[", "") + " ]";
		double toReturn = 0;
		if (ids.length() != 8) { // check this CHECK THIS TODO 
			tempParser.parseInstruction(currentTurtle, ids);
			for (String instruction : commands) {
				tempParser.parseInstruction(currentTurtle, instruction);
			}
			toReturn = tempParser.getReturnVal();
		}
		instructionStacks.addDouble(toReturn);
	}
}

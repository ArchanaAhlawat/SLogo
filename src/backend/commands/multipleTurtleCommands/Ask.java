package backend.commands.multipleTurtleCommands;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import backend.Parser;
import backend.Stacks;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class Ask extends GeneralCommands {

	public Ask(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException {
		List<String> commands = instructionStacks.getCommandsList(); // commands
		List<String> turtleIDs = instructionStacks.getSecondCommandsList(); // turtle IDs
		Parser tempParser = new Parser(instructionStacks.getLanguage());
		Set<String> idSet = new HashSet<String>();
		for (String id : turtleIDs.get(0).split(" ")) {
			idSet.add(id);
		}
		System.out.println(Arrays.toString(idSet.toArray()).replaceAll(",", "").replaceAll("\\]", "").replaceAll("\\[", ""));
		String ids = Arrays.toString(idSet.toArray()).replaceAll(",", "").replaceAll("\\]", "").replaceAll("\\[", "");
		tempParser.parseInstruction(currentTurtle, "Tell [ " + ids + " ]");
		
		for (String instruction : commands) {
			tempParser.parseInstruction(currentTurtle, instruction);
		}
		double toReturn = tempParser.getReturnVal();
		instructionStacks.addDouble(toReturn);
	}

}

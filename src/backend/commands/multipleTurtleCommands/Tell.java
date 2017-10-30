package backend.commands.multipleTurtleCommands;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import backend.Stacks;
import backend.TurtleTree;
import backend.api.Command;
import backend.commands.GeneralCommands;

public class Tell extends GeneralCommands {

	public Tell(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		currentTurtle.clearActiveTurtles(); // all turtles will become inactive
		List<String> turtleNums = instructionStacks.getCommandsList();
		String turtleNumsString = Arrays.toString(turtleNums.toArray());
		Double doubleNum = 0.0;
		for (String num : turtleNumsString.substring(1, turtleNumsString.length() - 1).split(" ")) {
			doubleNum = Double.parseDouble(num);
			for (int i = 1; i < doubleNum + 1; i++) {
				if (! currentTurtle.containsID(i)) {
					currentTurtle.addActiveTurtle(i); // adds new turtle
				}
				else { // if turtle is inactive, it will be activated. 
					currentTurtle.activateTurtle(i);
				}
			}
		}
		instructionStacks.addDouble(doubleNum);
	}

}

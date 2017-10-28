package backend.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import backend.Stacks;
import backend.TurtleTree;
import backend.api.Command;

public class Tell implements Command {

	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		currentTurtle.clearActiveTurtles();
		List<String> turtleNums = instructionStacks.getCommandsList();
		String turtleNumsString = Arrays.toString(turtleNums.toArray());
		Double doubleNum = 0.0;
		for (String num : turtleNumsString.substring(1, turtleNumsString.length() - 1).split(" ")) {
			doubleNum = Double.parseDouble(num);
			if (! currentTurtle.containsID(doubleNum)) {
				currentTurtle.addActiveTurtle(doubleNum); // adds new turtle
			}
			else { // if turtle is inactive, it will be activated
				currentTurtle.activateTurtle(doubleNum);
			}
		}
		instructionStacks.addDouble(doubleNum);
	}

}

package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class SetBackground extends GeneralCommands {

	public SetBackground(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	public double doUpdate() {
		return currentTurtle.getColorManager().getBackground();
	}
	

}

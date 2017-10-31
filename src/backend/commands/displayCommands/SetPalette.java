package backend.commands.displayCommands;

import backend.Stacks;
import backend.TurtleTree;
import backend.commands.GeneralCommands;

public class SetPalette extends GeneralCommands {

	public SetPalette(Stacks myStack, TurtleTree myTurtle) {
		super(myStack, myTurtle);
	}
	
	@Override
	public void execute(Stacks instructionStacks, TurtleTree currentTurtle) {
		double index = instructionStacks.popDouble();
		double r = instructionStacks.popDouble();
		double g = instructionStacks.popDouble();
		double b = instructionStacks.popDouble();
		currentTurtle.setColorIndex((int) index, new int[] {(int) r, (int) g, (int) b});
		instructionStacks.addDouble(index);
	}

}

package backend.commands;

import java.util.Stack;

import backend.Stacks;
import backend.Turtle;
import backend.api.Command;
import backend.api.LogicCommand;

/**
 * has the execute for when a and command is called
 *     pops two parameters off the stack
 *     pushes if both are nonzero onto the stack
 *     returns the stack of parameters
 * 
 * @author kelly
 *
 */
public class And extends LogicCommand {

	public And(Stacks myStack, Turtle myTurtle) {
		super(myStack, myTurtle);
	}

	@Override
	public double doUpdate() {
		if (expr1 != ZERO && expr2 != ZERO) {
			return ONE;
		}
		else {
			return ZERO;
		}
	}
}

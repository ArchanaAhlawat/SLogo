package backend;

public interface Command {

	/**
	 * executes by running the method associated with the string instruction/method name passed
	 * @param methodName string of the instruction/method name
	 * @param currentTurtle Turtle that will be updated with the change (may not be required)
	 * @return the double specified to be returned in the SLOGO specification, needed to be inserted into the stack of parameters
	 */
	public double execute(String methodName, Turtle currentTurtle);	
	
}

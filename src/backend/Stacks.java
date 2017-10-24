package backend;
import java.util.List;
import java.util.Stack;

//instantiate new Stacks object everytime an instruction is passed through
public class Stacks {
	Stack<Double> numberStack = new Stack<Double>(); // can these be static if only ever one copy? 
	Stack<String> variableStack = new Stack<String>();
	Stack<Double[]> listStack = new Stack<Double[]>();
	Stack<String> commandsStack = new Stack<String>();
	CommandsList commandsList;
	
	public Stacks() {
		
	}
	
	public boolean canBeAdded(String element) { // tests whether non-command (right now: variable or double)
		return (isNumeric(element) || isVariable(element));
	}
	
	public void push(String element) {
		if (isNumeric(element)) numberStack.push(Double.parseDouble(element));
		if (isVariable(element)) variableStack.push(element);
		
		if (element.matches("[ ]")) {
			//TODO: 
			//create the list in double[] form
			//push to listStack
		}
	}
	
	private boolean isNumeric(String possibleInt) {
		 return possibleInt.matches("-?\\d+(\\.\\d+)?");
	}
	
	private boolean isVariable(String possibleVar) {
		return possibleVar.matches(":[a-zA-Z_]+");
	}
	
	public Double peekDouble() {
		return numberStack.peek();
	}
	
	public Double getReturnVal() {
		return numberStack.peek(); // TODO: MAY HAVE TO CHANGE TO POP LATER. VERY IMPORTANT. 
	}
	
	public Double popDouble() {
		return numberStack.pop();
	}
	
	public void addDouble(double num) {
		numberStack.push(num);
	}
	
	public String popVariable() {
		return variableStack.pop();
	}
	
	public void addToCommands(String command) {
		commandsStack.push(command);
	}
	
	public void instantiateCommandsList(String commands) {
		commandsList = new CommandsList(commands);
	}
	
	public List<String> getCommandsList() {
		return commandsList.getCommandsList();
	}
}

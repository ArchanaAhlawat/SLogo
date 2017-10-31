package backend;
import java.util.List;
import java.util.Stack;

//instantiate new Stacks object everytime an instruction is passed through
public class Stacks {
	private Stack<Double> numberStack = new Stack<Double>(); // can these be static if only ever one copy? 
	private Stack<String> variableStack = new Stack<String>();
	private Stack<Double[]> listStack = new Stack<Double[]>();
	private Stack<String> commandsStack = new Stack<String>();
	private CommandsList commandsList;
	private CommandsList secondCommandsOrVarsList;
	private UserVariables userVars;
	private UserCommands userCommands;
	private String language;
	
	public Stacks(String language, UserCommands userC, UserVariables userV) {
		this.language = language;
		this.userCommands = userC;
		this.userVars = userV;
	}
	
	public boolean canBeAdded(String element) { // tests whether non-command (right now: variable or double)
		return (isNumeric(element) || isVariable(element));
	}
	
	public String getTBDefined() {
		return userCommands.getTBDefined();
	}
	
	public String getUserCommands(String key) {
		return userCommands.getCommand(key);
	}
	
	public void putUserVar(String var, double val) {
		userVars.put(var, val);
	}
	
	public void setLanguage(String lang) {
		language = lang;
	}
	
	public void putUserCommands(String var, String command) {
		userCommands.put(var, command);
	}
	
	public String getLanguage() {
		return language;
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
	
	public String peekVariable() {
		return variableStack.peek();
	}
	
	public void addToCommands(String command) {
		commandsStack.push(command);
	}
	
	public String getCommand() {
		return commandsStack.pop();
	}
	
	public void instantiateCommandsList(String commands) {
		commandsList = new CommandsList(commands);
	}
	
	public List<String> getCommandsList() {
		return commandsList.getCommandsList();
	}
	
	public void instantiateSecondCommandsList(String commands) {
		secondCommandsOrVarsList = new CommandsList(commands);
	}
	
	public List<String> getSecondCommandsList() {
		return secondCommandsOrVarsList.getCommandsList();
	}
}

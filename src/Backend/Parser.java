package backend;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Stack;

public class Parser {
	
	// TODO: throw exceptions properly w try/catch
	public void parseInstruction(String inst) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		LangMaps maps = new LangMaps(); // TODO: instantiate in driver later. JUST FOR TESTING
		Map<String, String> langMap = maps.getMaps("ENGLISH");
		Stack<Integer> instructionStack = new Stack<Integer>();
		String[] instructionArray = inst.split(" ");
		for (int i = instructionArray.length - 1; i > -1; i--) {
			if (isNumeric(instructionArray[i])) {
				instructionStack.push(Integer.parseInt(instructionArray[i]));
			}
			else {
				Class<?> commandClass = Class.forName("Backend." + langMap.get(instructionArray[i]));
				Object commandInstance = commandClass.newInstance();
				Method commandMethod = commandClass.getDeclaredMethod("execute", Stack.class);
				Stack<Integer> newStack = (Stack<Integer>) commandMethod.invoke(commandInstance, instructionStack);
				instructionStack = newStack; // invoke method must return new stack. TODO: maybe bad design to pass stack directly
				int returnVal = (int) commandClass.getDeclaredMethod("getReturnValue").invoke(commandInstance);
				System.out.println("RETURN VAL IS " + returnVal);
			}
		}
	}
	
	private boolean isNumeric(String possibleInt) {
		 return possibleInt.matches("-?\\d+(\\.\\d+)?");
	}
	
	public static void main (String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, InstantiationException, ClassNotFoundException {
		Parser p = new Parser();
		p.parseInstruction("Forward Sum 50 5");
	}
}

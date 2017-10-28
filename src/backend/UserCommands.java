package backend;

import java.util.HashMap;
import java.util.Map;

public class UserCommands {
	private static Map<String, String> userCommands = new HashMap<String, String>();
	private static String commandName;
	
	public static void put(String key, String command) {
		userCommands.put(key, command);
	}
	
	public static String getCommand(String key) {
		return userCommands.get(key);
	}
	
	public static boolean contains(String key) {
		return (userCommands.containsKey(key));
	}
	
	public static void setToDefine(String name) {
		commandName = name;
	}
	
	public static String getTBDefined() {
		return commandName;
	}
}

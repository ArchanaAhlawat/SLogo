package backend;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserCommands {
	private Map<String, String> userCommands = new LinkedHashMap<String, String>();
	private String commandName;
	
	public void put(String key, String command) {
		userCommands.put(key, command);
	}
	
	public String getCommand(String key) {
		return userCommands.get(key);
	}
	
	public boolean contains(String key) {
		return (userCommands.containsKey(key));
	}
	
	public void setToDefine(String name) {
		commandName = name;
	}
	
	public String getTBDefined() {
		return commandName;
	}
	
	public List<String> getUserDefinedCommands() {
		List<String> toReturn = new ArrayList<String>();
		for (String varName : userCommands.keySet()) {
			toReturn.add(varName + ": " + userCommands.get(varName));
		}
		return toReturn;
	}
}

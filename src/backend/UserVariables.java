package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserVariables {
	private static Map<String, Double> userVars = new HashMap<String, Double>();
	
	public void put(String key, double val) {
		userVars.put(key, val);
	}
	
	public double getVarVal(String key) {
		return userVars.get(key);
	}
	
	public boolean contains(String key) {
		return (userVars.containsKey(key));
	}
	
	public List<String> getUserDefinedVars() {
		List<String> toReturn = new ArrayList<String>();
		for (String varName : userVars.keySet()) {
			toReturn.add(varName.substring(1) + ": " + userVars.get(varName));
		}
		return toReturn;
	}
}

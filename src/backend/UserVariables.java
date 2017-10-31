package backend;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class UserVariables {
	private static Map<String, Double> userVars = new LinkedHashMap<String, Double>();
	
	public static void put(String key, double val) {
		userVars.put(key, val);
	}
	
	public static double getVarVal(String key) {
		return userVars.get(key);
	}
	
	public static boolean contains(String key) {
		return (userVars.containsKey(key));
	}
	
	public static List<String> getUserDefinedVars() {
		List<String> toReturn = new ArrayList<String>();
		for (String varName : userVars.keySet()) {
			toReturn.add(varName.substring(1) + ": " + userVars.get(varName));
		}
		return toReturn;
	}
}

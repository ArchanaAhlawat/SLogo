package backend;

import java.util.HashMap;
import java.util.Map;

public class UserVariables {
	private static Map<String, Double> userVars = new HashMap<String, Double>();
	
	public static void put(String key, double val) {
		userVars.put(key, val);
	}
	
	public static double getVarVal(String key) {
		return userVars.get(key);
	}
	
	public static boolean contains(String key) {
		return (userVars.containsKey(key));
	}
}

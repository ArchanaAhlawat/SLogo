package backend;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Map;

// should be called in BEDriver --> only once. 
public class LangMaps {
	private Map<String, Map<String, String>> allMaps = new HashMap<String, Map<String, String>>();

	public static String ENGLISH = "resources.languages.languages_en_US";
	public static String CHINESE = "resources.languages.Languages_CHINESE";
	public static String GERMAN = "resources.languages.Languages_GERMAN";
	public static String FRENCH = "resources.languages.Languages_FRENCH";
	public static String ITALIAN = "resources.languages.Languages_ITALIAN";
	public static String PORTUGUESE = "resources.languages.Languages_PORTUGUESE";
	public static String RUSSIAN = "resources.languages.Languages_RUSSIAN";
	public static String SPANISH = "resources.languages.Languages_SPANISH";
	
	public LangMaps(String country) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		createLocaleMaps(country);
	}
	
	/***
	 * 
	 * @param language
	 * @return Map<String, String> for selected language
	 */
	public Map<String, String> getMaps(String language) {
		return allMaps.get(language);
	}
	
	private void createLocaleMaps(String language) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Map<String, String> localeMap = new HashMap<String, String>();
		String countryFile = this.getClass().getDeclaredField(language.toUpperCase()).get(null).toString();
		ResourceBundle localeToAdd = ResourceBundle.getBundle(countryFile);
		for (String key : localeToAdd.keySet()) {
			if (localeToAdd.getString(key).contains("|")) {
				String[] commandSplit = localeToAdd.getString(key).split("\\|");
				for (String commandVariant : commandSplit) {
					localeMap.put(commandVariant.trim(), key);
				}
			}
			else localeMap.put(localeToAdd.getString(key).trim(), key);
		}
		allMaps.put(language.toUpperCase(), localeMap);
	}
	
	public static void main (String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		LangMaps maps = new LangMaps("chinese");
	}
}

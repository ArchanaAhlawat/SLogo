package backend;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Map;

// should be called in BEDriver --> only once. 
public class LangMaps {
	private Map<String, Map<String, String>> allMaps = new HashMap<String, Map<String, String>>();
	private List<Locale> supportedLocales;
	
	public LangMaps() {
		createLocaleMaps();
	}
	
	/***
	 * 
	 * @param language
	 * @return Map<String, String> for selected language
	 */
	public Map<String, String> getMaps(String language) {
		return allMaps.get(language);
	}
	
	private void createLocaleMaps() {
		//for (Locale loc : supportedLocales) {
			Map<String, String> localeMap = new HashMap<String, String>();
			ResourceBundle localeToAdd = ResourceBundle.getBundle("resources.languages.languages", Locale.ENGLISH);
			for (String key : localeToAdd.keySet()) {
				if (localeToAdd.getString(key).contains("|")) {
					String[] commandSplit = localeToAdd.getString(key).split("\\|");
					for (String commandVariant : commandSplit) {
						localeMap.put(commandVariant.trim(), key);
					}
				}
				else localeMap.put(localeToAdd.getString(key).trim(), key);
			}
			allMaps.put(Locale.ENGLISH.getCountry(), localeMap);
		//}
	}
}

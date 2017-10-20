package Backend;

import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Locale;
import java.util.Map;

// should be called in BEDriver --> only once. 
public class LangMaps {
	private Map<String, Map<String, String>> allMaps;
	private List<Locale> supportedLocales;
	
	public LangMaps() {
		// instantiate all maps with all languages
		supportedLocales.add(Locale.CHINESE);
		supportedLocales.add(Locale.FRENCH);
		supportedLocales.add(Locale.GERMAN);
		supportedLocales.add(Locale.ITALIAN);
		supportedLocales.add(new Locale("PORTUGUESE", "pt"));
		supportedLocales.add(new Locale("RUSSIAN", "ru"));
		supportedLocales.add(new Locale("SPANISH", "es"));
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
		for (Locale loc : supportedLocales) {
			Map<String, String> localeMap = new HashMap<String, String>();
			ResourceBundle localeToAdd = ResourceBundle.getBundle("languages", loc);
			for (String key : localeToAdd.keySet()) {
				localeMap.put(key, localeToAdd.getString(key));
			}
			allMaps.put(loc.getLanguage(), localeMap);
		}
	}
}

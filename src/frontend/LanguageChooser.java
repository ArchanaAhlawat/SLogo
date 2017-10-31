package frontend;

import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class LanguageChooser extends ChoiceBox<String> {
	
	public String LANGUAGE_DEFAULT = "English";
	
	private static final String COMMA = ",";
	
	private ObservableList<String> languageOptions;
	
	public LanguageChooser(String languages,double width,double height) {
		super();
		commonInitializer(languages,width, height);
		setValue(LANGUAGE_DEFAULT);
	}

	public void commonInitializer(String languages,double width,double height) {
		setItems(ListToObservable(languages));
		setPrefWidth(width);
		setPrefHeight(height);
	}
	
	public LanguageChooser(String languages,double width,double height,String language) {
	    super();
		commonInitializer(languages,width, height);
		LANGUAGE_DEFAULT=language;
		System.out.println(LANGUAGE_DEFAULT);
		setValue(language);
		
	}
	
	protected ReadOnlyIntegerProperty getIndex() {
		return getSelectionModel().selectedIndexProperty();
	}
	
	protected String getCurrentLanguage(Number number) {
		return languageOptions.get((int) number);
	}
	
	private ObservableList<String> ListToObservable(String languages) {
		String[] langArray = languages.split(COMMA);
		List<String> langList = Arrays.asList(langArray);
		languageOptions = FXCollections.observableList(langList);
		return languageOptions;
	}

}

package frontend;

import java.util.Arrays;
import java.util.List;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class LanguageChooser extends ChoiceBox<String> {
	
	public static final String LANGUAGE_DEFAULT = "English";
	
	private static final String COMMA = ",";
	
	private ObservableList<String> languageOptions;
	
	public LanguageChooser(String languages,double width,double height) {
		super();
		setItems(ListToObservable(languages));
		setValue(LANGUAGE_DEFAULT);
		setPrefWidth(width);
		setPrefHeight(height);
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

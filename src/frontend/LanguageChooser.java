package frontend;

import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

public class LanguageChooser extends ChoiceBox<String>{
	
	private static final String LANGUAGE_DEFAULT = "English";
	private static final String COMMA = ",";
	
	public LanguageChooser(String languages,double width,double height) {
		super();
		this.setItems(ListToObservable(languages));
		this.setValue(LANGUAGE_DEFAULT);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
	}
	
	private ObservableList<String> ListToObservable(String languages) {
		String[] langArray = languages.split(COMMA);
		List<String> langList = Arrays.asList(langArray);
		return FXCollections.observableList(langList);
	}
	
	protected String getLanguage() {
		return this.getSelectionModel().getSelectedItem();
	}

}

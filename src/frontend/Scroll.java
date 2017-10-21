package frontend;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;

public abstract class Scroll {
	
	private static final int LABEL_START = 5;
	private static final String NEW_LINE = "\n";
	
	private ScrollPane scrollPane;
	private Text allHistory;
	private String scrollLabel;
	
	public Scroll(String label,int x,int y,int width,int height) {
		scrollLabel = label;
		scrollPane = new ScrollPane();
		scrollPane.setTranslateX(x);
		scrollPane.setTranslateY(y);
		scrollPane.setPrefWidth(width);
		scrollPane.setPrefHeight(height);
		scrollPane.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		allHistory = new Text(label);
		allHistory.wrappingWidthProperty().bind(scrollPane.widthProperty());
		allHistory.setTranslateX(LABEL_START);
		scrollPane.setContent(allHistory);
	}
	
	protected String formatCommand(String command) {
		return command + NEW_LINE;
	}
	
	protected void addToScrollPane(String command) {
		allHistory.setText(command);
		getScrollPane().setContent(allHistory);
	}
	
	protected String getPastText() {
		return allHistory.getText();
	}
	
	protected String getScrollLabel() {
		return scrollLabel;
	}
	
	protected ScrollPane getScrollPane() {
		return scrollPane;
	}
}

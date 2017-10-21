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
	
	private ScrollPane scrollPane;
	private Text allHistory;
	
	public Scroll(String label,int x,int y,int width,int height) {
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
	
	protected ScrollPane getScrollPane() {
		return scrollPane;
	}
	
	protected Text getAllHistory() {
		return allHistory;
	}
	
	protected void setAllHistory(Text text) {
		this.allHistory = text;
	}
}

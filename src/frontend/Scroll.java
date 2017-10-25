package frontend;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;

public abstract class Scroll extends ScrollPane {
	
	private static final int LABEL_START = 5;
	private static final String NEW_LINE = "\n";
	
	private Text allHistory;
	private String scrollLabel;
	
	public Scroll(String label,int x,int y,int width,int height) {
		super(new Text(label));
		scrollLabel = label;
		allHistory = new Text(label);
		this.setTranslateX(x);
		this.setTranslateY(y);
		this.setPrefWidth(width);
		this.setPrefHeight(height);
		this.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		allHistory.wrappingWidthProperty().bind(this.widthProperty());
		allHistory.setTranslateX(LABEL_START);
		this.setContent(allHistory);
	}
	
	protected String formatCommand(String command) {
		return command + NEW_LINE;
	}
	
	protected void addToScrollPane(String command) {
		allHistory.setText(command);
		this.setContent(allHistory);
	}
	
	protected String getPastText() {
		return allHistory.getText();
	}
	
	protected String getScrollLabel() {
		return scrollLabel;
	}
}

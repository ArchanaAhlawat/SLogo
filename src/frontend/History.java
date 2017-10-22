package frontend;

import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class History extends Scroll {
	
	private static final String EMPTY_STRING = "";
	
	public History(String label, int x, int y, int width, int height) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	protected void addHistory(String command) {
		if(!command.equals(EMPTY_STRING)) {
			String formattedCommand = formatCommand(command);
			String past = getPastText();
			addToScrollPane(past + formattedCommand);
		}
	}
}

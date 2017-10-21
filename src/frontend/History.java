package frontend;

import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;

public class History extends Scroll {
	
	public History(String label, int x, int y, int width, int height) {
		super(label, x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	protected void addHistory(String command) {
		String formattedCommand = command + "\n";
		Text allHistory = this.getAllHistory();
		String past = allHistory.getText();
		allHistory.setText(past + formattedCommand);
		this.setAllHistory(allHistory);
		this.getScrollPane().setContent(allHistory);
	}
}

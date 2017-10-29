package frontend;


import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyEvent;

public class KeyboardHandler {
	private Group root;
	private FrontEndDriver FE;
	KeyboardHandler(Group root,FrontEndDriver FEDriver){
		this.root=root;
		this.FE=FEDriver;
		
	}
	public void execute() {root.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {

					@Override
					public void handle(KeyEvent event) {

						switch (event.getCode()) {
						case UP:
							keyBoardExecute("FORWARD 10",event);
							break;
						case DOWN:
							keyBoardExecute("BACK 10",event);
							break;
						case LEFT:
							keyBoardExecute("LEFT 10",event);
							break;
						case RIGHT:
							keyBoardExecute("RIGHT 10",event);
							break;
						default:
							break;

						}

					}
				});
	}

	private void keyBoardExecute(String c, KeyEvent event) {
		FE.executeCommandOnly(c);
		event.consume();

	}

}

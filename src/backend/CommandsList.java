package backend;

import java.util.ArrayList;
import java.util.List;

public class CommandsList {
	private List<String> commandsList = new ArrayList<String>();
	
	public CommandsList(String commands) {
		String[] temp = commands.split(", ");
		for (String command : temp) {
			commandsList.add(command);
		}
		// \n[\ncommand1\ncommand2\ncommand3\n]\n 
	}
	
	public List<String> getCommandsList() {
		return commandsList;
	}
}

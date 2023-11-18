package tp1.control.commands;

public abstract class NoParamsCommand extends Command {

	@Override
	public Command parse(String[] commandWords) {
		String command = commandWords[0].toString();
		if(matchCommandName(command)) {
			return this;
		}
		else 
			return null;
	}

}

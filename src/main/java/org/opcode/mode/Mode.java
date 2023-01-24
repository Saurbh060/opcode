package org.opcode.mode;

import org.opcode.Command;
import org.opcode.processor.exceptions.InvalidCommandException;
import org.opcode.processor.factory.CommandExecutor;
import org.opcode.processor.factory.MicroProcessorFactory;

import java.io.IOException;

public abstract class Mode {

	private MicroProcessorFactory microProcessorFactory;

	public Mode(MicroProcessorFactory microProcessorFactory) {
		this.microProcessorFactory = microProcessorFactory;
	}

	protected void processCommand(final Command command)
	{
		final CommandExecutor commandExecutor = microProcessorFactory.getCommandExecutor(command);
		if(commandExecutor.validate(command)) {
			commandExecutor.execute(command);
		} else {
			throw new InvalidCommandException();
		}
	}

	public abstract void process() throws IOException;
}

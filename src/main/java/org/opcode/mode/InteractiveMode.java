package org.opcode.mode;

import org.opcode.Command;
import org.opcode.processor.factory.MicroProcessorFactory;
import org.opcode.processor.factory.OperationExitCommandExecutor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InteractiveMode extends Mode{

	public InteractiveMode(MicroProcessorFactory microProcessorFactory) {
		super(microProcessorFactory);
	}

	@Override
	public void process() throws IOException {
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true)
		{
			final String input = reader.readLine();
			final Command command = new Command(input);
			processCommand(command);
			if(command.getOperationName().equalsIgnoreCase(OperationExitCommandExecutor.COMMAND_NAME.name())) {
				break;
			}

			// need to correct input handling, getting error while converting command name to IUnstruction Enum
		}
	}
}

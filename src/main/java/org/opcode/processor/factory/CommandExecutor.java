package org.opcode.processor.factory;

import org.opcode.Command;
import org.opcode.service.ProcessorService;

public abstract class CommandExecutor {

	protected ProcessorService processorService;

	public CommandExecutor(final ProcessorService processorService) {
		this.processorService = processorService;
	}

	public abstract boolean validate(Command command);

	//function to execute the command
	public abstract void execute(Command command);
}

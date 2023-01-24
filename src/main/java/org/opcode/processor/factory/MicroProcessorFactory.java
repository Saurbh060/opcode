package org.opcode.processor.factory;

import org.opcode.Command;
import org.opcode.common.Instruction;
import org.opcode.processor.exceptions.InvalidCommandException;
import org.opcode.service.ProcessorService;

import java.util.HashMap;
import java.util.Map;

public class MicroProcessorFactory {

	private Map<Instruction, CommandExecutor> commands = new HashMap<>();


	public MicroProcessorFactory(final ProcessorService processorService) {

		commands.put(OperationSetCommanExecutor.COMMAND_NAME,
			new OperationSetCommanExecutor((processorService)));
		commands.put(OperationAdditionNumberCommandExecutor.COMMAND_NAME,
			new OperationAdditionNumberCommandExecutor((processorService)));
		commands.put(OperationExitCommandExecutor.COMMAND_NAME,
			new OperationExitCommandExecutor((processorService)));
		commands.put(OperationIncrementCommandExecutor.COMMAND_NAME,
			new OperationIncrementCommandExecutor((processorService)));
		commands.put(OperationCreateRegistersCommandExecutor.COMMAND_NAME,
			new OperationCreateRegistersCommandExecutor((processorService)));
		commands.put(OperationReplaceRegisterValueCommandExecutor.COMMAND_NAME,
			new OperationReplaceRegisterValueCommandExecutor((processorService)));
		commands.put(OperationAddRegistersCommandExecutor.COMMAND_NAME,
			new OperationAddRegistersCommandExecutor((processorService)));
		commands.put(OperationResetCommanExecutor.COMMAND_NAME,
			new OperationResetCommanExecutor((processorService)));

	}

	public CommandExecutor getCommandExecutor(final Command command)
	{
		final CommandExecutor commandExecutor = commands.get(Instruction.valueOf(command.getOperationName()));
		if(commandExecutor == null)
			throw new InvalidCommandException();

		return commandExecutor;
	}
}

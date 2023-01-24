package org.opcode.processor.factory;

import org.opcode.Command;
import org.opcode.common.Instruction;
import org.opcode.service.ProcessorService;

public class OperationExitCommandExecutor extends CommandExecutor{

	public static Instruction COMMAND_NAME = Instruction.EXIT;

	public OperationExitCommandExecutor(ProcessorService processorService) {
		super(processorService);
	}

	@Override
	public boolean validate(Command command) {
		return command.getParams().isEmpty();
	}

	@Override
	public void execute(Command command) {
		System.out.println("leaving the console\n");
	}

}

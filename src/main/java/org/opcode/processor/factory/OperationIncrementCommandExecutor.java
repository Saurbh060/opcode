package org.opcode.processor.factory;

import org.opcode.Command;
import org.opcode.common.Instruction;
import org.opcode.service.ProcessorService;

public class OperationIncrementCommandExecutor extends CommandExecutor{
	public static Instruction COMMAND_NAME = Instruction.INR;

	public OperationIncrementCommandExecutor(ProcessorService processorService) {
		super(processorService);
	}

	@Override
	public boolean validate(Command command) {
		if(command.getParams().size() == 1)
			return true;
		return false;
	}

	@Override
	public void execute(Command command) {
		processorService.incrementOperation(command);
	}
}

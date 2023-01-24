package org.opcode.processor.factory;

import org.opcode.Command;
import org.opcode.common.Instruction;
import org.opcode.service.ProcessorService;

public class OperationAddRegistersCommandExecutor extends CommandExecutor{

	public static Instruction COMMAND_NAME = Instruction.ADR;

	public OperationAddRegistersCommandExecutor(ProcessorService processorService) {
		super(processorService);
	}


	@Override
	public boolean validate(Command command) {
		if(command.getParams().size() == 2)
			return true;
		return false;
	}

	@Override
	public void execute(Command command) {
		processorService.addValuesOfRegister(command);
	}
}

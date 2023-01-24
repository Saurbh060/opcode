package org.opcode.processor.factory;

import org.opcode.Command;
import org.opcode.common.Instruction;
import org.opcode.service.ProcessorService;

public class OperationResetCommanExecutor extends CommandExecutor{

	public static Instruction COMMAND_NAME = Instruction.RST;

	public OperationResetCommanExecutor(ProcessorService processorService) {
		super(processorService);
	}

	@Override
	public boolean validate(Command command) {
		if(command.getParams().size() == 0)
			return true;
		return false;
	}

	@Override
	public void execute(Command command) {
		processorService.setAllRegisters();
	}
}

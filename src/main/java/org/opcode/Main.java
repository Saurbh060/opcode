package org.opcode;

import org.opcode.exceptions.InvalidModeException;
import org.opcode.mode.InteractiveMode;
import org.opcode.processor.factory.MicroProcessorFactory;
import org.opcode.service.ProcessorService;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {

		final ProcessorService processorService = new ProcessorService();
		final MicroProcessorFactory microProcessorFactory = new MicroProcessorFactory(processorService);

		if(isInteractiveMode(args)) {
			new InteractiveMode(microProcessorFactory).process();
		}else {
			throw new InvalidModeException();
		}
	}

	private static boolean isInteractiveMode(String[] args) {
		if(args.length ==0)
			return true;
		return false;
	}
}
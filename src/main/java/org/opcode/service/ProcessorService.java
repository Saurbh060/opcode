package org.opcode.service;

import org.opcode.Command;
import org.opcode.common.Register;

import java.util.HashMap;
import java.util.Map;

public class ProcessorService {

	private Map<Register, Integer> registers = new HashMap<>();

	public void setOperation(Command command) {

		Register register = Register.valueOf(command.getParams().get(0));
		register.setValue(Integer.parseInt(command.getParams().get(1)));
		registers.put(register, register.getValue());
		System.out.printf("Setting the value of %s with value %s\n", register.name(), register.getValue());
		printRegisters();
	}

	public void setAllRegisters() {
		registers.forEach((register,value) -> registers.put(register,0));
		for(Register register : Register.values() ) {
			register.setValue(0);
		}
		System.out.printf("Setting the value of Registers to value 0\n");
		printRegisters();
	}

	public void addValuesOfRegister(Command command) {

		Register registerA = Register.valueOf(command.getParams().get(0));
		Register registerB = Register.valueOf(command.getParams().get(1));
		Integer registerValueA = registerA.getValue() + registerB.getValue();
		registerA.setValue(registerValueA);
		registers.put(registerA, registerValueA);
		System.out.printf("Adding the value of %s into %s\n", registerA.name(), registerB.name());
		printRegisters();
	}

	public void addNumberInRegister(Command command) {

		Register register = Register.valueOf(command.getParams().get(0));
		Integer registerValue = register.getValue() + Integer.parseInt(command.getParams().get(1));
		register.setValue(registerValue);
		registers.put(register, registerValue);
		System.out.printf("Adding the value %s into %s\n", Integer.parseInt(command.getParams().get(1)), register.name());
		printRegisters();
	}

	public void moveValuesOfRegister(Command command) {
		Register registerA = Register.valueOf(command.getParams().get(0));
		Register registerB = Register.valueOf(command.getParams().get(1));
		Integer registerValueA = registerB.getValue();
		registerA.setValue(registerValueA);
		registers.put(registerA, registerValueA);
		System.out.printf("Replacing the value of %s with value of %s\n", registerA.name(), registerB.name());
		printRegisters();
	}

	public void incrementOperation(Command command) {
		Register register = Register.valueOf(command.getParams().get(0));
		Integer registerValue = register.getValue() + 1;
		registers.put(register, registerValue);
		register.setValue(registerValue);
		System.out.printf("Incrementing the value %s by 1\n", register.name());
		printRegisters();
	}

	public void createRegister(Command command) {
		for(Register register : Register.values() ) {
			registers.put(register, 0);
		}
		System.out.printf("Setting up the all values as 0\n");
		printRegisters();
	}

	public void printRegisters()
	{
		for(Register register : Register.values() ) {
			System.out.printf("Current value of register %s is %s\n", register.name(), register.getValue());
		}
		System.out.println();
	}

	public void decrementValuesOfRegister(Command command) {
		Register register = Register.valueOf(command.getParams().get(0));
		Integer registerValue = register.getValue() - 1;
		registers.put(register, registerValue);
		register.setValue(registerValue);
		System.out.printf("decrementing the value %s by 1\n", register.name());
		printRegisters();
	}
}

package org.opcode.common;

/**
 * The enum Instruction.
 */
public enum Instruction {

	/**
	 * Set instruction.
	 */
	SET,

	/**
	 * Create all registeres with default value 0.
	 */
	CRT,
	/**
	 * Adr instruction.
	 */
	ADR,
	/**
	 * Add instruction.
	 */
	ADD,
	/**
	 * Mov instruction.
	 */
	MOV,
	/**
	 * Inr instruction.
	 */
	INR,
	/**
	 * Dcr instruction.
	 */
	DCR,
	/**
	 * Rst instruction.
	 */
	RST,

	/**
	 * Exit instruction.
	 */
	EXIT;
}

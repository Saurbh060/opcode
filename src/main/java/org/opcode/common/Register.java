package org.opcode.common;

public enum Register {

	A(0),
	B(0),
	C(0),
	D(0);

	private int value;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	Register(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Register{" +
			"value=" + value +
			'}';
	}
}

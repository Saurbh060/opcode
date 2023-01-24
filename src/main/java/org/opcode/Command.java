package org.opcode;

import org.opcode.processor.exceptions.InvalidCommandException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

	private static final String SPACE = " ";
	private String operationName;
	private List<String> params;

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public Command(final String inputLine) {
		final List<String> tokensList = Arrays.stream(inputLine.trim().split(SPACE))
			.map(String::trim)
			.filter(token -> (token.length() > 0)).collect(Collectors.toList());

		if (tokensList.size() == 0) {
			throw new InvalidCommandException();
		}

		operationName = tokensList.get(0);
		tokensList.remove(0);
		params = tokensList;
	}

}

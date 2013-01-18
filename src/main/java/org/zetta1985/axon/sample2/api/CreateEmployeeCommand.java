package org.zetta1985.axon.sample2.api;

import org.apache.commons.lang.Validate;

/**
 * @author t_hara
 */
public class CreateEmployeeCommand {

	private final String newEmployeeName;

	/**
	 * @param newEmployeeName
	 */
	public CreateEmployeeCommand(String newEmployeeName) {
		super();
		Validate.notEmpty(newEmployeeName);
		this.newEmployeeName = newEmployeeName;
	}
	
	/**
	 * @return the newEmployeeName
	 */
	public String getNewEmployeeName() {
		return newEmployeeName;
	}
}

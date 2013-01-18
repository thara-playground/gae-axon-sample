package org.zetta1985.axon.sample2.api;

import org.apache.commons.lang.Validate;

/**
 * @author t_hara
 */
public abstract class AbstractEmployeeCommand {

	private String employeeId;

	/**
	 * @param employeeId
	 */
	public AbstractEmployeeCommand(String employeeId) {
		super();
		Validate.notEmpty(employeeId);
		this.employeeId = employeeId;
	}
	
	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}
}

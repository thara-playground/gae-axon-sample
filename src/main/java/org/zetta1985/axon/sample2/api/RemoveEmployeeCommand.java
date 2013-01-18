package org.zetta1985.axon.sample2.api;

/**
 * @author t_hara
 */
public class RemoveEmployeeCommand extends AbstractEmployeeCommand {

	/**
	 * @param employeeId
	 */
	public RemoveEmployeeCommand(String employeeId) {
		super(employeeId);
	}

}

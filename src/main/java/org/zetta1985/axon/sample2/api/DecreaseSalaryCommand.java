package org.zetta1985.axon.sample2.api;

import java.math.BigDecimal;

/**
 * @author t_hara
 */
public class DecreaseSalaryCommand extends AbstractEmployeeSalaryCommand {

	/**
	 * @param employeeId
	 * @param value
	 */
	public DecreaseSalaryCommand(String employeeId, BigDecimal value) {
		super(employeeId, value);
	}

}

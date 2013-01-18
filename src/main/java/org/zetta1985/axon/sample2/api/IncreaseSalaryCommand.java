package org.zetta1985.axon.sample2.api;

import java.math.BigDecimal;

/**
 * @author t_hara
 */
public class IncreaseSalaryCommand extends AbstractEmployeeSalaryCommand {

	/**
	 * @param employeeId
	 * @param value
	 */
	public IncreaseSalaryCommand(String employeeId, BigDecimal value) {
		super(employeeId, value);
	}

}

package org.zetta1985.axon.sample2.api;

import java.math.BigDecimal;

import org.apache.commons.lang.Validate;

/**
 * @author t_hara
 */
public class AbstractEmployeeSalaryCommand extends AbstractEmployeeCommand {

	private BigDecimal value;
	
	/**
	 * @param employeeId
	 */
	public AbstractEmployeeSalaryCommand(String employeeId, BigDecimal value) {
		super(employeeId);
		Validate.isTrue(value.compareTo(BigDecimal.ZERO) > 0);
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public BigDecimal getValue() {
		return value;
	}
}

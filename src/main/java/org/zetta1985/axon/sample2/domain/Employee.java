package org.zetta1985.axon.sample2.domain;

import java.math.BigDecimal;

import org.axonframework.domain.AbstractAggregateRoot;
import org.axonframework.domain.AggregateIdentifier;

/**
 * @author t_hara
 */
public class Employee extends AbstractAggregateRoot{

	/** serialVersionUID */
	private static final long serialVersionUID = -6286018912860116284L;

	private String name;
	
	private BigDecimal monthlySalary;
		
	/**
	 * @param identifier
	 */
	public Employee(AggregateIdentifier identifier, String name) {
		super(identifier);
		this.name = name;
		this.monthlySalary = new BigDecimal(200000);
	}
	
	/**
	 * @param identifier
	 */
	public Employee(AggregateIdentifier identifier) {
		super(identifier);
	}
	
	public void increaseSalary(BigDecimal increase) {
		this.monthlySalary = this.monthlySalary.add(increase);
	}
	
	public void decreaseSalary(BigDecimal decrease) {
		this.monthlySalary = this.monthlySalary.subtract(decrease);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the monthlySalary
	 */
	public BigDecimal getMonthlySalary() {
		return monthlySalary;
	}
}

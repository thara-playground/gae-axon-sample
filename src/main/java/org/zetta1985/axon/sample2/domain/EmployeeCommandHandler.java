package org.zetta1985.axon.sample2.domain;

import java.math.BigDecimal;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.StringAggregateIdentifier;
import org.zetta1985.axon.framework.DeletableRepository;
import org.zetta1985.axon.sample2.api.AbstractEmployeeCommand;
import org.zetta1985.axon.sample2.api.CreateEmployeeCommand;
import org.zetta1985.axon.sample2.api.DecreaseSalaryCommand;
import org.zetta1985.axon.sample2.api.IncreaseSalaryCommand;
import org.zetta1985.axon.sample2.api.RemoveEmployeeCommand;

/**
 * @author t_hara
 */
public class EmployeeCommandHandler {

	DeletableRepository<Employee> repository;
	
	@CommandHandler
	public String handle(CreateEmployeeCommand command) {
		String newEmployeeName = command.getNewEmployeeName();
		AggregateIdentifier id = new StringAggregateIdentifier(newEmployeeName);
		Employee employee = new Employee(id, newEmployeeName);
		repository.add(employee);
		return id.asString();
	}
	
	@CommandHandler
	public BigDecimal handle(IncreaseSalaryCommand command) {
		Employee target = repository.load(getId(command));
		target.increaseSalary(command.getValue());
		return target.getMonthlySalary();
	}
	
	@CommandHandler
	public void handle(DecreaseSalaryCommand command) {
		Employee target = repository.load(getId(command));
		target.decreaseSalary(command.getValue());
	}

	@CommandHandler
	public void handle(RemoveEmployeeCommand command) {
		repository.delete(getId(command));
	}
	
	/**
	 * @param command
	 * @return
	 */
	StringAggregateIdentifier getId(AbstractEmployeeCommand command) {
		return new StringAggregateIdentifier(command.getEmployeeId());
	}
	
}

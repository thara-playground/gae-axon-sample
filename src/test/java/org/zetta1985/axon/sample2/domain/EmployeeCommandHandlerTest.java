package org.zetta1985.axon.sample2.domain;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.axonframework.commandhandling.CommandCallback;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerAdapter;
import org.axonframework.repository.AggregateNotFoundException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.zetta1985.axon.framework.InMemoryRepository;
import org.zetta1985.axon.sample2.api.CreateEmployeeCommand;
import org.zetta1985.axon.sample2.api.IncreaseSalaryCommand;


/**
 * @author t_hara
 */
public class EmployeeCommandHandlerTest {

	static SimpleCommandBus commandBus;
	
	static InMemoryRepository<Employee> repository;
	
	@BeforeClass
	public static void init() {
		commandBus = new SimpleCommandBus();
		
		EmployeeCommandHandler handler = new EmployeeCommandHandler();
		handler.repository = repository = new InMemoryRepository<Employee>();
		new AnnotationCommandHandlerAdapter(
				handler, commandBus).subscribe();
	}
	
	@Before
	public void setup() {
		repository.clear();
	}
	
	@Test
	public void createEmployee() {
		StringCallback callback = new StringCallback();
		commandBus.dispatch(new CreateEmployeeCommand("AAAA"), callback);
		
		assertNotNull(callback.result);
	}
	
	@Test
	public void increaseSalary_success() {
		commandBus.dispatch(new CreateEmployeeCommand("AAAA"));
		
		DecimalCallback callback = new DecimalCallback();
		commandBus.dispatch(new IncreaseSalaryCommand("AAAA", new BigDecimal(5000)), callback);
		
		assertEquals(new BigDecimal(205000), callback.result);
	}
	
	@Test(expected=AggregateNotFoundException.class)
	public void increaseSalary_failed() {
		DecimalCallback callback = new DecimalCallback();
		commandBus.dispatch(new IncreaseSalaryCommand("AAAA", new BigDecimal(5000)), callback);		
	}
	
	static class StringCallback implements CommandCallback<String> {

		String result;
		
		@Override
		public void onSuccess(String result) {
			this.result = result;
		}

		@Override
		public void onFailure(Throwable cause) {
			if (cause instanceof RuntimeException) throw (RuntimeException)cause; 
			throw new RuntimeException(cause);
		}
	}

	static class DecimalCallback implements CommandCallback<BigDecimal> {

		BigDecimal result;
		
		@Override
		public void onSuccess(BigDecimal result) {
			this.result = result;
		}

		@Override
		public void onFailure(Throwable cause) {
			if (cause instanceof RuntimeException) throw (RuntimeException)cause; 
			throw new RuntimeException(cause);
		}
	}
}

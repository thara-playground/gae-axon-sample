package org.zetta1985.axon.sample1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.annotation.AnnotationCommandHandlerAdapter;
import org.junit.Before;
import org.junit.Test;
import org.zetta1985.axon.framework.cqrs.CommandDispatcher;
import org.zetta1985.axon.framework.cqrs.DefaultCommandDispatcher;
import org.zetta1985.axon.sample1.api.HelloCommand;
import org.zetta1985.axon.sample1.api.ReguireNameCommand;
import org.zetta1985.axon.sample1.api.callback.SampleCallback;


/**
 * @author t_hara
 */
public class CommandHandlingTest {

	CommandBus commandBus;
	CommandDispatcher dispacher;
	
	@Before
	public void setup() {
		commandBus = new SimpleCommandBus();
		dispacher = new DefaultCommandDispatcher(commandBus);
		
		new AnnotationCommandHandlerAdapter(
				new SampleCommandHandler(), commandBus).subscribe();
	}
	
	@Test
	public void handleHelloCommand() {
		HelloCommand command = new HelloCommand();
		command.setName("zetta1985");
		
		SampleCallback callback = new SampleCallback();
		commandBus.dispatch(command, callback);
		
		assertEquals("Hello, zetta1985.", callback.getResult());
		assertNull(callback.getCause());
	}
	
	@Test
	public void handleReguireNameCommand_1() {
		ReguireNameCommand command = new ReguireNameCommand();
		
		SampleCallback callback = new SampleCallback();
		commandBus.dispatch(command, callback);
		
		assertNull(callback.getResult());
		
		Throwable t = callback.getCause();
		assertNotNull(t);
		assertEquals(IllegalArgumentException.class, t.getClass());
		assertEquals("name is null.", t.getMessage());
	}
	
	@Test
	public void handleReguireNameCommand_2() {
		ReguireNameCommand command = new ReguireNameCommand();
		try {
			dispacher.dispatch(command);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("name is null.", e.getMessage());
		}
	}
}

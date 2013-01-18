package org.zetta1985.axon.sample1;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.zetta1985.axon.sample1.api.HelloCommand;
import org.zetta1985.axon.sample1.api.NotCallbackCommand;
import org.zetta1985.axon.sample1.api.ReguireNameCommand;

/**
 * @author t_hara
 */
public class SampleCommandHandler {

	@CommandHandler
	public String handle(HelloCommand command) {
		return String.format("Hello, %s.", command.getName());
	}
	
	@CommandHandler
	public void handle(NotCallbackCommand command) {
		// 結果を返さない
	}
	
	@CommandHandler
	public void handle(ReguireNameCommand command) {
		if (command.getName() == null) throw new IllegalArgumentException("name is null.");
	}
}

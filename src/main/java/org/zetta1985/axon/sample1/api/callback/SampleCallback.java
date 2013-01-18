package org.zetta1985.axon.sample1.api.callback;

import org.axonframework.commandhandling.CommandCallback;

/**
 * @author t_hara
 */
public class SampleCallback implements CommandCallback<String> {

	private String result;
	private Throwable cause;
	
	@Override
	public void onFailure(Throwable cause) {
		this.cause = cause;
	}

	@Override
	public void onSuccess(String result) {
		this.result = result;
	}

	public String getResult() {
		return result;
	}

	public Throwable getCause() {
		return cause;
	}
}

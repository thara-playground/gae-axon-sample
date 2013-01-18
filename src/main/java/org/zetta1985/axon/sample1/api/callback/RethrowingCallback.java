package org.zetta1985.axon.sample1.api.callback;

import org.axonframework.commandhandling.CommandCallback;

/**
 * @author t_hara
 */
public class RethrowingCallback implements CommandCallback<Object> {

	@Override
	public void onFailure(Throwable cause) {
		// ビジネスロジックの例外クラスをRuntimeExceptionのサブクラスと想定
		if (cause instanceof RuntimeException) {
			throw (RuntimeException)cause;
		}else {
			throw new Error(cause);
		}
	}

	@Override
	public void onSuccess(Object result) {
		//
	}
}

package org.zetta1985.axon.framework;

import org.axonframework.commandhandling.interceptors.TransactionInterceptor;

/**
 * @author t_hara
 */
public class SimpleTransactionInterceptor extends TransactionInterceptor<SimpleTransaction> {

	/**
	 * @inherited
	 */
	@Override
	protected SimpleTransaction startTransaction() {
		return new SimpleTransaction();
	}

	/**
	 * @inherited
	 */
	@Override
	protected void commitTransaction(SimpleTransaction transaction) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @inherited
	 */
	@Override
	protected void rollbackTransaction(SimpleTransaction transaction) {
		// TODO Auto-generated method stub
		
	}

}

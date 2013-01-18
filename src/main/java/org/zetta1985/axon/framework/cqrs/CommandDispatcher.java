package org.zetta1985.axon.framework.cqrs;

/**
 * @author t_hara
 */
public interface CommandDispatcher {

	void dispatch(Object command);
}

package org.zetta1985.axon.framework;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.AggregateRoot;
import org.axonframework.repository.Repository;

/**
 * @author t_hara
 */
public interface DeletableRepository<T extends AggregateRoot> extends Repository<T> {

	void delete(AggregateIdentifier aggregateIdentifier);
}

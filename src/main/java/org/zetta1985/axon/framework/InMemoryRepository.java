package org.zetta1985.axon.framework;

import java.util.HashMap;
import java.util.Map;

import org.axonframework.domain.AggregateIdentifier;
import org.axonframework.domain.AggregateRoot;
import org.axonframework.repository.AbstractRepository;
import org.axonframework.repository.AggregateNotFoundException;

/**
 * @author t_hara
 */
public class InMemoryRepository<T extends AggregateRoot> extends AbstractRepository<T> implements DeletableRepository<T>{

	private Map<AggregateIdentifier, T> aggregates = new HashMap<AggregateIdentifier, T>();
	
	/**
	 * @inherited
	 */
	@Override
	protected T doLoad(AggregateIdentifier aggregateIdentifier,
			Long expectedVersion) {
		T aggregate = aggregates.get(aggregateIdentifier);
		if (aggregate == null) throw new AggregateNotFoundException("The aggregate was not found");
		return aggregate;
	}

	/**
	 * @inherited
	 */
	@Override
	protected void doSave(T aggregate) {
		aggregates.put(aggregate.getIdentifier(), aggregate);
	}
	
	/**
	 * @inherited
	 */
	@Override
	public void delete(AggregateIdentifier aggregateIdentifier) {
		aggregates.remove(aggregateIdentifier);
	}
	
	public void clear() {
		aggregates.clear();
	}
}

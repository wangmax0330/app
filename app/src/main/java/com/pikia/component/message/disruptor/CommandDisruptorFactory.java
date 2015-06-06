package com.pikia.component.message.disruptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.dsl.Disruptor;
import com.pikia.component.message.disruptor.consumer.ModelConsumerLoader;

/**
 * command 注解由CommandDisruptorFactory进行处理,暂时没用
 * 
 * @author methew
 * 
 */
@Component
public class CommandDisruptorFactory extends AbstractCachingDisruptorFactory {
    private final ModelConsumerLoader consumerLoader;

    @Autowired(required = false)
    public CommandDisruptorFactory(ModelConsumerLoader consumerLoader) {
	this(consumerLoader, new DisruptorParams());
    }

    @Autowired(required = false)
    public CommandDisruptorFactory(ModelConsumerLoader consumerLoader,
	    DisruptorParams disruptorParams) {
	super(disruptorParams);
	this.consumerLoader = consumerLoader;
    }

    @Override
    protected Disruptor<DisruptorEvent> createDisruptor(String paramString) {
	return null;
    }
}

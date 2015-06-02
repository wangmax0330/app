package com.pikia.component.message.disruptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pikia.component.message.disruptor.consumer.ConsumerLoader;

@Component
public class DisruptorFactory {
    private final ConsumerLoader consumerLoader;

    // required false : spring找不到的话会赋空值进去s
    @Autowired(required = false)
    public DisruptorFactory(ConsumerLoader consumerLoader) {
	//this(consumerLoader, new DisruptorParams());
	this.consumerLoader=consumerLoader;
    }

    public boolean containsTopic(String topic) {
	if (this.consumerLoader.getHandlerConsumers().containsKey(topic)) {
	    return true;
	}
	if (this.consumerLoader.getConsumerMethods().containsKey(topic)) {
	    return true;
	}
	if (this.consumerLoader.getBeanFactory().containsBean(topic)) {
	    return true;
	}
	return false;
    }
}

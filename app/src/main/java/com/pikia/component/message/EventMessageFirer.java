package com.pikia.component.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.pikia.component.message.disruptor.CommandDisruptorFactory;
import com.pikia.component.message.disruptor.DisruptorEvent;
import com.pikia.component.message.disruptor.DisruptorFactory;
import com.pikia.component.message.disruptor.DisruptorResultEvent;
import com.pikia.component.message.future.FutureFirer;

@Component
public class EventMessageFirer implements BeanFactoryAware {
    protected final Log logger = LogFactory.getLog(getClass());
    protected final DisruptorFactory disruptorFactory;
    protected final CommandDisruptorFactory commandDisruptorFactory;
    protected final FutureFirer futureFirer;
    protected BeanFactory beanFactory;

    @Autowired
    public EventMessageFirer(DisruptorFactory disruptorFactory,
	    CommandDisruptorFactory commandDisruptorFactory, FutureFirer futureFirer) {
	this.disruptorFactory = disruptorFactory;
	this.commandDisruptorFactory = commandDisruptorFactory;
	this.futureFirer = futureFirer;
    }

    public void fireDisruptorEvent(String topic, DomainMessage domainMessage) {
	if (this.disruptorFactory.containsTopic(topic)) {
	    throw new IllegalArgumentException("Topic [" + topic
		    + "] not found in disruptor factory [" + this.disruptorFactory
		    + "], check topic name and message type");
	}
	doFireDisruptorEvent(topic, this.disruptorFactory.getDisruptor(topic), domainMessage);
    }

    protected void doFireDisruptorEvent(String topic, Disruptor<DisruptorEvent> disruptor,
	    DomainMessage domainMessage) {
	long waitForTimeOut = domainMessage.getWaitForTimeOut();
	if (waitForTimeOut <= 0L) {
	    waitForTimeOut = 10000L;
	}
	// ?????
	domainMessage.setResultEvent(new DisruptorResultEvent(this.disruptorFactory
		.getDisruptorParams().getOutputRingBufferSize(), waitForTimeOut));
	RingBuffer ringBuffer = disruptor.getRingBuffer();
	long sequence = ringBuffer.next();
	DisruptorEvent disruptorEvent = (DisruptorEvent) ringBuffer.get(sequence);
	disruptorEvent.setTopic(topic);
	disruptorEvent.setDomainMessage(domainMessage);
	// 发布事件
	ringBuffer.publish(sequence);
    }

    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
	this.beanFactory = beanFactory;
    }

}

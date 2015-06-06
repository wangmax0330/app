package com.pikia.component.message.disruptor;

import com.lmax.disruptor.EventFactory;

//定义ValueEvent类，该类作为填充RingBuffer的消息体，生产者向该消息体中填充数据，消费者从消息体中获取数据：
public final class ValueEvent {
    private Object value;
    public static final EventFactory<ValueEvent> EVENT_FACTORY = new EventFactory() {
	public ValueEvent newInstance() {
	    return new ValueEvent();
	}
    };

    public Object getValue() {
	return this.value;
    }

    public void setValue(Object value) {
	this.value = value;
    }
}

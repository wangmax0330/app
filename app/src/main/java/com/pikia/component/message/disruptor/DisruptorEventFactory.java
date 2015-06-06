package com.pikia.component.message.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * EventFactory
 * 
 * @author methew
 * 
 */
public class DisruptorEventFactory implements EventFactory<DisruptorEvent> {
    @Override
    public DisruptorEvent newInstance() {
	return new DisruptorEvent();
    }
}

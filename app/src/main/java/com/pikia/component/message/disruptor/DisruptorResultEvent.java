package com.pikia.component.message.disruptor;

import java.util.concurrent.TimeUnit;

import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.TimeoutBlockingWaitStrategy;

public class DisruptorResultEvent implements com.pikia.component.message.ResultEvent {

    protected ValueEventProcessor valueEventProcessor;

    public DisruptorResultEvent(int ringBufferSize, long waitForTimeOut) {

	RingBuffer ringBuffer = RingBuffer.createSingleProducer(ValueEvent.EVENT_FACTORY,
		ringBufferSize, new TimeoutBlockingWaitStrategy(waitForTimeOut,
			TimeUnit.MILLISECONDS));
	this.valueEventProcessor = new ValueEventProcessor(ringBuffer);

    }

    @Override
    public Object get() {
	return null;
    }

    @Override
    public void send(Object paramObject) {

    }

}

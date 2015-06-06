package com.pikia.component.message.disruptor;

import com.lmax.disruptor.RingBuffer;

public class ValueEventProcessor {
    protected final RingBuffer<ValueEvent> ringBuffer;
    // 可以把ringBugger看做是一个队列,那么next就是得到下面一个事件槽
    private long waitAtSequence = 0L;

    public ValueEventProcessor(RingBuffer<ValueEvent> ringBuffer) {
	this.ringBuffer = ringBuffer;
    }

    public void send(Object result) {
	this.waitAtSequence = this.ringBuffer.next();
	ValueEvent ve = (ValueEvent) this.ringBuffer.get(this.waitAtSequence);
	ve.setValue(result);
	// 发布事件
	this.ringBuffer.publish(this.waitAtSequence);
    }

    public long getWaitAtSequence() {
	return this.waitAtSequence;
    }

    public void setWaitAtSequence(long waitAtSequence) {
	this.waitAtSequence = waitAtSequence;
    }

    public RingBuffer<ValueEvent> getRingBuffer() {
	return this.ringBuffer;
    }
}

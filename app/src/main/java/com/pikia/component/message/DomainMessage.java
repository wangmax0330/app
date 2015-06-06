package com.pikia.component.message;

import org.springframework.util.Assert;

public class DomainMessage {
    public static final long DEFAULT_WAIT_FOR_TIMEOUT = 10000L;
    protected Object eventSource;
    protected volatile ResultEvent resultEvent;
    private long waitForTimeOut = 10000L;

    public DomainMessage(Object eventSource) {
	this.eventSource = eventSource;
    }

    public DomainMessage(Object eventSource, long waitForTimeOut) {
	this(eventSource);
    }

    public long getWaitForTimeOut() {
	return this.waitForTimeOut;
    }

    public void setWaitForTimeOut(long waitForTimeOut) {
	this.waitForTimeOut = waitForTimeOut;
    }

    public Object getEventSource() {
	return this.eventSource;
    }

    public void setEventSource(Object eventSource) {
	this.eventSource = eventSource;
    }

    public void setResultEvent(ResultEvent resultEvent) {
	this.resultEvent = resultEvent;
    }

    public ResultEvent getResultEvent() {
	return this.resultEvent;
    }

    public Object getEventResult() {
	Assert.notNull(this.resultEvent, "resultEvent has not been set");
	return this.resultEvent.get();
    }

    public void setEventResult(Object eventResult) {
	Assert.notNull(this.resultEvent, "resultEvent has not been set");
	this.resultEvent.send(eventResult);
    }
}

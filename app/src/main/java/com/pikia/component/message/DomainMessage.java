package com.pikia.component.message;

import org.springframework.util.Assert;

//消息实体,在消息的发布者与接受者之间传递输
//入参数和结果,发送者通过 DomainMessage 的 eventSource 属性来设置事
//件源对象,产生一个消息可以直接使用构造函数
public class DomainMessage {
    public static final long DEFAULT_WAIT_FOR_TIMEOUT = 10000L;
    protected Object eventSource;
    protected volatile ResultEvent resultEvent;// 消息处理完后,发送者可以通过
					       // DomainMessage.getEventResult()获取到接收者的处理结果
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

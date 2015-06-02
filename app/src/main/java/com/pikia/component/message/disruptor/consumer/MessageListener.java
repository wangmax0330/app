package com.pikia.component.message.disruptor.consumer;

import com.pikia.component.message.DomainMessage;

public abstract interface MessageListener {
    public abstract void action(DomainMessage paramDomainMessage) throws Exception;
}

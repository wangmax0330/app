package com.pikia.component.message.disruptor;


import com.pikia.component.message.DomainMessage;

public class DisruptorEvent
{
  protected String topic;
  protected DomainMessage domainMessage;

  public String getTopic()
  {
    return this.topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public DomainMessage getDomainMessage() {
    return this.domainMessage;
  }

  public void setDomainMessage(DomainMessage domainMessage) {
    this.domainMessage = domainMessage;
  }

  protected void clear()
  {
    this.domainMessage = null;
  }

  public String toString()
  {
    return "DisruptorEvent [topic = " + this.topic + "; domainMessage = " + this.domainMessage + ']';
  }
}



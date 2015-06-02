package com.pikia.component.message;

import com.pikia.component.message.disruptor.DisruptorEvent;
/**
 * 定义消息时间处理者,具体的处理由集成类实现
 * @author methew
 *
 */
public abstract interface DomainEventHandler {
	public abstract void onEvent(DisruptorEvent paramDisruptorEvent,boolean paramBoolean) throws Exception;
}

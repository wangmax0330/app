package com.pikia.component.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pikia.component.message.disruptor.CommandDisruptorFactory;
import com.pikia.component.message.disruptor.DisruptorFactory;
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
			CommandDisruptorFactory commandDisruptorFactory,
			FutureFirer futureFirer) {
		this.disruptorFactory = disruptorFactory;
		this.commandDisruptorFactory = commandDisruptorFactory;
		this.futureFirer = futureFirer;
	}

	public void fireDisruptorEvent(String topic, DomainMessage domainMessage) {
		//if(this.disruptorFactory.co)
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {

	}

}

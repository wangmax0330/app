package com.pikia.component.message.disruptor.consumer;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import com.pikia.component.annotation.Consumer;
import com.pikia.component.annotation.OnEvent;
import com.pikia.component.message.DomainEventHandler;
import com.pikia.component.message.DomainMessage;

/**
 * 用BeanFactoryAware接口,用BEAN的名称来获取Bean对象
 * 
 * @author methew
 * 
 */
public class ConsumerLoader implements BeanFactoryAware, InitializingBean, DisposableBean {
    protected final Log logger = LogFactory.getLog(getClass());
    protected final Map<String, Collection<String>> handlerConsumers = new HashMap();
    protected final Map<String, Collection<ConsumerMethodHolder>> consumerMethods = new HashMap();

    // 可配置,BeanFactory的扩配置功能,提供了访问和修改BeanDefinition，预实例化singletons。
    protected ConfigurableListableBeanFactory beanFactory;

    @Override
    public void destroy() throws Exception {
	this.handlerConsumers.clear();
	this.consumerMethods.clear();
    }

    public BeanFactory getBeanFactory() {
	return this.beanFactory;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
	loadEventHandlerAndOnEventConsumers();
    }

    @Override
    public void setBeanFactory(BeanFactory arg0) throws BeansException {
	if ((beanFactory instanceof ConfigurableListableBeanFactory)) {
	    this.beanFactory = ((ConfigurableListableBeanFactory) beanFactory);
	} else {
	    throw new IllegalArgumentException("The given bean factory [" + beanFactory
		    + "] must be a ConfigurableListableBeanFactory instance");
	}

    }

    /**
     * 载入消息事件发送和处理类
     * 
     * @throws Exception
     */
    protected void loadEventHandlerAndOnEventConsumers() throws Exception {
	// 活取所有定义的Bean
	String[] beanDefinitaionNames = this.beanFactory.getBeanDefinitionNames();
	for (String beanDefinationName : beanDefinitaionNames) {
	    logger.error("----------------------loadEventHandlerAndOnEventConsumers   "
		    + beanDefinationName);
	    BeanDefinition beanDefinition = this.beanFactory.getBeanDefinition(beanDefinationName);
	    String beanClassName = beanDefinition.getBeanClassName();
	    // 使用默认的classloader来获取
	    Class beanClass = ClassUtils.forName(beanClassName, ClassUtils.getDefaultClassLoader());

	    /**
	     * 把加了consmer注解的class 加入到map容器中
	     */
	    if (beanClass.isAnnotationPresent(Consumer.class)) {
		// Class.isAssignableFrom()是用来判断一个类Class1和另一个类Class2是否相同或是另一个类的子类或接口。
		// 而instanceof是用来判断一个对象实例是否是一个类或接口的或其子类子接口的实例。
		if (!DomainEventHandler.class.isAssignableFrom(beanClass)) {
		    throw new IllegalStateException("Bean class [" + beanClass.getName()
			    + "] annotated with @Consumer must implement "
			    + DomainEventHandler.class);
		}
		Consumer consumer = (Consumer) beanClass.getAnnotation(Consumer.class);
		String topicName = StringUtils.hasText(consumer.value()) ? consumer.value()
			: beanDefinationName;
		if (this.logger.isDebugEnabled()) {
		    this.logger.debug("Found event handler [" + beanClass.getName()
			    + "] for topic [" + topicName + "]");
		}
		Collection consumers = (Collection) this.handlerConsumers.get(topicName);
		if (consumers == null) {
		    consumers = new LinkedList();
		    this.handlerConsumers.put(topicName, consumers);
		}
		consumers.add(beanDefinationName);
	    }
	    /**
	     * 把这个class中加了OnEvent注解的方法加入到map容器中
	     */
	    for (Method method : ReflectionUtils.getAllDeclaredMethods(beanClass)) {
		if (method.isAnnotationPresent(OnEvent.class)) {
		    OnEvent onEvent = (OnEvent) method.getAnnotation(OnEvent.class);
		    String topicName = onEvent.value();
		    if (this.logger.isDebugEnabled()) {
			this.logger.debug("Found consumer method [" + beanClass.getName() + "."
				+ method.getName() + "] for topic [" + topicName + "]");
		    }
		    Collection methods = (Collection) this.consumerMethods.get(topicName);
		    if (methods == null) {
			methods = new LinkedList();
			this.consumerMethods.put(topicName, methods);
		    }
		    methods.add(new ConsumerMethodHolder(beanDefinationName, method));
		}
	    }
	    /**
	     * 继承MessageListener,重载action方法实现消息接受
	     */
	    if (MessageListener.class.isAssignableFrom(beanClass)) {
		Method method = beanClass.getMethod("action", new Class[] { DomainMessage.class });
		String topicName = beanDefinationName;
		if (this.logger.isDebugEnabled()) {
		    this.logger.debug("Found message listener [" + beanClass.getName()
			    + "] for topic [" + topicName + "]");
		}
		Collection methods = (Collection) this.consumerMethods.get(topicName);
		if (methods == null) {
		    methods = new LinkedList();
		    this.consumerMethods.put(topicName, methods);
		}
		methods.add(new ConsumerMethodHolder(beanDefinationName, method));
	    }

	}
    }

    public Map<String, Collection<String>> getHandlerConsumers() {
	return this.handlerConsumers;
    }

    public Map<String, Collection<ConsumerMethodHolder>> getConsumerMethods() {
	return this.consumerMethods;
    }
}

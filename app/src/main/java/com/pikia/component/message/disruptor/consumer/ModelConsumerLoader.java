package com.pikia.component.message.disruptor.consumer;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import com.pikia.component.annotation.OnCommand;
import com.pikia.component.model.ModelUtils;

@Component
public class ModelConsumerLoader implements DisposableBean {
    private static final Log logger = LogFactory.getLog(ModelConsumerLoader.class);

    private static final Map<String, ConsumerMethodHolder> consumerMethods = new HashMap();

    public static void loadModelConsumers(Class<?> beanClass) {
	if (ModelUtils.isModel(beanClass)) {
	    for (Method method : ReflectionUtils.getAllDeclaredMethods(beanClass))
		if (method.isAnnotationPresent(OnCommand.class)) {
		    // ----------------------onCommand 暂时没写,不知道具体功能
		}
	}
    }

    @Override
    public void destroy() throws Exception {
	consumerMethods.clear();
    }

    public Map<String, ConsumerMethodHolder> getModelConsumerMethods() {
	return consumerMethods;
    }
}

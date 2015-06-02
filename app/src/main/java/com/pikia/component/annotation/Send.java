package com.pikia.component.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 消息发送者注解
 * 
 * @author methew
 * 
 */
@Target({ java.lang.annotation.ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Send {
	public abstract String value();

	public abstract String action();

	public abstract boolean asyn();

	public abstract MessageType type();
}

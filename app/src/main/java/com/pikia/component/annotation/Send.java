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
    public abstract String value(); // 主题名,产生的事件名称

    public abstract String action();// action 属性只能在 future 模式下使用,表示所调用接受者的方法

    public abstract boolean asyn();// asyn 属性是一个同步异步开关,只能在 future 模式下 使用

    public abstract MessageType type();// type 属性是消息模式选择,目前只可以设置 disruptor 和
				       // future 两个值, 默认为 disruptor。
}

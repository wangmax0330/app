package com.pikia.component.message.disruptor;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lmax.disruptor.ExceptionHandler;

public final class SimpleExceptionHandler implements ExceptionHandler {
    public static final SimpleExceptionHandler INSTANCE = new SimpleExceptionHandler();

    private final Log logger = LogFactory.getLog(getClass());

    public void handleEventException(Throwable ex, long sequence, Object event) {
	if (this.logger.isErrorEnabled())
	    this.logger.error("Exception processing: " + sequence + " " + event, ex);
    }

    public void handleOnStartException(Throwable ex) {
	if (this.logger.isErrorEnabled()) this.logger.error("Exception during onStart()", ex);
    }

    public void handleOnShutdownException(Throwable ex) {
	if (this.logger.isErrorEnabled()) this.logger.error("Exception during onShutdown()", ex);
    }
}

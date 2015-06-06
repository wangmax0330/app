package com.pikia.component.message.disruptor;

import com.lmax.disruptor.ExceptionHandler;

/**
 * Disruptor 中ringBuffe的一些配置,归并到Spring 统一异常处理
 * 
 * @author methew
 * 
 */
public class DisruptorParams {
    private int inputRingBufferSize = 1024;
    private int outputRingBufferSize = 1;
    private long inputDisruptorRefreshCycle = 86400L;
    private ExceptionHandler exceptionHandler;

    public DisruptorParams() {
    }

    public DisruptorParams(int inputRingBufferSize) {
	this.inputRingBufferSize = inputRingBufferSize;
    }

    public int getInputRingBufferSize() {
	return this.inputRingBufferSize;
    }

    public void setInputRingBufferSize(int inputRingBufferSize) {
	this.inputRingBufferSize = inputRingBufferSize;
    }

    public int getOutputRingBufferSize() {
	return this.outputRingBufferSize;
    }

    public void setOutputRingBufferSize(int outputRingBufferSize) {
	this.outputRingBufferSize = outputRingBufferSize;
    }

    public long getInputDisruptorRefreshCycle() {
	return this.inputDisruptorRefreshCycle;
    }

    public void setInputDisruptorRefreshCycle(long inputDisruptorRefreshCycle) {
	this.inputDisruptorRefreshCycle = inputDisruptorRefreshCycle;
    }

    public ExceptionHandler getExceptionHandler() {
	return this.exceptionHandler != null ? this.exceptionHandler
		: SimpleExceptionHandler.INSTANCE;
    }

    public void setExceptionHandler(ExceptionHandler exceptionHandler) {
	this.exceptionHandler = exceptionHandler;
    }
}

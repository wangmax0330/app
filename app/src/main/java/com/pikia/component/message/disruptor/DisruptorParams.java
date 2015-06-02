package com.pikia.component.message.disruptor;

import com.lmax.disruptor.ExceptionHandler;

public class DisruptorParams {
    private int inputRingBUfferSize = 1024;
    private int outputRingBufferSize = 1;
    private long inputDisruptorRefreshCycle = 86400L;
    private ExceptionHandler exceptionHandler;

    public DisruptorParams() {
    }
}

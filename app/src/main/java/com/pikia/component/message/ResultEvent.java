package com.pikia.component.message;

public abstract interface ResultEvent {
    public abstract Object get();

    public abstract void send(Object paramObject);
}
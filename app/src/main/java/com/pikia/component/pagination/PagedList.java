package com.pikia.component.pagination;

import java.io.Serializable;
import java.util.List;

public abstract interface PagedList<T> extends Serializable {

    public abstract List<T> getItems(); // 父类活取item,子类MutablePagedList给item设置具体值

    public abstract int getTotalPageCount();

    public abstract int getTotalItemCount();

    public abstract int getCurrentPageIndex();

    public abstract int getPageSize();

    public abstract int getNextPageIndex();

    public abstract int getPreviousPageIndex();
}
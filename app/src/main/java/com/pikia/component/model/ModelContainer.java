package com.pikia.component.model;

import java.util.List;

import com.pikia.component.pagination.SortPagedList;

public abstract interface ModelContainer {

	public abstract void identifiersToModels(
			SortPagedList<Object> paramMutablePagedList, Class<?> paramClass,
			ModelLoader paramModelLoader);

	public abstract <T> List<T> identifiersToModels(
			List<? extends Object> paramList, Class<T> paramClass,
			ModelLoader paramModelLoader);
}

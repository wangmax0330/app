package com.pikia.component.model;

import com.pikia.component.annotation.Model;

public class ModelUtils {
    public static boolean isModel(Object model) {
	if (model == null) {
	    return false;
	}
	return isModel(model.getClass());
    }

    public static boolean isModel(Class<?> clazz) {
	if (clazz.isAnnotationPresent(Model.class)) {
	    return true;
	}
	return false;
    }

    public static boolean isModified(Object model) {
	if (model == null) {
	    return false;
	}
	if ((Modifiable.class.isAssignableFrom(model.getClass()))
		&& (((Modifiable) model).isModified())) {
	    return true;
	}

	return false;
    }
}

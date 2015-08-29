package com.pikia.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class CmsDiaryController {
    /**
     * 统一处理所有的异常,发生异常都会拦截到这个方法进行处理
     * 
     * @param runtimeException
     * @param modelMap
     * @return
     */
    // @ExceptionHandler(RuntimeException.class)
    // public String runtimeExceptionHandler(RuntimeException runtimeException,
    // ModelMap modelMap) {
    // logger.error(runtimeException.getLocalizedMessage());
    // modelMap.put("status", IntegralConstant.FAIL_STATUS);
    // return "exception";
    // }

    // @ExceptionHandler(RuntimeException.class)
    // public @ResponseBody
    // Map<String,Object> runtimeExceptionHandler(RuntimeException
    // runtimeException) {
    // logger.error(runtimeException.getLocalizedMessage());
    //
    // Map model = new TreeMap();
    // model.put("status", false);
    // return model;
    // }
}

package com.pikia;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    protected final Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping(value = "/user/index", method = { RequestMethod.POST, RequestMethod.GET })
    public String userIndexPage(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	return "/user/index";
    }

    @RequestMapping(value = "/admin/index", method = { RequestMethod.POST, RequestMethod.GET })
    public String adminIndexPage(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	return "/admin/index";
    }

    @RequestMapping(value = "/task/index", method = { RequestMethod.POST, RequestMethod.GET })
    public String taskIndexPage(HttpServletRequest request, HttpServletResponse response) {
	return "/task/index";
    }

    @RequestMapping(value = "/schedule/index", method = { RequestMethod.POST, RequestMethod.GET })
    public String scheduleIndexPage(HttpServletRequest request, HttpServletResponse response) {
	return "/schedule/index";
    }

    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
    public String userLoginPagex(HttpServletRequest request, HttpServletResponse response)
	    throws Exception {
	return "/login";
    }
}

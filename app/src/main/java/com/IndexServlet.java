package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			// response.sendRedirect(new Oauth().getAuthorizeURL(request));
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<HTML>");
			out.println("<BODY>");
			out.println("这是Servlet的例子");
			out.println("</BODY>");
			out.println("</HTML>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		doGet(request, response);
	}
}
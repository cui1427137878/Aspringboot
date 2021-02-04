package com.tedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:${NAME}
 * Package:${PACKAGE_NAME}
 * Description:
 *
 *
 * Author:崔建新
 */
@WebServlet(name = "OneServlet")
public class OneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.getWriter().write("hello maven");
        response.getWriter().write("hello maven12345");
    }
}

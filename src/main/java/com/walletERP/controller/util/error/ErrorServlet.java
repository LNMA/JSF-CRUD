package com.walletERP.controller.util.error;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class ErrorServlet extends HttpServlet implements Serializable {


    private static final long serialVersionUID = 5612138839830244177L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Throwable  throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        String exceptionMessage = (String) request.getAttribute("javax.servlet.error.message");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");

        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");

        if (requestUri == null) {
            requestUri = "Unknown";
        }

        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1,maximum-scale=1.0, user-scalable=0, shrink-to-fit=no\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"/>\n"+
                "    <meta name=\"apple-mobile-web-app-capable\" content=\"yes\"/>\n"+
                "    <style>\n" +
                "        @import url(" + request.getContextPath() + "/libr/bootstrap-4.4.1/css/bootstrap.min.css);\n" +
                "    </style>\n" +
                "    <script src=\"" + request.getContextPath() + "/libr/jQuery-3.4.1/jquery.min.js\"></script>\n" +
                "    <script src=\"" + request.getContextPath() + "/libr/popper-1.16/popper.js\"></script>\n" +
                "    <script src=\"" + request.getContextPath() + "/bootstrap-4.4.1/js/bootstrap.bundle.min.js\"></script>\n" +
                "    <title>Error! `by Louay Amr`</title>\n" +
                "</head>\n" +
                "<body class=\"container-fluid\">\n" +
                "  <div class=\"row\">"+
                "<div class=\"col-md-4 col-sm-4\">\n" +
                "    <img src=\"" + request.getContextPath() + "/util/img/broken_robot.png\" height=\"420\" width=\"420\" style=\"margin-top: 27%\">\n" +
                "</div>\n" +
                "<div class=\"col-md-8 col-sm-8\" style=\"margin-top: 10%;\">\n" +
                "    <p class=\"font-weight-bold text-left text-warning h2\">Wallet-ERP Task</p>\n" +
                "    <p class=\"font-weight-bold h5\">Sorry but Exception is occurred!</p>\n" +
                "<p class=\"font-weight-bolder h5 mt-3\">"+statusCode+"</p>"+
                "    <p class=\"mt-4\">\n" +
                "        <label class=\"font-weight-bold\">" +throwable.getClass().getName() + "<label class=\"text-muted\">. That's an error.</label></label>" +
                "    </p>\n" +
                "    <p class=\"mt-5\">\n" +
                "        <label class=\"font-weight-bold \"> URI: " + requestUri + ", Servlet Name: " + servletName + ", Message: " + exceptionMessage +"<label class=\"text-muted\">. That's all we know.</label></label>" +
                "    </p>\n" +
                "</div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Error Occurred!";
    }
}

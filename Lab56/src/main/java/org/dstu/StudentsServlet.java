package org.dstu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String[] lastNames = req.getParameterValues("lastName");
        if (!lastNames[0].equals("Скворцова")) {
            req.getRequestDispatcher("notfound.jsp").forward(req, resp);
        }
    }
}

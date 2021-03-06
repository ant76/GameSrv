package ru.trusov.frontend;

import ru.trusov.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Frontend extends HttpServlet {
    private String login = "";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login == null? "" : login);

        resp.getWriter().println(PageGenerator.getPage("auth_form.html", pageVariables));
        resp.setContentType("text/html;charset=utf8");
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login = req.getParameter("login");

        resp.setContentType("text/html;charset=utf8");
        if (login == null || login.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            resp.setStatus(HttpServletResponse.SC_OK);
        }

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("lastLogin", login == null ? "" : login );
        resp.getWriter().println(PageGenerator.getPage("auth_form.html", pageVariables));

    }
}

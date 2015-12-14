package frontend;

import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by user on 14.12.2015.
 */
public class Mirror extends HttpServlet {
    private String key = "";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        key = req.getParameter("key");

        resp.setContentType("text/html;charset=utf8");
        if (key == null || key.isEmpty()) {
            resp.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            resp.setStatus(HttpServletResponse.SC_OK);
        }

        Map<String, Object> pageVariables = new HashMap<>();
        pageVariables.put("key", key == null ? "" : key );
        resp.getWriter().println(PageGenerator.getPage("mirror.html", pageVariables));
    }
}
package ru.trusov.main;

import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import ru.trusov.frontend.Frontend;
import ru.trusov.frontend.Mirror;


public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
//        Logger logger = LoggerFactory.getLogger(ru.trusov.main.Main.class);

    public static void main(String[] args) throws Exception {

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new Frontend()), "/auth_form");
        context.addServlet(new ServletHolder(new Mirror()), "/mirror");
//        context.addServlet(new ServletHolder(servlet), "/");

        Server server = new Server(8080);
        server.setHandler(context);


        server.start();
        logger.info("Server started");
        logger.trace("Hello World");
        logger.debug("Hello World");
        logger.info("Hello World");
        logger.warn("Hello World");
        logger.error("Hello World");

        server.join();
    }
}

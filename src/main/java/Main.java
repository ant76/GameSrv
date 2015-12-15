import frontend.Frontend;
import frontend.Mirror;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        Logger logger = LoggerFactory.getLogger(Main.class);
        logger.info("Hello World");

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new Frontend()), "/auth_form");
        context.addServlet(new ServletHolder(new Mirror()), "/mirror");
//        context.addServlet(new ServletHolder(servlet), "/");

        Server server = new Server(8080);
        server.setHandler(context);


        server.start();
        logger.info("Server started");
//        logger.trace("Hello World");
//        logger.debug("Hello World");
//        logger.info("Hello World");
//        logger.warn("Hello World");
//       logger.error("Hello World");

        server.join();
    }
}

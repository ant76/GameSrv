import frontend.Frontend;
import frontend.Mirror;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);

        context.addServlet(new ServletHolder(new Frontend()), "/auth_form");
        context.addServlet(new ServletHolder(new Mirror()), "/mirror");
//        context.addServlet(new ServletHolder(servlet), "/");

        Server server = new Server(8080);
        server.setHandler(context);

        server.start();
        server.join();
    }
}

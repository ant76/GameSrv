import org.eclipse.jetty.server.Server;

/**
 * Created by user on 13.12.15.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Frontend frontend = new Frontend();

        Server server = new Server(8080);
        ServletContextHandler context =
                new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(context);

        context.addServlet(new ServletHolder(frontend), '/authform');

        server.start();

        server.join();
    }
}

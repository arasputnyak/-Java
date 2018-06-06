import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
        DBService dbService = new DBService();
        AccountService accountService = new AccountService(dbService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new SignInServlet(accountService)), "/signin");
        context.addServlet(new ServletHolder(new SignUpServlet(accountService)), "/signup");

        //ResourceHandler resource_handler = new ResourceHandler();
        //resource_handler.setResourceBase("html_ki");

        //HandlerList handlers = new HandlerList();
        //handlers.setHandlers(new Handler[]{resource_handler, context});

        Server server = new Server(8080);
        //server.setHandler(handlers);
        server.setHandler(context);

        server.start();
        System.out.println("Server started");
        server.join();
    }
}
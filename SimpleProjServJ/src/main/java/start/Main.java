package start;

import account.AccountService;
import database.DBService;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servletiki.InputServlet;
import servletiki.OutputServlet;

public class Main {
    public static void main(String[] args) throws Exception {
        AccountService accountService = new AccountService(new DBService());
        Server server = new Server(8080);
        InputServlet servlet1 = new InputServlet(accountService);
        OutputServlet servlet2 = new OutputServlet(accountService);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(servlet1), "/add");
        context.addServlet(new ServletHolder(servlet2), "/info");

        ResourceHandler resource_handler = new ResourceHandler();
        resource_handler.setResourceBase("html_ki");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resource_handler, context});
        server.setHandler(handlers);

        server.start();
        System.out.println("server started");
        server.join();
    }

}

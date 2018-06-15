package start;

import accserver.AccountServer;
import accserver.AccountController;
import accserver.AccountControllerMBean;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servletik.MyServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        AccountServer accountServer = new AccountServer();
        Server server = new Server(8080);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        contextHandler.addServlet(new ServletHolder(new MyServlet(accountServer)), "/admin");

        AccountControllerMBean serverStatics = new AccountController(accountServer);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=AccountController.usersLimit");
        mbs.registerMBean(serverStatics, name);

        server.setHandler(contextHandler);

        server.start();
        System.out.println("Server started");
        logger.info("Server started at localhost: 8080");
        server.join();
    }
}

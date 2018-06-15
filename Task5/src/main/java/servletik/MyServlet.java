package servletik;

import accserver.AccountServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    private final AccountServer accountServer;
    static final Logger logger = LogManager.getLogger(MyServlet.class.getName());

    public MyServlet(AccountServer accountServer) {
        this.accountServer = accountServer;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int usLim = accountServer.getUsersLimit();
        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(Integer.toString(usLim));
        resp.setStatus(HttpServletResponse.SC_OK);
        logger.info("UsersLimit set at: " + usLim);
    }
}

package servletiki;

import account.AccountService;
import account.MyUser;
import database.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OutputServlet extends HttpServlet {
    private final AccountService accountService;

    public OutputServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");

        resp.setContentType("text/html;charset=utf-8");

        if (name == null) {
            resp.getWriter().println("no name was given");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        try {
            MyUser myUser = accountService.getUserByName(name);

            if (myUser == null) {
                resp.getWriter().println("no such profile");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }

            resp.getWriter().println(myUser.getAge() + ", " + myUser.getHomeTown());
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }
}

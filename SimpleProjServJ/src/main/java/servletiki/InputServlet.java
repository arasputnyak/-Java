package servletiki;


import account.AccountService;
import account.MyUser;
import database.DBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InputServlet extends HttpServlet {
    private final AccountService accountService;

    public InputServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String strAge = req.getParameter("age");
        String homeTown = req.getParameter("hometown");

        resp.setContentType("text/html;charset=utf-8");

        if (name == null || strAge == null || homeTown == null) {
            resp.getWriter().println("you`ve missed some parameters");
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int age = Integer.parseInt(strAge);
        try {
            accountService.addNewUser(name, age, homeTown);
            resp.getWriter().println("you got it");
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (DBException e) {
            e.printStackTrace();
        }

    }
}

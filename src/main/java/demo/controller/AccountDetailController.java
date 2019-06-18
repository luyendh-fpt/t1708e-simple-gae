package demo.controller;

import demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class AccountDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Account account = ofy().load().type(Account.class).id(id).now();
        if(account == null){
            resp.sendError(404);
            return;
        }
        req.setAttribute("account", account);
        req.getRequestDispatcher("/account/detail.jsp").forward(req, resp);
    }
}

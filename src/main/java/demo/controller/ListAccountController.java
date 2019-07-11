package demo.controller;

import com.googlecode.objectify.cmd.Query;
import demo.entity.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class ListAccountController extends HttpServlet {

    private static final int DEFAULT_PAGE = 1;
    private static final int DEFAULT_LIMIT = 10;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = DEFAULT_PAGE;
        int limit = DEFAULT_LIMIT;
        try {
            page = Integer.parseInt(req.getParameter("page"));
        } catch (Exception ex) {
        }
        try {
            limit = Integer.parseInt(req.getParameter("limit"));
        } catch (Exception ex) {

        }
        Query<Account> accountQuery = ofy().load().type(Account.class);

        String email = req.getParameter("email");
        if (email != null && !email.isEmpty()) {
            accountQuery = accountQuery.filter("email", email);
            req.setAttribute("email", email);
        }
        int totalPages = (int) Math.ceil(accountQuery.count()/ (double) limit);
        accountQuery = accountQuery.limit(limit).offset((page - 1) * limit);
        req.setAttribute("currentPage", page);
        req.setAttribute("limit", limit);
        req.setAttribute("list", accountQuery.list());
        req.setAttribute("totalPages", totalPages);
        req.getRequestDispatcher("/account/list.jsp").forward(req, resp);
    }
}

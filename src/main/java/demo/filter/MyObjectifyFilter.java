package demo.filter;

import com.googlecode.objectify.ObjectifyService;
import demo.entity.Account;

import javax.servlet.*;
import java.io.IOException;


public class MyObjectifyFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        ObjectifyService.register(Account.class);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}

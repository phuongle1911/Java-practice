package article_web.Controller;

import java.io.IOException;

import article_web.Model.UserDao;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter (urlPatterns={"/api/*"})
public class AuthenFilter implements Filter{
  @Override 
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpReq = (HttpServletRequest) req;
    HttpServletResponse httpRes = (HttpServletResponse) res;

    String token = null;
    Cookie[] cookies = httpReq.getCookies();

    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("jwt".equals(cookie.getName())) {
          token = cookie.getValue();
          break;
        }
      }
    }

    if (token != null) {
      try {
        UserDao userDao = new UserDao();
        String username = userDao.validateJwt(token);

        if (username != null) {
          httpReq.setAttribute("username", username);
          chain.doFilter(req,res);
          return;
        }

      } catch (Exception e) {
        System.out.println("token invalid or expired" + e);
      }
    }
    chain.doFilter(req,res);
    

  }
}

package article_web.Controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/logout")
public class LogoutController extends HttpServlet {
  @Override 
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    Cookie[] cookies = req.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if ("jwt".equals(cookie.getName())) {
          cookie.setValue("");
          cookie.setMaxAge(0);
          cookie.setPath("/");
          res.addCookie(cookie);
          res.sendRedirect("/api/home");
          break;
        }
      }
    }
  }
}

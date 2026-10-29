package article_web.Controller;

import java.io.IOException;

import article_web.Model.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet ("/api/login")
public class LoginController extends HttpServlet{
  private final UserDao userDao = new UserDao();
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
    try {
      int id = Integer.parseInt(req.getParameter("id"));
      String password = req.getParameter("password");
      Cookie jwtCookie = userDao.validateAuthen(id, password);

      
      if (jwtCookie != null) {
        res.addCookie(jwtCookie);
        res.sendRedirect("/api/home");
      } else {
        res.sendRedirect("/login.jsp");
      }

    } catch (Exception e) {
      System.out.println("something went wrong with login!" + e);
      res.sendRedirect("/login.jsp");

    }

  }
}

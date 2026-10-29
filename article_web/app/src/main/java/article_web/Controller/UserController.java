package article_web.Controller;

import java.io.IOException;

import article_web.Model.UserDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/users")
public class UserController extends HttpServlet {
  private final UserDao userDao = new UserDao();

  @Override 
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String username;
    int id;
    String password;
    try {
      username = req.getParameter("username");
      id = Integer.parseInt(req.getParameter("id"));
      password = req.getParameter("password");

      if (username == null || username.trim().isEmpty()) {
        req.setAttribute("errorMessage", "username cannot be empty");
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
        return;
      }

      if (password == null || password.trim().isEmpty() || password.length() <8) {
        req.setAttribute("errorMessage", "password must have minimum 8 characters!");
        req.getRequestDispatcher("/register.jsp").forward(req,resp);
        return;
      }

      int rs = userDao.create(username, id, password);

      if (rs>0) {
        resp.sendRedirect("/login.jsp");
      } else if (rs == 0) {
        resp.sendRedirect("/register.jsp");
      }

    } catch (NumberFormatException e) {
      System.out.println("id is invalid. please try again!");
    } catch(Exception e) {
      System.out.println("something went wrong with registering!" + e);
    }
  }
  
}

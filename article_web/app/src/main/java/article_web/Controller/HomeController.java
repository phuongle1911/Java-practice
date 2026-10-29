package article_web.Controller;

import java.io.IOException;
import java.sql.SQLException;

import article_web.Services.NewsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/api/*", "/api/home"})
public class HomeController extends HttpServlet {
    private final NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            req.setAttribute("categories", newsService.getHomeCategories());
        } catch (SQLException e) {
            System.out.println("Cannot load homepage" + e);
        }
        req.getRequestDispatcher("/home.jsp").forward(req, resp);
    }
}

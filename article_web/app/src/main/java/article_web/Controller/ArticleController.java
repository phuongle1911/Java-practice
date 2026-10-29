package article_web.Controller;


import java.io.IOException;
import java.sql.SQLException;

import article_web.Entity.Article;
import article_web.Services.NewsService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/api/article")
public class ArticleController extends HttpServlet {
    private final NewsService newsService = new NewsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer id = parseId(req.getParameter("id"));     
        try {
            Article article = (id == null) ? null : newsService.getArticle(id);
            if (article == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            req.setAttribute("article", article);
            req.setAttribute("category", newsService.getCategory(article.getCategoryId()));
        } catch (SQLException e) {
            throw new ServletException("Cannot load article " + id, e);
        }
        req.getRequestDispatcher("/article.jsp").forward(req, resp);
    }

    private static Integer parseId(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
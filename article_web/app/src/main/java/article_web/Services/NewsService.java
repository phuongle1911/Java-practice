package article_web.Services;

import java.sql.SQLException;
import java.util.List;

import article_web.Entity.Article;
import article_web.Entity.Category;
import article_web.Model.ArticleDao;
import article_web.Model.CategoryDao;

public class NewsService {
    private final CategoryDao categoryDao = new CategoryDao();
    private final ArticleDao articleDao = new ArticleDao();

   
    public List<Category> getHomeCategories() throws SQLException {
        List<Category> roots = categoryDao.findRoots();
        return roots;
    }

    public Category getCategory(int id) throws SQLException {
        return categoryDao.findById(id);
    }

    public List<Category> getSubCategories(int categoryId) throws SQLException {
        return categoryDao.findChildren(categoryId);
    }

    public List<Article> getArticles(int categoryId) throws SQLException {
        return articleDao.findByCategory(categoryId);
    }

    public Article getArticle(int id) throws SQLException {
        return articleDao.findById(id);
    }
}
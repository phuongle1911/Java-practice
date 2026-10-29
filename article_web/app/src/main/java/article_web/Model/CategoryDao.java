package article_web.Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import article_web.Entity.Article;
import article_web.Entity.Category;
import article_web.Utils.DbConnectionManager;

public class CategoryDao {

    
    public List<Category> findRoots() throws SQLException {
        String findCatQuery = "SELECT * FROM categories WHERE parent_id IS NULL";
        String findArticleQuery = " WITH root_categories_id AS (SELECT id FROM categories WHERE parent_id IS NULL),"

                                + " rank_articles AS (SELECT *, ROW_NUMBER() OVER (PARTITION BY category_id ORDER BY id DESC) AS row_num FROM articles"
                                + " WHERE category_id = ANY( SELECT id FROM root_categories_id))"

                                + " SELECT id, category_id, title, summary, content FROM rank_articles WHERE row_num <=3";

        List<Category> catList = new ArrayList<>();
        try (Connection c = DbConnectionManager.getConnection()) {
             PreparedStatement catPs = c.prepareStatement(findCatQuery);
             ResultSet catRs = catPs.executeQuery();
            while (catRs.next()) {
                catList.add(map(catRs));
            }
            if (catList.isEmpty()) {
                return catList;
            }
            try (PreparedStatement articlePs = c.prepareStatement(findArticleQuery);
                ResultSet articleRs = articlePs.executeQuery()) {
                ArticleDao articleDao = new ArticleDao();
                int category_id_article;
                Map<Integer,List<Article>> category_articles = new HashMap<>();
                
                for (Category category : catList) {
                    category_articles.put(category.getId(),new ArrayList<>());
                }

                while (articleRs.next()) {
                    category_id_article = articleRs.getInt("category_id");
                    List<Article> articleList = category_articles.get(articleRs.getInt("category_id"));
                    if (articleList != null) {
                        category_articles.get(category_id_article).add(articleDao.map(articleRs));
                    }
                }

                for (Category category : catList) {
                    category.setArticles(category_articles.get(category.getId()));
                }

            } catch(Exception e) {
                System.out.println("Failed to load articles of top-level categories");
            }

        } catch (SQLException e) {
        	throw new SQLException("Failed to load top-level categories", e.getSQLState(), e);
        }
        
        return catList;
    }

   
    public List<Category> findChildren(int parentId) throws SQLException {
        String sql = "SELECT id, name, parent_id FROM categories WHERE parent_id = ? ORDER BY id";
        List<Category> list = new ArrayList<>();
        try (Connection c = DbConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, parentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(map(rs));
                }
            } catch (SQLException e) {
            	throw new SQLException("Failed to load sub-level categories", e.getSQLState(), e);
            }
        }
        return list;
    }

   
    public Category findById(int id) throws SQLException {
        String sql = "SELECT id, name, parent_id FROM categories WHERE id = ?";
        try (Connection c = DbConnectionManager.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? map(rs) : null;
            }
        } catch (SQLException e) {
        	throw new SQLException("Failed to load category", e.getSQLState(), e);
        }
    }

    private Category map(ResultSet rs) throws SQLException {
        int parent = rs.getInt("parent_id");
        Integer parentId = rs.wasNull() ? null : parent;   
        return new Category(rs.getInt("id"), rs.getString("name"), parentId);
    }
}
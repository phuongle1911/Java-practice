package article_web.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import article_web.Services.PasswordService;
import article_web.Utils.DbConnectionManager;
import article_web.Utils.JwtUtils;
import jakarta.servlet.http.Cookie;



public class UserDao {
  private final PasswordService passwordService = new PasswordService();
  public int create(String username, int id, String password) throws SQLException {
    String findByIdQuery = "SELECT * FROM users WHERE id = ?";
    String query = "INSERT INTO users (username, id, password) VALUES (?,?,?)";
    
    try (Connection conn = DbConnectionManager.getConnection()){
      String password_hash = passwordService.hashPassword(password);
      PreparedStatement findStmt = conn.prepareStatement(findByIdQuery);
      findStmt.setInt(1, id);
      ResultSet findRs = findStmt.executeQuery();
      if (findRs != null) {
        System.out.println("this id already existed! Must use unique id.");
        return 0;
      }

      PreparedStatement insertStmt = conn.prepareStatement(query);

      insertStmt.setString(1, username);
      insertStmt.setInt(2, id);
      insertStmt.setString(3, password_hash);

      int rs = insertStmt.executeUpdate();
      return rs;

    } catch (Exception e) {
      System.out.println("Failed to create new users!" + e);
      return 0;
    }
  }

  public Cookie validateAuthen(int id, String passwordLogin) {
    String query = "SELECT password FROM users WHERE id = ?";
    String passwordFromDb;

    try (Connection conn = DbConnectionManager.getConnection()){
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setInt(1, id);

      ResultSet rs = stmt.executeQuery();

      if(!rs.next()) {
        System.out.println("User not found from this login!");
        return null;
      }
      
      passwordFromDb = rs.getString("password");


      if (passwordService.verifyPassword(passwordLogin,passwordFromDb)) {
        JwtUtils jwtUtils = new JwtUtils();
        String token = jwtUtils.generateJwt(id);

        Cookie jwtCookie = new Cookie("jwt", token);
        jwtCookie.setHttpOnly(true);
        jwtCookie.setSecure(false); // change to true in production
        jwtCookie.setMaxAge(3600);
        jwtCookie.setPath("/");

        return jwtCookie;
      } else {
        System.out.println("Invalid password!");
        return null;
      }
    } catch (Exception e) {
      System.out.println("Something went wrong when validate users login!" + e);
      return null;
    }
  }

  public String validateJwt(String token) {
    JwtUtils jwtUtil = new JwtUtils();
    int userId = jwtUtil.getIdFromJwt(token);
    String query = "SELECT * FROM users WHERE id = ?";
    String username;

    try (Connection conn = DbConnectionManager.getConnection()) {
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setInt(1, userId);
      ResultSet rs = stmt.executeQuery();

      if(!rs.next()) {
        System.out.println("User not found from this jwt!");
        return null;
      }

        username = rs.getString("username");
        return username;

    } catch (Exception e) {
      System.out.println("unable to validate token" + e);
      return null;
    }
  }
}

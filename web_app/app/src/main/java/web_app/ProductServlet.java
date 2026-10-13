
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/products")
public class ProductServlet extends HttpServlet{

  // Option 1 - out.println
  @Override 
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    res.setContentType("text/html");
    PrintWriter out = res.getWriter();
    String query = "SELECT * FROM products";

    out.println("<html><body>");
    out.println("<h1> Product list <h1>");
    out.println("<ul>");

    try (Connection conn = DbConnectionManager.dbConnect()) {
        
      Statement stmt = conn.createStatement();
      ResultSet result = stmt.executeQuery(query);

      while(result.next()) {
        String productName = result.getString("name");
        double price = result.getDouble("price");
        String branch = result.getString("branch");

        out.println("<li style=\"font-family: 'Arial', sans-serif; font-size: 12px;\">" + productName + ";   price: " + price + ";    branch: " + branch + "</li>");
      }
      out.println("</ul>");
      out.println("</body></html>");

      result.close();
      stmt.close();
      out.close();
    } catch (Exception e) {
      System.out.println("unable to load product list!" + e);
    }
    
  }
  
}

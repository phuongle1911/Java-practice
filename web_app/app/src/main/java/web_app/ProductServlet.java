
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/products")
public class ProductServlet extends HttpServlet{

  // Option 1 - out.println
  // @Override 
  // public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
  //   res.setContentType("text/html; charset=UTF-8");
  //   PrintWriter out = res.getWriter();
  //   String query = "SELECT * FROM products";

  //   out.println("<html><body>");
  //   out.println("<h1> Product list <h1>");
  //   out.println("<ul>");

  //   try (Connection conn = DbConnectionManager.dbConnect()) {
        
  //     Statement stmt = conn.createStatement();
  //     ResultSet result = stmt.executeQuery(query);

  //     while(result.next()) {
  //       String productName = result.getString("name");
  //       double price = result.getDouble("price");
  //       String branch = result.getString("branch");

  //       out.println("<li style=\"font-family: 'Arial', sans-serif; font-size: 12px;\">" + productName + ";   price: " + price + ";    branch: " + branch + "</li>");
  //     }
  //     out.println("</ul>");
  //     out.println("</body></html>");

  //     result.close();
  //     stmt.close();
  //     out.close();
  //   } catch (Exception e) {
  //     System.out.println("unable to load product list!" + e);
  //   }
    
  // }

  // Option 2 - using JSP for viewer, servlet for controller
  @Override 
  public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
    String query = "SELECT * FROM products";

    try (Connection conn = DbConnectionManager.dbConnect()) {
      UUID id;
      String productName;
      double price;
      String branch;
      List<Product> productList = new LinkedList<>();
        
      Statement stmt = conn.createStatement();
      ResultSet result = stmt.executeQuery(query);

      while(result.next()) {
        id = result.getObject("id", UUID.class);
        productName = result.getString("name");
        price = result.getDouble("price");
        branch = result.getString("branch");

        productList.add(new Product(id, productName, price, branch));
      }

      result.close();
      stmt.close();

      req.setAttribute("products", productList);
      req.getRequestDispatcher("products.jsp").forward(req, res);

    } catch (Exception e) {
      System.out.println("unable to get product list!" + e);
    }
    
  }

  
}

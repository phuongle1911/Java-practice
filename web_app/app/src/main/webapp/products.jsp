<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <body>
    <h1>Product List:</h1>
    <ul> 
      <c:forEach var="product" items="${products}">
        <li>Product name: ${product.name}; Price: ${product.price}; Branch: ${product.branch}</li>
      </c:forEach>

    </ul>
  </body>
</html>
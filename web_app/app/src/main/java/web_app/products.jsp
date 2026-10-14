<!DOCTYPE html>
<html>
  <body>
    <h1>Product List:</h1>
    <ul> 
      <c:forEach var="product" items="${productList}">
        <li>Product name: ${product.name}; Price: ${product.price}; Branch: ${product.branch}</li>
      </c:forEach>

    </ul>
  </body>
</html>
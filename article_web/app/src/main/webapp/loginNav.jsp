<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>


<nav>
  <ul>
    <c:choose>
      <c:when test="${not empty username}">
        <li>Hello <c:out value="${username}" /></li>
        <form action="${ctx}/api/logout" method="POST">
          <input type="submit" value="Logout">
        </form>
      </c:when>
      <c:otherwise>
        <li><a href="${ctx}/login.jsp">Login</a></li>
        <li><a href="${ctx}/register.jsp">Register</a></li>
      </c:otherwise>
    </c:choose>
  </ul>
</nav>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>


<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Товары</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div>
  <h2>Товары <br> Только для залогинившихся пользователей.</h2>
</div>
<div>
  <table>
    <thead>
    <th>ID</th>
    <th>ProductName</th>
    <th>Price</th>
    <th>Amount</th>

    </thead>
    <c:forEach items="${allProducts}" var="product">
      <tr>
        <td>${product.id}</td>
        <td>${product.name}</td>
        <td>${product.price}</td>
        <td>${product.amount}</td>


        <td>

        </td>
        <td>
          <form action="${pageContext.request.contextPath}/products" method="get">
            <input type="hidden" name="productId" value="${pruduct.id}"/>
            <input type="hidden" name="action" value="add"/>
            <button type="submit">Add</button>
          </form>

        </td>

      </tr>
    </c:forEach>
  </table>
  <a href="/">Главная</a>
</div>

</body>
</html>
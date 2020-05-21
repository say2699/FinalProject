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
    <h2>Корзина <br> Только для залогинившихся пользователей.</h2>
</div>
<div>
    <table>
        <thead>
        <th>ID</th>
        <th>ProductName</th>
        <th>Price</th>
        <th>Amount</th>

        </thead>
        <c:forEach items="${allBasket}" var="basket">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getAmount()}</td>

                <td>
                    <a href="/user/add/">Add</a>
                </td>


            </tr>
        </c:forEach>
    </table>
    <a href="/">Главная</a>
</div>

</body>
</html>
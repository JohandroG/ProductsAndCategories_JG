<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <main style="margin: 30px; border: 2px solid black; border-radius: 10px; padding: 20px; width: 40%;">
        <a class="btn btn-primary" href="/category/new">Or go to category</a>
        <h1>
            New Product
        </h1>
        <form method="POST" action="/product/insert">
            <div style="margin-top: 10px;margin-bottom: 10px;">
                <label style="margin-right: 7px;" for="name">Name:</label>
                <input type="text" name="name">
            </div>
            <div style="margin-top: 10px;margin-bottom: 10px; display: flex; flex-direction: row; align-items: center;">
                <label style="margin-right: 7px;" for="desc">Description:</label>
                <textarea name="desc"></textarea>
            </div>
            <div style="margin-top: 10px;margin-bottom: 10px;">
                <label  style="margin-right: 7px;" for="price">Price:</label>
                <input  type="text" name="price">
            </div>
            <button class="btn btn-success" style="margin-top: 10px;margin-bottom: 10px;" type="submit">
                Create
            </button>
        </form>
        <div>
            
            <ul class="list-group" style="width: 50%; margin-top: 30px;">
                <li class="list-group-item active">Products:</li>
                <c:forEach var = "product" items = "${prodInfo}">
                <li class="list-group-item">
                    <a href="/add/pro/${product.getProduct_id()}"><c:out value = "${product.getName()}" ></c:out></a>
                </li>
                </c:forEach>
            </ul>
        </div>
    </main>
</body>
</html>
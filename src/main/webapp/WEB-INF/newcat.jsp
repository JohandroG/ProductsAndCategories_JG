<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <main style="margin: 30px; border: 2px solid black; border-radius: 10px; padding: 20px; width: 40%;">
        <a style="margin-bottom: 30px;" class="btn btn-primary" href="/product/new">Or go to products</a>
        <h1>
            New Category
        </h1>
        <form method="POST" action="/category/insert">
            <div style="margin-top: 10px;margin-bottom: 10px;">
                <label for="name">Name:</label>
                <input type="text" name="name">
            </div>
            <button  class="btn btn-success" style="margin-top: 10px;margin-bottom: 10px;"" type="submit">
                Create
            </button>
        </form>
        <div>
            
            <ul class="list-group" style="width: 50%; margin-top: 30px;">
                <li class="list-group-item active">Categories:</li>
                <c:forEach var = "category" items = "${CatInfo}">
                <li class="list-group-item">
                    <a href="/add/cat/${category.getCategory_id()}"><c:out value = "${category.getCategory()}" ></c:out></a>
                </li>
                </c:forEach>
            </ul>
        </div>
    </main>
</body>
</html>
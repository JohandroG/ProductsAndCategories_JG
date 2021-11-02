<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Include Category</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
    <main style="margin: 30px; border: 2px solid black; border-radius: 10px; padding: 20px; width: 40%;">
        <a style="margin-bottom: 30px;" class="btn btn-danger" href="/category/new">Go back</a>
        <h1 style="margin-bottom: 20px;"><c:out value = "${current.getCategory()}" ></c:out></h1>
        <div style="display: flex; flex-direction: row; align-items: center; justify-content: space-between;">
            <div>
                
                <ul class="list-group" style="width: 170%;">
                    <li class="list-group-item active">Products:</li>
                <c:forEach var = "product" items = "${current.getProducts()}">
                <li class="list-group-item"><c:out value = "${product.getName()}" ></c:out></li>
                </c:forEach>
                </ul>
            </div>
            <div>
                <form style="display: flex; flex-direction: column; align-items: center;" method="POST" action="/add/new/pro/${current.getCategory_id()}">
                    <label style="margin-bottom: 15px; font-size: 20px;" for="prod">Add Product:</label>
                    <select name="prod">
                        <c:forEach var = "product" items = "${ProList}">
                            <option value="${product.getProduct_id()}"><c:out value = "${product.getName()}" ></c:out></option>
                        </c:forEach>
                    </select>
                <button style="margin-top: 25px;" class="btn btn-info" type="submit">Add</button>
                </form>
                
            </div>
        </div>
    </main>
</body>
</html>
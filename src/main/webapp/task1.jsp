<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task1</title>
</head>
<body>
<table>
<h2>Products and their Suppliers</h2>

<div>
    <thead>
    <tr>
        <th>Product</th>
        <th>Company</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="taskResult" items="${taskResults}">
        <tr>
            <td>${taskResult.companyName}</td>
            <td>${taskResult.productName}</td>
        </tr>
    </c:forEach>
    </tbody>

    <form action="filtered" method="get">

            You can filter your results by typing a (part of a) word from product:<br>
            <input type="text" id="filter" name="filter" placeholder="Please enter your filter"><br><br>
            <input type="submit" value="FILTER"><br><br>
    </form>

    <!-- str1.toLowerCase().contains(str2.toLowerCase()) -->
</div>
</body>
</html>

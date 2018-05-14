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
<h2>This is the first taskresult</h2>

<div>
<table>
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
</div>
</body>
</html>

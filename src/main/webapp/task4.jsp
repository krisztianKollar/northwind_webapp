<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Task4</title>
</head>
<body>
<h2>All Customers and their orders (if any)</h2>

<div>
<table>
    <thead>
    <tr>
        <th>Company</th>
        <th>Order IDs</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="taskResult" items="${taskResults}">
        <tr>
            <td>${taskResult.companyName}</td>
            <td>${taskResult.orderIds}</td>
        </tr>
    </c:forEach>
    <a href="index.jsp">You can go back to the first page clicking here</a><br><br><br>
            </tbody>

            <form action="task4" method="post">

                    You can filter your results by typing a (part of a) word from Company:<br>
                    <input type="text" id="filter" name="filter" placeholder="Please enter your filter"><br><br>
                    <input type="submit" value="FILTER"><br><br>
            </form>
            <form action="task4" method="get">
                    <input type="submit" value="BACK"><br><br>
            </form>
</div>
</body>
</html>

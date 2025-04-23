<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register User</title>
</head>
<body align="center">
	<h1>Search Flight</h1>
	<form action="searchFlight" method="post">
		From: <input type="text" name="from"><br>
		<br>To: <input type="text" name="to"><br>
		<br>Date: <input type="text" name="date"><br>
		<br><input type="submit" value="Search"><br>
	</form>
	<br>
	<a href = "booking-details.jsp">Your Bookings</a>
</body>
</html>
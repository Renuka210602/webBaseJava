<%@page import="com.airline.dao.BookingDao"%>
<%@page import="com.airline.entity.Booking"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Bookings</title>
</head>
<body align="center">
	<%
       List<Booking> bookings =(List<Booking>)request.getAttribute("bookings");
		 for(Booking booking:bookings) 
		 {
		%>
		<h1>
			ID: <%= booking.getId() %> 
			Flight ID: <%= booking.getFlightId() %> 
			User ID: <%= booking.getUserId() %> 
			Booking Date: <%= booking.getBookingDate() %>
		</h1>
		<form action="cancleBooking" method="post">
		<input type="hidden" name="bookingId" value=<%= booking.getId() %>> 
		<button>Cancle</button>
		</form>
	<% } %>
</body>
</html>

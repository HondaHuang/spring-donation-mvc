<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Donors</title>
</head>
<body>
	<h1>List Donors</h1>
	<h3>
		<a href="add.html">Add More Donors</a>
	</h3>

	<c:if test="${!empty donors}">
		<table align="left" border="1">
			<tr>
				<th>Donor ID</th>
				<th>Donor Name</th>
				<th>Donor Address</th>
				<th>Donor Contact</th>
				<th>Donated Amount</th>
				<th>Donate Date</th>
			</tr>

			<c:forEach items="${donors}" var="donor">
				<tr>
					<td><c:out value="${donor.id}" /></td>
					<td><c:out value="${donor.name}" /></td>
					<td><c:out value="${donor.address}" /></td>
					<td><c:out value="${donor.contact}" /></td>
					<td><c:out value="${donor.donatedamt}" /></td>
					<td><c:out value="${donor.donatedate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
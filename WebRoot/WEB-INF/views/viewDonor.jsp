<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Enter Donation ID</h2>
	<form:form method="POST" action="/springmvc_donation/search.html">
		<table>
			<tr>
				<td><form:label path="id">Donor ID:</form:label></td>
				<td><form:input path="id" value="${donor.id}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	<c:if test="${donor != null}">
		<h2>Donor Information</h2>
		<table align="left" border="1">
			<tr>
				<th>Donor ID</th>
				<th>Donor Name</th>
				<th>Donor Address</th>
				<th>Donor Contact</th>
				<th>Donated Amount</th>
				<th>Donate Date</th>
			</tr>

			<tr>
				<td><c:out value="${donor.id}" /></td>
				<td><c:out value="${donor.name}" /></td>
				<td><c:out value="${donor.address}" /></td>
				<td><c:out value="${donor.contact}" /></td>
				<td><c:out value="${donor.donatedamt}" /></td>
				<td><c:out value="${donor.donatedate}" /></td>
			</tr>
		</table>
	</c:if>
</body>
</html>
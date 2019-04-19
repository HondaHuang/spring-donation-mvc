<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Add Donor Data</h2>
	<form:form method="POST" action="/springmvc_donation/save.html">
		<table>
			<tr>
				<td><form:label path="id">Donor ID:</form:label></td>
				<td><form:input path="id" value="${donor.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Donor Name:</form:label></td>
				<td><form:input path="name" value="${donor.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="address">Donor Address:</form:label></td>
				<td><form:input path="address" value="${donor.address}" /></td>
			</tr>
			<tr>
				<td><form:label path="contact">Donor Contact:</form:label></td>
				<td><form:input path="contact" value="${donor.contact}" /></td>
			</tr>
			<tr>
				<td><form:label path="donatedamt">Donated Amount:</form:label></td>
				<td><form:input path="donatedamt" value="${donor.donatedamt}" /></td>
			</tr>
			<tr>
				<td><form:label path="donatedate">Donate Date:</form:label></td>
				<td><form:input path="donatedate" value="${donor.donatedate}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

		<h2>List Donors</h2>
		<table align="left" border="1">
			<tr>
				<th>Donor ID</th>
				<th>Donor Name</th>
				<th>Donor Address</th>
				<th>Donor Contact</th>
				<th>Donated Amount</th>
				<th>Donate Date</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${donors}" var="donor">
				<tr>
					<td><c:out value="${donor.id}" /></td>
					<td><c:out value="${donor.name}" /></td>
					<td><c:out value="${donor.address}" /></td>
					<td><c:out value="${donor.contact}" /></td>
					<td><c:out value="${donor.donatedamt}" /></td>
					<td><c:out value="${donor.donatedate}" /></td>
					<td align="center"><a href="edit.html?id=${donor.id}">Edit</a>
						| <a href="delete.html?id=${donor.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>
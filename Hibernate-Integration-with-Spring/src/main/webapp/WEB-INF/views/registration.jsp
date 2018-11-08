<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form:form action="studentRegister" commandName="studentFormRegister"
		modelAttribute="studentFormRegister" method="POST">
		<br>


		<br>
		<form:label path="name">Enter Name</form:label>
		<form:input path="name" />

		<br>
		<form:label path="mobile">Enter Mobile</form:label>
		<form:input path="mobile" />

		<br>
		<form:label path="address">Enter Address</form:label>
		<form:input path="address" />

		<br>
		<form:label path="username">Enter User Name</form:label>
		<form:input path="username" />

		<br>
		<form:label path="password">Enter Password</form:label>
		<form:input path="password" type="password" />

		<br>
		<input type="submit" value="submit">

	</form:form>


	<c:if test="${not empty success}">
		<h4>${success}</h4>
	</c:if>
	<c:if test="${not empty error}">
	<h4>${error}</h4>
	</c:if>
	
	<table>

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Address</th>
			<th>Mobile</th>
			<th>User name</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${list}" var="student">
			<%-- items must be in ${} --%>
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.address}</td>
				<td>${student.mobile}</td>
				<td>${student.username}</td>
				<td><a href="editStudent?id=${student.id}">Edit</a> 
				<a href="deleteStudent?id=${student.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
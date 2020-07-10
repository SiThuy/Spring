<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" modelAttribute="obj" cssClass="form">
		<p>

			<label>Name</label>
			<form:input path="name" />
		</p>
		<p>
			<label>Parent</label>
			<form:select path="parent">
				<form:option value="">--Select Parent--</form:option>
				<form:options items="${map}" />
			</form:select>
		</p>
		<p>
			<button>Save</button>
		</p>
	</form:form>
</body>
</html>
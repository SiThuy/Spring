<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
			<button class="btn btn-primary">Save</button>
		</p>
	</form:form>

</body>
</html>
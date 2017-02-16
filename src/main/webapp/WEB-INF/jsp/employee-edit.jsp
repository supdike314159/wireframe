<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit Employee page</title>
</head>
<body>
<h1>Edit Employee page</h1>
<form:form method="POST" commandName="employee" action="${pageContext.request.contextPath}/employee/edit/${employee.id}">
<table>
<tbody>
<tr>
<td>First Name:</td>
<td><form:input path="firstName" /></td>
<td><form:errors path="firstName" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Last Name:</td>
<td><form:input path="lastName" /></td>
<td><form:errors path="lastName" cssStyle="color: red;"/></td>
</tr>
<tr>
<td>Status:</td>
<td><form:input path="status" /></td>
<td><form:errors path="status" cssStyle="color: red;"/></td>
</tr>

<tr>
<td><input type="submit" value="Edit" /></td>
<td></td>
<td></td>
</tr>
</tbody>
</table>
</form:form>
<a href="${pageContext.request.contextPath}/">Home page</a>
</body>
</html>
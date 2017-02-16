<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Employee List page</title>
</head>
<body>
<h1>Employee List page</h1>
<table style="text-align: center;" border="1px" cellpadding="0" cellspacing="0" >
<thead>
<tr>
<th width="150px">Name</th><th width="25px">Status</th><th width="25px">Birth Date</th><th width="50px">actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="employee" items="${employeeList}">
<tr>
<td>${employee.firstName} ${employee.lastName} </td>
<td>${employee.status}</td>
<td>${employee.birthDate}</td>
<td>
<a href="${pageContext.request.contextPath}/employee/edit/${employee.id}">Edit</a><br/>
<a href="${pageContext.request.contextPath}/employee/delete/${employee.id}">Delete</a><br/>
</td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="${pageContext.request.contextPath}/employee/create">New Employee</a>
</body>
</html>
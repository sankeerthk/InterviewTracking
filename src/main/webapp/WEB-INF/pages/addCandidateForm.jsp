<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ page isELIgnored="false" %>
<style>
body {
	background-color: lightblue;
}

#divname {
	height: 700px;
	width: 600px;
	position: fixed;
	top: 26%;
	left: 35%;
	margin-top: -100px;
	margin-left: -200px;
	background
	:
	transparent; /* optional: just make scrollbar invisible */
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<center>
	<form class="form-horizontal" method="post" action="<c:url value='/addCandidate'/>" 
		enctype="multipart/form-data">
		<div id="divname">
			<c:if test="${message != null}">
				<c:out value="${message}" />
			</c:if>
			<table>
				<tr>
					<td>*First Name :</td>
					<td><input type="text" class="form-control" id="firstName"
						name="firstName" placeholder="Candidate First Name"></input></td>
				</tr>
				<tr>
					<td>*Last Name :</td>
					<td><input type="text" class="form-control" id="lastName"
						name="lastName" placeholder="Candidate Last Name"></input></td>
				</tr>
				<tr>
					<td>*Email :</td>
					<td><input type="email" class="form-control" id="email"
						name="email" placeholder="Candidate Email"></input></td>
				</tr>
				<tr>
					<td>*Resume :</td>
					<td><input type="file" name="resume" id="resume"></input></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Add Candidate" /></td>
				</tr>
			</table>
		</div>
		</form>
	</center>
</body>
</html>
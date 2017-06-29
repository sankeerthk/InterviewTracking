<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Interview Tracking</title>
</head>
<body>
	<center>
		<div id="divname">
			<table>
				<tr>
					<th>
						<form action="<c:url value='/addCandidate'/>" method="get">
							<input type="submit" value="Add Candidate">
						</form>
					</th>
					<th>
						<form action="<c:url value='/listOfCandidates'/>" method="get">
							<input type="submit" value="Show Candidates">

						</form>
					</th>
				</tr>
				<tr>
					<th><c:if test="${message != null}">
							<c:out value="${message}" />
						</c:if></th>
				</tr>
			</table>
		</div>
	</center>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<%@ page isELIgnored="false" %>
<style>
body {
	background-color: lightblue;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}
</style>
<title>List Of Candidates</title>
</head>
<body>
<c:out value="${can}"></c:out> 
	<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email ID</th>
				<th>Action</th>


			</tr>
			 <c:forEach var="candidate" items="${candidates}" >
				<tr>
					<td><c:out value="${candidate.firstName}" /></td>
					<td><c:out value="${candidate.lastName}" /></td>
					<td><c:out value="${candidate.email}" /></td>
					<td><spring:url
							value="/updateCandidate/${candidate.candidateId}/addInterview"
							var="userUrl" /> <spring:url
							value="/updateCandidate/${candidate.candidateId}/delete"
							var="deleteUrl" /> <spring:url
							value="/updateCandidate/${candidate.candidateId}/addFeedback"
							var="updateUrl" />

						<button class="btn btn-info" onclick="location.href='${userUrl}'">Add
							Interview</button>
						<button class="btn btn-primary"
							onclick="location.href='${updateUrl}'">Feedback</button>
						<button class="btn btn-danger"
							onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
						
				</tr>
			</c:forEach>	
		</table>
	
</body>
</html>
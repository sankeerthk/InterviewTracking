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
<title>Insert title here</title>
</head>
<body>
	<center>
		<form class="form-horizontal" method="post"
			action="<c:url value='/updateCandidate/${candidate.candidateId}/addFeedback'/>">
			<div id="divname">
				<table>
					<tr>
						<td>First Name :</td>
						<td>${candidate.firstName}</td>
					</tr>
					<br />
					<br />
					<tr>
						<td>Last Name :</td>
						<td>
						<td>${candidate.lastName}</td>
					</tr>
					<br />
					<br />
					<tr>
						<td>MailId :</td>
						<td>${candidate.email}</td>
					</tr>
					<br>

					<tr>
						<td>Feedback:</td>
						<td><textarea id="feedback" name="feedback" rows="3"
								cols="80" placeholder="Enter Feedback here"></textarea></td>
					</tr>
					<br>
					<br>
					<tr>
						<td></td>
						<td><input type="submit" value="Save" /></td>
					</tr>
				</table>
			</div>
		</form>
	</center>
</body>
</html>
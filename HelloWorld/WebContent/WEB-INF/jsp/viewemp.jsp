<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Points</th>
	</tr>
	<c:forEach var="user" items="${list}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.points}</td>
		</tr>
	</c:forEach>
</table>

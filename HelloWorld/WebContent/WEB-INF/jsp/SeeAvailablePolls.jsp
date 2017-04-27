<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Hi ${name} Here are the polls:</p>

<c:forEach var="poll" items="${pollList}">
	<a href="poll?pollId=${poll.pollId}&name=${name}">${poll.pollTitle}</a>
	<br>
	<%-- <a href="poll?pollId=<%=poll.pollId%>">${poll.pollTitle}</a></br> --%>
</c:forEach>

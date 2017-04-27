<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Hi ${name}! Here are your polls:</p>

<c:forEach var="poll" items="${pollList}">
	<a href="pollResults?pollId=${poll.pollId}&name=${name}">${poll.pollTitle}</a>
	<br>
</c:forEach>
<br>
<%-- <a href="CreateANewPoll?name=${name}">Create a new Poll</a> --%>

<form action="CreateANewPoll" method="post">
	<input type="submit" value = "Create a new Poll"/> 
	<input type="hidden" name="name" value="${name}" /> 
<%-- 	<input type="hidden" name="pollId" value="${poll.pollId}" /> --%>
</form>
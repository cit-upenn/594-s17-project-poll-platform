<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Hi ${name}</p>
<p>Here is ${poll.getPollTitle()}:</p>
<p>${poll.pollContent}:</p>
<p>${poll.tag}</p>
<form action="submitRating" method="post">
<input type="radio" name="rating" value="1"> 1
<input type="radio" name="rating" value="2"> 2
<input type="radio" name="rating" value="3"> 3
<input type="radio" name="rating" value="4"> 4
<input type="radio" name="rating" value="5"> 5
	<input type="submit"/>	
	<input type="hidden" name = "user" value="${name}" />
	<input type="hidden" name = "pollId" value="${poll.pollId}" />
</form>


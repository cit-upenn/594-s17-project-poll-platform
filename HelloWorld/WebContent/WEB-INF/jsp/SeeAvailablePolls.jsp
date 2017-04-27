<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<p>Hi ${name}! Here are the polls:</p>

<form action="category" method="post">
<input type="submit" name ="tag" value="business">	
<input type="submit" name ="tag" value="science">
<input type="submit" name ="tag" value="health">
<input type="submit" name ="tag" value="sports">
<input type="submit" name ="tag" value="arts">
<input type="submit" name ="tag" value="entertainment">
<input type="submit" name ="tag" value="life">
<input type="submit" name ="tag" value="others">	
<input type="hidden" name="name" value="${name}" />						
</form>

<c:forEach var="poll" items="${pollList}">
	<a href="poll?pollId=${poll.pollId}&name=${name}">${poll.pollTitle}</a>
	<br>
</c:forEach>

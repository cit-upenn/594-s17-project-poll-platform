<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Hi ${user.name}!</p>
<p>Create a poll here:</p>
<form action="createpoll?name=${user.name}" method="post">
	<p>Please enter your poll name: </p>
	<input type="text" name="pollTitle" />
	<p>Please enter your question: </p>
	<input type="text" name="content" />
	</br>
	<input type="submit" value="create"/>
	
</form>
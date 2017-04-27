<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Welcome! Please sign up here:</p>
<p>${message}</p>

<form action="signup" method="post">
	<p>Please enter your user name: </p>
	<input type="text" name="name" />
	<p>Please enter your password: </p>
	<input type="password" name="password" />
	<br>
	<input type="submit"/>	
</form>




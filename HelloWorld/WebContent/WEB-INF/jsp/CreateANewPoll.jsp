<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Hi ${name}!</p>
<p>Create a poll here:</p>

<form action="createpoll?name=${name}" method="post">
	<p>Please enter your poll name: </p>
	<input type="text" name="pollTitle" />
	<p>Please enter your question: </p>
	<input type="text" name="content" />
	<p>Please choose the tag: </p>
	<input type="checkbox" name ="tag" value="business">business	
	<input type="checkbox" name ="tag" value="science">science
	<input type="checkbox" name ="tag" value="health">health
	<input type="checkbox" name ="tag" value="sports">sports
	<input type="checkbox" name ="tag" value="arts">arts
	<input type="checkbox" name ="tag" value="entertainment">entertainment
	<input type="checkbox" name ="tag" value="life">life
	<input type="checkbox" name ="tag" value="others">others
	<br>	
	<input type="submit" value ="create"/>
</form>
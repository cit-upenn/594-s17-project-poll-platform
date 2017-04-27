<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<p>Hi ${user.name}!</p>
<a href="CreateANewPoll?name=${user.name}">Create a new Poll</a>
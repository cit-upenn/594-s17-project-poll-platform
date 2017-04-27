<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="signin" method="post">
	Name:<input type="text" name="name" />
	<br /> 
	Password:<input type="password" name="password" />
	<br /> 
	<input type="submit" value="Login" />
</form>

<p>${message}</p>
<a href="SignUpForm.html">Don't have an account? Sign up here! </a>



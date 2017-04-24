<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form:form method="post" action="save">
	<table>
		<tr>
			<td>UserName :</td>
			<td><form:input path="name" type="text" /></td>
		</tr>
		<tr>
			<td>Passwords :</td>
			<td><form:input path="password" type="password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Sign In" /></td>
		</tr>
	</table>
</form:form>

<p>${message}</p>  
<a href="SignUpForm.html">Don't have an account? Sign up here! </a>



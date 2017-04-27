
<p>Welcome ${user.name}!</p>
<p>${message}</p>
<table border="2" width="70%" cellpadding="2">
	<tr>
		<th>Your Name</th>
		<th>Your Password</th>
		<th>Your Current Points</th>
	</tr>

	<tr>
		<td>${user.name}</td>
		<td>${user.password}</td>
		<td>${user.points}</td>
	</tr>

</table>

<a href="SeeMyPolls?name=${user.name}">See my polls</a>

<%--<form a ction="hiddenTest" >
	<input type="hidden" name = "user" value="${user.name}" />,
	<input type="hidden" name = "pass" value="${user.password}" />,
	<input type="submit" value="SeeMyPolls" />
</form> --%>

<br>
<a href="SeeAvailablePolls?name=${user.name}">See avaliable polls</a>
